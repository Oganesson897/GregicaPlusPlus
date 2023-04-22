package me.oganesson.gregica.common.item.metaitems;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import me.oganesson.gregica.common.behavior.BaguetteBehavior;

public class GCMetaItems {
    private static StandardMetaItem metaItem1;

    public static MetaItem<?>.MetaValueItem BAGUETTE_SWORD;

    public static void initMetaItems() {
        metaItem1 = new StandardMetaItem();
        metaItem1.setRegistryName("meta_item_1");
    }

    public static void initSubitems() {
        initMetaItem1();
    }

    private static void initMetaItem1() {
        BAGUETTE_SWORD = metaItem1.addItem(0, "tool.baguette").addComponents(new BaguetteBehavior()).setMaxStackSize(1);
    }
}
