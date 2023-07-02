package gregica.client.gui.component;

import gregica.client.GCTextures;
import gregtech.api.gui.IRenderContext;
import gregtech.api.gui.resources.SizedTextureArea;
import gregtech.api.gui.widgets.ClickButtonWidget;
import gregtech.api.util.Position;
import gregtech.api.util.Size;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;

import java.util.function.Consumer;

public class GCClickButton extends ClickButtonWidget {
    
    private int drawDown = 0;
    
    private boolean disabled = false;
    
    public GCClickButton(int xPosition, int yPosition, int width, int height, String displayText, Consumer<ClickData> onPressed) {
        super(xPosition, yPosition, width, height, displayText, onPressed);
        this.setButtonTexture(GCTextures.BUTTON);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        if(drawDown >= 0){
            drawDown--;
        }
    }
    
    @Override
    public void drawInBackground(int mouseX, int mouseY, float partialTicks, IRenderContext context) {
        if (this.shouldDisplay.get()) {
            Position position = this.getPosition();
            Size size = this.getSize();
            if(disabled){
                GlStateManager.color(200F/255,200F/255,200F/255,80F/255);
            }
            if (this.buttonTexture instanceof SizedTextureArea) {
                ((SizedTextureArea)this.buttonTexture).drawHorizontalCutSubArea(position.x, position.y, size.width, size.height, drawDown>=0 || disabled ? 0.5 : 0.0, 0.5);
            } else {
                this.buttonTexture.drawSubArea(position.x, position.y, size.width, size.height, 0.0, 0.0, 1.0, 1.0);
            }
            GlStateManager.color(1f,1f,1f,1f);
        
            FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
            String text = I18n.format(this.displayText);
            fontRenderer.drawString(text, position.x + size.width / 2 - fontRenderer.getStringWidth(text) / 2, position.y + size.height / 2 - fontRenderer.FONT_HEIGHT / 2, this.textColor);
        }
    }
    
    @Override
    protected void triggerButton() {
        if(disabled) return;
        super.triggerButton();
        drawDown = 2;
        
    }
    
    public boolean isDisabled() {
        return disabled;
    }
    
    public GCClickButton setDisabled(boolean disabled) {
        this.disabled = disabled;
        return this;
    }
}
