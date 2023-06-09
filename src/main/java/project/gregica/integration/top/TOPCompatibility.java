package project.gregica.integration.top;

import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;
import project.gregica.integration.top.provider.QubitContainerInfoProvider;
import project.gregica.integration.top.provider.ColorProvider;

public class TOPCompatibility {
    
    public static void initCompatibility(){
        ITheOneProbe top = TheOneProbe.theOneProbeImp;
        top.registerProvider(new ColorProvider());
        top.registerProvider(new QubitContainerInfoProvider());
    }
    
}
