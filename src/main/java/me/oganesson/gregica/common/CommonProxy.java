package me.oganesson.gregica.common;

import gregtech.api.block.VariantItemBlock;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCLog;
import me.oganesson.gregica.common.blocks.GCMetaBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;
import java.util.function.Function;

@Mod.EventBusSubscriber(
        modid = Gregica.MOD_ID
)
public class CommonProxy {
    public CommonProxy() {
    }

    public void preLoad() {
    }

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals("gregica")) {
            ConfigManager.sync("gregica", Config.Type.INSTANCE);
        }

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        GCLog.logger.info("Registering blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(GCMetaBlocks.SOLAR_PANEL);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GCLog.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(createItemBlock(GCMetaBlocks.SOLAR_PANEL, VariantItemBlock::new));
    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = (ItemBlock)producer.apply(block);
        itemBlock.setRegistryName((ResourceLocation) Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GCLog.logger.info("Registering recipe low...");

    }
}
