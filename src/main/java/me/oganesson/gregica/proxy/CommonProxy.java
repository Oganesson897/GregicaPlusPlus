package me.oganesson.gregica.proxy;

import gregtech.api.GTValues;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.util.GTLog;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCPPCapabilities;
import me.oganesson.gregica.common.gregtech.FuelRecipe;
import me.oganesson.gregica.common.gregtech.GCMetaEntities;
import me.oganesson.gregica.common.gregtech.GCMetaItems;
import me.oganesson.gregica.common.gregtech.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.gregtech.block.laserpipe.ItemBlockLaserPipe;
import me.oganesson.gregica.common.gregtech.block.laserpipe.tile.TileEntityLaserPipe;
import me.oganesson.gregica.common.gregtech.tileentity.EssentiaHatch;
import me.oganesson.gregica.common.item.itemUpgrades;
import me.oganesson.gregica.common.thaumcraft.LargeEssentiaEnergyData;
import me.oganesson.gregica.common.top.GCPPCapability;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

import static me.oganesson.gregica.common.gregtech.CommonBlocks.ESSENTIA_HATCH;
import static me.oganesson.gregica.common.gregtech.GCMetaBlocks.GC_BLOCK_CASING;
import static me.oganesson.gregica.common.gregtech.GCMetaEntities.LASER_PIPES;

public class CommonProxy {

    public static Item Upgrades = new itemUpgrades();

    public static final CreativeTabs Tab = new CreativeTabs("gregica") {
        @Override
        @Nonnull
        public ItemStack createIcon() {
            return new ItemStack(Upgrades, 1, 0);
        }
    };

    public void preInit( FMLPreInitializationEvent event ) {
        GCMetaEntities.register();
        GCMetaItems.initMetaItems();
        GCPPCapabilities.init();
        LargeEssentiaEnergyData.processEssentiaData();
    }

    public void init( FMLInitializationEvent event ) {
        FuelRecipe.init();
        if (Loader.isModLoaded(GTValues.MODID_TOP)) {
            GTLog.logger.info("TheOneProbe found. Enabling integration...");
            GCPPCapability.registerCompatibility();
        }
    }

    public void registerItems(RegistryEvent.Register<Item> event) {
        GCMetaItems.initSubitems();

        Upgrades.setCreativeTab(Tab);
        event.getRegistry().register(Upgrades);
        event.getRegistry().register(createItemBlock(GC_BLOCK_CASING, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(ESSENTIA_HATCH, ItemBlock::new));
        for(BlockLaserPipe pipe : LASER_PIPES) event.getRegistry().register(createItemBlock(pipe, ItemBlockLaserPipe::new));
    }

    public void registerBlocks(RegistryEvent.Register<Block> event) {
        GC_BLOCK_CASING.setCreativeTab(Tab);
        ESSENTIA_HATCH.setCreativeTab(Tab);
        event.getRegistry().register(GC_BLOCK_CASING);
        event.getRegistry().register(ESSENTIA_HATCH);
        for (BlockLaserPipe pipe : LASER_PIPES) event.getRegistry().register(pipe);
        GameRegistry.registerTileEntity(EssentiaHatch.class, Objects.requireNonNull(ESSENTIA_HATCH.getRegistryName()));
        GameRegistry.registerTileEntity(TileEntityLaserPipe.class, new ResourceLocation(Gregica.MOD_ID, "laser_pipe"));
    }

    public void onModelRegister() {

    }

    private static <T extends Block> ItemBlock createItemBlock(@Nonnull T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }
}
