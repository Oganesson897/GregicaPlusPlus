package project.gregica.loader.recipes;

import project.gregica.loader.recipes.machines.LogCreateFatoryRecipe;
import project.gregica.loader.recipes.machines.NaquadahReactorRecipes;
import project.gregica.loader.recipes.machines.ReplicatorRecipes;
import project.gregica.loader.recipes.machines.SawmillRecipes;
import project.gregica.loader.recipes.xkball.XkballRecipe;

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
        SawmillRecipes.init();
    }
}
