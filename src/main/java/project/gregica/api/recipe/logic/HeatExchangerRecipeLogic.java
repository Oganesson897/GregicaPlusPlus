package project.gregica.api.recipe.logic;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.unification.material.Materials;
import project.gregica.api.recipe.builders.HeatExchangerRecipeBuilder;
import project.gregica.common.tileentities.mte.multi.generators.MTELargeHeatExchanger;
import project.gregica.api.unification.materials.GCMaterials;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;

import java.util.ArrayList;
import java.util.List;

public class HeatExchangerRecipeLogic extends MultiblockRecipeLogic {
    private MTELargeHeatExchanger mte;

    public HeatExchangerRecipeLogic(MTELargeHeatExchanger tileEntity) {
        super(tileEntity);
        this.mte = ((MTELargeHeatExchanger)this.metaTileEntity);
    }

    @Override
    protected boolean canProgressRecipe() {
        boolean result = false;
        for (IFluidTank tank : this.mte.getAbilities(MultiblockAbility.IMPORT_FLUIDS)) {
            if ((tank.getFluid() == Materials.Water.getFluid(tank.getFluidAmount()) && isActive)) metaTileEntity.doExplosion(10);
            if (tank.getFluid() == Materials.DistilledWater.getFluid(tank.getFluidAmount())) result = true;
        }
        return super.canProgressRecipe() && result;
    }

    private List<FluidStack> getInputFluid() {
        List<FluidStack> result = new ArrayList<>();
        mte.getAbilities(MultiblockAbility.IMPORT_FLUIDS).forEach(iFluidTank -> result.add(iFluidTank.getFluid()));
        return result;
    }

    @Override
    protected void completeRecipe() {
        int amount;
        for (FluidStack stack : getInputFluid()) {
            if ((stack.getFluid() != Materials.DistilledWater.getFluid()) && canProgressRecipe()) {
                HeatExchangerRecipeBuilder builder = HeatExchangerRecipeBuilder.map.get(stack.getFluid());
                if (0 < stack.amount && stack.amount < builder.superheatedSteamThreshold) fluidOutputs.add(Materials.Steam.getFluid(stack.amount * builder.steamGenerateMultiplier));
                else
                    if (builder.superheatedSteamThreshold < stack.amount && stack.amount < builder.maxInputVolume) fluidOutputs.add(GCMaterials.SuperheatedSteam.getFluid(stack.amount * builder.steamGenerateMultiplier / 2));
            }
        }
    }
}
