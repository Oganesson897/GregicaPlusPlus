package me.oganesson.gregica.crossmod.top.provider;

import gregtech.integration.theoneprobe.provider.CapabilityInfoProvider;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.blocks.IColored;
import me.oganesson.gregica.api.capability.GCCapabilities;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.capabilities.Capability;
import org.jetbrains.annotations.NotNull;

public class ColorProvider extends CapabilityInfoProvider<IColored> {
    @NotNull
    @Override
    protected Capability<IColored> getCapability() {
        return GCCapabilities.COLOR_CAPABILITY;
    }
    
    @Override
    protected void addProbeInfo(IColored iColored, IProbeInfo iProbeInfo, EntityPlayer entityPlayer, TileEntity tileEntity, IProbeHitData iProbeHitData) {
        iProbeInfo.text(iColored.getStandardColor().getChatColor()+iColored.getStandardColor().getI18NKey());
    }
    
    @Override
    public String getID() {
        return Gregica.MOD_ID+":colored_block_provider";
    }
}
