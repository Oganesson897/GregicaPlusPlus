package project.gregica.module.gcys.api.unification;

import gregtech.common.items.MetaItems;
import project.gregica.module.gcys.api.unification.ore.GCYSOrePrefix;

public class OrePrefixAdditions {
    public static void init(){
        MetaItems.addOrePrefix(GCYSOrePrefix.seedCrystal);
        MetaItems.addOrePrefix(GCYSOrePrefix.boule);
    }
}
