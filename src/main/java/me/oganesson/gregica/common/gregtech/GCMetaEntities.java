package me.oganesson.gregica.common.gregtech;

import gregtech.api.GTValues;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCValues;
import me.oganesson.gregica.common.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.block.laserpipe.LaserPipeType;
import me.oganesson.gregica.common.tileentities.mte.multi.generators.MTEEssentiaGenerator;
import me.oganesson.gregica.common.tileentities.mte.multi.generators.MTEIndustrialFishingPond;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTEAlgaeFarm;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTELightningRod;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTEQubitComputer;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTEResearchStation;
import me.oganesson.gregica.common.tileentities.mte.multipart.MTEQubitHatch;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class GCMetaEntities {

    public static MTEEssentiaGenerator ESSENTIA_GENERATOR;
    public static MTEIndustrialFishingPond INDUSTRIAL_POND;
    public static final MTELightningRod[] LIGHTNING_ROD = new MTELightningRod[4];
    public static MTEQubitComputer QUBIT_COMPUTER;
    public static MTEQubitHatch[] QBIT_INPUT_HATCH = new MTEQubitHatch[GCValues.QUBIT.length];
    public static MTEQubitHatch[] QBIT_OUTPUT_HATCH = new MTEQubitHatch[GCValues.QUBIT.length];
    public static final BlockLaserPipe[] LASER_PIPES = new BlockLaserPipe[1];
    public static MTEResearchStation RESEARCH_STATION;
    public static MTEAlgaeFarm ALGAE_FARM;
    public static void register() {
        ESSENTIA_GENERATOR = registerMetaTileEntity(11001, new MTEEssentiaGenerator(gcID("essentia_generator")));
        INDUSTRIAL_POND = registerMetaTileEntity(11002, new MTEIndustrialFishingPond(gcID("industrial_fishing_pond")));
        LIGHTNING_ROD[0] = registerMetaTileEntity(11003, new MTELightningRod(gcID("lightning_rod.hv"), GTValues.HV));
        LIGHTNING_ROD[1] = registerMetaTileEntity(11004, new MTELightningRod(gcID("lightning_rod.ev"), GTValues.EV));
        LIGHTNING_ROD[2] = registerMetaTileEntity(11005, new MTELightningRod(gcID("lightning_rod.iv"), GTValues.IV));
        QUBIT_COMPUTER = registerMetaTileEntity(11006, new MTEQubitComputer(gcID("quantum_computer")));

        QBIT_INPUT_HATCH[0] = registerMetaTileEntity(11007, new MTEQubitHatch(gcID("qubit_hatch.input.16"), 0, 16, false));
        QBIT_OUTPUT_HATCH[0] = registerMetaTileEntity(11008, new MTEQubitHatch(gcID("qubit_hatch.output.1"), 0, 16, true));

        RESEARCH_STATION = registerMetaTileEntity(11009, new MTEResearchStation(gcID("research_station")));
        for (LaserPipeType type : LaserPipeType.values()) {
            LASER_PIPES[type.ordinal()] = new BlockLaserPipe();
            LASER_PIPES[type.ordinal()].setRegistryName(String.format("laser_pipe_%s", type.name));
        }
        ALGAE_FARM = registerMetaTileEntity(11010,new MTEAlgaeFarm(gcID("algae_farm")));
    }

    private static ResourceLocation gcID(String name) {
        return new ResourceLocation(Gregica.MOD_ID, name);
    }

}
