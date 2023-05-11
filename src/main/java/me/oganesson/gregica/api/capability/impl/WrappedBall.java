package me.oganesson.gregica.api.capability.impl;

import me.oganesson.gregica.api.item.IBall;

import java.util.Optional;

public class WrappedBall implements IBall {
    
    IBall inner;
    
    public WrappedBall(IBall inner){
        this.inner = inner;
    }
    
    public void update(IBall newBall){
        this.inner = newBall;
    }
    
    @Override
    public Optional<String> getName() {
        return inner.getName();
    }
}
