package gregica.client.gui.component;

import gregica.client.GCTextures;
import gregtech.api.gui.IRenderContext;
import gregtech.api.gui.widgets.ToggleButtonWidget;
import gregtech.api.util.Position;
import gregtech.api.util.Size;
import gregtech.api.util.function.BooleanConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.BooleanSupplier;

public class ToggleButtonString extends ToggleButtonWidget {
    
    private String displayString;
  
    private int textColor = 16777215;
    
    public ToggleButtonString(int xPosition, int yPosition, int width, int height,
                              BooleanSupplier isPressedCondition, BooleanConsumer setPressedExecutor
                                ,String text) {
        super(xPosition, yPosition, width, height, GCTextures.BUTTON, isPressedCondition, setPressedExecutor);
        this.displayString = text;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void drawInBackground(int mouseX, int mouseY, float partialTicks, IRenderContext context) {
        super.drawInBackground(mouseX, mouseY, partialTicks, context);
        if(this.displayString != null) {
            Position position = this.getPosition();
            Size size = this.getSize();
            FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
            String text = I18n.format(this.displayString);
            fontRenderer.drawString(text, position.x + size.width / 2 - fontRenderer.getStringWidth(text) / 2, position.y + size.height / 2 - fontRenderer.FONT_HEIGHT / 2, this.textColor);
        }
    }
    
    public String getDisplayString() {
        return displayString;
    }
    
    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }
    
    public int getTextColor() {
        return textColor;
    }
    
    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
    
}
