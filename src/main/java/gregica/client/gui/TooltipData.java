package gregica.client.gui;

import com.google.common.base.Preconditions;
import gregtech.api.gui.ISizeProvider;
import gregtech.api.util.GTUtility;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.config.GuiUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class TooltipData {
    
    private Supplier<String> tooltipText;
    private Object[] args;
    
    public TooltipData(Supplier<String> text,Object... args){
        Preconditions.checkNotNull(text, "tooltipText");
        this.tooltipText = text;
        this.args = args;
    }
    
    public TooltipData reset(Supplier<String> text,Object... args){
        Preconditions.checkNotNull(text, "tooltipText");
        this.tooltipText = text;
        this.args = args;
        return this;
    }
    
    @SideOnly(Side.CLIENT)
    public void drawForeground(int mouseX, int mouseY, ISizeProvider size){
        String tooltipHoverString = this.tooltipText.get();
        List<String> hoverList = Arrays.asList(GTUtility.getForwardNewLineRegex().split(I18n.format(tooltipHoverString, args)));
        Minecraft mc = Minecraft.getMinecraft();
        GuiUtils.drawHoveringText(ItemStack.EMPTY,hoverList, mouseX, mouseY, size.getScreenWidth(),size.getScreenHeight(),300, mc.fontRenderer);
        GlStateManager.disableLighting();
    
    }
    
    
}
