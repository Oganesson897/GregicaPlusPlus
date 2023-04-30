package me.oganesson.gregica.common.tileentities.mte.multi;

import gregtech.api.capability.IControllable;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import me.oganesson.gregica.api.mte.IUpdatable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;

public abstract class MultiblockWithUpdatable<T extends IUpdatable> extends MultiblockWithDisplayBase implements IControllable {
    public MultiblockWithUpdatable(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }
    
    public abstract T getLogic();
    
    @Override
    protected void updateFormedValid() {
    
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        return this.getLogic().writeToNBT(data);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.getLogic().readFromNBT(data);
    }
    
    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        this.getLogic().writeInitialSyncData(buf);
    }
    
    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.getLogic().receiveInitialSyncData(buf);
    }
    
    @Override
    public boolean isWorkingEnabled() {
        return this.getLogic().isWorkingEnabled();
    }
    
    @Override
    public void setWorkingEnabled(boolean b) {
        this.getLogic().setWorkingEnabled(b);
    }
    
    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        this.getLogic().receiveCustomData(dataId,buf);
    }
}
