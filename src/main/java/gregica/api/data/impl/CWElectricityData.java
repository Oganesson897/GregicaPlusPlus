package gregica.api.data.impl;

import gregica.api.data.CrossWorldData;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CWElectricityData implements CrossWorldData {
    
    //private Int2ObjectMap<>
    @Override
    public void load(NBTTagCompound tagCompound) {
    
    }
    
    @Override
    public NBTTagCompound save() {
        return null;
    }
    
    @Override
    public boolean isDirty() {
        return false;
    }
    
    @Override
    public void init() {
    
    }
    
    @Override
    public String getName() {
        return null;
    }
}
