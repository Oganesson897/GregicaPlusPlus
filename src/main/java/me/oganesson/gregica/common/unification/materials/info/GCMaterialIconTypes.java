package me.oganesson.gregica.common.unification.materials.info;

import gregtech.api.unification.material.info.MaterialIconType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(
        modid = "gregtech",
        value = {Side.CLIENT}
)
public class GCMaterialIconTypes {
    public static final MaterialIconType orePoor = new MaterialIconType("orePoor");

    public static final MaterialIconType oreRich = new MaterialIconType("oreRich");

    public static final MaterialIconType nanoWireIcon = new MaterialIconType("nanowire");
    public static final MaterialIconType nanoFoilIcon = new MaterialIconType("nanofoil");

    private GCMaterialIconTypes() {/**/}
}
