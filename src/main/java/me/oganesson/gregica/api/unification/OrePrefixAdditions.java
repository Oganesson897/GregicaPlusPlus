package me.oganesson.gregica.api.unification;

import gregtech.common.items.MetaItems;
import me.oganesson.gregica.api.unification.ore.GCYSOrePrefix;

public class OrePrefixAdditions {
    public static void init(){
        MetaItems.addOrePrefix(GCYSOrePrefix.seedCrystal);
        MetaItems.addOrePrefix(GCYSOrePrefix.boule);
    }
}
