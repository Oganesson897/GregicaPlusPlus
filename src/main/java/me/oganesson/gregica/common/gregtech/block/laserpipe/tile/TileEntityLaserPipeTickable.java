package me.oganesson.gregica.common.gregtech.block.laserpipe.tile;

import net.minecraft.util.ITickable;

//Code By Htmlcsjs, From htmltech at https://github.com/htmlcsjs/htmlTech, under the LGPLv3 License.
public class TileEntityLaserPipeTickable extends TileEntityLaserPipe implements ITickable {

    @Override
    public boolean supportsTicking() {
        return true;
    }

    @Override
    public void update() {
        getCoverableImplementation().update();
    }
}
