package project.gregica.mixin.gregtech;

import gregtech.common.metatileentities.steam.boiler.SteamSolarBoiler;
import project.gregica.api.nerf.INerfed;
import project.gregica.config.GCConfig;
import net.minecraft.client.resources.I18n;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(SteamSolarBoiler.class)
public abstract class MixinSolarBoilerClient implements INerfed {
    
    @Override
    public boolean isNerfed() {
        return GCConfig.Nerf.enableNerfSteamSolarBoiler;
    }
    
    @Override
    public void details(List<String> tooltip) {
        tooltip.add("   "+ I18n.format("gregica.mixin.nerf.steam.solar.detail"));
    }
}
