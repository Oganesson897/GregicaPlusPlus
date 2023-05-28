package me.oganesson.gregica.common.recipes;

import me.oganesson.gregica.common.recipes.machines.LogCreateFatoryRecipe;
import me.oganesson.gregica.common.recipes.machines.NaquadahReactorRecipes;
import me.oganesson.gregica.common.recipes.machines.ReplicatorRecipes;
import me.oganesson.gregica.common.recipes.xkball.XkballRecipe;

public class GCRecipeManager {
    private GCRecipeManager() {

    }

    public static void init() {
        NaquadahReactorRecipes.init();
        ReplicatorRecipes.init();
        LogCreateFatoryRecipe.init();
        GCBiologyRecipe.init();
        GCIsaProcessLine.init();
        XkballRecipe.init();
    }
}
