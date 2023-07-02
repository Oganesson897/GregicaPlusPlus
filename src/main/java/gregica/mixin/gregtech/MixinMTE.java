package gregica.mixin.gregtech;

import gregica.api.blocks.IColored;
import gregtech.api.metatileentity.MetaTileEntity;
import gregica.api.capability.GCCapabilities;
import gregica.utils.GCColorUtil;
import gregtech.api.metatileentity.MetaTileEntity;
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
    public <T> void onGetCapability(Capability<T> capability, EnumFacing side, CallbackInfoReturnable<T> cir){
        if(this.isPainted() && capability == GCCapabilities.COLOR_CAPABILITY){
            cir.setReturnValue(GCCapabilities.COLOR_CAPABILITY.cast(() -> GCColorUtil.valueToColor.apply(paintingColor)));
            //() -> GCColorUtil.valueToColor.apply(paintingColor)));
            cir.cancel();
        }
    }
}
