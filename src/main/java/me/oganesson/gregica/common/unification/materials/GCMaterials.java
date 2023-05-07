package me.oganesson.gregica.common.unification.materials;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;
import me.oganesson.gregica.GCConfig;
import me.oganesson.gregica.common.unification.materials.material.FirstDegreeMaterials;
import me.oganesson.gregica.common.unification.materials.material.GCYSDegreeMaterials;
import me.oganesson.gregica.common.unification.materials.material.SecondDegreeMaterials;
import me.oganesson.gregica.common.unification.materials.material.TJCoreDegreeMaterials;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GCMaterials {
    //Isotopes

    public static Material[] doNotGenerate = new Material[]{Carbon};
    public static List<MaterialFlag> STANDARDPLATE = new ArrayList<>(Arrays.asList(GENERATE_PLATE, GENERATE_DENSE, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES));
    public static List<MaterialFlag> STANDARDWIREFINE = new ArrayList<>(Collections.singletonList(GENERATE_FINE_WIRE));
    public static List<MaterialFlag> STANDARDFOIL = new ArrayList<>(Collections.singletonList(GENERATE_FOIL));
    public static List<MaterialFlag> STANDARDROD = new ArrayList<>(Arrays.asList(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW));
    public static List<MaterialFlag> STANDARDROTOR = new ArrayList<>(Arrays.asList(GENERATE_ROTOR, GENERATE_RING));
    public static List<MaterialFlag> STANDARDGEAR = new ArrayList<>(Arrays.asList(GENERATE_GEAR, GENERATE_SMALL_GEAR));
    public static List<MaterialFlag> STANDARDSPRING = new ArrayList<>(Arrays.asList(GENERATE_SPRING, GENERATE_SPRING_SMALL));
    public static List<MaterialFlag> STANDARDROUND = new ArrayList<>(Collections.singletonList(GENERATE_ROUND));
    public static List<MaterialFlag> STANDARDLENS = new ArrayList<>(Collections.singletonList(GENERATE_LENS));

    public static List<MaterialFlag> STANDARDCASING = new ArrayList<>(Collections.singletonList(GENERATE_FRAME));
    public static List<MaterialFlag> STANDARDGEM = new ArrayList<>(Arrays.asList(GENERATE_LENS, HIGH_SIFTER_OUTPUT));

    public static Material Cobalt60;
    public static Material SuperfluidHelium3;

    //Alloys
    public static Material BT6;
    public static Material Birmabright;
    public static Material NickelPlatedTin;
    public static Material DegenerateRhenium;
    public static Material NihoniumTriiodide;
    public static Material SuperheavyH;
    public static Material SuperheavyL;
    public static Material EnrichedNaqAlloy;
    public static Material TriniumSteel;
    public static Material TerfenolD_H;
    public static Material TerfenolD_L;
    public static Material GalvanizedSteel;
    public static Material LutetiumTantalate;
    public static Material Iridrhodruthenium;
    public static Material HEA_1;
    public static Material HEA_2;
    public static Material HEA_3;
    public static Material HDCS_1;
    public static Material HDCS_2;
    public static Material HDCS_3;
    public static Material Pikyonium;
    public static Material TantalumCarbide;
    public static Material HafniumCarbide;
    public static Material SeaborgiumCarbide;
    public static Material TantalumHafniumSeaborgiumCarbide;
    public static Material TantalumHafniumSeaborgiumCarboNitride;
    public static Material OganessonTetraTennesside;


    //Chemicals
    public static Material Methyltrichlorosilane;
    public static Material Methyltrimethoxysilane;
    public static Material Polymethylsilesquioxane;
    public static Material Silane;
    public static Material TriphenylPhosphine;
    public static Material PhenylmagnesiumBromide;
    public static Material Bromobenzene;
    public static Material HydrogenSilsesquioxane;
    public static Material SU8_Photoresist;
    public static Material MolybdenumSulfide;
    public static Material Difluoroethane; //C2H4F2
    public static Material PalladiumChloride; // PdCl2
    public static Material AllylAcetate;
    public static Material SilverLeadOxide;
    public static Material LuminescentSiliconNanocrystals;
    public static Material SeleniumMonobromide;
    public static Material HydraziniumChloride;
    public static Material DibromoisophthalicAcid;
    public static Material Dibromoterephthaloyldichloride;
    public static Material HafniumSilicate;
    public static Material GraphenePQD;
    public static Material BismuthIridiumOxide;
    public static Material IndiumFluoride;
    public static Material XenonDioxide;
    public static Material XenonTetraFluoride;
    public static Material XenonOxyTetraFluoride;
    public static Material XenonHexaFluoride;
    public static Material NeonFluoride;
    public static Material ExcitedNeonFluoride;
    public static Material ArgonFluorine;
    public static Material SilverGalliumSelenide;
    public static Material IridiumOnCubicZirconia;
    public static Material OnePropanol;
    public static Material ZSM_5_ZEOLITE;
    public static Material SodiumHydroxideSilica;
    public static Material SodiumAluminate;
    public static Material SodiumAluminumSilicaSolution;
    public static Material AluminoSilicateGlass;
    public static Material DimethylCarbonate;
    public static Material TetramethylammoniumBromide;
    public static Material CobaltChloride;
    public static Material CobaltIodide;
    public static Material Cobalt60Iodide;
    public static Material Cobalt59Iodide;
    public static Material Cobalt59;
    public static Material HydroiodicAcid;
    public static Material ImpureHydroiodicAcid;
    public static Material Butynediol;
    public static Material KAOil;
    public static Material AdipicAcid;
    public static Material NitrousAcid;
    public static Material BariumOxide;
    public static Material BariumHydroxide;
    public static Material Cyclopentanone;
    public static Material BenzenesulfonicAcid;
    public static Material TriphenylsulfoniumHexafluoroantimonate;
    public static Material HypofluorousAcid;
    public static Material HexafluoroantimonateSalt1;
    public static Material HexafluoroantimonateSalt2;
    public static Material MixedHexafluoroantimonateSalts;
    public static Material DiluteFluoroantimonicAcid;

    // Cermaics + Glass
    public static Material SodiumPotassiumNiobate;
    public static Material BismuthTelluride;
    public static Material SilicaCeramic;
    public static Material Fiberglass;
    public static Material SynthDiamond;
    public static Material LeadZirconateTitanate;
    public static Material BismuthPhosphomolybdate;
    public static Material Acrylonitrile;
    public static Material SodiumThiocyanate;
    public static Material SodiumThiocyanatePolymerizationSolution;
    public static Material Cellulose;
    public static Material ZirconiumTetrafluoride;
    public static Material BariumDifluoride;
    public static Material LanthanumTrifluoride;
    public static Material AluminiumTrifluoride;
    public static Material SodiumFluoride;
    //
    public static Material BauxiteSlurry;
    public static Material IlmeniteSlurry;
    public static Material RedMud;
    public static Material HeavyRedMudResidue;
    public static Material RefractoryMetalResidue;
    public static Material PotassiumFluorideRefractoryMixture;
    public static Material PotassiumHexafluorozirconate;
    public static Material PotassiumHexafluorohafnate;
    public static Material HafniumTetrachloride;
    public static Material ZirconiumTetrachloride;
    public static Material Trichlorosilane;

    // Polymers
    public static Material Polyacrylonitrile;
    public static Material Polyetheretherketone;
    public static Material CarbonNanotubePolymer;
    public static Material Ladder_Poly_P_Phenylene;

    // Mixtures
    public static Material SuspendedPGQD;
    public static Material ArgonSilane;
    public static Material DiamondSonicationSolution;
    public static Material XenonFluorideSupercondiveMix;
    public static Material P1Solution;
    public static Material TetrakisPDCatalyst;
    public static Material CFCoatingSolution;
    public static Material IndiumSolution;
    public static Material IndiumSulfide;
    public static Material IndiumResidue;
    public static Material SulfuricFlueGas;
    public static Material SulfuricIronSlag;
    public static Material SulfuricZincSlag;
    public static Material SulfuricNickelSlag;
    public static Material SulfuricCopperSlag;

    //BIOCHEM MATERIALS BEWARE

    public static Material PotassiumHydride;
    public static Material Aminopropionitrile;
    public static Material Aminopropylamine;
    public static Material KAPA;
    public static Material BetaPinene;
    public static Material AlphaPinene;
    public static Material Camphene;
    public static Material IsobornylAcetate;
    public static Material Isoborneol;
    public static Material SodiumAcetate;
    public static Material DehydrogenationCatalyst;
    public static Material SodiumPerchlorate;
    public static Material PerchloricAcid;
    public static Material Phenylhydrazine;
    public static Material BenzoylChloride;
    public static Material TriphenylMethoxytriazoylPerchlorate;
    public static Material SodiumMethoxide;
    public static Material TriphenylMethoxytriazole;
    public static Material Acetaldehyde;
    public static Material Acetoin;
    public static Material MetaNitrochlorobenzine;
    public static Material Nitroanisole;
    public static Material Anisidine;
    public static Material MethylBromoacetate;
    public static Material CarbethoxymethyleneTriphenylphosphorane;
    public static Material PropargylAlcohol;
    public static Material PropargylBromide;
    public static Material MethylmagnesiumIodide;
    public static Material AcetylChloride;
    public static Material Acetophenone;
    public static Material Phenylethylamine;
    public static Material PhenylethylIsocyanate;
    public static Material TriethyloxoniumTetrafluoroborate;
    public static Material TrischloroethoxypopanylBorate;



    // Magic materials, unknown composition
    public static Material Draconium;
    public static Material Manasteel;
    public static Material Terrasteel;
    public static Material Thaumium;
    public static Material Void;
    public static Material ColdIron;
    public static Material Starmetal;
    public static Material ManasteelAlloy;
    public static Material Starlight;
    public static Material Salis;

    //Long dist cable materials

    public static Material LVLongDistance = new Material.Builder(25029, "lv_long_distance").color(VC[LV]).build();
    public static Material MVLongDistance = new Material.Builder(25030, "mv_long_distance").color(VC[MV]).build();
    public static Material HVLongDistance = new Material.Builder(25031, "hv_long_distance").color(VC[HV]).build();
    public static Material EVLongDistance = new Material.Builder(25032, "ev_long_distance").color(VC[EV]).build();
    public static Material IVLongDistance = new Material.Builder(25033, "iv_long_distance").color(VC[IV]).build();

    //endgame unknown
    public static Material ProgrammableMatter;
    public static Material Gluons;
    public static Material HeavyQuarks;
    public static Material LightQuarks;
    public static Material Leptons;
    public static Material HeavyQuarkDegenerate;
    public static Material[] longDistanceWireMaterials = new Material[]{ MVLongDistance, HVLongDistance, EVLongDistance, IVLongDistance};

    // Element Materials
    public static Material Lithium6;
    public static Material Lithium7;
    public static Material Beryllium7;
    public static Material Orichalcum;
    public static Material Vibranium;
    public static Material Adamantium;
    public static Material Taranium;


    // First Degree Materials
    public static Material LanthanumOxide;
    public static Material PraseodymiumOxide;
    public static Material NeodymiumOxide;
    public static Material CeriumOxide;
    public static Material ScandiumOxide;
    public static Material EuropiumOxide;
    public static Material GadoliniumOxide;
    public static Material SamariumOxide;
    public static Material YttriumOxide;
    public static Material TerbiumOxide;
    public static Material DysprosiumOxide;
    public static Material HolmiumOxide;
    public static Material ErbiumOxide;
    public static Material ThuliumOxide;
    public static Material YtterbiumOxide;
    public static Material LutetiumOxide;
    public static Material PurifiedPlatinumGroupConcentrate;
    public static Material AmmoniumHexachloroplatinate;
    public static Material AmmoniumHexachloropalladate;
    public static Material PotassiumHydroxide;
    public static Material CarbonTetrachloride;
    public static Material RutheniumChloride;
    public static Material PotassiumBromate;
    public static Material SodiumNitrate;
    public static Material SodiumPeroxide;
    public static Material RhodiumOxide;
    public static Material SodiumChlorate;
    public static Material SulfurDichloride;
    public static Material ThionylChloride;
    public static Material OsmiumTetrachloride;
    public static Material TungstenTrioxide;
    public static Material Hydrazine;
    public static Material HydrogenPeroxide;
    public static Material BerylliumOxide;
    public static Material TantalumPentoxide;
    public static Material NiobiumPentoxide;
    public static Material CalciumDifluoride;
    public static Material ManganeseDifluoride;
    public static Material CalciumCarbide;
    public static Material CalciumHydroxide;
    public static Material SodiumCyanide;
    public static Material ChlorosulfuricAcid;
    public static Material CubicZirconia;
    public static Material MolybdenumTrioxide;
    public static Material LeadChloride;
    public static Material SodiumTellurite;
    public static Material TelluriumDioxide;
    public static Material SeleniumDioxide;
    public static Material SelenousAcid;
    public static Material BoricAcid;
    public static Material BoronTrioxide;
    public static Material BoronTrifluoride;
    public static Material LithiumTetrafluoroborate;
    public static Material Diborane;
    public static Material Borazine;
    public static Material BoronTrichloride;
    public static Material Trichloroborazine;
    public static Material HexagonalBoronNitride;
    public static Material CubicBoronNitride;
    public static Material AmorphousBoronNitride;
    public static Material Heterodiamond;
    public static Material CubicHeterodiamond;
    public static Material LithiumHydride;
    public static Material HydrobromicAcid;
    public static Material WhitePhosphorus;
    public static Material RedPhosphorus;
    public static Material VioletPhosphorus;
    public static Material BlackPhosphorus;
    public static Material BluePhosphorus;
    public static Material Phosphorene;
    public static Material PhosphorusTrichloride;
    public static Material PhosphorylChloride;
    public static Material ZincOxide;
    public static Material GermaniumTetrachloride;
    public static Material GermaniumDioxide;
    public static Material SiliconTetrachloride;
    public static Material GSTGlass;
    public static Material ZBLANGlass;
    public static Material HeliumNeon;
    public static Material AluminiumTrichloride;
    public static Material AluminiumHydroxide;
    public static Material GalliumTrichloride;
    public static Material GalliumTrioxide;
    public static Material GalliumNitride;
    public static Material CadmiumBromide;
    public static Material MagnesiumBromide;
    public static Material CadmiumSulfide;
    public static Material CadmiumSelenide;
    public static Material Phosphine;
    public static Material PlutoniumTrihydride;
    public static Material PlutoniumPhosphide;
    public static Material CarbonNanotube;
    public static Material LithiumHydroxide;
    public static Material LithiumAmalgam;
    public static Material Lithium7Hydroxide;
    public static Material NeptuniumAluminide;
    public static Material BismuthTrioxide;
    public static Material FerricOxide;
    public static Material BismuthChalcogenide;
    public static Material MercuryCadmiumTelluride;
    public static Material AluminiumSelenide;
    public static Material HydrogenSelenide;
    public static Material PalladiumNitrate;
    public static Material Fullerene;
    public static Material ThalliumCopperChloride;
    public static Material PerrhenicAcid;
    public static Material AmmoniumPerrhenate;
    public static Material ThalliumSulfate;
    public static Material HeavyTaraniumFuel;
    public static Material MediumTaraniumFuel;
    public static Material LightTaraniumFuel;
    public static Material HeavyEnrichedTaraniumFuel;
    public static Material MediumEnrichedTaraniumFuel;
    public static Material LightEnrichedTaraniumFuel;
    public static Material Adamantite;
    public static Material AdamantiumUnstable;
    public static Material OrichalcumEnergized;
    public static Material AdamantiumEnriched;
    public static Material DeepIron;
    public static Material VibraniumUnstable;
    public static Material SiliconCarbide;
    public static Material ChromiumGermaniumTelluride;
    public static Material Kovar;
    public static Material StannicChloride;
    public static Material RubidiumChlorostannate;
    public static Material CaesiumChlorostannate;
    public static Material HRAMagnesium;
    public static Material LithiumFluoride;
    public static Material Alumina;
    public static Material ChloroplatinicAcid;


    // Second Degree Materials
    public static Material LaPrNdCeOxidesSolution;
    public static Material ScEuGdSmOxidesSolution;
    public static Material YTbDyHoOxidesSolution;
    public static Material ErTmYbLuOxidesSolution;
    public static Material PlatinumGroupConcentrate;
    public static Material PlatinumGroupResidue;
    public static Material GrapheneOxide;
    public static Material AmmoniumNitrate;
    public static Material Wollastonite;
    public static Material RoastedSphalerite;
    public static Material WaelzOxide;
    public static Material WaelzSlag;
    public static Material ImpureGermaniumDioxide;
    public static Material ErbiumDopedZBLANGlass;
    public static Material PraseodymiumDopedZBLANGlass;
    public static Material NdYAG;
    public static Material BismuthFerrite;
    public static Material ChromiumGermaniumTellurideMagnetic;
    public static Material HeavyAlkaliChlorideSolution;


    // Third Degree Materials
    public static Material ZincRichSphalerite;


    // Organic Chemistry Materials
    public static Material Tetrahydrofuran;
    public static Material Ethylhexanol;
    public static Material DiethylhexylPhosphoricAcid;
    public static Material Butanol;
    public static Material MethylFormate;
    public static Material FormicAcid;
    public static Material PhthalicAnhydride;
    public static Material Ethylanthraquinone;
    public static Material Ethylanthrahydroquinone;
    public static Material Formaldehyde;
    public static Material Acetylene;
    public static Material Turpentine;
    public static Material ChloroaceticAcid;
    public static Material MalonicAcid;
    public static Material Trichloroethylene;
    public static Material Dichloroethane;
    public static Material Ethylenediamine;
    public static Material HydrogenCyanide;
    public static Material TetrasodiumEDTA;
    public static Material EthylenediaminetetraaceticAcid;
    public static Material Aniline;
    public static Material AceticAnhydride;
    public static Material ParaXylene;
    public static Material Durene;
    public static Material PyromelliticDianhydride;
    public static Material Aminophenol;
    public static Material Dimethylformamide;
    public static Material Oxydianiline;
    public static Material KaptonK;
    public static Material BiphenylTetracarboxylicAcidDianhydride;
    public static Material Nitroaniline;
    public static Material ParaPhenylenediamine;
    public static Material KaptonE;
    public static Material Methylamine;
    public static Material Trimethylamine;
    public static Material Bistrichloromethylbenzene;
    public static Material Tetrabromoethane;
    public static Material TerephthalicAcid;
    public static Material TerephthaloylChloride;
    public static Material Butanediol;
    public static Material GammaButyrolactone;
    public static Material NMethylPyrrolidone;
    public static Material Kevlar;
    public static Material TetramethylammoniumChloride;
    public static Material TetramethylammoniumHydroxide;
    public static Material Pyrocatechol;
    public static Material EthyleneOxide;
    public static Material EthyleneGlycol;
    public static Material Diacetyl;
    public static Material AcetoneCyanohydrin;
    public static Material PMMA;
    public static Material Trimethylaluminium;
    public static Material Trimethylgallium;
    public static Material EthyleneDibromide;
    public static Material GrignardReagent;
    public static Material Dimethylcadmium;
    public static Material DiethylSuflide;
    public static Material Cycloparaphenylene;
    public static Material Indene;
    public static Material Indanone;
    public static Material Truxene;
    public static Material Bromomethane;
    public static Material BromoBromomethylNaphthalene;
    public static Material Bromobutane;
    public static Material Butyllithium;
    public static Material PalladiumAcetate;
    public static Material GeodesicPolyarene;
    public static Material Edot;
    public static Material Polystyrene;
    public static Material PolystyreneSulfonate;
    public static Material PedotPSS;
    public static Material PedotTMA;


    // Unknown Composition Materials
    public static Material RareEarthHydroxidesSolution;
    public static Material RareEarthChloridesSolution;
    public static Material LeachedTurpentine;
    public static Material SteamCrackedTurpentine;
    public static Material BZMedium;
    public static Material RichNitrogenMixture;
    public static Material RichAmmoniaMixture;
    public static Material Brine;
    public static Material ChlorinatedBrine;
    public static Material ChalcogenAnodeMud;
    public static Material MethylamineMixture;
    public static Material EDP;
    public static Material PhosphoreneSolution;
    public static Material SodioIndene;
    public static Material SteamCrackedSodioIndene;
    public static Material MolybdenumFlue;
    public static Material TraceRheniumFlue;
    public static Material FracturingFluid;
    public static Material BedrockSmoke;
    public static Material Bedrock;
    public static Material BedrockSootSolution;
    public static Material CleanBedrockSolution;
    public static Material HeavyBedrockSmoke;
    public static Material MediumBedrockSmoke;
    public static Material LightBedrockSmoke;
    public static Material UltralightBedrockSmoke;
    public static Material HeavyTaraniumGas;
    public static Material MediumTaraniumGas;
    public static Material LightTaraniumGas;
    public static Material BedrockGas;
    public static Material CrackedHeavyTaranium;
    public static Material CrackedMediumTaranium;
    public static Material CrackedLightTaranium;
    public static Material EnrichedBedrockSootSolution;
    public static Material CleanEnrichedBedrockSolution;
    public static Material HeavyEnrichedBedrockSmoke;
    public static Material MediumEnrichedBedrockSmoke;
    public static Material LightEnrichedBedrockSmoke;
    public static Material HeavyEnrichedTaraniumGas;
    public static Material MediumEnrichedTaraniumGas;
    public static Material LightEnrichedTaraniumGas;
    public static Material CrackedHeavyEnrichedTaranium;
    public static Material CrackedMediumEnrichedTaranium;
    public static Material CrackedLightEnrichedTaranium;
    public static Material EnergeticNaquadria;
    public static Material LightHyperFuel;
    public static Material MediumHyperFuel;
    public static Material HeavyHyperFuel;



    //Material ID: 26000-27000

    public static Material Coolant;
    public static Material SuperCoolant;
    public static Material Cryotheum;
    public static Material XPJuice;
    public static Material Blood;
    public static Material Pure;
    public static Material Death;
    public static Material Spirit;
    public static Material Hollowtears;
    public static Material AtomicSeparationCatalyst;
    public static Material Tiberium;
    public static Material NeutronsFlow;
    public static Material ProtonFlow;
public static Material BismuthLeadAlloy;
    public static void register() {
        FirstDegreeMaterials.register();
        SecondDegreeMaterials.register();

        if (GCConfig.Misc.enableTjcore) {
            TJCoreDegreeMaterials.register();
            GCYSDegreeMaterials.register();
        }
    }
}