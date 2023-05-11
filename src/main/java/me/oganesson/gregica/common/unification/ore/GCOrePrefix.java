package me.oganesson.gregica.common.unification.ore;

import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.unification.ore.OrePrefix.Conditions.hasOreProperty;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GCOrePrefix {

    public static final OrePrefix oreMilled = new OrePrefix("milled", -1, null, GCMaterialIconType.milled, ENABLE_UNIFICATION, hasOreProperty.and(mat -> mat.hasFlag(GCMaterialFlags.GENERATE_MILLED)));
}
