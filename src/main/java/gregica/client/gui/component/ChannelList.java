package gregica.client.gui.component;

import gregtech.api.gui.widgets.ScrollableListWidget;
import gregtech.api.util.Position;

import java.util.function.Consumer;

public class ChannelList extends ScrollableListWidget {
    
    private Consumer<ChannelList> addChannelLabel;
    public ChannelList(int xPosition, int yPosition, int width, int height) {
        super(xPosition, yPosition, width, height);
    }
    
    public ChannelList setLabelAdder(Consumer<ChannelList> addChannelLabel){
        this.addChannelLabel = addChannelLabel;
        reAddLabel();
        return this;
    }
    
    public void reAddLabel(){
        addChannelLabel.accept(this);
    }
    
    public void clearWidget(){
        if(this.widgets.isEmpty()) return;
        for(var widget : widgets){
            widget.setUiAccess(null);
            widget.setGui(null);
            widget.setSizes(null);
            widget.setParentPosition(Position.ORIGIN);
        }
        this.widgets.clear();
        this.recomputeSize();
        if (this.uiAccess != null) {
            this.uiAccess.notifyWidgetChange();
        }
    }
    
}
