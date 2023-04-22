package me.oganesson.gregica;

import me.oganesson.gregica.api.GCValues;
import net.minecraftforge.common.config.Config;

public class GCConfig {

    @Config.Comment("Config options of miscellaneous features")
    public static Misc Misc = new Misc();

    @Config.Comment("Config options of pollution system")
    public static Pollution Pollution = new Pollution();

    public static class Misc {
        @Config.Comment("List of Soldering fluid [<fluid>:<amount>] amount=[1 ~ 64000]")
        @Config.RequiresMcRestart
        public String[] solderingFluidList = new String[]{"soldering_alloy:72", "tin:144"};
    }

    public static class Pollution {

        @Config.Comment({"Enable the Pollution System.", "Strict requirements GTCEu version:" + GCValues.CEu_VERSION})
        @Config.RequiresMcRestart
        public boolean enablePollution = true;

    }
}
