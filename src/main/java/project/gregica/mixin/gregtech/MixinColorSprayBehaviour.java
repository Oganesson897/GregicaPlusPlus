package project.gregica.mixin.gregtech;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.common.items.behaviors.ColorSprayBehaviour;
import project.gregica.common.tileentities.mte.multipart.MTELaserHatch;
import project.gregica.common.tileentities.te.TELaserPipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ColorSprayBehaviour.class)
public abstract class MixinColorSprayBehaviour {
    
    @Shadow(remap = false) @Final private EnumDyeColor color;
    
    @Inject(method = "tryPaintBlock",at = @At(value = "HEAD",remap = false),remap = false,cancellable = true)
    public void onTryPaintBlock(EntityPlayer player, World world, BlockPos pos, EnumFacing side, CallbackInfoReturnable<Boolean> cir){
        TileEntity te = world.getTileEntity(pos);
        int colorValue = this.color == null ? -1 : color.ordinal()+1;
        if (te instanceof IGregTechTileEntity) {
            MetaTileEntity mte = ((IGregTechTileEntity) te).getMetaTileEntity();
            if (mte instanceof MTELaserHatch && ((MTELaserHatch) mte).getColor() != colorValue) {
                MTELaserHatch laserHatch = (MTELaserHatch) mte;
                laserHatch.setColor(colorValue);
                cir.setReturnValue(true);
                cir.cancel();
                return;
            }
        }
        if(te instanceof TELaserPipe){
            if(((TELaserPipe) te).getColor() != (colorValue)){
                ((TELaserPipe) te).setColor(colorValue);
                ((TELaserPipe) te).updateConnections(world,pos,true);
                cir.setReturnValue(true);
                cir.cancel();
            }
        }
    }
}
