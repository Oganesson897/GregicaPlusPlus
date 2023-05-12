package me.oganesson.gregica.client;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleSidedCubeRenderer;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.client.render.IsaMillRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static gregtech.client.renderer.texture.cube.OrientedOverlayRenderer.OverlayFace.*;

public class GCTextures {

    public static SimpleOverlayRenderer MAGIC_CASING;
    
    public static SimpleOverlayRenderer FISHING_CASING;
    
    public static SimpleOverlayRenderer QUANTUM_CASING;
    
    public static SimpleOverlayRenderer QUBIT_GENERATOR_CASING;

    public static SimpleOverlayRenderer ISA_MILL_CASING;

    public static OrientedOverlayRenderer LARGE_ESSENTIA_GENERATOR;

    public static SimpleSidedCubeRenderer LIGHTNING_ROD_HV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_ACTIVE_HV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_EV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_ACTIVE_EV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_IV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_ACTIVE_IV;
    
    public static SimpleOverlayRenderer HIGH_POWER_CASING;
    
    public static SimpleOverlayRenderer CATALYST_HATCH;

    public static SimpleOverlayRenderer BALL_HATCH;
    
    public static SimpleSidedCubeRenderer LAPOTRONIC_CASING;
    
    public static OrientedOverlayRenderer LAPOTRONIC_CAPACITOR;
    
    public static OrientedOverlayRenderer QUBIT_COMPUTER_OVERLAY;
    
    public static OrientedOverlayRenderer RESEARCH_STATION_OVERLAY;
    
    public static SimpleOverlayRenderer ASEPTIC_FARM_CASING;
    
    public static OrientedOverlayRenderer ALGAE_FARM;
    
    public static OrientedOverlayRenderer ACTIVE_TRANSFORMER;

    public static OrientedOverlayRenderer CHEMICAL_PLANT;

    public static SimpleOverlayRenderer FLOTATION_CELL_REGULATOR;

    public static final IsaMillRenderer ISA_MILL = new IsaMillRenderer();

    public static final ModelResourceLocation LASER_PIPE_MODEL = new ModelResourceLocation(new ResourceLocation(Gregica.MOD_ID, "laser_pipe_normal"), "normal");

    public static final SimpleOverlayRenderer GRATE_CASING = new SimpleOverlayRenderer("casings/pipe/machine_casing_grate");

    public static final SimpleOverlayRenderer RESEARCH_DATA_HATCH = new SimpleOverlayRenderer("overlay/machine/overlay_data_hatch");
    public static final SimpleOverlayRenderer CREATIVE_RESEARCH_DATA_HATCH = new SimpleOverlayRenderer("overlay/machine/overlay_data_hatch_creative");

    //GCYS
    public static OrientedOverlayRenderer DRYER_OVERLAY = new OrientedOverlayRenderer("machines/dryer", FRONT, TOP, SIDE);
    public static OrientedOverlayRenderer CRYSTALLIZATION_CRUCIBLE_OVERLAY = new OrientedOverlayRenderer("multiblock/crystallization_crucible", FRONT);
    public static OrientedOverlayRenderer ROASTER_OVERLAY = new OrientedOverlayRenderer("multiblock/roaster", FRONT);
    public static OrientedOverlayRenderer NANOSCALE_FABRICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/nanoscale_fabricator", FRONT);
    public static OrientedOverlayRenderer CVD_UNIT_OVERLAY = new OrientedOverlayRenderer("multiblock/cvd_unit", FRONT);
    public static OrientedOverlayRenderer BURNER_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/burner_reactor", FRONT);
    public static OrientedOverlayRenderer CRYOGENIC_REACTOR_OVERLAY = new OrientedOverlayRenderer("multiblock/cryogenic_reactor", FRONT);
    public static OrientedOverlayRenderer FRACKER_OVERLAY = new OrientedOverlayRenderer("multiblock/fracker", FRONT);
    public static OrientedOverlayRenderer SONICATOR_OVERLAY = new OrientedOverlayRenderer("multiblock/sonicator", FRONT);
    public static OrientedOverlayRenderer CATALYTIC_REFORMER_OVERLAY = new OrientedOverlayRenderer("multiblock/catalytic_reformer", FRONT);
    public static OrientedOverlayRenderer INDUSTRIAL_DRILL_OVERLAY = new OrientedOverlayRenderer("multiblock/industrial_drill", FRONT);
    public static OrientedOverlayRenderer SUBSONIC_AXIAL_COMPRESSOR_OVERLAY = new OrientedOverlayRenderer("multiblock/subsonic_axial_compressor", FRONT);
    public static OrientedOverlayRenderer SUPERSONIC_AXIAL_COMPRESSOR_OVERLAY = new OrientedOverlayRenderer("multiblock/supersonic_axial_compressor", FRONT);
    public static OrientedOverlayRenderer LOW_POWER_TURBOMOLECULAR_PUMP = new OrientedOverlayRenderer("multiblock/low_power_turbomolecular_pump", TOP);
    public static OrientedOverlayRenderer HIGH_POWER_TURBOMOLECULAR_PUMP = new OrientedOverlayRenderer("multiblock/high_power_turbomolecular_pump", TOP);
    public static OrientedOverlayRenderer SUPRACHRONAL_OVERLAY = new OrientedOverlayRenderer("multiblock/suprachronal_assembler", FRONT);

