package me.oganesson.gregica.common.gregtech;

import gregtech.api.GTValues;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.common.gregtech.metatileentity.MetaTileEntityEssentiaGenerator;
import me.oganesson.gregica.common.gregtech.metatileentity.MetaTileEntityIndustrialFishingPond;
import me.oganesson.gregica.common.gregtech.metatileentity.MetaTileEntityLightningRod;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class GCMetaEntities {

    public static MetaTileEntityEssentiaGenerator ESSENTIA_GENERATOR;
    public static MetaTileEntityIndustrialFishingPond INDUSTRIAL_POND;
    public static final MetaTileEntityLightningRod[] LIGHTNING_ROD = new MetaTileEntityLightningRod[4];

    public static void register() {
        ESSENTIA_GENERATOR = registerMetaTileEntity(11001, new MetaTileEntityEssentiaGenerator(gcID("essentia_generator")));
        INDUSTRIAL_POND = registerMetaTileEntity(11002, new MetaTileEntityIndustrialFishingPond(gcID("industrial_fishing_pond")));
        LIGHTNING_ROD[0] = registerMetaTileEntity(11003, new MetaTileEntityLightningRod(gcID("lightning_rod.hv"), GTValues.HV));
        LIGHTNING_ROD[1] = registerMetaTileEntity(11004, new MetaTileEntityLightningRod(gcID("lightning_rod.ev"), GTValues.EV));
        LIGHTNING_ROD[2] = registerMetaTileEntity(11005, new MetaTileEntityLightningRod(gcID("lightning_rod.iv"), GTValues.IV));
    }

    private static ResourceLocation gcID(String name) {
        return new ResourceLocation(Gregica.MOD_ID, name);
    }

}
