package project.gregica.network.packets;

import io.netty.buffer.ByteBuf;
import project.gregica.common.tileentities.te.TELaserPipe;
import project.gregica.network.GCPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UpdateConnectionsClient implements GCPacket {
    
    private final BlockPos pos;
    private final int connections;
    
    public UpdateConnectionsClient(ByteBuf byteBuf){
        int px = byteBuf.readInt();
        int py = byteBuf.readInt();
        int pz = byteBuf.readInt();
        this.pos = new BlockPos(px,py,pz);
        this.connections = byteBuf.readInt();
    }
    
    public UpdateConnectionsClient(BlockPos pos,int connections){
        this.pos = pos;
        this.connections = connections;
    }
    
    @Override
    public void writeData(ByteBuf out) {
        out.writeInt(pos.getX());
        out.writeInt(pos.getY());
        out.writeInt(pos.getZ());
        out.writeInt(connections);
    }
    
    @Override
    public void onClient(EntityPlayer player) {
        World world = player.getEntityWorld();
        TileEntity te = world.getTileEntity(pos);
        if(te instanceof TELaserPipe){
            ((TELaserPipe) te).setConnections(connections);
            ((TELaserPipe) te).updateRendering();
        }
    }
}
