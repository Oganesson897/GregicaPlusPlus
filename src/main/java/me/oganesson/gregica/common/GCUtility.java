package me.oganesson.gregica.common;

import net.minecraft.util.EnumFacing;

import static net.minecraft.util.EnumFacing.*;

public class GCUtility {
    public static int clamp(int value, int min, int max) {
        if (value < min)
            return min;
        return Math.min(value, max);
    }
    
    public static EnumFacing getCounterClockWise(EnumFacing self) {
        EnumFacing direction;
        switch(self) {
            case NORTH:
                direction = WEST;
                break;
            case SOUTH:
                direction = EAST;
                break;
            case WEST:
                direction = SOUTH;
                break;
            case EAST:
                direction = NORTH;
                break;
            default:
                throw new IllegalStateException("Unable to get CCW facing of " + self);
        }
        
        return direction;
    }
    
    public static EnumFacing getClockWise(EnumFacing self) {
        EnumFacing direction;
        switch(self) {
            case NORTH:
                direction = EAST;
                break;
            case SOUTH:
                direction = WEST;
                break;
            case WEST:
                direction = NORTH;
                break;
            case EAST:
                direction = SOUTH;
                break;
            default:
                throw new IllegalStateException("Unable to get Y-rotated facing of " + self);
        }
        
        return direction;
    }
}
