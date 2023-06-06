package me.oganesson.gregica;

import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.loaders.recipe.CraftingComponent;
import me.oganesson.gregica.api.item.IExtendedItemBehavior;
import me.oganesson.gregica.api.unification.OrePrefixAdditions;
import me.oganesson.gregica.api.unification.materials.GCYSMaterials;
import me.oganesson.gregica.api.unification.materials.properties.GCYSMaterialPropertyAddition;
import me.oganesson.gregica.common.recipes.GCYSMaterialInfoLoader;
import me.oganesson.gregica.common.recipes.component.GCYSCraftingComponent;
import me.oganesson.gregica.common.unification.materials.GCMaterials;
import me.oganesson.gregica.common.unification.materials.ore.GCOrePrefixs;
import me.oganesson.gregica.network.GCNetworkManager;
import me.oganesson.gregica.network.packets.MouseEventToSeverPacker;
import me.oganesson.gregica.utils.GCLangUtil;
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
