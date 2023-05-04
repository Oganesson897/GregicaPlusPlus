package me.oganesson.gregica.mixin.gregtech;

import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.metatileentities.steam.boiler.SteamBoiler;
import gregtech.common.metatileentities.steam.boiler.SteamSolarBoiler;
import me.oganesson.gregica.GCConfig;
import me.oganesson.gregica.api.nerf.INerfed;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(SteamSolarBoiler.class)
public abstract class MixinSolarBoiler extends SteamBoiler implements INerfed {
    
    private long timer = 0;
    
    
    @Shadow(remap = false) protected abstract int getBaseSteamOutput();
    
    
    public MixinSolarBoiler(ResourceLocation metaTileEntityId, boolean isHighPressure, ICubeRenderer renderer) {
        super(metaTileEntityId, isHighPressure, renderer);
    }
    
    @Inject(method = "getBaseSteamOutput",at = @At(value = "HEAD",remap = false),remap = false,cancellable = true)
    public void onGetOutput(CallbackInfoReturnable<Integer> cir){
        timer++;
        if(GCConfig.Nerf.enableNerfSteamSolarBoiler){
            long time = getTimer()-2400;
            if(time > 0){
                int base = isHighPressure ? 360 : 120;
                float rank = 1 - Math.min(time/(2400f*10f),2/3f);
                cir.setReturnValue((int) (base*rank));
                cir.cancel();
            }
        }
    }
    
    @Override
    public boolean isNerfed() {
        return GCConfig.Nerf.enableNerfSteamSolarBoiler;
    }
    
    @Override
    public void details(List<String> tooltip) {
        tooltip.add("   "+I18n.format("gregica.mixin.nerf.steam.solar.detail"));
    }
    
    @NotNull
    @Override
    public List<ITextComponent> getDataInfo() {
        List<ITextComponent> result = new ArrayList<>(super.getDataInfo());
        result.add(new TextComponentTranslation("gregica.mixin.info.steam",
                ((MixinSteamBoilerAccess)this).getCurrentTemperature()>100 ? getBaseSteamOutput() : 0));
        result.add(new TextComponentString(String.format("timer: %d",getTimer())));
        return result;
    }
    
    public long getTimer(){
        return timer;
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        NBTTagCompound result =  super.writeToNBT(data);
        result.setLong("MixinTimer",timer);
        return result;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.timer = data.getLong("MixinTimer");
    }
}
