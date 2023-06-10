package gregica.common.block.laserpipe.net;

import gregica.api.capability.GCCapabilities;
import gregica.api.capability.quantum.IQubitContainer;
import gregica.common.block.laserpipe.tile.TileEntityLaserPipe;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

//Code By Htmlcsjs
public class LaserRoutePath {
    private final BlockPos destPipePos;
    private final EnumFacing destFacing;
    private final int distance;
    private final Set<TileEntityLaserPipe> path;

    public LaserRoutePath(BlockPos destPipePos, EnumFacing destFacing, Set<TileEntityLaserPipe> path, int distance) {
        this.destPipePos = destPipePos;
        this.destFacing = destFacing;
        this.path = path;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public Set<TileEntityLaserPipe> getPath() {
        return path;
    }

    public BlockPos getPipePos() {
        return destPipePos;
    }

    public EnumFacing getFaceToHandler() {
        return destFacing;
    }

    public BlockPos getHandlerPos() {
        return destPipePos.offset(destFacing);
    }

    public IQubitContainer getHandler(World world) {
        TileEntity tile = world.getTileEntity(getHandlerPos());
        if(tile != null) {
            return tile.getCapability(GCCapabilities.QBIT_CAPABILITY, destFacing.getOpposite());
        }
        return null;
    }
}
