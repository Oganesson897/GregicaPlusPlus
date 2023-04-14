package me.oganesson.gregica.api.quantum;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.recipes.RecipeMap;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.gcpp.recipe.GCPPRecipeMaps")
@ZenRegister

public class GCPPRecipeMaps {

    public static final RecipeMap<QubitProducerRecipeBuilder> SIMPLE_QUBIT_GENERATOR = new RecipeMap<>("simple_qubit_generator",
            1, 1, 0, 0, new QubitProducerRecipeBuilder(), false);

    public static final RecipeMap<QubitConsumerRecipeBuilder> RESEARCH_STATION = new RecipeMap<>("research_station",
            2, 1, 0, 0, new QubitConsumerRecipeBuilder(), false);
}
