package me.oganesson.gregica.common.block.laserpipe;

import gregtech.api.pipenet.block.ItemBlockPipe;
import gregtech.api.pipenet.block.simple.EmptyNodeData;
import me.oganesson.gregica.proxy.CommonProxy;

//Code By Htmlcsjs, From htmltech at https://github.com/htmlcsjs/htmlTech, under the LGPLv3 License.
public class ItemBlockLaserPipe extends ItemBlockPipe<LaserPipeType, EmptyNodeData> {

    public ItemBlockLaserPipe(BlockLaserPipe block) {
        super(block);
        setCreativeTab(CommonProxy.Tab);
    }
}
