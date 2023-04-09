package me.oganesson.gregica.common;

import me.oganesson.gregica.common.blocks.GCMetaBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber({Side.CLIENT})
public class ClientProxy extends CommonProxy {
    public ClientProxy() {
    }

    public void preLoad() {
        super.preLoad();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GCMetaBlocks.registerItemModels();
    }
}
