package me.oganesson.gregica.api.quantum;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.recipes.RecipeMap;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.gcpp.recipe.GCPPRecipeMaps")
@ZenRegister

public class GCPPRecipeMaps {

    @ZenProperty
    public static final RecipeMap<QubitProducerRecipeBuilder> SIMPLE_QUBIT_GENERATOR = new RecipeMap<>("simple_qubit_generator",
            1, 1, 0, 0, 0, 0, 0, 0, new QubitProducerRecipeBuilder(), false);

}
