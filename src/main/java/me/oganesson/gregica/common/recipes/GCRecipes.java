package me.oganesson.gregica.common.recipes;

import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.ToolProperty;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;
import me.oganesson.gregica.common.item.metaitems.GCMetaToolItems;
import me.oganesson.gregica.common.tileentities.mte.GCMetaEntities;
import me.oganesson.gregica.common.unification.materials.GCMaterials;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.loaders.recipe.handlers.ToolRecipeHandler.addToolRecipe;
import static me.oganesson.gregica.common.recipes.GCBiologyRecipe.getBiologyCircuitData;

public class GCRecipes {

    public static void register(){
        workbenchRecipe();
        gcMachineRecipes();
        GCRecipeManager.init();
    }

    public static void registerTool(){
        plate.addProcessingHandler(PropertyKey.TOOL, GCRecipes::gcmTool);
    }
    public static void workbenchRecipe() {
        //machine
        ModHandler.addShapedRecipe("industrial_fishing_pond", GCMetaEntities.INDUSTRIAL_POND.getStackForm(),
                "WMW", "EFE", "WMW",
                'W', new UnificationEntry(OrePrefix.plate, GCYMMaterials.WatertightSteel),
                'E', new UnificationEntry(OrePrefix.wireFine, Materials.Electrum),
                'F', MetaTileEntities.FISHER[3].getStackForm(),
                'M', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.MV));

        ModHandler.addShapedRecipe("lightning_rod_iv", GCMetaEntities.LIGHTNING_ROD[0].getStackForm(),
                "LML", "MCM", "LML",
                'L', MetaItems.ENERGY_LAPOTRONIC_ORB,
                'C', new ItemStack(MetaBlocks.MACHINE_CASING, 1, 6),
                'M', MetaTileEntities.TRANSFORMER[6].getStackForm());

        ModHandler.addShapedRecipe("lightning_rod_luv", GCMetaEntities.LIGHTNING_ROD[1].getStackForm(),
                "LML", "MCM", "LML",
                'L', MetaItems.ENERGY_LAPOTRONIC_ORB_CLUSTER,
                'C', new ItemStack(MetaBlocks.MACHINE_CASING, 1, 7),
                'M', MetaTileEntities.TRANSFORMER[7].getStackForm());

        ModHandler.addShapedRecipe("lightning_rod_zpm", GCMetaEntities.LIGHTNING_ROD[2].getStackForm(),
                "LML", "MCM", "LML",
                'L', MetaItems.ULTIMATE_BATTERY,
                'C', new ItemStack(MetaBlocks.MACHINE_CASING, 1, 8),
                'M', MetaTileEntities.TRANSFORMER[8].getStackForm());

