package me.oganesson.gregica.common.unification.materials.material;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialIconSet;
import me.oganesson.gregica.common.unification.GCElements;
import me.oganesson.gregica.common.unification.materials.GCMaterials;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static me.oganesson.gregica.common.unification.materials.info.GCMaterialFlags.GENERATE_MILLED;

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
                .components(Hydrogen,1, Helium,1, Lithium,1, Beryllium,1,
                        Boron,1, Carbon,1, Nitrogen,1, Oxygen,1,
                        Fluorine,1, Neon,1, Sodium,1, Magnesium,1,
                        Aluminium,1, Silicon,1, Phosphorus,1, Sulfur,1,
                        Chlorine,1, Argon,1, Potassium,1, Calcium,1,
                        Scandium,1, Titanium,1, Vanadium,1, Chrome,1,
                        Manganese,1, Iron,1, Cobalt,1, Nickel,1,
                        Copper,1, Zinc,1, Gallium,1, Germanium,1,
                        Arsenic,1, Selenium,1, Bromine,1, Krypton,1,
                        Rubidium,1, Strontium,1, Yttrium,1, Zirconium,1,
                        Niobium,1, Molybdenum,1, Technetium,1, Ruthenium,1,
                        Rhodium,1, Palladium,1, Silver,1, Cadmium,1,
                        Indium,1, Tin,1, Antimony,1, Tellurium,1,
                        Iodine,1, Xenon,1, Caesium,1, Barium,1,
                        Lanthanum,1, Cerium,1, Praseodymium,1, Neodymium,1,
                        Promethium,1, Samarium,1, Europium,1, Gadolinium,1,
                        Terbium,1, Dysprosium,1, Holmium,1, Erbium,1,
                        Thulium,1, Ytterbium,1, Lutetium,1, Hafnium,1,
                        Tantalum,1, Tungsten,1, Rhenium,1, Osmium,1,
                        Iridium,1, Platinum,1, Gold,1, Mercury,1,
                        Thallium,1, Lead,1, Bismuth,1, Polonium,1,
                        Astatine,1, Radon,1, Francium,1, Radium,1,
                        Actinium,1, Thorium,1, Protactinium,1, Uranium235,1,
                        Neptunium,1, Plutonium239,1, Americium,1, Curium,1,
                        Berkelium,1, Californium,1, Einsteinium,1, Fermium,1,
                        Mendelevium,1, Nobelium,1, Lawrencium,1, Rutherfordium,1,
                        Dubnium,1, Seaborgium,1, Bohrium,1, Hassium,1,
                        Meitnerium,1, Darmstadtium,1, Roentgenium,1, Copernicium,1,
                        Nihonium,1, Flerovium,1, Moscovium,1, Livermorium, 1,Tennessine,1,
                        Oganesson,1)
                .build();

        GCMaterials.AlmandineFront  = new Material.Builder(26117, "almandine_front").fluid().color(0xD70505).build();
        GCMaterials.PentlanditeFront  = new Material.Builder(26118, "pentlandite_front").fluid().color(0x8c800a).build();
        GCMaterials.ChalcopyriteFront  = new Material.Builder(26119, "chalcopyrite_front").fluid().color(0x896826).build();
        GCMaterials.GrossularFront  = new Material.Builder(26120, "grossular_front").fluid().color(0xab5860).build();
        GCMaterials.MonaziteFront  = new Material.Builder(26121, "monazite_front").fluid().color(0x2e3f2e).build();
        GCMaterials.NickelFront  = new Material.Builder(26122, "nickel_front").fluid().color(0xABABD5).build();
        GCMaterials.PlatinumFront  = new Material.Builder(26123, "platinum_front").fluid().color(0xe2e2b2).build();
        GCMaterials.PyropeFront  = new Material.Builder(26124, "pyrope_front").fluid().color(0x682E57).build();
        GCMaterials.RedstoneFront  = new Material.Builder(26125, "redstone_front").fluid().color(0xAC0505).build();
        GCMaterials.SpessartineFront  = new Material.Builder(26126, "spessartine_front").fluid().color(0XDF5A5A).build();
        GCMaterials.SphaleriteFront  = new Material.Builder(26127, "sphalerite_front").fluid().color(0xD9D9D9).build();

        GCMaterials.Inconel625 = new Material.Builder(26128, "inconel_625")
                .fluid()
                .flags(GENERATE_RING, GENERATE_BOLT_SCREW, GENERATE_GEAR)
                .fluidTemp(3700)
                .color(0x3fcc60)
                .fluidPipeProperties(5500, 64000, true, true, true, true)
                .build();
        
        GCMaterials.MetallicHydrogen = new Material.Builder(26129, "metallic_hydrogen")
                .ingot().fluid()
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, GENERATE_RING, GENERATE_ROUND, GENERATE_ROTOR, GENERATE_BOLT_SCREW, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_LONG_ROD, GENERATE_FRAME)
                .fluidTemp(1)
                .color(0x4682B4)
                .fluidPipeProperties(10240, 32000, true, true, true, true)
                .components(Hydrogen, 1)
                .build();
        
        GCMaterials.Ethylenimine = new Material.Builder(26130, "ethylenimine")
                .fluid()
                .color(0x483D8B)
                .components(Carbon, 2, Hydrogen, 5, Nitrogen, 1)
                .build();
        
        GCMaterials.Polyethyleneimine = new Material.Builder(26131, "polyethylenimine")
                .fluid()
                .color(0x483DB4)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 2, Hydrogen, 5, Nitrogen, 1)
                .build();
        
        Materials.Potin.addFlags("generate_rotor", "generate_small_gear");
        Materials.Iridium.addFlags("generate_frame");
        Materials.Darmstadtium.addFlags("generate_frame");
        Materials.Cobalt.addFlags("generate_fine_wire");
        Materials.Lapis.addFlags("generate_bolt_screw");
        Materials.HSSE.addFlags(GENERATE_SMALL_GEAR);
        Materials.Neutronium.addFlags(GENERATE_SMALL_GEAR, GENERATE_ROUND, GENERATE_RING, GENERATE_ROTOR);

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
