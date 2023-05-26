package me.oganesson.gregica.common.unification.materials.info;

import gregtech.api.unification.material.info.MaterialIconType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(
        modid = "gregtech",
        value = {Side.CLIENT}
)
public class GCMaterialIconTypes {
    public static final MaterialIconType orePoor = new MaterialIconType("ore_poor");

    public static final MaterialIconType oreRich = new MaterialIconType("ore_rich");

    public static final MaterialIconType nanoWireIcon = new MaterialIconType("nanowire");
    public static final MaterialIconType nanoFoilIcon = new MaterialIconType("nanofoil");

    public static final MaterialIconType milled = new MaterialIconType("milled");

    private GCMaterialIconTypes() {/**/}
}
