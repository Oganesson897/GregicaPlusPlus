package project.gregica.api.data;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IStringSerializable;

public interface CrossWorldData extends IStringSerializable {
    
    void load(NBTTagCompound tagCompound);
    
    NBTTagCompound save();
    
    boolean isDirty();
    
    void init();
}
