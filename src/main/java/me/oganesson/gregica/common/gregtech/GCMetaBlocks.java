package me.oganesson.gregica.common.gregtech;

import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.common.gregtech.metablock.GCMetaCasing;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import static gregtech.common.blocks.MetaBlocks.statePropertiesToString;

public class GCMetaBlocks {

    public static final GCMetaCasing GC_BLOCK_CASING = new GCMetaCasing();

    public static boolean isEssentiaCell(IBlockState state) {
        if (!state.getBlock().equals(GC_BLOCK_CASING)) {
            return false;
        }
        if (state.equals(GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ESSENTIA_CELL_T1))) {
            return true;
        } else if (state.equals(GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ESSENTIA_CELL_T2))) {
            return true;
        } else if (state.equals(GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ESSENTIA_CELL_T3))) {
            return true;
        } else return state.equals(GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ESSENTIA_CELL_T4));
    }
    public static boolean isMachineCasing(IBlockState state) {
        if (!state.getBlock().equals(MetaBlocks.MACHINE_CASING)) {
            return false;
        }
        if (state.equals(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ULV))) {
            return false;
        } else if (state.equals(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LV))) {
            return false;
        }
         else return true;
    }

    public static int getCellTier(IBlockState state) {
        if (state.equals(GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ESSENTIA_CELL_T1))) {
            return 1;
        } else if (state.equals(GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ESSENTIA_CELL_T2))) {
            return 2;
        } else if (state.equals(GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ESSENTIA_CELL_T3))) {
            return 3;
        } else if (state.equals(GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ESSENTIA_CELL_T4))) {
            return 4;
        }
        return -1;
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(GC_BLOCK_CASING);
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@Nonnull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }

}
