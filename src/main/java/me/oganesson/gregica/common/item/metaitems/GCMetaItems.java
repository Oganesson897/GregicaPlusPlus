package me.oganesson.gregica.common.item.metaitems;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.common.items.behaviors.TooltipBehavior;
import me.oganesson.gregica.common.item.behavior.BaguetteBehavior;
import me.oganesson.gregica.proxy.CommonProxy;
import net.minecraft.client.resources.I18n;

public class GCMetaItems {
    private static StandardMetaItem metaItem1;


    public static MetaItem<?>.MetaValueItem BAGUETTE_SWORD;
    public static MetaItem<?>.MetaValueItem COMMON_ALGAE;
    public static MetaItem<?>.MetaValueItem GREEN_ALGAE;
    public static MetaItem<?>.MetaValueItem RED_ALGAE;
    public static MetaItem<?>.MetaValueItem BROWN_ALGAE;
    public static MetaItem<?>.MetaValueItem GOLD_ALGAE;
    public static MetaItem<?>.MetaValueItem T_ALGAE;
    public static MetaItem<?>.MetaValueItem ULV_CONVEYOR_MODULE;
    public static MetaItem<?>.MetaValueItem ULV_ELECTRIC_PUMP;
    public static MetaItem<?>.MetaValueItem ULV_ELECTRIC_MOTOR;
    public static MetaItem<?>.MetaValueItem ULV_ELECTRIC_PISTON;
    public static MetaItem<?>.MetaValueItem ULV_ROBOT_ARM;
    public static MetaItem<?>.MetaValueItem ULV_EMITTER;
    public static MetaItem<?>.MetaValueItem ULV_SENSOR;
    public static MetaItem<?>.MetaValueItem ULV_FIELD_GENERATOR;
    public static MetaItem<?>.MetaValueItem MAX_CONVEYOR_MODULE;
    public static MetaItem<?>.MetaValueItem MAX_ELECTRIC_PUMP;
    public static MetaItem<?>.MetaValueItem MAX_ELECTRIC_MOTOR;
    public static MetaItem<?>.MetaValueItem MAX_ELECTRIC_PISTON;
    public static MetaItem<?>.MetaValueItem MAX_ROBOT_ARM;
    public static MetaItem<?>.MetaValueItem MAX_EMITTER;
    public static MetaItem<?>.MetaValueItem MAX_SENSOR;
    public static MetaItem<?>.MetaValueItem MAX_FIELD_GENERATOR;
    public static MetaItem<?>.MetaValueItem ADVANCED_PROCESS_CIRCUIT;
    public static void initMetaItems() {
        metaItem1 = new StandardMetaItem();
        metaItem1.setRegistryName("meta_item_gc");
    }

    public static void initSubitems() {
        initMetaItem1();
    }

    private static void initMetaItem1() {
        //meme 0~9
        BAGUETTE_SWORD = metaItem1.addItem(0, "tool.baguette").addComponents(new BaguetteBehavior()).setMaxStackSize(1).setCreativeTabs(CommonProxy.Tab);

        //materal 10 ~ 199
        //algae(10 ~ 21)
        COMMON_ALGAE = metaItem1.addItem(10,"algae.common").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        GREEN_ALGAE = metaItem1.addItem(11,"algae.green").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        RED_ALGAE = metaItem1.addItem(12,"algae.red").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        BROWN_ALGAE = metaItem1.addItem(13,"algae.brown").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        GOLD_ALGAE = metaItem1.addItem(14,"algae.gold").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        T_ALGAE = metaItem1.addItem(15,"algae.t").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        tierItems();
        ADVANCED_PROCESS_CIRCUIT = metaItem1.addItem(38, "item.advanced_circuit").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
    }

    private static void tierItems() {
        //ulv cover(22 ~ 29)
        ULV_CONVEYOR_MODULE = metaItem1.addItem(22, "cover.conveyor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 2));
        }));
        ULV_ELECTRIC_PUMP = metaItem1.addItem(23, "cover.pump.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.electric.pump.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 1280 / 80));
        }));
        ULV_ELECTRIC_MOTOR = metaItem1.addItem(24, "cover.motor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_ELECTRIC_PISTON = metaItem1.addItem(25, "cover.piston.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_ROBOT_ARM = metaItem1.addItem(26, "cover.robotic_arm.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.robot.arm.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 2));
        }));
        ULV_EMITTER = metaItem1.addItem(27, "cover.emitter.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_SENSOR = metaItem1.addItem(28, "cover.sensor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_FIELD_GENERATOR = metaItem1.addItem(29, "cover.field_generator.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);

        //max cover(30~37)
        MAX_CONVEYOR_MODULE = metaItem1.addItem(30, "cover.conveyor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 16 * 64 * 2));
        }));
        MAX_ELECTRIC_PUMP = metaItem1.addItem(31, "cover.pump.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.electric.pump.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 * 2 / 80));
        }));
        MAX_ELECTRIC_MOTOR = metaItem1.addItem(32, "cover.motor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_ELECTRIC_PISTON = metaItem1.addItem(33, "cover.piston.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_ROBOT_ARM = metaItem1.addItem(34, "cover.robotic_arm.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.robot.arm.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 16 * 64 * 2));
        }));
        MAX_EMITTER = metaItem1.addItem(35, "cover.emitter.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_SENSOR = metaItem1.addItem(36, "cover.sensor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_FIELD_GENERATOR = metaItem1.addItem(37, "cover.field_generator.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
    }
}
