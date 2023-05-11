package me.oganesson.gregica.common.unification.materials.material;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialIconSet;
import me.oganesson.gregica.common.unification.GCElements;
import me.oganesson.gregica.common.unification.materials.GCMaterials;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static me.oganesson.gregica.common.unification.ore.GCMaterialFlags.GENERATE_MILLED;

public class SecondDegreeMaterials {

    public static void register() {
        GCMaterials.Tiberium = new Material.Builder(26101, "tiberium")
                .blastTemp(1800)
                .iconSet(MaterialIconSet.DIAMOND)
                .color(4651590)
                .element(GCElements.Tr)
                .build();

        GCMaterials.NeutronsFlow = new Material.Builder(26102, "neutrons_flow")
                .fluid(FluidTypes.PLASMA, false)
                .color(16448250)
                .build();

        GCMaterials.ProtonFlow = new Material.Builder(26103, "proton_flow")
                .fluid(FluidTypes.PLASMA, false)
                .color(16448250)
                .build();

        GCMaterials.BismuthLeadAlloy = new Material.Builder(26104, "bismuth_lead_alloy")
                .fluid().dust()
                .color(0x800080)
                .fluidTemp(5475)
                .components(new Object[]{Materials.Bismuth, 47, Materials.Lead, 25, Materials.Tin, 13, Materials.Cadmium, 10, Materials.Indium, 5})
                .build();

        GCMaterials.UreaMix = new Material.Builder(26105, "urea_mix")
                .fluid()
                .fluidTemp(200)
                .color(0x443610)
                .build();

        GCMaterials.FermentationBase = new Material.Builder(26106, "fermentation_base")
                .fluid()
                .fluidTemp(200)
                .color(0x5E5839)
                .build();

        GCMaterials.Resin = new Material.Builder(26107, "resin")
                .fluid()
                .fluidTemp(200)
                .color(0x353533)
                .build();

        GCMaterials.CalciumCarbonate = new Material.Builder(26108, "calcium_carbonate")
                .dust()
                .components(Materials.Calcium, 1, Materials.Carbon, 1, Materials.Oxygen, 3)
                .color(0xE8E8CB)
                .build();

        GCMaterials.PropionicAcid = new Material.Builder(26109, "propionic_acid")
                .fluid()
                .fluidTemp(200)
                .color(0xB3BC88)
                .build();

        GCMaterials.SodiumAluminate = new Material.Builder(26110, "sodium_aluminate")
                .dust()
                .colorAverage()
                .components(Sodium, 1, Aluminium, 1, Oxygen, 2)
                .build();


        GCMaterials.RedMud = new Material.Builder(26111, "red_mud")
                .fluid()
                .colorAverage()
                .flags(DISABLE_DECOMPOSITION)
                .components(Rutile, 1, HydrochloricAcid, 2)
                .build();


        GCMaterials.Butanol = new Material.Builder(26112, "butanol")
                .fluid()
                .color(0xC7AF2E)
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .build()
                .setFormula("C4H9OH", true);


        GCMaterials.Formaldehyde = new Material.Builder(26113, "formaldehyde")
                .fluid()
                .color(0x95A13A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .build();

        Materials.Potin.addFlags("generate_rotor", "generate_small_gear");
        Materials.Iridium.addFlags("generate_frame");
        Materials.Darmstadtium.addFlags("generate_frame");
        Materials.Cobalt.addFlags("generate_fine_wire");
        Materials.Lapis.addFlags("generate_bolt_screw");
        Almandine.addFlags(GENERATE_MILLED);
        Chalcopyrite.addFlags(GENERATE_MILLED);
        Grossular.addFlags(GENERATE_MILLED);
        Monazite.addFlags(GENERATE_MILLED);
        Nickel.addFlags(GENERATE_MILLED);
        Platinum.addFlags(GENERATE_MILLED);
        Pyrope.addFlags(GENERATE_MILLED);
        Redstone.addFlags(GENERATE_MILLED);
        Spessartine.addFlags(GENERATE_MILLED);
        Sphalerite.addFlags(GENERATE_MILLED);
    }
}
