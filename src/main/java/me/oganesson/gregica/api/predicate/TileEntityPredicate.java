package me.oganesson.gregica.api.predicate;

import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import me.oganesson.gregica.common.block.CommonBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import me.oganesson.gregica.common.tileentities.mte.multi.generators.MTEEssentiaGenerator;
import net.minecraft.tileentity.TileEntity;

import java.util.Arrays;
import java.util.Comparator;

public class TileEntityPredicate extends TraceabilityPredicate {

    public TileEntityPredicate(Class<? extends TileEntity> tileClazz, MTEEssentiaGenerator host) {
        super(blockWorldState -> {
            TileEntity te = blockWorldState.getTileEntity();
            if (tileClazz.isInstance(te)) {
                host.addEssentiaHatch(te);
                return true;
            }
            return false;
        }, () -> Arrays.stream(GCMetaCasing.MetalCasingType.values())
                .sorted(Comparator.comparing(GCMetaCasing.MetalCasingType::getName))
                .map(type -> new BlockInfo(CommonBlocks.ESSENTIA_HATCH.getDefaultState(), null))
                .toArray(BlockInfo[]::new));
    }

    public static TileEntityPredicate get(Class<? extends TileEntity> tileClazz, MTEEssentiaGenerator host) {
        return new TileEntityPredicate(tileClazz, host);
    }

}