        ModHandler.addShapedRecipe("lapotron_super_capacitor_bank", GCMetaEntities.LAPOTRONIC_SUPER_CAPACITOR.getStackForm(),
                "WMW", "EFE", "WMW",
                'W', MetaItems.LAPOTRON_CRYSTAL.getStackForm(),
                'E', new UnificationEntry(circuit, MarkerMaterials.Tier.LuV),
                'F', new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1,0),
                'M', MetaItems.POWER_INTEGRATED_CIRCUIT.getStackForm());

        //machine casing
        ModHandler.addShapedRecipe("fishing_casing", new ItemStack(GCMetaBlocks.GC_BLOCK_CASING, 2, 1),
                "WhW", "KFK", "WdW",
                'W', new UnificationEntry(OrePrefix.plate, GCYMMaterials.WatertightSteel),
                'K', new UnificationEntry(OrePrefix.plate, Materials.Kanthal),
                'F', new UnificationEntry(OrePrefix.frameGt, GCYMMaterials.WatertightSteel));

        ModHandler.addShapedRecipe("super_capacitor_casing", new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1),
                "WFW", "KBK", "WFW",
                'W', new UnificationEntry(OrePrefix.plate, Materials.Tantalum),
                'K', new UnificationEntry(stickLong, Materials.TungstenSteel),
                'F', new UnificationEntry(OrePrefix.frameGt, Materials.TungstenSteel),
                'B', new UnificationEntry(OrePrefix.block, Materials.Lapis));

        ModHandler.addShapedRecipe("blank_lapotron_capacitor", new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 1),
                "WFW", "F F", "WFW",
                'W', new UnificationEntry(screw, Materials.Lapis),
                'F', new UnificationEntry(plate, Materials.Lapis));

        ModHandler.addShapedRecipe("lapotron_capacitor_block_tier_1", new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 2),
                "WFW", "FCF", "WFW",
                'C', MetaItems.LAPOTRON_CRYSTAL,
                'W', new UnificationEntry(screw, Materials.Lapis),
                'F', new UnificationEntry(plate, Materials.Lapis));

        ModHandler.addShapedRecipe("lapotron_capacitor_block_tier_2", new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 3),
                "WFW", "FOF", "WFW",
                'O', MetaItems.ENERGY_LAPOTRONIC_ORB,
                'W', new UnificationEntry(screw, Materials.Lapis),
                'F', new UnificationEntry(plate, Materials.Lapis));

        //Cover
        ModHandler.addShapedRecipe("ulv_electric_pump", GCMetaItems.ULV_ELECTRIC_PUMP.getStackForm(),
                "SCR", "dPw", "RMW",
                'W', new UnificationEntry(cableGtSingle, Materials.Lead),
                'S', new UnificationEntry(screw, Materials.Lead),
                'R', new UnificationEntry(ring, Materials.Rubber),
                'M', GCMetaItems.ULV_ELECTRIC_MOTOR.getStackForm(),
                'C', new UnificationEntry(rotor, Materials.Potin),
                'P', new UnificationEntry(pipeNormalFluid, Materials.Lead)
        );

        ModHandler.addShapedRecipe("ulv_electric_motor", GCMetaItems.ULV_ELECTRIC_MOTOR.getStackForm(),
                "CWR", "WTW", "RWC",
                'W', new UnificationEntry(wireGtSingle, Materials.Lead),
                'R', new UnificationEntry(stick, Materials.WroughtIron),
                'T', new UnificationEntry(stick, Materials.IronMagnetic),
                'C', new UnificationEntry(cableGtSingle, Materials.RedAlloy)
        );

        ModHandler.addShapedRecipe("ulv_electric_conveyor", GCMetaItems.ULV_CONVEYOR_MODULE.getStackForm(),
                "PPP", "MCM", "PPP",
                'P', new UnificationEntry(plate, Materials.Rubber),
                'M', GCMetaItems.ULV_ELECTRIC_MOTOR.getStackForm(),
                'C', new UnificationEntry(cableGtSingle, Materials.Lead)
        );

        ModHandler.addShapedRecipe("ulv_electric_piston", GCMetaItems.ULV_ELECTRIC_PISTON.getStackForm(),
                "PPP", "CSS", "CMG",
                'P', new UnificationEntry(plate, Materials.Lead),
                'S', new UnificationEntry(stick, Materials.WroughtIron),
                'M', GCMetaItems.ULV_ELECTRIC_MOTOR.getStackForm(),
                'G', new UnificationEntry(gearSmall, Materials.Potin),
                'C', new UnificationEntry(cableGtSingle, Materials.Lead)
        );

        ModHandler.addShapedRecipe("ulv_robotic_arm", GCMetaItems.ULV_ROBOT_ARM.getStackForm(),
                "CCC", "MSM", "PTS",
                'P', GCMetaItems.ULV_ELECTRIC_PISTON.getStackForm(),
                'S', new UnificationEntry(stick, Materials.Potin),
                'M', GCMetaItems.ULV_ELECTRIC_MOTOR.getStackForm(),
                'C', new UnificationEntry(cableGtSingle, Materials.Lead),
                'T', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV)
        );

        ModHandler.addShapedRecipe("ulv_sensor", GCMetaItems.ULV_SENSOR.getStackForm(),
                "P C", "PS ", "TPP",
                'P', new UnificationEntry(plate, Materials.WroughtIron),
                'S', new UnificationEntry(stick, Materials.IronMagnetic),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LV),
                'T', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV)
        );

        ModHandler.addShapedRecipe("ulv_emitter", GCMetaItems.ULV_EMITTER.getStackForm(),
                "SST", "WCS", "TWS",
                'S', new UnificationEntry(stick, Materials.IronMagnetic),
                'W', new UnificationEntry(cableGtSingle, Materials.Lead),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LV),
                'T', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV)
        );

        ModHandler.addShapedRecipe("ulv_field_generator", GCMetaItems.ULV_FIELD_GENERATOR.getStackForm(),
                "WTW", "TCT", "WTW",
                'W', new UnificationEntry(wireGtSingle, Materials.Lead),
                'C', new UnificationEntry(circuit, MarkerMaterials.Tier.LV),
                'T', new UnificationEntry(circuit, MarkerMaterials.Tier.ULV)
        );
    }

    private static void gcmTool(OrePrefix prefix, Material material, ToolProperty property) {
        UnificationEntry plate = new UnificationEntry(OrePrefix.plate, material);
        UnificationEntry ingot = new UnificationEntry(material.hasProperty(PropertyKey.GEM) ? OrePrefix.gem : OrePrefix.ingot, material);
        //tools
        if (material.hasFlag(MaterialFlags.GENERATE_LONG_ROD)) {
            UnificationEntry rod = new UnificationEntry(stickLong, material);
            if (material.hasFlag(MaterialFlags.GENERATE_PLATE)) {
                if (material.hasFlag(MaterialFlags.GENERATE_BOLT_SCREW)) {
                    addToolRecipe(material, GCMetaToolItems.Choocher, false, "IdP", "IPP", "ST ", 'I', ingot, 'P', plate, 'T', new UnificationEntry(OrePrefix.screw, material), 'S', rod);
                }
            }
        }
    }

    private static void gcMachineRecipes(){
        CANNER_RECIPES.recipeBuilder().duration(233).EUt(VA[ULV])
                .input(Items.BREAD)
                .fluidInputs(Materials.Lead.getFluid(144))
                .output(GCMetaItems.BAGUETTE_SWORD)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaTileEntities.TRANSFORMER[6].getStackForm())
                .input(GCMetaItems.ADVANCED_PROCESS_CIRCUIT)
                .input(wireGtSingle, Materials.IndiumTinBariumTitaniumCuprate, 16)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .fluidInputs(Materials.TungstenSteel.getFluid(576))
                .outputs(GCMetaEntities.ACTIVE_TRANSFORMER.getStackForm())
                .EUt(VA[LuV]).duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaItems.ELITE_CIRCUIT_BOARD)
                .input(circuit, MarkerMaterials.Tier.ZPM, 2)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 4)
                .input(MetaItems.NANO_CENTRAL_PROCESSING_UNIT, 2)
                .input(MetaItems.QUBIT_CENTRAL_PROCESSING_UNIT, 2)
                .input(wireGtSingle, Materials.UraniumRhodiumDinaquadide, 64)
                .fluidInputs(GCMaterials.BismuthLeadAlloy.getFluid(288))
                .output(GCMetaItems.ADVANCED_PROCESS_CIRCUIT)
                .EUt(VA[IV]).duration(2400).cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Materials.Iridium)
                .input(plateDouble, Materials.Iridium, 6)
                .input(circuit, MarkerMaterials.Tier.LuV)
                .input(wireFine, Materials.Cobalt, 16)
                .input(wireFine, Materials.Copper, 16)
                .input(wireGtSingle, Materials.NiobiumTitanium, 2)
                .fluidInputs(Materials.TungstenSteel.getFluid(576))
                .outputs(new ItemStack(GCMetaBlocks.GC_BLOCK_CASING, 1, 4))
                .EUt(VA[LuV]).duration(100)
                .buildAndRegister();

        GCYMRecipeMaps.ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Materials.Bismuth, 47)
                .input(dust, Materials.Lead, 25)
                .input(dust, Materials.Tin, 13)
                .input(dust, Materials.Cadmium, 10)
                .input(dust, Materials.Indium, 5)
                .circuitMeta(5)
                .blastFurnaceTemp(5475)
                .EUt(VA[IV]).duration(800)
                .fluidOutputs(GCMaterials.BismuthLeadAlloy.getFluid(14000))
                .buildAndRegister();

        GCYMRecipeMaps.ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Materials.Nickel, 3)
                .input(dust, Materials.Chrome, 7)
                .input(dust, Materials.Molybdenum, 10)
                .input(dust, Materials.Invar, 10)
                .input(dust, Materials.Nichrome, 13)
                .circuitMeta(5)
                .blastFurnaceTemp(3700)
                .EUt(120).duration(400)
                .fluidOutputs(GCMaterials.Inconel625.getFluid(6192))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaItems.ENERGY_LAPOTRONIC_ORB_CLUSTER)
                .input(frameGt, Materials.TungstenSteel, 4)
                .input(screw, Materials.TungstenSteel, 24)
                .outputs(new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 4))
                .circuitMeta(6)
                .EUt(VA[IV]).duration(800)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaItems.ENERGY_LAPOTRONIC_ORB)
                .inputs(new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 1))
                .outputs(new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 3))
                .circuitMeta(6)
                .EUt(VA[IV]).duration(400)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaItems.LAPOTRON_CRYSTAL)
                .inputs(new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 1))
                .outputs(new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 2))
                .circuitMeta(6)
                .EUt(VA[EV]).duration(200)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .EUt(80000).duration(1000)
                .input(frameGt, Materials.TungstenSteel, 4)
                .input(screw, Materials.TungstenSteel, 24)
                .input(MetaItems.EXTREME_CIRCUIT_BOARD)
                .input(OrePrefix.plate, Materials.Europium, 8)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.LuV, 4)
                .input(MetaItems.ENERGY_LAPOTRONIC_ORB)
                .input(MetaItems.FIELD_GENERATOR_IV)
                .input(MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT, 16)
                .input(MetaItems.ADVANCED_SMD_DIODE, 8)
                .input(MetaItems.ADVANCED_SMD_CAPACITOR, 8)
                .input(MetaItems.ADVANCED_SMD_RESISTOR, 8)
                .input(MetaItems.ADVANCED_SMD_TRANSISTOR, 8)
                .input(MetaItems.ADVANCED_SMD_INDUCTOR, 8)
                .input(OrePrefix.wireFine, Materials.Platinum, 64)
                .input(OrePrefix.bolt, Materials.Naquadah, 16)
                .fluidInputs(new FluidStack[]{Materials.SolderingAlloy.getFluid(720)})
                .outputs(new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 4))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .EUt(100000).duration(1200)
                .input(frameGt, Materials.NaquadahAlloy, 4)
                .input(screw, Materials.NaquadahAlloy, 24)
                .input(MetaItems.ELITE_CIRCUIT_BOARD)
                .input(OrePrefix.plateDouble, Materials.Europium, 8)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(MetaItems.ENERGY_LAPOTRONIC_ORB_CLUSTER)
                .input(MetaItems.FIELD_GENERATOR_LuV)
                .input(MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .input(MetaItems.ADVANCED_SMD_DIODE, 12)
                .input(MetaItems.ADVANCED_SMD_CAPACITOR, 12)
                .input(MetaItems.ADVANCED_SMD_RESISTOR, 12)
                .input(MetaItems.ADVANCED_SMD_TRANSISTOR, 12)
                .input(MetaItems.ADVANCED_SMD_INDUCTOR, 12)
                .input(OrePrefix.wireFine, Materials.Ruridit, 64)
                .input(OrePrefix.bolt, Materials.Trinium, 16)
                .fluidInputs(new FluidStack[]{Materials.SolderingAlloy.getFluid(1440)})
                .outputs(new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 5))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .EUt(200000).duration(1400)
                .input(frameGt, Materials.Darmstadtium, 4)
                .input(screw, Materials.Darmstadtium, 24)
                .input(MetaItems.WETWARE_CIRCUIT_BOARD)
                .input(OrePrefix.plate, Materials.Americium, 16)
                .input(MetaItems.WETWARE_SUPER_COMPUTER_UV, 4)
                .input(MetaItems.ENERGY_MODULE)
                .input(MetaItems.FIELD_GENERATOR_ZPM)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 32)
                .input(MetaItems.ADVANCED_SMD_DIODE, 16)
                .input(MetaItems.ADVANCED_SMD_CAPACITOR, 16)
                .input(MetaItems.ADVANCED_SMD_RESISTOR, 16)
                .input(MetaItems.ADVANCED_SMD_TRANSISTOR, 16)
                .input(MetaItems.ADVANCED_SMD_INDUCTOR, 16)
                .input(OrePrefix.wireFine, Materials.Osmiridium, 64)
                .input(OrePrefix.bolt, Materials.Naquadria, 16)
                .fluidInputs(new FluidStack[]{Materials.SolderingAlloy.getFluid(2880)})
                .fluidInputs(new FluidStack[]{Materials.Polybenzimidazole.getFluid(576)})
                .outputs(new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 6))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .EUt(300000).duration(2000)
                .input(frameGt, Materials.Neutronium, 4)
                .input(screw, Materials.Neutronium, 24)
                .input(OrePrefix.plateDouble, Materials.Darmstadtium, 16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.UHV, 4)
                .input(MetaItems.ENERGY_CLUSTER, 16)
                .input(MetaItems.FIELD_GENERATOR_UV, 4)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT_WAFER, 64)
                .input(MetaItems.ADVANCED_SMD_DIODE, 64)
                .input(MetaItems.ADVANCED_SMD_CAPACITOR, 64)
                .input(MetaItems.ADVANCED_SMD_RESISTOR, 64)
                .input(MetaItems.ADVANCED_SMD_TRANSISTOR, 64)
                .input(MetaItems.ADVANCED_SMD_INDUCTOR, 64)
                .input(OrePrefix.wireGtSingle, Materials.EnrichedNaquadahTriniumEuropiumDuranide, 64)
                .input(OrePrefix.bolt, Materials.Neutronium, 64)
                .fluidInputs(new FluidStack[]{Materials.SolderingAlloy.getFluid(5760)})
                .fluidInputs(new FluidStack[]{Materials.Polybenzimidazole.getFluid(2304)})
                .fluidInputs(new FluidStack[]{Materials.Naquadria.getFluid(2592)})
                .outputs(new ItemStack(GCMetaBlocks.GC_LAPOTRONIC_CASING, 1, 7))
                .buildAndRegister();

        GTRecipeHandler.removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{new ItemStack(MetaBlocks.TRANSPARENT_CASING, 1, 2), OreDictUnifier.get(plate, Materials.Naquadah, 4), MetaItems.NEUTRON_REFLECTOR.getStackForm(4)}, new FluidStack[]{Materials.Polybenzimidazole.getFluid(144)});
        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(VA[LuV]).duration(50)
                .inputs(new ItemStack(GCMetaBlocks.TRANSPARENT_CASING, 1, 5))
                .input(plate, Materials.Naquadah, 4)
                .inputs(MetaItems.NEUTRON_REFLECTOR.getStackForm(4))
                .fluidInputs(Materials.Polybenzimidazole.getFluid(144))
                .outputs(new ItemStack(MetaBlocks.TRANSPARENT_CASING, 2, 1))
                .buildAndRegister();


        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .EUt(VA[HV]).duration(18)
                .input(block, Materials.BorosilicateGlass, 1)
                .fluidInputs(Materials.Titanium.getFluid(1152))
                .outputs(new ItemStack(GCMetaBlocks.TRANSPARENT_CASING, 1, 0))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .EUt(VA[EV]).duration(18)
                .input(block, Materials.BorosilicateGlass, 1)
                .fluidInputs(Materials.TungstenSteel.getFluid(1152))
                .outputs(new ItemStack(GCMetaBlocks.TRANSPARENT_CASING, 1, 1))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .EUt(VA[IV]).duration(18)
                .input(block, Materials.BorosilicateGlass, 1)
                .fluidInputs(Materials.RhodiumPlatedPalladium.getFluid(1152))
                .outputs(new ItemStack(GCMetaBlocks.TRANSPARENT_CASING, 1, 3))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .EUt(VA[ZPM]).duration(18)
                .input(block, Materials.BorosilicateGlass, 1)
                .fluidInputs(Materials.Osmiridium.getFluid(1152))
                .outputs(new ItemStack(GCMetaBlocks.TRANSPARENT_CASING, 1, 5))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .EUt(VA[LuV]).duration(18)
                .input(block, Materials.BorosilicateGlass, 1)
                .fluidInputs(Materials.Iridium.getFluid(1152))
                .outputs(new ItemStack(GCMetaBlocks.TRANSPARENT_CASING, 1, 4))
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .EUt(VA[UV]).duration(18)
                .input(block, Materials.BorosilicateGlass, 1)
                .fluidInputs(Materials.Neutronium.getFluid(1152))
                .outputs(new ItemStack(GCMetaBlocks.TRANSPARENT_CASING, 1, 6))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(64).duration(200)
                .input(plank, Materials.Wood, 8)
                .input(MetaItems.PLANT_BALL, 4)
                .input(MetaItems.VOLTAGE_COIL_MV)
                .input(pipeTinyFluid, Materials.Steel)
                .input(frameGt, Materials.Bronze)
                .circuitMeta(2)
                .fluidInputs(Materials.Water.getFluid(2000))
                .outputs(new ItemStack(GCMetaBlocks.GC_BLOCK_CASING, 1, 5))
                .buildAndRegister();

        ModHandler.addShapedRecipe("tree_growther", GCMetaEntities.LOG_CREATE_FACTORY.getStackForm(),
                "WTW", "NCN", "WFW",
                'W', MetaItems.FIELD_GENERATOR_IV.getStackForm(),
                'N', new UnificationEntry(plate, Materials.NiobiumTitanium),
                'C', MetaTileEntities.HULL[IV].getStackForm(),
                'T', new UnificationEntry(rotor, GCYMMaterials.IncoloyMA956),
                'F', new UnificationEntry(pipeNormalFluid, GCMaterials.Inconel625)
        );

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(120).duration(1200)
                .input(dust, Materials.Redstone, 32)
                .input(bolt, Materials.Steel, 16)
                .input(plate, Materials.Wood, 32)
                .input(stick, Materials.Aluminium, 12)
                .inputs(MetaTileEntities.HULL[ULV].getStackForm(4))
                .notConsumable(getBiologyCircuitData(21))
                .fluidInputs(Materials.Potin.getFluid(1152))
                .outputs(GCMetaEntities.ALGAE_FARM.getStackForm())
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(1920).duration(9600)
                .input(plateDouble, GCMaterials.Inconel625, 4)
                .input(ring, GCMaterials.Inconel625, 8)
                .input(bolt, GCMaterials.Inconel625, 16)
                .input(plate, Materials.HSSE, 8)
                .inputs(MetaTileEntities.HULL[EV].getStackForm(2))
                .circuitMeta(7)
                .fluidInputs(Materials.Aluminium.getFluid(1152))
                .outputs(new ItemStack(GCMetaBlocks.GC_BLOCK_CASING, 1, 7))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .EUt(30720).duration(2400)
                .input(gear, GCMaterials.Inconel625, 4)
                .input(gearSmall, Materials.HSSE, 8)
                .input(plate, GCMaterials.Inconel625, 8)
                .input(bolt, GCYMMaterials.Zeron100, 16)
                .inputs(new ItemStack(MetaBlocks.TURBINE_CASING, 2, 3))
                .circuitMeta(7)
                .fluidInputs(Materials.TungstenSteel.getFluid(1152))
                .outputs(new ItemStack(GCMetaBlocks.GC_META_GEAR_BOX, 1))
                .buildAndRegister();

    }
}
