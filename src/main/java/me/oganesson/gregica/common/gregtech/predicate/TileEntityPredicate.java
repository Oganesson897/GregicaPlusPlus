package me.oganesson.gregica.common.gregtech.predicate;

import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import me.oganesson.gregica.common.gregtech.CommonBlocks;
import me.oganesson.gregica.common.gregtech.metablock.GCMetaCasing;
import me.oganesson.gregica.common.gregtech.metatileentity.MetaTileEntityEssentiaGenerator;
import net.minecraft.tileentity.TileEntity;

import java.util.Arrays;
import java.util.Comparator;

public class TileEntityPredicate extends TraceabilityPredicate {

    public TileEntityPredicate(Class<? extends TileEntity> tileClazz, MetaTileEntityEssentiaGenerator host) {
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

    public static TileEntityPredicate get(Class<? extends TileEntity> tileClazz, MetaTileEntityEssentiaGenerator host) {
        return new TileEntityPredicate(tileClazz, host);
    }

}
