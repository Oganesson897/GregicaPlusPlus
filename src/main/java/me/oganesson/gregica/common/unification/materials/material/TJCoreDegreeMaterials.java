package me.oganesson.gregica.common.unification.materials.material;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.*;
import gregtech.api.unification.ore.OrePrefix;
import me.oganesson.gregica.common.unification.materials.info.GCMaterialIconTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.ore.OrePrefix.Flags.*;
import static me.oganesson.gregica.common.unification.GCElements.*;
import static me.oganesson.gregica.common.unification.materials.GCMaterials.*;

public class TJCoreDegreeMaterials {
    public static void register() {
        registerMaterials();
        registerProperties();
    }

    public static final MaterialFlag GENERATE_NANOWIRE = new MaterialFlag.Builder("generate_nanowire")
            .requireProps(PropertyKey.FLUID)
            .build();

    public static final MaterialFlag GENERATE_NANOFOIL = new MaterialFlag.Builder("generate_nanofoil")
            .requireProps(PropertyKey.FLUID)
            .build();
    public static final OrePrefix nanowire = new OrePrefix("nanowire", GTValues.M / 144, null, GCMaterialIconTypes.nanoWireIcon, ENABLE_UNIFICATION, material -> ((material.getMaterialComponents().size() == 1 && material.isSolid() && material.hasFluid() && (!Arrays.toString(doNotGenerate).contains(material.toString()))) || material.hasFlag(GENERATE_NANOWIRE)));
    public static final OrePrefix nanofoil = new OrePrefix("nanofoil", GTValues.M / 144, null, GCMaterialIconTypes.nanoFoilIcon, ENABLE_UNIFICATION, material -> ((material.getMaterialComponents().size() == 1 && material.isSolid() && material.hasFluid() && (!Arrays.toString(doNotGenerate).contains(material.toString()))) || material.hasFlag(GENERATE_NANOFOIL)));

    public static void registerMaterials(){
        Birmabright = new Material.Builder(25000, "birmabright")
                .ingot().fluid()
                .blastTemp(1100)
                .color(1755371).iconSet(MaterialIconSet.DULL)
                .flags(setMaterialFlags(STANDARDPLATE, STANDARDROD, STANDARDROTOR, STANDARDGEAR, STANDARDSPRING, STANDARDCASING))
                .components(Aluminium, 5, Magnesium, 1, Manganese, 1)
                .build();

        BT6 = new Material.Builder(25001, "bt_6")
                .ingot().fluid()
                .colorAverage().iconSet(MaterialIconSet.SHINY)
                .flags(setMaterialFlags(STANDARDPLATE, STANDARDROD, STANDARDROTOR, STANDARDGEAR, STANDARDSPRING))
                .components(Iron, 3, Carbon, 1, Vanadium, 5, Titanium, 40, Aluminium, 6)
                .blastTemp(3400)
                .build();

        TriphenylPhosphine  = new Material.Builder(25002,"triphenylphosphine")
                .dust()
                .fluid()
                .colorAverage()
                .components(Phosphorus, 1, Carbon, 18, Hydrogen, 15)
                .build()
                .setFormula("P(C6H5)3", true);

        MolybdenumSulfide = new Material.Builder(25004, "molybdenumsulfide")
                .fluid()
                .colorAverage()
                .components(Molybdenum, 1, Sulfur, 2)
                .build()
                .setFormula("MoS2", true);

        PhenylmagnesiumBromide = new Material.Builder(25005,"phenylmagnesiumbromide")
                .fluid()
                .colorAverage()
                .components(Carbon, 6, Hydrogen, 5, Magnesium, 1, Bromine, 1)
                .build()
                .setFormula("C6H5MgBr", true);

        Bromobenzene = new Material.Builder(25006,"bromobenzene")
                .fluid()
                .colorAverage()
                .components(Carbon, 6, Hydrogen, 4, Bromine, 1)
                .build()
                .setFormula("C6H5Br",true);

        Draconium = new Material.Builder(25007, "draconium")
                .ingot().fluid()
                .color(0x573d85).iconSet(MaterialIconSet.DULL)
                .flags(setMaterialFlags(STANDARDPLATE, STANDARDCASING))
                .build();

        SilicaCeramic = new Material.Builder(25008,"silicaceramic")
                .ingot()
                .blastTemp(1000)
                .color(0x8c7a50).iconSet(MaterialIconSet.SHINY)
                .flags(setMaterialFlags(STANDARDPLATE,STANDARDROD,STANDARDFOIL,STANDARDROUND))
                .build();

        NickelPlatedTin = new Material.Builder(25009, "nickelplatedtin")
                .ingot()
                .color(0x8fb7c4).iconSet(MaterialIconSet.SHINY)
                .build();

        //TODO: CARBON make the formula for ladder poly-p-phenylene
        Ladder_Poly_P_Phenylene = new Material.Builder(25011, "polypphenylene")
                .fluid()
                .ingot()
                .color(0xbfb393)
                .flags(setMaterialFlags(STANDARDWIREFINE,STANDARDFOIL))
                .build();

        HydrogenSilsesquioxane = new Material.Builder(25012, "hydrogensilsesquioxane")
                .fluid()
                .color(0x471525)
                .build()
                .setFormula("[HSiO3/2]", true);

        //TODO: CARBON make the formula for SU-8 Photoresist
        SU8_Photoresist = new Material.Builder(25013, "su_photoresist")
                .fluid()
                .color(0x0e242b)
                .build();
        Fiberglass = new Material.Builder(25014, "fiberglass")
                .ingot()
                .color(0x99c0cf)
                .build();

        LuminescentSiliconNanocrystals = new Material.Builder(25015,"luminescentsiliconnanocrystals")
                .dust()
                .iconSet(MaterialIconSet.SHINY)
                .color(0x363636)
                .build();

        SeleniumMonobromide = new Material.Builder(25016, "seleniummonobromide")
                .fluid()
                .color(0x472a1a)
                .build();

        Starlight = new Material.Builder(25019, "starlight")
                .fluid()
                .color(0xebfafc)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        SilverLeadOxide = new Material.Builder(25020, "silverleadoxide")
                .dust()
                .colorAverage()
                .components(Silver, 1, Lead, 1, Oxygen, 1)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        PalladiumChloride = new Material.Builder(25021, "palladiumchloride")
                .dust()
                .colorAverage()
                .components(Palladium, 1, Chlorine, 2)
                .build()
                .setFormula("PdCl2",true);

        TetrakisPDCatalyst = new Material.Builder(25022, "tretrakispdcatalyst")
                .dust()
                .color(0x9bd1e8)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        HydraziniumChloride = new Material.Builder(25023, "hydraziniumchloride")
                .fluid()
                .colorAverage()
                .components(Nitrogen, 2, Hydrogen, 5, Chlorine, 1)
                .build()
                .setFormula("N2H4HCl", true);

        DibromoisophthalicAcid = new Material.Builder(25024, "dibromoisophthalicacid")
                .fluid()
                .colorAverage()
                .components(Carbon, 8, Hydrogen, 5, Bromine, 1, Oxygen, 4)
                .build()
                .setFormula("C8H5BrO4",true);

        Dibromoterephthaloyldichloride = new Material.Builder(25025, "dibromoterephthaloyldichloride")
                .fluid()
                .colorAverage()
                .components(Carbon, 8, Hydrogen, 2, Bromine, 2, Chlorine, 2, Oxygen, 2)
                .build()
                .setFormula("C8H2Br2Cl2O2",true);

        P1Solution = new Material.Builder(25026, "p_one_solution")
                .fluid()
                .color(0x6b0c05)
                .build();

        HafniumSilicate = new Material.Builder(25027, "hafnium_silicate")
                .dust()
                .colorAverage()
                .components(Hafnium, 1, Oxygen, 4, Silicon, 1)
                .build()
                .setFormula("HfO4Si", true);

        Cobalt60 = new Material.Builder(25028,"cobalt_sixty")
                .dust()
                .iconSet(MaterialIconSet.SHINY)
                .color(Cobalt.getMaterialRGB())
                .element(Co60)
                .build()
                .setFormula("Co-60", false);

        //25029 - 25044 RESERVED


        Silane = new Material.Builder(25045, "silane")
                .fluid()
                .colorAverage()
                .components(Silicon, 1, Hydrogen, 4)
                .build()
                .setFormula("SiH4", true);

        ArgonSilane = new Material.Builder(25044, "argon_silane")
                .fluid()
                .plasma()
                .flags(DISABLE_DECOMPOSITION)
                .components(Argon, 1, Silane, 1)
                .color(0x24BB18)
                .build();


        CarbonNanotubePolymer = new Material.Builder(25046, "carbon_nanotube_polymer")
                .dust()
                .ingot()
                .color(0x0d0d0d)
                .iconSet(MaterialIconSet.SHINY)
                .components(CarbonNanotube, 5, Kevlar, 2)
                .build();

        DegenerateRhenium = new Material.Builder(25047, "degenerate_rhenium")
                .dust()
                .ingot()
                .color(0xc9c9c9)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Rhenium, 1)
                .build();

