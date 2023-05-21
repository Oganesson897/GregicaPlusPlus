package me.oganesson.gregica.network.packets;

import io.netty.buffer.ByteBuf;
import me.oganesson.gregica.api.item.IExtendedItemBehavior;
import me.oganesson.gregica.network.GCPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.io.IOException;

public class MouseEventToSeverPacker implements GCPacket {
    
    private final boolean isUp;
    
    public MouseEventToSeverPacker(ByteBuf byteBuf){
        this.isUp = byteBuf.readBoolean();
    }
    
    public MouseEventToSeverPacker(boolean b){
        this.isUp = b;
    }
    
    @Override
    public void onServer(EntityPlayer player) {
        World world = player.getEntityWorld();
        ItemStack itemStack = player.getHeldItem(EnumHand.MAIN_HAND);
        IExtendedItemBehavior behavior = IExtendedItemBehavior.getFirstOnItemsStack(itemStack);
        if(behavior != null){
            behavior.onWheelChanged(this.isUp,world,player,itemStack);
        }
    }
    
    @Override
    public void writeData(ByteBuf out) {
        out.writeBoolean(isUp);
    }
    
//    @Override
//    public void readData(ByteBuf in) throws IOException {
//
//    }
}
