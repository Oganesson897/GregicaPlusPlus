package me.oganesson.gregica.common.recipes;

import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.ModHandler;
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
import me.oganesson.gregica.common.unification.materials.GCMaterial;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.loaders.recipe.handlers.ToolRecipeHandler.addToolRecipe;

public class GCRecipes {

    public static void register(){
        workbenchRecipe();
        gcMachineRecipes();
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

        //machine casing
        ModHandler.addShapedRecipe("fishing_casing", new ItemStack(GCMetaBlocks.GC_BLOCK_CASING, 2, 1),
                "WhW", "KFK", "WdW",
                'W', new UnificationEntry(OrePrefix.plate, GCYMMaterials.WatertightSteel),
                'K', new UnificationEntry(OrePrefix.plate, Materials.Kanthal),
                'F', new UnificationEntry(OrePrefix.frameGt, GCYMMaterials.WatertightSteel));

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
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(MetaTileEntities.TRANSFORMER[6].getStackForm())
                .input(GCMetaItems.ADVANCED_PROCESS_CIRCUIT)
                .input(wireGtSingle, Materials.IndiumTinBariumTitaniumCuprate, 16)
                .input(MetaItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT)
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
                .fluidInputs(GCMaterial.BismuthLeadAlloy.getFluid(288))
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
                .fluidOutputs(GCMaterial.BismuthLeadAlloy.getFluid(14000))
                .buildAndRegister();
    }
}
