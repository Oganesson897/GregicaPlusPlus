package me.oganesson.gregica.common.recipes.xkball.laser;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import me.oganesson.gregica.common.item.CommonItems;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;

public class LaserRecipes {
    
    public static void init(){
        RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(GTValues.VA[8])
                .duration(100)
                .input(GCMetaItems.OPTICAL_FIBER,16)
                .input(OrePrefix.ring, Materials.Iridium,2)
                .output(CommonItems.ITEM_LASER_VACUUM_BLOCK)
                .buildAndRegister();
                
    }
}
