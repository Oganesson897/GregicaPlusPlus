package project.gregica.api.blocks.impl;

import project.gregica.api.blocks.ITired;
import net.minecraft.util.IStringSerializable;
import org.jetbrains.annotations.NotNull;

public class WrappedTired implements ITired {
    
    private final IStringSerializable inner;
    
    public WrappedTired(IStringSerializable inner) {
        this.inner = inner;
    }
    
    @Override
    @NotNull
    public String getName() {
        return inner.getName();
    }
}
