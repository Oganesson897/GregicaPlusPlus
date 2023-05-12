package me.oganesson.gregica.common.recipes;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.ConfigHolder;
import gregtech.common.items.MetaItems;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;
import me.oganesson.gregica.common.unification.materials.GCMaterials;
import me.oganesson.gregica.common.unification.ore.GCOrePrefix;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;

import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.gem;
import static me.oganesson.gregica.common.unification.ore.GCMaterialFlags.GENERATE_MILLED;

public class GCIsaProcessLine {

    public static void register(){
        OrePrefix.ore.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
        OrePrefix.oreNetherrack.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
        OrePrefix.oreEndstone.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
        if (ConfigHolder.worldgen.allUniqueStoneTypes) {
            OrePrefix.oreGranite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreDiorite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreAndesite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreBasalt.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreBlackgranite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreMarble.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreRedgranite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreSand.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreRedSand.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
        }
    }

    public static void processIsaMill(OrePrefix ore, @Nonnull Material material, OreProperty property) {
        if(!material.hasFlag(GENERATE_MILLED))
            return;

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.ore, material, 16)
                .circuitMeta(11)
                .duration(3000)
                .getTier(1)
                .EUt(7680)
                .outputs(OreDictUnifier.get(GCOrePrefix.oreMilled, material, 48))
                .buildAndRegister();

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.crushed, material, 16)
                .circuitMeta(11)
                .getTier(1)
                .duration(1500)
                .EUt(7680)
                .output(GCOrePrefix.oreMilled, material, 16)
                .buildAndRegister();

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.crushed, material, 16)
                .circuitMeta(10)
                .getTier(2)
                .duration(1200)
                .EUt(7680)
                .output(GCOrePrefix.oreMilled, material, 32)
                .buildAndRegister();

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.ore, material, 16)
                .circuitMeta(10)
                .getTier(2)
                .duration(2400)
                .EUt(7680)
                .output(GCOrePrefix.oreMilled, material, 64)
                .output(GCOrePrefix.oreMilled, material, 32)
                .buildAndRegister();
    }

    public static void init() {
        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(3)
                .input(OrePrefix.dust, Materials.Potash, 3)
                .input(OrePrefix.dust, Materials.Quicklime, 5)
                .fluidInputs(Materials.Water.getFluid(5000))
                .fluidInputs(Materials.CarbonDioxide.getFluid(1000))
                .circuitMeta(18)
                .EUt(120)
                .duration(600)
                .output(OrePrefix.dust, GCMaterials.CalciumCarbonate, 5)
                .outputs(GCMetaItems.POTASSIUM_ETHYLATE.getStackForm(6))
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(3)
                .input(OrePrefix.dust, Materials.Sodium)
                .fluidInputs(Materials.Ethanol.getFluid(1000))
                .circuitMeta(16)
                .EUt(120)
                .duration(600)
                .fluidOutputs(Materials.Hydrogen.getFluid(1000))
                .outputs(GCMetaItems.SODIUM_ETHYLATE.getStackForm(9))
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(5)
                .inputs(GCMetaItems.POTASSIUM_ETHYLATE.getStackForm(3))
                .fluidInputs(GCMaterials.CarbenDisulfide.getFluid(1000))
                .circuitMeta(17)
                .EUt(120)
                .duration(1200)
                .outputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(12))
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(5)
                .inputs(GCMetaItems.SODIUM_ETHYLATE.getStackForm(9))
                .fluidInputs(GCMaterials.CarbenDisulfide.getFluid(1000))
                .fluidInputs(Materials.Ethanol.getFluid(1000))
                .circuitMeta(17)
                .EUt(120)
                .duration(1200)
                .outputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(12))
                .fluidOutputs(Materials.Water.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(4)
                .inputs(GCMetaItems.PINE_FRAGMENT.getStackForm(64))
                .fluidInputs(Materials.Steam.getFluid(5000))
                .circuitMeta(16)
                .EUt(120)
                .duration(1200)
                .chancedOutput(OrePrefix.dust, Materials.Ash, 5, 30, 15)
                .chancedOutput(OrePrefix.dust, Materials.Ash, 5, 30, 15)
                .chancedOutput(OrePrefix.dust, Materials.DarkAsh, 5, 30, 15)
                .chancedOutput(OrePrefix.dust, Materials.DarkAsh, 5, 30, 15)
                .fluidOutputs(GCMaterials.PineOil.getFluid(500))
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(5)
                .inputs(GCMetaItems.PINE_FRAGMENT.getStackForm(64))
                .fluidInputs(Materials.Steam.getFluid(5000))
                .circuitMeta(18)
                .EUt(120)
                .duration(900)
                .chancedOutput(OrePrefix.dustTiny, Materials.Ash, 5, 30, 15)
                .chancedOutput(OrePrefix.dustTiny, Materials.Ash, 5, 30, 15)
                .chancedOutput(OrePrefix.dustTiny, Materials.DarkAsh, 5, 30, 15)
                .chancedOutput(OrePrefix.dustTiny, Materials.DarkAsh, 5, 30, 15)
                .fluidOutputs(GCMaterials.PineOil.getFluid(1500))
                .buildAndRegister();

        RecipeMaps.BLAST_RECIPES.recipeBuilder()
                .input(gem, Materials.Coke, 8)
                .input(dust, Materials.Sulfur, 16)
                .output(dust, Materials.DarkAsh, 1)
                .fluidOutputs(GCMaterials.CarbenDisulfide.getFluid(4000))
                .blastFurnaceTemp(1500)
                .EUt(30).duration(12000)
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(3)
                .input(dust, Materials.Sulfur, 4)
                .fluidInputs(Materials.CoalGas.getFluid(1000))
                .circuitMeta(20)
                .EUt(30)
                .duration(6000)
                .fluidOutputs(GCMaterials.CarbenDisulfide.getFluid(2000))
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(4)
                .input(Item.getItemFromBlock(GCMetaBlocks.PINE_LEAVES))
                .circuitMeta(14)
                .EUt(30)
                .duration(200)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 2, 5000, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 2, 5000, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 2, 2500, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 2, 2500, 0)
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(4)
                .input(Item.getItemFromBlock(GCMetaBlocks.PINE_SAPLING))
                .circuitMeta(14)
                .EUt(60)
                .duration(200)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 4, 7500, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 4, 7500, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 4, 2500, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 4, 2500, 0)
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(4)
                .input(Item.getItemFromBlock(GCMetaBlocks.PINE_LOG))
                .circuitMeta(14)
                .EUt(120)
                .duration(200)
                .output(GCMetaItems.PINE_FRAGMENT, 16)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 16, 75, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 16, 50, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 16, 25, 0)
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .input(Items.BREAD)
                .output(Items.STICK)
                .EUt(1920).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(8000))
                .fluidOutputs(GCMaterials.PyropeFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Pyrope, 64)
                .input(GCOrePrefix.oreMilled, Materials.Pyrope, 64)
                .input(GCOrePrefix.oreMilled, Materials.Pyrope, 64)
                .input(GCOrePrefix.oreMilled, Materials.Pyrope, 64)
                .EUt(1920).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(8000))
                .fluidOutputs(GCMaterials.PyropeFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Chalcopyrite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Chalcopyrite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Chalcopyrite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Chalcopyrite, 64)
                .EUt(7680).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(12000))
                .fluidOutputs(GCMaterials.ChalcopyriteFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Redstone, 64)
                .input(GCOrePrefix.oreMilled, Materials.Redstone, 64)
                .input(GCOrePrefix.oreMilled, Materials.Redstone, 64)
                .input(GCOrePrefix.oreMilled, Materials.Redstone, 64)
                .EUt(7680).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(13000))
                .fluidOutputs(GCMaterials.RedstoneFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Nickel, 64)
                .input(GCOrePrefix.oreMilled, Materials.Nickel, 64)
                .input(GCOrePrefix.oreMilled, Materials.Nickel, 64)
                .input(GCOrePrefix.oreMilled, Materials.Nickel, 64)
                .EUt(7680).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(25000))
                .fluidOutputs(GCMaterials.NickelFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Almandine, 64)
                .input(GCOrePrefix.oreMilled, Materials.Almandine, 64)
                .input(GCOrePrefix.oreMilled, Materials.Almandine, 64)
                .input(GCOrePrefix.oreMilled, Materials.Almandine, 64)
                .EUt(7680).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(18000))
                .fluidOutputs(GCMaterials.AlmandineFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Spessartine, 64)
                .input(GCOrePrefix.oreMilled, Materials.Spessartine, 64)
                .input(GCOrePrefix.oreMilled, Materials.Spessartine, 64)
                .input(GCOrePrefix.oreMilled, Materials.Spessartine, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(35000))
                .fluidOutputs(GCMaterials.SpessartineFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Sphalerite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Sphalerite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Sphalerite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Sphalerite, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(14000))
                .fluidOutputs(GCMaterials.SphaleriteFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Pentlandite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Pentlandite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Pentlandite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Pentlandite, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(14000))
                .fluidOutputs(GCMaterials.PentlanditeFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Platinum, 64)
                .input(GCOrePrefix.oreMilled, Materials.Platinum, 64)
                .input(GCOrePrefix.oreMilled, Materials.Platinum, 64)
                .input(GCOrePrefix.oreMilled, Materials.Platinum, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(35000))
                .fluidOutputs(GCMaterials.PlatinumFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Grossular, 64)
                .input(GCOrePrefix.oreMilled, Materials.Grossular, 64)
                .input(GCOrePrefix.oreMilled, Materials.Grossular, 64)
                .input(GCOrePrefix.oreMilled, Materials.Grossular, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(28000))
                .fluidOutputs(GCMaterials.GrossularFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefix.oreMilled, Materials.Monazite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Monazite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Monazite, 64)
                .input(GCOrePrefix.oreMilled, Materials.Monazite, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(30000))
                .fluidOutputs(GCMaterials.MonaziteFront.getFluid(1000))
                .buildAndRegister();

    }
}
