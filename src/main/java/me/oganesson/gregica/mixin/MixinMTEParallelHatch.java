package me.oganesson.gregica.mixin;

import gregicality.multiblocks.common.metatileentities.multiblockpart.MetaTileEntityParallelHatch;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(MetaTileEntityParallelHatch.class)
public class MixinMTEParallelHatch {
    
    @Shadow(remap = false) @Final private int maxParallel;
    
    @Inject(method = "getCurrentParallel",at = @At(value = "HEAD",remap = false),remap = false,cancellable = true)
    public void onConstruction(CallbackInfoReturnable<Integer> cir){
        if(this.maxParallel > 64){
            cir.setReturnValue(64);
            cir.cancel();
        }
    }
    
    @Inject(method = "addInformation",at = @At(value = "RETURN",remap = false),remap = false)
    public void onAddInfo(ItemStack stack, World player, List<String> tooltip, boolean advanced, CallbackInfo ci){
        if(this.maxParallel > 64) tooltip.add(I18n.format("gergica.mixin.parallel.banned"));
    }
}
