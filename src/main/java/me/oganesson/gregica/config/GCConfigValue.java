package me.oganesson.gregica.config;

import me.oganesson.gregica.api.GCValues;

public class GCConfigValue {
    static {
        if(!GCConfig.configLoaded){
            throw new RuntimeException("Don't use config value before loading config");
        }
    }
    
    public final static boolean enableTjcore = GCConfig.Misc.enableTjcore;
    public static boolean enableResearch = GCConfig.Machines.enableResearch;
    
   // public final static boolean harderVacuumTubes = GCConfig.CircuitOverrides.harderVacuumTubes;
    public final static boolean harderCrystalCircuits = GCConfig.CircuitOverrides.harderWetwareCircuits;
    public final static boolean harderWetwareCircuits = GCConfig.CircuitOverrides.harderWetwareCircuits;
    
    public final static boolean disableRareEarthProcessing = GCConfig.ChainOverrides.disableRareEarthProcessing;
    public final static boolean disablePlatinumProcessing = GCConfig.ChainOverrides.disablePlatinumProcessing;
    public final static boolean disableTungstenProcessing = GCConfig.ChainOverrides.disableTungstenProcessing;
    public final static boolean disableGrapheneProcessing = GCConfig.ChainOverrides.disableGrapheneProcessing;
    public final static boolean disableNiobiumTantalumProcessing = GCConfig.ChainOverrides.disableNiobiumTantalumProcessing;
    public final static boolean disableAmmoniaProcessing = GCConfig.ChainOverrides.disableAmmoniaProcessing;
    public final static boolean disableMolybdenumProcessing = GCConfig.ChainOverrides.disableMolybdenumProcessing;
    
    public final static boolean  enableMetaItemShows_en_us_nameOnOtherLanguage = GCConfig.Misc.enableMetaItemShows_en_us_nameOnOtherLanguage || GCValues.IS_BilingualName_LOADED;
    
    //cannot use in mixin
    public final static boolean enableNerfSteamSolarBoiler = GCConfig.Nerf.enableNerfSteamSolarBoiler;
    
    public final static boolean enableNerfGCYMParallelHatch = GCConfig.Nerf.enableNerfGCYMParallelHatch;
}

