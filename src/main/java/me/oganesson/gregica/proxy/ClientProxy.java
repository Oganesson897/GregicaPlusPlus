package me.oganesson.gregica.proxy;

import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCValues;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.client.render.laserpipe.LaserVacuumPipeRender;
import me.oganesson.gregica.common.block.CommonBlocks;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.block.GCYSMetaBlocks;
import me.oganesson.gregica.common.item.CommonItems;
import me.oganesson.gregica.common.item.itemUpgrades;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    public void preInit( FMLPreInitializationEvent event ) {
        super.preInit(event);
        GCTextures.preInit();
        LaserVacuumPipeRender.INSTANCE.preInit();
    }

    public void init( FMLInitializationEvent event ) {
        super.init(event);
        GCMetaBlocks.registerColors();
    }

    public void onModelRegister() {
        GCMetaBlocks.registerItemModels();
        GCYSMetaBlocks.registerItemModels();
        if(GCValues.IS_TC_LOADED) CommonBlocks.registerItemModels();
       for (int i = 0; i < itemUpgrades.ListUpgrade.length; i++)
            ModelLoader.setCustomModelResourceLocation(Upgrades, i, new ModelResourceLocation(Gregica.MOD_ID + ":" + itemUpgrades.ListUpgrade[i] + "_upgrade", "inventory"));
       
       ModelLoader.setCustomStateMapper(CommonBlocks.OpaqueLVPipe,new DefaultStateMapper(){
           @Override
           protected @NotNull ModelResourceLocation getModelResourceLocation(@NotNull IBlockState state) {
               return LaserVacuumPipeRender.INSTANCE.getModelLocation();
           }
       });
       ModelLoader.setCustomStateMapper(CommonBlocks.TransparentLVPipe,new DefaultStateMapper(){
           @Override
           protected @NotNull ModelResourceLocation getModelResourceLocation(@NotNull IBlockState state) {
               return LaserVacuumPipeRender.INSTANCE.getModelLocation();
           }
       });
       
        ModelLoader.setCustomMeshDefinition(CommonItems.OPAQUE_ITEM_LASER_VACUUM_BLOCK,
                stack -> LaserVacuumPipeRender.INSTANCE.getModelLocation());
        ModelLoader.setCustomMeshDefinition(CommonItems.TRANSPARENT_ITEM_LASER_VACUUM_BLOCK,
                stack -> LaserVacuumPipeRender.INSTANCE.getModelLocation());
        
    }
    

}