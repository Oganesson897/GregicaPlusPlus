package project.gregica.common.data;

import project.gregica.Gregica;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = Gregica.MOD_ID)
public class DataEventHandler {

    @SubscribeEvent
    public static void onWorldLoad(WorldEvent.Load event){
        if(!event.getWorld().isRemote) {
            try {
                CrossWorldDataHandler.INSTANCE.loadWorld(event.getWorld().provider.getDimension());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SubscribeEvent
    public static void onWorldSave(WorldEvent.Save event){
        if(!event.getWorld().isRemote) {
            try {
                CrossWorldDataHandler.INSTANCE.save(event.getWorld().provider.getDimension());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SubscribeEvent
    public static void onWorldUnload(WorldEvent.Unload event){
        if(!event.getWorld().isRemote) {
            try {
                CrossWorldDataHandler.INSTANCE.unloadWorld(event.getWorld().provider.getDimension());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    
}
