package project.gregica.loader.recipes.compat;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import project.gregica.api.unification.materials.GCMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.items.ItemsTC;

import static project.gregica.api.recipe.GCRecipeMaps.LOGS_CREATE;

public class Thaumcraft {

    public static void initTC(){
       //registerTCOre();
        addThaumcraftLog();
      //  removeEZPlate();
    }


    public static void registerTCOre(){
        OreDictUnifier.registerOre(new ItemStack(ItemsTC.ingots, 1, 0), OrePrefix.ingot, GCMaterials.Thaumium);
        OreDictUnifier.registerOre(new ItemStack(ItemsTC.ingots, 1, 1), OrePrefix.ingot, GCMaterials.VoidMetal);
        OreDictUnifier.registerOre(new ItemStack(ItemsTC.plate, 1, 2), OrePrefix.plate, GCMaterials.Thaumium);
        OreDictUnifier.registerOre(new ItemStack(ItemsTC.plate, 1, 3), OrePrefix.plate, GCMaterials.VoidMetal);
        OreDictUnifier.registerOre(new ItemStack(BlocksTC.metalBlockThaumium), OrePrefix.block, GCMaterials.Thaumium);
        OreDictUnifier.registerOre(new ItemStack(BlocksTC.metalBlockVoid), OrePrefix.block, GCMaterials.VoidMetal);

    }

    public static void addThaumcraftLog()
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

    public static void removeEZPlate()
    {
        ModHandler.removeRecipeByName(new ResourceLocation("thaumcraft:ironplate"));
        ModHandler.removeRecipeByName(new ResourceLocation("thaumcraft:brassplate"));
        ModHandler.removeRecipeByName(new ResourceLocation("thaumcraft:thaumiumplate"));
        ModHandler.removeRecipeByName(new ResourceLocation("thaumcraft:voidplate"));
    }
}
