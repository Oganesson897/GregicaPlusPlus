package project.gregica.module.gcys.api.unification.materials.material;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.FINE;
import static gregtech.api.unification.material.info.MaterialIconSet.ROUGH;

public class GCYSUnknownCompositionMaterials {

    /**
     * 18000-19999
     */
    public static void init() {

        GCYSMaterials.RareEarthHydroxidesSolution = new Material.Builder(18000, "rare_earth_hydroxides_solution")
                .fluid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .build();

        GCYSMaterials.RareEarthChloridesSolution = new Material.Builder(18001, "rare_earth_chlorides_solution")
                .fluid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .build();

        GCYSMaterials.LeachedTurpentine = new Material.Builder(18002, "leached_turpentine")
                .fluid()
                .color(0x330D16)
                .flags(DISABLE_DECOMPOSITION)
                .components(GCYSMaterials.Turpentine, 1, RareEarth, 1)
                .build();

        GCYSMaterials.SteamCrackedTurpentine = new Material.Builder(18003, "steamcracked_turpentine").fluid().color(0x634D56).build();

        GCYSMaterials.BZMedium = new Material.Builder(18004, "bz_medium").fluid().color(0xA2FD35).build(); //TODO "The Belousov-Zhabotinsky Reaction" tooltip

        GCYSMaterials.RichNitrogenMixture = new Material.Builder(18013, "rich_nitrogen_mixture").fluid(FluidTypes.GAS).color(0x6891D8).build();

        GCYSMaterials.RichAmmoniaMixture = new Material.Builder(18014, "rich_ammonia_mixture").fluid().color(0x708ACD).build();

        GCYSMaterials.Brine = new Material.Builder(18015, "brine").fluid().color(0xFCFC8A).build();

        GCYSMaterials.ChlorinatedBrine = new Material.Builder(18016, "chlorinated_brine").fluid().color(0xFAFC8A).build();

        GCYSMaterials.ChalcogenAnodeMud = new Material.Builder(18017, "chalcogen_anode_mud").dust().color(0x8A3324).iconSet(FINE).build();

        GCYSMaterials.MethylamineMixture = new Material.Builder(18018, "methylamine_mixture").fluid().color(0xAA4400).build();

        GCYSMaterials.EDP = new Material.Builder(18019, "edp").fluid().color(0xFBFF17).build();

        GCYSMaterials.PhosphoreneSolution = new Material.Builder(18020, "phosphorene_solution").fluid().color(0x465966).build();

        GCYSMaterials.SodioIndene = new Material.Builder(18021, "sodio_indene").fluid().color(0x1D1C24).build();

        GCYSMaterials.SteamCrackedSodioIndene = new Material.Builder(18022, "steam_cracked_sodio_indene").fluid().fluidTemp(1105).color(0x1C1A29).build();

        GCYSMaterials.MolybdenumFlue = new Material.Builder(18023, "molybdenum_flue").fluid(FluidTypes.GAS).color(0x39194A).build();

        GCYSMaterials.TraceRheniumFlue = new Material.Builder(18024, "trace_rhenium_flue").fluid(FluidTypes.GAS).color(0x96D6D5).build();

        GCYSMaterials.FracturingFluid = new Material.Builder(18025, "fracturing_fluid").fluid().color(0x96D6D5).build();

        GCYSMaterials.BedrockSmoke = new Material.Builder(18026, "bedrock_smoke").fluid(FluidTypes.GAS).color(0x525252).build();

        // FREE ID 18027

        GCYSMaterials.Bedrock = new Material.Builder(18028, "bedrock").dust().color(0x404040).iconSet(ROUGH).build();

        GCYSMaterials.BedrockSootSolution = new Material.Builder(18029, "bedrock_soot_solution").fluid().color(0x1E2430).build();

        GCYSMaterials.CleanBedrockSolution = new Material.Builder(18030, "clean_bedrock_solution").fluid().color(0xA89F9E).build();

        GCYSMaterials.HeavyBedrockSmoke = new Material.Builder(18031, "heavy_bedrock_smoke").fluid(FluidTypes.GAS).color(0x242222).build();

        GCYSMaterials.MediumBedrockSmoke = new Material.Builder(18032, "medium_bedrock_smoke").fluid(FluidTypes.GAS).color(0x2E2C2C).build();

        GCYSMaterials.LightBedrockSmoke = new Material.Builder(18033, "light_bedrock_smoke").fluid(FluidTypes.GAS).color(0x363333).build();

        GCYSMaterials.UltralightBedrockSmoke = new Material.Builder(18034, "ultralight_bedrock_smoke").fluid(FluidTypes.GAS).color(0x403D3D).build();

        GCYSMaterials.HeavyTaraniumGas = new Material.Builder(18035, "heavy_taranium_gas").fluid(FluidTypes.GAS).color(0x262626).build();

        GCYSMaterials.MediumTaraniumGas = new Material.Builder(18036, "medium_taranium_gas").fluid(FluidTypes.GAS).color(0x313131).build();

        GCYSMaterials.LightTaraniumGas = new Material.Builder(18037, "light_taranium_gas").fluid(FluidTypes.GAS).color(0x404040).build();

        GCYSMaterials.BedrockGas = new Material.Builder(18038, "bedrock_gas").fluid(FluidTypes.GAS).color(0x575757).build();

        GCYSMaterials.CrackedHeavyTaranium = new Material.Builder(18039, "cracked_heavy_taranium").fluid().color(0x1F2B2E).build();

        GCYSMaterials.CrackedMediumTaranium = new Material.Builder(18040, "cracked_medium_taranium").fluid().color(0x29393D).build();

        GCYSMaterials.CrackedLightTaranium = new Material.Builder(18041, "cracked_light_taranium").fluid().color(0x374C52).build();

        GCYSMaterials.EnrichedBedrockSootSolution = new Material.Builder(18042, "enriched_bedrock_soot_solution").fluid().color(0x280C26).build();

        GCYSMaterials.CleanEnrichedBedrockSolution = new Material.Builder(18043, "clean_enriched_bedrock_solution").fluid().color(0x828C8C).build();

        GCYSMaterials.HeavyEnrichedBedrockSmoke = new Material.Builder(18044, "heavy_enriched_bedrock_smoke").fluid(FluidTypes.GAS).color(0x1A2222).build();

        GCYSMaterials.MediumEnrichedBedrockSmoke = new Material.Builder(18045, "medium_enriched_bedrock_smoke").fluid(FluidTypes.GAS).color(0x1E2C2C).build();

        GCYSMaterials.LightEnrichedBedrockSmoke = new Material.Builder(18046, "light_enriched_bedrock_smoke").fluid(FluidTypes.GAS).color(0x163333).build();

        GCYSMaterials.HeavyEnrichedTaraniumGas = new Material.Builder(18047, "heavy_enriched_taranium_gas").fluid(FluidTypes.GAS).color(0x1F2626).build();

        GCYSMaterials.MediumEnrichedTaraniumGas = new Material.Builder(18048, "medium_enriched_taranium_gas").fluid(FluidTypes.GAS).color(0x1F3131).build();

        GCYSMaterials.LightEnrichedTaraniumGas = new Material.Builder(18049, "light_enriched_taranium_gas").fluid(FluidTypes.GAS).color(0x1F4040).build();

        GCYSMaterials.CrackedHeavyEnrichedTaranium = new Material.Builder(18050, "cracked_heavy_enriched_taranium").fluid().color(0x2E1F2E).build();

        GCYSMaterials.CrackedMediumEnrichedTaranium = new Material.Builder(18051, "cracked_medium_enriched_taranium").fluid().color(0x29393D).build();

        GCYSMaterials.CrackedLightEnrichedTaranium = new Material.Builder(18052, "cracked_light_enriched_taranium").fluid().color(0x374C52).build();

        GCYSMaterials.EnergeticNaquadria = new Material.Builder(18053, "energetic_naquadria").fluid().color(0x202020).build();

        GCYSMaterials.LightHyperFuel = new Material.Builder(18054, "light_hyper_fuel").fluid().color(0x8C148C).build();

        GCYSMaterials.MediumHyperFuel = new Material.Builder(18055, "medium_hyper_fuel").fluid().color(0xDC0A0A).build();

        GCYSMaterials.HeavyHyperFuel = new Material.Builder(18056, "heavy_hyper_fuel").fluid().color(0x1E5064).build();

        GCYSMaterials.QCDConfinedMatter = new Material.Builder(18057, "qcd_confined_matter")
                .ingot()
                .color(0xc82828)
                .flags(NO_UNIFICATION, GENERATE_PLATE, GENERATE_ROD)
                .build();

        GCYSMaterials.SentientMetal = new Material.Builder(18059, "sentient_metal")
                .fluid()
                .color(0x0c0c0c)
                .build();
    }
}
