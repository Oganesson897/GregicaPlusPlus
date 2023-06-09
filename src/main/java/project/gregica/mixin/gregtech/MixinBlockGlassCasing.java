package project.gregica.mixin.gregtech;

import gregtech.api.GTValues;
import gregtech.api.block.VariantActiveBlock;
import gregtech.common.blocks.BlockGlassCasing;
import project.gregica.api.blocks.ITiredGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(BlockGlassCasing.class)
public abstract class MixinBlockGlassCasing extends VariantActiveBlock<BlockGlassCasing.CasingType> {
    
    public MixinBlockGlassCasing(Material materialIn) {
        super(materialIn);
    }
    @Override
    public void addInformation(@NotNull ItemStack stack, @Nullable World player, List<String> tooltip, @NotNull ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        int tier = ((ITiredGlass)(Object)getState(stack)).getGlassTier();
        tooltip.add(I18n.format("gregica.mixin.info.glass.tier", GTValues.VNF[tier]));
    }
}
