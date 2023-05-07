package me.oganesson.gregica.mixin.minecraft;

import gregtech.api.GTValues;
import me.oganesson.gregica.api.blocks.ITiredGlass;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mixin({BlockGlass.class, BlockStainedGlass.class})
@ParametersAreNonnullByDefault
public abstract class MixinBlockGlass extends BlockBreakable implements ITiredGlass {
    protected MixinBlockGlass(Material materialIn, boolean ignoreSimilarityIn) {
        super(materialIn, ignoreSimilarityIn);
    }
    
    @Override
    public void addInformation(@NotNull ItemStack stack, @Nullable World player, List<String> tooltip, @NotNull ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gregica.mixin.info.glass.tier", GTValues.VNF[getGlassTier()]));
    }
    
    @Override
    public int getGlassTier() {
        return 3;
    }
}
