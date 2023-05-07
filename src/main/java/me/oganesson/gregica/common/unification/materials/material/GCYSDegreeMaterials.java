package me.oganesson.gregica.common.unification.materials.material;

import gregtech.api.GTValues;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.ToolProperty;
import me.oganesson.gregica.common.unification.GCElements;
import me.oganesson.gregica.GCConfig;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static me.oganesson.gregica.common.unification.GCElements.*;
import static me.oganesson.gregica.common.unification.materials.GCMaterials.*;

public class GCYSDegreeMaterials {
    public static void register() {
            // 3100-3499
            elements();

            // 3500-5999
            firstDegree();

            // 6000-8999
            secondDegree();

            // 15000-17999
            organic();

            // 18000-19999
            unknownComposition();

            flagAddition();
    }

    public static final MaterialFlag DISABLE_CRYSTALLIZATION = new MaterialFlag.Builder("no_crystallization")
            .requireFlags(MaterialFlags.CRYSTALLIZABLE)
            .requireProps(PropertyKey.GEM)
            .build();

    public static final MaterialFlag GENERATE_BOULE = new MaterialFlag.Builder("generate_boule")
            .requireProps(PropertyKey.GEM)
            .build();

    public static void elements() {
        Lithium6 = new Material.Builder(3100, "lithium_6")
                .ingot()
                .color(0xE6E1FF)
                .flags(GENERATE_PLATE, GENERATE_FOIL)
                .element(GCElements.Li6)
                .build();

        Lithium7 = new Material.Builder(3101, "lithium_7")
                .ingot()
                .color(0xE1DCFF).iconSet(METALLIC)
                .element(Li7)
                .build();

        Beryllium7 = new Material.Builder(3102, "beryllium_7")
                .ingot().fluid()
                .color(0x6EBE6E)
                .element(Be7)
                .build();

        Orichalcum = new Material.Builder(3103, "orichalcum")
                .ingot().fluid()
                .color(0x72A0C1).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .element(Or)
                .blastTemp(9000, BlastProperty.GasTier.HIGH)
                .build();

        Vibranium = new Material.Builder(3104, "vibranium")
                .ingot().fluid().plasma()
                .color(0xC880FF).iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL)
                .element(Vb)
                .blastTemp(4852, BlastProperty.GasTier.HIGH)
                .build();

