package project.gregica.mixin.gregtech;

import gregtech.common.metatileentities.steam.boiler.SteamBoiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SteamBoiler.class)
public interface MixinSteamBoilerAccess {
    @Accessor(value = "currentTemperature",remap = false)
    int getCurrentTemperature();
}
