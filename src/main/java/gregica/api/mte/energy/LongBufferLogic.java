package gregica.api.mte.energy;

import gregica.api.mte.IUpdatable;
import gregica.common.tileentities.mte.multi.MultiblockWithUpdatable;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LongBufferLogic implements IEnergyBufferLogic<Long>, IUpdatable {
    
    private final MultiblockWithUpdatable<?> metaTileEntity;
    
    private long stored;
    
    private long leftCapacity;
    
    private long capacity;
    
    private long input;
    
    private long output;
    
    private long lastInput;
    
    private long lastOutput;
    
    private boolean workingEnable;
    
    public LongBufferLogic(MultiblockWithUpdatable<?> metaTileEntity) {
        this.metaTileEntity = metaTileEntity;
    }
    
    public Long updateCapacity(List<IEnergyContainer> input, List<IEnergyContainer> output ) {
        long l = 0;
        for(IEnergyContainer container : input){
            l = l+container.getEnergyCapacity();
        }
        for(IEnergyContainer container : output){
            l = l+container.getEnergyCapacity();
        }
        return l;
    }
    
    @Override
    public Long getStored() {
        return stored;
    }
    
    @Override
    public float getLossRate() {
        return 0.9998f;
    }
    
    
    @Override
    public void update() {
        if (!this.workingEnable)
            return;
        if(metaTileEntity.getOffsetTimer() % 5 == 0) {
            List<IEnergyContainer> input = metaTileEntity.getAbilities(MultiblockAbility.INPUT_ENERGY);
            List<IEnergyContainer> output = metaTileEntity.getAbilities(MultiblockAbility.OUTPUT_ENERGY);
            this.capacity = updateCapacity(input, output);
            this.stored = Math.min(capacity, stored);
            updateLeftCapacity();
            tryInputEnergy(input);
            tryOutputEnergy(output);
        }
        if(metaTileEntity.getOffsetTimer()%20 == 0){
            lastInput = input;
            lastOutput = output;
            input = 0;
            output = 0;
        }
    }
    
    public void tryInputEnergy(List<IEnergyContainer> input){
        for(IEnergyContainer energyContainer : input){
            if(leftCapacity > 0){
                long toAdd = Math.min(leftCapacity, energyContainer.getEnergyStored());
                this.stored = this.stored + toAdd;
                this.stored = this.stored - (long) (toAdd*(1-getLossRate()));
                energyContainer.removeEnergy(toAdd);
                this.input = this.input+toAdd;
                updateLeftCapacity();
            }
        }
    }
    
    public void tryOutputEnergy(List<IEnergyContainer> output){
        for(IEnergyContainer energyContainer : output){
            long outputValue =  Math.min(stored,energyContainer.getEnergyCanBeInserted());
            this.stored = this.stored - outputValue;
            energyContainer.addEnergy(outputValue);
            this.output = this.output + outputValue;
            updateLeftCapacity();
        }
    }
    
    public void updateLeftCapacity(){
        this.leftCapacity = capacity - stored;
    }
    
    
    @Override
    public NBTTagCompound writeToNBT(@NotNull NBTTagCompound data) {
        data.setLong("stored",this.stored);
        data.setLong("capacity",this.capacity);
        data.setBoolean("workable",this.workingEnable);
        return data;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound data) {
        this.stored = data.getLong("stored");
        this.capacity = data.getLong("capacity");
        this.workingEnable = data.getBoolean("workable");
        updateLeftCapacity();
    }
    
    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        buf.writeLong(this.stored);
        buf.writeLong(this.capacity);
        buf.writeBoolean(this.workingEnable);
    }
    
    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        this.stored = buf.readLong();
        this.capacity = buf.readLong();
        this.workingEnable = buf.readBoolean();
        updateLeftCapacity();
    }
    
    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            this.workingEnable = buf.readBoolean();
            metaTileEntity.scheduleRenderUpdate();
        }
    }
    
    @Override
    public boolean isWorkingEnabled() {
        return this.workingEnable;
    }
    
    public void setWorkingEnabled(boolean isWorkingEnabled) {
        if (this.workingEnable != isWorkingEnabled) {
            this.workingEnable = isWorkingEnabled;
            metaTileEntity.markDirty();
            if (metaTileEntity.getWorld() != null && !metaTileEntity.getWorld().isRemote) {
                this.metaTileEntity.writeCustomData(GregtechDataCodes.WORKING_ENABLED, buf -> buf.writeBoolean(isWorkingEnabled));
            }
        }
    }
    
    @Override
    public Long getCapacity(){
        return capacity;
    }
    
    public long getBuffedCapacity(){
        return capacity;
    }
    
    @Override
    public long getLastInput() {
        return lastInput;
    }
    
    @Override
    public long getLastOutput() {
        return lastOutput;
    }
}
