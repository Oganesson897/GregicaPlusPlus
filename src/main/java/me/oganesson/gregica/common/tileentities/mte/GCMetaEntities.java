package me.oganesson.gregica.common.tileentities.mte;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCValues;
import me.oganesson.gregica.common.tileentities.mte.multi.energy.MTEActiveTransformer;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTEAlgaeFarm;
import me.oganesson.gregica.common.tileentities.mte.multipart.MTECreativeEnergyHatch;
import me.oganesson.gregica.common.tileentities.mte.multipart.MTEQubitHatch;
import me.oganesson.gregica.common.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.block.laserpipe.LaserPipeType;
import me.oganesson.gregica.common.tileentities.mte.multi.generators.MTEEssentiaGenerator;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTEIndustrialFishingPond;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTELightningRod;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTEQubitComputer;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTEResearchStation;
import me.oganesson.gregica.common.tileentities.mte.single.MTECreativeGenerator;
import net.minecraft.util.ResourceLocation;

import java.util.function.IntFunction;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class GCMetaEntities {
    
    public static int currentID = 11000;
    public static MTEEssentiaGenerator ESSENTIA_GENERATOR;
    public static MTEIndustrialFishingPond INDUSTRIAL_POND;
    public static final MTELightningRod[] LIGHTNING_ROD = new MTELightningRod[4];
    public static MTEQubitComputer QUBIT_COMPUTER;
    public static MTEQubitHatch[] QBIT_INPUT_HATCH = new MTEQubitHatch[GCValues.QUBIT.length];
    public static MTEQubitHatch[] QBIT_OUTPUT_HATCH = new MTEQubitHatch[GCValues.QUBIT.length];
    public static final BlockLaserPipe[] LASER_PIPES = new BlockLaserPipe[1];
    public static MTEResearchStation RESEARCH_STATION;
    public static MTEAlgaeFarm ALGAE_FARM;
    public static final SimpleGeneratorMetaTileEntity[] SEMI_FLUID_GENERATOR = new SimpleGeneratorMetaTileEntity[3];
    
    public static final MTECreativeGenerator[] CREATIVE_GENERATORS = new MTECreativeGenerator[GTValues.V.length];
    
    public static final MTECreativeEnergyHatch[] CREATIVE_ENERGY_HATCHES = new MTECreativeEnergyHatch[GTValues.V.length];
    
    public static MTEActiveTransformer ACTIVE_TRANSFORMER;

    public static void register() {
        if(GCValues.IS_TC_LOADED)
        {
            ESSENTIA_GENERATOR = registerMetaTileEntity(nextID(), new MTEEssentiaGenerator(gcID("essentia_generator")));
        }
        INDUSTRIAL_POND = registerMetaTileEntity(nextID(), new MTEIndustrialFishingPond(gcID("industrial_fishing_pond")));
        LIGHTNING_ROD[0] = registerMetaTileEntity(nextID(), new MTELightningRod(gcID("lightning_rod.hv"), GTValues.HV));
        LIGHTNING_ROD[1] = registerMetaTileEntity(nextID(), new MTELightningRod(gcID("lightning_rod.ev"), GTValues.EV));
        LIGHTNING_ROD[2] = registerMetaTileEntity(nextID(), new MTELightningRod(gcID("lightning_rod.iv"), GTValues.IV));
        QUBIT_COMPUTER = registerMetaTileEntity(nextID(), new MTEQubitComputer(gcID("quantum_computer")));

        QBIT_INPUT_HATCH[0] = registerMetaTileEntity(nextID(), new MTEQubitHatch(gcID("qubit_hatch.input.16"), 0, 16, false));
        QBIT_OUTPUT_HATCH[0] = registerMetaTileEntity(nextID(), new MTEQubitHatch(gcID("qubit_hatch.output.1"), 0, 16, true));

        RESEARCH_STATION = registerMetaTileEntity(nextID(), new MTEResearchStation(gcID("research_station")));
        for (LaserPipeType type : LaserPipeType.values()) {
            LASER_PIPES[type.ordinal()] = new BlockLaserPipe();
            LASER_PIPES[type.ordinal()].setRegistryName(String.format("laser_pipe_%s", type.name));
        }
//        for(int i = 0;i<GTValues.V.length;i++){
//            CREATIVE_GENERATORS[i] = registerMetaTileEntity(
//                    nextID(),new MTECreativeGenerator(
//                            gcID("creative_generator."+GTValues.VN[i].toLowerCase()),i));
//        }
        simpleTiredInit(CREATIVE_GENERATORS,
                (i) -> new MTECreativeGenerator(gcID("creative_generator."+GTValues.VN[i].toLowerCase()),i));
        simpleTiredInit(CREATIVE_ENERGY_HATCHES,
                (i) -> new MTECreativeEnergyHatch(gcID("creative_energy_hatch."+GTValues.VN[i].toLowerCase()),i));

        ALGAE_FARM = registerMetaTileEntity(nextID(),new MTEAlgaeFarm(gcID("algae_farm")));
        ACTIVE_TRANSFORMER = registerMetaTileEntity(nextID(),new MTEActiveTransformer(gcID("active_transformer")));
    }

    private static ResourceLocation gcID(String name) {
        return new ResourceLocation(Gregica.MOD_ID, name);
    }
    
    public static void simpleTiredInit(MetaTileEntity[] tileEntities, IntFunction<MetaTileEntity> function){
        for(int i = 0;i<GTValues.V.length;i++){
            tileEntities[i] = registerMetaTileEntity(
                    nextID(),function.apply(i));
        }
    }

    private static int nextID(){
        currentID++;
        return currentID;
    }
    
}
