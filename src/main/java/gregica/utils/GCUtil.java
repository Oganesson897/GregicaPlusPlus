package gregica.utils;

import gregica.Gregica;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import java.util.Arrays;
import java.util.BitSet;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static net.minecraft.util.EnumFacing.*;

public class GCUtil {
    
    public static int intValueOfBitSet(BitSet set){
        int result = 0;
        for(int i = 0; i<set.length();i++){
            result = result | (set.get(i)?1:0) << i;
        }
        return result;
    }
    
    public static BitSet forIntToBitSet(int i,int length){
        return forIntToBitSet(i,length,new BitSet(length));
    }
    
    public static BitSet forIntToBitSet(int i,int length,BitSet result){
        for(int j = 0;j<length;j++){
            if(((i & ( 0b1 << j)) / ( 0b1 << j)) == 1){
                result.set(j);
            }
            else {
                result.clear(j);
            }
        }
        return result;
    }
    
    public static <T> T getOrDefault(BooleanSupplier canGet, Supplier<T> getter, T defaultValue){
        return canGet.getAsBoolean() ? getter.get() : defaultValue;
    }
    
    public static EnumFacing getFacingFromNeighbor(BlockPos pos,BlockPos neighbor){
        BlockPos rel = neighbor.subtract(pos);
        if(rel.getX() == 1){
            return EAST;
        }
        if(rel.getX() == -1){
            return WEST;
        }
        if(rel.getY() == 1){
            return UP;
        }
        if(rel.getY() == -1){
            return DOWN;
        }
        if(rel.getZ() == 1){
            return SOUTH;
        }
        return NORTH;
    }
    
    public static EnumFacing getCounterClockWise(EnumFacing self) {
    
        return switch (self) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
            default -> throw new IllegalStateException("Unable to get CCW facing of " + self);
        };
    }
    
    public static EnumFacing getClockWise(EnumFacing self) {
    
        return switch (self) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
            default -> throw new IllegalStateException("Unable to get Y-rotated facing of " + self);
        };
    }
    
    public static int getOrDefault(NBTTagCompound tag, String key, int defaultValue){
        if(tag.hasKey(key)){
            return tag.getInteger(key);
        }
        return defaultValue;
    }
    
    public static boolean isOP(EntityPlayer entityPlayer){
        var name = entityPlayer.getName();
        if (Gregica.currentServer != null) {
            var list = Gregica.currentServer.getPlayerList().getOppedPlayerNames();
            return Arrays.asList(list).contains(name);
        }
        return false;
    }
  
}
