package gregica.api.data.impl;

import gregica.api.data.CrossWorldData;
import gregica.common.data.DataCode;
import gregica.common.data.data.ElectricityData;
import gregica.network.GCNetworkManager;
import gregica.network.packets.CWDataUpdatePacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CWElectricityData implements CrossWorldData {
    
    public static final String NAME = "cross_world_electricity_data";
    
    private final Int2ObjectMap<ElectricityData> data = new Int2ObjectOpenHashMap<>();
    private boolean isDirty = false;
    
    public CWElectricityData() {
    }
    
    public boolean scanIsDirty(){
        if(this.isDirty) return true;
        for(var eData : data.values()){
            if(eData.isDirty()) return true;
        }
        return false;
    }
    
    public void createNewChannel(int channel, UUID owner){
        createNewChannel(channel,owner,false);
    }
    
    //服务端客户端均可
    public void createNewChannel(int channel, UUID owner,boolean isReceive){
        data.put(channel,new ElectricityData(channel,BigInteger.ZERO).addOwner(owner));
        markDirty();
        if(!isReceive){
            sentUpdateData(DataCode.CREATE_CHANNEL,byteBuf -> {
                byteBuf.writeInt(channel);
                byteBuf.writeLong(owner.getMostSignificantBits());
                byteBuf.writeLong(owner.getLeastSignificantBits());
            });
        }
    }
    
    public void load(NBTTagCompound tag) {
        if (tag.hasKey("data_list") && tag.hasKey("list_type")) {
            NBTTagList list = tag.getTagList("data_list", tag.getInteger("list_type"));
            
            for(int i = 0; i < list.tagCount(); ++i) {
                NBTTagCompound in = list.getCompoundTagAt(i);
                ElectricityData electricityData = ElectricityData.load(in);
                if (electricityData != null) {
                    this.data.put(electricityData.getChannel(), electricityData);
                }
            }
        }
        
    }
    
    public NBTTagCompound save() {
        NBTTagCompound result = new NBTTagCompound();
        NBTTagList list = new NBTTagList();
    
        for (ElectricityData data1 : this.data.values()) {
            list.appendTag(data1.save());
        }
        
        result.setTag("data_list", list);
        result.setInteger("list_type", list.getTagType());
        return result;
    }
    
    //仅存数据时候使用
    public boolean isDirty() {
        return this.scanIsDirty();
    }
    
    public void markDirty() {
        this.isDirty = true;
    }
    
    public void init() {
    }
    
    @Override
    public void updateData(int id, ByteBuf byteBuf) {
        if(id == DataCode.LOAD_ALL && isClient()){
            var tag = ByteBufUtils.readTag(byteBuf);
            if(tag != null){
                this.load(tag);
            }
        }
        if(id == DataCode.ADD_EU && isClient()){
            this.addEU(byteBuf.readInt(),byteBuf.readLong());
        }
        if(id == DataCode.DELETE_CHANNEL){
            this.deleteChannel(byteBuf.readInt(),true);
        }
        if(id == DataCode.CREATE_CHANNEL){
            this.createNewChannel(byteBuf.readInt(),new UUID(byteBuf.readLong(),byteBuf.readLong()),true);
        }
        if(id == DataCode.ADD_OWNER){
            this.data.get(byteBuf.readInt()).addOwner(new UUID(byteBuf.readLong(),byteBuf.readLong()),true);
        }
        if(id == DataCode.REMOVE_OWNER){
            this.data.get(byteBuf.readInt()).removeOwner(new UUID(byteBuf.readLong(),byteBuf.readLong()),true);
        }
    }
    
    public void sentUpdateData(int id, Consumer<ByteBuf> dataWriter){
        ByteBuf backedBuffer = Unpooled.buffer();
        dataWriter.accept(backedBuffer);
        if(isClient()){
            GCNetworkManager.INSTANCE.sendPacketToServer(new CWDataUpdatePacket(id,getName(),backedBuffer));
        }
        else {
            GCNetworkManager.INSTANCE.sendPacketToAll(new CWDataUpdatePacket(id,getName(),backedBuffer));
        }
    }
    
    //仅服务端操作
    public boolean addEU(int channel, long count) {
        if (channel != 0 && this.data.containsKey(channel)) {
            ElectricityData d = this.data.get(channel);
            d.setStorage(d.getStorage().add(BigInteger.valueOf(count)));
            this.markDirty();
            if(!isClient()){
                sentUpdateData(DataCode.ADD_EU,(byteBuf) -> {
                    byteBuf.writeInt(channel);
                    byteBuf.writeLong(channel);
                });
            }
            return true;
        } else {
            return false;
        }
    }
    
    //仅服务端操作
    public boolean subtractEU(int channel, long count) {
        return this.addEU(channel, -count);
    }
    
    public BigInteger getStoredEU(int channel) {
        return this.data.containsKey(channel) && channel != 0 ? this.data.get(channel).getStorage() : BigInteger.ZERO;
    }
    
    public long getStoredEULong(int channel) {
        BigInteger bi = this.getStoredEU(channel);
        return bi.bitLength() <= 63 ? bi.longValue() : 4611686018427387903L;
    }
    
    public boolean isExistChannel(int channel) {
        return this.data.containsKey(channel) && channel != 0;
    }
    
    @Nullable
    public ElectricityData getElectricityData(int channel){
        if(isExistChannel(channel)){
            return data.get(channel);
        }
        return null;
    }
    public boolean deleteChannel(int channel){
        return deleteChannel(channel,false);
    }
    //服务端客户端均可
    public boolean deleteChannel(int channel,boolean receiveData){
        if(isExistChannel(channel)){
            this.data.remove(channel);
            this.markDirty();
            if(!receiveData){
                sentUpdateData(DataCode.DELETE_CHANNEL,(byteBuf) -> byteBuf.writeInt(channel));
            }
            return true;
        }
        return false;
    }
    
    @Override
    public String getName() {
        return NAME;
    }
    
    public Collection<ElectricityData> getAllData(){
        return Collections.unmodifiableCollection(data.values());
    }
    
    public boolean isClient(){
        return FMLCommonHandler.instance().getSide() == Side.CLIENT;
    }
}
