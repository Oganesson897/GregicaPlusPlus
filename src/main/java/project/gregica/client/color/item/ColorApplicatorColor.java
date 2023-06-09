package project.gregica.client.color.item;

import project.gregica.common.item.behavior.ColorApplicatorBehavior;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ColorApplicatorColor implements IItemColor {
    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        if(tintIndex == 1){
            return ColorApplicatorBehavior.currentColorValue(stack);
        }
        return 0;
    }
}
