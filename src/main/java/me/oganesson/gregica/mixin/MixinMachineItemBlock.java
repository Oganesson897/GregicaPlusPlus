package me.oganesson.gregica.mixin;

import gregtech.api.block.machines.MachineItemBlock;
import gregtech.api.capability.IMultiblockController;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import me.oganesson.gregica.api.capability.ICreativeOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(MachineItemBlock.class)
public abstract class MixinMachineItemBlock {
    
    @Inject(method = "addInformation",
            at = {@At(value = "RETURN",remap = false)},
            locals = LocalCapture.CAPTURE_FAILSOFT,
            remap = false)
    @SideOnly(Side.CLIENT)
    public void gcppOnAddInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn,
                                     CallbackInfo ci,MetaTileEntity metaTileEntity){
        if(metaTileEntity instanceof IMultiblockController){
            tooltip.add(I18n.format("gregica.mixin.gregtech.itemblock.multiblock_controller"));
        }
        if(metaTileEntity instanceof IMultiblockPart){
            tooltip.add(I18n.format("gregica.mixin.gregtech.itemblock.multiblock_part"));
        }
        if(metaTileEntity instanceof ICreativeOnly){
            tooltip.add(I18n.format("gregica.mixin.gregtech.itemblock.creative_only"));
        }
    
    }
}
