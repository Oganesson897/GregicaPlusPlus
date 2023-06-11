package gregica.loader.recipes;

import gregica.loader.recipes.machines.LogCreateFatoryRecipe;
import gregica.loader.recipes.machines.NaquadahReactorRecipes;
import gregica.loader.recipes.machines.ReplicatorRecipes;
import gregica.loader.recipes.xkball.XkballRecipe;

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