        NihoniumTriiodide = new Material.Builder(25048, "nihonium_triiodide")
                .dust()
                .ingot()
                .color(0x5986a8)
                .iconSet(MaterialIconSet.SHINY)
                .components(Nihonium, 1, Iodine, 3)
                .build();

        SuperheavyL = new Material.Builder(25049, "superheavy_l")
                .dust()
                .ingot()
                .color(0x000a8f)
                .iconSet(MaterialIconSet.SHINY)
                .components(Nobelium, 1, Lawrencium, 1, Meitnerium, 1, Darmstadtium, 1, Roentgenium, 1, Copernicium, 1)
                .build();

        SuperheavyH = new Material.Builder(25050, "superheavy_h")
                .dust()
                .ingot()
                .colorAverage()
                .iconSet(MaterialIconSet.SHINY)
                .components(Nihonium, 1, Flerovium, 1, Moscovium, 1, Livermorium, 1, Tennessine, 1, Oganesson, 1)
                .build();

        Gluons = new Material.Builder(25051, "gluons")
                .fluid()
                .color(0xffffff)
                .build();

        LightQuarks = new Material.Builder(25052, "light_quarks")
                .fluid()
                .color(0x59ff7d)
                .build();

        HeavyQuarks = new Material.Builder(25053, "heavy_quarks")
                .fluid()
                .color(0x4a080b)
                .build();

        BismuthTelluride = new Material.Builder(25054, "bismuth_telluride")
                .ingot()
                .colorAverage()
                .components(Bismuth, 2, Tellurium, 3)
                .build();

        SynthDiamond = new Material.Builder(25055, "synthetic_diamond")
                .dust()
                .gem()
                .color(0x8fbaff)
                .components(Carbon, 8)
                .build();

