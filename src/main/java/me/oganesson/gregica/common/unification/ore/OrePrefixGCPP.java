package me.oganesson.gregica.common.unification.ore;

import gregtech.common.items.MetaItems;

public class OrePrefixGCPP {
    public static void register() {
        MetaItems.addOrePrefix(GCOrePrefix.oreMilled);
    }
}