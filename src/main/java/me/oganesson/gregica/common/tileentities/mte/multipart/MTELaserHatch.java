package me.oganesson.gregica.common.tileentities.mte.multipart;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.handler.BlockPosHighlightRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.PipelineUtil;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;
import me.oganesson.gregica.api.GCValues;
import me.oganesson.gregica.api.capability.impl.EnergyContainerLaser;
import me.oganesson.gregica.api.mte.HatchType;
import me.oganesson.gregica.api.mte.INoticeable;
import me.oganesson.gregica.common.tileentities.te.TELaserPipe;
import me.oganesson.gregica.utils.GCColorUtil;
import me.oganesson.gregica.utils.GCMathUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MTELaserHatch extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IEnergyContainer>, IDataInfoProvider, INoticeable {
    
    public static final String COLOR_KEY = "LaserColor";
    public static final String UP_KEY = "needUpdate";
    public static final String POS_KEY = "targetPos";
    
    private final IEnergyContainer energyContainer;
    private final HatchType type;
    private final int amperage;
    
    private final long maxIO;
    
    private int color;
    
    private boolean needUpdateImm;
    
    private BlockPos target;
    
    
    public MTELaserHatch(ResourceLocation metaTileEntityId, int tier, int amperage, HatchType type) {
        super(metaTileEntityId, tier);
        this.type = type;
        this.amperage = amperage;
        this.maxIO = GTValues.V[tier]*amperage;
        this.energyContainer = type == HatchType.INPUT ? EnergyContainerLaser.input(this,GTValues.V[tier],amperage)
                : EnergyContainerLaser.output(this,GTValues.V[tier],amperage);
    }
    
    @Override
    public void update() {
        super.update();
        if(!this.getWorld().isRemote && this.type == HatchType.OUTPUT){
            
            if(needUpdateImm){
                updateTarget();
                needUpdateImm = false;
            }
            else if(getOffsetTimer() % 100 == 0){
                updateTarget();
            }
            
            if(this.target != null && getOffsetTimer() % 5 == 0){
                MetaTileEntity mte = GTUtility.getMetaTileEntity(getWorld(),target);
                if(mte instanceof MTELaserHatch) {
                    IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, this.getFrontFacing().getOpposite());
                    long canOutput = container.getEnergyCanBeInserted();
                    canOutput = GCMathUtils.min(canOutput, energyContainer.getEnergyStored(),maxIO);
                    int tier = this.getTier() - ((MTELaserHatch) mte).getTier();
                    if(tier > 0){
                        //this.doExplosion(this.getTier()*1.5F);
                        mte.doExplosion(this.getTier()*1.5F);
                        return;
                    }
                    energyContainer.removeEnergy(canOutput);
                    container.addEnergy(canOutput);
                }
            }
        }
      
    }
    
    public void updateTarget(){
        if(this.color != -1){
            
            World world = getWorld();
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(this.getPos()).move(this.getFrontFacing());
            if(this.target != null){
                BlockPos self = this.getPos();
                int distance = (int) target.getDistance(self.getX(),self.getY(),self.getZ());
                for(int i=0;i<distance;i++){
                    if(!world.isBlockLoaded(pos) || isConnectedLaserPipe(world,pos) || isTarget(world,pos)){
                        pos = pos.move(this.getFrontFacing());
                    }
                    else {
                        target = null;
                        return;
                    }
                }
            }
            else {
                while (isConnectedLaserPipe(world,pos)){
                    pos = pos.move(this.getFrontFacing());
                }
                if(isTarget(world,pos)){
                    this.target = pos.toImmutable();
                }
            }
         
        }
       
    }
    
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (this.shouldRenderOverlay()) {
            Textures.ENERGY_IN_HI.renderSided(this.getFrontFacing(), renderState, translation, PipelineUtil.color(pipeline, GTValues.VC[this.getTier()]));
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        NBTTagCompound result = super.writeToNBT(data);
        result.setInteger(COLOR_KEY,color);
        result.setBoolean(UP_KEY,needUpdateImm);
        if(target != null) {
            result.setIntArray(POS_KEY, new int[]{target.getX(), target.getY(), target.getZ()});
        }
        return result;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.color = data.getInteger(COLOR_KEY);
        this.needUpdateImm = data.getBoolean(UP_KEY);
        if(data.hasKey(POS_KEY)){
            int[] pos = data.getIntArray(POS_KEY);
            this.target = new BlockPos(pos[0],pos[1],pos[2]);
        }
    }
    
    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(color);
    }
    
    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.color = buf.readInt();
    }
    
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTELaserHatch(this.metaTileEntityId, this.getTier(), this.amperage,this.type);
    }
    
    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }
    
    @Override
    protected boolean openGUIOnRightClick() {
        return false;
    }
    
    @Override
    public MultiblockAbility<IEnergyContainer> getAbility() {
        return this.type == HatchType.INPUT ? MultiblockAbility.INPUT_ENERGY : MultiblockAbility.OUTPUT_ENERGY;
    }
    
    @Override
    public void registerAbilities(List<IEnergyContainer> list) {
        list.add(this.energyContainer);
    }
    
    public int getColor() {
        return color;
    }
    
    public void setColor(int color) {
        this.color = color;
        this.writeCustomData(GCValues.REQUIRE_DATA_UPDATE,(b) -> b.writeInt(color));
    }
    
    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if(dataId == GCValues.REQUIRE_DATA_UPDATE){
            this.color = buf.readInt();
        }
    }
    
    @NotNull
    @Override
    public List<ITextComponent> getDataInfo() {
        List<ITextComponent> result = new ArrayList<>(1);
        result.add(new TextComponentTranslation("gregica.laser.color",color)
                .appendSibling(new TextComponentTranslation(GCColorUtil.StandardColor.getFromInt(color).getI18NKey())));
        if(this.type == HatchType.OUTPUT && this.target != null){
            result.add(new TextComponentString("target: x:"+target.getX()+" y:"+target.getY()+" z:"+target.getZ()));
            BlockPosHighlightRenderer.renderBlockBoxHighLight(target,10000);
        }
        
        return result;
    }
    
    @Override
    public void notice(IBlockAccess world, BlockPos pos) {
        //MetaTileEntity mte = GTUtility.getMetaTileEntity(world,pos);
        if(this.type == HatchType.OUTPUT) this.needUpdateImm = true;
    }
    
    @Override
    public boolean isNoticed() {
        return false;
    }
    
    public boolean isConnectedLaserPipe(World world ,BlockPos pos){
        TileEntity te = world.getTileEntity(pos);
        if(te instanceof TELaserPipe){
            return ((TELaserPipe) te).getColor() == this.color;
        }
        return false;
    }
    
    public boolean isTarget(World world,BlockPos pos){
        MetaTileEntity mte = GTUtility.getMetaTileEntity(world,pos);
        if(mte instanceof MTELaserHatch){
            return ((MTELaserHatch) mte).type == HatchType.INPUT;
        }
        return false;
    }
}
