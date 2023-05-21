package me.oganesson.gregica.api;

import gregtech.api.GTValues;
import net.minecraftforge.fml.common.Loader;

public class GCValues {
    public static final int[] QUBIT = new int[]{1, 16, 256, 4096, 65536, 1048576, 16777216, 268435456};

    public static final String CEu_VERSION = "2.6.1-beta";
    
    public static final boolean IS_TOP_LOADED = Loader.isModLoaded(GTValues.MODID_TOP);
    
    public static final boolean IS_TC_LOADED = Loader.isModLoaded("thaumcraft");
    
    //用于writeCustomData
    public static final int UPDATE_TIER = 114514;
    public static final int REQUIRE_DATA_UPDATE = 1919;

    /**
     * Earth's Temperature in Kelvin
     */
    public static final int EARTH_TEMPERATURE = 298;
}
