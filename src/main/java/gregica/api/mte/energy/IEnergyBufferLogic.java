package gregica.api.mte.energy;

import gregtech.api.capability.IEnergyContainer;

import java.util.List;

public interface IEnergyBufferLogic<T extends Number> {
    
    void tryInputEnergy(List<IEnergyContainer> input);
    
    void tryOutputEnergy(List<IEnergyContainer> output);
    T getCapacity();
    
    T getStored();
    
    float getLossRate();
    
    long getLastInput();
    
    long getLastOutput();
    
}
