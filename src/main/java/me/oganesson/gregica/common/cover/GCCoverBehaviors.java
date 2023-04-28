package me.oganesson.gregica.common.cover;

import gregtech.api.GTValues;
import gregtech.common.covers.CoverConveyor;
import gregtech.common.covers.CoverPump;
import gregtech.common.covers.CoverRoboticArm;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.covers.CoverBehaviors.registerBehavior;

public class GCCoverBehaviors {

    public static void init() {
        registerBehavior(new ResourceLocation(Gregica.MOD_ID, "conveyor.ulv"), GCMetaItems.ULV_CONVEYOR_MODULE, (tile, side) -> new CoverConveyor(tile, side, GTValues.ULV, 2));
        registerBehavior(new ResourceLocation(Gregica.MOD_ID, "pump.ulv"), GCMetaItems.ULV_ELECTRIC_PUMP, (tile, side) -> new CoverPump(tile, side, GTValues.ULV, 1280 / 4));
        registerBehavior(new ResourceLocation(Gregica.MOD_ID, "robotic_arm.ulv"), GCMetaItems.ULV_ROBOT_ARM, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.ULV, 2));

        registerBehavior(new ResourceLocation(Gregica.MOD_ID, "conveyor.max"), GCMetaItems.MAX_CONVEYOR_MODULE, (tile, side) -> new CoverConveyor(tile, side, GTValues.MAX, 16 * 64 * 2));
        registerBehavior(new ResourceLocation(Gregica.MOD_ID, "pump.max"), GCMetaItems.MAX_ELECTRIC_PUMP, (tile, side) -> new CoverPump(tile, side, GTValues.MAX, 1280 * 64 * 64 * 4 * 2));
        registerBehavior(new ResourceLocation(Gregica.MOD_ID, "robotic_arm.max"), GCMetaItems.MAX_ROBOT_ARM, (tile, side) -> new CoverRoboticArm(tile, side, GTValues.MAX, 16 * 64 * 2));
    }
}
