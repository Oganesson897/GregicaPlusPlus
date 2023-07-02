package gregica.client.gui.component;

import gregica.Gregica;
import gregtech.api.gui.IRenderContext;
import gregtech.api.gui.Widget;
import gregtech.api.util.Position;
import gregtech.api.util.Size;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.function.Supplier;

public class DynamicTextLabel extends Widget {
    
    private int color = 4210752;
    private boolean dropShadow;
   
    protected boolean xCentered;
    protected boolean yCentered;
    
    protected String text;
    protected Object[] formatting;
    
    final Supplier<String> stringSupplier;
    final Supplier<Object[]> format;
    
    @SideOnly(Side.CLIENT)
    private String textT;
    
    public DynamicTextLabel(int x, int y, Supplier<String> stringSupplier, Supplier<Object[]> format) {
        super(new Position(x,y), Size.ZERO);
        this.format = format;
        this.stringSupplier = stringSupplier;
        this.text = stringSupplier.get();
        this.formatting = format.get();
        this.textT = I18n.format(this.text,this.formatting);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateScreen() {
        super.updateScreen();
        if(Gregica.clientTimer % 5 == 0){
            this.formatting = format.get();
            this.text = stringSupplier.get();
            if(Gregica.clientTimer != 0){
                this.textT = I18n.format(this.text,this.formatting);
            }
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void drawInBackground(int mouseX, int mouseY, float partialTicks, IRenderContext context) {
        super.drawInBackground(mouseX, mouseY, partialTicks, context);
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        Position pos = this.getPosition();
        int height = fontRenderer.FONT_HEIGHT;
        String resultText = textT;
        int width = fontRenderer.getStringWidth(resultText);
        float x = (float)pos.x - (this.xCentered ? (float)width / 2.0F : 0.0F);
        float y = (float)pos.y - (this.yCentered ? (float)height / 2.0F : 0.0F) + (float)(fontRenderer.FONT_HEIGHT);
        fontRenderer.drawString(resultText, x, y,color,dropShadow);
    }
    
    public int getColor() {
        return color;
    }
    
    public DynamicTextLabel setSelfColor(int color) {
        this.color = color;
        return this;
    }
    
    public boolean isDropShadow() {
        return dropShadow;
    }
    
    public DynamicTextLabel setDropShadow(boolean dropShadow) {
        this.dropShadow = dropShadow;
        return this;
    }
    
    public boolean isxCentered() {
        return xCentered;
    }
    
    public void setxCentered(boolean xCentered) {
        this.xCentered = xCentered;
    }
    
    public boolean isyCentered() {
        return yCentered;
    }
    
    public DynamicTextLabel setyCentered(boolean yCentered) {
        this.yCentered = yCentered;
        return this;
    }
    
    
}
