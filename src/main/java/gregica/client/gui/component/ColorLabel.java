package gregica.client.gui.component;

import gregica.client.gui.TooltipData;
import gregtech.api.gui.IRenderContext;
import gregtech.api.gui.Widget;
import gregtech.api.util.Position;
import gregtech.api.util.Size;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;
import java.util.function.IntSupplier;

public class ColorLabel extends Widget {
    
    private final IntSupplier colorSupplier;
    private boolean centered;
    
    @Nullable
    private TooltipData tooltip;
    
    
    
    public ColorLabel(int x, int y, int width, int height, IntSupplier colorSupplier,@Nullable TooltipData tooltip){
        this(x,y,width,height,colorSupplier);
        this.tooltip = tooltip;
    }
    
    public ColorLabel(int x, int y, int width, int height, IntSupplier colorSupplier) {
        super(x, y, width, height);
        this.colorSupplier = colorSupplier;
    }
    
    public ColorLabel setCentered(boolean b){
        if(centered != b){
            centered = b;
            
        }
        return this;
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void drawInForeground(int mouseX, int mouseY) {
        super.drawInForeground(mouseX, mouseY);
        if(this.isVisible() && tooltip != null){
            if (this.isMouseOverElement(mouseX, mouseY) && this.tooltip != null){
                tooltip.drawForeground(mouseX,mouseY,this.sizes);
            }
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void drawInBackground(int mouseX, int mouseY, float partialTicks, IRenderContext context) {
        super.drawInBackground(mouseX, mouseY, partialTicks, context);
        if (this.isVisible()) {
            Position pos = this.getPosition();
            Size size = this.getSize();
            int color = colorSupplier.getAsInt();
            float r = (float) (color >> 16 & 255) / 255.0F;
            float g = (float) (color >> 8  & 255) / 255.0F;
            float b = (float) (color       & 255) / 255.0F;
            float a = (float) (color >> 24 & 255) / 255.0F;
    
            GlStateManager.disableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.disableAlpha();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.shadeModel(GL11.GL_SMOOTH);
            
            //GlStateManager.color(r,g,b,a);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
            bufferbuilder.pos(pos.x,pos.y+size.height,0.0).color(r,g,b,a).endVertex();
            bufferbuilder.pos(pos.x+size.width,pos.y+size.height,0.0).color(r,g,b,a).endVertex();
            bufferbuilder.pos(pos.x+size.width,pos.y,0.0).color(r,g,b,a).endVertex();
            bufferbuilder.pos(pos.x,pos.y,0.0).color(r,g,b,a).endVertex();
            tessellator.draw();
    
            GlStateManager.shadeModel(GL11.GL_FLAT);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableTexture2D();
        }
    }
}
