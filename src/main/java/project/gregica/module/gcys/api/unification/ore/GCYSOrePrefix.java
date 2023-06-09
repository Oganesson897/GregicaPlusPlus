package project.gregica.module.gcys.api.unification.ore;

import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.ore.OrePrefix;
import project.gregica.module.gcys.api.unification.materials.info.GCYSMaterialFlags;
import project.gregica.module.gcys.api.unification.materials.info.GCYSMaterialIconType;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Conditions.hasGemProperty;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GCYSOrePrefix {

    public static final OrePrefix seedCrystal = new OrePrefix("seedCrystal", M / 9, null, GCYSMaterialIconType.seedCrystal, ENABLE_UNIFICATION, hasGemProperty.and(mat -> mat.hasFlag(GCYSMaterialFlags.GENERATE_BOULE) || (mat.hasFlag(MaterialFlags.CRYSTALLIZABLE) && !mat.hasFlag(GCYSMaterialFlags.DISABLE_CRYSTALLIZATION))));
    public static final OrePrefix boule = new OrePrefix("boule", M * 4, null, GCYSMaterialIconType.boule, ENABLE_UNIFICATION, hasGemProperty.and(mat -> mat.hasFlag(GCYSMaterialFlags.GENERATE_BOULE) || (mat.hasFlag(MaterialFlags.CRYSTALLIZABLE) && !mat.hasFlag(GCYSMaterialFlags.DISABLE_CRYSTALLIZATION))));
}
