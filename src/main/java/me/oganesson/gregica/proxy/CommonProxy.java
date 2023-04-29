package me.oganesson.gregica.proxy;

import gregtech.api.GTValues;
import gregtech.api.block.VariantItemBlock;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCLog;
import me.oganesson.gregica.api.capability.GCCapabilities;
import me.oganesson.gregica.api.capability.GCCapabilityProvider;
import me.oganesson.gregica.common.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.block.laserpipe.ItemBlockLaserPipe;
import me.oganesson.gregica.common.block.laserpipe.tile.TileEntityLaserPipe;
import me.oganesson.gregica.common.cover.GCCoverBehaviors;
import me.oganesson.gregica.common.item.itemUpgrades;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;
import me.oganesson.gregica.common.item.metaitems.GCMetaToolItems;
import me.oganesson.gregica.common.recipes.FuelRecipe;
import me.oganesson.gregica.common.thaumcraft.LargeEssentiaEnergyData;
import me.oganesson.gregica.common.tileentities.EssentiaHatch;
import me.oganesson.gregica.common.tileentities.mte.GCMetaEntities;
import me.oganesson.gregica.common.recipes.GCRecipes;
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
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

import static me.oganesson.gregica.common.block.CommonBlocks.ESSENTIA_HATCH;
import static me.oganesson.gregica.common.block.metablock.GCMetaBlocks.GC_BLOCK_CASING;
import static me.oganesson.gregica.common.block.metablock.GCMetaBlocks.GC_ESSENTIA_CELLS;
import static me.oganesson.gregica.common.tileentities.mte.GCMetaEntities.LASER_PIPES;

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
        GCMetaToolItems.init();
        GCCapabilities.init();
        GCRecipes.registerTool();
        if(Loader.isModLoaded("thaumcraft")) LargeEssentiaEnergyData.processEssentiaData();
        GCLog.init(LogManager.getLogger(Gregica.MOD_ID));
    }

    public void init( FMLInitializationEvent event ) {
        FuelRecipe.init();
        GCRecipes.register();
        GCCoverBehaviors.init();
        if (Loader.isModLoaded(GTValues.MODID_TOP)) {
            GCLog.logger.info("TheOneProbe found. Enabling integration...");
            GCCapabilityProvider.registerCompatibility();
        }
    }

    public void registerItems(RegistryEvent.Register<Item> event) {
        GCMetaItems.initSubitems();

        Upgrades.setCreativeTab(Tab);
        event.getRegistry().register(Upgrades);
        event.getRegistry().register(createItemBlock(GC_BLOCK_CASING, VariantItemBlock::new));
        event.getRegistry().register(createItemBlock(GC_ESSENTIA_CELLS, VariantItemBlock::new));
        if(Loader.isModLoaded("thaumcraft")) event.getRegistry().register(createItemBlock(ESSENTIA_HATCH, ItemBlock::new));
        for(BlockLaserPipe pipe : LASER_PIPES) event.getRegistry().register(createItemBlock(pipe, ItemBlockLaserPipe::new));
    }

    public void registerBlocks(RegistryEvent.Register<Block> event) {
        GC_BLOCK_CASING.setCreativeTab(Tab);
        GC_ESSENTIA_CELLS.setCreativeTab(Tab);
        event.getRegistry().register(GC_BLOCK_CASING);
        event.getRegistry().register(GC_ESSENTIA_CELLS);
        for (BlockLaserPipe pipe : LASER_PIPES) event.getRegistry().register(pipe);
        if(Loader.isModLoaded("thaumcraft")){
            GameRegistry.registerTileEntity(EssentiaHatch.class, Objects.requireNonNull(ESSENTIA_HATCH.getRegistryName()));
            ESSENTIA_HATCH.setCreativeTab(Tab);
            event.getRegistry().register(ESSENTIA_HATCH);}
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
