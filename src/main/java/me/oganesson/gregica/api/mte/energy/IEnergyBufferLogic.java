package me.oganesson.gregica.api.mte.energy;

import gregtech.api.capability.IEnergyContainer;

import java.util.List;

public interface IEnergyBufferLogic<T extends Number> {
    T getCapacity(List<IEnergyContainer> input, List<IEnergyContainer> output );
    
    T getStored();
    
}
