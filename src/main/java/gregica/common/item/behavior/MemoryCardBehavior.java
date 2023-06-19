package gregica.common.item.behavior;

import gregica.api.data.impl.CWElectricityData;
import gregica.client.gui.TooltipData;
import gregica.client.gui.component.ColorLabel;
import gregica.client.gui.component.RightTextField;
import gregica.client.gui.component.ToggleButtonString;
import gregica.client.gui.proup.IntModeGroup;
import gregica.common.data.CWDataType;
import gregica.common.data.CrossWorldDataHandler;
import gregica.utils.GCColorUtil;
import gregica.utils.GCLangUtil;
import gregica.utils.GCUtil;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.ClickButtonWidget;
import gregtech.api.gui.widgets.LabelWidget;
import gregtech.api.items.gui.ItemUIFactory;
import gregtech.api.items.gui.PlayerInventoryHolder;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.util.GTUtility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MemoryCardBehavior implements IItemBehaviour, ItemUIFactory {
    
    private int channel = 0;
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(!world.isRemote && player.isSneaking()){
            PlayerInventoryHolder holder = new PlayerInventoryHolder(player, hand);
            holder.openUI();
        }
        return IItemBehaviour.super.onItemRightClick(world, player, hand);
    }
    
    @Override
    public ModularUI createUI(PlayerInventoryHolder playerInventoryHolder, EntityPlayer entityPlayer) {
        
        int w = 192;
        int h = 209;
        
        var item = playerInventoryHolder.getCurrentItem();
        var isOP = GCUtil.isOP(entityPlayer);
        if(!item.hasTagCompound()){
            item.setTagCompound(new NBTTagCompound());
        }
        var tag = item.getTagCompound();
        //noinspection ConstantConditions
        AtomicReference<AtomicInteger> channelT = new AtomicReference<>(new AtomicInteger(item.getTagCompound().getInteger("channel")));
        AtomicInteger channelTB = new AtomicInteger(channelT.get().get());
        AtomicBoolean existedChannel = new AtomicBoolean(((CWElectricityData) CrossWorldDataHandler.INSTANCE.getOrCreate(CWDataType.ELECTRICITY)).isExistChannel(channelT.get().get()));
        
        
                //模式选择
        var button1 = new ToggleButtonString(5,20,60,20,
                () -> tag.getInteger("mode") == 0,
                b -> {
                    if(b) {
                        tag.setInteger("mode", 0);
                        item.setTagCompound(tag);
                    }
                },
                "gregica.gui.mode.manual"
        );
        var button2 = new ToggleButtonString(5+61,20,60,20,
                () -> tag.getInteger("mode") == 1,
                b -> {
                    if(b) {
                        tag.setInteger("mode", 1);
                        item.setTagCompound(tag);
                    }
                },
                "gregica.gui.mode.available"
        );
        var button3 = new ToggleButtonString(5+61*2,20,60,20,
                () -> tag.getInteger("mode") == 2,
                b -> {
                    if(b) {
                        tag.setInteger("mode", 2);
                        item.setTagCompound(tag);
                    }
                },
                "gregica.gui.mode.all"
        );
        
        var group = new IntModeGroup(() -> tag.getInteger("mode"),0,40);
        //模式0
        group.addWidget(new LabelWidget(5+30,0,"mode1").setXCentered(true),0);
        group.addWidget(new LabelWidget(5,20,"gregica.gui.channel_to_bind").setYCentered(true).setShadow(true),0);
        group.addWidget(new RightTextField(5+20,10,60,20,true,
                () -> Integer.toHexString(channelTB.get()).toUpperCase(),
                (data) -> channelTB.set(data.isEmpty() ? 0 : Integer.parseInt(data)))
                .setValidator(GCLangUtil.hexIntValidator),0);
        group.addWidget(new ClickButtonWidget(5+20+64,10,40,20,"gregica.gui.set_channel",
                (data) -> {
                        channelT.set(channelTB);
                        var tagN = item.getTagCompound();
                        tagN.setInteger("channel",channelT.get().get());
                        item.setTagCompound(tagN);
                        existedChannel.set(((CWElectricityData) CrossWorldDataHandler.INSTANCE.getOrCreate(CWDataType.ELECTRICITY)).isExistChannel(channelT.get().get()));
                }),0);
        //模式1
        group.addWidget(new LabelWidget(5+61+30,0,"mode2").setXCentered(true),1);
        //模式2
        group.addWidget(new LabelWidget(5+61*2+30,0,"mode3").setXCentered(true),2);
        
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND,w ,h )
                .widget(new LabelWidget(w/2-5,10,"gregica.gui.current_channel", channelT.get().get() ==0?"none":Integer.toString(channelT.get().get(),16))
                        .setXCentered(true))
                .widget(new ColorLabel(w-40,10,10,10,() -> channelT.get().get() == 0 && existedChannel.get() ?
                        GTUtility.convertRGBtoOpaqueRGBA_MC(GCColorUtil.StandardColor.GREEN.getColor()) :
                        GTUtility.convertRGBtoOpaqueRGBA_MC(GCColorUtil.StandardColor.RED.getColor()),
                        new TooltipData(() -> existedChannel.get() ?
                                "gregica.gui.available_channel":"gregica.gui.unavailable_channel")))
                .widget(button1)
                .widget(button2)
                .widget(button3)
                .widget(group);
        return builder.build(playerInventoryHolder,entityPlayer);
    }
    
    
    
    public int getChannel() {
        return channel;
    }
    
    public void setChannel(int channel) {
        this.channel = channel;
        
    }
}
