package me.oganesson.gregica.api.predicate;

import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import net.minecraft.block.state.IBlockState;

import java.util.Arrays;
import java.util.Comparator;

public class AlgaeFarmPredicate {
    public static TraceabilityPredicate MACHINECASINGS = new TraceabilityPredicate(blockWorldState -> {
        IBlockState blockState = blockWorldState.getBlockState();
        return GCMetaBlocks.isMachineCasing(blockState);
    }, () -> Arrays.stream(BlockMachineCasing.MachineCasingType.values())
            .sorted(Comparator.comparing(BlockMachineCasing.MachineCasingType::getName))
            .map(type -> new BlockInfo(MetaBlocks.MACHINE_CASING.getState(type), null))
            .toArray(BlockInfo[]::new));
}
