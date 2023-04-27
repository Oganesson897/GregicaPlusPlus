package me.oganesson.gregica.common.unification.materials.material;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import me.oganesson.gregica.common.unification.GCElements;
import me.oganesson.gregica.common.unification.materials.GCMaterial;

public class SecondDegreeMaterials {

    public static void register() {
        GCMaterial.Tiberium = new Material.Builder(26101, "tiberium")
                .blastTemp(1800)
                .gem()
                .iconSet(MaterialIconSet.DIAMOND)
                .color(4651590)
                .element(GCElements.Tr)
                .build();
    }
}
