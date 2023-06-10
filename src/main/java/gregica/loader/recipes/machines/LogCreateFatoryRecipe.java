package gregica.loader.recipes.machines;

import gregica.api.recipe.GCRecipeMaps;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import static gregtech.common.blocks.MetaBlocks.RUBBER_LOG;
import static gregtech.common.blocks.MetaBlocks.RUBBER_SAPLING;

public class LogCreateFatoryRecipe {
    public static void init()
    {
        for (int i = 0; i < 4; i++) {
            addLogCreate(1920,200,20,i);
        }
        for (int i = 0; i < 2; i++) {
            addLog2Create(1920,200,20,i);
        }

        GCRecipeMaps.LOGS_CREATE.recipeBuilder()
                .notConsumable(new ItemStack(RUBBER_SAPLING))
                .outputs(new ItemStack(RUBBER_LOG,20))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();
    }
    private static void addLogCreate(int EUt, int tick, int outNum, int meta)
    {
        GCRecipeMaps.LOGS_CREATE.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING,1,meta))
                .outputs(new ItemStack(Blocks.LOG,outNum,meta))
                .EUt(EUt)
                .duration(tick)
                .buildAndRegister();
    }
    private static void addLog2Create(int EUt, int tick, int outNum, int meta)
    {
        GCRecipeMaps.LOGS_CREATE.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING,1,meta+4))
                .outputs(new ItemStack(Blocks.LOG2,outNum,meta))
                .EUt(EUt)
                .duration(tick)
                .buildAndRegister();
    }
}
