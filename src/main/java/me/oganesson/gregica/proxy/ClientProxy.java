package me.oganesson.gregica.proxy;

import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCValues;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.client.render.pipe.LaserPipeRenderer;
import me.oganesson.gregica.common.block.CommonBlocks;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.block.GCYSMetaBlocks;
import me.oganesson.gregica.common.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.item.itemUpgrades;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.resources.IResource;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import java.io.IOException;
import java.io.InputStream;

import static me.oganesson.gregica.common.tileentities.mte.GCMetaEntities.LASER_PIPES;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public void preInit( FMLPreInitializationEvent event ) {
        super.preInit(event);
        GCTextures.preInit();
        LaserPipeRenderer.INSTANCE.preInit();
    }

    public void init( FMLInitializationEvent event ) {
        super.init(event);
        GCMetaBlocks.registerColors();
    }

    public void onModelRegister() {
        GCMetaBlocks.registerItemModels();
        GCYSMetaBlocks.registerItemModels();
        if(GCValues.IS_TC_LOADED) CommonBlocks.registerItemModels();
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
//                       "block_model"+ GCMetaBlocks.getType(state).ordinal());
//           }
//       });
//        ModelLoaderRegistry.registerLoader(new CasingModelLoader());
    }
    
//    public void onCustomResourcePack(CustomResourcePackEvent event){
//        //GCLog.info("test_mixin");
//        event.addCustomResourcePack(Gregica.MOD_ID,new CasingResourcePack());
//    }
}