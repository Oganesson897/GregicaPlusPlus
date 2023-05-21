package me.oganesson.gregica.mixin.forge;

import me.oganesson.gregica.config.GCConfig;
import net.minecraftforge.common.config.ConfigManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ConfigManager.class,remap = false)
public abstract class GCMixinConfigManager {
    
    @Inject(method = "loadData", at = @At(value = "RETURN"), remap = false)
    private static void onLoadMods(CallbackInfo ci){
        GCConfig.configLoaded = true;
    }
}
