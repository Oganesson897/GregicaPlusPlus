package me.oganesson.gregica.api.mte;

import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMap;
import me.oganesson.gregica.api.capability.GCCapabilities;
import me.oganesson.gregica.api.capability.IPressureContainer;
import me.oganesson.gregica.api.capability.IPressureMachine;
import me.oganesson.gregica.api.capability.impl.AtmosphericPressureContainer;
import me.oganesson.gregica.api.capability.impl.PressureMultiblockRecipeLogic;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public abstract class PressureMultiblockController extends RecipeMapMultiblockController implements IPressureMachine {

    private IPressureContainer container;

    public PressureMultiblockController(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap) {
        super(metaTileEntityId, recipeMap);
        this.recipeMapWorkable = new PressureMultiblockRecipeLogic(this);
    }

    @Override
    protected void initializeAbilities() {
        super.initializeAbilities();
        List<IPressureContainer> list = getAbilities(GCCapabilities.PRESSURE_CONTAINER);
        if (list.isEmpty()) {
            this.container = new AtmosphericPressureContainer(this, 1.0);
        } else {
            this.container = list.get(0);
        }
    }

    @Override
    public TraceabilityPredicate autoAbilities(boolean checkEnergyIn, boolean checkMaintenance, boolean checkItemIn, boolean checkItemOut, boolean checkFluidIn, boolean checkFluidOut, boolean checkMuffler) {
        TraceabilityPredicate predicate = super.autoAbilities(checkEnergyIn, checkMaintenance, checkItemIn, checkItemOut, checkFluidIn, checkFluidOut, checkMuffler);
        predicate = predicate.or(abilities(GCCapabilities.PRESSURE_CONTAINER).setMaxGlobalLimited(1).setPreviewCount(1));
        return predicate;
    }

    @Override
    public IPressureContainer getPressureContainer() {
        return this.container;
    }
}
