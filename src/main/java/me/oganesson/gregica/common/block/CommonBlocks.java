package me.oganesson.gregica.common.block;

import me.oganesson.gregica.common.block.TEBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class CommonBlocks {

    public static final TEBlock ESSENTIA_HATCH = new TEBlock("essentia_hatch", 1);

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        if(Loader.isModLoaded("thaumcraft")) registerItemModel(ESSENTIA_HATCH);
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@Nonnull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(
                    Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }

}
