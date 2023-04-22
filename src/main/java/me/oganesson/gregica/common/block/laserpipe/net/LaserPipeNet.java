package me.oganesson.gregica.common.block.laserpipe.net;

import gregtech.api.pipenet.Node;
import gregtech.api.pipenet.PipeNet;
import gregtech.api.pipenet.WorldPipeNet;
import gregtech.api.pipenet.block.simple.EmptyNodeData;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Code By Htmlcsjs, From htmltech at https://github.com/htmlcsjs/htmlTech, under the LGPLv3 License.
public class LaserPipeNet extends PipeNet<EmptyNodeData> {

    private long lastEnergyFluxPerSec;
    private long energyFluxPerSec;
    private long lastTime;

    private final Map<BlockPos, List<LaserRoutePath>> NET_DATA = new HashMap<>();

    public LaserPipeNet(WorldPipeNet<EmptyNodeData, ? extends PipeNet> world) {
        super(world);
    }

    public List<LaserRoutePath> getNetData(BlockPos pipePos) {
        List<LaserRoutePath> data = NET_DATA.get(pipePos);
        if (data == null) {
            data = LaserNetWalker.createNetData(getWorldData(), pipePos);
            data.sort(Comparator.comparingInt(LaserRoutePath::getDistance));
            NET_DATA.put(pipePos, data);
        }
        return data;
    }

    public void nodeNeighbourChanged(BlockPos pos) {
        NET_DATA.clear();
    }

    public long getEnergyFluxPerSec() {
        World world = getWorldData();
        if (world != null && !world.isRemote && (world.getWorldTime() - lastTime) >= 20) {
            lastTime = world.getWorldTime();
            clearCache();
        }
        return lastEnergyFluxPerSec;
    }

    public void addEnergyFluxPerSec(long energy) {
        energyFluxPerSec += energy;
    }

    public void clearCache() {
        lastEnergyFluxPerSec = energyFluxPerSec;
        energyFluxPerSec = 0;
    }
    @Override
    protected void updateBlockedConnections(BlockPos nodePos, EnumFacing facing, boolean isBlocked) {
        super.updateBlockedConnections(nodePos, facing, isBlocked);
        NET_DATA.clear();
    }

    @Override
    protected void transferNodeData(Map<BlockPos, Node<EmptyNodeData>> transferredNodes, PipeNet<EmptyNodeData> parentNet) {
        super.transferNodeData(transferredNodes, parentNet);
        NET_DATA.clear();
        ((LaserPipeNet) parentNet).NET_DATA.clear();
    }


    @Override
    protected void writeNodeData(EmptyNodeData emptyNodeData, NBTTagCompound nbtTagCompound) {

    }

    @Override
    protected EmptyNodeData readNodeData(NBTTagCompound nbtTagCompound) {
        return null;
    }
}
