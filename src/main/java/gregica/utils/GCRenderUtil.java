package gregica.utils;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class GCRenderUtil {
    
    public static void drawRect(int x,int y,int w,int h,int r,int g,int b,int a){
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
    
        //GlStateManager.color(r,g,b,a);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos(x,y+h,0.0).color(r,g,b,a).endVertex();
        bufferbuilder.pos(x+w,y+h,0.0).color(r,g,b,a).endVertex();
        bufferbuilder.pos(x+w,y,0.0).color(r,g,b,a).endVertex();
        bufferbuilder.pos(x,y,0.0).color(r,g,b,a).endVertex();
        tessellator.draw();
    
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
}
