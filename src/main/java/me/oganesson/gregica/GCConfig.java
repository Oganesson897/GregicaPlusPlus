package me.oganesson.gregica;

import me.oganesson.gregica.api.GCValues;
import net.minecraftforge.common.config.Config;

public class GCConfig {

    @Config.Comment("Config options of miscellaneous features")
    public static Misc Misc = new Misc();

    @Config.Comment("Config options of pollution system")
    public static Pollution Pollution = new Pollution();
    
    @Config.Comment("Config options of nerf other mods")
    public static Nerf nerf = new Nerf();
    
    @Config(modid = Gregica.MOD_ID)
    public static class Misc {
        @Config.Comment("List of Soldering fluid [<fluid>:<amount>] amount=[1 ~ 64000]")
        @Config.RequiresMcRestart
        public static String[] solderingFluidList = new String[]{"soldering_alloy:72", "tin:144"};
    }
    
    @Config(modid = Gregica.MOD_ID)
    public static class Pollution {

        @Config.Comment({"Enable the Pollution System.", "Strict requirements GTCEu version:" + GCValues.CEu_VERSION})
        @Config.RequiresMcRestart
        public static boolean enablePollution = true;

    }
    
    @Config(modid = Gregica.MOD_ID)
    public static class Nerf{
        
        @Config.Comment({"Enable nerf the steam solar boiler.The output will decrease to 1/3 as time goes on."})
        @Config.RequiresMcRestart
        public static boolean enableNerfSteamSolarBoiler = true;
        
    }
}
