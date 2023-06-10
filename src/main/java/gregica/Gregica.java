package gregica;

import gregica.api.CommonProxy;
import gregtech.api.event.HighTierEvent;
import gregica.client.render.BlocksHighlightRenderer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = Gregica.MOD_ID,
        name = Gregica.MOD_NAME,
        version = Gregica.VERSION,
        dependencies="required-after:gcym;after:thaumcraft;required:mixinbooter"
)
public class Gregica {

    public static Logger logger = LogManager.getLogger(Gregica.MOD_ID);

    public static final String MOD_ID = "gregica";
    public static final String MOD_NAME = "Gregica++";
    public static final String MOD_ABRIDGE = "GC";
    public static final String VERSION = "0.0.2-Alpha";

    @SidedProxy(clientSide = "me.oganesson.gregica.api.ClientProxy", serverSide = "me.oganesson.gregica.api.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void onConstruction(FMLConstructionEvent event) {
       // ConfigHolder.machines.highTierContent = true;
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
    
    public static ResourceLocation gcResource(String path){
        return new ResourceLocation(Gregica.MOD_ID,path);
    }

    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /** Listen for the register event for creating custom items */

        @SubscribeEvent
        public static void onCheckHighTier(HighTierEvent event){
            event.enableHighTier();
        }
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            proxy.registerItems(event);
        }
        /** Listen for the register event for creating custom blocks */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
            proxy.registerBlocks(event);
        }

        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public static void modelRegistryEvent(ModelRegistryEvent event) {
            proxy.onModelRegister();
        }
    
        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public static void onRenderWorldLast(RenderWorldLastEvent event) {
            BlocksHighlightRenderer.renderWorldLastEvent(event);
        }
        
    }
}
