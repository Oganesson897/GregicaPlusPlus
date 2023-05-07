package me.oganesson.gregica.common.recipes.circuits;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;
import gregtech.common.items.ToolItems;
import me.oganesson.gregica.common.item.metaitems.GCMetaItem2;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;

import java.util.ArrayList;
import java.util.List;

import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static me.oganesson.gregica.api.recipe.GCRecipeMaps.*;
import static me.oganesson.gregica.common.item.metaitems.GCMetaItems.VACUUM_TUBE;
import static me.oganesson.gregica.common.unification.materials.GCMaterials.*;
import static me.oganesson.gregica.common.item.metaitems.GCMetaItems.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.metatileentity.multiblock.CleanroomType.CLEANROOM;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class CircuitRecipes {
    /*
    public static void registerCircuits() {
        removePreexistingCircuits();
        removeOldWafers();
        SMDRecipes.registerSMDRecipes();
        ChipRecipes.registerChips();
        registerBoards();
        registerRecipes();
        registerSolder();
    }

    private static void removePreexistingCircuits() {
        oreDictHandling();
        GTRecipeHandler.removeAllRecipes(CIRCUIT_ASSEMBLER_RECIPES);
        GTRecipeHandler.removeAllRecipes(ASSEMBLY_LINE_RECIPES);
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Carbon, 4)}, new FluidStack[]{Polyethylene.getFluid(36)});
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Carbon, 4)}, new FluidStack[]{Polytetrafluoroethylene.getFluid(18)});
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Carbon, 4)}, new FluidStack[]{Epoxy.getFluid(9)});
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Carbon, 8)}, new FluidStack[]{Polybenzimidazole.getFluid(9)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{CARBON_FIBERS.getStackForm(1)}, new FluidStack[]{Epoxy.getFluid(144)});
        GTRecipeHandler.removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, BorosilicateGlass)}, new FluidStack[]{Epoxy.getFluid(144)});
        ModHandler.removeRecipeByOutput(ELECTRONIC_CIRCUIT_LV.getStackForm());
        ModHandler.removeRecipeByOutput(ELECTRONIC_CIRCUIT_MV.getStackForm());
        ModHandler.removeRecipeByOutput(MetaItems.VACUUM_TUBE.getStackForm());
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{GLASS_TUBE.getStackForm(), OreDictUnifier.get(bolt, Steel), OreDictUnifier.get(wireGtSingle, AnnealedCopper, 2)}, new FluidStack[]{RedAlloy.getFluid(18)});
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{GLASS_TUBE.getStackForm(), OreDictUnifier.get(bolt, Steel), OreDictUnifier.get(wireGtSingle, Copper, 2)}, new FluidStack[]{RedAlloy.getFluid(18)});
        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{GLASS_TUBE.getStackForm(), OreDictUnifier.get(bolt, Steel), OreDictUnifier.get(wireGtSingle, Copper, 2), IntCircuitIngredient.getIntegratedCircuit(1)});
        SMD_CAPACITOR.setInvisible();
        SMD_DIODE.setInvisible();
        SMD_INDUCTOR.setInvisible();
        SMD_TRANSISTOR.setInvisible();
        SMD_RESISTOR.setInvisible();
        ADVANCED_SMD_CAPACITOR.setInvisible();
        ADVANCED_SMD_RESISTOR.setInvisible();
        ADVANCED_SMD_TRANSISTOR.setInvisible();
        ADVANCED_SMD_DIODE.setInvisible();
        ADVANCED_SMD_INDUCTOR.setInvisible();
        BASIC_CIRCUIT_BOARD.setInvisible();
        COATED_BOARD.setInvisible();
        PHENOLIC_BOARD.setInvisible();
        PLASTIC_BOARD.setInvisible();
        EPOXY_BOARD.setInvisible();
        FIBER_BOARD.setInvisible();
        MULTILAYER_FIBER_BOARD.setInvisible();
        MetaItems.WETWARE_BOARD.setInvisible();
        ADVANCED_CIRCUIT_BOARD.setInvisible();
        PLASTIC_CIRCUIT_BOARD.setInvisible();
        GOOD_CIRCUIT_BOARD.setInvisible();
        ELITE_CIRCUIT_BOARD.setInvisible();
        EXTREME_CIRCUIT_BOARD.setInvisible();
        WETWARE_CIRCUIT_BOARD.setInvisible();
    }

    private static void removeOldWafers() {
        MetaItems.SILICON_BOULE.setInvisible();
        MetaItems.SILICON_WAFER.setInvisible();
        GLOWSTONE_BOULE.setInvisible();
        GLOWSTONE_WAFER.setInvisible();
        NAQUADAH_BOULE.setInvisible();
        NAQUADAH_WAFER.setInvisible();
        NEUTRONIUM_BOULE.setInvisible();
        NEUTRONIUM_WAFER.setInvisible();
        STEM_CELLS.setInvisible();
        NEURO_PROCESSOR.setInvisible();
        CRYSTAL_SYSTEM_ON_CHIP.setInvisible();
        CRYSTAL_CENTRAL_PROCESSING_UNIT.setInvisible();
        ENGRAVED_CRYSTAL_CHIP.setInvisible();
        RAW_CRYSTAL_CHIP_PART.setInvisible();
        RAW_CRYSTAL_CHIP.setInvisible();
        CENTRAL_PROCESSING_UNIT_WAFER.setInvisible();
        CENTRAL_PROCESSING_UNIT.setInvisible();
        RANDOM_ACCESS_MEMORY_WAFER.setInvisible();
        RANDOM_ACCESS_MEMORY.setInvisible();
        INTEGRATED_LOGIC_CIRCUIT_WAFER.setInvisible();
        INTEGRATED_LOGIC_CIRCUIT.setInvisible();
        NANO_CENTRAL_PROCESSING_UNIT_WAFER.setInvisible();
        NANO_CENTRAL_PROCESSING_UNIT.setInvisible();
        QUBIT_CENTRAL_PROCESSING_UNIT_WAFER.setInvisible();
        QUBIT_CENTRAL_PROCESSING_UNIT.setInvisible();
        SYSTEM_ON_CHIP_WAFER.setInvisible();
        SYSTEM_ON_CHIP.setInvisible();
        SIMPLE_SYSTEM_ON_CHIP_WAFER.setInvisible();
        SIMPLE_SYSTEM_ON_CHIP.setInvisible();
        ADVANCED_SYSTEM_ON_CHIP_WAFER.setInvisible();
        ADVANCED_SYSTEM_ON_CHIP.setInvisible();
        HIGHLY_ADVANCED_SOC_WAFER.setInvisible();
        HIGHLY_ADVANCED_SOC.setInvisible();
        NAND_MEMORY_CHIP_WAFER.setInvisible();
        NAND_MEMORY_CHIP.setInvisible();
        NOR_MEMORY_CHIP_WAFER.setInvisible();
        NOR_MEMORY_CHIP.setInvisible();
    }

    private static void oreDictHandling() {
        List<String> toRemove = new ArrayList<>();
        toRemove.add("circuitUlv");
        toRemove.add("circuitLv");
        toRemove.add("circuitMv");
        toRemove.add("circuitHv");
        toRemove.add("circuitEv");
        toRemove.add("circuitIv");
        toRemove.add("circuitLuv");
        toRemove.add("circuitZpm");
        toRemove.add("circuitUv");
        toRemove.add("circuitUhv");
        toRemove.add("circuitUev");
        toRemove.add("circuitUiv");
        toRemove.add("circuitUxv");
        toRemove.add("circuitOpv");
        toRemove.add("circuitMax");
        for (String oredict : toRemove) {
            List<ItemStack> list = OreDictionary.getOres(oredict, false);
            for (int i = 0; i < list.size(); i++) {
                ItemStack stack = list.get(i);
                if (!(stack.getItem() instanceof GCMetaItem2)) {
                    MetaItem<?>.MetaValueItem valueItem = ((MetaItem) stack.getItem()).getItem(stack);
                    valueItem.setInvisible();
                    list.remove(i);
                    i--;
                }
            }
        }
    }

    private static void registerSolder() {
        ModHandler.addShapelessRecipe("soldering_alloy", OreDictUnifier.get(dust, SolderingAlloy, 9),
                OreDictUnifier.get(dust, Tin),
                OreDictUnifier.get(dust, Tin),
                OreDictUnifier.get(dust, Tin),
                OreDictUnifier.get(dust, Tin),
                OreDictUnifier.get(dust, Tin),
                OreDictUnifier.get(dust, Lead),
                OreDictUnifier.get(dust, Lead),
                OreDictUnifier.get(dust, Lead),
                OreDictUnifier.get(dust, Antimony));
    }

    private static void registerBoards() {
        primitiveBoard();
        electronicBoard();
        integratedBoard();
        microBoard();
        nanoBoard();
        imcBoard();
        opticalBoard();
        crystalBoard();
        wetwareBoard();
        biowareBoard();
        quantumBoard();
        exoticBoard();
        cosmicBoard();
        supraBoard();
    }

    private static void registerRecipes() {
        primitive();
        electronic();
        integrated();
        micro();
        nano();
        imc();
        optical();
        crystal();
    }

    private static void primitiveBoard() {
        //Primitive Point to Point PCB
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Wood, 4)
                .fluidInputs(Creosote.getFluid(500))
                .output(WETPHENOLICPULP)
                .EUt(8)
                .duration(20)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .input(WETPHENOLICPULP)
                .output(WETPRESSEDPHENOLICSUBSTRATE)
                .EUt(8)
                .duration(20)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .input(WETPRESSEDPHENOLICSUBSTRATE)
                .output(PRIMITIVE_PREBOARD)
                .EUt(8)
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapelessRecipe("primitive_board", PRIMITIVE_BOARD.getStackForm(1),
                new UnificationEntry(wireFine, Copper),
                new UnificationEntry(wireFine, Copper),
                PRIMITIVE_PREBOARD.getStackForm());

    }

    private static void electronicBoard() {

        ///Silicate Stenciled PCB

        LAMINATOR_RECIPES.recipeBuilder()
                .input(plate, SilicaCeramic)
                .input(foil, Copper, 2)
                .output(ELECTRONIC_PREBOARD)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        ModHandler.addShapelessRecipe("electronic_board", ELECTRONIC_BOARD.getStackForm(1),
                new UnificationEntry(foil, SilicaCeramic),
                ToolItems.KNIFE.getOreDictName(),
                ELECTRONIC_PREBOARD.getStackForm());
    }

    private static void integratedBoard() {
        Material[] laminatorFluids = {Polyethylene, PolyvinylChloride, Polytetrafluoroethylene, Polybenzimidazole};
        //Machine Stenciled PCB
        for (int i = 0; i < laminatorFluids.length; i++) {
            LAMINATOR_RECIPES.recipeBuilder()
                    .input(plate, Polyethylene)
                    .input(foil, Copper, 2)
                    .fluidInputs(laminatorFluids[i].getFluid(144 / (i + 1)))
                    .output(INTEGRATED_PREBOARD, i + 1)
                    .EUt(30)
                    .duration(20)
                    .buildAndRegister();
        }

        ModHandler.addShapedRecipe("stencil_cutting_head", STENCILING_CUTHEAD.getStackForm(),
                "RP ", "RG ", "SL ",
                'R', OreDictUnifier.get(stick, Steel),
                'P', OreDictUnifier.get(plate, Steel),
                'G', OreDictUnifier.get(gear, Steel),
                'L', OreDictUnifier.get(springSmall, Steel),
                'S', OreDictUnifier.get(screw, Steel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(INTEGRATED_PREBOARD)
                .input(foil, Polyethylene)
                .notConsumable(STENCILING_CUTHEAD)
                .output(INTEGRATED_BOARD)
                .EUt(VA[LV])
                .duration(40)
                .buildAndRegister();
    }

    private static void microBoard() {
        //Simple Etched PCB

        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(500)
                .duration(50)
                .input(foil, Epoxy, 2)
                .input(foil, AnnealedCopper, 2)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(COPPER_LAMINATED_EPOXID)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(120)
                .duration(50)
                .input(COPPER_LAMINATED_EPOXID)
                .input(foil, Polyethylene)
                .output(MICRO_PREBOARD)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(35)
                .input(MICRO_PREBOARD)
                .fluidInputs(NitricAcid.getFluid(50))
                .output(MICRO_BOARD)
                .buildAndRegister();
    }

    private static void nanoBoard() {
        //Reinforced Etched PCB
        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(2000)
                .duration(20)
                .input(foil, Epoxy, 2)
                .input(foil, Electrum)
                .input(foil, Fiberglass)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(ELECTRUM_LAMINATED_EPOXID, 2)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(500)
                .duration(55)
                .input(ELECTRUM_LAMINATED_EPOXID)
                .input(foil, Polyethylene)
                .output(NANO_PREBOARD)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(80)
                .input(NANO_PREBOARD)
                .fluidInputs(NitricAcid.getFluid(50))
                .output(NANO_BOARD)
                .buildAndRegister();
    }

    private static void imcBoard() {
        //Multi-Layer Etched PCB
        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[MV])
                .duration(150)
                .input(wireFine, Fiberglass)
                .output(FIBERGLASS_MESH, 2)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(50)
                .input(FIBERGLASS_MESH)
                .fluidInputs(Epoxy.getFluid(72))
                .output(plate, ReinforcedEpoxyResin)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(60)
                .input(plate, ReinforcedEpoxyResin, 4)
                .input(foil, Germanium)
                .input(foil, Fiberglass)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(GERMANIUM_LAMINATED_EPOXID, 2)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(55)
                .input(GERMANIUM_LAMINATED_EPOXID)
                .input(foil, Polyethylene)
                .output(IMC_PREBOARD)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[LV])
                .duration(80)
                .input(IMC_PREBOARD)
                .fluidInputs(NitricAcid.getFluid(50))
                .output(IMC_BOARD)
                .buildAndRegister();

    }

    private static void opticalBoard() {
        //Optical Integrated PCB
        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(20)
                .input(wireFine, ZBLANGlass)
                .fluidInputs(Europium.getFluid(16))
                .output(ZBLANMATRIX)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(20)
                .input(ZBLANMATRIX)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(144))
                .output(OPTICAL_BASE)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .EUt(VA[IV])
                .duration(40)
                .input(OPTICAL_BASE)
                .input(dustSmall, IndiumPhosphide)
                .input(foil, ErbiumDopedZBLANGlass)
                .output(LAMINATED_OPTICAL_BASE)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[LuV])
                .duration(60)
                .input(dustSmall, LuminescentSiliconNanocrystals)
                .input(LAMINATED_OPTICAL_BASE)
                .fluidInputs(SeleniumMonobromide.getFluid(50))
                .output(OPTICAL_PREBOARD)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[EV])
                .duration(20)
                .input(wireFine, ZBLANGlass, 4)
                .input(OPTICAL_PREBOARD)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(50))
                .output(OPTICAL_BOARD)
                .buildAndRegister();
    }

    private static void crystalBoard() {
        FSZM_RECIPES.recipeBuilder()
                .duration(80)
                .EUt(VA[EV])
                .input(SAPPHIRE_WAFER)
                .fluidInputs(Argon.getFluid(50))
                .output(PROCESSED_CRYSTAL_WAFER)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(140)
                .EUt(VA[IV])
                .input(dust, HafniumSilicate, 4)
                .input(wireFine, Rhodium)
                .output(CRYSTAL_SFET_BUNDLE, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(90)
                .EUt(VA[ZPM])
                .input(PROCESSED_CRYSTAL_WAFER)
                .input(CRYSTAL_SFET_BUNDLE, 4)
                .output(CRYSTAL_SFET_WAFER)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(55)
                .EUt(VA[EV])
                .input(foil, Germanium, 2)
                .input(foil, PraseodymiumDopedZBLANGlass)
                .input(plate, ReinforcedEpoxyResin)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(72))
                .output(REFRACTING_SHEET)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(105)
                .EUt(VA[EV])
                .input(REFRACTING_SHEET)
                .input(CRYSTAL_SFET_WAFER)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(288))
                .output(LAMINATED_CRYSTAL_PCB_SHEET)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .duration(20)
                .EUt(VA[MV])
                .input(dust, Cobalt60)
                .input(foil, Lead)
                .output(GAMMA_EMITTING_DIODE, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(65)
                .EUt(VA[ZPM])
                .input(LAMINATED_CRYSTAL_PCB_SHEET)
                .input(GAMMA_EMITTING_DIODE, 8)
                .output(CRYSTAL_PREBOARD)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .duration(160)
                .EUt(VA[EV])
                .input(CRYSTAL_PREBOARD)
                .output(CRYSTAL_BOARD, 8)
                .buildAndRegister();
    }

    private static void quantumBoard() {
        //Q-Bit Transfer Unit
    }

    private static void wetwareBoard() {
        //Organic Neural Network Support Unit
    }
    private static void biowareBoard() {
        //Bio-Froth Support Unit
    }

    private static void exoticBoard() {
        //Non-Abelian Anyon Universal Bus
    }

    private static void cosmicBoard() {
        //Cosmic Soup Physical Calculation Framework
    }

    private static void supraBoard() {
        //Temporally Isolated Calculation Framework
    }

    public static void primitive() {
        ModHandler.addShapedRecipe("primitive_assembly_ulv", PRIMITIVE_ASSEMBLY_ULV.getStackForm(),
                "RVR", "WBW", " V ",
                'R', RESISTOR.getStackForm(),
                'V', VACUUM_TUBE.getStackForm(),
                'B', PRIMITIVE_BOARD.getStackForm(),
                'W', OreDictUnifier.get(wireGtSingle, Tin));

        ModHandler.addShapedRecipe("primitive_computer_lv", PRIMITIVE_COMPUTER_LV.getStackForm(),
                "CAC", "WBW", "PAP",
                'C', CAPACITOR.getStackForm(),
                'A', PRIMITIVE_ASSEMBLY_ULV.getStackForm(),
                'W', OreDictUnifier.get(cableGtSingle, RedAlloy),
                'B', PRIMITIVE_BOARD.getStackForm(),
                'P', OreDictUnifier.get(plate, Tin));

        ModHandler.addShapedRecipe("primitive_mainframe_mv", PRIMITIVE_MAINFRAME_MV.getStackForm(),
                "DPD", "CFC", "TGT",
                'C', PRIMITIVE_COMPUTER_LV.getStackForm(),
                'D', DIODE.getStackForm(),
                'F', OreDictUnifier.get(frameGt, Wood),
                'P', OreDictUnifier.get(plate, WroughtIron),
                'T', TRANSISTOR.getStackForm(),
                'G', OreDictUnifier.get(cableGtSingle, Tin));
    }

    public static void electronic() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LV])
                .input(SIMPLE_CPU)
                .input(ELECTRONIC_BOARD)
                .input(CAPACITOR, 2)
                .input(RESISTOR, 2)
                .input(wireFine, Tin, 4)
                .output(ELECTRONIC_PROCESSOR_ULV, 4)
                .buildAndRegister();

        ModHandler.addShapedRecipe("glass_lens_hand", OreDictUnifier.get(lens, Glass),
                "   ", "fPh", "   ", 'P', OreDictUnifier.get(plate, Glass));

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LV])
                .input(ELECTRONIC_PROCESSOR_ULV, 2)
                .input(ELECTRONIC_BOARD)
                .input(TRANSISTOR, 2)
                .input(RESISTOR, 2)
                .input(wireFine, Tin, 2)
                .output(ELECTRONIC_ASSEMBLY_LV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LV])
                .input(ELECTRONIC_ASSEMBLY_LV, 2)
                .input(plate, Aluminium, 2)
                .input(INDUCTOR, 2)
                .input(CAPACITOR, 2)
                .input(wireFine, Copper, 2)
                .output(ELECTRONIC_COMPUTER_MV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LV])
                .input(ELECTRONIC_COMPUTER_MV, 2)
                .input(frameGt, Aluminium)
                .input(TRANSISTOR, 2)
                .input(DIODE, 2)
                .input(cableGtSingle, Copper, 2)
                .output(ELECTRONIC_MAINFRAME_HV)
                .buildAndRegister();
    }

    public static void integrated() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .cleanroom(CLEANROOM)
                .input(INTEGRATED_CHIP)
                .input(INTEGRATED_BOARD)
                .input(SMD_CAPACITOR_1, 2)
                .input(SMD_RESISTOR_1, 2)
                .input(wireFine, Copper, 4)
                .output(INTEGRATED_PROCESSOR_LV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .cleanroom(CLEANROOM)
                .input(INTEGRATED_PROCESSOR_LV, 2)
                .input(INTEGRATED_BOARD)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_RESISTOR_1, 2)
                .input(wireFine, Copper, 2)
                .output(INTEGRATED_ASSEMBLY_MV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .cleanroom(CLEANROOM)
                .input(INTEGRATED_ASSEMBLY_MV, 2)
                .input(plate, StainlessSteel, 2)
                .input(SMD_INDUCTOR_1, 2)
                .input(SMD_CAPACITOR_1, 2)
                .input(wireFine, Electrum, 2)
                .output(INTEGRATED_COMPUTER_HV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .cleanroom(CLEANROOM)
                .input(INTEGRATED_COMPUTER_HV, 2)
                .input(frameGt, StainlessSteel)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_DIODE_1, 2)
                .input(cableGtSingle, Electrum, 2)
                .output(INTEGRATED_MAINFRAME_EV)
                .buildAndRegister();
    }

    public static void micro() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[HV])
                .cleanroom(CLEANROOM)
                .input(MICRO_CHIP)
                .input(MICRO_BOARD)
                .input(SMD_CAPACITOR_1, 2)
                .input(SMD_RESISTOR_1, 2)
                .input(wireFine, Electrum, 4)
                .output(MICRO_PROCESSOR_MV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[HV])
                .cleanroom(CLEANROOM)
                .input(MICRO_PROCESSOR_MV, 2)
                .input(MICRO_BOARD)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_RESISTOR_1, 2)
                .input(wireFine, Electrum, 2)
                .output(MICRO_ASSEMBLY_HV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[HV])
                .cleanroom(CLEANROOM)
                .input(MICRO_ASSEMBLY_HV, 2)
                .input(plate, Titanium, 2)
                .input(SMD_INDUCTOR_1, 2)
                .input(SMD_CAPACITOR_1, 2)
                .input(wireFine, Aluminium, 2)
                .output(MICRO_COMPUTER_EV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[HV])
                .cleanroom(CLEANROOM)
                .input(MICRO_COMPUTER_EV, 2)
                .input(frameGt, Titanium)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_DIODE_1, 2)
                .input(cableGtSingle, Aluminium, 2)
                .output(MICRO_MAINFRAME_IV)
                .buildAndRegister();
    }

    public static void nano() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .cleanroom(CLEANROOM)
                .input(NANO_CHIP)
                .input(NANO_BOARD)
                .input(SMD_CAPACITOR_1, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, Aluminium, 4)
                .output(GCMetaItems.NANO_PROCESSOR_HV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .cleanroom(CLEANROOM)
                .input(GCMetaItems.NANO_PROCESSOR_HV, 2)
                .input(NANO_BOARD)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, Aluminium, 2)
                .output(NANO_ASSEMBLY_EV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .cleanroom(CLEANROOM)
                .input(NANO_ASSEMBLY_EV, 2)
                .input(plate, TungstenSteel, 2)
                .input(SMD_INDUCTOR_1, 2)
                .input(SMD_CAPACITOR_1, 2)
                .input(wireFine, Platinum, 2)
                .output(GCMetaItems.NANO_COMPUTER_IV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .cleanroom(CLEANROOM)
                .input(GCMetaItems.NANO_COMPUTER_IV, 2)
                .input(frameGt, TungstenSteel)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_DIODE_1, 2)
                .input(cableGtSingle, Platinum, 2)
                .output(GCMetaItems.NANO_MAINFRAME_LUV)
                .buildAndRegister();
    }

    public static void imc() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .cleanroom(CLEANROOM)
                .input(IMC_CHIP)
                .input(IMC_BOARD)
                .input(SMD_CAPACITOR_1, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, Platinum, 4)
                .output(IMC_PROCESSOR_EV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .cleanroom(CLEANROOM)
                .input(IMC_PROCESSOR_EV, 2)
                .input(IMC_BOARD)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, Platinum, 2)
                .output(IMC_ASSEMBLY_IV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .cleanroom(CLEANROOM)
                .input(IMC_ASSEMBLY_IV, 2)
                .input(plate, LutetiumTantalate, 2)
                .input(SMD_INDUCTOR_1, 2)
                .input(SMD_CAPACITOR_1, 2)
                .input(wireFine, NiobiumTitanium, 2)
                .output(IMC_COMPUTER_LUV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .cleanroom(CLEANROOM)
                .input(IMC_COMPUTER_LUV, 2)
                .input(frameGt, LutetiumTantalate)
                .input(SMD_TRANSISTOR_1, 2)
                .input(SMD_DIODE_2, 2)
                .input(cableGtSingle, NiobiumTitanium, 2)
                .output(IMC_MAINFRAME_ZPM)
                .buildAndRegister();
    }

    public static void optical() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .cleanroom(CLEANROOM)
                .input(OPTICAL_CHIP)
                .input(GCMetaItems.OPTICAL_BOARD)
                .input(UVEMITTER_E)
                .input(SMD_CAPACITOR_2, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, NiobiumTitanium, 4)
                .output(OPTICAL_PROCESSOR_IV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .cleanroom(CLEANROOM)
                .input(OPTICAL_PROCESSOR_IV, 2)
                .input(GCMetaItems.OPTICAL_BOARD)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_RESISTOR_2, 2)
                .input(wireFine, NiobiumTitanium, 2)
                .output(OPTICAL_ASSEMBLY_LUV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .cleanroom(CLEANROOM)
                .input(OPTICAL_ASSEMBLY_LUV, 2)
                .input(plate, HSSE, 2)
                .input(SMD_INDUCTOR_2, 2)
                .input(SMD_CAPACITOR_2, 2)
                .input(wireFine, VanadiumGallium, 2)
                .output(OPTICAL_COMPUTER_ZPM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .cleanroom(CLEANROOM)
                .input(OPTICAL_COMPUTER_ZPM, 2)
                .input(frameGt, HSSE)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_DIODE_2, 2)
                .input(cableGtSingle, VanadiumGallium, 2)
                .output(OPTICAL_MAINFRAME_UV)
                .buildAndRegister();
    }

    public static void crystal() {
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CLEANROOM)
                .input(SAPPHIRE_CHIP)
                .input(CRYSTAL_BOARD)
                .input(SMD_CAPACITOR_2, 2)
                .input(SMD_RESISTOR_3, 2)
                .input(wireFine, VanadiumGallium, 4)
                .output(CRYSTAL_PROCESSOR_LUV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CLEANROOM)
                .input(CRYSTAL_PROCESSOR_LUV, 2)
                .input(CRYSTAL_BOARD)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_RESISTOR_3, 2)
                .input(wireFine, VanadiumGallium, 2)
                .output(CRYSTAL_ASSEMBLY_ZPM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CLEANROOM)
                .input(CRYSTAL_ASSEMBLY_ZPM, 2)
                .input(plate, Europium, 2)
                .input(SMD_CAPACITOR_2, 2)
                .input(SMD_INDUCTOR_2, 2)
                .input(wireFine, Naquadah, 2)
                .output(CRYSTAL_COMPUTER_UV)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[ZPM])
                .cleanroom(CLEANROOM)
                .input(CRYSTAL_COMPUTER_UV, 2)
                .input(frameGt, Europium)
                .input(SMD_TRANSISTOR_2, 2)
                .input(SMD_DIODE_2, 2)
                .input(cableGtSingle, Naquadah, 2)
                .output(CRYSTAL_MAINFRAME_UHV)
                .buildAndRegister();
    }

     */
}
