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
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.block.laserpipe.BlockLaserPipe;
import me.oganesson.gregica.common.block.laserpipe.LaserPipeType;
import me.oganesson.gregica.common.tileentities.mte.multi.energy.MTEActiveTransformer;
import me.oganesson.gregica.common.tileentities.mte.multi.energy.MTELapotronicSuperCapacitor;
import me.oganesson.gregica.common.tileentities.mte.multi.gcys.*;
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
import java.util.function.IntSupplier;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class GCMetaEntities {
    
    public static int currentMultiBlockID = 11000;
    public static int currentMultiPartID = 14000;
    public static int currentSingleMachineID = 17000;
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
    public static MTEFlotationCellRegulator FLOTATION_CELL_REGULATOR;
    public static MTEActiveTransformer ACTIVE_TRANSFORMER;
    public static MTEReplicator REPLICATOR;
    public static MTELapotronicSuperCapacitor LAPOTRONIC_SUPER_CAPACITOR;
    public static MTEIsaMill ISA_MILL;
    public static MTEVacuumFurnace VACUUM_FURNACE;

    //Part
    public static MTEQubitHatch[] QBIT_INPUT_HATCH = new MTEQubitHatch[GCValues.QUBIT.length];
    public static MTEQubitHatch[] QBIT_OUTPUT_HATCH = new MTEQubitHatch[GCValues.QUBIT.length];

    public static MTECatalystHatch CATALYST_HATCH;
    public static MTEBallHatch GRIND_BALL_HATCH;

    public static final MTECreativeEnergyHatch[] CREATIVE_ENERGY_HATCHES = new MTECreativeEnergyHatch[GTValues.V.length];

    public static final BlockLaserPipe[] LASER_PIPES = new BlockLaserPipe[1];

    public static SimpleMachineMetaTileEntity[] DRYER = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

    public static MetaTileEntityCrystallizationCrucible CRYSTALLIZATION_CRUCIBLE;
    public static MetaTileEntityRoaster ROASTER;
    public static MetaTileEntityNanoscaleFabricator NANOSCALE_FABRICATOR;
    public static MetaTileEntityCVDUnit CVD_UNIT;
    public static MetaTileEntityBurnerReactor BURNER_REACTOR;
    public static MetaTileEntityCryoReactor CRYOGENIC_REACTOR;
    public static MetaTileEntityFracker HYDRAULIC_FRACKER;
    public static MetaTileEntitySonicator SONICATOR;
    public static MetaTileEntityCatalyticReformer CATALYTIC_REFORMER;
    public static MetaTileEntityIndustrialDrill INDUSTRIAL_DRILL;

    
    
    public static void register() {
        initMultiBlock();
        initMultiPart();
        initSingleMachine();
        initGCYS();

        for (LaserPipeType type : LaserPipeType.values()) {
            LASER_PIPES[type.ordinal()] = new BlockLaserPipe();
            LASER_PIPES[type.ordinal()].setRegistryName(String.format("laser_pipe_%s", type.name));
        }

        //GCYS

    }

    private static ResourceLocation gcID(String name) {
        return new ResourceLocation(Gregica.MOD_ID, name);
    }
    
    private static ResourceLocation gcysID(String name){
        return new ResourceLocation("gcys",name);
    }
    
    public static void simpleTiredInit(MetaTileEntity[] tileEntities, IntFunction<MetaTileEntity> function, IntSupplier idSupplier){
        for(int i = 0;i<GTValues.V.length;i++){
            tileEntities[i] = registerMetaTileEntity(
                    idSupplier.getAsInt(),function.apply(i));
        }
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing, Function<Integer, Integer> tankScalingFunction,boolean isGCYS) {
        MetaTileEntities.registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, isGCYS ? GCMetaEntities::gcysID : GCMetaEntities::gcID, tankScalingFunction);
    }

    private static void registerSimpleMetaTileEntity(SimpleMachineMetaTileEntity[] machines, int startID, String name, RecipeMap<?> map, ICubeRenderer texture, boolean frontfacing,boolean isGCYS) {
        registerSimpleMetaTileEntity(machines, startID, name, map, texture, frontfacing, GTUtility.defaultTankSizeFunction,isGCYS);
    }

    private static int nextMultiBlockID(){
        currentMultiBlockID++;
        return currentMultiBlockID;
    }
    private static int nextMultiPartID(){
        currentMultiPartID++;
        return currentMultiPartID;
    }
    private static int nextSingleMachineID(){
        currentSingleMachineID++;
        return currentSingleMachineID;
    }
    
    private static void initMultiBlock(){
       
        INDUSTRIAL_POND = registerMetaTileEntity(nextMultiBlockID(), new MTEIndustrialFishingPond(gcID("industrial_fishing_pond")));
    
        QUBIT_COMPUTER = registerMetaTileEntity(nextMultiBlockID(), new MTEQubitComputer(gcID("quantum_computer")));
    
        RESEARCH_STATION = registerMetaTileEntity(nextMultiBlockID(), new MTEResearchStation(gcID("research_station")));
    
        ALGAE_FARM = registerMetaTileEntity(nextMultiBlockID(),new MTEAlgaeFarm(gcID("algae_farm")));
    
        ASSEMBLY_LINE = registerMetaTileEntity(nextMultiBlockID(), new MTEAssemblyLine(gcID("qubit_assembly_line")));
    
        ACTIVE_TRANSFORMER = registerMetaTileEntity(nextMultiBlockID(),new MTEActiveTransformer(gcID("active_transformer")));
    
        REPLICATOR = registerMetaTileEntity(nextMultiBlockID(), new MTEReplicator(gcID("replicator")));
    
        LAPOTRONIC_SUPER_CAPACITOR = registerMetaTileEntity(nextMultiBlockID(),new MTELapotronicSuperCapacitor(gcID("lapotronic_super_capacitor")));
    
        LOG_CREATE_FACTORY = registerMetaTileEntity(nextMultiBlockID(),new MTELogCreateFactory(gcID("log_create_factory")));
    
        ISA_MILL = registerMetaTileEntity(nextMultiBlockID(),new MTEIsaMill(gcID("isa_mill")));
    
        CHEMICAL_PLANT = registerMetaTileEntity(nextMultiBlockID(),new MTEChemicalPlant(gcID("chemical_plant")));
    
        FLOTATION_CELL_REGULATOR = registerMetaTileEntity(nextMultiBlockID(),new MTEFlotationCellRegulator(gcID("flotation_cell_regulator")));
    
        VACUUM_FURNACE = registerMetaTileEntity(nextMultiBlockID(), new MTEVacuumFurnace(gcID("vacuum_furnace")));
        //含联动的放最底下
        if(GCValues.IS_TC_LOADED)
        {
            ESSENTIA_GENERATOR = registerMetaTileEntity(nextMultiBlockID(), new MTEEssentiaGenerator(gcID("essentia_generator")));
        }
        else {
            //防止ID错位
            nextMultiBlockID();
        }
    }
    
    private static void initMultiPart(){
        QBIT_INPUT_HATCH[0] = registerMetaTileEntity(nextMultiPartID(), new MTEQubitHatch(gcID("qubit_hatch.input.16"), 0, 16, false));
        QBIT_OUTPUT_HATCH[0] = registerMetaTileEntity(nextMultiPartID(), new MTEQubitHatch(gcID("qubit_hatch.output.1"), 0, 16, true));
    
        CATALYST_HATCH = registerMetaTileEntity(nextMultiPartID(),new MTECatalystHatch(gcID("catalyst_hatch")));
        GRIND_BALL_HATCH = registerMetaTileEntity(nextMultiPartID(),new MTEBallHatch(gcID("ball_hatch")));
    
        simpleTiredInit(CREATIVE_ENERGY_HATCHES,
                (i) -> new MTECreativeEnergyHatch(gcID("creative_energy_hatch."+GTValues.VN[i].toLowerCase()),i),
                GCMetaEntities::nextMultiPartID);
    }
    
    private static void initSingleMachine(){
        LIGHTNING_ROD[0] = registerMetaTileEntity(nextSingleMachineID(), new MTELightningRod(gcID("lightning_rod.hv"), GTValues.HV));
        LIGHTNING_ROD[1] = registerMetaTileEntity(nextSingleMachineID(), new MTELightningRod(gcID("lightning_rod.ev"), GTValues.EV));
        LIGHTNING_ROD[2] = registerMetaTileEntity(nextSingleMachineID(), new MTELightningRod(gcID("lightning_rod.iv"), GTValues.IV));
        
        simpleTiredInit(CREATIVE_GENERATORS,
                (i) -> new MTECreativeGenerator(gcID("creative_generator."+GTValues.VN[i].toLowerCase()),i),
                GCMetaEntities::nextSingleMachineID);
    
        registerSimpleMetaTileEntity(LAMINATOR, 12070, "laminator", GCRecipeMaps.LAMINATOR_RECIPES, Textures.BENDER_OVERLAY, true,false);
    
    }
    
    private static void initGCYS(){
        // Simple Machines: ID 2300-3000+
        registerSimpleMetaTileEntity(DRYER, 2200, "dryer", GCRecipeMaps.DRYER_RECIPES, GCTextures.DRYER_OVERLAY, true, GTUtility.hvCappedTankSizeFunction,true);
    
        // Multiblocks: Id 3900-3999
        INDUSTRIAL_DRILL = registerMetaTileEntity(3900, new MetaTileEntityIndustrialDrill(gcysID("industrial_drill")));
        CATALYTIC_REFORMER = registerMetaTileEntity(3901, new MetaTileEntityCatalyticReformer(gcysID("catalytic_reformer")));
        SONICATOR = registerMetaTileEntity(3902, new MetaTileEntitySonicator(gcysID("sonicator")));
        HYDRAULIC_FRACKER = registerMetaTileEntity(3903, new MetaTileEntityFracker(gcysID("fracker"), GTValues.ZPM));
        NANOSCALE_FABRICATOR = registerMetaTileEntity(3904, new MetaTileEntityNanoscaleFabricator(gcysID("nanoscale_fabricator")));
        ROASTER = registerMetaTileEntity(3905, new MetaTileEntityRoaster(gcysID("roaster")));
        CRYSTALLIZATION_CRUCIBLE = registerMetaTileEntity(3907, new MetaTileEntityCrystallizationCrucible(gcysID("crystallization_crucible")));
        CVD_UNIT = registerMetaTileEntity(3908, new MetaTileEntityCVDUnit(gcysID("cvd_unit")));
        BURNER_REACTOR = registerMetaTileEntity(3909, new MetaTileEntityBurnerReactor(gcysID("burner_reactor")));
        CRYOGENIC_REACTOR = registerMetaTileEntity(3910, new MetaTileEntityCryoReactor(gcysID("cryogenic_reactor")));
     
    }
    
}
