package me.oganesson.gregica.api.event;

import net.minecraft.client.resources.IResourcePack;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;

//失败的尝试
public class CustomResourcePackEvent extends Event {
    
    public static boolean  posted = false;
    private final List<IResourcePack> resourcePackList;
    
    //private final Map<String, IResourcePack> resourcePackMap;
    
    public CustomResourcePackEvent(List<IResourcePack> resourcePackList
            //, Map<String, IResourcePack> resourcePackMap
    ) {
        this.resourcePackList = resourcePackList;
        //this.resourcePackMap = resourcePackMap;
    }
    
    public void addCustomResourcePack(String modid,IResourcePack resourcePack){
        resourcePackList.add(resourcePack);
        //resourcePackMap.put(modid,resourcePack);
    }
}
