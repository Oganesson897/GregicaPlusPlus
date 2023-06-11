package gregica.loader.recipes.machines;


import gregica.api.recipe.GCRecipeMaps;
import gregica.api.unification.materials.GCMaterials;
import gregtech.api.unification.material.Materials;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import static gregtech.api.unification.ore.OrePrefix.*;

public class NaquadahReactorRecipes {

    private static final Item NULL = Items.AIR;
    public static void init() {
        addRecipeTiberium();
        addRecipeEnrichedNaquadah();
    }

    private static void addRecipeTiberium() {
        GCRecipeMaps.NR_MKI.recipeBuilder()
                .input(bolt, GCMaterials.Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(625000)
                .buildAndRegister();

        GCRecipeMaps.NR_MKII.recipeBuilder()
                .input(stick, GCMaterials.Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(3125000)
                .buildAndRegister();

        GCRecipeMaps.NR_MKIII.recipeBuilder()
                .input(stickLong, GCMaterials.Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(6250000)
                .buildAndRegister();

        GCRecipeMaps.NR_MKIV.recipeBuilder()
                .input(stick, GCMaterials.Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(1562500)
                .buildAndRegister();

        GCRecipeMaps.NR_MKV.recipeBuilder()
                .input(stickLong, GCMaterials.Tiberium)
                .output(NULL)
                .duration(20)
                .EUt(6250000)
                .buildAndRegister();
    }

    private static void addRecipeEnrichedNaquadah() {
        GCRecipeMaps.NR_MKI.recipeBuilder()
                .input(bolt, Materials.NaquadahEnriched)
                .output(bolt, Materials.Naquadah)
                .duration(20)
                .EUt(2500000)
                .buildAndRegister();

        GCRecipeMaps.NR_MKII.recipeBuilder()
                .input(stick, Materials.NaquadahEnriched)
                .output(stick, Materials.Naquadah)
                .duration(20)
                .EUt(12500000)
                .buildAndRegister();

        GCRecipeMaps.NR_MKIII.recipeBuilder()
                .input(stickLong, Materials.NaquadahEnriched)
                .output(stickLong, Materials.Naquadah)
                .duration(20)
                .EUt(25000000)
                .buildAndRegister();

        GCRecipeMaps.NR_MKIV.recipeBuilder()
                .input(bolt, Materials.Naquadria)
                .output(bolt, Materials.Naquadah)
                .duration(20)
                .EUt(12500000)
                .buildAndRegister();

        GCRecipeMaps.NR_MKV.recipeBuilder()
                .input(stick, Materials.Naquadria)
                .output(stick, Materials.Naquadah)
                .duration(20)
                .EUt(50000000)
                .buildAndRegister();
    }
}
