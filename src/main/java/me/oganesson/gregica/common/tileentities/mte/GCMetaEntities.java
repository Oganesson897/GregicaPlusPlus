package me.oganesson.gregica.common.tileentities.mte;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.api.GCValues;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.common.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.block.laserpipe.LaserPipeType;
import me.oganesson.gregica.common.tileentities.mte.multi.energy.MTEActiveTransformer;
import me.oganesson.gregica.common.tileentities.mte.multi.energy.MTELapotronicSuperCapacitor;
import me.oganesson.gregica.common.tileentities.mte.multi.generators.MTEEssentiaGenerator;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.*;
import me.oganesson.gregica.common.tileentities.mte.multipart.MTEBallHatch;
import me.oganesson.gregica.common.tileentities.mte.multipart.MTECatalystHatch;
import me.oganesson.gregica.common.tileentities.mte.multipart.MTECreativeEnergyHatch;
import me.oganesson.gregica.common.tileentities.mte.multipart.MTEQubitHatch;
import me.oganesson.gregica.common.tileentities.mte.single.MTECreativeGenerator;
import net.minecraft.util.ResourceLocation;

import java.util.function.Function;
import java.util.function.IntFunction;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class GCMetaEntities {
    
    public static int currentID = 11000;
    public static final MTELightningRod[] LIGHTNING_ROD = new MTELightningRod[4];
    public static final MTECreativeGenerator[] CREATIVE_GENERATORS = new MTECreativeGenerator[GTValues.V.length];
    public static SimpleMachineMetaTileEntity[] LAMINATOR = new SimpleMachineMetaTileEntity[GTValues.MAX];

    //Multi
    public static MTEEssentiaGenerator ESSENTIA_GENERATOR;
    public static MTEIndustrialFishingPond INDUSTRIAL_POND;
    public static MTEQubitComputer QUBIT_COMPUTER;
    public static MTEResearchStation RESEARCH_STATION;
    public static MTEAlgaeFarm ALGAE_FARM;
    public static MTEAssemblyLine ASSEMBLY_LINE;

    public static MTELogCreateFactory LOG_CREATE_FACTORY;

    public static final SimpleGeneratorMetaTileEntity[] SEMI_FLUID_GENERATOR = new SimpleGeneratorMetaTileEntity[3];

    public static MTEChemicalPlant CHEMICAL_PLANT;

    public static MTEActiveTransformer ACTIVE_TRANSFORMER;
    public static MTEReplicator REPLICATOR;
    public static MTELapotronicSuperCapacitor LAPOTRONIC_SUPER_CAPACITOR;
    public static MTEIsaMill ISA_MILL;

    //Part
    public static MTEQubitHatch[] QBIT_INPUT_HATCH = new MTEQubitHatch[GCValues.QUBIT.length];
    public static MTEQubitHatch[] QBIT_OUTPUT_HATCH = new MTEQubitHatch[GCValues.QUBIT.length];

    public static MTECatalystHatch CATALYST_HATCH;
    public static MTEBallHatch GRIND_BALL_HATCH;

    public static final MTECreativeEnergyHatch[] CREATIVE_ENERGY_HATCHES = new MTECreativeEnergyHatch[GTValues.V.length];

    public static final BlockLaserPipe[] LASER_PIPES = new BlockLaserPipe[1];

    public static void register() {
        //Single Machine
        LIGHTNING_ROD[0] = registerMetaTileEntity(nextID(), new MTELightningRod(gcID("lightning_rod.hv"), GTValues.HV));
        LIGHTNING_ROD[1] = registerMetaTileEntity(nextID(), new MTELightningRod(gcID("lightning_rod.ev"), GTValues.EV));
        LIGHTNING_ROD[2] = registerMetaTileEntity(nextID(), new MTELightningRod(gcID("lightning_rod.iv"), GTValues.IV));

        simpleTiredInit(CREATIVE_GENERATORS,
                (i) -> new MTECreativeGenerator(gcID("creative_generator."+GTValues.VN[i].toLowerCase()),i));

        registerSimpleMetaTileEntity(LAMINATOR, 12070, "laminator", GCRecipeMaps.LAMINATOR_RECIPES, Textures.BENDER_OVERLAY, true);

        //Multiblock Controller
        if(GCValues.IS_TC_LOADED)
        {
            ESSENTIA_GENERATOR = registerMetaTileEntity(nextID(), new MTEEssentiaGenerator(gcID("essentia_generator")));
        }
        INDUSTRIAL_POND = registerMetaTileEntity(nextID(), new MTEIndustrialFishingPond(gcID("industrial_fishing_pond")));

        QUBIT_COMPUTER = registerMetaTileEntity(nextID(), new MTEQubitComputer(gcID("quantum_computer")));

        RESEARCH_STATION = registerMetaTileEntity(nextID(), new MTEResearchStation(gcID("research_station")));

        ALGAE_FARM = registerMetaTileEntity(nextID(),new MTEAlgaeFarm(gcID("algae_farm")));

        ASSEMBLY_LINE = registerMetaTileEntity(nextID(), new MTEAssemblyLine(gcID("qubit_assembly_line")));

        ACTIVE_TRANSFORMER = registerMetaTileEntity(nextID(),new MTEActiveTransformer(gcID("active_transformer")));

        REPLICATOR = registerMetaTileEntity(nextID(), new MTEReplicator(gcID("replicator")));
        
        LAPOTRONIC_SUPER_CAPACITOR = registerMetaTileEntity(nextID(),new MTELapotronicSuperCapacitor(gcID("lapotronic_super_capacitor")));

        LOG_CREATE_FACTORY = registerMetaTileEntity(nextID(),new MTELogCreateFactory(gcID("log_create_factory")));

        ISA_MILL = registerMetaTileEntity(nextID(),new MTEIsaMill(gcID("isa_mill")));

 CHEMICAL_PLANT = registerMetaTileEntity(nextID(),new MTEChemicalPlant(gcID("chemical_plant")));
 
        //Multipart
        QBIT_INPUT_HATCH[0] = registerMetaTileEntity(nextID(), new MTEQubitHatch(gcID("qubit_hatch.input.16"), 0, 16, false));
        QBIT_OUTPUT_HATCH[0] = registerMetaTileEntity(nextID(), new MTEQubitHatch(gcID("qubit_hatch.output.1"), 0, 16, true));

        CATALYST_HATCH = registerMetaTileEntity(nextID(),new MTECatalystHatch(gcID("catalyst_hatch")));
        GRIND_BALL_HATCH = registerMetaTileEntity(nextID(),new MTEBallHatch(gcID("ball_hatch")));

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

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing, Function<Integer, Integer> tankScalingFunction) {
        MetaTileEntities.registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, GCMetaEntities::gcID, tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing) {
        registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, GTUtility.defaultTankSizeFunction);
    }

    private static int nextID(){
        currentID++;
        return currentID;
    }
    
}
