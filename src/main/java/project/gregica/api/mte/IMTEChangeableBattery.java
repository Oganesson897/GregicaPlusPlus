package project.gregica.api.mte;

import gregtech.api.metatileentity.MetaTileEntity;

import java.math.BigInteger;

public interface IMTEChangeableBattery<T extends MetaTileEntity> {
    
    BigInteger getCapacity();
    long getPassiveLoss();
    
    BigInteger updateCapacity();
    
    long updatePassiveLoss();
}
