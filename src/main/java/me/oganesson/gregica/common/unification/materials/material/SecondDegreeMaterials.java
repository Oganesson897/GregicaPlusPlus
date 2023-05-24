package me.oganesson.gregica.common.unification.materials.material;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.stack.MaterialStack;
import me.oganesson.gregica.common.unification.GCElements;
import me.oganesson.gregica.common.unification.materials.GCMaterials;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
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
                .fluid(FluidTypes.GAS, false)
                .color(16448250)
                .build();

        GCMaterials.ProtonFlow = new Material.Builder(26103, "proton_flow")
                .fluid(FluidTypes.GAS, false)
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

        GCMaterials.CarbenDisulfide  = new Material.Builder(26114, "carbon_disulfide")
                .fluid()
                .colorAverage()
                .components(Carbon, 1, Sulfur, 2)
                .build();

        GCMaterials.PineOil  = new Material.Builder(26115, "pine_oil")
                .fluid()
                .color(0xd6ac37)
                .build();

        GCMaterials.Periodicium = new Material.Builder(26116, "periodicium")
                .color(0x3D4BF6)
                .ingot(6)
                .iconSet(MaterialIconSet.SHINY)
                .blastTemp(13500)
                .fluidTemp(13500)
                .components(Hydrogen, Helium, Lithium, Beryllium, Boron, Carbon, Nitrogen, Oxygen, Fluorine, Neon, Sodium, Magnesium, Aluminium, Silicon, Phosphorus, Sulfur, Chlorine, Argon, Potassium, Calcium, Scandium, Titanium, Vanadium, Chrome, Manganese, Iron, Cobalt, Nickel, Copper, Zinc, Gallium, Germanium, Arsenic, Selenium, Bromine, Krypton, Rubidium, Strontium, Yttrium, Zirconium, Niobium, Molybdenum, Technetium, Ruthenium, Rhodium, Palladium, Silver, Cadmium, Indium, Tin, Antimony, Tellurium, Iodine, Xenon, Caesium, Barium, Lanthanum, Cerium, Praseodymium, Neodymium, Promethium, Samarium, Europium, Gadolinium, Terbium, Dysprosium, Holmium, Erbium, Thulium, Ytterbium, Lutetium, Hafnium, Tantalum, Tungsten, Rhenium, Osmium, Iridium, Platinum, Gold, Mercury, Thallium, Lead, Bismuth, Polonium, Astatine, Radon, Francium, Radium, Actinium, Thorium, Protactinium, Uranium235, Neptunium, Plutonium239, Americium, Curium, Berkelium, Californium, Einsteinium, Fermium, Mendelevium, Nobelium, Lawrencium, Rutherfordium, Dubnium, Seaborgium, Bohrium, Hassium, Meitnerium, Darmstadtium, Roentgenium, Copernicium, Nihonium, Flerovium, Moscovium, Livermorium, Tennessine, Oganesson)
                .build();

        GCMaterials.AlmandineFront  = new Material.Builder(26116, "almandine_front").fluid().color(0xD70505).build();
        GCMaterials.PentlanditeFront  = new Material.Builder(26117, "pentlandite_front").fluid().color(0x8c800a).build();
        GCMaterials.ChalcopyriteFront  = new Material.Builder(26118, "chalcopyrite_front").fluid().color(0x896826).build();
        GCMaterials.GrossularFront  = new Material.Builder(26119, "grossular_front").fluid().color(0xab5860).build();
        GCMaterials.MonaziteFront  = new Material.Builder(26120, "monazite_front").fluid().color(0x2e3f2e).build();
        GCMaterials.NickelFront  = new Material.Builder(26121, "nickel_front").fluid().color(0xABABD5).build();
        GCMaterials.PlatinumFront  = new Material.Builder(26122, "platinum_front").fluid().color(0xe2e2b2).build();
        GCMaterials.PyropeFront  = new Material.Builder(26123, "pyrope_front").fluid().color(0x682E57).build();
        GCMaterials.RedstoneFront  = new Material.Builder(26124, "redstone_front").fluid().color(0xAC0505).build();
        GCMaterials.SpessartineFront  = new Material.Builder(26125, "spessartine_front").fluid().color(0XDF5A5A).build();
        GCMaterials.SphaleriteFront  = new Material.Builder(26126, "sphalerite_front").fluid().color(0xD9D9D9).build();

        GCMaterials.Inconel625 = new Material.Builder(26127, "inconel_625")
                .fluid()
                .flags(GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_GEAR)
                .fluidTemp(3700)
                .color(0x3fcc60)
                .fluidPipeProperties(5500, 64000, true, true, true, true)
                .build();
        
        GCMaterials.MetallicHydrogen = new Material.Builder(26128, "metallic_hydrogen")
                .fluid()
                .flags(GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_GEAR)
                .fluidTemp(1)
                .color(0x4682B4)
                .components(Hydrogen)
                .build();
        
        GCMaterials.Ethylenimine = new Material.Builder(26129, "ethylenimine")
                .fluid()
                .color(0x483D8B)
                .components(Carbon, 2, Hydrogen, 5, Nitrogen)
                .build()
        
        GCMaterials.Polyethyleneimine = new Material.Builder(26130, "polyethylenimine")
                .fluid()
                .color(0x483D8B)
                .components(Carbon, 2, Hydrogen, 5, Nitrogen)
                .build()
        
        Materials.Potin.addFlags("generate_rotor", "generate_small_gear");
        Materials.Iridium.addFlags("generate_frame");
        Materials.Darmstadtium.addFlags("generate_frame");
        Materials.Cobalt.addFlags("generate_fine_wire");
        Materials.Lapis.addFlags("generate_bolt_screw");
        Materials.HSSE.addFlags(GENERATE_SMALL_GEAR);

        GCYMMaterials.Zeron100.addFlags("generate_rotor", "generate_bolt_screw");
        GCYMMaterials.IncoloyMA956.addFlags("generate_rotor");

        Almandine.addFlags(GENERATE_MILLED);
        Pentlandite.addFlags(GENERATE_MILLED);
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
