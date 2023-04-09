package me.oganesson.gregica.common.blocks;

import com.google.common.collect.UnmodifiableIterator;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GCMetaBlocks {
    public static SingleSolarPanel SOLAR_PANEL;

    private GCMetaBlocks() {
    }

    public static void init() {
        SOLAR_PANEL = new SingleSolarPanel();
        SOLAR_PANEL.setRegistryName("solar_panel");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(SOLAR_PANEL);
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Block block) {
        UnmodifiableIterator var1 = block.getBlockState().getValidStates().iterator();

        while(var1.hasNext()) {
            IBlockState state = (IBlockState)var1.next();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), block.getMetaFromState(state), new ModelResourceLocation(block.getRegistryName(), MetaBlocks.statePropertiesToString(state.getProperties())));
        }

    }
}
