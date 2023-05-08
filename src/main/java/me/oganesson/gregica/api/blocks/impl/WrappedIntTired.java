package me.oganesson.gregica.api.blocks.impl;

import net.minecraft.util.IStringSerializable;

public class WrappedIntTired extends WrappedTired{
    
    private final int tier;
    
    public WrappedIntTired(IStringSerializable inner,int tier) {
        super(inner);
        this.tier = tier;
    }
    
    public int getIntTier() {
        return tier;
    }
}
