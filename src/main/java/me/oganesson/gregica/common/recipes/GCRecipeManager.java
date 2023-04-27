package me.oganesson.gregica.common.recipes;

import me.oganesson.gregica.common.recipes.machines.NaquadahReactorRecipes;

public class GCRecipeManager {
    private GCRecipeManager() {

    }

    public static void init() {
        NaquadahReactorRecipes.init();
    }
}
