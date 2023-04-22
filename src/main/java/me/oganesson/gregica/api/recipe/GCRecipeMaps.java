package me.oganesson.gregica.api.recipe;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.recipes.RecipeMap;
import me.oganesson.gregica.api.capability.quantum.QubitConsumerRecipeBuilder;
import me.oganesson.gregica.api.capability.quantum.QubitProducerRecipeBuilder;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.gcpp.recipe.GCPPRecipeMaps")
@ZenRegister

public class GCRecipeMaps {

    public static final RecipeMap<QubitProducerRecipeBuilder> SIMPLE_QUBIT_GENERATOR = new RecipeMap<>("simple_qubit_generator",
            1, 1, 0, 0, new QubitProducerRecipeBuilder(), false);

    public static final RecipeMap<QubitConsumerRecipeBuilder> RESEARCH_STATION = new RecipeMap<>("research_station",
            2, 1, 0, 0, new QubitConsumerRecipeBuilder(), false);
}
