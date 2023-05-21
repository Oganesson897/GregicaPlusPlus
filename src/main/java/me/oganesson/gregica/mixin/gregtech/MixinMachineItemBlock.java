package me.oganesson.gregica.mixin.gregtech;

import gregtech.api.block.machines.MachineItemBlock;
import gregtech.api.capability.IMultiblockController;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.client.utils.TooltipHelper;
import me.oganesson.gregica.api.capability.ICreativeOnly;
import me.oganesson.gregica.api.nerf.INerfed;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(MachineItemBlock.class)
public abstract class MixinMachineItemBlock {
    
    @Inject(method = "addInformation",
            at = {@At(value = "INVOKE",
                    shift = At.Shift.AFTER,
                    target = "Lgregtech/api/metatileentity/MetaTileEntity;addInformation(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Ljava/util/List;Z)V",
                    remap = false)},
            locals = LocalCapture.CAPTURE_FAILSOFT)
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
        if(metaTileEntity instanceof INerfed){
            INerfed mte = (INerfed) metaTileEntity;
            if(mte.isNerfed()){
                tooltip.add(I18n.format("gregica.mixin.gregtech.itemblock.nerfed"));
                if(TooltipHelper.isShiftDown()) mte.details(tooltip);
            }
           
        }
        if(metaTileEntity.getMetaName().contains("gregica")){
            tooltip.add(I18n.format("gregica.mixin.gregica"));
        }
        
        if(metaTileEntity.getMetaName().contains("gcys")){
            tooltip.add(I18n.format("gregica.mixin.gcys"));
        }
    
    }
}
