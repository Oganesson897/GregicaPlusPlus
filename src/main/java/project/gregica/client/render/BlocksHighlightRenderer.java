package project.gregica.client.render;

import gregtech.client.utils.RenderBufferHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlocksHighlightRenderer {
    private static final Map<BlockPos,Long> needRender = new HashMap<>();
    private static final List<BlockPos> needRemove = new ArrayList<>();
    
    public static void renderBlockBoxHighLight(BlockPos blockpos, long durTimeMillis) {
        needRender.putIfAbsent(blockpos,durTimeMillis+System.currentTimeMillis());
    }
    
    public static void renderWorldLastEvent(RenderWorldLastEvent evt) {
        if (!needRender.isEmpty()) {
            long time = System.currentTimeMillis();
//            if (time > hlEndTime) {
//                posHighLight = null;
//                hlEndTime = 0L;
//                return;
//            }
    
            if ((time / 500L & 1L) == 0L) {
                return;
            }
            for (BlockPos posHighLight : needRender.keySet()) {
                if(time >= needRender.get(posHighLight)){
                    needRemove.add(posHighLight);
                    continue;
                }
                EntityPlayerSP p = Minecraft.getMinecraft().player;
                double doubleX = p.lastTickPosX + (p.posX - p.lastTickPosX) * (double) evt.getPartialTicks();
                double doubleY = p.lastTickPosY + (p.posY - p.lastTickPosY) * (double) evt.getPartialTicks();
                double doubleZ = p.lastTickPosZ + (p.posZ - p.lastTickPosZ) * (double) evt.getPartialTicks();
                GlStateManager.pushMatrix();
                GlStateManager.color(1.0F, 0.0F, 0.0F);
                GlStateManager.translate(-doubleX, -doubleY, -doubleZ);
                GlStateManager.disableDepth();
                GlStateManager.disableTexture2D();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 1);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder buffer = tessellator.getBuffer();
                buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
                RenderBufferHelper.renderCubeFace(buffer, posHighLight.getX(), posHighLight.getY(), posHighLight.getZ(), posHighLight.getX() + 1, posHighLight.getY() + 1, posHighLight.getZ() + 1, 1.0F, 0.0F, 0.0F, 0.8F);
                tessellator.draw();
                GlStateManager.blendFunc(770, 771);
                GlStateManager.disableBlend();
                GlStateManager.enableTexture2D();
                GlStateManager.enableDepth();
                GlStateManager.color(1.0F, 1.0F, 1.0F);
                GlStateManager.popMatrix();
            }
        }
        for(BlockPos pos : needRemove) {
            needRender.remove(pos);
        }
        needRemove.clear();
    }
}
