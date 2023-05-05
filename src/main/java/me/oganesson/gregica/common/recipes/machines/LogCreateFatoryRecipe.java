package me.oganesson.gregica.common.recipes.machines;

import me.oganesson.gregica.api.GCValues;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional;
import thaumcraft.api.blocks.BlocksTC;
import static gregtech.common.blocks.MetaBlocks.*;
import static me.oganesson.gregica.api.recipe.GCRecipeMaps.LOGS_CREATE;

public class LogCreateFatoryRecipe {
    public static void init()
    {
        for (int i = 0; i < 4; i++) {
            addLogCreate(1920,200,20,i);
        }
        for (int i = 0; i < 2; i++) {
            addLog2Create(1920,200,20,i);
        }

        if (GCValues.IS_TC_LOADED) addThaumcraftLog();

        LOGS_CREATE.recipeBuilder()
                .notConsumable(new ItemStack(RUBBER_SAPLING))
                .outputs(new ItemStack(RUBBER_LOG,20))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();
    }
    private static void addLogCreate(int EUt, int tick, int outNum, int meta)
    {
        LOGS_CREATE.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING,1,meta))
                .outputs(new ItemStack(Blocks.LOG,outNum,meta))
                .EUt(EUt)
                .duration(tick)
                .buildAndRegister();
    }
    private static void addLog2Create(int EUt, int tick, int outNum, int meta)
    {
        LOGS_CREATE.recipeBuilder()
                .notConsumable(new ItemStack(Blocks.SAPLING,1,meta+4))
                .outputs(new ItemStack(Blocks.LOG2,outNum,meta))
                .EUt(EUt)
                .duration(tick)
                .buildAndRegister();
    }
    @Optional.Method(modid = "thaumcraft")
    private static void addThaumcraftLog()
    {
        LOGS_CREATE.recipeBuilder()
                .notConsumable(new ItemStack(BlocksTC.saplingGreatwood,1))
                .outputs(new ItemStack(BlocksTC.logGreatwood,16))
                .EUt(1920)
                .duration(300)
                .buildAndRegister();
        LOGS_CREATE.recipeBuilder()
                .notConsumable(new ItemStack(BlocksTC.saplingSilverwood,1))
                .outputs(new ItemStack(BlocksTC.logSilverwood,16))
                .EUt(1920)
                .duration(300)
                .buildAndRegister();
    }
}
