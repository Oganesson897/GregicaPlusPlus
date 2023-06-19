package gregica.api;

import gregtech.api.GTValues;
import net.minecraftforge.fml.common.Loader;

import java.util.function.IntUnaryOperator;

public class GCValues {
    public static final int[] QUBIT = new int[]{1, 16, 256, 4096, 65536, 1048576, 16777216, 268435456};
    
    public static final int[] LASER_AMPERAGE = new int[]{256,1024,4096,16384,65536,262144};
    
    public static final IntUnaryOperator AMPERAGE_TIER = (i) -> switch (i) {
        case (256) -> 1;
        case (1024) -> 2;
        case (4096) -> 3;
        case (16384) -> 4;
        case (65536) -> 5;
        case (262144) -> 6;
        default -> 0;
    };

    public static final String CEu_MOD_ID = "gregtech";
    public static final String CEu_VERSION = "2.6.2-beta";
    
    public static final boolean IS_TOP_LOADED = Loader.isModLoaded(GTValues.MODID_TOP);
    
    public static final boolean IS_TC_LOADED = Loader.isModLoaded("thaumcraft");
    
    public static final boolean IS_SERENDUSTRY_LOADED = Loader.isModLoaded("dandustry");
    
    @SuppressWarnings("SpellCheckingInspection")
    public static final boolean IS_BilingualName_LOADED = Loader.isModLoaded("bilingualname");
    
    //用于writeCustomData
    public static final int UPDATE_TIER = 114514;
    public static final int REQUIRE_DATA_UPDATE = 1919;
    
    public static final int RENDER_UPDATE = 16384;
    
    public static final int TARGET_UPDATE= 65536;
    public static final int TARGET_UPDATE_NULL = 65537;

    /**
     * Earth's Temperature in Kelvin
     */
    public static final int EARTH_TEMPERATURE = 298;
}
