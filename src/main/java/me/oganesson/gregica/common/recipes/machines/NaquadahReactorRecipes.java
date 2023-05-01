package me.oganesson.gregica.common.recipes.machines;


import gregtech.api.unification.material.Materials;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import static gregtech.api.unification.ore.OrePrefix.*;
import static me.oganesson.gregica.api.recipe.GCRecipeMaps.*;
import static me.oganesson.gregica.common.unification.materials.GCMaterial.Tiberium;

public class NaquadahReactorRecipes {

    private static final Item NULL = Items.AIR;
    public static void init() {
        addRecipeTiberium();
        addRecipeEnrichedNaquadah();
    }

    private static void addRecipeTiberium() {
        NR_MKI.recipeBuilder()
                .input(bolt, Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(625000)
                .buildAndRegister();

        NR_MKII.recipeBuilder()
                .input(stick, Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(3125000)
                .buildAndRegister();

        NR_MKIII.recipeBuilder()
                .input(stickLong, Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(6250000)
                .buildAndRegister();

        NR_MKIV.recipeBuilder()
                .input(stick, Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(1562500)
                .buildAndRegister();

        NR_MKV.recipeBuilder()
                .input(stickLong, Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(6250000)
                .buildAndRegister();
    }

    private static void addRecipeEnrichedNaquadah() {
        NR_MKI.recipeBuilder()
                .input(bolt, Materials.NaquadahEnriched)
                .output(bolt, Materials.Naquadah)
                .duration(20)
                .EUt(2500000)
                .buildAndRegister();

        NR_MKII.recipeBuilder()
                .input(stick, Materials.NaquadahEnriched)
                .output(stick, Materials.Naquadah)
                .duration(20)
                .EUt(12500000)
                .buildAndRegister();

        NR_MKIII.recipeBuilder()
                .input(stickLong, Materials.NaquadahEnriched)
                .output(stickLong, Materials.Naquadah)
                .duration(20)
                .EUt(25000000)
                .buildAndRegister();

        NR_MKIV.recipeBuilder()
                .input(bolt, Materials.Naquadria)
                .output(bolt, Materials.Naquadah)
                .duration(20)
                .EUt(12500000)
                .buildAndRegister();

        NR_MKV.recipeBuilder()
                .input(stick, Materials.Naquadria)
                .output(stick, Materials.Naquadah)
                .duration(20)
                .EUt(50000000)
                .buildAndRegister();
    }
}
