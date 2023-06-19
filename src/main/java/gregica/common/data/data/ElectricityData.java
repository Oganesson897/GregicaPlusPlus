package gregica.common.data.data;

import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nullable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ElectricityData {
    public static final String STORAGE_KEY = "storage_electricity";
    private final int channel;
    private BigInteger storage;
    private final List<UUID> owner = new ArrayList<>();
    
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
    }
    
    public void addOwner(UUID ow) {
        this.owner.add(ow);
    }
    
    public void removeOwner(UUID ow) {
        this.owner.remove(ow);
    }
}
