package me.oganesson.gregica.common.gregtech.block.laserpipe.net;

import gregtech.api.pipenet.WorldPipeNet;
import gregtech.api.pipenet.block.simple.EmptyNodeData;
import net.minecraft.world.World;

//Code By Htmlcsjs, From htmltech at https://github.com/htmlcsjs/htmlTech, under the LGPLv3 License.
public class WorldLaserNet extends WorldPipeNet<EmptyNodeData, LaserPipeNet> {

    private static final String DATA_ID_BASE = "gregica.laser_pipe_net";

    public static WorldLaserNet getWorldPipeNet(World world) {
        String DATA_ID = getDataID(DATA_ID_BASE, world);
        WorldLaserNet netWorldData = (WorldLaserNet) world.loadData(WorldLaserNet.class, DATA_ID);
        if (netWorldData == null) {
            netWorldData = new WorldLaserNet(DATA_ID);
            world.setData(DATA_ID, netWorldData);
        }

        netWorldData.setWorldAndInit(world);
        return netWorldData;
    }

    public WorldLaserNet(String name) {
        super(name);
    }

    @Override
    protected LaserPipeNet createNetInstance() {
        return new LaserPipeNet(this);
    }
}
