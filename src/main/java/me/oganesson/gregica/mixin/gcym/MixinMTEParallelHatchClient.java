package me.oganesson.gregica.mixin.gcym;

import gregicality.multiblocks.common.metatileentities.multiblockpart.MetaTileEntityParallelHatch;
import me.oganesson.gregica.api.nerf.INerfed;
import me.oganesson.gregica.config.GCConfig;
import net.minecraft.client.resources.I18n;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(MetaTileEntityParallelHatch.class)
public abstract class MixinMTEParallelHatchClient implements INerfed {
    
    @Shadow(remap = false) @Final private int maxParallel;
    
    @Override
    public boolean isNerfed() {
        return this.maxParallel > 64 && GCConfig.Nerf.enableNerfGCYMParallelHatch;
    }
    
    @Override
    public void details(List<String> tooltip) {
        tooltip.add("   "+ I18n.format("gergica.mixin.parallel.banned"));
    }
}
