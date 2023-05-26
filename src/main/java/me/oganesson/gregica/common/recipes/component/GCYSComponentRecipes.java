package me.oganesson.gregica.common.recipes.component;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;

import static gregtech.api.GTValues.L;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLY_LINE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static me.oganesson.gregica.api.unification.materials.GCYSMaterials.*;

public class GCYSComponentRecipes {

    public static void init() {
        motor();
        conveyor();
        piston();
        robotArm();
        pump();
        emitter();
        sensor();
        fieldGenerator();
        craftingComponents();
    }

    private static void motor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, Neutronium, 4)
                .input(ring, Neutronium, 4)
                .input(round, Neutronium, 8)
                .input(wireFine, SiliconCarbide, 64)
                .input(wireFine, SiliconCarbide, 64)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Naquadria.getFluid(L * 8))
                .output(ELECTRIC_MOTOR_UHV)
                .duration(600).EUt(400000).buildAndRegister();
    }

    private static void conveyor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(plate, Neutronium, 2)
                .input(ring, Neutronium, 4)
                .input(round, Neutronium, 16)
                .input(screw, Neutronium, 4)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(StyreneButadieneRubber.getFluid(L * 24))
                .fluidInputs(Naquadria.getFluid(L * 8))
                .output(CONVEYOR_MODULE_UHV)
                .duration(600).EUt(400000).buildAndRegister();
    }

    private static void piston() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, Neutronium, 4)
                .input(ring, Neutronium, 4)
                .input(round, Neutronium, 16)
                .input(stick, Neutronium, 4)
                .input(gear, Neutronium)
                .input(gearSmall, Darmstadtium, 2)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Naquadria.getFluid(L * 8))
                .output(ELECTRIC_PISTON_UHV)
                .duration(600).EUt(400000).buildAndRegister();
    }

    private static void robotArm() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, Neutronium, 4)
                .input(gear, Neutronium)
                .input(gearSmall, Darmstadtium, 3)
                .input(ELECTRIC_MOTOR_UHV, 2)
                .input(ELECTRIC_PISTON_UHV)
                .input(circuit, MarkerMaterials.Tier.UHV)
                .input(circuit, MarkerMaterials.Tier.UV, 2)
                .input(circuit, MarkerMaterials.Tier.ZPM, 4)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Naquadria.getFluid(L * 8))
                .output(ROBOT_ARM_UHV)
                .duration(600).EUt(400000).buildAndRegister();
    }

    private static void pump() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UHV)
                .input(pipeLargeFluid, Duranium)
                .input(plate, Neutronium, 2)
                .input(screw, Neutronium, 8)
                .input(ring, StyreneButadieneRubber, 16)
                .input(rotor, Neutronium)
                .input(cableGtSingle, Europium, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Naquadria.getFluid(L * 8))
                .output(ELECTRIC_PUMP_UHV)
                .duration(600).EUt(400000).buildAndRegister();
    }

    private static void emitter() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(stickLong, Neutronium, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, Tritanium, 64)
                .input(foil, Tritanium, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Naquadria.getFluid(L * 8))
                .output(EMITTER_UHV)
                .duration(600).EUt(400000).buildAndRegister();
    }

    private static void sensor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .input(ELECTRIC_MOTOR_UHV)
                .input(plate, Neutronium, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(foil, Naquadria, 64)
                .input(foil, Naquadria, 32)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Naquadria.getFluid(L * 8))
                .output(SENSOR_UHV)
                .duration(600).EUt(400000).buildAndRegister();
    }

    private static void fieldGenerator() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Neutronium)
                .input(plate, Neutronium, 6)
                .input(GRAVI_STAR)
                .input(EMITTER_UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(wireFine, PedotPSS, 64)
                .input(wireFine, PedotPSS, 64)
                .input(cableGtSingle, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Naquadria.getFluid(L * 8))
                .output(FIELD_GENERATOR_UHV)
                .duration(600).EUt(400000).buildAndRegister();
    }

    private static void motor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, ChromiumGermaniumTellurideMagnetic)
                .input(stickLong, MetallicHydrogen, 4)
                .input(ring, MetallicHydrogen, 4)
                .input(round, MetallicHydrogen, 8)
                .input(wireFine, CarbonNanotube, 64)
                .input(wireFine, CarbonNanotube, 64)
                .input(cableGtSingle, PedotTma, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Neutronium.getFluid(L * 4))
                .output(ELECTRIC_MOTOR_UEV)
                .duration(600).EUt(1600000).buildAndRegister();
    }

    private static void conveyor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(plate, MetallicHydrogen, 2)
                .input(ring, MetallicHydrogen, 4)
                .input(round, MetallicHydrogen, 16)
                .input(screw, MetallicHydrogen, 4)
                .input(cableGtSingle, PedotTma, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(StyreneButadieneRubber.getFluid(L * 24))
                .fluidInputs(Neutronium.getFluid(L * 4))
                .output(CONVEYOR_MODULE_UEV)
                .duration(600).EUt(1600000).buildAndRegister();
    }

    private static void piston() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, MetallicHydrogen, 4)
                .input(ring, MetallicHydrogen, 4)
                .input(round, MetallicHydrogen, 16)
                .input(stick, MetallicHydrogen, 4)
                .input(gear, MetallicHydrogen)
                .input(gearSmall, MetallicHydrogen, 2)
                .input(cableGtSingle, PedotTma, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Neutronium.getFluid(L * 4))
                .output(ELECTRIC_PISTON_UEV)
                .duration(600).EUt(1600000).buildAndRegister();
    }

    private static void robotArm() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, MetallicHydrogen, 4)
                .input(gear, MetallicHydrogen)
                .input(gearSmall, MetallicHydrogen, 3)
                .input(ELECTRIC_MOTOR_UEV, 2)
                .input(ELECTRIC_PISTON_UEV)
                .input(circuit, MarkerMaterials.Tier.UEV)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(circuit, MarkerMaterials.Tier.UV, 4)
                .input(cableGtSingle, PedotTma, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Neutronium.getFluid(L * 4))
                .output(ROBOT_ARM_UEV)
                .duration(600).EUt(1600000).buildAndRegister();
    }

    private static void pump() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(ELECTRIC_MOTOR_UEV)
                .input(pipeLargeFluid, Neutronium)
                .input(plate, MetallicHydrogen, 2)
                .input(screw, MetallicHydrogen, 8)
                .input(ring, StyreneButadieneRubber, 16)
                .input(rotor, MetallicHydrogen)
                .input(cableGtSingle, PedotTma, 2)
                .fluidInputs(SolderingAlloy.getFluid(L * 4))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Neutronium.getFluid(L * 4))
                .output(ELECTRIC_PUMP_UEV)
                .duration(600).EUt(1600000).buildAndRegister();
    }

    private static void emitter() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MetallicHydrogen)
                .input(ELECTRIC_MOTOR_UEV)
                .input(stickLong, MetallicHydrogen, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, MercuryCadmiumTelluride, 64)
                .input(foil, MercuryCadmiumTelluride, 32)
                .input(cableGtSingle, PedotTma, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Neutronium.getFluid(L * 4))
                .output(EMITTER_UEV)
                .duration(600).EUt(1600000).buildAndRegister();
    }

    private static void sensor() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MetallicHydrogen)
                .input(ELECTRIC_MOTOR_UEV)
                .input(plate, MetallicHydrogen, 4)
                .input(GRAVI_STAR)
                .input(circuit, MarkerMaterials.Tier.UEV, 2)
                .input(foil, Fullerene, 64)
                .input(foil, Fullerene, 32)
                .input(cableGtSingle, PedotTma, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 8))
                .fluidInputs(Neutronium.getFluid(L * 4))
                .output(SENSOR_UEV)
                .duration(600).EUt(1600000).buildAndRegister();
    }

    private static void fieldGenerator() {
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, MetallicHydrogen)
                .input(plate, MetallicHydrogen, 6)
                .input(GRAVI_STAR)
                .input(EMITTER_UEV, 2)
                .input(circuit, MarkerMaterials.Tier.UHV, 2)
                .input(wireFine, CarbonNanotube, 64)
                .input(wireFine, CarbonNanotube, 64)
                .input(cableGtSingle, PedotTma, 4)
                .fluidInputs(SolderingAlloy.getFluid(L * 12))
                .fluidInputs(Neutronium.getFluid(L * 4))
                .output(FIELD_GENERATOR_UEV)
                .duration(600).EUt(1600000).buildAndRegister();
    }
    
    private static void craftingComponents() {
        ModHandler.addShapedRecipe("component_grinder_boron_nitride", GCMetaItems.COMPONENT_GRINDER_BORON_NITRIDE.getStackForm(),
                "PDP", "DGD", "PDP",
                'P', new UnificationEntry(plate, CubicBoronNitride),
                'D', new UnificationEntry(plateDouble, Vibranium),
                'G', new UnificationEntry(gem, CubicHeterodiamond));
    }
}
