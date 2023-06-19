package gregica.api.capability.impl;

import gregica.api.data.impl.CWElectricityData;
import gregica.utils.GCMathUtils;
import gregica.common.data.CWDataType;
import gregica.common.data.CrossWorldDataHandler;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.metatileentity.MetaTileEntity;

public class EnergyContainerWireless extends EnergyContainerHandler {
    
    private int channel;
    
    public EnergyContainerWireless(MetaTileEntity tileEntity, boolean isExport,
                                    long voltage, long amperage,int channel){
        this(tileEntity,voltage*amperage*32,isExport?0:voltage,amperage,isExport?voltage:0,amperage,channel);
    }
    
    public EnergyContainerWireless(MetaTileEntity tileEntity, long maxCapacity, long maxInputVoltage, long maxInputAmperage, long maxOutputVoltage, long maxOutputAmperage,int channel) {
        super(tileEntity, maxCapacity, maxInputVoltage, maxInputAmperage, maxOutputVoltage, maxOutputAmperage);
        this.channel = channel;
    }
    
    @Override
    public void update() {
        //super.update();
        if(!this.metaTileEntity.getWorld().isRemote && channel != 0){
            if(this.metaTileEntity.getOffsetTimer() % 5 == 0){
                long amps;
                CWElectricityData data = CrossWorldDataHandler.INSTANCE.getOrCreate(CWDataType.ELECTRICITY);
                if(this.getInputAmperage() != 0){
                    amps = this.getInputAmperage();
                    long toSub = Math.min(this.getEnergyStored(),this.getInputVoltage()*amps*5);
                    this.removeEnergy(toSub);
                    data.addEU(this.channel,toSub);
                }
                if(this.getOutputAmperage() != 0){
                    amps = this.getOutputAmperage();
                    long toAdd = GCMathUtils.min(this.getEnergyCanBeInserted(),this.getOutputVoltage()*amps*5,data.getStoredEULong(channel));
                    data.subtractEU(channel,toAdd);
                    this.addEnergy(toAdd);
                }
            }
        }
    }
    
    
    public int getChannel() {
        return channel;
    }
    
    public void setChannel(int channel) {
        this.channel = channel;
    }
    
    @Override
    public long getEnergyCanBeInserted() {
        return 0;
    }
}
