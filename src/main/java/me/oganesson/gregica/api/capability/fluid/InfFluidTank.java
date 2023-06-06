package me.oganesson.gregica.api.capability.fluid;

import gregtech.api.capability.impl.NotifiableFluidTank;
import gregtech.api.metatileentity.MetaTileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import org.jetbrains.annotations.Nullable;

public class InfFluidTank extends NotifiableFluidTank {
    
    final Fluid fluidType;
    final FluidStack stack;
    
    public InfFluidTank(FluidStack fluidStack, MetaTileEntity entityToNotify, boolean isExport) {
        super(Integer.MAX_VALUE, entityToNotify, isExport);
        this.fluid = fluidStack;
        this.fluidType = fluidStack.getFluid();
        this.stack = new FluidStack(fluid,Integer.MAX_VALUE);
    }
    
    @Nullable
    @Override
    public FluidStack getFluid() {
        return stack;
    }
    
    @Override
    public void setFluid(@Nullable FluidStack fluid) {
    }
    
    public void update(){
        this.onContentsChanged();
    }
    @Override
    public boolean canFill() {
        return false;
    }
    
    @Override
    public boolean canDrain() {
        return true;
    }
    
    @Override
    public FluidStack drain(FluidStack resource, boolean doDrain) {
        return resource;
    }
    
    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        if(fluid != null){
            return new FluidStack(fluid,maxDrain);
        }
        return null;
    }
    
    @Override
    public int fill(FluidStack resource, boolean doFill) {
        return 0;
    }
    
    @Override
    public int getFluidAmount() {
        return Integer.MAX_VALUE;
    }
}
