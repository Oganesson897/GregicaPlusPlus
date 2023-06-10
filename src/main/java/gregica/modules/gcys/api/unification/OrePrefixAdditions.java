package gregica.modules.gcys.api.unification;

import gregtech.common.items.MetaItems;
import gregica.modules.gcys.api.unification.ore.GCYSOrePrefix;

public class OrePrefixAdditions {
    public static void init(){
        MetaItems.addOrePrefix(GCYSOrePrefix.seedCrystal);
        MetaItems.addOrePrefix(GCYSOrePrefix.boule);
    }
}
