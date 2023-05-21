package me.oganesson.gregica.proxy;

import gregtech.api.block.VariantItemBlock;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCLog;
import me.oganesson.gregica.api.GCValues;
import me.oganesson.gregica.api.capability.GCCapabilities;
import me.oganesson.gregica.api.capability.GCCapabilityProvider;
import me.oganesson.gregica.common.block.GCYSMetaBlocks;
import me.oganesson.gregica.common.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.block.laserpipe.ItemBlockLaserPipe;
import me.oganesson.gregica.common.block.laserpipe.tile.TileEntityLaserPipe;
import me.oganesson.gregica.common.item.cover.GCCoverBehaviors;
import me.oganesson.gregica.common.item.itemUpgrades;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;
import me.oganesson.gregica.common.item.metaitems.GCMetaToolItems;
import me.oganesson.gregica.common.recipes.FuelRecipe;
import me.oganesson.gregica.common.recipes.GCIsaProcessLine;
import me.oganesson.gregica.common.recipes.GCRecipes;
import me.oganesson.gregica.common.recipes.GCYSRecipeLoader;
import me.oganesson.gregica.common.recipes.compat.Thaumcraft;
import me.oganesson.gregica.common.thaumcraft.LargeEssentiaEnergyData;
import me.oganesson.gregica.common.tileentities.EssentiaHatch;
import me.oganesson.gregica.common.tileentities.mte.GCMetaEntities;
import me.oganesson.gregica.common.unification.materials.ore.GCOres;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

import static me.oganesson.gregica.api.capability.chemical_plant.ChemicalPlantProperties.registerCasingTier;
import static me.oganesson.gregica.api.capability.isa_mill.IsaMillProperties.registerBallTier;
import static me.oganesson.gregica.common.block.CommonBlocks.getEssentiaHatch;
import static me.oganesson.gregica.common.block.GCMetaBlocks.*;
import static me.oganesson.gregica.common.tileentities.mte.GCMetaEntities.LASER_PIPES;

public class CommonProxy {

    public static Item Upgrades = new itemUpgrades();

    public static final CreativeTabs GREGICA_TAB = new CreativeTabs("gregica") {
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
        if(GCValues.IS_TC_LOADED) LargeEssentiaEnergyData.processEssentiaData();
        GCRecipes.registerTool();
        GCIsaProcessLine.register();
        GCLog.init(LogManager.getLogger(Gregica.MOD_ID));

        //GCYS
        GCYSMetaBlocks.init();
        GCYSRecipeLoader.initHandlers();
    }

    public void init( FMLInitializationEvent event ) {
        registerCasingTier(0, "Bronze");
        registerCasingTier(1, "Steel");
        registerCasingTier(2, "Aluminium");
        registerCasingTier(3, "StainlessSteel");
        registerCasingTier(4, "Titanium");
        registerCasingTier(5, "TungstenSteel");

        registerBallTier(1, "SoapStone");
        registerBallTier(2, "Aluminium");

        FuelRecipe.init();
        if (GCValues.IS_TOP_LOADED) {
            GCLog.logger.info("TheOneProbe found. Enabling integration...");
            GCCapabilityProvider.registerCompatibility();
        }
        GCRecipes.register();
        GCCoverBehaviors.init();

        //GCYS
        GCYSRecipeLoader.init();

        //Thaumcraft
        if(GCValues.IS_TC_LOADED)
            Thaumcraft.initTC();
    }
    

    public void registerItems(RegistryEvent.Register<Item> event) {
        GCMetaItems.initSubitems();
        
        IForgeRegistry<Item> registry = event.getRegistry();
        
        Upgrades.setCreativeTab(GREGICA_TAB);
        registry.register(Upgrades);
        registry.register(createItemBlock(GC_BLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GC_ESSENTIA_CELLS, VariantItemBlock::new));
        registry.register(createItemBlock(GC_META_GEAR_BOX, VariantItemBlock::new));
        registry.register(createItemBlock(GC_LAPOTRONIC_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(TRANSPARENT_CASING,  VariantItemBlock::new));
        registry.register(createItemBlock(TRANSPARENT_CASING1,  VariantItemBlock::new));
        registry.register(createItemBlock(PINE_LOG, ItemBlock::new));
        registry.register(createItemBlock(PINE_SAPLING, ItemBlock::new));
        registry.register(createItemBlock(PINE_LEAVES, ItemBlock::new));
        if(GCValues.IS_TC_LOADED) event.getRegistry().register(createItemBlock(getEssentiaHatch(), ItemBlock::new));
        for(BlockLaserPipe pipe : LASER_PIPES) event.getRegistry().register(createItemBlock(pipe, ItemBlockLaserPipe::new));

        
        registry.register(createItemBlock(GCYSMetaBlocks.CRUCIBLE, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSMetaBlocks.MULTIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSMetaBlocks.MULTIBLOCK_CASING_ACTIVE, VariantItemBlock::new));
        registry.register(createItemBlock(GCYSMetaBlocks.TRANSPARENT_CASING, VariantItemBlock::new));
    }

    public void registerBlocks(RegistryEvent.Register<Block> event) {
        GCOres.registerSpecialOres();

        GC_BLOCK_CASING.setCreativeTab(GREGICA_TAB);
        GC_ESSENTIA_CELLS.setCreativeTab(GREGICA_TAB);
        GC_META_GEAR_BOX.setCreativeTab(GREGICA_TAB);
        TRANSPARENT_CASING1.setCreativeTab(GREGICA_TAB);
        TRANSPARENT_CASING.setCreativeTab(GREGICA_TAB);
        GC_LAPOTRONIC_CASING.setCreativeTab(GREGICA_TAB);
        PINE_LOG.setCreativeTab(GREGICA_TAB);
        PINE_SAPLING.setCreativeTab(GREGICA_TAB);
        PINE_LEAVES.setCreativeTab(GREGICA_TAB);

        if(GCValues.IS_TC_LOADED){
            getEssentiaHatch().setCreativeTab(GREGICA_TAB);
            event.getRegistry().register(getEssentiaHatch());
            GameRegistry.registerTileEntity(EssentiaHatch.class, Objects.requireNonNull(getEssentiaHatch().getRegistryName()));
        }
        event.getRegistry().register(GC_BLOCK_CASING);
        event.getRegistry().register(GC_ESSENTIA_CELLS);
        event.getRegistry().register(GC_META_GEAR_BOX);
        event.getRegistry().register(GC_LAPOTRONIC_CASING);
        event.getRegistry().register(TRANSPARENT_CASING);
        event.getRegistry().register(TRANSPARENT_CASING1);
        event.getRegistry().register(PINE_LOG);
        event.getRegistry().register(PINE_SAPLING);
        event.getRegistry().register(PINE_LEAVES);
        for (BlockLaserPipe pipe : LASER_PIPES) event.getRegistry().register(pipe);
        GameRegistry.registerTileEntity(TileEntityLaserPipe.class, new ResourceLocation(Gregica.MOD_ID, "laser_pipe"));

        event.getRegistry().register(GCYSMetaBlocks.CRUCIBLE);
        event.getRegistry().register(GCYSMetaBlocks.MULTIBLOCK_CASING);
        event.getRegistry().register(GCYSMetaBlocks.MULTIBLOCK_CASING_ACTIVE);
        event.getRegistry().register(GCYSMetaBlocks.TRANSPARENT_CASING);
    }

    public void onModelRegister() {

    }

    private static <T extends Block> ItemBlock createItemBlock(@Nonnull T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }
}
