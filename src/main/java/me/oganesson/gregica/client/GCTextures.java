package me.oganesson.gregica.client;

import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.renderer.texture.cube.SimpleSidedCubeRenderer;

public class GCTextures {

    public static SimpleOverlayRenderer MAGIC_CASING;
    public static SimpleOverlayRenderer FISHING_CASING;
    public static OrientedOverlayRenderer LARGE_ESSENTIA_GENERATOR;
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_HV;
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_ACTIVE_HV;
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_EV;
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_ACTIVE_EV;
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_IV;
    public static SimpleSidedCubeRenderer LIGHTNING_ROD_ACTIVE_IV;
    public static void preInit() {
        MAGIC_CASING = new SimpleOverlayRenderer("magic_machine_casing");
        FISHING_CASING = new SimpleOverlayRenderer("fishing_machine_casing");
        LARGE_ESSENTIA_GENERATOR = new OrientedOverlayRenderer("multiblock/large_essentia_generator", new OrientedOverlayRenderer.OverlayFace[]{OrientedOverlayRenderer.OverlayFace.FRONT});
        LIGHTNING_ROD_HV = new SimpleSidedCubeRenderer("casings/lightning_rod_hv/normal");
        LIGHTNING_ROD_ACTIVE_HV = new SimpleSidedCubeRenderer("casings/lightning_rod_hv/active");
        LIGHTNING_ROD_EV = new SimpleSidedCubeRenderer("casings/lightning_rod_ev/normal");
        LIGHTNING_ROD_ACTIVE_EV = new SimpleSidedCubeRenderer("casings/lightning_rod_ev/active");
        LIGHTNING_ROD_IV = new SimpleSidedCubeRenderer("casings/lightning_rod_iv/normal");
        LIGHTNING_ROD_ACTIVE_IV = new SimpleSidedCubeRenderer("casings/lightning_rod_iv/active");
    }

}
