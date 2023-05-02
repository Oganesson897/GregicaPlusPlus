package me.oganesson.gregica.api.predicate;

import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCells;
import net.minecraft.block.state.IBlockState;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class EssentiaCellPredicate {

    public static TraceabilityPredicate ESSENTIA_CELLS = new TraceabilityPredicate(blockWorldState -> {
        IBlockState blockState = blockWorldState.getBlockState();
        if (GCMetaBlocks.isEssentiaCell(blockState)) {
            int tier = GCMetaBlocks.getCellTier(blockState);
            Object currentCell = blockWorldState.getMatchContext().getOrPut("ESS_CELL", tier);
            if (!currentCell.equals(tier)) {
                blockWorldState.setError(new PatternStringError("gc.multiblock.pattern.error.essentia"));
                return false;
            }
            blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>()).add(blockWorldState.getPos());
            return true;
        }
        return false;
    }, () -> Arrays.stream(GCMetaCells.MetalCellType.values())
            .sorted(Comparator.comparing(GCMetaCells.MetalCellType::getName))
            .map(type -> new BlockInfo(GCMetaBlocks.GC_ESSENTIA_CELLS.getState(type), null))
            .toArray(BlockInfo[]::new))
            .addTooltips("gc.multiblock.pattern.error.essentia");

  //  () -> Arrays.stream(BlockCrucible.CrucibleType.values())
    //        .sorted(Comparator.comparingInt(BlockCrucible.CrucibleType::getTemperature))
   //         .map(type -> new BlockInfo(GCYSMetaBlocks.CRUCIBLE.getState(type), null))
      //      .toArray(BlockInfo[]::new));

}
