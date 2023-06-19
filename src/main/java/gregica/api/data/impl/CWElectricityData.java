package gregica.api.data.impl;

import gregica.api.data.CrossWorldData;
import gregica.common.data.data.ElectricityData;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import javax.annotation.ParametersAreNonnullByDefault;
import java.math.BigInteger;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CWElectricityData implements CrossWorldData {
    
    private final Int2ObjectMap<ElectricityData> data = new Int2ObjectOpenHashMap<>();
    private boolean isDirty = false;
    
    public CWElectricityData() {
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
    
    public boolean isDirty() {
        return this.isDirty;
    }
    
    public void markDirty() {
        this.isDirty = true;
    }
    
    public void init() {
    }
    
    public boolean addEU(int channel, long count) {
        if (channel != 0 && this.data.containsKey(channel)) {
            ElectricityData d = this.data.get(channel);
            d.setStorage(d.getStorage().add(BigInteger.valueOf(count)));
            this.markDirty();
            return true;
        } else {
            return false;
        }
    }
    
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
    
    @Override
    public String getName() {
        return "cross_world_electricity_data";
    }
}
