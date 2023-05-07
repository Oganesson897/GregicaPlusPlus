package me.oganesson.gregica.common.item.metaitems;

import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.common.items.behaviors.TooltipBehavior;
import me.oganesson.gregica.common.item.behavior.BaguetteBehavior;
import me.oganesson.gregica.proxy.CommonProxy;
import net.minecraft.client.resources.I18n;

import static me.oganesson.gregica.common.item.metaitems.GCMetaItems.*;

public class GCMetaItem1 extends StandardMetaItem {

    public GCMetaItem1() {super();}

    @Override
    public void registerSubItems() {
        BAGUETTE_SWORD = addItem(0, "tool.baguette").addComponents(new BaguetteBehavior()).setMaxStackSize(1).setCreativeTabs(CommonProxy.Tab);

        //material 10 ~ 199
        //algae(10 ~ 21)
        COMMON_ALGAE = addItem(10,"algae.common").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        GREEN_ALGAE = addItem(11,"algae.green").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        RED_ALGAE = addItem(12,"algae.red").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        BROWN_ALGAE = addItem(13,"algae.brown").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        GOLD_ALGAE = addItem(14,"algae.gold").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        T_ALGAE = addItem(15,"algae.t").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ADVANCED_PROCESS_CIRCUIT = addItem(38, "item.advanced_circuit").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);

        tierItems();
    }

    private void tierItems() {
        //ulv cover(22 ~ 29)
        ULV_CONVEYOR_MODULE = addItem(22, "cover.conveyor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 2));
        }));
        ULV_ELECTRIC_PUMP = addItem(23, "cover.pump.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.electric.pump.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 1280 / 80));
        }));
        ULV_ELECTRIC_MOTOR = addItem(24, "cover.motor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_ELECTRIC_PISTON = addItem(25, "cover.piston.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_ROBOT_ARM = addItem(26, "cover.robotic_arm.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.robot.arm.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 2));
        }));
        ULV_EMITTER = addItem(27, "cover.emitter.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_SENSOR = addItem(28, "cover.sensor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_FIELD_GENERATOR = addItem(29, "cover.field_generator.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);

        //max cover(30~37)
        MAX_CONVEYOR_MODULE = addItem(30, "cover.conveyor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 16 * 64 * 2));
        }));
        MAX_ELECTRIC_PUMP = addItem(31, "cover.pump.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.electric.pump.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 * 2 / 80));
        }));
        MAX_ELECTRIC_MOTOR = addItem(32, "cover.motor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_ELECTRIC_PISTON = addItem(33, "cover.piston.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_ROBOT_ARM = addItem(34, "cover.robotic_arm.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.robot.arm.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 16 * 64 * 2));
        }));
        MAX_EMITTER = addItem(35, "cover.emitter.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_SENSOR = addItem(36, "cover.sensor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_FIELD_GENERATOR = addItem(37, "cover.field_generator.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
    }

}
