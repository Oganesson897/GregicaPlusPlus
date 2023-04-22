package me.oganesson.gregica.common.block.laserpipe.tile;

import gregtech.api.pipenet.block.simple.EmptyNodeData;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import gregtech.api.util.PerTickLongCounter;
import gregtech.common.pipelike.cable.tile.AveragingPerTickCounter;
import me.oganesson.gregica.api.capability.GCCapabilities;
import me.oganesson.gregica.api.capability.quantum.IQubitContainer;
import me.oganesson.gregica.common.block.laserpipe.LaserPipeType;
import me.oganesson.gregica.common.block.laserpipe.net.LaserPipeNet;
import me.oganesson.gregica.common.block.laserpipe.net.PipeLaserContainer;
import me.oganesson.gregica.common.block.laserpipe.net.WorldLaserNet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;
import java.lang.ref.WeakReference;

//Code By Htmlcsjs, From htmltech at https://github.com/htmlcsjs/htmlTech, under the LGPLv3 License.
public class TileEntityLaserPipe extends TileEntityPipeBase<LaserPipeType, EmptyNodeData> {

    private PipeLaserContainer laserContainer;
    private WeakReference<LaserPipeNet> currentEnergyNet = new WeakReference<>(null);
    private final PerTickLongCounter maxVoltageCounter = new PerTickLongCounter(0);
    private final AveragingPerTickCounter averageVoltageCounter = new AveragingPerTickCounter(0, 20);
    private final AveragingPerTickCounter averageAmperageCounter = new AveragingPerTickCounter(0, 20);


    public PipeLaserContainer getLaserContainer() {
        LaserPipeNet net = getLaserPipeNet();
        if(laserContainer == null) {
            laserContainer = new PipeLaserContainer(net, this, null);
        }
        return laserContainer;
    }

    @Override
    public Class<LaserPipeType> getPipeTypeClass() {
        return LaserPipeType.class;
    }

    @Override
    public boolean supportsTicking() {
        return false;
    }

    @Override
    public <T> T getCapabilityInternal(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == GCCapabilities.QBIT_CAPABILITY) {
            return GCCapabilities.QBIT_CAPABILITY.cast(getLaserContainer());
        }
        return super.getCapabilityInternal(capability, facing);
    }

    public IQubitContainer findLaserContainer(EnumFacing facing) {
        IQubitContainer laserContainer = null;
        BlockPos.PooledMutableBlockPos pos = BlockPos.PooledMutableBlockPos.retain(getPos());
        while (laserContainer == null) {
            pos.move(facing);
            TileEntity tile = world.getTileEntity(pos);
            if(tile == null)
                break;
            if(tile instanceof TileEntityLaserPipe)
                continue;
            laserContainer = tile.getCapability(GCCapabilities.QBIT_CAPABILITY, facing.getOpposite());
        }
        return laserContainer;
    }

    /**
     * Should only be called internally
     */
    public void incrementAmperage(long amps, long voltage) {
        if (voltage > maxVoltageCounter.get(world)) {
            maxVoltageCounter.set(world, voltage);
        }
        averageVoltageCounter.increment(world, voltage);
        averageAmperageCounter.increment(world, amps);
    }


    private LaserPipeNet getLaserPipeNet() {
        if(world == null || world.isRemote)
            return null;
        LaserPipeNet currentEnergyNet = this.currentEnergyNet.get();
        if (currentEnergyNet != null && currentEnergyNet.isValid() && currentEnergyNet.containsNode(getPos()))
            return currentEnergyNet; //return current net if it is still valid
        WorldLaserNet worldNet = WorldLaserNet.getWorldPipeNet(getWorld());
        currentEnergyNet = worldNet.getNetFromPos(getPos());
        if (currentEnergyNet != null) {
            this.currentEnergyNet = new WeakReference<>(currentEnergyNet);
        }
        return currentEnergyNet;
    }
}
