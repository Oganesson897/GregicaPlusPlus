package me.oganesson.gregica.common.item.metaitems;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import me.oganesson.gregica.common.item.behavior.BaguetteBehavior;
import me.oganesson.gregica.proxy.CommonProxy;

public class GCMetaItems {
    private static StandardMetaItem metaItem1;
    private static StandardMetaItem algae;


    public static MetaItem<?>.MetaValueItem BAGUETTE_SWORD;
    public static MetaItem<?>.MetaValueItem COMMON_ALGAE;
    public static MetaItem<?>.MetaValueItem GREEN_ALGAE;
    public static MetaItem<?>.MetaValueItem RED_ALGAE;
    public static MetaItem<?>.MetaValueItem BROWN_ALGAE;
    public static MetaItem<?>.MetaValueItem GOLD_ALGAE;
    public static MetaItem<?>.MetaValueItem T_ALGAE;

    public static void initMetaItems() {
        metaItem1 = new StandardMetaItem();
        metaItem1.setRegistryName("meta_item_1");
        algae = onItemsHandler("algae_blue");
    }

    public static void initSubitems() {
        initMetaItem1();
    }

    private static void initMetaItem1() {
        BAGUETTE_SWORD = metaItem1.addItem(0, "tool.baguette").addComponents(new BaguetteBehavior()).setMaxStackSize(1).setCreativeTabs(CommonProxy.Tab);
        COMMON_ALGAE = algae.addItem(0,"algae.common").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        GREEN_ALGAE = algae.addItem(1,"algae.green").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        RED_ALGAE = algae.addItem(2,"algae.red").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        BROWN_ALGAE = algae.addItem(3,"algae.brown").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        GOLD_ALGAE = algae.addItem(4,"algae.gold").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        T_ALGAE = algae.addItem(5,"algae.t").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
    }
    private static StandardMetaItem onItemsHandler(String name)
    {
        StandardMetaItem item = new StandardMetaItem();
        item.setRegistryName(name);
        return  item;
    }
}
