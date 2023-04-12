package me.oganesson.gregica.common.gregtech.block.laserpipe.net;

import gregtech.api.util.GTLog;
import gregtech.api.util.GTUtility;
import me.oganesson.gregica.api.quantum.IQubitContainer;
import me.oganesson.gregica.common.gregtech.block.laserpipe.tile.TileEntityLaserPipe;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.List;
import java.util.Objects;

//Code By Htmlcsjs, From htmltech at https://github.com/htmlcsjs/htmlTech, under the LGPLv3 License.
public class PipeLaserContainer implements IQubitContainer {

    private final LaserPipeNet net;
    private final TileEntityLaserPipe cable;
    private final EnumFacing facing;

    public PipeLaserContainer(LaserPipeNet net, TileEntityLaserPipe cable, EnumFacing facing) {
        this.net = Objects.requireNonNull(net);
        this.cable = Objects.requireNonNull(cable);
        this.facing = facing;
    }

    public long getInputPerSec() {
        return net.getEnergyFluxPerSec();
    }

    public long getOutputPerSec() {
        return net.getEnergyFluxPerSec();
    }

    @Override
    public long acceptQubitFromNetwork(EnumFacing side, long voltage, long amperage) {
        if (side == null) {
            if (facing == null) return 0;
            side = facing;
        }

        long amperesUsed = 0L;
        List<LaserRoutePath> paths = net.getNetData(cable.getPos());
        for (LaserRoutePath path : paths) {
            if (GTUtility.arePosEqual(cable.getPos(), path.getPipePos()) && side == path.getFaceToHandler()) {
                //Do not insert into source handler
                continue;
            }
            IQubitContainer dest = path.getHandler(cable.getWorld());
            EnumFacing facing = path.getFaceToHandler().getOpposite();
            if (dest == null || !dest.inputsQubit(facing) || dest.getQubitCanBeInserted() <= 0) continue;
            long amps = 0;
            if (voltage > 0) {
                amps = dest.acceptQubitFromNetwork(facing, voltage, amperage - amperesUsed);
            }
            amperesUsed += amps;
            for (TileEntityLaserPipe cable : path.getPath()) {
                cable.incrementAmperage(amps, voltage);
            }

            if (amperage == amperesUsed)
                break;
        }
        net.addEnergyFluxPerSec(amperesUsed * voltage);
        return amperesUsed;
    }

    private void burnCable(World world, BlockPos pos) {
        world.setBlockState(pos, Blocks.FIRE.getDefaultState());
        if (!world.isRemote) {
            ((WorldServer) world).spawnParticle(EnumParticleTypes.SMOKE_LARGE,
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    5 + world.rand.nextInt(3), 0.0, 0.0, 0.0, 0.1);
        }
    }

    @Override
    public long getInputParallel() {
        return Short.MAX_VALUE;
    }

    @Override
    public long getInputQubit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public long getQubitCapacity() {
        return getInputQubit() * getInputParallel();
    }

    @Override
    public long changeQubit(long energyToAdd) {
        GTLog.logger.fatal("Do not use changeEnergy() for cables! Use acceptEnergyFromNetwork()");
        return acceptQubitFromNetwork(facing == null ? EnumFacing.UP : facing,
                energyToAdd / getInputParallel(),
                energyToAdd / getInputQubit()) * getInputQubit();
    }

    @Override
    public boolean outputsQubit(EnumFacing side) {
        return true;
    }

    @Override
    public boolean inputsQubit(EnumFacing side) {
        return true;
    }

    @Override
    public long getQubitStored() {
        return 0;
    }

    @Override
    public boolean isOneProbeHidden() {
        return true;
    }
}
