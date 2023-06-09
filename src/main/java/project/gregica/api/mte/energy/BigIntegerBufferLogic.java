package project.gregica.api.mte.energy;

import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import project.gregica.api.mte.IMTEChangeableBattery;
import project.gregica.api.mte.IUpdatable;
import project.gregica.common.tileentities.mte.multi.MultiblockWithUpdatable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.List;

public class BigIntegerBufferLogic<T extends MultiblockWithUpdatable<?> & IMTEChangeableBattery<T>> implements IEnergyBufferLogic<BigInteger>, IUpdatable {
    
    private final T metaTileEntity;
    
    private BigInteger stored = BigInteger.ZERO;
    
    private BigInteger leftCapacity = BigInteger.ZERO;
    
    private BigInteger capacity = BigInteger.ZERO;
    
    private long passiveLoss;
    
    private long input;
    
    private long output;
    
    private long lastInput;
    
    private long lastOutput;
    
    private boolean workingEnable;
    
    public BigIntegerBufferLogic(T metaTileEntity) {
        this.metaTileEntity = metaTileEntity;
    }
    
    @Override
    public void update() {
        BigInteger passiveLoss = BigInteger.valueOf(getPassiveLoss());
            stored = stored.subtract(stored.min(passiveLoss));
        
        if (!this.workingEnable)
            return;
        if(metaTileEntity.getOffsetTimer()%5 == 0){
            List<IEnergyContainer> input = metaTileEntity.getAbilities(MultiblockAbility.INPUT_ENERGY);
            List<IEnergyContainer> output = metaTileEntity.getAbilities(MultiblockAbility.OUTPUT_ENERGY);
            //this.capacity = metaTileEntity.getCapacity();
            this.stored = capacity.min(stored);
            updateLeftCapacity();
            tryInputEnergy(input);
            tryOutputEnergy(output);
        }
        if(metaTileEntity.getOffsetTimer()%20 == 0){
            lastInput = input;
            lastOutput =output;
            input = 0;
            output = 0;
        }
        if(this.getCapacity().equals(BigInteger.ZERO) || this.metaTileEntity.getOffsetTimer()%1200 == 0){
           this.capacity = metaTileEntity.updateCapacity();
           this.passiveLoss = metaTileEntity.updatePassiveLoss();
        }
    }
    
    public void tryInputEnergy(List<IEnergyContainer> input){
        for(IEnergyContainer energyContainer : input){
            if(leftCapacity.compareTo(BigInteger.ZERO)>0){
                BigInteger toAdd = leftCapacity.min(BigInteger.valueOf(energyContainer.getEnergyStored()));
                this.stored = this.stored.add(toAdd);
                //this.stored = this.stored - (long) (toAdd*(1-getLossRate()));
                energyContainer.removeEnergy(toAdd.longValue());
                this.input = this.input + toAdd.longValue();
                updateLeftCapacity();
            }
        }
    }
    
    public void tryOutputEnergy(List<IEnergyContainer> output) {
        for (IEnergyContainer energyContainer : output) {
            BigInteger outputValue = stored.min(BigInteger.valueOf(energyContainer.getEnergyCanBeInserted()));
            this.stored = this.stored.subtract(outputValue);
            energyContainer.addEnergy(outputValue.longValue());
            this.output = this.output + outputValue.longValue();
            updateLeftCapacity();
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(@NotNull NBTTagCompound data) {
        data.setString("stored",this.stored.toString());
        data.setString("capacity",this.capacity.toString());
        data.setBoolean("workable",this.workingEnable);
        data.setLong("passive_loss",this.passiveLoss);
        return data;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound data) {
        this.stored = new BigInteger(data.getString("stored"));
        this.capacity = new BigInteger(data.getString("capacity"));
        this.workingEnable = data.getBoolean("workable");
        this.passiveLoss = data.getLong("passive_loss");
        updateLeftCapacity();
    }
    
    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        buf.writeString(stored.toString());
        buf.writeString(capacity.toString());
        buf.writeBoolean(this.workingEnable);
        buf.writeLong(passiveLoss);
    }
    
    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        this.stored = new BigInteger(buf.readString(Integer.MAX_VALUE/5));
        this.capacity = new BigInteger(buf.readString(Integer.MAX_VALUE/5));
        this.workingEnable = buf.readBoolean();
        this.passiveLoss = buf.readLong();
        updateLeftCapacity();
    }
    
    private void updateLeftCapacity() {
        this.leftCapacity = this.capacity.subtract(this.stored);
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
    
    @Override
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
    public BigInteger getCapacity() {
        return capacity;
    }
    
    @Override
    public BigInteger getStored() {
        return stored;
    }
    
    @Override
    public float getLossRate() {
        return 1;
    }
    
    public long getPassiveLoss(){
        return passiveLoss;
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
