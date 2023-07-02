package gregica.client.gui.proup;

import gregica.api.data.impl.CWElectricityData;
import gregica.client.gui.component.GCClickButton;
import gregica.common.data.CWDataType;
import gregica.common.data.CrossWorldDataHandler;
import gregica.common.item.behavior.MemoryCardBehavior;
import gregica.utils.GCColorUtil;
import gregica.utils.GCRenderUtil;
import gregtech.api.gui.IRenderContext;
import gregtech.api.gui.widgets.LabelWidget;
import gregtech.api.gui.widgets.WidgetGroup;

import java.util.UUID;
import java.util.function.Consumer;

public class ChannelLabelGroup extends WidgetGroup {
    
    private static CWElectricityData data;
    
    private final int channel;
    private int w,h;
    
    
    public ChannelLabelGroup(int channel, int w, int h, boolean canEdit, boolean canChoose, UUID opener,
                             Consumer<ClickData> chooseChannel, Consumer<ClickData> displayInviteUI, Consumer<ClickData> displayDeleteUI,
                             MemoryCardBehavior.Context context) {
        this.channel = channel;
        this.w = w;
        this.h = h;
        
        if(data == null){
            data = CrossWorldDataHandler.INSTANCE.getOrCreate(CWDataType.ELECTRICITY);
        }
        var eData = data.getElectricityData(channel);
        
        if(eData != null){
            var label1 = new LabelWidget(3,3,"gregica.gui.channel",Integer.toString(channel,16).toUpperCase());
            var label2 = new LabelWidget(w-80,3,channelDescription(channel));
            var label3 = new LabelWidget(3,h-10,"gregica.gui.channel_owner_count",Integer.toString(eData.getOwners().size()));
            
            var button0 = new GCClickButton(w-120-20,h-30,30,20,"gregica.gui.channel_choose",
                    chooseChannel).setDisabled(!canChoose);
            var button1 = new GCClickButton(w-90-15,h-30,30,20,"gregica.gui.channel_invite",
                    displayInviteUI)
                    .setDisabled(!eData.getOwners().contains(opener));
            var button2 = new GCClickButton(w-60-10,h-30,30,20,"gregica.gui.channel_join",
                    (d) -> {
                        eData.addOwner(opener);
                        context.needUpdate = true;
                    }).setDisabled(!canEdit || eData.getOwners().contains(opener));
            var button3 = new GCClickButton(w-30-5,h-30,30,20,"gregica.gui.channel_delete",
                    displayDeleteUI).setDisabled(!canEdit).setTextColor(GCColorUtil.StandardColor.RED.getColor());
            
            this.addWidget(label1);
            this.addWidget(label2);
            this.addWidget(label3);
            this.addWidget(button0);
            this.addWidget(button1);
            this.addWidget(button2);
            this.addWidget(button3);
        }
        
        
    }
    
    
    @Override
    public void drawInBackground(int mouseX, int mouseY, float partialTicks, IRenderContext context) {
        int x = this.getPosition().x;
        int y = this.getPosition().y;
        GCRenderUtil.drawRect(x,y,w,h,210,220,225,255);
        GCRenderUtil.drawRect(x+1,y+1,w-2,h-2,114,120,139,255);
        super.drawInBackground(mouseX, mouseY, partialTicks, context);
    }
    
    public int getChannel() {
        return channel;
    }
    
    public static String channelDescription(int channel){
        if(data.isExistChannel(channel)){
            return "gregica.gui.current_mode0";
        }
        return "gregica.gui.current_mode";
    }
}
