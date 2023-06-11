package gregica.loader.recipes.chain;

import gregica.api.recipe.GCRecipeMaps;

import static gregtech.api.GTValues.HV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregica.modules.gcys.api.unification.materials.GCYSMaterials.Brine;
import static gregica.modules.gcys.api.unification.materials.GCYSMaterials.ChlorinatedBrine;

public class BrineChain {

    //TODO this is infinite bromine until Sodium Chloride Solution is separate from Salt Water
    public static void init() {
        GCRecipeMaps.DRYER_RECIPES.recipeBuilder()
                .fluidInputs(SaltWater.getFluid(8000))
                .fluidOutputs(Brine.getFluid(1000))
                .duration(640)
                .EUt(VA[HV])
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Brine.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .fluidOutputs(ChlorinatedBrine.getFluid(2000))
                .duration(160)
                .EUt(VA[HV])
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Sodium)
                .fluidInputs(ChlorinatedBrine.getFluid(1000))
                .output(dust, Salt, 8)
                .fluidOutputs(Bromine.getFluid(500))
                .duration(320)
                .EUt(VA[HV])
                .buildAndRegister();
    }
}
