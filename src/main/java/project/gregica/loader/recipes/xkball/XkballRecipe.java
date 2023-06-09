package project.gregica.loader.recipes.xkball;

import project.gregica.loader.recipes.xkball.laser.LaserRecipes;
import project.gregica.loader.recipes.xkball.worktablerecipe.XkballCraftingTableRecipe;

public class XkballRecipe {
    public static void init(){
        LaserRecipes.init();
        XkballCraftingTableRecipe.init();
    }
}
