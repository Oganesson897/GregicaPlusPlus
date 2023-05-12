package me.oganesson.gregica.common.item.metaitems;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.common.items.behaviors.TooltipBehavior;
import me.oganesson.gregica.common.item.behavior.BaguetteBehavior;
import me.oganesson.gregica.common.item.behavior.IntBcircuitBehavior;
import me.oganesson.gregica.common.item.behavior.MillBallBehavior;
import me.oganesson.gregica.proxy.CommonProxy;
import net.minecraft.client.resources.I18n;

public class GCMetaItems {
    private static StandardMetaItem metaItem1;
    private static StandardMetaItem metaItem2;


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
    public static MetaItem<?>.MetaValueItem BIOLOGY_INTEGRATED_CIRCUIT;
    public static MetaItem<?>.MetaValueItem ADVANCED_INTEGRATED_CIRCUIT;

    public static MetaItem<?>.MetaValueItem ROUGH_BIOLOGY_RESIN;
    public static MetaItem<?>.MetaValueItem PURIFIED_ALUMINUM_MIXTURE;
    public static MetaItem<?>.MetaValueItem CELLULOSE_PULP;
    public static MetaItem<?>.MetaValueItem CELLULOSE_FIBER;
    public static MetaItem<?>.MetaValueItem CELLULOSE_FIBER_RED;
    public static MetaItem<?>.MetaValueItem CELLULOSE_FIBER_YELLOW;
    public static MetaItem<?>.MetaValueItem PINE_CONE;
    public static MetaItem<?>.MetaValueItem PINE_FRAGMENT;
    public static MetaItem<?>.MetaValueItem COMPOST;
    public static MetaItem<?>.MetaValueItem ALGAE_ACID;
    public static MetaItem<?>.MetaValueItem WOOD_PELLETS;
    public static MetaItem<?>.MetaValueItem PELLETS_MOULD;
    public static MetaItem<?>.MetaValueItem ALUMINUM_PELLETS;

    public static MetaItem<?>.MetaValueItem GRINDBALL_SOAPSTONE;
    public static MetaItem<?>.MetaValueItem GRINDBALL_ALUMINIUM;

    public static MetaItem<?>.MetaValueItem SODIUM_ETHYLATE;
    public static MetaItem<?>.MetaValueItem POTASSIUM_ETHYLATE;

    public static MetaItem<?>.MetaValueItem SODIUM_ETHYLXANTHATE;
    public static MetaItem<?>.MetaValueItem POTASSIUM_ETHYLXANTHATE;

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
        //biologist items
        BIOLOGY_INTEGRATED_CIRCUIT=metaItem1.addItem(39, "item.biology_integrated_circuit").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new IntBcircuitBehavior());
        ADVANCED_INTEGRATED_CIRCUIT=metaItem1.addItem(40, "item.advanced_integrated_circuit").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ROUGH_BIOLOGY_RESIN=metaItem1.addItem(41, "item.biology_resin").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        PURIFIED_ALUMINUM_MIXTURE=metaItem1.addItem(42, "item.aluminum_mixture").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        CELLULOSE_PULP=metaItem1.addItem(43, "item.cellulose_pulp").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        CELLULOSE_FIBER=metaItem1.addItem(44, "item.cellulose_fiber_green").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        CELLULOSE_FIBER_RED=metaItem1.addItem(45, "item.cellulose_fiber_red").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        CELLULOSE_FIBER_YELLOW=metaItem1.addItem(46, "item.cellulose_fiber_yellow").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        PINE_CONE=metaItem1.addItem(47, "item.pine_cone").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        PINE_FRAGMENT=metaItem1.addItem(48, "item.pine_fragment").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        COMPOST=metaItem1.addItem(49, "item.compost").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ALGAE_ACID=metaItem1.addItem(50, "item.algae_acid").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        WOOD_PELLETS=metaItem1.addItem(51, "item.wood_pellets").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        PELLETS_MOULD=metaItem1.addItem(52, "item.pellets_mould").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ALUMINUM_PELLETS=metaItem1.addItem(53, "item.aluminum_pellets").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);

        GRINDBALL_SOAPSTONE=metaItem1.addItem(54, "item.soapstone.ball").setMaxStackSize(1).setCreativeTabs(CommonProxy.Tab).addComponents(new MillBallBehavior());
        GRINDBALL_ALUMINIUM=metaItem1.addItem(55, "item.aluminium.ball").setMaxStackSize(1).setCreativeTabs(CommonProxy.Tab).addComponents(new MillBallBehavior());

        SODIUM_ETHYLATE=metaItem1.addItem(56, "item.sodium.ethylate").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        SODIUM_ETHYLXANTHATE=metaItem1.addItem(57, "item.sodium.ethylxanthate").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);

        POTASSIUM_ETHYLATE=metaItem1.addItem(58, "item.potassium.ethylate").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        POTASSIUM_ETHYLXANTHATE=metaItem1.addItem(59, "item.potassium.ethylxanthate").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);


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
