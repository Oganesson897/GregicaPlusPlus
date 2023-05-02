package me.oganesson.gregica.api.capability.impl;

import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import me.oganesson.gregica.common.tileentities.mte.single.MTECreativeGenerator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class EnergyContainerCreative extends EnergyContainerHandler {
    
    public EnergyContainerCreative(MetaTileEntity tileEntity, long maxOutputVoltage) {
        this(tileEntity,Integer.MAX_VALUE, 0, 0, maxOutputVoltage, 64);
    }
    
    public EnergyContainerCreative(MetaTileEntity tileEntity,long maxCapacity,long maxInputVoltage,long maxInputAmperage, long maxOutputVoltage,long maxOutputAmperage) {
        super(tileEntity,maxCapacity, maxInputVoltage, maxInputAmperage, maxOutputVoltage, maxOutputAmperage);
    }
    
    @Override
    public long getEnergyStored() {
        return this.getOutputVoltage()*64;
    }
    
    @Override
    public void setEnergyStored(long energyStored) {
    
    }
    
    @Override
    public long getOutputAmperage() {
        MetaTileEntity metaTileEntity = getMetaTileEntity();
        if(metaTileEntity instanceof MTECreativeGenerator){
            MTECreativeGenerator cg = (MTECreativeGenerator)metaTileEntity;
            return cg.getOutputAmperage();
        }
        return 2L;
    }
    
    @Override
    public void update() {
        amps = 0;
        if (getMetaTileEntity().getWorld().isRemote)
            return;
        if (metaTileEntity.getOffsetTimer() % 20 == 0) {
            lastEnergyOutputPerSec = energyOutputPerSec;
            lastEnergyInputPerSec = energyInputPerSec;
            energyOutputPerSec = 0;
            energyInputPerSec = 0;
        }
        if (getEnergyStored() >= getOutputVoltage() && getOutputVoltage() > 0 && getOutputAmperage() > 0) {
            long outputVoltage = getOutputVoltage();
            long outputAmperes = Math.min(getEnergyStored() / outputVoltage, getOutputAmperage());
            if (outputAmperes == 0) return;
            long amperesUsed = 0;
            EnumFacing side = getMetaTileEntity().getFrontFacing();
            TileEntity tileEntity = metaTileEntity.getWorld().getTileEntity(metaTileEntity.getPos().offset(side));
            EnumFacing oppositeSide = side.getOpposite();
            if (tileEntity != null && tileEntity.hasCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, oppositeSide)) {
                IEnergyContainer energyContainer = tileEntity.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, oppositeSide);
                if (energyContainer != null || energyContainer.inputsEnergy(oppositeSide)){
                    amperesUsed += energyContainer.acceptEnergyFromNetwork(oppositeSide, outputVoltage, outputAmperes - amperesUsed);
                }
            }
            
            if (amperesUsed > 0) {
                setEnergyStored(getEnergyStored() - amperesUsed * outputVoltage);
            }
        }
    }
}
