package me.oganesson.gregica.api.predicate;

import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class AlgaeFarmPredicate {
    public static final Object2ObjectOpenHashMap<IBlockState, IStringSerializable> IMACHINECASING = new Object2ObjectOpenHashMap();

    public static TraceabilityPredicate MACHINECASINGS = new TraceabilityPredicate(blockWorldState -> {
        IBlockState blockState = blockWorldState.getBlockState();
        if (GCMetaBlocks.isMachineCasing(blockState)) {
            IStringSerializable stats = IMACHINECASING.get(blockState);
            Object currentCoil = blockWorldState.getMatchContext().getOrPut("MachineCasingType", stats);
            if (!currentCoil.equals(stats)) {
                blockWorldState.setError(new PatternStringError("gregtech.multiblock.pattern.error.casing"));
                return false;
            } else {
                ((LinkedList)blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList())).add(blockWorldState.getPos());
                return true;
            }
        } else {
            return false;
        }
    }, () -> Arrays.stream(BlockMachineCasing.MachineCasingType.values())
            .sorted(Comparator.comparing(BlockMachineCasing.MachineCasingType::getName))
            .map(type -> new BlockInfo(MetaBlocks.MACHINE_CASING.getState(type), null))
            .toArray(BlockInfo[]::new));
}