        GraphenePQD = new Material.Builder(25056, "photoluminescent_graphene_quantum_dots")
                .dust()
                .color(0x616161)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 6)
                .build();

        HeavyQuarkDegenerate = new Material.Builder(25057, "heavy_quark_degenerate_matter")
                .fluid()
                .ingot()
                .color(0x171717)
                .components(Gluons, 1, HeavyQuarks, 4, LightQuarks, 1)
                .build();

        BismuthIridiumOxide = new Material.Builder(25058, "bismuth_iridium_oxide")
                .ingot()
                .colorAverage()
                .components(Bismuth, 2, Iridium, 2, Oxygen, 7)
                .iconSet(MaterialIconSet.DULL)
                .build();

        IndiumFluoride = new Material.Builder(25059, "indium_fluoride")
                .fluid()
                .color(0x2d5c53)
                .components(Indium, 1, Fluorine, 3)
                .build();

        EnrichedNaqAlloy = new Material.Builder(25060, "enriched_naquadah_alloy")
                .ingot()
                .fluid()
                .colorAverage()
                .components(NaquadahEnriched, 16, Einsteinium, 4, Rhodium, 4, Technetium, 4, Astatine, 2, Erbium, 2)
                .blastTemp(9700)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        SodiumPotassiumNiobate = new Material.Builder(25061, "sodium_potassium_niobate")
                .ingot()
                .colorAverage()
                .components(Sodium, 1, Potassium, 1, Niobium, 2, Oxygen, 6)
                .blastTemp(3600)
                .build();

        TriniumSteel = new Material.Builder(25062, "trinium_steel")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(10200)
                .colorAverage()
                .components(Trinium, 18, Tungsten, 6, Vanadium, 4, Chrome, 2, Tantalum, 1, Cobalt, 1)
                .build();

        LeadZirconateTitanate = new Material.Builder(25063, "lead_zirconate_titanate")
                .ingot()
                .iconSet(MaterialIconSet.DULL)
                .blastTemp(6100)
                .color(0x355232)
                .components(Lead, 12, Titanium, 1, Zirconium, 1, Oxygen, 16)
                .build();

        XenonFluorideSupercondiveMix = new Material.Builder(25064, "xenon_fluoride_mix")
                .fluid()
                .color(0x251a33)
                .build();


        XenonOxyTetraFluoride = new Material.Builder(25065, "xenon_oxytetrafluoride")
                .fluid()
                .colorAverage()
                .components(Xenon, 1, Oxygen, 1, Fluorine, 4)
                .build();

        XenonDioxide = new Material.Builder(25066, "xenon_dioxide")
                .fluid()
                .colorAverage()
                .components(Xenon, 1, Oxygen, 2)
                .build();

        XenonTetraFluoride = new Material.Builder(25067, "xenon_tetrafluoride")
                .fluid()
                .color(0x3d1e42)
                .components(Xenon, 1, Fluorine, 4)
                .build();
        XenonHexaFluoride = new Material.Builder(25068, "xenon_hexafluoride")
                .fluid()
                .color(0x8d5cff)
                .components(Xenon, 1, Fluorine, 6)
                .build();

        TerfenolD_H = new Material.Builder(25069, "terfenol_d_heavy")
                .ingot()
                .blastTemp(10200)
                .components(Osmium, 12, Iron, 6, Dysprosium, 2, Terbium, 1)
                .color(0x4d4d4d)
                .build();

        TerfenolD_L = new Material.Builder(25070, "terfenol_d_light")
                .ingot()
                .blastTemp(10200)
                .components(Lithium7, 12, Iron, 6, Dysprosium, 2, Terbium, 1)
                .color(0x9c9c9c)
                .build();

        SuspendedPGQD = new Material.Builder(25071, "suspended_pgqd")
                .fluid()
                .color(0x65ad95)
                .components(Krypton, 1, GraphenePQD, 1)
                .build();

        Leptons = new Material.Builder(25072, "leptons")
                .fluid()
                .color(0x5500ff)
                .build();

        NeonFluoride = new Material.Builder(25073, "neon_fluoride")
                .fluid()
                .colorAverage()
                .components(Neon, 1, Fluorine, 1)
                .build();

        ExcitedNeonFluoride = new Material.Builder(25074, "excited_neon_fluoride")
                .fluid()
                .colorAverage()
                .color(NeonFluoride.getMaterialRGB())
                .components(NeonFluoride, 1)
                .build();

        ArgonFluorine = new Material.Builder(25075, "argon_fluorine")
                .fluid()
                .color(0x00ff88)
                .components(Argon, 1, Fluorine, 1)
                .build();

        SilverGalliumSelenide = new Material.Builder(25076, "silver_gallium_selenide")
                .dust()
                .colorAverage()
                .components(Silver, 1, Gallium, 1, Selenium, 2)
                .build();

        BismuthPhosphomolybdate = new Material.Builder(25077, "bismuth_phosphomolybdate")
                .dust()
                .colorAverage()
                .components(Bismuth, 9, Phosphorus, 1, Molybdenum, 12, Oxygen, 52)
                .build();

        Acrylonitrile = new Material.Builder(25078, "acrylonitrile")
                .fluid()
                .color(0x565734)
                .components(Carbon, 3, Hydrogen, 3, Nitrogen, 1)
                .build()
                .setFormula("CH2CHCN", true);

        SodiumThiocyanate = new Material.Builder(25079, "sodium_thiocyanate")
                .dust()
                .colorAverage()
                .components(SodiumCyanide, 1, Sulfur, 1)
                .build();

        SodiumThiocyanatePolymerizationSolution = new Material.Builder(25080, "sodiumthiocyanatepolymerizationsolution")
                .fluid()
                .colorAverage()
                .components(Water, 1, SodiumThiocyanate, 1)
                .build();

        Polyacrylonitrile = new Material.Builder(25081, "polyacrylonitrile")
                .dust()
                .color(0x854218)
                .build();

        CFCoatingSolution = new Material.Builder(25082, "cf_coating_solution")
                .fluid()
                .colorAverage()
                .components(PolyvinylChloride, 1, Polyethylene, 1)
                .build();

        GalvanizedSteel = new Material.Builder(25083, "galvanized_steel")
                .ingot()
                .color(0xb5b5b5)
                .components(Iron, 9, Zinc, 1)
                .iconSet(MaterialIconSet.SHINY)
                .arcSmeltInto(Steel)
                .flags(DISABLE_DECOMPOSITION, NO_WORKING, NO_SMASHING, NO_SMELTING)
                .build();

        Polyetheretherketone = new Material.Builder(25086, "peek")
                .ingot()
                .fluid()
                .iconSet(MaterialIconSet.DULL)
                .color(0x2b2b2b)
                .build()
                .setFormula("C20H12O3", true);

        ProgrammableMatter = new Material.Builder(25087, "programmable_matter")
                .ingot()
                .fluid()
                .color(0x8196a3)
                .iconSet(MaterialIconSet.SHINY)
                .build()
                .setFormula("robots!", false);

        LutetiumTantalate = new Material.Builder(25088, "lutetium_tantalite")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .components(Lutetium, 1, Tantalum, 1, Oxygen, 4)
                .color(0xaccde6)
                .build();

        Iridrhodruthenium = new Material.Builder(25089, "iridrhodruthenium")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .components(Ruthenium, 8, Rhodium, 1, Iridium, 1)
                .colorAverage()
                .build();

        HEA_1 = new Material.Builder(25090, "high_entropy_alloy_1")
                .ingot()
                .iconSet(MaterialIconSet.METALLIC)
                .components(Chrome, 5, Niobium, 8, Silicon, 7, Titanium, 3, Zirconium, 5)
                .colorAverage()
                .build();

        HEA_2 = new Material.Builder(25091, "high_entropy_alloy_2")
                .ingot()
                .fluid()
                .iconSet(MaterialIconSet.METALLIC)
                .components(Zirconium, 6, Tungsten, 4, Vanadium, 5, Cobalt, 3, Manganese, 4)
                .colorAverage()
                .build();

        HEA_3 = new Material.Builder(25092, "high_entropy_alloy_3")
                .ingot()
                .fluid()
                .iconSet(MaterialIconSet.SHINY)
                .components(Aluminium, 5, Chrome, 5, Molybdenum, 7, Tantalum, 9, Titanium, 6, Zirconium, 4, Nitrogen, 21)
                .colorAverage()
                .build();

        HDCS_1 = new Material.Builder(25093, "high_durability_compound_steel_1")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .color(0x2e216e)
                .components(Naquadria, 10, Americium, 4, ChromiumGermaniumTellurideMagnetic, 4, Vanadium, 3, Rhenium, 2, Lithium, 2)
                .build();

        HDCS_2 = new Material.Builder(25094, "high_durability_compound_steel_2")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .color(0x3d0b0e)
                .components(Adamantium, 8, Fermium, 4, EnrichedNaqAlloy, 4, Germanium, 3, BismuthChalcogenide, 3, Arsenic, 3, Beryllium, 2)
                .build();

        HDCS_3 = new Material.Builder(25095, "high_durability_compound_steel_3")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .color(0x1f0126)
                .components(Vibranium, 12, TriniumSteel, 8, Rutherfordium, 6, Promethium, 4, Scandium, 4, Hassium, 1)
                .build();

        Pikyonium = new Material.Builder(25096, "pikyonium")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .color(0x3770bf)
                .components(HSSE, 12, Seaborgium, 7, Lead, 5, Molybdenum, 5, Beryllium, 3, Gallium, 3, Iodine, 2, Mercury, 2)
                .build();

        HafniumCarbide = new Material.Builder(25097, "hafnium_carbide")
                .dust()
                .iconSet(MaterialIconSet.METALLIC)
                .colorAverage()
                .components(Hafnium, 1, Carbon, 1)
                .build();

        TantalumCarbide = new Material.Builder(25098, "tantalum_carbide")
                .dust()
                .iconSet(MaterialIconSet.METALLIC)
                .colorAverage()
                .components(Tantalum, 1, Carbon, 1)
                .build();

        SeaborgiumCarbide = new Material.Builder(25099, "seaborgium_carbide")
                .dust()
                .iconSet(MaterialIconSet.METALLIC)
                .colorAverage()
                .components(Seaborgium, 1, Carbon, 1)
                .build();

        TantalumHafniumSeaborgiumCarbide = new Material.Builder(25100, "tantalum_hafnium_seaborgium_carbide")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .colorAverage()
                .components(TantalumCarbide, 3, HafniumCarbide, 1, SeaborgiumCarbide, 3)
                .build();

        TantalumHafniumSeaborgiumCarboNitride = new Material.Builder(25101, "tantalum_hafnium_seaborgium_carbonitide")
                .ingot()
                .iconSet(MaterialIconSet.SHINY)
                .color(0x1c1c1c)
                .components(TantalumHafniumSeaborgiumCarbide, 1, Nitrogen, 1)
                .build()
                .setFormula("4TaHf3Sg10C7N");

        OganessonTetraTennesside = new Material.Builder(25102, "oganessontetratennesside")
                .ingot()
                .iconSet(MaterialIconSet.METALLIC)
                .colorAverage()
                .components(Oganesson, 1, Tennessine, 4)
                .build();

        Methyltrichlorosilane = new Material.Builder(25103, "methyltrichlorosilane")
                .fluid()
                .colorAverage()
                .components(Carbon, 1, Hydrogen, 3, Chlorine, 3, Silicon, 1)
                .build()
                .setFormula("CH3Cl3Si", true);

        Methyltrimethoxysilane = new Material.Builder(25104, "methyltrimethyoxysilane")
                .fluid()
                .color(0x42163c)
                .components(Silicon, 1, Oxygen, 3, Carbon, 4, Hydrogen, 12)
                .build()
                .setFormula("CH3Si(OCH3)3", true);

        Polymethylsilesquioxane = new Material.Builder(25105, "polymethylsilesquioxane")
                .fluid()
                .color(0xff7ab4)
                .components(Silicon, 1, Oxygen, 3, Carbon, 4, Hydrogen, 12)
                .build()
                .setFormula("[CH3Si(OCH3)3]N", true);

        Cellulose = new Material.Builder(25106, "cellulose")
                .dust()
                .color(0xd9d9d9)
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 5)
                .build();

        IridiumOnCubicZirconia = new Material.Builder(25107, "iridiumoncubiczirconia")
                .dust()
                .colorAverage()
                .components(Iridium, 1, CubicZirconia, 1)
                .build();

        OnePropanol = new Material.Builder(25108, "onepropanol")
                .fluid()
                .color(0xbad17b)
                .components(Carbon, 3, Hydrogen, 8, Oxygen, 1)
                .build()
                .setFormula("CH3CH2CH2OH", true);

        ZSM_5_ZEOLITE = new Material.Builder(25109, "zsm_five_zeolite")
                .dust()
                .color(0xb8ffe1)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(Na13Al13Si83O192)16H2O", true);

        SodiumHydroxideSilica = new Material.Builder(25110, "sodiumhydroxidesilica")
                .fluid()
                .color(0x213996)
                .iconSet(MaterialIconSet.FLUID)
                .components(SodiumHydroxide, 1, SiliconDioxide, 1, Water, 1)
                .build();

        SodiumAluminate = new Material.Builder(25111, "sodiumaluminate")
                .dust()
                .colorAverage()
                .components(Sodium, 1, Aluminium, 1, Oxygen, 2)
                .build();

        SodiumAluminumSilicaSolution = new Material.Builder(25112, "aluminumsilicasolution")
                .fluid()
                .color(0xb0c1ff)
                .components(Sodium, 1, Aluminium, 1, Silicon, 1, Oxygen, 2, Water, 1)
                .build();

        AluminoSilicateGlass = new Material.Builder(25113, "aluminosilicateglass")
                .ingot()
                .flags(GENERATE_PLATE)
                .color(0x9a9fb3)
                .iconSet(MaterialIconSet.SHINY)
                .components(Aluminium, 1, Silicon, 1, Oxygen, 4)
                .build();

        DimethylCarbonate = new Material.Builder(25115, "dimethylcarbonate")
                .fluid()
                .colorAverage()
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 3)
                .build()
                .setFormula("(CH3O)2CO",true);

        TetramethylammoniumBromide = new Material.Builder(25116, "tetramethylammoniumbromide")
                .dust()
                .colorAverage()
                .components(Carbon, 4, Hydrogen, 12, Nitrogen, 1, Bromine, 1)
                .build()
                .setFormula("(CH3)4NBr",true);

        DiamondSonicationSolution = new Material.Builder(25117, "diamondsonicationsolution")
                .fluid()
                .colorAverage()
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphite, 1, Phenol, 1)
                .build();

        SuperfluidHelium3 = new Material.Builder(25118, "superfluidhelium")
                .fluid()
                .colorAverage()
                .flags(DISABLE_DECOMPOSITION)
                .components(Helium3, 1)
                .build();

        CobaltChloride = new Material.Builder(25119, "cobaltchloride")
                .fluid()
                .color(0x48559F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Cobalt, 1, Chlorine, 2)
                .build();

        CobaltIodide = new Material.Builder(25120, "cobaltiodide")
                .fluid()
                .colorAverage()
                .flags(DISABLE_DECOMPOSITION)
                .components(Cobalt, 1, Iodine, 2)
                .build();

        Cobalt59 = new Material.Builder(25121, "cobalt_59")
                .dust()
                .color(0x3D3DFA)
                .build()
                .setFormula("Co-59", false);

        Cobalt59Iodide = new Material.Builder(25122, "cobalt_59_iodide")
                .fluid()
                .color(0x0B0058)
                .components(Cobalt59, 1, Iodine, 2)
                .build();

        Cobalt60Iodide = new Material.Builder(25123, "cobalt_60_iodide")
                .fluid()
                .colorAverage()
                .components(Cobalt60, 1, Iodine, 2)
                .build();

        HydroiodicAcid = new Material.Builder(25124, "hydroiodicacid")
                .fluid()
                .colorAverage()
                .components(Hydrogen, 1, Iodine, 1)
                .build();

        ImpureHydroiodicAcid = new Material.Builder(25125, "impurehydroiodicacid")
                .fluid()
                .colorAverage()
                .flags(DISABLE_DECOMPOSITION)
                .components(HydroiodicAcid, 1, Water, 1)
                .build()
                .setFormula("N2(HI)2H2O",true);

        Butynediol = new Material.Builder(25126, "butynediol")
                .fluid()
                .colorAverage()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        KAOil = new Material.Builder(25127, "ka_oil")
                .fluid()
                .color(0xFA7B53)
                .components(Carbon, 12, Hydrogen, 22, Oxygen, 2)
                .build()
                .setFormula("2(C6H11OH)2((CH2)5CO)", true);

        AdipicAcid = new Material.Builder(25128, "adipic_acid")
                .dust()
                .colorAverage()
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 4)
                .build()
                .setFormula("C6H8O2(OH)2", true);

        NitrousAcid = new Material.Builder(25138, "nitrous_acid")
                .fluid()
                .colorAverage()
                .components(Hydrogen, 1, Nitrogen, 1, Oxygen, 2)
                .build();

        BariumOxide = new Material.Builder(25129, "barium_oxide")
                .dust()
                .colorAverage()
                .components(Barium, 1, Oxygen, 1)
                .build();

        BariumHydroxide = new Material.Builder(25130, "barium_hydroxide")
                .dust()
                .colorAverage()
                .components(Barium, 1, Hydrogen, 1, Oxygen, 1)
                .build();

        Cyclopentanone = new Material.Builder(25131, "cyclopentanone")
                .fluid()
                .colorAverage()
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 1)
                .build()
                .setFormula("(CH2)4CO",true);

        BenzenesulfonicAcid = new Material.Builder(25132, "benzenesulfonic_acid")
                .dust()
                .colorAverage()
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 3, Sulfur, 1)
                .build();

        TriphenylsulfoniumHexafluoroantimonate = new Material.Builder(25133, "triphenylsulfonium_hexafluoroantimonate")
                .fluid()
                .color(0x8968FA)
                .components(Carbon, 18, Hydrogen, 15, Sulfur, 1, Antimony, 1, Fluorine, 6)
                .build();

        HypofluorousAcid = new Material.Builder(25134, "hypofluorous_acid")
                .fluid()
                .colorAverage()
                .components(Hydrogen, 1, Fluorine, 1, Oxygen, 1)
                .build();

        HexafluoroantimonateSalt1 = new Material.Builder(25135, "hexafluoroantimonate_salt_1")
                .fluid()
                .color(0x26095F)
                .components(Carbon, 36, Hydrogen, 28, Sulfur, 3, Antimony, 2, Fluorine, 12)
                .build()
                .setFormula("C36H28S3(SbF6)2", true);

        HexafluoroantimonateSalt2 = new Material.Builder(25136, "hexafluoroantimonate_salt_2")
                .fluid()
                .color(0x5A2F9F)
                .components(Carbon, 24, Hydrogen, 19, Sulfur, 2, Antimony, 1, Fluorine, 6)
                .build();

        MixedHexafluoroantimonateSalts = new Material.Builder(25137, "mixed_hexafluoroantimonate_salts")
                .fluid()
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .colorAverage()
                .components(HexafluoroantimonateSalt1, 1, HexafluoroantimonateSalt2, 1)
                .build();

        DiluteFluoroantimonicAcid = new Material.Builder(25139, "dilute_fluoroantimonic_acid")
                .fluid()
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .components(Hydrogen, 1, Antimony, 1, Fluorine, 6)
                .build();

        IndiumSolution = new Material.Builder(25140, "indium_solution")
                .fluid()
                .color(0x58474C)
                .flags(DISABLE_DECOMPOSITION)
                .build()
                .setFormula("(H2SO4)?", true);

        IndiumSulfide = new Material.Builder(25141, "indium_sulfide")
                .dust()
                .iconSet(MaterialIconSet.SHINY)
                .colorAverage()
                .components(Indium, 2, Sulfur, 3)
                .build();

        IndiumResidue = new Material.Builder(25142, "indium_refining_residue")
                .fluid()
                .iconSet(MaterialIconSet.LIGNITE)
                .color(0x060921)
                .build();

        ZirconiumTetrafluoride = new Material.Builder(25143, "zirconium_fluoride")
                .dust()
                .colorAverage()
                .components(Zirconium, 1, Fluorine, 4)
                .build();

        BariumDifluoride = new Material.Builder(25144, "barium_fluoride")
                .dust()
                .colorAverage()
                .components(Barium, 1, Fluorine, 2)
                .build();

        LanthanumTrifluoride = new Material.Builder(25145, "lanthanum_fluoride")
                .dust()
                .colorAverage()
                .components(Lanthanum, 1, Fluorine, 3)
                .build();

        AluminiumTrifluoride = new Material.Builder(25146, "aluminium_fluoride")
                .dust()
                .colorAverage()
                .components(Aluminium, 1, Fluorine, 3)
                .build();

        SodiumFluoride = new Material.Builder(25147, "sodium_fluoride")
                .dust()
                .colorAverage()
                .components(Sodium, 1, Fluorine, 1)
                .build();

        BauxiteSlurry = new Material.Builder(25148, "bauxite_slurry")
                .fluid()
                .color(0x51040A)
                .build();

        IlmeniteSlurry = new Material.Builder(25149, "ilmenite_slurry")
                .fluid()
                .color(0x0A0212)
                .build();

        RedMud = new Material.Builder(25150, "red_mud")
                .fluid()
                .colorAverage()
                .flags(DISABLE_DECOMPOSITION)
                .components(Rutile, 1, HydrochloricAcid, 2)
                .build();

        HeavyRedMudResidue = new Material.Builder(25151, "red_mud_residue")
                .fluid()
                .color(0x091012)
                .build();

        RefractoryMetalResidue = new Material.Builder(25152, "refractory_metal_residue")
                .fluid()
                .color(0x164347)
                .build();

        PotassiumHexafluorohafnate = new Material.Builder(25153, "potassium_hexafluorohafnate")
                .gem()
                .colorAverage()
                .components(Potassium, 2, Hafnium, 1, Fluorine, 6)
                .build();

        PotassiumHexafluorozirconate = new Material.Builder(25154, "potassium_hexafluorozironate")
                .gem()
                .colorAverage()
                .components(Potassium, 2, Zirconium, 1, Fluorine, 6)
                .build();

        HafniumTetrachloride = new Material.Builder(25155, "hafnium_tetrachloride")
                .fluid()
                .colorAverage()
                .components(Hafnium, 1, Chlorine, 4)
                .build();

        ZirconiumTetrachloride = new Material.Builder(25156, "zirconium_tetrachloride")
                .fluid()
                .colorAverage()
                .components(Zirconium, 1, Chlorine, 4)
                .build();

        PotassiumFluorideRefractoryMixture = new Material.Builder(25157, "potassium_fluoride_refractory_mixture")
                .fluid()
                .color(0x667E71)
                .build();

        Trichlorosilane = new Material.Builder(25158, "trichlorosilane")
                .fluid()
                .colorAverage()
                .components(Hydrogen, 1, Silicon, 1, Chlorine, 3)
                .build();

        PotassiumHydride = new Material.Builder(25181, "potassium_hydride")
                .dust()
                .components(Potassium, 1, Hydrogen, 1)
                .colorAverage()
                .build();

        Aminopropionitrile = new Material.Builder(25159, "aminopropionitrile")
                .fluid()
                .components(Carbon, 3, Hydrogen, 6, Nitrogen, 2)
                .colorAverage()
                .build();

        Aminopropylamine = new Material.Builder(25160, "aminopropylamine")
                .fluid()
                .components(Carbon, 3, Hydrogen, 10, Nitrogen, 2)
                .colorAverage()
                .build();

        KAPA = new Material.Builder(25161, "kapa")
                .fluid()
                .components(Potassium, 2, Carbon, 3, Hydrogen, 10, Nitrogen, 2)
                .colorAverage()
                .build();

        BetaPinene  = new Material.Builder(25162, "betapinene")
                .dust()
                .components(Carbon, 10, Hydrogen, 16)
                .colorAverage()
                .build();

        AlphaPinene = new Material.Builder(25163, "alphapinene")
                .dust()
                .components(Carbon, 10, Hydrogen, 16)
                .colorAverage()
                .build();

        Camphene = new Material.Builder(25164, "camphene")
                .dust()
                .components(Carbon, 10, Hydrogen, 16)
                .colorAverage()
                .build();

        IsobornylAcetate = new Material.Builder(25165, "isobornyl_acetate")
                .dust()
                .components(Carbon, 12, Hydrogen, 20, Oxygen, 2)
                .colorAverage()
                .build();

        Isoborneol = new Material.Builder(25166, "isoborneol")
                .dust()
                .components(Carbon, 10, Hydrogen, 18, Oxygen, 1)
                .colorAverage()
                .build();

        SodiumAcetate = new Material.Builder(25167, "sodium_acetate")
                .fluid()
                .components(Carbon, 2, Hydrogen, 3, Sodium, 1, Oxygen, 2)
                .colorAverage()
                .build()
                .setFormula("CH3COONa", true);

        DehydrogenationCatalyst = new Material.Builder(25168, "dehydrogenation_catalyst")
                .dust()
                .components()
                .color(0x2C1711)
                .build();

        SodiumPerchlorate = new Material.Builder(25169, "sodium_perchlorate")
                .dust()
                .iconSet(MaterialIconSet.BRIGHT)
                .components(Sodium, 1, Chlorine, 1, Oxygen, 4)
                .colorAverage()
                .build();

        PerchloricAcid = new Material.Builder(25170, "perchloric_acid")
                .fluid()
                .components(Hydrogen, 1, Chlorine, 1, Oxygen, 4)
                .colorAverage()
                .build();

        Phenylhydrazine = new Material.Builder(25171, "phenylhydrazine")
                .fluid()
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .colorAverage()
                .build();

        BenzoylChloride = new Material.Builder(25172, "benzoyl_chloride")
                .fluid()
                .components(Carbon, 7, Hydrogen, 5, Chlorine, 1, Oxygen, 1)
                .colorAverage()
                .build();

        TriphenylMethoxytriazoylPerchlorate = new Material.Builder(25173, "triphenyl_methoxytriazoyl_perchlorate")
                .dust()
                .components(Carbon, 20, Hydrogen, 20, Oxygen, 6, Chlorine, 1, Nitrogen, 3)
                .flags()
                .colorAverage()
                .build();

        SodiumMethoxide = new Material.Builder(25174, "sodium_methoxide")
                .dust()
                .components(Carbon, 1, Hydrogen, 3, Sodium, 1, Oxygen, 1)
                .colorAverage()
                .build();

        TriphenylMethoxytriazole = new Material.Builder(25175, "triphenyl_methoxytriazole")
                .dust()
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 21, Hydrogen, 23, Oxygen, 3, Nitrogen, 3)
                .colorAverage()
                .build();

        Acetaldehyde = new Material.Builder(25176, "acetaldehyde")
                .fluid()
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .colorAverage()
                .build();

        Acetoin  = new Material.Builder(25178, "acetoin")
                .fluid()
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 2)
                .colorAverage()
                .build();

        MetaNitrochlorobenzine = new Material.Builder(25179, "meta_nitrochlorobenzine")
                .fluid()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 1, Nitrogen, 1, Oxygen, 2)
                .colorAverage()
                .build();

        Nitroanisole = new Material.Builder(25180, "nitroanisole")
                .fluid()
                .components(Carbon, 7, Hydrogen, 7, Nitrogen, 1, Oxygen, 3)
                .colorAverage()
                .build();

        Anisidine = new Material.Builder(25182, "anisidine")
                .fluid()
                .components(Carbon, 7, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        MethylBromoacetate = new Material.Builder(25183, "methyl_bromoacetate")
                .dust()
                .colorAverage()
                .components(Carbon, 3, Hydrogen, 5, Bromine, 1, Oxygen, 2)
                .build();

        CarbethoxymethyleneTriphenylphosphorane = new Material.Builder(25184, "carbomethoxy_methylenetriphenylphosphorane")
                .dust()
                .colorAverage()
                .components(Carbon, 22, Hydrogen, 21, Oxygen, 2, Phosphorus, 1)
                .build();

        PropargylAlcohol = new Material.Builder(25185, "propargyl_alcohol")
                .fluid()
                .colorAverage()
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 1)
                .build();

        PropargylBromide = new Material.Builder(25186, "propargyl_bromide")
                .fluid()
                .colorAverage()
                .components(Carbon, 3, Hydrogen, 3, Bromine, 1)
                .build();

        MethylmagnesiumIodide = new Material.Builder(25187, "methylmagnesium_iodide")
                .dust()
                .colorAverage()
                .components(Carbon, 1, Hydrogen, 3, Iodine, 1, Magnesium, 1)
                .build()
                .setFormula("CH3COCl", true);

        AcetylChloride = new Material.Builder(25188, "acetyl_chloride")
                .fluid()
                .colorAverage()
                .components(Carbon, 2, Hydrogen, 3, Oxygen, 1, Chlorine, 1)
                .build();

        Acetophenone = new Material.Builder(25189, "acetophenone")
                .fluid()
                .colorAverage()
                .components(Carbon, 8, Hydrogen, 8, Oxygen, 1)
                .build()
                .setFormula("C6H5COCH3", true);

        Phenylethylamine = new Material.Builder(25190, "phenylethylamine")
                .fluid()
                .colorAverage()
                .components(Carbon, 8, Hydrogen, 11, Nitrogen, 1)
                .build();

        PhenylethylIsocyanate = new Material.Builder(25191, "phenylethyl_isocyanate")
                .fluid()
                .colorAverage()
                .components(Carbon, 9, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .build();

        TriethyloxoniumTetrafluoroborate = new Material.Builder(25192, "triethyloxonium_tetrafluoroborate")
                .dust()
                .colorAverage()
                .components(Carbon, 6, Hydrogen, 15, Oxygen, 1, Boron, 1, Fluorine, 4)
                .build()
                .setFormula("(C2H5)3O(BF4)", true);

        TrischloroethoxypopanylBorate = new Material.Builder(25193, "trischloroethoxypopanyl_borate")
                .dust()
                .colorAverage()
                .components()
                .build();

        SulfuricFlueGas = new Material.Builder(25194, "sulfuric_flue_gas")
                .fluid()
                .color(0x6B6623)
                .build();

        SulfuricIronSlag = new Material.Builder(25195, "sulfuric_iron_slag")
                .ingot()
                .iconSet(MaterialIconSet.ROUGH)
                .color(0x616B33)
                .build();

        SulfuricCopperSlag = new Material.Builder(25196, "sulfuric_copper_slag")
                .ingot()
                .iconSet(MaterialIconSet.ROUGH)
                .color(0x975128)
                .build();

        SulfuricNickelSlag = new Material.Builder(25197, "sulfuric_nickel_slag")
                .ingot()
                .iconSet(MaterialIconSet.ROUGH)
                .color(0x769197)
                .build();

        SulfuricZincSlag = new Material.Builder(25198, "sulfuric_zinc_slag")
                .ingot()
                .iconSet(MaterialIconSet.ROUGH)
                .color(0xB5AECA)
                .build();


        // SCRIPTS FOR TJCORE HAS 29000-30000
    }

    public static void registerProperties() {

        // Glass + Ceramics
        Alumina.addFlags(DISABLE_DECOMPOSITION);
        BismuthIridiumOxide.addFlags(NO_WORKING, NO_SMASHING, GENERATE_PLATE);
        BismuthTelluride.addFlags(GENERATE_FOIL);
        Fiberglass.addFlags(GENERATE_FINE_WIRE, GENERATE_FOIL);
        LeadZirconateTitanate.addFlags(GENERATE_PLATE, GENERATE_RING);
        SilicaCeramic.addFlags(NO_WORKING, NO_SMELTING, GENERATE_RING, GENERATE_FOIL);
        SodiumPotassiumNiobate.addFlags(GENERATE_FOIL, GENERATE_ROUND);

        // Polymers
        CarbonNanotubePolymer.addFlags(GENERATE_FRAME, GENERATE_PLATE, NO_WORKING, NO_SMASHING, NO_SMELTING);
        Epoxy.addFlags(GENERATE_FOIL);
        PedotPSS.addFlags(GENERATE_FRAME);
        PedotTMA.addFlags(GENERATE_FINE_WIRE);
        Polybenzimidazole.addFlags(GENERATE_FINE_WIRE);
        Polyetheretherketone.addFlags(GENERATE_PLATE, GENERATE_FOIL);
        Polyethylene.addFlags(GENERATE_FINE_WIRE);
        PolyphenyleneSulfide.addFlags(GENERATE_FINE_WIRE);
        Polytetrafluoroethylene.addFlags(GENERATE_FINE_WIRE, GENERATE_LONG_ROD);
        PolyvinylButyral.addFlags(GENERATE_FOIL, GENERATE_RING);
        PolyvinylChloride.addFlags(GENERATE_FINE_WIRE);
        ReinforcedEpoxyResin.addFlags(GENERATE_FOIL);

        // Metals
        Aluminium.addFlags(GENERATE_ROTOR);
        Bohrium.addFlags(GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_FOIL, GENERATE_FRAME, GENERATE_DENSE, GENERATE_LONG_ROD);
        Brass.addFlags(GENERATE_FOIL, GENERATE_LONG_ROD);
        Carbon.addFlags(GENERATE_FINE_WIRE);
        Chrome.addFlags(GENERATE_FOIL);
        ChromiumGermaniumTellurideMagnetic.addFlags(GENERATE_FOIL);
        Cobalt.addFlags(GENERATE_FINE_WIRE);
        Draconium.addFlags(GENERATE_ROTOR);
        Dubnium.addFlags(GENERATE_FOIL, GENERATE_ROUND, GENERATE_FINE_WIRE, GENERATE_NANOWIRE, GENERATE_LONG_ROD);
        Duranium.addFlags(GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_NANOFOIL);
        Dysprosium.addFlags(GENERATE_PLATE, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_FRAME);
        EnrichedNaqAlloy.addFlags(GENERATE_LONG_ROD, GENERATE_DENSE, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_ROUND, GENERATE_FRAME);
        ErbiumDopedZBLANGlass.addFlags(GENERATE_FOIL, GENERATE_FINE_WIRE);
        Fermium.addFlags(GENERATE_FOIL, GENERATE_SPRING_SMALL, GENERATE_NANOWIRE);
        GalvanizedSteel.addFlags(GENERATE_ROUND, GENERATE_FRAME, GENERATE_ROTOR, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_BOLT_SCREW, GENERATE_PLATE, GENERATE_SPRING_SMALL, GENERATE_SPRING, GENERATE_RING);
        Graphene.addFlags(GENERATE_NANOFOIL);
        HDCS_1.addFlags(GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_DENSE, GENERATE_ROUND, GENERATE_SMALL_GEAR, GENERATE_GEAR, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD);
        HDCS_2.addFlags(GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_DENSE, GENERATE_ROUND, GENERATE_SMALL_GEAR, GENERATE_GEAR, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD);
        HDCS_3.addFlags(GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_DENSE, GENERATE_ROUND, GENERATE_SMALL_GEAR, GENERATE_GEAR, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD);
        HEA_1.addFlags(GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_DENSE, GENERATE_ROUND, GENERATE_LONG_ROD);
        HEA_2.addFlags(GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_DENSE, GENERATE_ROUND, GENERATE_LONG_ROD);
        HEA_3.addFlags(GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_DENSE, GENERATE_ROUND, GENERATE_LONG_ROD);
        HSSG.addFlags(GENERATE_ROUND);
        HeavyQuarkDegenerate.addFlags(GENERATE_ROUND, GENERATE_ROTOR, GENERATE_FRAME, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW, GENERATE_RING, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_NANOWIRE, DISABLE_DECOMPOSITION, NO_SMELTING, NO_SMASHING, NO_WORKING);
        Iridrhodruthenium.addFlags(GENERATE_PLATE, GENERATE_FRAME, GENERATE_RING, GENERATE_ROD, GENERATE_LONG_ROD);
        LutetiumTantalate.addFlags(GENERATE_PLATE, GENERATE_FRAME, GENERATE_RING, GENERATE_ROD, GENERATE_LONG_ROD);
        NeodymiumMagnetic.addFlags(GENERATE_FOIL, GENERATE_RING);
        Neutronium.addFlags(GENERATE_ROTOR, GENERATE_FINE_WIRE, GENERATE_FOIL, GENERATE_ROUND);
        Nichrome.addFlags(GENERATE_BOLT_SCREW, GENERATE_FINE_WIRE, GENERATE_RING);
        NickelPlatedTin.addFlags(GENERATE_FOIL);
        Nihonium.addFlags(GENERATE_PLATE, GENERATE_NANOWIRE);
        NihoniumTriiodide.addFlags(GENERATE_FINE_WIRE, GENERATE_RING);
        OganessonTetraTennesside.addFlags(GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_SPRING);
        Osmium.addFlags(GENERATE_FINE_WIRE, GENERATE_SPRING, GENERATE_SPRING_SMALL);
        Palladium.addFlags(GENERATE_BOLT_SCREW, GENERATE_FRAME);
        Pikyonium.addFlags(GENERATE_FINE_WIRE);
        PlutoniumPhosphide.addFlags(GENERATE_NANOFOIL);
        PolystyreneSulfonate.addFlags(GENERATE_FOIL);
        Praseodymium.addFlags(GENERATE_NANOWIRE);
        PraseodymiumDopedZBLANGlass.addFlags(GENERATE_FOIL, GENERATE_FINE_WIRE);
        ProgrammableMatter.addFlags(GENERATE_PLATE, GENERATE_FRAME, GENERATE_LONG_ROD);
        RhodiumPlatedPalladium.addFlags(GENERATE_FRAME);
        Rutherfordium.addFlags(GENERATE_FOIL);
        Seaborgium.addFlags(GENERATE_BOLT_SCREW, GENERATE_PLATE, GENERATE_NANOFOIL, GENERATE_FOIL);
        Silicon.addFlags(GENERATE_ROD);
        Steel.addFlags(GENERATE_ROUND);
        SuperheavyH.addFlags(GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW);
        SuperheavyL.addFlags(GENERATE_LONG_ROD, GENERATE_FRAME, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_RING, GENERATE_BOLT_SCREW);
        SynthDiamond.addFlags(GENERATE_PLATE);
        TantalumHafniumSeaborgiumCarbide.addFlags(GENERATE_PLATE, GENERATE_DENSE, GENERATE_RING, GENERATE_ROTOR);
        TantalumHafniumSeaborgiumCarboNitride.addFlags(GENERATE_PLATE, GENERATE_FRAME);
        Taranium.addFlags(GENERATE_BOLT_SCREW, GENERATE_LONG_ROD, GENERATE_SPRING_SMALL, GENERATE_NANOWIRE, GENERATE_FINE_WIRE);
        Terbium.addFlags(GENERATE_ROD, GENERATE_NANOFOIL);
        TerfenolD_H.addFlags(GENERATE_FOIL, GENERATE_FRAME, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_DENSE);
        TerfenolD_L.addFlags(GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_RING, GENERATE_SPRING, GENERATE_BOLT_SCREW, GENERATE_ROTOR);
        Thulium.addFlags(GENERATE_FOIL, GENERATE_ROD);
        TinAlloy.addFlags(GENERATE_FINE_WIRE);
        TriniumSteel.addFlags(GENERATE_ROUND, GENERATE_FRAME, GENERATE_SPRING, GENERATE_PLATE, GENERATE_BOLT_SCREW);
        VanadiumGallium.addFlags(GENERATE_FINE_WIRE);
        Vibranium.addFlags(GENERATE_ROUND, GENERATE_FRAME, GENERATE_BOLT_SCREW, GENERATE_NANOFOIL, GENERATE_ROTOR, GENERATE_LONG_ROD);
        WroughtIron.addFlags(GENERATE_BOLT_SCREW, GENERATE_FRAME);
        ZBLANGlass.addFlags(GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW);
        //Properties

        FluidPipeProperties PZTPipeProps = new FluidPipeProperties(3200, 46,false,true,true,false);
        FluidPipeProperties TaHfSgCNPipeProps = new FluidPipeProperties(3950, 45,true,true, true, true);
        FluidPipeProperties birmabrightFluidPipeProps = new FluidPipeProperties(1500, 24, false, true, false, false);
        FluidPipeProperties bluesteelFluidPipeProps = new FluidPipeProperties(1500, 30, false, true, false, false);
        FluidPipeProperties bt6FluidPipeProps = new FluidPipeProperties(1500, 36, false, true, false, false);
        FluidPipeProperties silicaCeramicFluidPipeProps = new FluidPipeProperties(350, 18, false, false, false, false);
        IngotProperty TaraniumIngotProp = new IngotProperty();
        PlasmaProperty HQDPlasmaProp = new PlasmaProperty();
        WireProperties BlueSteelWireProps = new WireProperties(512, 2, 6);
        WireProperties EnrichedNaqAlloyProps = new WireProperties(2097152, 2, 48);
        WireProperties NeutroniumProp = new WireProperties(2147483647, 4,0);
        WireProperties NihoniumTriiodideProp = new WireProperties(33554432, 2, 64);
        WireProperties OgTs4 = new WireProperties(536870912, 2, 256);
        WireProperties PikyoniumWireProps = new WireProperties(2097152, 2,12);
        WireProperties SuperheavyHProp = new WireProperties(536870912, 4, 128);
        WireProperties TaraniumWireProp = new WireProperties(134217728, 2, 64);
        FluidPipeProperties HDCS1PipeProps = new FluidPipeProperties(2100, 85,true,true, true, false);
        FluidPipeProperties HDCS2PipeProps = new FluidPipeProperties(2540, 115,true,true, true, false);
        FluidPipeProperties HDCS3PipeProps = new FluidPipeProperties(3280, 145,true,true, true, false);

        Actinium.setProperty(PropertyKey.DUST, new DustProperty());
        Alumina.setProperty(PropertyKey.ORE, new OreProperty());
        Astatine.setProperty(PropertyKey.DUST, new DustProperty());
        BT6.setProperty(PropertyKey.FLUID_PIPE, bt6FluidPipeProps);
        Birmabright.setProperty(PropertyKey.FLUID_PIPE, birmabrightFluidPipeProps);
        BlueSteel.setProperty(PropertyKey.FLUID_PIPE, bluesteelFluidPipeProps);
        BlueSteel.setProperty(PropertyKey.WIRE, BlueSteelWireProps);
        Bohrium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Carbon.setProperty(PropertyKey.INGOT, new IngotProperty());
        Dubnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Dysprosium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Einsteinium.setProperty(PropertyKey.DUST, new DustProperty());
        EnrichedNaqAlloy.setProperty(PropertyKey.WIRE, EnrichedNaqAlloyProps);
        Fermium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Fullerene.setProperty(PropertyKey.FLUID, new FluidProperty());
        HDCS_1.setProperty(PropertyKey.FLUID_PIPE, HDCS1PipeProps);
        HDCS_2.setProperty(PropertyKey.FLUID_PIPE, HDCS2PipeProps);
        HDCS_3.setProperty(PropertyKey.FLUID_PIPE, HDCS3PipeProps);
        Hafnium.setProperty(PropertyKey.DUST, new DustProperty());
        Hafnium.setProperty(PropertyKey.BLAST, new BlastProperty(2900));
        HeavyQuarkDegenerate.setProperty(PropertyKey.ITEM_PIPE, new ItemPipeProperties());
        HeavyQuarkDegenerate.setProperty(PropertyKey.PLASMA, HQDPlasmaProp);
        Iodine.setProperty(PropertyKey.DUST, new DustProperty());
        LeadZirconateTitanate.setProperty(PropertyKey.FLUID_PIPE, PZTPipeProps);
        Livermorium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Livermorium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Neutronium.setProperty(PropertyKey.WIRE, NeutroniumProp);
        NihoniumTriiodide.setProperty(PropertyKey.WIRE, NihoniumTriiodideProp);
        Oganesson.setProperty(PropertyKey.INGOT, new IngotProperty());
        OganessonTetraTennesside.setProperty(PropertyKey.WIRE, OgTs4);
        Pikyonium.setProperty(PropertyKey.WIRE, PikyoniumWireProps);
        Praseodymium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Praseodymium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Rutherfordium.setProperty(PropertyKey.ITEM_PIPE, new ItemPipeProperties());
        Seaborgium.setProperty(PropertyKey.INGOT, new IngotProperty());
        SilicaCeramic.setProperty(PropertyKey.FLUID_PIPE, silicaCeramicFluidPipeProps);
        SuperheavyH.setProperty(PropertyKey.WIRE, SuperheavyHProp);
        TantalumHafniumSeaborgiumCarboNitride.setProperty(PropertyKey.FLUID_PIPE, TaHfSgCNPipeProps);
        Taranium.setProperty(PropertyKey.INGOT, TaraniumIngotProp);
        Taranium.setProperty(PropertyKey.WIRE, TaraniumWireProp);
        Technetium.setProperty(PropertyKey.DUST, new DustProperty());
        Tennessine.setProperty(PropertyKey.INGOT, new IngotProperty());
        Terbium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Thulium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Zirconium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Zirconium.setProperty(PropertyKey.BLAST, new BlastProperty(2900));
    }

    @SafeVarargs
    private static List<MaterialFlag> setMaterialFlags(List<MaterialFlag>... materials) {
        List<MaterialFlag> result = new ArrayList<MaterialFlag>();
        for (List<MaterialFlag> x : materials) {
            result.addAll(x);
        }
        return result;
    }
}
