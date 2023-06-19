package gregica.common.data;

import gregica.Gregica;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = Gregica.MOD_ID)
public class DataEventHandler {
    
    public static void onServerStart() {
        try {
            CrossWorldDataHandler.INSTANCE.loadWorld();
        } catch (IOException var1) {
            throw new RuntimeException(var1);
        }
    }
    
    public static void onSeverClose() {
        try {
            CrossWorldDataHandler.INSTANCE.unloadWorld();
        } catch (IOException var1) {
            throw new RuntimeException(var1);
        }
    }
    
    public static void onWorldLoad(WorldEvent.Load event) {
        if (!event.getWorld().isRemote) {
            try {
                CrossWorldDataHandler.INSTANCE.loadWorld();
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        }
        
    }
    
    @SubscribeEvent
    public static void onWorldSave(WorldEvent.Save event) {
        if (!event.getWorld().isRemote) {
            try {
                CrossWorldDataHandler.INSTANCE.save();
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        }
        
    }
    
    public static void onWorldUnload(WorldEvent.Unload event) {
        if (!event.getWorld().isRemote) {
            try {
                CrossWorldDataHandler.INSTANCE.unloadWorld();
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        }
        
    }
    
}
