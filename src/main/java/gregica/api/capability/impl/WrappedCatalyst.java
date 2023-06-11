package gregica.api.capability.impl;

import gregica.api.item.ICatalyst;

import java.util.Optional;

public class WrappedCatalyst implements ICatalyst {
    
    ICatalyst inner;
    
    public WrappedCatalyst(ICatalyst inner){
        this.inner = inner;
    }
    
    public void update(ICatalyst newCatalyst){
        this.inner = newCatalyst;
    }
    
    @Override
    public Optional<String> getName() {
        return inner.getName();
    }
}
