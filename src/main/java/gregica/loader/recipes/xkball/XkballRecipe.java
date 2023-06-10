package gregica.loader.recipes.xkball;

import gregica.loader.recipes.xkball.laser.LaserRecipes;
import gregica.loader.recipes.xkball.worktablerecipe.XkballCraftingTableRecipe;

public class XkballRecipe {
    public static void init(){
        LaserRecipes.init();
        XkballCraftingTableRecipe.init();
    }
}
