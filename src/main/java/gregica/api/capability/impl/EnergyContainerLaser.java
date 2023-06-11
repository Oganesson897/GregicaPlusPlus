package gregica.api.capability.impl;

import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.metatileentity.MetaTileEntity;

public class EnergyContainerLaser extends EnergyContainerHandler {
    
    public static EnergyContainerHandler input(MetaTileEntity tileEntity,long voltage,long amperage){
        return new EnergyContainerLaser(tileEntity,voltage*amperage*64,voltage,amperage,0,0);
    }
    
    public static EnergyContainerHandler output(MetaTileEntity tileEntity,long voltage,long amperage){
        return new EnergyContainerLaser(tileEntity,voltage*amperage*64,0,0,voltage,amperage);
    }
    
    public EnergyContainerLaser(MetaTileEntity tileEntity, long maxCapacity, long maxInputVoltage, long maxInputAmperage, long maxOutputVoltage, long maxOutputAmperage) {
        super(tileEntity, maxCapacity, maxInputVoltage, maxInputAmperage, maxOutputVoltage, maxOutputAmperage);
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
//        if (getEnergyStored() >= getOutputVoltage() && getOutputVoltage() > 0 && getOutputAmperage() > 0) {
//            long outputVoltage = getOutputVoltage();
//            long outputAmperes = Math.min(getEnergyStored() / outputVoltage, getOutputAmperage());
//            if (outputAmperes == 0) return;
//            long amperesUsed = 0;
//            //向激光靶仓输出
////            EnumFacing side = getMetaTileEntity().getFrontFacing();
////            TileEntity tileEntity = metaTileEntity.getWorld().getTileEntity(metaTileEntity.getPos().offset(side));
////            EnumFacing oppositeSide = side.getOpposite();
////            if (tileEntity != null && tileEntity.hasCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, oppositeSide)) {
////                IEnergyContainer energyContainer = tileEntity.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, oppositeSide);
////                if (energyContainer != null || energyContainer.inputsEnergy(oppositeSide)){
////                    amperesUsed += energyContainer.acceptEnergyFromNetwork(oppositeSide, outputVoltage, outputAmperes - amperesUsed);
////                }
////            }
//
//            if (amperesUsed > 0) {
//                setEnergyStored(getEnergyStored() - amperesUsed * outputVoltage);
//            }
//        }
    }
}
