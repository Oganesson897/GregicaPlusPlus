package gregica.integration.top;

import gregica.integration.top.provider.ColorProvider;
import gregica.integration.top.provider.QubitContainerInfoProvider;
import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;

public class TOPCompatibility {
    
    public static void initCompatibility(){
        ITheOneProbe top = TheOneProbe.theOneProbeImp;
        top.registerProvider(new ColorProvider());
        top.registerProvider(new QubitContainerInfoProvider());
    }
    
}
