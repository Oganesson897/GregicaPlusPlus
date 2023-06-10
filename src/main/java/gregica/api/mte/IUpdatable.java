package gregica.api.mte;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;

import javax.annotation.Nonnull;

public interface IUpdatable {
    
    void update();
    
    NBTTagCompound writeToNBT(@Nonnull NBTTagCompound data);
   
    void readFromNBT(NBTTagCompound data);
   
    void writeInitialSyncData(PacketBuffer buf);
    
    void receiveInitialSyncData(PacketBuffer buf);
    
    void receiveCustomData(int dataId, PacketBuffer buf);
    
    boolean isWorkingEnabled();
    
    void setWorkingEnabled(boolean isWorkingEnabled);
}
