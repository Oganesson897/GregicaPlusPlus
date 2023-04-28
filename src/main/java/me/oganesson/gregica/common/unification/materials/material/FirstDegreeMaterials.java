package me.oganesson.gregica.common.unification.materials.material;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;
import me.oganesson.gregica.common.unification.materials.GCMaterial;

public class FirstDegreeMaterials {

    public static void register() {
        GCMaterial.Coolant = new Material.Builder(26000, "coolant")
                .fluid(FluidTypes.LIQUID)
                .color(0x0C618D).iconSet(MaterialIconSet.FLUID)
                .build();

        GCMaterial.SuperCoolant = new Material.Builder(26001, "super_coolant")
                .fluid(FluidTypes.LIQUID)
                .color(0x025B6F).iconSet(MaterialIconSet.FLUID)
                .build();

        GCMaterial.Cryotheum = new Material.Builder(26002, "cryotheum")
                .fluid(FluidTypes.LIQUID)
                .color(0x04F8DA).iconSet(MaterialIconSet.FLUID)
                .build();

        GCMaterial.XPJuice = new Material.Builder(26003, "xpjuice")
                .fluid(FluidTypes.LIQUID)
                .color(0x51C031).iconSet(MaterialIconSet.FLUID)
                .build();

        GCMaterial.Blood = new Material.Builder(26004, "lifeessence")
                .fluid(FluidTypes.LIQUID)
                .color(0xE61B1B).iconSet(MaterialIconSet.FLUID)
                .build();

        GCMaterial.Spirit = new Material.Builder(26007, "fluidspirit")
                .fluid(FluidTypes.LIQUID)
                .color(0x701D36).iconSet(MaterialIconSet.FLUID)
                .build();

        GCMaterial.Hollowtears = new Material.Builder(26008, "hollowtears")
                .fluid(FluidTypes.LIQUID)
                .color(0x25DBD5).iconSet(MaterialIconSet.FLUID)
                .build();

        GCMaterial.AtomicSeparationCatalyst = new Material.Builder(26009, "atomic_separation_catalyst")
                .ingot().fluid()
                .color(0xE85E0C).iconSet(MaterialIconSet.SHINY)
                .blastTemp(5000, BlastProperty.GasTier.MID)
                .build();
    }
}