    public static SimpleOverlayRenderer SUPRACHRONAL_CASING = new SimpleOverlayRenderer("casings/solid/suprachronal_casing");

    public static TextureAtlasSprite PRESSURE_PIPE_SIDE;
    public static TextureAtlasSprite PRESSURE_PIPE_OPEN;

    @SideOnly(Side.CLIENT)
    public static void register(TextureMap textureMap) {
        PRESSURE_PIPE_SIDE = textureMap.registerSprite(new ResourceLocation(Gregica.MOD_ID, "blocks/pipe/pressure_pipe_side"));
        PRESSURE_PIPE_OPEN = textureMap.registerSprite(new ResourceLocation(Gregica.MOD_ID, "blocks/pipe/pressure_pipe_open"));

    }

    public static void preInit() {
        MAGIC_CASING = new SimpleOverlayRenderer("magic_machine_casing");
        FISHING_CASING = new SimpleOverlayRenderer("fishing_machine_casing");
        ASEPTIC_FARM_CASING = new SimpleOverlayRenderer("aseptic_farm_machine_casing");
        QUANTUM_CASING = new SimpleOverlayRenderer("computer_machine_casing");
        QUBIT_GENERATOR_CASING = new SimpleOverlayRenderer("quantum_generator_machine_casing");
        HIGH_POWER_CASING = new SimpleOverlayRenderer("casings/high_power_casing");
        CATALYST_HATCH = new SimpleOverlayRenderer("multipart/overlay_catalysts");
        BALL_HATCH = new SimpleOverlayRenderer("multipart/overlay_grindball");
        LAPOTRONIC_CASING = new SimpleSidedCubeRenderer("casings/lapotronic");
        LAPOTRONIC_CAPACITOR = new OrientedOverlayRenderer("casings/lapotronic/capacitor");
        LARGE_ESSENTIA_GENERATOR = new OrientedOverlayRenderer("multiblock/large_essentia_generator");
        CHEMICAL_PLANT = new OrientedOverlayRenderer("multiblock/gc_chemical_plant");
        LIGHTNING_ROD_HV = new SimpleSidedCubeRenderer("casings/lightning_rod_hv/normal");
        LIGHTNING_ROD_ACTIVE_HV = new SimpleSidedCubeRenderer("casings/lightning_rod_hv/active");
        LIGHTNING_ROD_EV = new SimpleSidedCubeRenderer("casings/lightning_rod_ev/normal");
        LIGHTNING_ROD_ACTIVE_EV = new SimpleSidedCubeRenderer("casings/lightning_rod_ev/active");
        LIGHTNING_ROD_IV = new SimpleSidedCubeRenderer("casings/lightning_rod_iv/normal");
        LIGHTNING_ROD_ACTIVE_IV = new SimpleSidedCubeRenderer("casings/lightning_rod_iv/active");
        QUBIT_COMPUTER_OVERLAY = new OrientedOverlayRenderer("multiblock/qubit_computer");
        RESEARCH_STATION_OVERLAY= new OrientedOverlayRenderer("multiblock/research_station");
        ALGAE_FARM= new OrientedOverlayRenderer("multiblock/algae_farm");
        ACTIVE_TRANSFORMER= new OrientedOverlayRenderer("multiblock/active_transformer");
        ISA_MILL_CASING= new SimpleOverlayRenderer("isa_machine_casing");
        FLOTATION_CELL_REGULATOR= new SimpleOverlayRenderer("flotation_casing");
    }

}