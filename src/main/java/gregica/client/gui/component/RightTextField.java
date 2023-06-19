package gregica.client.gui.component;

import gregtech.api.gui.resources.IGuiTexture;
import gregtech.api.gui.widgets.TextFieldWidget;
import net.minecraft.client.Minecraft;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class RightTextField extends TextFieldWidget {
    
    public RightTextField(int xPosition, int yPosition, int width, int height, boolean enableBackground, Supplier<String> textSupplier, Consumer<String> textResponder) {
        super(xPosition, yPosition, width, height, enableBackground, textSupplier, textResponder);
    }
    
    public RightTextField(int xPosition, int yPosition, int width, int height, boolean enableBackground, Supplier<String> textSupplier, Consumer<String> textResponder, int maxStringLength) {
        super(xPosition, yPosition, width, height, enableBackground, textSupplier, textResponder, maxStringLength);
    }
    
    public RightTextField(int xPosition, int yPosition, int width, int height, IGuiTexture background, Supplier<String> textSupplier, Consumer<String> textResponder) {
        super(xPosition, yPosition, width, height, background, textSupplier, textResponder);
    }
    
    public void updateTextFieldPos(){
        if(this.gui != null && this.gui.holder != null && isClientSide()){
            var text = getCurrentString();
            var render = Minecraft.getMinecraft().fontRenderer;
            int length = text == null ? 0 : render.getStringWidth(text);
            textField.x = this.getSelfPosition().getX()+this.getSize().width-length;
        }
    }
    
    @Override
    public boolean keyTyped(char charTyped, int keyCode) {
        var rel = super.keyTyped(charTyped, keyCode);
        updateTextFieldPos();
        return rel;
    }
    
    @Override
    protected void onPositionUpdate() {
        super.onPositionUpdate();
        updateTextFieldPos();
    }
    
    @Override
    protected void onSizeUpdate() {
        super.onSizeUpdate();
        updateTextFieldPos();
    }
}
