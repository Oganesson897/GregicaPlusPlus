package me.oganesson.gregica.api.item;

import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public interface IExtendedItemBehavior {
    
    default EnumActionResult onLeftClickEmpty(World world, EntityPlayer player, ItemStack itemStack){
        return EnumActionResult.PASS;
    }
    
    default EnumActionResult onLeftClickBlock(World world, EntityPlayer player, ItemStack itemStack){
        return EnumActionResult.PASS;
    }
    
    default EnumActionResult onWheelChanged(boolean isUp, World world, EntityPlayer player, ItemStack itemStack){
        return EnumActionResult.PASS;
    }
    
    default boolean canLeftClickEmpty(){
        return false;
    }
    
    default boolean canLeftClickBlock(){
        return false;
    }
    
    default boolean canHandleWheelChange(){
        return false;
    }
    
    @Nullable
    public static IExtendedItemBehavior getFirstOnItemsStack(ItemStack stack){
        Item item = stack.getItem();
        if(item instanceof StandardMetaItem) {
            StandardMetaItem metaItem = (StandardMetaItem) item;
            for (IItemBehaviour behaviour : metaItem.getBehaviours(stack)) {
                if (behaviour instanceof IExtendedItemBehavior) {
                    return (IExtendedItemBehavior) behaviour;
                }
            }
        }
        return null;
    }
}
