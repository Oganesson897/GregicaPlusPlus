package project.gregica.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

public interface GCPacket {
    
    /**
     * 发包端写数据
     */
    void writeData(ByteBuf out) throws IOException;
    
//    /**
//     * 解包端读数据
//     */
//    void readData(ByteBuf in) throws IOException;
    
    //在服务端处理数据
    default void onServer(EntityPlayer player){
    
    }
    
    //在客户端处理数据
    @SideOnly(Side.CLIENT)
    default void onClient(EntityPlayer player){
    
    }
    
}