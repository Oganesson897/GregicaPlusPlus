package me.oganesson.gregica.api.unification.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.ToolProperty;
import me.oganesson.gregica.api.unification.GCYSElements;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.METALLIC;
import static gregtech.api.unification.material.info.MaterialIconSet.SHINY;
import static me.oganesson.gregica.api.unification.materials.GCYSMaterials.*;

public class GCYSElementMaterials {

    /**
     * 3100-3499
     */
    public static void init() {
        Lithium6 = new Material.Builder(3100, "lithium_6")
                .ingot()
                .color(0xE6E1FF)
                .flags(GENERATE_PLATE, GENERATE_FOIL)
                .element(GCYSElements.Li6)
                .build();

        Lithium7 = new Material.Builder(3101, "lithium_7")
                .ingot()
                .color(0xE1DCFF).iconSet(METALLIC)
                .element(GCYSElements.Li7)
                .build();

        Beryllium7 = new Material.Builder(3102, "beryllium_7")
                .ingot().fluid()
                .color(0x6EBE6E)
                .element(GCYSElements.Be7)
                .build();

        Orichalcum = new Material.Builder(3103, "orichalcum")
                .ingot().fluid()
                .color(0x72A0C1).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .element(GCYSElements.Or)
                .toolStats(new ToolProperty(7.0F, 25.0F, 17000, 22))
                .blastTemp(9000, BlastProperty.GasTier.HIGH)
                .build();

        Vibranium = new Material.Builder(3104, "vibranium")
                .ingot().fluid().plasma()
                .color(0xC880FF).iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL)
                .element(GCYSElements.Vb)
                .blastTemp(4852, BlastProperty.GasTier.HIGH)
                .build();

        Adamantium = new Material.Builder(3105, "adamantium")
                .ingot().fluid().plasma()
                .color(0xFF0040).iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FRAME,
                        GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROUND)
                .element(GCYSElements.Ad)
                .blastTemp(5225, BlastProperty.GasTier.HIGH)
                .build();

        Taranium = new Material.Builder(3106, "taranium")
                .ingot().fluid()
                .color(0x4F404F).iconSet(METALLIC)
                .element(GCYSElements.Tn)
                .build();

        Hematite = (new Material.Builder(461, "hematite")).dust().ore().color(9525850).components(new Object[]{Materials.Iron, 2, Materials.Oxygen, 3}).build();
        Alumina = (new Material.Builder(383, "alumina")).dust().color(0x78c3eb).iconSet(MaterialIconSet.METALLIC).flags().components(Materials.Aluminium, 2, Materials.Oxygen, 3).build();
        BlueVitriol = (new Material.Builder(451, "blue_vitriol")).fluid().color(0x4242de).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Copper, 1, Materials.Sulfur, 1, Materials.Oxygen, 4).build();
        GreenVitriol = (new Material.Builder(452, "green_vitriol")).fluid().color(0x42de42).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Iron, 1, Materials.Sulfur, 1, Materials.Oxygen, 4).build();
        RedVitriol = (new Material.Builder(453, "red_vitriol")).fluid().color(0xde4242).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Cobalt, 1, Materials.Sulfur, 1, Materials.Oxygen, 4).build();
        PinkVitriol = (new Material.Builder(454, "pink_vitriol")).fluid().color(0xde6f6f).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Magnesium, 1, Materials.Sulfur, 1, Materials.Oxygen, 4).build();
        CyanVitriol = (new Material.Builder(455, "cyan_vitriol")).fluid().color(0x6fdede).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Nickel, 1, Materials.Sulfur, 1, Materials.Oxygen, 4).build();
        WhiteVitriol = (new Material.Builder(456, "white_vitriol")).fluid().color(0xdedede).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Zinc, 1, Materials.Sulfur, 1, Materials.Oxygen, 4).build();
        GrayVitriol = (new Material.Builder(457, "gray_vitriol")).fluid().color(0x6f6f6f).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Manganese, 1, Materials.Sulfur, 1, Materials.Oxygen, 4).build();
        ClayVitriol = (new Material.Builder(458, "clay_vitriol")).fluid().color(0x42dede).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Aluminium, 2, Materials.Sulfur, 3, Materials.Oxygen, 12).build().setFormula("Al2(SO4)3", true);
        ChloroauricAcid = (new Material.Builder(459, "chloroauric_acid")).fluid(FluidTypes.ACID).color(0xffc846).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Hydrogen, 1, Materials.Gold, 1, Materials.Chlorine, 4).build();
        ChloroplatinicAcid = (new Material.Builder(460, "chloroplatinic_acid")).fluid(FluidTypes.ACID).color(0xff4646).flags(MaterialFlags.DISABLE_DECOMPOSITION).components(Materials.Hydrogen, 2, Materials.Platinum, 1, Materials.Chlorine, 6).build();

    }
}
