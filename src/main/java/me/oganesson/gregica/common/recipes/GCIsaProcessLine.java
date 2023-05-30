package me.oganesson.gregica.common.recipes;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;
import me.oganesson.gregica.common.unification.materials.GCMaterials;
import me.oganesson.gregica.common.unification.materials.ore.GCOrePrefixs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;

import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.gem;
import static me.oganesson.gregica.common.recipes.GCBiologyRecipe.getBiologyCircuitData;
import static me.oganesson.gregica.common.unification.materials.info.GCMaterialFlags.GENERATE_MILLED;

public class GCIsaProcessLine {

    public static void register(){
        OrePrefix.ore.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
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
                .outputs(OreDictUnifier.get(GCOrePrefixs.oreMilled, material, 48))
                .buildAndRegister();

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.crushed, material, 16)
                .circuitMeta(11)
                .getTier(1)
                .duration(1500)
                .EUt(7680)
                .output(GCOrePrefixs.oreMilled, material, 16)
                .buildAndRegister();

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.crushed, material, 16)
                .circuitMeta(10)
                .getTier(2)
                .duration(1200)
                .EUt(7680)
                .output(GCOrePrefixs.oreMilled, material, 32)
                .buildAndRegister();

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.ore, material, 16)
                .circuitMeta(10)
                .getTier(2)
                .duration(2400)
                .EUt(7680)
                .output(GCOrePrefixs.oreMilled, material, 64)
                .output(GCOrePrefixs.oreMilled, material, 32)
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
                .input(Blocks.SAPLING, 32)
                .fluidInputs(Materials.DistilledWater.getFluid(8000))
                .fluidInputs(Materials.Mutagen.getFluid(2000))
                .notConsumable(getBiologyCircuitData(6))
                .EUt(64)
                .duration(2400)
                .output(GCMetaBlocks.PINE_SAPLING, 16)
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
                .chancedOutput(OrePrefix.dust, Materials.Ash, 5, 3000, 15)
                .chancedOutput(OrePrefix.dust, Materials.Ash, 5, 3000, 15)
                .chancedOutput(OrePrefix.dust, Materials.DarkAsh, 5, 3000, 15)
                .chancedOutput(OrePrefix.dust, Materials.DarkAsh, 5, 3000, 15)
                .fluidOutputs(GCMaterials.PineOil.getFluid(500))
                .buildAndRegister();

        GCRecipeMaps.CHEMICAL_PLANT.recipeBuilder()
                .recipeLevel(5)
                .inputs(GCMetaItems.PINE_FRAGMENT.getStackForm(64))
                .fluidInputs(Materials.Steam.getFluid(5000))
                .circuitMeta(18)
                .EUt(120)
                .duration(900)
                .chancedOutput(OrePrefix.dustTiny, Materials.Ash, 5, 3000, 15)
                .chancedOutput(OrePrefix.dustTiny, Materials.Ash, 5, 3000, 15)
                .chancedOutput(OrePrefix.dustTiny, Materials.DarkAsh, 5, 3000, 15)
                .chancedOutput(OrePrefix.dustTiny, Materials.DarkAsh, 5, 3000, 15)
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
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 16, 7500, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 16, 5000, 0)
                .chancedOutput(GCMetaItems.PINE_FRAGMENT, 16, 2500, 0)
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Pyrope, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Pyrope, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Pyrope, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Pyrope, 64)
                .EUt(1920).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(8000))
                .fluidOutputs(GCMaterials.PyropeFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Chalcopyrite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Chalcopyrite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Chalcopyrite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Chalcopyrite, 64)
                .EUt(7680).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(12000))
                .fluidOutputs(GCMaterials.ChalcopyriteFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Redstone, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Redstone, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Redstone, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Redstone, 64)
                .EUt(7680).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(13000))
                .fluidOutputs(GCMaterials.RedstoneFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Nickel, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Nickel, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Nickel, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Nickel, 64)
                .EUt(7680).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(25000))
                .fluidOutputs(GCMaterials.NickelFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Almandine, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Almandine, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Almandine, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Almandine, 64)
                .EUt(7680).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(18000))
                .fluidOutputs(GCMaterials.AlmandineFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Spessartine, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Spessartine, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Spessartine, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Spessartine, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(35000))
                .fluidOutputs(GCMaterials.SpessartineFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Sphalerite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Sphalerite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Sphalerite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Sphalerite, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(14000))
                .fluidOutputs(GCMaterials.SphaleriteFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Pentlandite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Pentlandite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Pentlandite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Pentlandite, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(14000))
                .fluidOutputs(GCMaterials.PentlanditeFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Platinum, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Platinum, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Platinum, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Platinum, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(35000))
                .fluidOutputs(GCMaterials.PlatinumFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.POTASSIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Grossular, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Grossular, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Grossular, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Grossular, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(28000))
                .fluidOutputs(GCMaterials.GrossularFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.FLOTATION_CELL_REGULATOR.recipeBuilder()
                .inputs(GCMetaItems.SODIUM_ETHYLXANTHATE.getStackForm(32))
                .input(GCOrePrefixs.oreMilled, Materials.Monazite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Monazite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Monazite, 64)
                .input(GCOrePrefixs.oreMilled, Materials.Monazite, 64)
                .EUt(30720).duration(9600)
                .fluidInputs(GCMaterials.PineOil.getFluid(30000))
                .fluidOutputs(GCMaterials.MonaziteFront.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.PyropeFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Magnesium, 64)
                .output(OrePrefix.dust, Materials.Magnesium, 46)
                .output(OrePrefix.dust, Materials.Manganese, 64)
                .output(OrePrefix.dust, Materials.Manganese, 6)
                .output(OrePrefix.dust, Materials.Borax, 60)
                .output(OrePrefix.dust, Materials.Rhenium, 20)
                .circuitMeta(10)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(1920).duration(2400).blastFurnaceTemp(3500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.NickelFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Nickel, 64)
                .output(OrePrefix.dust, Materials.Nickel, 64)
                .output(OrePrefix.dust, Materials.Nickel, 22)
                .output(OrePrefix.dust, Materials.Cobalt, 64)
                .output(OrePrefix.dust, Materials.Cobalt, 56)
                .output(OrePrefix.dust, Materials.Rhodium, 32)
                .output(OrePrefix.dust, Materials.Ruthenium, 16)
                .circuitMeta(3)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(7680).duration(2400).blastFurnaceTemp(4500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.RedstoneFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Redstone, 64)
                .output(OrePrefix.dust, Materials.Redstone, 64)
                .output(OrePrefix.dust, Materials.Redstone, 64)
                .output(OrePrefix.dust, Materials.Redstone, 64)
                .output(OrePrefix.dust, Materials.Redstone, 44)
                .output(OrePrefix.dust, Materials.Chrome, 60)
                //TODO FireStone Dust* 45
                .output(OrePrefix.dust, Materials.Dysprosium, 16)
                .circuitMeta(6)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(7680).duration(2400).blastFurnaceTemp(4500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.ChalcopyriteFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Copper, 64)
                .output(OrePrefix.dust, Materials.Copper, 64)
                .output(OrePrefix.dust, Materials.Copper, 52)
                .output(OrePrefix.dust, Materials.Iron, 64)
                .output(OrePrefix.dust, Materials.Iron, 44)
                .output(OrePrefix.dust, Materials.Cadmium, 50)
                .output(OrePrefix.dust, Materials.Indium, 10)
                .circuitMeta(2)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(7680).duration(2400).blastFurnaceTemp(4500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.PlatinumFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Platinum, 64)
                .output(OrePrefix.dust, Materials.Platinum, 64)
                .output(OrePrefix.dust, Materials.Rhodium, 40)
                .output(OrePrefix.dust, Materials.Selenium, 40)
                .output(OrePrefix.dust, Materials.Tellurium, 10)
                .circuitMeta(4)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(30720).duration(2400).blastFurnaceTemp(5500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.SpessartineFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Manganese, 64)
                .output(OrePrefix.dust, Materials.Manganese, 64)
                .output(OrePrefix.dust, Materials.Manganese, 22)
                .output(OrePrefix.dust, Materials.Aluminium, 64)
                .output(OrePrefix.dust, Materials.Aluminium, 26)
                .output(OrePrefix.dust, Materials.RarestMetalMixture, 30)
                .output(OrePrefix.dust, Materials.Strontium, 20)
                .circuitMeta(7)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(30720).duration(2400).blastFurnaceTemp(5500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.AlmandineFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Aluminium, 64)
                .output(OrePrefix.dust, Materials.Aluminium, 64)
                .output(OrePrefix.dust, Materials.Aluminium, 22)
                .output(OrePrefix.dust, Materials.Manganese, 64)
                .output(OrePrefix.dust, Materials.Manganese, 26)
                .output(OrePrefix.dust, Materials.Yttrium, 25)
                .output(OrePrefix.dust, Materials.Ytterbium, 15)
                .circuitMeta(9)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(30720).duration(2400).blastFurnaceTemp(5500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.SphaleriteFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Zinc, 64)
                .output(OrePrefix.dust, Materials.Zinc, 64)
                .output(OrePrefix.dust, Materials.Zinc, 52)
                .output(OrePrefix.dust, Materials.Iron, 64)
                .output(OrePrefix.dust, Materials.Iron, 56)
                .output(OrePrefix.dust, Materials.Indium, 64)
                .output(OrePrefix.dust, Materials.Germanium, 15)
                .circuitMeta(1)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(30720).duration(2400).blastFurnaceTemp(5500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.PentlanditeFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Iron, 64)
                .output(OrePrefix.dust, Materials.Iron, 64)
                .output(OrePrefix.dust, Materials.Iron, 22)
                .output(OrePrefix.dust, Materials.Nickel, 64)
                .output(OrePrefix.dust, Materials.Nickel, 36)
                .output(OrePrefix.dust, Materials.Promethium, 20)
                .output(OrePrefix.dust, Materials.Hafnium, 10)
                .circuitMeta(5)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(30720).duration(2400).blastFurnaceTemp(5500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.GrossularFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Calcium, 64)
                .output(OrePrefix.dust, Materials.Calcium, 64)
                .output(OrePrefix.dust, Materials.Calcium, 52)
                .output(OrePrefix.dust, Materials.Aluminium, 64)
                .output(OrePrefix.dust, Materials.Aluminium, 46)
                .output(OrePrefix.dust, Materials.Tungsten, 60)
                .output(OrePrefix.dust, Materials.Thallium, 15)
                .circuitMeta(8)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(30720).duration(2400).blastFurnaceTemp(5500)
                .buildAndRegister();

        GCRecipeMaps.VACUUM_FURNACE.recipeBuilder()
                .fluidInputs(GCMaterials.MonaziteFront.getFluid(4000))
                .output(OrePrefix.dust, Materials.Erbium, 64)
                .output(OrePrefix.dust, Materials.Lanthanum, 32)
                .output(OrePrefix.dust, Materials.Lutetium, 16)
                .output(OrePrefix.dust, Materials.Europium, 8)
                .circuitMeta(11)
                .fluidOutputs(GCMaterials.RedMud.getFluid(2000))
                .fluidOutputs(Materials.Water.getFluid(2000))
                .EUt(122880).duration(2400).blastFurnaceTemp(5500)
                .buildAndRegister();
    }
}
