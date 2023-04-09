package me.oganesson.gregica.proxy;

import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.gregtech.CommonBlocks;
import me.oganesson.gregica.common.gregtech.GCMetaBlocks;
import me.oganesson.gregica.common.item.itemUpgrades;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    public void preInit( FMLPreInitializationEvent event ) {
        super.preInit(event);
        GCTextures.preInit();
    }

    public void init( FMLInitializationEvent event ) {
        super.init(event);
    }

    public void onModelRegister() {
        GCMetaBlocks.registerItemModels();
        CommonBlocks.registerItemModels();
       for (int i = 0; i < itemUpgrades.ListUpgrade.length; i++)
            ModelLoader.setCustomModelResourceLocation(Upgrades, i, new ModelResourceLocation(Gregica.MOD_ID + ":" + itemUpgrades.ListUpgrade[i] + "_upgrade", "inventory"));
    }
}