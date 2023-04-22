package me.oganesson.gregica.common.tileentities.metatileentity;

import gregtech.api.GTValues;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCValues;
import me.oganesson.gregica.common.tileentities.metatileentity.multipart.MetaTileEntityQubitHatch;
import me.oganesson.gregica.common.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.block.laserpipe.LaserPipeType;
import me.oganesson.gregica.common.tileentities.metatileentity.multi.generators.MetaTileEntityEssentiaGenerator;
import me.oganesson.gregica.common.tileentities.metatileentity.multi.generators.MetaTileEntityIndustrialFishingPond;
import me.oganesson.gregica.common.tileentities.metatileentity.multi.machines.MetaTileEntityLightningRod;
import me.oganesson.gregica.common.tileentities.metatileentity.multi.machines.MetaTileEntityQubitComputer;
import me.oganesson.gregica.common.tileentities.metatileentity.multi.machines.MetaTileEntityResearchStation;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class GCMetaEntities {

    public static MetaTileEntityEssentiaGenerator ESSENTIA_GENERATOR;
    public static MetaTileEntityIndustrialFishingPond INDUSTRIAL_POND;
    public static final MetaTileEntityLightningRod[] LIGHTNING_ROD = new MetaTileEntityLightningRod[4];
    public static MetaTileEntityQubitComputer QUBIT_COMPUTER;
    public static MetaTileEntityQubitHatch[] QBIT_INPUT_HATCH = new MetaTileEntityQubitHatch[GCValues.QUBIT.length];
    public static MetaTileEntityQubitHatch[] QBIT_OUTPUT_HATCH = new MetaTileEntityQubitHatch[GCValues.QUBIT.length];
    public static final BlockLaserPipe[] LASER_PIPES = new BlockLaserPipe[1];
    public static MetaTileEntityResearchStation RESEARCH_STATION;
    public static void register() {
        ESSENTIA_GENERATOR = registerMetaTileEntity(11001, new MetaTileEntityEssentiaGenerator(gcID("essentia_generator")));
        INDUSTRIAL_POND = registerMetaTileEntity(11002, new MetaTileEntityIndustrialFishingPond(gcID("industrial_fishing_pond")));
        LIGHTNING_ROD[0] = registerMetaTileEntity(11003, new MetaTileEntityLightningRod(gcID("lightning_rod.hv"), GTValues.HV));
        LIGHTNING_ROD[1] = registerMetaTileEntity(11004, new MetaTileEntityLightningRod(gcID("lightning_rod.ev"), GTValues.EV));
        LIGHTNING_ROD[2] = registerMetaTileEntity(11005, new MetaTileEntityLightningRod(gcID("lightning_rod.iv"), GTValues.IV));
        QUBIT_COMPUTER = registerMetaTileEntity(11006, new MetaTileEntityQubitComputer(gcID("quantum_computer")));

        QBIT_INPUT_HATCH[0] = registerMetaTileEntity(11007, new MetaTileEntityQubitHatch(gcID("qubit_hatch.input.16"), 0, 16, false));
        QBIT_OUTPUT_HATCH[0] = registerMetaTileEntity(11008, new MetaTileEntityQubitHatch(gcID("qubit_hatch.output.1"), 0, 16, true));

        RESEARCH_STATION = registerMetaTileEntity(11009, new MetaTileEntityResearchStation(gcID("research_station")));
        for (LaserPipeType type : LaserPipeType.values()) {
            LASER_PIPES[type.ordinal()] = new BlockLaserPipe();
            LASER_PIPES[type.ordinal()].setRegistryName(String.format("laser_pipe_%s", type.name));
        }
    }

    private static ResourceLocation gcID(String name) {
        return new ResourceLocation(Gregica.MOD_ID, name);
    }

}
