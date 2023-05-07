package me.oganesson.gregica.common.recipes.circuits;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.items.MetaItems.SILICON_BOULE;
import static gregtech.common.items.MetaItems.SILICON_WAFER;
import static gregtech.common.items.ToolItems.*;
import static me.oganesson.gregica.common.item.metaitems.GCMetaItems.*;
import static gregtech.api.unification.material.Materials.*;
import static me.oganesson.gregica.common.item.metaitems.GCMetaItems.VACUUM_TUBE;
import static me.oganesson.gregica.common.unification.materials.GCMaterials.*;
import static me.oganesson.gregica.api.recipe.GCRecipeMaps.*;

public class ChipRecipes {
    // Lithography Arrays

    static MetaItem<?>.MetaValueItem[] boule = {SILICON_BOULE, ANTIMONY_DOPED_SILICON_BOULE, BORON_DOPED_SILICON_BOULE, GALLIUM_ARSENIDE_BOULE, SILVER_GALLIUM_SELENIDE_BOULE};
    static MetaItem<?>.MetaValueItem[] rawWafer = {SILICON_WAFER, ANTIMONY_DOPED_SILICON_WAFER, BORON_DOPED_SILICON_WAFER, GALLIUM_ARSENIDE_WAFER, SILVER_GALLIUM_SELENIDE_WAFER};
    static MetaItem<?>.MetaValueItem[] layered = {LAYERED_SILICON_WAFER, LAYERED_ANTIMONY_DOPED_SILICON_WAFER, LAYERED_BORON_DOPED_SILICON_WAFER, LAYERED_GALLIUM_ARSENIDE_WAFER, LAYERED_SILVER_GALLIUM_SELENIDE_WAFER};
    static MetaItem<?>.MetaValueItem[] prepared = {PREPARED_SILICON_WAFER, PREPARED_ANTIMONY_DOPED_SILICON_WAFER, PREPARED_BORON_DOPED_SILICON_WAFER, PREPARED_GALLIUM_ARSENIDE_WAFER, PREPARED_SILVER_GALLIUM_SELENIDE_WAFER};
    static MetaItem<?>.MetaValueItem[] lithPrep = {INTEGRATED_WAFER_LITHOGRAPHY_PREP, MICRO_WAFER_LITHOGRAPHY_PREP, NANO_WAFER_LITHOGRAPHY_PREP, IMC_WAFER_LITHOGRAPHY_PREP, OPTICAL_WAFER_LITHOGRAPHY_PREP};
    static MetaItem<?>.MetaValueItem[] prebaked = {PREBAKED_INTEGRATED_WAFER, PREBAKED_MICRO_WAFER, PREBAKED_NANO_WAFER, PREBAKED_IMC_WAFER, PREBAKED_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] treated = {TREATED_INTEGRATED_WAFER, TREATED_MICRO_WAFER, TREATED_NANO_WAFER, TREATED_IMC_WAFER, TREATED_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] raw = {RAW_INTEGRATED_WAFER, RAW_MICRO_WAFER, RAW_NANO_WAFER, RAW_IMC_WAFER, RAW_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] baked = {BAKED_INTEGRATED_WAFER, BAKED_MICRO_WAFER, BAKED_NANO_WAFER, BAKED_IMC_WAFER, BAKED_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] wafer = {INTEGRATED_WAFER, MICRO_WAFER, NANO_WAFER, IMC_WAFER, OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] etched = {ETCHED_INTEGRATED_WAFER, ETCHED_MICRO_WAFER, ETCHED_NANO_WAFER, ETCHED_IMC_WAFER, ETCHED_OPTICAL_WAFER};
    static MetaItem<?>.MetaValueItem[] chip = {INTEGRATED_CHIP, MICRO_CHIP, NANO_CHIP, IMC_CHIP, OPTICAL_CHIP};

