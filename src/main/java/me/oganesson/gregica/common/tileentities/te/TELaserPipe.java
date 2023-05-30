package me.oganesson.gregica.common.tileentities.te;

import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.util.GTUtility;
import mcp.MethodsReturnNonnullByDefault;
import me.oganesson.gregica.api.blocks.IColored;
import me.oganesson.gregica.api.capability.GCCapabilities;
import me.oganesson.gregica.api.mte.INoticeable;
import me.oganesson.gregica.common.block.te.LaserVacuumPipeBlock;
import me.oganesson.gregica.common.tileentities.mte.multipart.MTELaserHatch;
import me.oganesson.gregica.utils.GCColorUtil;
import me.oganesson.gregica.utils.GCUtil;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TELaserPipe extends TileEntity implements INoticeable, IDataInfoProvider, IColored {
    
    public static final String COLOR_KEY = "color";
    public static final String CONNECTION_KEY = "connections";
    public static final String STATE_KEY = "state";
    
    private final BitSet connections = new BitSet(6);
    private int color = -1;
    private boolean noticed = false;
    private boolean updated = false;
    
    private boolean state = false;
    
    public void updateConnections(IBlockAccess world, BlockPos pos,boolean needNotice){
        if(updated) return;
        this.updated = true;
        if(this.color != -1){
            boolean changed = false;
            for(EnumFacing facing : EnumFacing.VALUES){
                BlockPos testPos = pos.offset(facing);
                int index = facing.getIndex();
                
                TileEntity te = world.getTileEntity(testPos);
                MetaTileEntity mte = GTUtility.getMetaTileEntity(world,testPos);
                if(te instanceof TELaserPipe){
                    
                    TELaserPipe lp = (TELaserPipe) te;
                    if(lp.getColor() == this.color && !connections.get(index)){
                        this.connections.set(index);
                        lp.updateConnections(world,testPos,false);
                        changed = true;
                    }
                    if(lp.getColor() != this.color && connections.get(index)){
                        this.connections.clear(index);
                        lp.updateConnections(world,testPos,false);
                        changed = true;
                    }
                }
                else if(mte instanceof MTELaserHatch){
                    int hatchColor = ((MTELaserHatch) mte).getColor();
                    if(hatchColor == this.color && !connections.get(index)){
                        this.connections.set(index);
                        ((MTELaserHatch) mte).notice(world,testPos);
                        changed = true;
                    }
                    if(hatchColor != this.color && connections.get(index)){
                        this.connections.clear(index);
                        ((MTELaserHatch) mte).notice(world,testPos);
                        changed = true;
                    }
                }
                else {
                    if(connections.get(index)){
                        this.connections.clear(index);
                        changed = true;
                    }
                }
            }
            if(changed){
                if(needNotice) this.notice(world,pos);
                IBlockState state1 = world.getBlockState(pos);
                this.world.notifyBlockUpdate(pos,state1,state1,0);
                this.markDirty();
                this.updateRendering();
            }
        }
        else if(this.getConnectionsAsInt() != 0){
            for(EnumFacing facing : EnumFacing.VALUES){
                if(connections.get(facing.getIndex())){
                    BlockPos testPos = pos.offset(facing);
                    TileEntity te = world.getTileEntity(testPos);
                    if(te instanceof TELaserPipe){
                        ((TELaserPipe) te).updateConnections(world,testPos,false);
//                        GCNetworkManager.INSTANCE.sendPacketToAll(
//                                new UpdateConnectionsClient(testPos,((TELaserPipe) te).getConnectionsAsInt()));
                    }
                }
            }
            connections.clear();
            if(needNotice) this.notice(world,pos);
            IBlockState state1 = world.getBlockState(pos);
            this.world.notifyBlockUpdate(pos,state1,state1,0);
            this.markDirty();
            this.updateRendering();
//            GCNetworkManager.INSTANCE.sendPacketToAll(
//                    new UpdateConnectionsClient(this.pos,getConnectionsAsInt()));
        }
        this.updated = false;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.color = tag.getInteger(COLOR_KEY);
        GCUtil.forIntToBitSet(tag.getInteger(CONNECTION_KEY),6,connections);
        this.state = tag.getBoolean(STATE_KEY);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        NBTTagCompound nbt = pkt.getNbtCompound();
        readFromNBT(nbt);
        this.updateRendering();
    }
    
//    @Override
//    public void writeInitialSyncData(PacketBuffer packetBuffer) {
//        packetBuffer.writeInt(color);
//        packetBuffer.writeInt(getConnectionsAsInt());
//        packetBuffer.writeBoolean(state);
//    }
//
//    @Override
//    public void receiveInitialSyncData(PacketBuffer packetBuffer) {
//        this.color = packetBuffer.readInt();
//        GCUtil.forIntToBitSet(packetBuffer.readInt(),6,connections);
//        this.state = packetBuffer.readBoolean();
//    }
//
//    @Override
//    public void receiveCustomData(int i, PacketBuffer packetBuffer) {
//        if(i == GregtechDataCodes.UPDATE_CONNECTIONS && this.world.isRemote){
//            this.updateRendering();
//        }
//    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);
        return new SPacketUpdateTileEntity(this.getPos(), 0, nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagCompound result = super.writeToNBT(compound);
        result.setInteger(COLOR_KEY,color);
        result.setInteger(CONNECTION_KEY,getConnectionsAsInt());
        result.setBoolean(STATE_KEY,state);
        return result;
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound result = super.getUpdateTag();
        result.setInteger(COLOR_KEY,color);
        result.setInteger(CONNECTION_KEY,getConnectionsAsInt());
        result.setBoolean(STATE_KEY,state);
        return result;
    }
    
    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        super.handleUpdateTag(tag);
        this.color = tag.getInteger(COLOR_KEY);
        GCUtil.forIntToBitSet(tag.getInteger(CONNECTION_KEY),6,connections);
        this.state = tag.getBoolean(STATE_KEY);
    }
    
    public int getColor() {
        return color;
    }
    
    public void setColor(int color) {
        this.color = color;
        IBlockState state1 = world.getBlockState(pos);
        this.world.notifyBlockUpdate(pos,state1,state1,0);
        this.markDirty();
        this.updateRendering();
    }
    
    public BitSet getConnections() {
        return connections;
    }
    
    public int getConnectionsAsInt(){
        return GCUtil.intValueOfBitSet(connections);
    }
    
    public void setConnections(int i){
        GCUtil.forIntToBitSet(i,6,connections);
    }
    
    public boolean isState() {
        return state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    
    @Override
    public void notice(IBlockAccess world, BlockPos pos) {
        if(!this.noticed){
            this.noticed = true;
            for(EnumFacing facing : EnumFacing.VALUES){
                if(connections.get(facing.getIndex())){
                    TileEntity te = world.getTileEntity(pos.offset(facing));
                    if(te instanceof INoticeable){
                        if( ((INoticeable) te).isNoticed()){
                            ((INoticeable) te).notice(world,pos);
                            continue;
                        }
                    }
                    MetaTileEntity mte = GTUtility.getMetaTileEntity(world,pos);
                    if(mte instanceof INoticeable){
                        if(((INoticeable) mte).isNoticed()){
                            ((INoticeable) mte).notice(world,pos);
                        }
                    }
                }
            }
        }
        this.noticed = false;
    }
    
    public boolean isConnectedLaserPipe(World world ,BlockPos pos){
        TileEntity te = world.getTileEntity(pos);
        if(te instanceof TELaserPipe){
            return ((TELaserPipe) te).getColor() == this.color;
        }
        return false;
    }
    
    public void updateRendering(){
        BlockPos pos = this.pos;
        this.world.notifyNeighborsOfStateChange(pos,this.blockType,true);
        //if(this.world.isRemote){
            this.world.markBlockRangeForRenderUpdate(pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1,
                    pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
//        }
//        else {
//            this.writeCustomData(GregtechDataCodes.UPDATE_CONNECTIONS,packetBuffer -> {});
//        }
    }
    
    @NotNull
    @Override
    public List<ITextComponent> getDataInfo() {
        List<ITextComponent> result = new LinkedList<>();
        int i = getConnectionsAsInt();
        BitSet c = getConnections();
        result.add(new TextComponentString("connections: " + Integer.toString(i,2)));
        for(int j = 0;j<6;j++){
            String con = EnumFacing.VALUES[j].getName() +
                    ": " +
                    (c.get(j) ? "true" : "false");
            result.add(new TextComponentString(con));
        }
        result.add(new TextComponentString("color: "+this.color)
                .appendSibling(new TextComponentTranslation(GCColorUtil.StandardColor.getFromInt(color).getI18NKey())));
        return result;
    }
    
    public boolean isNoticed() {
        return noticed;
    }
    
    @Override
    public GCColorUtil.StandardColor getStandardColor() {
        return GCColorUtil.StandardColor.getFromInt(color);
    }
    
    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == GCCapabilities.COLOR_CAPABILITY){
            return GCCapabilities.COLOR_CAPABILITY.cast(this);
        }
        return super.getCapability(capability, facing);
    }
    
    public boolean isTransparent(){
        Block self = this.getBlockType();
        if(self instanceof LaserVacuumPipeBlock){
            return ((LaserVacuumPipeBlock) self).isTransparent();
        }
        return false;
    }
}
