package me.oganesson.gregica.crossmod.top;

import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;
import me.oganesson.gregica.crossmod.top.provider.QubitContainerInfoProvider;
import me.oganesson.gregica.crossmod.top.provider.ColorProvider;

public class TOPCompatibility {
    
    public static void initCompatibility(){
        ITheOneProbe top = TheOneProbe.theOneProbeImp;
        top.registerProvider(new ColorProvider());
        top.registerProvider(new QubitContainerInfoProvider());
    }
    
}
