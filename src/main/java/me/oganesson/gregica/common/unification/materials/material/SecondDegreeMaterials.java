package me.oganesson.gregica.common.unification.materials.material;

import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.info.MaterialIconSet;
import me.oganesson.gregica.common.unification.GCElements;
import me.oganesson.gregica.common.unification.materials.GCMaterial;

public class SecondDegreeMaterials {

    public static void register() {
        GCMaterial.Tiberium = new Material.Builder(26101, "tiberium")
                .blastTemp(1800)
                .iconSet(MaterialIconSet.DIAMOND)
                .color(4651590)
                .element(GCElements.Tr)
                .build();

        GCMaterial.NeutronsFlow = new Material.Builder(26102, "neutrons_flow")
                .fluid(FluidTypes.PLASMA, false)
                .color(16448250)
                .build();

        GCMaterial.ProtonFlow = new Material.Builder(26103, "proton_flow")
                .fluid(FluidTypes.PLASMA, false)
                .color(16448250)
                .build();

        Materials.Potin.addFlags("generate_rotor", "generate_small_gear");
    }
}
