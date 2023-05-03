package me.oganesson.gregica.mixin.gcym;

import gregicality.multiblocks.common.metatileentities.multiblockpart.MetaTileEntityParallelHatch;
import me.oganesson.gregica.GCConfig;
import me.oganesson.gregica.api.nerf.INerfed;
import net.minecraft.client.resources.I18n;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(MetaTileEntityParallelHatch.class)
public abstract class MixinMTEParallelHatch implements INerfed {
    
    @Shadow(remap = false) @Final private int maxParallel;
    
    @Inject(method = "getCurrentParallel",at = @At(value = "HEAD",remap = false),remap = false,cancellable = true)
    public void onConstruction(CallbackInfoReturnable<Integer> cir){
        if(this.maxParallel > 64 && GCConfig.Nerf.enableNerfGCYMParallelHatch){
            cir.setReturnValue(64);
            cir.cancel();
        }
    }
    
//    @Inject(method = "addInformation",at = @At(value = "RETURN",remap = false),remap = false)
//    public void onAddInfo(ItemStack stack, World player, List<String> tooltip, boolean advanced, CallbackInfo ci){
//        //if(this.maxParallel > 64) tooltip.add(I18n.format("gergica.mixin.parallel.banned"));
//    }
    
    @Override
    public boolean isNerfed() {
        return this.maxParallel > 64 && GCConfig.Nerf.enableNerfGCYMParallelHatch;
    }
    
    @Override
    public void details(List<String> tooltip) {
        tooltip.add("   "+I18n.format("gergica.mixin.parallel.banned"));
    }
}
