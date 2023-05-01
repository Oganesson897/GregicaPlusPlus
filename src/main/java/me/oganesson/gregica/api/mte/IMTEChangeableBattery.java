package me.oganesson.gregica.api.mte;

import gregtech.api.metatileentity.MetaTileEntity;

import java.math.BigInteger;

public interface IMTEChangeableBattery<T extends MetaTileEntity> {
    
    BigInteger getCapacity();
    int getPassiveLoss();
    
    BigInteger updateCapacity();
    
    int updatePassiveLoss();
}
