package gregica.api.data;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IStringSerializable;

public interface CrossWorldData extends IStringSerializable {
    
    void load(NBTTagCompound tagCompound);
    
    NBTTagCompound save();
    
    boolean isDirty();
    
    void init();
    
    void updateData(int id, ByteBuf byteBuf);
}
