package gregica.common.item.behavior;

import gregica.api.data.impl.CWElectricityData;
import gregica.client.GCTextures;
import gregica.client.gui.TooltipData;
import gregica.client.gui.component.*;
import gregica.client.gui.proup.ChannelLabelGroup;
import gregica.client.gui.proup.IntModeGroup;
import gregica.common.data.CWDataType;
import gregica.common.data.CrossWorldDataHandler;
import gregica.common.data.data.ElectricityData;
import gregica.utils.GCColorUtil;
import gregica.utils.GCLangUtil;
import gregica.utils.GCUtil;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.Widget;
import gregtech.api.gui.widgets.LabelWidget;
import gregtech.api.gui.widgets.TextFieldWidget;
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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryCardBehavior implements IItemBehaviour, ItemUIFactory {
    
    
    private static CWElectricityData data;
    private int channel = 0;
    private int bind_mode = -1;
    
    private int mode = 0;
    
    private boolean channel_existed = false;
    
    private final Context context = new Context();
    
    
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
        
        if(data == null){
            data = CrossWorldDataHandler.INSTANCE.getOrCreate(CWDataType.ELECTRICITY);
        }
        
        int w = 209;
        int h = 242;
        
        var item = playerInventoryHolder.getCurrentItem();
        var canEdit = GCUtil.isOP(entityPlayer) || entityPlayer.isCreative();
        if(!item.hasTagCompound()){
            item.setTagCompound(new NBTTagCompound());
        }
        var tag = item.getTagCompound();
        var uuid = entityPlayer.getUniqueID();
        
        //AtomicInteger channelT = new AtomicInteger(item.getTagCompound().getInteger("channel"));
        
        //noinspection ConstantConditions
        channel = item.getTagCompound().getInteger("channel");
        //noinspection ConstantConditions
        mode = tag.getInteger("mode");
        AtomicInteger channelTB = new AtomicInteger(channel);
        channel_existed = data.isExistChannel(channel);
        bind_mode = channel_existed ? item.getTagCompound().getInteger("bind_mode") : -1;
        
        
        //模式选择
        var button1 = new ToggleButtonString(10,30,60,20,
                () -> tag.getInteger("mode") == 0,
                b -> {
                    if(b) {
                        mode = 0;
                        item.setTagCompound(updateTag(tag));
                    }
                },
                "gregica.gui.mode.manual"
        );
        var button2 = new ToggleButtonString(10+62,30,60,20,
                () -> tag.getInteger("mode") == 1,
                b -> {
                    if(b) {
                        mode = 1;
                        item.setTagCompound(updateTag(tag));
                    }
                },
                "gregica.gui.mode.available"
        );
        var button3 = new ToggleButtonString(10+62*2,30,60,20,
                () -> tag.getInteger("mode") == 2,
                b -> {
                    if(b) {
                        mode = 2;
                        item.setTagCompound(updateTag(tag));
                    }
                },
                "gregica.gui.mode.all"
        );
        
        var group = new IntModeGroup(() ->
                //tag.getInteger("mode")
                mode
                ,0,50);
        group.setUpdater( () -> {
                    if(context.needUpdate){
                        context.needUpdate = false;
                        for(Widget widget : group.widgets){
                            if(widget instanceof ChannelList list){
                                list.reAddLabel();
                            }
                        }
                    }
                });
        //模式0 创建频道(仅创造)
        group.addWidget(new LabelWidget(5+30,0,"mode1").setXCentered(true),0);
        group.addWidget(new LabelWidget(5,20,"gregica.gui.channel_to_bind").setYCentered(true).setShadow(true),0);
        group.addWidget(new TextFieldWidget(5+25,10,70,20,true,
                () -> Integer.toHexString(channelTB.get()).toUpperCase(),
                (data) -> channelTB.set(data.isEmpty() ? 0 : Integer.parseInt(data,16)))
                .setValidator(GCLangUtil.hexIntValidator)
                ,0);
        group.addWidget(new GCClickButton(5+25+74,10,70,20,"gregica.gui.set_channel",
                (d) -> {
                        channel = channelTB.get();
                        if ( bind_mode == 0 && !data.isExistChannel(channel)) {
                            data.createNewChannel(channel, entityPlayer.getUniqueID());
                        }
                        context.needUpdate = true;
                        channel_existed = data.isExistChannel(channel);
                        item.setTagCompound(updateTag(tag));
                 })
                        .setDisabled(!canEdit)
                        .setTooltipText("gregica.gui.create_or_op")
                        .setButtonTexture(GCTextures.BUTTON)
                        
                ,0);
            //电网模式选择
        group.addWidget(new LabelWidget(5,50,"gregica.gui.channel_mode_choose")
                .setYCentered(true)
                .setShadow(true),0);
        group.addWidget(new ToggleButtonString(w-120,40,60,20,
                () -> bind_mode == 0 ,
                (b) -> {
                    if(b){
                        bind_mode = 0;
                        item.setTagCompound(updateTag(tag));
                    }
                },"gregica.gui.cross_world_electricity"
                ),0);
        //模式1 可用频道
        group.addWidget(new LabelWidget(5+61+30,0,"mode2").setXCentered(true),1);
        var scrollableList1 = new ChannelList(5,10,w-10,140);
        scrollableList1.setLabelAdder((self) -> {
            self.clearWidget();
            for(ElectricityData eData : data.getAllData()){
                if(eData.getOwners().contains(uuid)){
                    self.addWidget(new ChannelLabelGroup(eData.getChannel(),w-15,50,canEdit,channel != eData.getChannel(),uuid,
                            (cd) -> {
                                channel = eData.getChannel();
                                channel_existed = data.isExistChannel(channel);
                                context.needUpdate = true;
                                item.setTagCompound(updateTag(tag));
                            },
                            (cd) -> {
                                context.contextChannel = eData.getChannel();
                                context.oldMode = 1;
                                mode = 3;
                        },
                            (cd) -> {
                                context.contextChannel = eData.getChannel();
                                context.oldMode = 1;
                                mode = 4;
                                },context
                    ));
                }
            }
        });
        group.addWidget(scrollableList1,1);
        
        //模式2 所有频道
        group.addWidget(new LabelWidget(5+61*2+30,0,"mode3").setXCentered(true),2);
        var scrollableList2 = new ChannelList(5,10,w-10,140);
        scrollableList2.setLabelAdder((self) -> {
            self.clearWidget();
            for(ElectricityData eData : data.getAllData()){
                self.addWidget(new ChannelLabelGroup(eData.getChannel(),w-15,50,canEdit,
                        channel != eData.getChannel() && eData.getOwners().contains(uuid),uuid,
                        (cd) -> {
                            channel = eData.getChannel();
                            channel_existed = data.isExistChannel(channel);
                            context.needUpdate = true;
                            item.setTagCompound(updateTag(tag));
                        },
                        (cd) -> {
                            context.contextChannel = eData.getChannel();
                            context.oldMode = 2;
                            mode = 3;
                        },
                        (cd) -> {
                            context.contextChannel = eData.getChannel();
                            context.oldMode = 2;
                            mode = 4;
                        },context
                ));
            }
        });
        group.addWidget(scrollableList2,2);
        
        //模式3 邀请
        group.addWidget(new LabelWidget(20,20,"gregica.gui.invite"),3);
        group.addWidget(new GCClickButton(w-30-5,25,30,20,"gregica.gui.cancel",
                (d) -> {
                    mode = context.oldMode;
                    context.oldMode = 0;
                    item.setTagCompound(updateTag(tag));
                }
                ),3);
        var textField = new TextFieldWidget(5+25,10,70,20,true,
                () -> "",
                (s) -> {
                
                });
        group.addWidget(new GCClickButton(w-60-10,25,30,20,"gregica.gui.confirm",
                (d) -> {
                    var text = textField.getCurrentString();
                    try {
                        var newUUID = UUID.fromString(text);
                        var eData = data.getElectricityData(context.contextChannel);
                        if(eData != null){
                            eData.addOwner(newUUID);
                        }
                    } catch (Exception ignored){
                    
                    }
                    mode = context.oldMode;
                    context.oldMode = 0;
                    item.setTagCompound(updateTag(tag));
                }),3);
        group.addWidget(textField,3);
        
        //模式4 删除
        group.addWidget(new GCClickButton(w-30-5,25,30,20,"gregica.gui.cancel",
                (d) -> {
                    mode = context.oldMode;
                    context.oldMode = 0;
                    item.setTagCompound(updateTag(tag));
                }
        ),4);
        group.addWidget(new GCClickButton(w-60-10,25,30,20,"gregica.gui.confirm",
                (d) -> {
                    data.deleteChannel(context.contextChannel);
                    mode = context.oldMode;
                    context.oldMode = 0;
                    item.setTagCompound(updateTag(tag));
                }).setTextColor(GCColorUtil.StandardColor.RED.getColor()),4);
        
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND,w ,h )
                //当前频道
                .widget(
                        new DynamicTextLabel(25,5,
                                () -> "gregica.gui.current_channel",
                                () -> new Object[]{
                                   channel == 0 ? "none" : Integer.toString(channel,16).toUpperCase()
                            })
                                .setyCentered(true)
                                //.setDropShadow(true)
                                //.setSelfColor(GCColorUtil.StandardColor.RED.getColor())
                                )
                .widget(new ColorLabel(w-40,10,10,10,() -> channel_existed && channel != 0 ?
                        GTUtility.convertRGBtoOpaqueRGBA_MC(GCColorUtil.StandardColor.GREEN.getColor()) :
                        GTUtility.convertRGBtoOpaqueRGBA_MC(GCColorUtil.StandardColor.RED.getColor()),
                        new TooltipData(() -> channel_existed ?
                                "gregica.gui.available_channel":"gregica.gui.unavailable_channel")))
                .widget(new DynamicTextLabel(25,15,() -> switch (bind_mode){
                    case 1 -> "";
                    case 0 -> "gregica.gui.current_mode0";
                    default -> "gregica.gui.current_mode";
                },() -> GCLangUtil.NONE_ARRAY)
                        .setyCentered(true)
                        //.setDropShadow(true)
                )
                //UUID
                .widget(new LabelWidget(5,h-40,"gregica.gui.uuid",entityPlayer.getUniqueID().toString()))
                .widget(new GCClickButton(w-40,h-30,30,20,"gregica.gui.copy",
                        (data) ->
                                Toolkit.getDefaultToolkit().getSystemClipboard()
                                        .setContents(new StringSelection(entityPlayer.getUniqueID().toString()),null))
                        .setButtonTexture(GCTextures.BUTTON))
                .widget(button1)
                .widget(button2)
                .widget(button3)
                .widget(group);
        return builder.build(playerInventoryHolder,entityPlayer);
    }
    
    private NBTTagCompound updateTag(NBTTagCompound tag){
        tag.setInteger("channel",channel);
        tag.setInteger("mode",mode);
        tag.setInteger("bind_mode",bind_mode);
        return tag;
    }
    
    
    
    public int getChannel() {
        return channel;
    }
    
    public void setChannel(int channel) {
        this.channel = channel;
    }
    
    public static class Context{
        public int contextChannel;
        public boolean needUpdate = false;
        
        public int oldMode = 0;
    }
}
