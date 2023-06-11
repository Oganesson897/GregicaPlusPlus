package gregica.modules.gcys.api.unification.materials;

import gregica.modules.gcys.api.unification.materials.info.GCYSMaterialFlags;
import gregica.config.GCConfigValue;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GCYSMaterialFlagAddition {

    public static void init() {

        // Formula Changes
        PalladiumRaw.setFormula("PdCl2", true);
        RarestMetalMixture.setFormula("IrOs?", true);
        IridiumMetalResidue.setFormula("Ir2O3", true);

        // Disable Decomposition
        if (GCConfigValue.disableNiobiumTantalumProcessing) {
            Pyrochlore.addFlags(DISABLE_DECOMPOSITION);
            Tantalite.addFlags(DISABLE_DECOMPOSITION);
        }
        if (GCConfigValue.disableMolybdenumProcessing) {
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
        Monazite.addFlags(GCYSMaterialFlags.DISABLE_CRYSTALLIZATION);

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

        OreProperty oreProp;

        oreProp = Materials.Copper.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Cobalt, Materials.Gold, Materials.Nickel, Materials.Gold);
        oreProp.setWashedIn(GCYSMaterials.BlueVitriol);
        oreProp = Materials.Chalcocite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Sulfur, Materials.Lead, Materials.Silver);
        oreProp.setDirectSmeltResult(Materials.Copper);
        oreProp.setWashedIn(GCYSMaterials.BlueVitriol);
        oreProp = Materials.Bastnasite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Neodymium, Materials.RareEarth);
        oreProp = Materials.Pentlandite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Iron, Materials.Sulfur, Materials.Cobalt);
        oreProp.setDirectSmeltResult(Materials.Nickel);
        oreProp.setWashedIn(GCYSMaterials.CyanVitriol);
        oreProp = Materials.Spodumene.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Aluminium, Materials.Lithium);
        oreProp = Materials.Lepidolite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Lithium, Materials.Caesium, Materials.Boron);
        oreProp = Materials.GlauconiteSand.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Sodium, Materials.Aluminium, Materials.Iron);
        oreProp = Materials.Malachite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Copper, Materials.BrownLimonite, Materials.Calcite);
        oreProp.setDirectSmeltResult(Materials.Copper);
        oreProp.setWashedIn(GCYSMaterials.BlueVitriol);
        oreProp = Materials.Olivine.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Pyrope, Materials.Magnesium, Materials.Manganese);
        oreProp.setWashedIn(GCYSMaterials.PinkVitriol);
        oreProp = Materials.Opal.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Opal);
        oreProp = Materials.Amethyst.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Amethyst);
        oreProp = Materials.Lapis.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Lazurite, Materials.Sodalite, Materials.Pyrite);
        oreProp = Materials.Apatite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.TricalciumPhosphate, Materials.Phosphate, Materials.Pyrochlore);
        oreProp = Materials.TricalciumPhosphate.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Apatite, Materials.Phosphate, Materials.Pyrochlore);
        oreProp = Materials.GarnetRed.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Spessartine, Materials.Pyrope, Materials.Almandine);
        oreProp = Materials.GarnetYellow.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Andradite, Materials.Grossular, Materials.Uvarovite);
        oreProp = Materials.VanadiumMagnetite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Magnetite, Materials.Magnetite, Materials.Vanadium);
        oreProp.setWashedIn(GCYSMaterials.GreenVitriol);
        oreProp = Materials.Pollucite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Caesium, Materials.Aluminium, Materials.Potassium);
        oreProp = Materials.Bentonite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Aluminium, Materials.Calcium, Materials.Magnesium);
        oreProp = Materials.FullersEarth.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Aluminium, Materials.Silicon, Materials.Magnesium);
        oreProp = Materials.Pitchblende.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Thorium, Materials.Uraninite, Materials.Lead);
        oreProp = Materials.Monazite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Thorium, Materials.Neodymium, Materials.RareEarth);
        oreProp = Materials.Redstone.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Cinnabar, Materials.RareEarth, Materials.Glowstone);
        oreProp = Materials.Diatomite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GCYSMaterials.Hematite, Materials.Sapphire);
        oreProp = Materials.GraniticMineralSand.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.GraniteBlack, Materials.Magnetite);
        oreProp.setDirectSmeltResult(Materials.Iron);
        oreProp = Materials.GarnetSand.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.GarnetRed, Materials.GarnetYellow);
        oreProp = Materials.BasalticMineralSand.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Basalt, Materials.Magnetite);
        oreProp.setDirectSmeltResult(Materials.Iron);
        oreProp = GCYSMaterials.Hematite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Magnetite, Materials.Calcium, Materials.Magnesium);
        oreProp.setDirectSmeltResult(Materials.Iron);
        oreProp.setWashedIn(GCYSMaterials.GreenVitriol);
        oreProp = Materials.Wulfenite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Iron, Materials.Manganese, Materials.Manganese, Materials.Lead);
        oreProp = Materials.Soapstone.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.SiliconDioxide, Materials.Magnesium, Materials.Calcite, Materials.Talc);
        oreProp.setWashedIn(GCYSMaterials.PinkVitriol);
        oreProp = Materials.Kyanite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Talc, Materials.Aluminium, Materials.Silicon);
        oreProp.setWashedIn(GCYSMaterials.PinkVitriol);
        oreProp = Materials.Gypsum.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Sulfur, Materials.Calcium, Materials.Salt);
        oreProp = Materials.Talc.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Clay, Materials.Carbon, Materials.Clay);
        oreProp.setWashedIn(GCYSMaterials.PinkVitriol);
        oreProp = Materials.Powellite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Iron, Materials.Potassium, Materials.Molybdenite);
        oreProp = Materials.Trona.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Sodium, Materials.SodaAsh, Materials.SodaAsh);
        oreProp = Materials.Mica.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Potassium, Materials.Aluminium);
        oreProp = Materials.Zeolite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Calcium, Materials.Silicon, Materials.Aluminium);
        oreProp = Materials.Electrotine.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Copper);
        oreProp.setWashedIn(GCYSMaterials.BlueVitriol);
        oreProp = Materials.Pyrochlore.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(Materials.Apatite, Materials.Calcium, Materials.Niobium);
    }
}
