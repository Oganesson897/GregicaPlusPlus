package me.oganesson.gregica.common.unification.materials.ore;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import me.oganesson.gregica.common.unification.materials.info.GCMaterialIconTypes;
import me.oganesson.gregica.common.unification.materials.info.GCMaterialFlags;

import java.util.function.Predicate;

import static gregtech.api.unification.ore.OrePrefix.Conditions.hasOreProperty;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GCOrePrefixs {
    public static final OrePrefix orePoor;
    public static final OrePrefix orePoorGranite;
    public static final OrePrefix orePoorDiorite;
    public static final OrePrefix orePoorAndesite;
    public static final OrePrefix orePoorBlackgranite;
    public static final OrePrefix orePoorRedgranite;
    public static final OrePrefix orePoorMarble;
    public static final OrePrefix orePoorBasalt;
    public static final OrePrefix orePoorSand;
    public static final OrePrefix orePoorRedSand;
    public static final OrePrefix orePoorNetherrack;
    public static final OrePrefix orePoorEndstone;

    public static final OrePrefix oreRich;
    public static final OrePrefix oreRichGranite;
    public static final OrePrefix oreRichDiorite;
    public static final OrePrefix oreRichAndesite;
    public static final OrePrefix oreRichBlackgranite;
    public static final OrePrefix oreRichRedgranite;
    public static final OrePrefix oreRichMarble;
    public static final OrePrefix oreRichBasalt;
    public static final OrePrefix oreRichSand;
    public static final OrePrefix oreRichRedSand;
    public static final OrePrefix oreRichNetherrack;
    public static final OrePrefix oreRichEndstone;

    public static final OrePrefix oreMilled;

    public static void register() {
        MetaItems.addOrePrefix(oreMilled);
    }


    static {
        orePoor = new OrePrefix("orePoor", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);
        orePoorGranite = new OrePrefix("orePoorGranite", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);
        orePoorDiorite = new OrePrefix("orePoorDiorite", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);
        orePoorAndesite = new OrePrefix("orePoorAndesite", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);
        orePoorBlackgranite = new OrePrefix("orePoorBlackgranite", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);
        orePoorRedgranite = new OrePrefix("orePoorRedgranite", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);
        orePoorMarble = new OrePrefix("orePoorMarble", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);
        orePoorBasalt = new OrePrefix("orePoorBasalt", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);
        orePoorSand = new OrePrefix("orePoorSand", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, (Predicate)null);
        orePoorRedSand = new OrePrefix("orePoorRedSand", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, (Predicate)null);
        orePoorNetherrack = new OrePrefix("orePoorNetherrack", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);
        orePoorEndstone = new OrePrefix("orePoorEndstone", -1L, (Material)null, GCMaterialIconTypes.orePoor, 1L, OrePrefix.Conditions.hasOreProperty);

        oreRich = new OrePrefix("oreRich", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreRichGranite = new OrePrefix("oreRichGranite", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreRichDiorite = new OrePrefix("oreRichDiorite", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreRichAndesite = new OrePrefix("oreRichAndesite", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreRichBlackgranite = new OrePrefix("oreRichBlackgranite", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreRichRedgranite = new OrePrefix("oreRichRedgranite", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreRichMarble = new OrePrefix("oreRichMarble", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreRichBasalt = new OrePrefix("oreRichBasalt", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreRichSand = new OrePrefix("oreRichSand", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, (Predicate)null);
        oreRichRedSand = new OrePrefix("oreRichRedSand", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, (Predicate)null);
        oreRichNetherrack = new OrePrefix("oreRichNetherrack", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreRichEndstone = new OrePrefix("oreRichEndstone", -1L, (Material)null, GCMaterialIconTypes.oreRich, 1L, OrePrefix.Conditions.hasOreProperty);
        oreMilled = new OrePrefix("milled", -1, null, GCMaterialIconTypes.milled, ENABLE_UNIFICATION, hasOreProperty.and(mat -> mat.hasFlag(GCMaterialFlags.GENERATE_MILLED)));
    }
}
