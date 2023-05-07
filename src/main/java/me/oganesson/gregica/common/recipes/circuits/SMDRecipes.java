package me.oganesson.gregica.common.recipes.circuits;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static me.oganesson.gregica.api.recipe.GCRecipeMaps.*;
import static me.oganesson.gregica.common.item.metaitems.GCMetaItems.*;
import static me.oganesson.gregica.common.unification.materials.GCMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static me.oganesson.gregica.common.unification.materials.material.TJCoreDegreeMaterials.*;

public class SMDRecipes {
    public static void registerSMDRecipes() {

        // RESISTORS

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[LV])
                .input(foil, SilicaCeramic, 2)
                .input(dust, SilverLeadOxide)
                .input(wireFine, Copper, 2)
                .fluidInputs(Polyethylene.getFluid(72))
                .output(SMD_RESISTOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[MV])
                .input(ring, PolyvinylButyral)
                .input(foil, Epoxy, 4)
                .input(wireFine, Nichrome, 2)
                .fluidInputs(PolyphenyleneSulfide.getFluid(72))
                .output(SMD_RESISTOR_2, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[LuV])
                .input(foil, Polybenzimidazole)
                .input(dustTiny, Cobalt60)
                .input(ring, Lead)
                .input(wireFine, Osmium, 4)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(72))
                .output(SMD_RESISTOR_3, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UV])
                .input(plate, LeadZirconateTitanate)
                .input(nanofoil, Nickel)
                .input(round, SodiumPotassiumNiobate, 9)
                .input(wireFine, YttriumBariumCuprate, 2)
                .fluidInputs(Polyetheretherketone.getFluid(72))
                .output(SMD_RESISTOR_4,16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UEV])
                .input(CNT_SHORT, 8)
                .input(nanowire, Adamantium, 8)
                .input(dustTiny, GraphenePQD)
                .input(screw, Trinium)
                .fluidInputs(SuperfluidHelium3.getFluid(125))
                .output(SMD_RESISTOR_5, 16)
                .buildAndRegister();

        // TRANSISTORS
        ModHandler.addShapedRecipe("transistor", TRANSISTOR.getStackForm(2),
                " F ", "WDW", " F ",
                'F', OreDictUnifier.get(foil, Silicon),
                'D', OreDictUnifier.get(foil, Gold),
                'W', OreDictUnifier.get(dustTiny, SiliconDioxide));

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[LV])
                .input(ring, SilicaCeramic, 2)
                .input(foil, Silicon)
                .input(wireFine, Copper, 2)
                .fluidInputs(Polyethylene.getFluid(72))
                .output(SMD_TRANSISTOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[HV])
                .input(plate, IndiumGalliumPhosphide)
                .input(foil, ErbiumDopedZBLANGlass, 2)
                .input(foil, PraseodymiumDopedZBLANGlass, 2)
                .input(wireFine, Palladium, 4)
                .fluidInputs(SeleniumMonobromide.getFluid(72))
                .output(SMD_TRANSISTOR_2, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[LuV])
                .input(foil, Ladder_Poly_P_Phenylene, 4)
                .input(dust, Thorium)
                .input(wireFine, ZBLANGlass, 2)
                .fluidInputs(SeleniumMonobromide.getFluid(125))
                .output(SMD_TRANSISTOR_3, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UHV])
                .input(CARBON_FIBER_FOIL, 8)
                .input(dust, MalonicAcid, 2)
                .input(dustTiny, Naquadah)
                .input(pipeTinyFluid, Gold, 2)
                .fluidInputs(RichAmmoniaMixture.getFluid(125))
                .output(SMD_TRANSISTOR_4, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UXV])
                .input(plate, HeavyQuarkDegenerate, 4)
                .input(foil, Neutronium, 2)
                .input(nanowire, Nihonium)
                .input(springSmall, Taranium)
                .fluidInputs(Leptons.getFluid(125))
                .output(SMD_TRANSISTOR_5, 16)
                .buildAndRegister();

        // CAPACITORS

        ModHandler.addShapedRecipe("capcitor", CAPACITOR.getStackForm(3),
                " F ", "WDW", " F ",
                'F', OreDictUnifier.get(foil, Copper),
                'D', OreDictUnifier.get(dustTiny, Glass),
                'W', OreDictUnifier.get(wireFine, Tin));

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[LV])
                .input(foil, SilicaCeramic, 2)
                .input(foil, NickelPlatedTin, 2)
                .input(wireFine, Tin, 2)
                .fluidInputs(Polyethylene.getFluid(72))
                .output(SMD_CAPACITOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[EV])
                .input(pipeTinyFluid, Polytetrafluoroethylene, 4)
                .input(dustTiny, Neodymium, 4)
                .input(wireFine, Platinum, 4)
                .input(foil, SteelMagnetic)
                .fluidInputs(PolyvinylChloride.getFluid(72))
                .output(SMD_CAPACITOR_2, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[ZPM])
                .input(plate, Iridium, 2)
                .input(nanofoil, Copper, 32)
                .input(gemExquisite, BismuthFerrite)
                .input(wireFine, Naquadah, 2)
                .fluidInputs()
                .output(SMD_CAPACITOR_3, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UHV])
                .input(PETRI_DISH)
                .input(foil, Gold)
                .input(dust, Meat, 8)
                .input(nanowire, Titanium, 32)
                .fluidInputs(DistilledWater.getFluid(125))
                .output(SMD_CAPACITOR_4, 24)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UIV])
                .input(plate, NihoniumTriiodide, 4)
                .input(foil, OganessonTetraTennesside)
                .input(foil, TerfenolD_H)
                .input(nanowire, Vibranium, 32)
                .fluidInputs(Gluons.getFluid(125))
                .output(SMD_CAPACITOR_5, 16)
                .buildAndRegister();

        // DIODES

        ModHandler.addShapedRecipe("diode", DIODE.getStackForm(4),
                " F ", "PDP", " F ",
                'F', OreDictUnifier.get(wireFine, Copper),
                'D', OreDictUnifier.get(foil, Gallium),
                'P', OreDictUnifier.get(plate, Glass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[LV])
                .input(foil, Rubber, 2)
                .input(dustSmall, Gallium)
                .input(dustSmall, Phosphorus)
                .input(wireFine, Copper)
                .fluidInputs(Polyethylene.getFluid(72))
                .output(SMD_DIODE_1, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[IV])
                .input(pipeSmallFluid, Chrome, 2)
                .input(wireFine, BorosilicateGlass, 4)
                .input(plate, ZBLANGlass)
                .input(dustTiny, Indium)
                .input(dustTiny, Germanium)
                .fluidInputs(Ladder_Poly_P_Phenylene.getFluid(72))
                .output(SMD_DIODE_2, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UV])
                .input(FLUID_CELL_GLASS_VIAL, 2)
                .input(STEM_CELLS, 2)
                .input(dust, NaquadahEnriched, 2)
                .input(nanowire, Gold, 2)
                .input(STERILE_POLYMER_FOIL)
                .fluidInputs(SterileGrowthMedium.getFluid(125))
                .output(SMD_DIODE_3, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UEV])
                .input(CNT_LONG, 4)
                .input(bolt, HDCS_1, 4)
                .input(foil, ChromiumGermaniumTellurideMagnetic, 2)
                .input(nanowire, Praseodymium, 16)
                .fluidInputs(Kevlar.getFluid(72))
                .output(SMD_DIODE_4, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UXV])
                .input(ring, HeavyQuarkDegenerate, 4)
                .input(wireFine, OganessonTetraTennesside, 4)
                .input(nanofoil, Neutronium, 2)
                .input(round, Vibranium)
                .fluidInputs(Leptons.getFluid(125))
                .output(SMD_DIODE_5, 16)
                .buildAndRegister();

        // INDUCTORS

        ModHandler.addShapelessRecipe("inductor_handcraft", INDUCTOR.getStackForm(1),
                new UnificationEntry(wireFine, Copper),
                new UnificationEntry(wireFine, Copper),
                new UnificationEntry(ring, Steel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[LV])
                .input(FERROUS_INDUCTOR_CORE)
                .input(wireFine, Copper, 4)
                .fluidInputs(Polyethylene.getFluid(72))
                .output(SMD_INDUCTOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[IV])
                .input(ring, BerylliumOxide, 2)
                .input(wireFine, HSSG, 8)
                .input(plate, MolybdenumDisilicide)
                .fluidInputs(Glass.getFluid(144))
                .output(SMD_INDUCTOR_2, 24)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[ZPM])
                .input(TUNGSTEN_INDUCTOR_CORE)
                .input(wireFine, Platinum, 8)
                .input(foil, Ruthenium)
                .fluidInputs()
                .output(SMD_INDUCTOR_3, 24)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UHV])
                .input(GCMetaItems.CARBON_FIBER_PLATE, 2)
                .input(nanowire, Vanadium, 16)
                .input(wireFine, Palladium, 2)
                .input(LANGMUIR_HOUSING)
                .fluidInputs(Polybenzimidazole.getFluid(72))
                .output(SMD_INDUCTOR_4, 16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(70)
                .EUt(VA[UXV])
                .input(plate, ProgrammableMatter, 2)
                .input(nanofoil, Vibranium)
                .input(SUPERCOOLING_PORT)
                .fluidInputs(SuperfluidHelium3.getFluid(125))
                .output(SMD_INDUCTOR_5, 16)
                .buildAndRegister();


        // MISC. INTERMEDIARIES
        LAMINATOR_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[HV])
                .input(foil, Dubnium)
                .input(foil, Polybenzimidazole, 2)
                .fluidInputs(Polystyrene.getFluid(144))
                .output(LAYERED_POLYMER_FOIL)
                .buildAndRegister();

        EXPOSURE_CHAMBER_RECIPES.recipeBuilder()
                .duration(160)
                .EUt(VA[LuV])
                .input(LAYERED_POLYMER_FOIL)
                .notConsumable(BLACKLIGHT)
                .output(STERILE_POLYMER_FOIL)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[LV])
                .input(bolt, Steel)
                .input(foil, Silicon)
                .fluidInputs(Glass.getFluid(72))
                .output(FERROUS_INDUCTOR_CORE)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[EV])
                .input(bolt, Tungsten)
                .input(foil, NiobiumNitride)
                .fluidInputs(Glass.getFluid(72))
                .output(TUNGSTEN_INDUCTOR_CORE)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[IV])
                .input(plate, SynthDiamond)
                .input(foil, SiliconeRubber)
                .input(nanowire, Palladium, 32)
                .output(TRANSMON_SUPPORT)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(85)
                .EUt(VA[LuV])
                .input(SAPPHIRE_WAFER)
                .input(plate, GalliumNitride)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(SQUID_BASE)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[ZPM])
                .input(SQUID_BASE)
                .fluidInputs(Helium.getPlasma(5))
                .output(LANGMUIR_OSCILATOR)
                .buildAndRegister();

        GCRecipeMaps.MOLECULAR_BEAM_RECIPES.recipeBuilder()
                .duration(100)
                .EUt(VA[UEV])
                .input(LANGMUIR_OSCILATOR)
                .input(dustTiny, GraphenePQD)
                .output(LANGMUIR_HOUSING)
                .buildAndRegister();

        //XenonHexaFluoride

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[EV])
                .fluidInputs(Xenon.getFluid(1000), Fluorine.getFluid(4000))
                .fluidOutputs(XenonTetraFluoride.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(30)
                .EUt(VA[LV])
                .fluidInputs(XenonTetraFluoride.getFluid(1000), DistilledWater.getFluid(2000))
                .fluidOutputs(HydrofluoricAcid.getFluid(4000), XenonDioxide.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(150)
                .EUt(VA[LuV])
                .fluidInputs(XenonDioxide.getFluid(1000), Acetylene.getFluid(1000), HydrofluoricAcid.getFluid(4000))
                .fluidOutputs(XenonOxyTetraFluoride.getFluid(1000), Ethanol.getFluid(1000))
                .buildAndRegister();

        GCRecipeMaps.CRYOGENIC_REACTOR_RECIPES.recipeBuilder()
                .duration(130)
                .EUt(VA[ZPM])
                .fluidInputs(XenonOxyTetraFluoride.getFluid(3000), BoronTrifluoride.getFluid(2000))
                .fluidOutputs(XenonHexaFluoride.getFluid(3000))
                .output(dust, BoronTrioxide, 5)
                .buildAndRegister();

    }
}
