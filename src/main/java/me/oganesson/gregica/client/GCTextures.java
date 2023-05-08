package me.oganesson.gregica.client;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleSidedCubeRenderer;
import me.oganesson.gregica.Gregica;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

public class GCTextures {

    public static SimpleOverlayRenderer MAGIC_CASING;
    
    public static SimpleOverlayRenderer FISHING_CASING;
    
    public static SimpleOverlayRenderer QUANTUM_CASING;
    
    public static SimpleOverlayRenderer QUBIT_GENERATOR_CASING;
    
    public static OrientedOverlayRenderer LARGE_ESSENTIA_GENERATOR;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_HV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_ACTIVE_HV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_EV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_ACTIVE_EV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_IV;
    
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_ACTIVE_IV;
    
    public static SimpleOverlayRenderer HIGH_POWER_CASING;
    
    public static SimpleOverlayRenderer CATALYST_HATCH;
    
    public static SimpleSidedCubeRenderer LAPOTRONIC_CASING;
    
    public static OrientedOverlayRenderer LAPOTRONIC_CAPACITOR;
    
    public static OrientedOverlayRenderer QUBIT_COMPUTER_OVERLAY;
    
    public static OrientedOverlayRenderer RESEARCH_STATION_OVERLAY;
    
    public static SimpleOverlayRenderer ASEPTIC_FARM_CASING;
    
    public static OrientedOverlayRenderer ALGAE_FARM;
    
    public static OrientedOverlayRenderer ACTIVE_TRANSFORMER;

    public static OrientedOverlayRenderer CHEMICAL_PLANT;

    public static final ModelResourceLocation LASER_PIPE_MODEL = new ModelResourceLocation(new ResourceLocation(Gregica.MOD_ID, "laser_pipe_normal"), "normal");

    public static final SimpleOverlayRenderer GRATE_CASING = new SimpleOverlayRenderer("casings/pipe/machine_casing_grate");

    public static final SimpleOverlayRenderer RESEARCH_DATA_HATCH = new SimpleOverlayRenderer("overlay/machine/overlay_data_hatch");
    public static final SimpleOverlayRenderer CREATIVE_RESEARCH_DATA_HATCH = new SimpleOverlayRenderer("overlay/machine/overlay_data_hatch_creative");

    public static void preInit() {
        MAGIC_CASING = new SimpleOverlayRenderer("magic_machine_casing");
        FISHING_CASING = new SimpleOverlayRenderer("fishing_machine_casing");
        ASEPTIC_FARM_CASING = new SimpleOverlayRenderer("aseptic_farm_machine_casing");
        QUANTUM_CASING = new SimpleOverlayRenderer("computer_machine_casing");
        QUBIT_GENERATOR_CASING = new SimpleOverlayRenderer("quantum_generator_machine_casing");
        HIGH_POWER_CASING = new SimpleOverlayRenderer("casings/high_power_casing");
        CATALYST_HATCH = new SimpleOverlayRenderer("multipart/overlay_catalysts");
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
    }

}