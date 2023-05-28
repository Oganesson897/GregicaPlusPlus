package me.oganesson.gregica.api.mte;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public interface INoticeable {
    //仅服务端调用
    void notice(IBlockAccess world, BlockPos pos);
    
    boolean isNoticed();
}
