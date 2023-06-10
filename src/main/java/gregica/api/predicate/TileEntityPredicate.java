package gregica.api.predicate;

import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregica.common.block.CommonBlocks;
import gregica.common.block.metablock.GCMetaCasing;
import gregica.common.tileentities.mte.multi.generators.MTEEssentiaGenerator;
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
                .map(type -> new BlockInfo(CommonBlocks.getEssentiaHatch().getDefaultState(), null))
                .toArray(BlockInfo[]::new));
    }

    public static TileEntityPredicate get(Class<? extends TileEntity> tileClazz, MTEEssentiaGenerator host) {
        return new TileEntityPredicate(tileClazz, host);
    }

}
