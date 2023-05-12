package me.oganesson.gregica.common.recipes.chain;

import gregtech.api.recipes.ingredients.IntCircuitIngredient;

import static gregtech.api.GTValues.EV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.Graphite;
import static gregtech.api.unification.material.Materials.Silicon;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static me.oganesson.gregica.api.unification.materials.GCYSMaterials.SiliconCarbide;

/**
 * Adds recipes for simple materials with few steps
 */
public class SimpleMaterials {

    public static void init() {
        siliconCarbide();
    }

    private static void siliconCarbide() {
        // produced via the Lely Method
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .input(dust, Silicon)
                .notConsumable(new IntCircuitIngredient(1))
                .output(dust, SiliconCarbide, 2)
                .duration(300).EUt(VA[EV]).buildAndRegister();
    }
}
