package gregica.client.gui.proup;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import gregtech.api.gui.IRenderContext;
import gregtech.api.gui.Widget;
import gregtech.api.gui.widgets.WidgetGroup;
import gregtech.api.util.Position;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.IntSupplier;

public class IntModeGroup extends WidgetGroup {
    
    private final IntSupplier modeGetter;
    private int mode;
    private final Multimap<Integer,Widget> widgetMultimap = ArrayListMultimap.create();
    
    public IntModeGroup(IntSupplier modeGetter,int x,int y) {
        super(new Position(x,y));
        this.modeGetter = modeGetter;
    }
    
    @Override
    public void addWidget(Widget widget) {
        throw new IllegalArgumentException("not support");
    }
    
    public void addWidget(Widget widget,int mode){
        super.addWidget(widget);
        widgetMultimap.put(mode,widget);
    }
    
    @Override
    public void removeWidget(Widget widget) {
        super.removeWidget(widget);
        boolean toRemove = false;
        int removeMode = 0;
        for(var entry : widgetMultimap.entries()){
            if(entry.getValue() == widget){
                removeMode = entry.getKey();
                toRemove = true;
            }
        }
        if(toRemove){
            widgetMultimap.remove(removeMode,widget);
        }
    }
    
    @Override
    public void clearAllWidgets() {
        super.clearAllWidgets();
        this.widgetMultimap.clear();
    }
    
//    @Override
//    public void updateScreen() {
//        super.updateScreen();
//        var modeNow = modeGetter.getAsInt();
//        if(modeNow != mode){
//            mode = modeNow;
//            for(var entry : widgetMultimap.entries()){
//                entry.getValue().setVisible(entry.getKey().equals(mode));
//            }
//        }
//    }
    
    
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        if(modeGetter.getAsInt() != mode){
            mode = modeGetter.getAsInt();
            for(var entry : widgetMultimap.entries()){
                entry.getValue().setVisible(entry.getKey().equals(mode));
            }
            this.writeUpdateInfo(8, b -> b.writeInt(mode));
        }
    }
    
    @Override
    public void readUpdateInfo(int id, PacketBuffer buffer) {
        super.readUpdateInfo(id, buffer);
        if(id == 8){
            this.mode = buffer.readInt();
        }
    }
    
    public int getMode() {
        return mode;
    }
    
    public void setMode(int mode) {
        this.mode = mode;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void drawInForeground(int mouseX, int mouseY) {
        //super.drawInForeground(mouseX, mouseY);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    
        for (Widget widget : this.widgetMultimap.get(mode)) {
            if (widget.isVisible()) {
                widget.drawInForeground(mouseX, mouseY);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void drawInBackground(int mouseX, int mouseY, float partialTicks, IRenderContext context) {
        //super.drawInBackground(mouseX, mouseY, partialTicks, context);
        GlStateManager.color(this.gui.getRColorForOverlay(), this.gui.getGColorForOverlay(), this.gui.getBColorForOverlay(), 1.0F);
    
        for (Widget widget : this.widgetMultimap.get(mode)) {
            if (widget.isVisible()) {
                widget.drawInBackground(mouseX, mouseY, partialTicks, context);
                GlStateManager.color(this.gui.getRColorForOverlay(), this.gui.getGColorForOverlay(), this.gui.getBColorForOverlay(), 1.0F);
            }
        }
    }
}
