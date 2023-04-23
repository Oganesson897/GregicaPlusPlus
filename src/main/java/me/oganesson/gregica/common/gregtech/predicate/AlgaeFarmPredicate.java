package me.oganesson.gregica.common.gregtech.predicate;

import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.common.gregtech.GCMetaBlocks;
import me.oganesson.gregica.common.gregtech.metablock.GCMetaCasing;
import net.minecraft.block.state.IBlockState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class AlgaeFarmPredicate {
    public static TraceabilityPredicate MACHINECASINGS = new TraceabilityPredicate(blockWorldState -> {
        IBlockState blockState = blockWorldState.getBlockState();
        if (GCMetaBlocks.isMachineCasing(blockState)) {
            return true;
        }
        return false;
    }, () -> Arrays.stream(BlockMachineCasing.MachineCasingType.values())
            .sorted(Comparator.comparing(BlockMachineCasing.MachineCasingType::getName))
            .map(type -> new BlockInfo(MetaBlocks.MACHINE_CASING.getState(type), null))
            .toArray(BlockInfo[]::new));
}
