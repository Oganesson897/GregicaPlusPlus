package gregica.network.packets;

import gregica.common.data.CWDataType;
import gregica.common.data.CrossWorldDataHandler;
import gregica.network.GCPacket;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class CWDataUpdatePacket implements GCPacket {
    
    final int id;
    final String name;
    final ByteBuf data;
    
    public CWDataUpdatePacket(int id,String name, ByteBuf data) {
        this.id = id;
        this.data = data;
        this.name = name;
    }
    
    @SuppressWarnings("unused")
    public CWDataUpdatePacket(ByteBuf byteBuf){
        this.id = byteBuf.readInt();
        this.name = ByteBufUtils.readUTF8String(byteBuf);
        this.data = byteBuf;
    }
    
    
    @Override
    public void writeData(ByteBuf out) {
        out.writeInt(id);
        ByteBufUtils.writeUTF8String(out,name);
        out.writeBytes(data);
    }
    
    @Override
    public void onServer(EntityPlayer player) {
        updateData();
    }
    
    @Override
    public void onClient(EntityPlayer player) {
        updateData();
    }
    
    private void updateData(){
        CrossWorldDataHandler.INSTANCE.getOrCreate(CWDataType.formName(name)).updateData(id,data);
    }
}
