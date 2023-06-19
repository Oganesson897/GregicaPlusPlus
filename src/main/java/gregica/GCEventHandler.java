package gregica;

import gregica.api.item.IExtendedItemBehavior;
import gregica.modules.gcys.api.unification.OrePrefixAdditions;
import gregica.network.GCNetworkManager;
import gregica.utils.GCLangUtil;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.loaders.recipe.CraftingComponent;
import gregica.modules.gcys.api.unification.materials.GCYSMaterials;
import gregica.modules.gcys.api.unification.materials.properties.GCYSMaterialPropertyAddition;
import gregica.loader.recipes.GCYSMaterialInfoLoader;
import gregica.loader.recipes.component.GCYSCraftingComponent;
import gregica.api.unification.materials.GCMaterials;
import gregica.api.unification.materials.ore.GCOrePrefixs;
import gregica.network.packets.MouseEventToSeverPacker;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Gregica.MOD_ID)
public class GCEventHandler {
    
//    @SubscribeEvent
//    @SideOnly(Side.CLIENT)
//    public static void itemColors(ColorHandlerEvent.Item event) {
//        event.getItemColors().registerItemColorHandler(new ColorApplicatorColor(), GCMetaItems.metaItem3);
//    }
    
    @SubscribeEvent(priority = EventPriority.HIGH)
    @SideOnly(Side.CLIENT)
    public static void onWheelEvent(MouseEvent event){
        if(event.getDwheel() == 0){
            return;
        }
    
        Minecraft minecraft = Minecraft.getMinecraft();
        EntityPlayer player = minecraft.player;
        if(player.isSneaking()){
            ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
            Item item = stack.getItem();
            if(item instanceof StandardMetaItem){
                StandardMetaItem metaItem = (StandardMetaItem) item;
                for(IItemBehaviour behaviour : metaItem.getBehaviours(stack)){
                    if(behaviour instanceof IExtendedItemBehavior){
                        IExtendedItemBehavior extendedItemBehavior = (IExtendedItemBehavior) behaviour;
                        if(extendedItemBehavior.canHandleWheelChange()){
                            GCNetworkManager.INSTANCE.sendPacketToServer(new MouseEventToSeverPacker(event.getDwheel()>0));
                            event.setCanceled(true);
                            return;
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onMaterialRegister(GregTechAPI.MaterialEvent event){
        GCOrePrefixs.register();
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
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onClientEvent(TickEvent.ClientTickEvent event){
        GCLangUtil.updateModifier();
    }
}