    static MetaItem<?>.MetaValueItem[] hardMask = {INTEGRATED_HARD_MASK, MICRO_HARD_MASK, NANO_HARD_MASK, IMC_HARD_MASK, OPTICAL_HARD_MASK};
    static Material[] conductor = {Copper, NickelPlatedTin, Electrum, Platinum, ZBLANGlass};
    static MetaItem<?>.MetaValueItem[] uvEmitter = {UVEMITTER_A, UVEMITTER_B, UVEMITTER_C, UVEMITTER_D, UVEMITTER_E};
    static Material[] polymer = {Polyethylene, PolyvinylChloride, Polytetrafluoroethylene, PolyphenyleneSulfide, Ladder_Poly_P_Phenylene};
    static Material[] printMaterial = {Polyethylene, PolyvinylChloride, Polytetrafluoroethylene, PolyphenyleneSulfide, Polybenzimidazole};
    static Material[] photopolymers = {HydrogenSilsesquioxane, HydrogenSilsesquioxane, HydrogenSilsesquioxane, SU8_Photoresist, SU8_Photoresist};

    public static void registerChips(){
        vacuumTubes();
        electronicChip();
        lithographyChips();
        crystalChip();
        wetwareChip();
        biowareChip();
        quantumChip();
        exoticChip();
        cosmicChip();
        supraChip();
    }

    private static void vacuumTubes() {
        ModHandler.removeRecipeByOutput(GCMetaItems.VACUUM_TUBE_COMPONENTS.getStackForm());
        ModHandler.addShapedRecipe("vacuum_tube_components_lead", VACUUM_TUBE_COMPONENTS.getStackForm(),
                " W ","BFB"," W ",
                'B', new UnificationEntry(bolt, Steel),
                'W', new UnificationEntry(wireFine, Copper),
                'F', new UnificationEntry(foil, Lead));

        ModHandler.addShapedRecipe("vacuum_tube_components_gold", VACUUM_TUBE_COMPONENTS.getStackForm(2),
                " W ","BFB"," W ",
                'B', new UnificationEntry(bolt, Steel),
                'W', new UnificationEntry(wireFine, Copper),
                'F', new UnificationEntry(foil, Gold));

        COMPRESSOR_RECIPES.recipeBuilder()
                .duration(130)
                .EUt(8)
                .input(GLASS_TUBE)
                .output(EVACUATED_TUBE)
               .buildAndRegister();

        ModHandler.addShapelessRecipe("evacuated_tube", EVACUATED_TUBE.getStackForm(),
                GLASS_TUBE.getStackForm(),
                PLUNGER
        );

        ModHandler.addShapelessRecipe("vacuum_tube", VACUUM_TUBE.getStackForm(),
                EVACUATED_TUBE.getStackForm(),
                VACUUM_TUBE_COMPONENTS.getStackForm(),
                OreDictUnifier.get(ring, Kovar)
        );

    }

    private static void electronicChip() {

        CUTTER_RECIPES.recipeBuilder()
                .duration(80)
                .EUt(VA[LV])
                .input(plate, Silicon)
                .output(SIMPLE_SILICON_WAFER, 4)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .duration(100)
                .EUt(VA[LV])
                .input(SIMPLE_SILICON_WAFER)
                .notConsumable(craftingLens, Glass)
                .output(SIMPLE_CPU_WAFER)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .duration(100)
                .EUt(VA[LV])
                .input(SIMPLE_CPU_WAFER)
                .output(SIMPLE_CPU,4)
                .buildAndRegister();
    }

