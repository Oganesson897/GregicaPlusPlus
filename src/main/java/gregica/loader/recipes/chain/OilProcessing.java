package gregica.loader.recipes.chain;

import gregica.api.recipe.GCRecipeMaps;

import static gregtech.api.GTValues.MV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregica.modules.gcys.api.unification.materials.GCYSMaterials.ParaXylene;

public class OilProcessing {

    public static void init() {
        catalyticReforming();
    }

    private static void catalyticReforming() {
        GCRecipeMaps.CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .notConsumable(plate, Platinum)
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(Toluene.getFluid(60))
                .fluidOutputs(Benzene.getFluid(200))
                .fluidOutputs(ParaXylene.getFluid(350))
                .fluidOutputs(Ethylbenzene.getFluid(200))
                .duration(120).EUt(VA[MV]).buildAndRegister();

        GCRecipeMaps.CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .notConsumable(plate, Rhenium)
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(Toluene.getFluid(120))
                .fluidOutputs(Benzene.getFluid(400))
                .fluidOutputs(ParaXylene.getFluid(700))
                .fluidOutputs(Ethylbenzene.getFluid(400))
                .duration(120).EUt(VA[MV]).buildAndRegister();
    }
}
