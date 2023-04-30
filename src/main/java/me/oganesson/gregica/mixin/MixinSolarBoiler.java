package me.oganesson.gregica.mixin;

import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.metatileentities.steam.boiler.SteamBoiler;
import gregtech.common.metatileentities.steam.boiler.SteamSolarBoiler;
import me.oganesson.gregica.GCConfig;
import me.oganesson.gregica.api.nerf.INerfed;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(SteamSolarBoiler.class)
public abstract class MixinSolarBoiler extends SteamBoiler implements INerfed {
    
    
    public MixinSolarBoiler(ResourceLocation metaTileEntityId, boolean isHighPressure, ICubeRenderer renderer) {
        super(metaTileEntityId, isHighPressure, renderer);
    }
    
    @Inject(method = "getBaseSteamOutput",at = @At(value = "HEAD",remap = false),remap = false,cancellable = true)
    public void onGetOutput(CallbackInfoReturnable<Integer> cir){
        if(GCConfig.nerf.enableNerfSteamSolarBoiler){
            long time = getOffsetTimer()-24000;
            if(time > 0){
                int base = isHighPressure ? 360 : 120;
                float rank = 1 - Math.min(time/24000f*10f,2/3f);
                cir.setReturnValue((int) (base*rank));
                cir.cancel();
            }
        }
    }
    
    @Override
    public boolean isNerfed() {
        return true;
    }
    
    @Override
    public void details(List<String> tooltip) {
        tooltip.add("   "+I18n.format("gregica.mixin.nerf.steam.solar.detail"));
    }
}
