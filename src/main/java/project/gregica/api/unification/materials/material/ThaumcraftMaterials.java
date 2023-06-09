package project.gregica.api.unification.materials.material;

import gregtech.api.unification.Elements;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import project.gregica.api.unification.GCElements;
import project.gregica.api.unification.materials.GCMaterials;

import static gregtech.api.unification.material.info.MaterialFlags.GENERATE_PLATE;

public class ThaumcraftMaterials {


public static void TCMaterials() {
    GCMaterials.Thaumium = new Material.Builder(8000, "thaumium")
            .ingot(3)
            .iconSet(MaterialIconSet.SHINY)
            .flags(GENERATE_PLATE)
            .color(0x473B6D)
            .element(Elements.Ma)
            .build();

    GCMaterials.VoidMetal = new Material.Builder(8001, "void")
            .ingot(3)
            .iconSet(MaterialIconSet.SHINY)
            .flags(GENERATE_PLATE)
            .color(0x2A1248)
            .element(GCElements.Void)
            .build();
}
}
