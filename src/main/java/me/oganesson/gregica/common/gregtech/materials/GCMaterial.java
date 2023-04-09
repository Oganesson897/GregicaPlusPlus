package me.oganesson.gregica.common.gregtech.materials;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

public class GCMaterial {

    //24000-25000
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

    public static void register() {
        Coolant = new Material.Builder(24000, "coolant")
                .fluid(FluidTypes.LIQUID)
                .color(0x0C618D).iconSet(MaterialIconSet.FLUID)
                .build();

        SuperCoolant = new Material.Builder(24001, "super_coolant")
                .fluid(FluidTypes.LIQUID)
                .color(0x025B6F).iconSet(MaterialIconSet.FLUID)
                .build();

        Cryotheum = new Material.Builder(24002, "cryotheum")
                .fluid(FluidTypes.LIQUID)
                .color(0x04F8DA).iconSet(MaterialIconSet.FLUID)
                .build();

        XPJuice = new Material.Builder(24003, "xpjuice")
                .fluid(FluidTypes.LIQUID)
                .color(0x51C031).iconSet(MaterialIconSet.FLUID)
                .build();

        Blood = new Material.Builder(24004, "lifeessence")
                .fluid(FluidTypes.LIQUID)
                .color(0xE61B1B).iconSet(MaterialIconSet.FLUID)
                .build();

        Spirit = new Material.Builder(24007, "fluidspirit")
                .fluid(FluidTypes.LIQUID)
                .color(0x701D36).iconSet(MaterialIconSet.FLUID)
                .build();

        Hollowtears = new Material.Builder(24008, "hollowtears")
                .fluid(FluidTypes.LIQUID)
                .color(0x25DBD5).iconSet(MaterialIconSet.FLUID)
                .build();

        AtomicSeparationCatalyst = new Material.Builder(24009, "atomic_separation_catalyst")
                .ingot().fluid()
                .color(0xE85E0C).iconSet(MaterialIconSet.SHINY)
                .blastTemp(5000, BlastProperty.GasTier.MID)
                .build();

    }

}
