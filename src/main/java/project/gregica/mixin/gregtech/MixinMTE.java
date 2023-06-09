package project.gregica.mixin.gregtech;

import gregtech.api.metatileentity.MetaTileEntity;
import project.gregica.api.capability.GCCapabilities;
import project.gregica.utils.GCColorUtil;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MetaTileEntity.class)
public abstract class MixinMTE {
    
    @Shadow(remap = false) public abstract boolean isPainted();
    
    @Shadow(remap = false) private int paintingColor;
    
    @Inject(method = "getCapability",at = @At(value = "HEAD",remap = false),remap = false,cancellable = true)
    public <T> void onGetCapability(Capability<T> capability, EnumFacing side, CallbackInfoReturnable<Capability<T>> cir){
        if(this.isPainted() && capability == GCCapabilities.COLOR_CAPABILITY){
            cir.setReturnValue(GCCapabilities.COLOR_CAPABILITY.cast(()-> GCColorUtil.valueToColor.apply(paintingColor)));
            cir.cancel();
        }
    }
}
