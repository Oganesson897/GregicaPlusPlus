package me.oganesson.gregica;

import gregtech.api.GregTechAPI;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.loaders.recipe.CraftingComponent;
import me.oganesson.gregica.api.unification.OrePrefixAdditions;
import me.oganesson.gregica.api.unification.materials.GCYSMaterials;
import me.oganesson.gregica.api.unification.materials.properties.GCYSMaterialPropertyAddition;
import me.oganesson.gregica.common.recipes.GCYSMaterialInfoLoader;
import me.oganesson.gregica.common.recipes.component.GCYSCraftingComponent;
import me.oganesson.gregica.common.unification.materials.GCMaterials;
import me.oganesson.gregica.common.unification.ore.OrePrefixGCPP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Gregica.MOD_ID)
public class GCEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onMaterialRegister(GregTechAPI.MaterialEvent event){
        OrePrefixGCPP.register();
        GCMaterials.register();

        //GCYS
        GCYSMaterials.init();
        GCYSMaterialPropertyAddition.init();
        OrePrefixAdditions.init();
    }

    //GCYS
    @SubscribeEvent
    public static void initMaterialInfo(GregTechAPI.RegisterEvent<ItemMaterialInfo> event) {
        GCYSMaterialInfoLoader.init();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void initComponents(GregTechAPI.RegisterEvent<CraftingComponent> event) {
        GCYSCraftingComponent.init();
    }
}
