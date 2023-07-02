package gregica.common.data.data;

import gregica.api.data.impl.CWElectricityData;
import gregica.common.data.CWDataType;
import gregica.common.data.CrossWorldDataHandler;
import gregica.common.data.DataCode;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nullable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ElectricityData {
    public static final String STORAGE_KEY = "storage_electricity";
    private final int channel;
    private BigInteger storage;
    private final List<UUID> owner = new ArrayList<>();
    
    private boolean isDirty = false;
    
    public ElectricityData(int channel, BigInteger storage) {
        this.channel = channel;
        this.storage = storage;
    }
    
    public NBTTagCompound save() {
        NBTTagCompound result = new NBTTagCompound();
        result.setString("storage_electricity", this.storage.toString());
        result.setInteger("owner_length", this.owner.size());
        
        for(int i = 0; i < this.owner.size(); ++i) {
            result.setUniqueId("owner_" + i, this.owner.get(i));
        }
        
        result.setInteger("channel", this.channel);
        return result;
    }
    
    @Nullable
    public static ElectricityData load(NBTTagCompound tag) {
        if (tag.hasKey("channel") && tag.hasKey("storage_electricity") && tag.hasKey("owner_length") && tag.getInteger("owner_length") != 0) {
            ElectricityData result = new ElectricityData(tag.getInteger("channel"), new BigInteger(tag.getString("storage_electricity")));
            
            for(int i = 0; i < tag.getInteger("owner_length"); ++i) {
                result.addOwner(tag.getUniqueId("owner_" + i));
            }
            
            return result;
        } else {
            return null;
        }
    }
    
    public int getChannel() {
        return this.channel;
    }
    
    public BigInteger getStorage() {
        return this.storage;
    }
    
    public void setStorage(BigInteger storage) {
        this.storage = storage;
        this.markDirty();
    }
    public ElectricityData addOwner(UUID ow){
        return this.addOwner(ow,false);
    }
    //服务端客户端均可
    public ElectricityData addOwner(UUID ow,boolean isReceive) {
        if(owner.contains(ow)) return this;
        this.owner.add(ow);
        this.markDirty();
        if(!isReceive){
            getHandler().sentUpdateData(DataCode.ADD_OWNER,byteBuf -> {
                byteBuf.writeInt(this.channel);
                byteBuf.writeLong(ow.getMostSignificantBits());
                byteBuf.writeLong(ow.getLeastSignificantBits());
            });
        }
        return this;
    }
    
    public void removeOwner(UUID ow){
        this.removeOwner(ow,false);
    }
    //服务端客户端均可
    public void removeOwner(UUID ow,boolean isReceive) {
        if(!owner.contains(ow)) return;
        this.owner.remove(ow);
        this.markDirty();
        if(!isReceive){
            getHandler().sentUpdateData(DataCode.REMOVE_OWNER,byteBuf -> {
                byteBuf.writeInt(this.channel);
                byteBuf.writeLong(ow.getMostSignificantBits());
                byteBuf.writeLong(ow.getLeastSignificantBits());
            });
        }
    }
    
    public List<UUID> getOwners(){
        return Collections.unmodifiableList(owner);
    }
    
    public void markDirty() {
        this.isDirty = true;
    }
    
    public boolean isDirty() {
        return isDirty;
    }
    
    public CWElectricityData getHandler(){
        return CrossWorldDataHandler.INSTANCE.getOrCreate(CWDataType.ELECTRICITY);
    }
}
