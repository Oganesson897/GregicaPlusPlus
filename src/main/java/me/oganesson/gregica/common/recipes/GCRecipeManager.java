package me.oganesson.gregica.common.recipes;

import me.oganesson.gregica.GCConfig;
import me.oganesson.gregica.common.recipes.circuits.CircuitRecipes;
import me.oganesson.gregica.common.recipes.machines.LogCreateFatoryRecipe;
import me.oganesson.gregica.common.recipes.machines.NaquadahReactorRecipes;
import me.oganesson.gregica.common.recipes.machines.ReplicatorRecipes;

public class GCRecipeManager {
    private GCRecipeManager() {

    }

    public static void init() {
        NaquadahReactorRecipes.init();
        ReplicatorRecipes.init();
        LogCreateFatoryRecipe.init();

        if (GCConfig.Misc.enableTjcore) {
            tjcoreMerge();
        }
    }

    private static void tjcoreMerge() {
        //CircuitRecipes.registerCircuits();
    }
}
