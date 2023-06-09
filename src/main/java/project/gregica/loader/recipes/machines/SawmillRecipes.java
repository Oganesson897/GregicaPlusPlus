package project.gregica.loader.recipes.machines;

import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;

import static project.gregica.api.recipe.GCRecipeMaps.SAWMILL;

public class SawmillRecipes {
    public static void init() {
        sawmillRecipe(Blocks.LOG, 0, Blocks.PLANKS, 0);
        sawmillRecipe(Blocks.LOG, 1, Blocks.PLANKS, 1);
        sawmillRecipe(Blocks.LOG, 2, Blocks.PLANKS, 2);
        sawmillRecipe(Blocks.LOG, 3, Blocks.PLANKS, 3);
        sawmillRecipe(MetaBlocks.RUBBER_LOG, 0, MetaBlocks.PLANKS, 0);
        sawmillRecipe(Blocks.LOG2, 0, Blocks.PLANKS, 4);
        sawmillRecipe(Blocks.LOG2, 1, Blocks.PLANKS, 5);
    }

    private static void sawmillRecipe(Block input, int meta, Block result, int meta2) {
        SAWMILL.recipeBuilder()
                .fluidInputs(Materials.Water.getFluid(1000))
                .input(ItemBlock.getItemFromBlock(input), 6, meta)
                .circuitMeta(1)
                .output(ItemBlock.getItemFromBlock(input), 48, meta2)
                .output(OrePrefix.dust, Materials.Wood, 12)
                .EUt(30)
                .duration(600)
                .build();

        SAWMILL.recipeBuilder()
                .fluidInputs(Materials.Water.getFluid(1000))
                .input(ItemBlock.getItemFromBlock(input), 6, meta)
                .circuitMeta(2)
                .output(ItemBlock.getItemFromBlock(input), 60, meta2)
                .EUt(30)
                .duration(600)
                .build();
    }
}