        Adamantium = new Material.Builder(3105, "adamantium")
                .ingot().fluid().plasma()
                .color(0xFF0040).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FRAME,
                        GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND)
                .element(Ad)
                .blastTemp(5225, BlastProperty.GasTier.HIGH)
                .build();

        Taranium = new Material.Builder(3106, "taranium")
                .dust()
                .color(0x4F404F).iconSet(METALLIC)
                .element(Tn)
                .build();
    }

    /**
     * 3500-5999
     */
    public static void firstDegree() {

        LanthanumOxide = new Material.Builder(3500, "lanthanum_oxide")
                .dust()
                .color(0x5F7777)
                .iconSet(MaterialIconSet.SHINY)
                .components(Lanthanum, 2, Oxygen, 3)
                .build();

        PraseodymiumOxide = new Material.Builder(3501, "praseodymium_oxide")
                .dust()
                .color(0xD0D0D0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Praseodymium, 2, Oxygen, 3)
                .build();

        NeodymiumOxide = new Material.Builder(3502, "neodymium_oxide")
                .dust()
                .color(0x868686)
                .components(Neodymium, 2, Oxygen, 3)
                .build();

        CeriumOxide = new Material.Builder(3503, "cerium_oxide")
                .dust()
                .color(0x10937F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cerium, 1, Oxygen, 2)
                .build();

        ScandiumOxide = new Material.Builder(3504, "scandium_oxide")
                .dust()
                .color(0x43964F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Scandium, 2, Oxygen, 3)
                .build();

        EuropiumOxide = new Material.Builder(3505, "europium_oxide")
                .dust()
                .color(0x20AAAA)
                .iconSet(MaterialIconSet.SHINY)
                .components(Europium, 2, Oxygen, 3)
                .build();

        GadoliniumOxide = new Material.Builder(3506, "gadolinium_oxide")
                .dust()
                .color(0xEEEEFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Gadolinium, 2, Oxygen, 3)
                .build();

        SamariumOxide = new Material.Builder(3507, "samarium_oxide")
                .dust()
                .color(0xFFFFDD)
                .components(Samarium, 2, Oxygen, 3)
                .build();

        YttriumOxide = new Material.Builder(3508, "yttrium_oxide")
                .dust()
                .color(0x78544E)
                .iconSet(MaterialIconSet.SHINY)
                .components(Yttrium, 2, Oxygen, 3)
                .build();

        TerbiumOxide = new Material.Builder(3509, "terbium_oxide")
                .dust()
                .color(0xA264A2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Terbium, 2, Oxygen, 3)
                .build();

        DysprosiumOxide = new Material.Builder(3510, "dysprosium_oxide")
                .dust()
                .color(0xD273D2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Dysprosium, 2, Oxygen, 3)
                .build();

        HolmiumOxide = new Material.Builder(3511, "holmium_oxide")
                .dust()
                .color(0xAF7F2A)
                .iconSet(MaterialIconSet.SHINY)
                .components(Holmium, 2, Oxygen, 3)
                .build();

        ErbiumOxide = new Material.Builder(3512, "erbium_oxide")
                .dust()
                .color(0xE07A32)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Erbium, 2, Oxygen, 3)
                .build();

        ThuliumOxide = new Material.Builder(3513, "thulium_oxide")
                .dust()
                .color(0x3B9E8B)
                .components(Thulium, 2, Oxygen, 3)
                .build();

        YtterbiumOxide = new Material.Builder(3514, "ytterbium_oxide")
                .dust()
                .color(0xA9A9A9)
                .components(Ytterbium, 2, Oxygen, 3)
                .build();

        LutetiumOxide = new Material.Builder(3515, "lutetium_oxide")
                .dust()
                .color(0x11BBFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Lutetium, 2, Oxygen, 3)
                .build();

        PurifiedPlatinumGroupConcentrate = new Material.Builder(3516, "purified_platinum_group_concentrate")
                .fluid()
                .color(0xFFFFC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Platinum, 1, Palladium, 1, Chlorine, 6)
                .build();

        AmmoniumHexachloroplatinate = new Material.Builder(3517, "ammonium_hexachloroplatinate")
                .fluid()
                .color(0xFEF0C2)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Platinum, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PtCl6", true);

        AmmoniumHexachloropalladate = new Material.Builder(3518, "ammonium_hexachloropalladate")
                .fluid()
                .color(0x808080)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Palladium, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PdCl6", true);

        SodiumNitrate = new Material.Builder(3519, "sodium_nitrate")
                .dust()
                .color(0x846684)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .build();

        PotassiumHydroxide = new Material.Builder(3520, "potassium_hydroxide")
                .dust().fluid()
                .color(0xFA9849)
                .flags(DISABLE_DECOMPOSITION)
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .fluidTemp(633)
                .build();

        CarbonTetrachloride = new Material.Builder(3521, "carbon_tetrachloride")
                .fluid()
                .color(0x75201A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Chlorine, 4)
                .build();

        RutheniumChloride = new Material.Builder(3522, "ruthenium_chloride")
                .dust()
                .color(0x605C6C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ruthenium, 1, Chlorine, 3)
                .build();

        SodiumPeroxide = new Material.Builder(3523, "sodium_peroxide")
                .dust()
                .color(0xECFF80)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Sodium, 2, Oxygen, 2)
                .build();

        RhodiumOxide = new Material.Builder(3524, "rhodium_oxide")
                .dust()
                .color(0xD93D16)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Rhodium, 2, Oxygen, 3)
                .build();

        SodiumChlorate = new Material.Builder(3525, "sodium_chlorate")
                .dust()
                .color(0xAB8D85)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Sodium, 1, Chlorine, 1, Oxygen, 3)
                .build();

        SulfurDichloride = new Material.Builder(3526, "sulfur_dichloride")
                .fluid()
                .color(0x761410)
                .components(Sulfur, 1, Chlorine, 2)
                .build();

        ThionylChloride = new Material.Builder(3527, "thionyl_chloride")
                .fluid()
                .color(0xEBE863)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sulfur, 1, Oxygen, 1, Chlorine, 2)
                .build();

        OsmiumTetrachloride = new Material.Builder(3528, "osmium_tetrachloride")
                .dust()
                .color(0x29080A)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Osmium, 1, Chlorine, 4)
                .build();

        PotassiumBromate = new Material.Builder(3529, "potassium_bromate")
                .dust()
                .color(0x782828)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Potassium, 1, Bromine, 1, Oxygen, 3)
                .build();

        TungstenTrioxide = new Material.Builder(3530, "tungsten_trioxide")
                .dust()
                .color(0xC7D300)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tungsten, 1, Oxygen, 3)
                .build();

        HydrogenPeroxide = new Material.Builder(3531, "hydrogen_peroxide")
                .fluid()
                .color(0xD2FFFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 2)
                .build();

        Hydrazine = new Material.Builder(3532, "hydrazine")
                .fluid()
                .color(0xB50707)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 4)
                .build();

        BerylliumOxide = new Material.Builder(3533, "beryllium_oxide")
                .ingot()
                .color(0x54C757)
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Beryllium, 1, Oxygen, 1)
                .build();

        TantalumPentoxide = new Material.Builder(3534, "tantalum_pentoxide")
                .dust()
                .color(0x72728A)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Tantalum, 2, Oxygen, 5)
                .build();

        NiobiumPentoxide = new Material.Builder(3535, "niobium_pentoxide")
                .dust()
                .color(0xBAB0C3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Niobium, 2, Oxygen, 5)
                .build();

        CalciumDifluoride = new Material.Builder(3536, "calcium_difluoride")
                .dust()
                .color(0xFFFC9E)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Calcium, 1, Fluorine, 2)
                .build();

        ManganeseDifluoride = new Material.Builder(3537, "manganese_difluoride")
                .dust()
                .color(0xEF4B3D)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Manganese, 1, Fluorine, 2)
                .build();

        CalciumCarbide = new Material.Builder(3538, "calcium_carbide")
                .dust()
                .color(0x807B70)
                .iconSet(MaterialIconSet.DULL)
                .components(Calcium, 1, Carbon, 2)
                .build();

        CalciumHydroxide = new Material.Builder(3539, "calcium_hydroxide")
                .dust()
                .color(0x5F8764)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Calcium, 1, Hydrogen, 2, Oxygen, 2)
                .build()
                .setFormula("Ca(OH)2", true);

        SodiumCyanide = new Material.Builder(3540, "sodium_cyanide")
                .dust()
                .color(0x5F7C8C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 1, Carbon, 1, Nitrogen, 1)
                .build();

        ChlorosulfuricAcid = new Material.Builder(3541, "chlorosulfuric_acid")
                .fluid()
                .color(0x916C1D)
                .components(Hydrogen, 1, Sulfur, 1, Oxygen, 3, Chlorine, 1)
                .build();

        CubicZirconia = new Material.Builder(3542, "cubic_zirconia")
                .gem()
                .color(0xFFDFE2)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(CRYSTALLIZABLE, DISABLE_DECOMPOSITION)
                .components(Zirconium, 1, Oxygen, 2)
                .build();

        MolybdenumTrioxide = new Material.Builder(3543, "molybdenum_trioxide")
                .dust()
                .color(0xCBCFDA)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Molybdenum, 1, Oxygen, 3)
                .build();

        LeadChloride = new Material.Builder(3544, "lead_chloride")
                .dust()
                .color(0xF3F3F3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Lead, 1, Chlorine, 2)
                .build();

        SodiumTellurite = new Material.Builder(3545, "sodium_tellurite")
                .dust()
                .color(0xC6C9BE)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Tellurium, 1, Oxygen, 3)
                .build();

        TelluriumDioxide = new Material.Builder(3546, "tellurium_dioxide")
                .dust()
                .color(0xE3DDB8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tellurium, 1, Oxygen, 2)
                .build();

        SeleniumDioxide = new Material.Builder(3547, "selenium_dioxide")
                .dust()
                .color(0xE0DDD8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Selenium, 1, Oxygen, 2)
                .build();

        SelenousAcid = new Material.Builder(3548, "selenous_acid")
                .dust()
                .color(0xE0E083)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Selenium, 1, Oxygen, 3)
                .build();

        BoricAcid = new Material.Builder(3549, "boric_acid")
                .dust()
                .color(0xFAFAFA)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .build();

        // FREE ID: 3550

        BoronTrioxide = new Material.Builder(3551, "boron_trioxide")
                .dust()
                .color(0xE9FAC0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Boron, 2, Oxygen, 3)
                .build();

        BoronTrifluoride = new Material.Builder(3552, "boron_trifluoride")
                .fluid(FluidTypes.GAS)
                .color(0xFAF191)
                .components(Boron, 1, Fluorine, 3)
                .build();

        LithiumTetrafluoroborate = new Material.Builder(3553, "lithium_tetrafluoroborate")
                .dust()
                .color(0x90FAF6)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Lithium, 1, Boron, 1, Fluorine, 4)
                .build();

        Diborane = new Material.Builder(3554, "diborane")
                .fluid(FluidTypes.GAS)
                .color(0x3F3131)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 2, Hydrogen, 6)
                .build();

        Borazine = new Material.Builder(3555, "borazine") //TODO "Boron Aromatic" tooltip
                .fluid()
                .color(0x542828)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Hydrogen, 6, Nitrogen, 3)
                .build();

        BoronTrichloride = new Material.Builder(3556, "boron_trichloride")
                .fluid(FluidTypes.GAS)
                .color(0x033F1B)
                .components(Boron, 1, Chlorine, 3)
                .build();

        Trichloroborazine = new Material.Builder(3557, "trichloroborazine") //TODO "Boron Aromatic" tooltip
                .fluid()
                .color(0xD62929)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Chlorine, 3, Hydrogen, 3, Nitrogen, 3)
                .build();

        HexagonalBoronNitride = new Material.Builder(3558, "hexagonal_boron_nitride")
                .gem()
                .color(0x6A6A72)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("h-BN", true);

        CubicBoronNitride = new Material.Builder(3559, "cubic_boron_nitride")
                .gem()
                .color(0x545572)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, CRYSTALLIZABLE, FLAMMABLE, EXPLOSIVE, DISABLE_CRYSTALLIZATION) // to disable implosion recipes
                .components(Boron, 1, Nitrogen, 1)
                .toolStats(ToolProperty.Builder.of(14.0F, 9.0F, 12400, 5).enchantability(15).build())
                .build()
                .setFormula("c-BN", true);

        AmorphousBoronNitride = new Material.Builder(3560, "amorphous_boron_nitride")
                .ingot()
                .color(0x9193C5)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("a-BN", true);

        Heterodiamond = new Material.Builder(3561, "heterodiamond")
                .gem()
                .color(0x512A72)
                .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 1, Nitrogen, 1)
                .build();

        CubicHeterodiamond = new Material.Builder(3562, "cubic_heterodiamond")
                .gem()
                .color(0x753DA6)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 2, Nitrogen, 1)
                .build()
                .setFormula("c-BC2N", true);

        LithiumHydride = new Material.Builder(3563, "lithium_hydride")
                .ingot()
                .color(0x9BAFDB)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Lithium, 1, Hydrogen, 1)
                .build();

        HydrobromicAcid = new Material.Builder(3564, "hydrobromic_acid")
                .fluid(FluidTypes.ACID)
                .color(0x8D1212)
                .components(Hydrogen, 1, Bromine, 1)
                .build();

        WhitePhosphorus = new Material.Builder(3565, "white_phosphorus")
                .gem()
                .color(0xECEADD)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        RedPhosphorus = new Material.Builder(3566, "red_phosphorus")
                .gem()
                .color(0x77040E)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        VioletPhosphorus = new Material.Builder(3567, "violet_phosphorus")
                .gem()
                .color(0x8000FF)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        BlackPhosphorus = new Material.Builder(3568, "black_phosphorus")
                .gem()
                .color(0x36454F)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        BluePhosphorus = new Material.Builder(3569, "blue_phosphorus")
                .gem()
                .color(0x9BE3E4)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        Phosphorene = new Material.Builder(3570, "phosphorene")
                .ingot()
                .color(0x273239)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FOIL)
                .components(Phosphorus, 4)
                .build();

        PhosphorusTrichloride = new Material.Builder(3571, "phosphorus_trichloride")
                .fluid()
                .color(0xE8C474)
                .components(Phosphorus, 1, Chlorine, 3)
                .build();

        PhosphorylChloride = new Material.Builder(3572, "phosphoryl_chloride")
                .fluid()
                .color(0xE8BB5B)
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .build();

        ZincOxide = new Material.Builder(3573, "zinc_oxide")
                .dust()
                .color(0xB85C34)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .components(Zinc, 1, Oxygen, 1)
                .build();

        GermaniumTetrachloride = new Material.Builder(3574, "germanium_tetrachloride")
                .fluid()
                .color(0x787878)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Chlorine, 4)
                .build();

        GermaniumDioxide = new Material.Builder(3575, "germanium_dioxide")
                .dust()
                .color(0x666666)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Oxygen, 2)
                .build();

        SiliconTetrachloride = new Material.Builder(3576, "silicon_tetrachloride")
                .fluid()
                .color(0x5B5B7A)
                .components(Silicon, 1, Chlorine, 4)
                .build();

        GSTGlass = new Material.Builder(3577, "gst_glass")
                .ingot().fluid()
                .color(0xCFFFFF)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, NO_SMASHING, NO_WORKING, DECOMPOSITION_BY_CENTRIFUGING)
                .components(Germanium, 2, Antimony, 2, Tellurium, 5)
                .blastTemp(873, BlastProperty.GasTier.MID)
                .build();

        ZBLANGlass = new Material.Builder(3578, "zblan_glass")
                .ingot().fluid()
                .color(0xACB4BC)
                .iconSet(MaterialIconSet.SHINY)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION)
                .components(Zirconium, 5, Barium, 2, Lanthanum, 1, Aluminium, 1, Sodium, 2, Fluorine, 6)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2", true);

        HeliumNeon = new Material.Builder(3579, "helium_neon")
                .fluid(FluidTypes.GAS)
                .color(0xFF0080)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Helium, 9, Neon, 1)
                .build();

        AluminiumHydroxide = new Material.Builder(3580, "aluminium_hydroxide")
                .dust()
                .color(0xBEBEC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .build()
                .setFormula("Al(OH)3", true);

        AluminiumTrichloride = new Material.Builder(3581, "aluminium_trichloride")
                .dust()
                .color(0x78C3EB)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Chlorine, 3)
                .build();

        GalliumTrichloride = new Material.Builder(3582, "gallium_trichloride")
                .dust()
                .color(0x6EB4FF)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Gallium, 1, Chlorine, 3)
                .build();

        GalliumTrioxide = new Material.Builder(3583, "gallium_trioxide")
                .dust().fluid().fluidTemp(2170)
                .color(0xE4CDFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Gallium, 1, Oxygen, 3)
                .build();

        GalliumNitride = new Material.Builder(3584, "gallium_nitride")
                .ingot()
                .color(0xFFF458)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE)
                .components(Gallium, 1, Nitrogen, 1)
                .build();

        CadmiumBromide = new Material.Builder(3585, "cadmium_bromide")
                .dust()
                .color(0xFF1774)
                .iconSet(MaterialIconSet.SHINY)
                .components(Cadmium, 1, Bromine, 2)
                .build();

        MagnesiumBromide = new Material.Builder(3586, "magnesium_bromide")
                .dust()
                .color(0x5F4C32)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Magnesium, 1, Bromine, 2)
                .build();

        CadmiumSulfide = new Material.Builder(3587, "cadmium_sulfide")
                .dust()
                .color(0xC8C43C)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, GENERATE_PLATE)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cadmium, 1, Sulfur, 1)
                .build();

        CadmiumSelenide = new Material.Builder(3588, "cadmium_selenide") //TODO "Quantum Dots" tooltip
                .dust()
                .color(0x983034)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cadmium, 1, Selenium, 1)
                .build();

        Phosphine = new Material.Builder(3589, "phosphine")
                .fluid(FluidTypes.GAS)
                .color(0xACB330)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, FLAMMABLE)
                .components(Phosphorus, 1, Hydrogen, 3)
                .build();

        PlutoniumTrihydride = new Material.Builder(3590, "plutonium_trihydride")
                .dust()
                .color(0x140002)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Plutonium239, 1, Hydrogen, 3)
                .build()
                .setFormula("PuH3", true);

        PlutoniumPhosphide = new Material.Builder(3591, "plutonium_phosphide")
                .ingot()
                .color(0x1F0104)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Plutonium239, 1, Phosphorus, 1)
                .build()
                .setFormula("PuP", true);

        CarbonNanotube = new Material.Builder(3592, "carbon_nanotube")
                .ingot().fluid()
                .color(0x05090C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD,
                        GENERATE_FINE_WIRE, GENERATE_SPRING)
                .cableProperties(V[UEV], 8, 6)
                .components(Carbon, 48)
                .build()
                .setFormula("CNT", false);

        LithiumHydroxide = new Material.Builder(3593, "lithium_hydroxide")
                .dust()
                .color(0xDECAFA)
                .iconSet(MaterialIconSet.FINE)
                .components(Lithium, 1, Oxygen, 1, Hydrogen, 1)
                .build();

        LithiumAmalgam = new Material.Builder(3594, "lithium_amalgam")
                .fluid()
                .color(0xAEA7D4).iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Mercury, 1, Lithium, 1)
                .build();

        Lithium7Hydroxide = new Material.Builder(3595, "lithium_7_hydroxide")
                .dust()
                .color(0xAEAACA).iconSet(MaterialIconSet.FINE)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .components(Lithium7, 1, Oxygen, 1, Hydrogen, 1)
                .build()
                .setFormula("LiOH", true);

        NeptuniumAluminide = new Material.Builder(3596, "neptunium_aluminide")
                .ingot().fluid()
                .color(0x5E228F)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Neptunium, 1, Aluminium, 3)
                .blastTemp(1568, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.ZPM])
                .build()
                .setFormula("NpAl3", true);

        BismuthTrioxide = new Material.Builder(3597, "bismuth_trioxide")
                .dust()
                .color(0xF5EF42).iconSet(MaterialIconSet.FINE)
                .components(Bismuth, 2, Oxygen, 3)
                .build();

        FerricOxide = new Material.Builder(3598, "ferric_oxide")
                .dust()
                .color(0x915A5A).iconSet(MaterialIconSet.ROUGH)
                .components(Iron, 2, Oxygen, 3)
                .build();

        BismuthChalcogenide = new Material.Builder(3599, "bismuth_chalcogenide") //TODO "3D Topological Isolator" tooltip
                .ingot()
                .color(0x91994D).iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Bismuth, 1, Antimony, 1, Tellurium, 2, Sulfur, 1)
                .build();

        MercuryCadmiumTelluride = new Material.Builder(3600, "mercury_cadmium_telluride")
                .ingot().fluid()
                .color(0x823C80).iconSet(MaterialIconSet.BRIGHT)
                .flags(GENERATE_FINE_WIRE)
                .components(Mercury, 2, Cadmium, 1, Tellurium, 2)
                .cableProperties(V[UHV], 6, 8)
                .blastTemp(2170, BlastProperty.GasTier.HIGHER, GTValues.VA[UHV])
                .build();

        AluminiumSelenide = new Material.Builder(3601, "aluminium_selenide")
                .dust()
                .color(0x969651)
                .components(Aluminium, 2, Selenium, 3)
                .build();

        HydrogenSelenide = new Material.Builder(3602, "hydrogen_selenide")
                .fluid(FluidTypes.GAS)
                .color(0x42f554)
                .components(Hydrogen, 2, Selenium, 1)
                .build();

        PalladiumNitrate = new Material.Builder(3603, "palladium_nitrate")
                .dust()
                .color(0x82312A).iconSet(MaterialIconSet.METALLIC)
                .components(Palladium, 1, Nitrogen, 2, Oxygen, 6)
                .build()
                .setFormula("Pd(NO3)2", true);

        Fullerene = new Material.Builder(3604, "fullerene")
                .ingot()
                .color(0x72556A)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_RING,
                        GENERATE_FRAME)
                .components(Carbon, 60)
                .build();

        ThalliumCopperChloride = new Material.Builder(3605, "thallium_copper_chloride") //TODO "Antiferromagnetic" Tooltip
                .ingot().fluid()
                .color(0x3C5CB5)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Thallium, 1, Copper, 1, Chlorine, 3)
                .build();

        PerrhenicAcid = new Material.Builder(3606, "perrhenic_acid")
                .dust()
                .color(0xE6DC70)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Rhenium, 1, Oxygen, 4)
                .build();

        AmmoniumPerrhenate = new Material.Builder(3607, "ammonium_perrhenate")
                .dust()
                .color(0xA69970)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Rhenium, 1, Oxygen, 4)
                .build();

        ThalliumSulfate = new Material.Builder(3608, "thallium_sulfate")
                .dust()
                .color(0x9C222C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Thallium, 2, Sulfur, 1, Oxygen, 4)
                .build();

        HeavyTaraniumFuel = new Material.Builder(3609, "heavy_taranium_fuel")
                .fluid()
                .color(0x141414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        MediumTaraniumFuel = new Material.Builder(3610, "medium_taranium_fuel")
                .fluid()
                .color(0x181818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        LightTaraniumFuel = new Material.Builder(3611, "light_taranium_fuel")
                .fluid()
                .color(0x1C1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        HeavyEnrichedTaraniumFuel = new Material.Builder(3612, "heavy_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        MediumEnrichedTaraniumFuel = new Material.Builder(3613, "medium_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        LightEnrichedTaraniumFuel = new Material.Builder(3614, "light_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        Adamantite = new Material.Builder(3615, "adamantite")
                .dust()
                .color(0xC83C3C)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Adamantium, 3, Oxygen, 4)
                .build();

        AdamantiumUnstable = new Material.Builder(3616, "adamantium_unstable")
                .fluid()
                .color(0xFF763C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Adamantium, 1)
                .build();

        OrichalcumEnergized = new Material.Builder(3617, "orichalcum_energized")
                .dust()
                .color(0xF4FC0C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Orichalcum, 1)
                .build();

        AdamantiumEnriched = new Material.Builder(3618, "adamantium_enriched")
                .dust()
                .color(0x64B4FF)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1, RareEarth, 1)
                .build();

        DeepIron = new Material.Builder(3619, "deep_iron")
                .dust()
                .color(0x968C8C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iron, 2, Trinium, 1, Indium, 1)
                .build();

        VibraniumUnstable = new Material.Builder(3620, "vibranium_unstable")
                .fluid()
                .color(0xFF7832)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1)
                .build();

        SiliconCarbide = new Material.Builder(3621, "silicon_carbide") //TODO Carborundum tooltip
                .dust()
                .color(0x4D4D4D)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Silicon, 1, Carbon, 1)
                .blastTemp(2500, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.UV])
                .cableProperties(V[UHV], 6, 8)
                .build();

        ChromiumGermaniumTelluride = new Material.Builder(3622, "cgt")
                .ingot().fluid()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Chrome, 1, Germanium, 1, Tellurium, 3)
                .blastTemp(2900, BlastProperty.GasTier.HIGHER)
                .build();

        Kovar = new Material.Builder(3623, "kovar")
                .ingot()
                .color(0xCBC0A6)
                .flags(GENERATE_ROD, GENERATE_RING, DECOMPOSITION_BY_CENTRIFUGING)
                .components(Iron, 4, Nickel, 2, Cobalt, 1)
                .build();

        StannicChloride = new Material.Builder(3624, "stannic_chloride")
                .fluid()
                .color(0x33BBF5)
                .components(Tin, 1, Chlorine, 4)
                .build();

        RubidiumChlorostannate = new Material.Builder(3625, "rubidium_chlorostannate")
                .dust()
                .color(0xBD888A)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Rubidium, 2, Tin, 1, Chlorine, 6)
                .build();

        CaesiumChlorostannate = new Material.Builder(3626, "caesium_chlorostannate")
                .dust()
                .color(0xBDAD88)
                .iconSet(MaterialIconSet.SHINY)
                .components(Caesium, 2, Tin, 1, Chlorine, 6)
                .build();

        HRAMagnesium = new Material.Builder(3627, "hra_magnesium") //TODO "Reike Metal" tooltip
                .dust()
                .color(Magnesium.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Magnesium, 1)
                .build();

        LithiumFluoride = new Material.Builder(3628,"lithium_fluoride")
                .dust()
                .color(0x9AE7AD)
                .components(Lithium,1 , Fluorine, 1)
                .build();

        // TODO Using CEu ID for the ore work
        Alumina = new Material.Builder(383, "alumina")
                .dust()
                .color(7914475)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Materials.Aluminium, 2, Materials.Oxygen, 3)
                .build();

        // TODO Using CEu ID for the ore work
        ChloroplatinicAcid = new Material.Builder(459, "chloroplatinic_acid")
                .fluid(FluidTypes.ACID).color(16729670)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(Materials.Hydrogen, 2, Materials.Platinum, 1, Materials.Chlorine, 6)
                .build();
    }

    /**
     * 6000-8999
     */
    public static void secondDegree() {
        LaPrNdCeOxidesSolution = new Material.Builder(6000, "la_pr_nd_ce_oxides_solution")
                .fluid()
                .color(0x9CE3DB)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(LanthanumOxide, 1, PraseodymiumOxide, 1, NeodymiumOxide, 1, CeriumOxide, 1)
                .build();

        ScEuGdSmOxidesSolution = new Material.Builder(6001, "sc_eu_gd_sm_oxides_solution")
                .fluid()
                .color(0xFFFF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ScandiumOxide, 1, EuropiumOxide, 1, GadoliniumOxide, 1, SamariumOxide, 1)
                .build();

        YTbDyHoOxidesSolution = new Material.Builder(6002, "y_tb_dy_ho_oxides_solution")
                .fluid()
                .color(0x99FF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 1, TerbiumOxide, 1, DysprosiumOxide, 1, HolmiumOxide, 1)
                .build();

        ErTmYbLuOxidesSolution = new Material.Builder(6003, "er_tm_yb_lu_oxides_solution")
                .fluid()
                .color(0xFFB3FF)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ErbiumOxide, 1, ThuliumOxide, 1, YtterbiumOxide, 1, LutetiumOxide, 1)
                .build();

        PlatinumGroupConcentrate = new Material.Builder(6004, "platinum_group_concentrate")
                .fluid()
                .color(0xFFFFA6)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gold, 1, Platinum, 1, Palladium, 1, HydrochloricAcid, 6)
                .build();

        PlatinumGroupResidue = new Material.Builder(6005, "platinum_group_residue")
                .dust()
                .color(0x64632E)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iridium, 1, Osmium, 1, Rhodium, 1, Ruthenium, 1, RareEarth, 1)
                .build();

        // FREE ID 6006-6013

        GrapheneOxide = new Material.Builder(6014, "graphene_oxide")
                .dust()
                .color(0x777777)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphene, 1, Oxygen, 1)
                .build();

        AmmoniumNitrate = new Material.Builder(6015, "ammonium_nitrate")
                .dust()
                .color(0xA59ED7)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Ammonia, 1, NitricAcid, 1)
                .build()
                .setFormula("NH4NO3", true);

        Wollastonite = new Material.Builder(6016, "wollastonite")
                .dust()
                .color(0xF0F0F0)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Quicklime, 2, SiliconDioxide, 3)
                .build()
                .setFormula("CaSiO3", true);

        RoastedSphalerite = new Material.Builder(6017, "roasted_sphalerite")
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, GermaniumDioxide, 1)
                .build();

        WaelzOxide = new Material.Builder(6018, "waelz_oxide")
                .dust()
                .color(0xB8B8B8)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 1, GermaniumDioxide, 1)
                .build();

        //TODO move to first degree
        WaelzSlag = new Material.Builder(6019, "waelz_slag")
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Zinc, 1, Sulfur, 1, Oxygen, 4)
                .build();

        ImpureGermaniumDioxide = new Material.Builder(6020, "impure_germanium_dioxide")
                .dust()
                .color(0x666666)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(GermaniumDioxide, 1)
                .build()
                .setFormula("GeO2?", true);

        ErbiumDopedZBLANGlass = new Material.Builder(6021, "erbium_doped_zblan_glass")
                .ingot()
                .color(0x505444)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Erbium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Er", true);

        PraseodymiumDopedZBLANGlass = new Material.Builder(6022, "praseodymium_doped_zblan_glass")
                .ingot()
                .color(0xC5C88D)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(ZBLANGlass, 1, Praseodymium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Pr", true);

        NdYAG = new Material.Builder(6023, "nd_yag") //TODO "Yttrium-Aluminium-Garnet" Tooltip
                .gem()
                .color(0xD99DE4)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(CRYSTALLIZABLE, DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 2, NeodymiumOxide, 1, Alumina, 5)
                .build()
                .setFormula("NdY2Al5O12", true);

        BismuthFerrite = new Material.Builder(6024, "bismuth_ferrite") //TODO "Multiferroic!" tooltip
                .gem()
                .color(0x43634B)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(CRYSTALLIZABLE, GENERATE_PLATE)
                .components(BismuthTrioxide, 2, FerricOxide, 2)
                .build()
                .setFormula("BiFeO3", true);

        ChromiumGermaniumTellurideMagnetic = new Material.Builder(6025, "cgt_magnetic")
                .ingot()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(ChromiumGermaniumTelluride, 1)
                .ingotSmeltInto(ChromiumGermaniumTelluride)
                .arcSmeltInto(ChromiumGermaniumTelluride)
                .macerateInto(ChromiumGermaniumTelluride)
                .build();
        ChromiumGermaniumTelluride.getProperty(PropertyKey.INGOT).setMagneticMaterial(ChromiumGermaniumTellurideMagnetic);

        HeavyAlkaliChlorideSolution = new Material.Builder(6026, "heavy_alkali_chloride_solution")
                .fluid()
                .color(0x8F5353)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rubidium, 1, Caesium, 2, Chlorine, 6, Water, 2)
                .build()
                .setFormula("RbCl(CsCl)2Cl3(H2O)2", true);

        ZincRichSphalerite = new Material.Builder(9001, "zinc_rich_sphalerite")
                .dust()
                .color(0xC3AC8F)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 2, RoastedSphalerite, 3)
                .build()
                .setFormula("Zn2(GaGeO2)", true);
    }

    public static void flagAddition() {

        // Formula Changes
        PalladiumRaw.setFormula("PdCl2", true);
        RarestMetalMixture.setFormula("IrOs?", true);
        IridiumMetalResidue.setFormula("Ir2O3", true);

        // Disable Decomposition
        if (GCConfig.chainOverrides.disableNiobiumTantalumProcessing) {
            Pyrochlore.addFlags(DISABLE_DECOMPOSITION);
            Tantalite.addFlags(DISABLE_DECOMPOSITION);
        }
        if (GCConfig.chainOverrides.disableMolybdenumProcessing) {
            Molybdenite.addFlags(DISABLE_DECOMPOSITION);
            OreProperty oreProp = Molybdenite.getProperty(PropertyKey.ORE);
            oreProp.setDirectSmeltResult(null);
            Powellite.addFlags(DISABLE_DECOMPOSITION);
            Wulfenite.addFlags(DISABLE_DECOMPOSITION);
        }
        RockSalt.addFlags(DISABLE_DECOMPOSITION); // Conflict between Potassium Hydroxide and Rock Salt Electrolysis
        Salt.addFlags(DISABLE_DECOMPOSITION); // Conflict between Sodium Chlorate and Salt Electrolysis
        Pollucite.addFlags(DISABLE_DECOMPOSITION); // for rubidium chain

        // Disable Crystallization
        Monazite.addFlags(DISABLE_CRYSTALLIZATION);

        // Crystallizable
        Sapphire.addFlags(CRYSTALLIZABLE);
        Ruby.addFlags(CRYSTALLIZABLE);
        Emerald.addFlags(CRYSTALLIZABLE);
        Olivine.addFlags(CRYSTALLIZABLE);
        Amethyst.addFlags(CRYSTALLIZABLE);
        Opal.addFlags(CRYSTALLIZABLE);

        // Plates
        Germanium.addFlags(GENERATE_PLATE);
        Rhenium.addFlags(GENERATE_PLATE);

        // Rods
        Darmstadtium.addFlags(GENERATE_ROD);

        // Springs
        Trinium.addFlags(GENERATE_SPRING);
        Tritanium.addFlags(GENERATE_SPRING);

        // Small Springs
        Europium.addFlags(GENERATE_SPRING_SMALL);

        // Frames
        Darmstadtium.addFlags(GENERATE_FRAME);

        // Foils
        Nickel.addFlags(GENERATE_FOIL);
        Titanium.addFlags(GENERATE_FOIL);
        Germanium.addFlags(GENERATE_FOIL);
    }

    /**
     * IDs: 15000-17999
     */
    public static void organic() {

        Tetrahydrofuran = new Material.Builder(15000, "tetrahydrofuran") //TODO "THF" tooltip
                .fluid()
                .color(0x3234A8)
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .build();

        Ethylhexanol = new Material.Builder(15001, "ethylhexanol")
                .fluid()
                .color(0xFEEA9A)
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .build();

        DiethylhexylPhosphoricAcid = new Material.Builder(15002, "diethylhexyl_phosphoric_acid")
                .fluid()
                .color(0xFFFF99)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .build()
                .setFormula("(C8H7O)2PO2H", true);

        Butanol = new Material.Builder(15003, "butanol")
                .fluid()
                .color(0xC7AF2E)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .build()
                .setFormula("C4H9OH", true);

        MethylFormate = new Material.Builder(15004, "methyl_formate")
                .fluid()
                .color(0xFFAAAA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 4, Carbon, 2, Oxygen, 2)
                .build()
                .setFormula("HCO2CH3", true);

        FormicAcid = new Material.Builder(15005, "formic_acid")
                .fluid(FluidTypes.ACID)
                .color(0xFFAA77)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Carbon, 1, Oxygen, 2)
                .build()
                .setFormula("HCOOH", true);

        PhthalicAnhydride = new Material.Builder(15006, "phthalic_anhydride")
                .dust()
                .color(0xEEAAEE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .build()
                .setFormula("C6H4(CO)2O", true);

        Ethylanthraquinone = new Material.Builder(15007, "ethylanthraquinone")
                .fluid()
                .color(0xCC865A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .build()
                .setFormula("C6H4(CO)2C6H3Et", true);

        Ethylanthrahydroquinone = new Material.Builder(15008, "ethylanthrahydroquinone")
                .fluid()
                .color(0xAD531A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 18, Oxygen, 2)
                .build()
                .setFormula("C6H4(CH2OH)2C6H3Et", true);

        Formaldehyde = new Material.Builder(15009, "formaldehyde")
                .fluid()
                .color(0x95A13A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .build();

        Acetylene = new Material.Builder(15010, "acetylene")
                .fluid()
                .color(0x959C60)
                .components(Carbon, 2, Hydrogen, 2)
                .build();

        Turpentine = new Material.Builder(15013, "turpentine")
                .fluid()
                .color(0x93BD46)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16)
                .build();

        Dichloroethane = new Material.Builder(15014, "dichloroethane")
                .fluid()
                .color(0xDAAED3)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .build();

        Trichloroethylene = new Material.Builder(15015, "trichloroethylene")
                .fluid()
                .color(0xB685B1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 1, Chlorine, 3)
                .build();

        ChloroaceticAcid = new Material.Builder(15016, "chloroacetic_acid")
                .dust()
                .color(0x38541A)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 2, Hydrogen, 3, Chlorine, 1, Oxygen, 2)
                .build();

        MalonicAcid = new Material.Builder(15017, "malonic_acid")
                .dust()
                .color(0x61932E)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 3, Hydrogen, 4, Oxygen, 4)
                .build();

        TetramethylammoniumChloride = new Material.Builder(15018, "tetramethylammonium_chloride")
                .dust()
                .color(0x27FF81)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Carbon, 4, Hydrogen, 12, Nitrogen, 1, Chlorine, 1)
                .build()
                .setFormula("N(CH3)4Cl", true);

        Ethylenediamine = new Material.Builder(15019, "ethylenediamine")
                .fluid()
                .color(0xD00ED0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("C2H4(NH2)2", true);

        HydrogenCyanide = new Material.Builder(15020, "hydrogen_cyanide")
                .fluid(FluidTypes.GAS)
                .color(0xB6D1AE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Carbon, 1, Nitrogen, 1)
                .build();

        TetrasodiumEDTA = new Material.Builder(15021, "tetrasodium_edta")
                .dust()
                .color(0x8890E0)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 12, Nitrogen, 2, Oxygen, 8, Sodium, 4)
                .build();

        EthylenediaminetetraaceticAcid = new Material.Builder(15022, "ethylenediaminetetraacetic_acid") //TODO EDTA Tooltip
                .dust()
                .color(0x87E6D9)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .build();

        Aniline = new Material.Builder(15026, "aniline")
                .fluid()
                .color(0x4C911D)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1)
                .build()
                .setFormula("C6H5NH2", true);

        AceticAnhydride = new Material.Builder(15027, "acetic_anhydride")
                .fluid()
                .color(0xD5DDDF)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 3)
                .build()
                .setFormula("(CH3CO)2O", true);

        ParaXylene = new Material.Builder(15030, "para_xylene")
                .fluid()
                .color(0x666040)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 10)
                .build()
                .setFormula("C6H4(CH3)2", true);

        Durene = new Material.Builder(15031, "durene")
                .dust()
                .color(0x336040)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 14)
                .build()
                .setFormula("C6H2(CH3)4", true);

        PyromelliticDianhydride = new Material.Builder(15032, "pyromellitic_dianhydride") //TODO PDMA Tooltip
                .dust()
                .color(0xF0EAD6)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .build()
                .setFormula("C6H2(C2O3)2", true);

        Aminophenol = new Material.Builder(15033, "aminophenol")
                .fluid()
                .color(0xFF7F50)
                .components(Carbon, 6, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("HOC6H4NH2", true);

        Dimethylformamide = new Material.Builder(15034, "dimethylformamide") //TODO DMF Tooltip
                .fluid()
                .color(0x42BDFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build()
                .setFormula("(CH3)2NC(O)H", true);

        Oxydianiline = new Material.Builder(15035, "oxydianiline") //TODO ODA Tooltip
                .dust()
                .color(0xF0E130)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        KaptonK = new Material.Builder(15036, "kapton_k") //TODO Poly 4,4'-oxydiphenylene-pyromellitimide Tooltip
                .ingot().fluid()
                .color(0xFFCE52)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("(C7H2N2O4)(O(C6H4)2)", true);

        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(15037, "biphenyl_tetracarboxylic_acid_dianhydride") //TODO BPDA Tooltip
                .dust()
                .color(0xFF7F50)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 16, Hydrogen, 6, Oxygen, 6)
                .build()
                .setFormula("(C8H3O3)2", true);

        Nitroaniline = new Material.Builder(15038, "nitroaniline")
                .fluid()
                .color(0x2A6E68)
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("H2NC6H4NO2", true);

        ParaPhenylenediamine = new Material.Builder(15039, "para_phenylenediamine")
                .dust()
                .color(0x4A8E7B)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .build()
                .setFormula("H2NC6H4NH2", true);

        KaptonE = new Material.Builder(15040, "kapton_e")
                .ingot().fluid()
                .color(0xFFDF8C)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, NO_SMASHING, NO_SMELTING, GENERATE_FOIL)
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .build()
                .setFormula("O(C6H4NH2)2", true);

        Methylamine = new Material.Builder(15041, "methylamine")
                .fluid(FluidTypes.GAS)
                .color(0xAA6600)
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .build()
                .setFormula("CH3NH2", true);

        Trimethylamine = new Material.Builder(15042, "trimethylamine")
                .fluid(FluidTypes.GAS)
                .color(0xBB7700)
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .build()
                .setFormula("(CH3)3N", true);

        Bistrichloromethylbenzene = new Material.Builder(15043, "bistrichloromethylbenzene")
                .fluid()
                .color(0xCF8498)
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 6)
                .build()
                .setFormula("C6H4(CCl3)2", true);

        Tetrabromoethane = new Material.Builder(15044, "tetrabromoethane")
                .fluid()
                .color(0x5AAADA)
                .components(Carbon, 2, Hydrogen, 2, Bromine, 4)
                .build();

        TerephthalicAcid = new Material.Builder(15045, "terephthalic_acid") //TODO "PTA" Tooltip
                .dust()
                .color(0x5ACCDA)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .build()
                .setFormula("C6H4(CO2H)2", true);

        TerephthaloylChloride = new Material.Builder(15046, "terephthaloyl_chloride")
                .dust()
                .color(0xFAC4DA)
                .iconSet(MaterialIconSet.SHINY)
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 2, Chlorine, 2)
                .build()
                .setFormula("C6H4(COCl)2", true);

        Butanediol = new Material.Builder(15047, "butanediol")
                .fluid()
                .color(0xAAC4DA)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .build()
                .setFormula("C4H8(OH)2", true);

        GammaButyrolactone = new Material.Builder(15048, "gamma_butyrolactone") //TODO "GBL" tooltip
                .fluid()
                .color(0xAF04D6)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        NMethylPyrrolidone = new Material.Builder(15049, "n_methyl_pyrrolidone")
                .fluid()
                .color(0xA504D6)
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .build();

        Kevlar = new Material.Builder(15050, "kevlar")
                .ingot().fluid()
                .color(0xF0F078)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 14, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .build()
                .setFormula("(C6H4)2(CO)2(NH)2", true);

        TetramethylammoniumHydroxide = new Material.Builder(15051, "tetramethylammonium_hydroxide") //TODO "TMAH" tooltip
                .fluid() //this should be a solid, however it will be liquid for circuit etching purposes
                .color(0x40FFD6)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Carbon, 4, Hydrogen, 12, Oxygen, 1, Hydrogen, 1)
                .build()
                .setFormula("N(CH3)4OH", true);

        Pyrocatechol = new Material.Builder(15052, "pyrocatechol")
                .dust()
                .color(0x784421)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.DULL)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .build();

        EthyleneOxide = new Material.Builder(15053, "ethylene_oxide")
                .fluid(FluidTypes.GAS)
                .color(0xDCBFE1)
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .build();

        EthyleneGlycol = new Material.Builder(15054, "ethylene_glycol")
                .fluid()
                .color(0x286632)
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .build()
                .setFormula("C2H4(OH)2", true);

        Diacetyl = new Material.Builder(15055, "diacetyl") //TODO "Tastes like butter" tooltip
                .fluid()
                .color(0xF7FF65)
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .build();

        AcetoneCyanohydrin = new Material.Builder(15056, "acetone_cyanohydrin")
                .fluid()
                .color(0xA1FFD0)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 4, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .build();

        PMMA = new Material.Builder(15057, "polymethylmethacrylate") //TODO PMMA tooltip
                .ingot().fluid()
                .color(0x91CAE1)
                .flags(DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .build();

        Trimethylaluminium = new Material.Builder(15058, "trimethylaluminium")
                .fluid()
                .color(0x6ECCFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 2, Carbon, 6, Hydrogen, 18)
                .build()
                .setFormula("Al2(CH3)6", true);

        Trimethylgallium = new Material.Builder(15059, "trimethylgallium")
                .fluid()
                .color(0x4F92FF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Carbon, 3, Hydrogen, 9)
                .build()
                .setFormula("Ga(CH3)3", true);

        EthyleneDibromide = new Material.Builder(15060, "ethylene_dibromide") //TODO "EDB" tooltip
                .fluid()
                .color(0x4F1743)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 4, Bromine, 2)
                .build();

        GrignardReagent = new Material.Builder(15061, "grignard_reagent")
                .fluid()
                .color(0xA12AA1)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Hydrogen, 3, Magnesium, 1, Bromine, 1)
                .build();

        Dimethylcadmium = new Material.Builder(15062, "dimethylcadmium")
                .fluid()
                .color(0x5C037F)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 6, Cadmium, 1)
                .build()
                .setFormula("(CH3)2Cd", true);

        DiethylSuflide = new Material.Builder(15063, "diethyl_sulfide")
                .fluid()
                .color(0xFF7E4B)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ethylene, 2, Sulfur, 1)
                .build()
                .setFormula("(C2H5)2S", true);

        Cycloparaphenylene = new Material.Builder(15064, "cycloparaphenylene") //TODO "CPP" tooltip
                .fluid()
                .color(0x60545A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 6, Hydrogen, 4)
                .build();

        Indene = new Material.Builder(15065, "indene")
                .fluid()
                .color(0x171429)
                .components(Carbon, 9, Hydrogen, 8)
                .build();

        Indanone = new Material.Builder(15066, "indanone")
                .dust()
                .color(0x2E1616).iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 9, Hydrogen, 8, Oxygen, 1)
                .build();

        Truxene = new Material.Builder(15067, "truxene")
                .fluid()
                .color(0x1A3336)
                .components(Carbon, 27, Hydrogen, 18)
                .build();

        Bromomethane = new Material.Builder(15068, "bromomethane")
                .fluid(FluidTypes.GAS)
                .color(0xC82C31)
                .components(Carbon, 1, Hydrogen, 3, Bromine, 1)
                .build();

        BromoBromomethylNaphthalene = new Material.Builder(15069, "bromo_bromomethyl_naphthalene")
                .fluid()
                .color(0x52122E)
                .components(Carbon, 11, Hydrogen, 8, Bromine, 2)
                .build();

        Bromobutane = new Material.Builder(15070, "bromobutane")
                .fluid(FluidTypes.GAS)
                .color(0xE6E8A2)
                .components(Butene, 1, HydrobromicAcid, 1)
                .build()
                .setFormula("C4H9Br", true);

        Butyllithium = new Material.Builder(15071, "butyllithium")
                .fluid()
                .color(0xE683B6B)
                .components(Butene, 1, Hydrogen, 1, Lithium, 1)
                .build()
                .setFormula("C4H9Li", true);

        PalladiumAcetate = new Material.Builder(15072, "palladium_acetate")
                .dust()
                .color(0x693C2D).iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Palladium, 1, AceticAcid, 2)
                .build()
                .setFormula("Pd(CH3COOH)2", true);

        GeodesicPolyarene = new Material.Builder(15073, "geodesic_polyarene")
                .dust()
                .color(0x9E81A8).iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 60, Hydrogen, 30)
                .build();

        Edot = new Material.Builder(15074, "edot")
                .fluid()
                .color(0xB1FFD7)
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2, Sulfur, 1)
                .build();

        Polystyrene = new Material.Builder(15075, "polystyrene")
                .fluid()
                .color(0xE1C2C2)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 8, Hydrogen, 8)
                .build();

        PolystyreneSulfonate = new Material.Builder(15076, "polystyrene_sulfonate")
                .ingot().fluid()
                .color(0xE17C72)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(Carbon, 8, Hydrogen, 8, Sulfur, 1, Oxygen, 3)
                .build();

        PedotPSS = new Material.Builder(15077, "pedot_pss")
                .ingot().fluid()
                .color(0xE165A7)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FINE_WIRE)
                .components(Edot, 1, PolystyreneSulfonate, 1)
                .cableProperties(V[UHV], 24, 0, true)
                .build();

        PedotTMA = new Material.Builder(15078, "pedot_tma")
                .ingot().fluid()
                .color(0x5E9EE1)
                .flags(DISABLE_DECOMPOSITION, GENERATE_ROD, GENERATE_SPRING)
                .components(Edot, 1, PMMA, 2)
                .cableProperties(V[UEV], 8, 6)
                .build();
    }

    /**
     * 18000-19999
     */
    public static void unknownComposition() {

        RareEarthHydroxidesSolution = new Material.Builder(18000, "rare_earth_hydroxides_solution")
                .fluid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .build();

        RareEarthChloridesSolution = new Material.Builder(18001, "rare_earth_chlorides_solution")
                .fluid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();

        LeachedTurpentine = new Material.Builder(18002, "leached_turpentine")
                .fluid()
                .color(0x330D16)
                .flags(DISABLE_DECOMPOSITION)
                .components(Turpentine, 1, RareEarth, 1)
                .build();

        SteamCrackedTurpentine = new Material.Builder(18003, "steamcracked_turpentine").fluid().color(0x634D56).build();

        BZMedium = new Material.Builder(18004, "bz_medium").fluid().color(0xA2FD35).build(); //TODO "The Belousov-Zhabotinsky Reaction" tooltip

        RichNitrogenMixture = new Material.Builder(18013, "rich_nitrogen_mixture").fluid(FluidTypes.GAS).color(0x6891D8).build();

        RichAmmoniaMixture = new Material.Builder(18014, "rich_ammonia_mixture").fluid().color(0x708ACD).build();

        Brine = new Material.Builder(18015, "brine").fluid().color(0xFCFC8A).build();

        ChlorinatedBrine = new Material.Builder(18016, "chlorinated_brine").fluid().color(0xFAFC8A).build();

        ChalcogenAnodeMud = new Material.Builder(18017, "chalcogen_anode_mud").dust().color(0x8A3324).iconSet(FINE).build();

        MethylamineMixture = new Material.Builder(18018, "methylamine_mixture").fluid().color(0xAA4400).build();

        EDP = new Material.Builder(18019, "edp").fluid().color(0xFBFF17).build();

        PhosphoreneSolution = new Material.Builder(18020, "phosphorene_solution").fluid().color(0x465966).build();

        SodioIndene = new Material.Builder(18021, "sodio_indene").fluid().color(0x1D1C24).build();

        SteamCrackedSodioIndene = new Material.Builder(18022, "steam_cracked_sodio_indene").fluid().fluidTemp(1105).color(0x1C1A29).build();

        MolybdenumFlue = new Material.Builder(18023, "molybdenum_flue").fluid(FluidTypes.GAS).color(0x39194A).build();

        TraceRheniumFlue = new Material.Builder(18024, "trace_rhenium_flue").fluid(FluidTypes.GAS).color(0x96D6D5).build();

        FracturingFluid = new Material.Builder(18025, "fracturing_fluid").fluid().color(0x96D6D5).build();

        BedrockSmoke = new Material.Builder(18026, "bedrock_smoke").fluid(FluidTypes.GAS).color(0x525252).build();

        // FREE ID 18027

        Bedrock = new Material.Builder(18028, "bedrock").dust().color(0x404040).iconSet(ROUGH).build();

        BedrockSootSolution = new Material.Builder(18029, "bedrock_soot_solution").fluid().color(0x1E2430).build();

        CleanBedrockSolution = new Material.Builder(18030, "clean_bedrock_solution").fluid().color(0xA89F9E).build();

        HeavyBedrockSmoke = new Material.Builder(18031, "heavy_bedrock_smoke").fluid(FluidTypes.GAS).color(0x242222).build();

        MediumBedrockSmoke = new Material.Builder(18032, "medium_bedrock_smoke").fluid(FluidTypes.GAS).color(0x2E2C2C).build();

        LightBedrockSmoke = new Material.Builder(18033, "light_bedrock_smoke").fluid(FluidTypes.GAS).color(0x363333).build();

        UltralightBedrockSmoke = new Material.Builder(18034, "ultralight_bedrock_smoke").fluid(FluidTypes.GAS).color(0x403D3D).build();

        HeavyTaraniumGas = new Material.Builder(18035, "heavy_taranium_gas").fluid(FluidTypes.GAS).color(0x262626).build();

        MediumTaraniumGas = new Material.Builder(18036, "medium_taranium_gas").fluid(FluidTypes.GAS).color(0x313131).build();

        LightTaraniumGas = new Material.Builder(18037, "light_taranium_gas").fluid(FluidTypes.GAS).color(0x404040).build();

        BedrockGas = new Material.Builder(18038, "bedrock_gas").fluid(FluidTypes.GAS).color(0x575757).build();

        CrackedHeavyTaranium = new Material.Builder(18039, "cracked_heavy_taranium").fluid().color(0x1F2B2E).build();

        CrackedMediumTaranium = new Material.Builder(18040, "cracked_medium_taranium").fluid().color(0x29393D).build();

        CrackedLightTaranium = new Material.Builder(18041, "cracked_light_taranium").fluid().color(0x374C52).build();

        EnrichedBedrockSootSolution = new Material.Builder(18042, "enriched_bedrock_soot_solution").fluid().color(0x280C26).build();

        CleanEnrichedBedrockSolution = new Material.Builder(18043, "clean_enriched_bedrock_solution").fluid().color(0x828C8C).build();

        HeavyEnrichedBedrockSmoke = new Material.Builder(18044, "heavy_enriched_bedrock_smoke").fluid(FluidTypes.GAS).color(0x1A2222).build();

        MediumEnrichedBedrockSmoke = new Material.Builder(18045, "medium_enriched_bedrock_smoke").fluid(FluidTypes.GAS).color(0x1E2C2C).build();

        LightEnrichedBedrockSmoke = new Material.Builder(18046, "light_enriched_bedrock_smoke").fluid(FluidTypes.GAS).color(0x163333).build();

        HeavyEnrichedTaraniumGas = new Material.Builder(18047, "heavy_enriched_taranium_gas").fluid(FluidTypes.GAS).color(0x1F2626).build();

        MediumEnrichedTaraniumGas = new Material.Builder(18048, "medium_enriched_taranium_gas").fluid(FluidTypes.GAS).color(0x1F3131).build();

        LightEnrichedTaraniumGas = new Material.Builder(18049, "light_enriched_taranium_gas").fluid(FluidTypes.GAS).color(0x1F4040).build();

        CrackedHeavyEnrichedTaranium = new Material.Builder(18050, "cracked_heavy_enriched_taranium").fluid().color(0x2E1F2E).build();

        CrackedMediumEnrichedTaranium = new Material.Builder(18051, "cracked_medium_enriched_taranium").fluid().color(0x29393D).build();

        CrackedLightEnrichedTaranium = new Material.Builder(18052, "cracked_light_enriched_taranium").fluid().color(0x374C52).build();

        EnergeticNaquadria = new Material.Builder(18053, "energetic_naquadria").fluid().color(0x202020).build();

        LightHyperFuel = new Material.Builder(18054, "light_hyper_fuel").fluid().color(0x8C148C).build();

        MediumHyperFuel = new Material.Builder(18055, "medium_hyper_fuel").fluid().color(0xDC0A0A).build();

        HeavyHyperFuel = new Material.Builder(18056, "heavy_hyper_fuel").fluid().color(0x1E5064).build();
    }
}
