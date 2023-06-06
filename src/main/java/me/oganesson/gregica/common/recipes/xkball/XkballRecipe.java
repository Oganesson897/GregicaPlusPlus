package me.oganesson.gregica.common.recipes.xkball;

import me.oganesson.gregica.common.recipes.xkball.laser.LaserRecipes;
import me.oganesson.gregica.common.recipes.xkball.worktablerecipe.XkballCraftingTableRecipe;

public class XkballRecipe {
    public static void init(){
        LaserRecipes.init();
        XkballCraftingTableRecipe.init();
    }
}
