package me.oganesson.gregica.proxy;

import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.client.LaserPipeRenderer;
import me.oganesson.gregica.client.model.CasingModelLoader;
import me.oganesson.gregica.common.block.CommonBlocks;
import me.oganesson.gregica.common.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.block.metablock.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import me.oganesson.gregica.common.item.itemUpgrades;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.BlockStateMapper;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import javax.annotation.Nonnull;

import static me.oganesson.gregica.common.tileentities.mte.GCMetaEntities.LASER_PIPES;

public class ClientProxy extends CommonProxy {

    public void preInit( FMLPreInitializationEvent event ) {
        super.preInit(event);
        GCTextures.preInit();
        LaserPipeRenderer.INSTANCE.preInit();
    }

    public void init( FMLInitializationEvent event ) {
        super.init(event);
    }

    public void onModelRegister() {
        GCMetaBlocks.registerItemModels();
        if(Loader.isModLoaded("thaumcraft")) CommonBlocks.registerItemModels();
        for (BlockLaserPipe pipe : LASER_PIPES) {
            ModelLoader.setCustomStateMapper(pipe, new DefaultStateMapper() {
                @Nonnull
                @Override
                protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
                    return LaserPipeRenderer.INSTANCE.getModelLocation();
                }
            });
            ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(pipe), stack -> LaserPipeRenderer.INSTANCE.getModelLocation());
        }
       for (int i = 0; i < itemUpgrades.ListUpgrade.length; i++)
            ModelLoader.setCustomModelResourceLocation(Upgrades, i, new ModelResourceLocation(Gregica.MOD_ID + ":" + itemUpgrades.ListUpgrade[i] + "_upgrade", "inventory"));
       
//       ModelLoader.setCustomStateMapper(GCMetaBlocks.GC_BLOCK_CASING, new StateMapperBase() {
//           @Override
//           @Nonnull
//           protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
//               return new ModelResourceLocation(new ResourceLocation(Gregica.MOD_ID,"gc_machine_casing"),
//                       "model"+ GCMetaBlocks.getType(state).ordinal());
//           }
//       });
        //ModelLoaderRegistry.registerLoader(new CasingModelLoader());
    }
}