    private static void lithographyChips() {

        //Boule Recipes

        BLAST_RECIPES.recipeBuilder()
                .blastFurnaceTemp(1100)
                .duration(420)
                .EUt(VA[LV])
                .input(dust, Silicon, 16)
                .notConsumable(INTEGRATED_CIRCUIT)
                .output(GCMetaItems.SILICON_BOULE)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .blastFurnaceTemp(2100)
                .duration(420)
                .EUt(VA[LV])
                .input(dust, Silicon, 16)
                .input(dustSmall, Antimony)
                .output(ANTIMONY_DOPED_SILICON_BOULE)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .blastFurnaceTemp(3100)
                .duration(420)
                .EUt(VA[LV])
                .input(dust, Silicon, 16)
                .input(dustSmall, Boron)
                .output(BORON_DOPED_SILICON_BOULE)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .blastFurnaceTemp(3900)
                .duration(420)
                .EUt(VA[LV])
                .input(dust, GalliumArsenide, 16)
                .output(GALLIUM_ARSENIDE_BOULE)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .blastFurnaceTemp(4800)
                .duration(420)
                .EUt(VA[LV])
                .input(dust, SilverGalliumSelenide, 16)
                .output(SILVER_GALLIUM_SELENIDE_BOULE)
                .buildAndRegister();

        //UV Emitter Recipes
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[LV])
                .input(RESISTOR)
                .input(wireFine, Steel, 4)
                .input(wireFine, AnnealedCopper, 4)
                .output(BALLAST)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(130)
                .EUt(VA[LV])
                .input(GLASS_TUBE)
                .input(wireFine, Cobalt)
                .input(ring, Kovar)
                .output(EMPTY_GEISSLER_TUBE)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(85)
                .EUt(VA[LV])
                .input(BALLAST)
                .input(EMPTY_GEISSLER_TUBE)
                .input(plate, SterlingSilver, 2)
                .input(wireFine, AnnealedCopper, 2)
                .fluidInputs(Mercury.getFluid(125))
                .output(UVEMITTER_A)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(140)
                .EUt(VA[MV])
                .input(wireFine, Carbon)
                .input(GLASS_TUBE)
                .input(ring, StainlessSteel)
                .fluidInputs(SolderingAlloy.getFluid(144))
                .output(EMPTY_ARC_LAMP)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .duration(20)
                .EUt(VA[MV])
                .input(EMPTY_ARC_LAMP)
                .fluidInputs(Hydrogen.getFluid(1000))
                .output(UVEMITTER_B)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .duration(20)
                .EUt(VA[HV])
                .input(EMPTY_ARC_LAMP)
                .fluidInputs(Deuterium.getFluid(1000))
                .output(UVEMITTER_C)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[EV])
                .fluidInputs(Neon.getFluid(1000))
                .fluidInputs(Fluorine.getFluid(1000))
                .fluidOutputs(NeonFluoride.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(135)
                .fluidInputs(NeonFluoride.getFluid(1000))
                .notConsumable(plate, NeodymiumMagnetic)
                .notConsumable(Hydrogen.getFluid(500))
                .fluidOutputs(ExcitedNeonFluoride.getFluid(1000))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(185)
                .EUt(VA[EV])
                .input(ELECTRIC_PUMP_EV)
                .input(ring, SiliconeRubber)
                .input(GLASS_TUBE)
                .input(wireFine, Platinum, 4)
                .input(wireFine, Polyethylene, 4)
                .fluidInputs(ExcitedNeonFluoride.getFluid(1000))
                .output(UVEMITTER_D)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(25)
                .EUt(VA[EV])
                .input(foil, ErbiumDopedZBLANGlass)
                .input(foil, Germanium)
                .input(plate, PolyphenyleneSulfide)
                .fluidInputs(HydrogenSulfide.getFluid(100))
                .output(REFLECTING_SHEET)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(65)
                .EUt(VA[IV])
                .input(wireFine, Osmium)
                .input(springSmall, NiobiumTitanium)
                .input(REFLECTING_SHEET)
                .fluidInputs(BorosilicateGlass.getFluid(288))
                .output(LASER_TUBE)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[LV])
                .fluidInputs(Argon.getFluid(1000))
                .fluidInputs(Fluorine.getFluid(1000))
                .fluidOutputs(ArgonFluorine.getFluid(1000))
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .duration(110)
                .EUt(VA[EV])
                .input(LASER_TUBE)
                .fluidInputs(ArgonFluorine.getFluid(100))
                .output(UVEMITTER_E)
                .buildAndRegister();

        //HARDMASK recipe generation

        EXTRUDER_RECIPES.recipeBuilder()
                .EUt(24)
                .duration(15)
                .input(dust, Ladder_Poly_P_Phenylene)
                .notConsumable(SHAPE_EXTRUDER_FOIL)
                .output(foil, Ladder_Poly_P_Phenylene, 4)
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .EUt(24)
                .duration(15)
                .input(ingot, Ladder_Poly_P_Phenylene)
                .notConsumable(SHAPE_EXTRUDER_FOIL)
                .output(foil, Ladder_Poly_P_Phenylene, 4)
                .buildAndRegister();

        /*
        for (int i = 0; i < hardMask.length; i++) {
            for (int j = 0; j < printMaterial.length; j++) {
                PRINTER_RECIPES.recipeBuilder()
                        .input(wireFine, printMaterial[j], (48 / (j + 1)))
                        .circuitMeta(i)
                        .output(hardMask[i])
                        .EUt(VA[i + 1])
                        .duration(300)
                        .buildAndRegister();
            }

        }

         */

        //Wafer generation for each type
        for (int i = 0; i < boule.length; i++) {
            int tierPower = VA[i + 1];


            CUTTER_RECIPES.recipeBuilder()
                    .input(boule[i])
                    .output(rawWafer[i], 16*(i+1))
                    .EUt(VA[LV])
                    .duration(400)
                    .buildAndRegister();

            LAMINATOR_RECIPES.recipeBuilder()
                    .input(rawWafer[i])
                    .input(foil, conductor[i])
                    .fluidInputs(Polyethylene.getFluid(16))
                    .output(layered[i])
                    .EUt(VA[LV])
                    .duration(400)
                    .buildAndRegister();

            LAMINATOR_RECIPES.recipeBuilder()
                    .input(layered[i])
                    .input(foil, polymer[i], 4)
                    .output(prepared[i])
                    .EUt(VA[LV])
                    .duration(200)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(prepared[i])
                    .input(hardMask[i])
                    .output(lithPrep[i])
                    .EUt(VA[LV])
                    .duration(20)
                    .buildAndRegister();

            FURNACE_RECIPES.recipeBuilder()
                    .input(lithPrep[i])
                    .output(prebaked[i])
                    .EUt(VA[LV])
                    .duration(600)
                    .buildAndRegister();

            CHEMICAL_BATH_RECIPES.recipeBuilder()
                    .input(prebaked[i])
                    .fluidInputs(photopolymers[i].getFluid(200 * (i + 1)))
                    .output(dust, polymer[i])
                    .output(treated[i])
                    .EUt(tierPower)
                    .duration(VA[LV])
                    .buildAndRegister();

            if (i < 3) {
                CHEMICAL_BATH_RECIPES.recipeBuilder()
                        .input(prebaked[i])
                        .fluidInputs(SU8_Photoresist.getFluid(100 * (i + 1)))
                        .output(dust, polymer[i])
                        .output(treated[i])
                        .EUt(tierPower)
                        .duration(VA[LV])
                        .buildAndRegister();
            }

            for (int j = i; j < uvEmitter.length; j++) {
                LASER_ENGRAVER_RECIPES.recipeBuilder()
                        .input(treated[i])
                        .notConsumable(uvEmitter[j])
                        .output(raw[i])
                        .EUt(tierPower)
                        .duration(100)
                        .buildAndRegister();
            }

            FURNACE_RECIPES.recipeBuilder()
                    .input(raw[i])
                    .output(baked[i])
                    .EUt(VA[LV])
                    .duration(600)
                    .buildAndRegister();

            PACKER_RECIPES.recipeBuilder()
                    .input(baked[i])
                    .outputs(wafer[i].getStackForm(), hardMask[i].getStackForm())
                    .EUt(VA[LV])
                    .duration(200)
                    .buildAndRegister();

            CHEMICAL_BATH_RECIPES.recipeBuilder()
                    .input(wafer[i])
                    .fluidInputs(NitricAcid.getFluid(25 * (i + 1)))
                    .output(etched[i])
                    .EUt(VA[LV])
                    .duration(20)
                    .buildAndRegister();

            CUTTER_RECIPES.recipeBuilder()
                    .input(etched[i])
                    .output(chip[i], 8)
                    .EUt(VA[LV])
                    .duration(20)
                    .buildAndRegister();
        }
    }

    private static void crystalChip() {
        //TODO: CARBON - Integrate with starlight in TJ2
        /*
        CVD_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(100)
                .input(SAPPHIRE_WAFER)
                .fluidInputs(Methane.getFluid(1000))
                .notConsumable(Argon.getFluid(1))
                .output(COATED_SAPPHIRE_WAFER)
                .fluidOutputs(Hydrogen.getFluid(4000))
                .buildAndRegister();

         */

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(100)
                .input(COATED_SAPPHIRE_WAFER)
                .fluidInputs(Starlight.getFluid(250))
                .output(DIRTY_COATED_SAPPHIRE_WAFER)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(60)
                .input(DIRTY_COATED_SAPPHIRE_WAFER)
                .fluidInputs(Dysprosium.getFluid(144))
                .output(CLEANED_COATED_SAPPHIRE_WAFER)
                .output(ingot, Dysprosium) //TODO 4 Chunks
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(5)
                .input(CLEANED_COATED_SAPPHIRE_WAFER)
                .fluidInputs(Helium.getPlasma(150))
                .output(SAPPHIRE_SUBSTRATE_PREP)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(130)
                .input(SAPPHIRE_SUBSTRATE_PREP)
                .fluidInputs(AquaRegia.getFluid(250))
                .output(ETCHED_SAPPHIRE_WAFER)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(340)
                .blastFurnaceTemp(8600)
                .input(ETCHED_SAPPHIRE_WAFER)
                .notConsumable(Argon.getFluid(1))
                .output(SUPERHEATED_SAPPHIRE_WAFER)
                .buildAndRegister();

        //TODO: ANYONE - Find a way to either/or viable/nonviable here
        VACUUM_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(40)
                .input(SUPERHEATED_SAPPHIRE_WAFER)
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(VIABLE_SAPPHIRE_WAFER)
                .fluidOutputs(Steam.getFluid(1000))
                //.chancedOutput(NONVIABLE_SAPPHIRE_WAFER, 5000)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(1000)
                .input(NONVIABLE_SAPPHIRE_WAFER)
                .fluidInputs(Starlight.getFluid(500))
                .output(RECYCLED_SAPPHIRE_WAFER)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(10)
                .input(RECYCLED_SAPPHIRE_WAFER)
                .fluidInputs(Dysprosium.getFluid(288))
                .output(CLEANED_COATED_SAPPHIRE_WAFER)
                .output(ingot ,Dysprosium,2)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(140)
                .input(VIABLE_SAPPHIRE_WAFER)
                .input(foil, Rutherfordium)
                .fluidInputs()
                .output(SINTERED_SAPPHIRE_WAFER)
                .buildAndRegister();


        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(30)
                .input(wireFine,Palladium)
                .input(SINTERED_SAPPHIRE_WAFER)
                .output(WIRED_SAPPHIRE_WAFER)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .EUt(VA[ZPM])
                .duration(30)
                .input(WIRED_SAPPHIRE_WAFER)
                .output(RAW_SAPPHIRE_CHIP,32)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(65)
                .input(RAW_SAPPHIRE_CHIP)
                .fluidInputs(Neon.getFluid(10))
                .output(SAPPHIRE_CHIP)
                .buildAndRegister();
    }

    private static void wetwareChip() {

    }

    private static void biowareChip() {

    }

    private static void quantumChip() {

    }

    private static void exoticChip() {

    }

    private static void cosmicChip() {

    }

    private static void supraChip() {

    }
}
