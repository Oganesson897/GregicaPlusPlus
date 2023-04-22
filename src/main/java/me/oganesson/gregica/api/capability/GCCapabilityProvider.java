package me.oganesson.gregica.api.capability;

import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;
import me.oganesson.gregica.api.capability.quantum.QubitContainerInfoProvider;

public class GCCapabilityProvider {
    public static void registerCompatibility() {
        ITheOneProbe oneProbe = TheOneProbe.theOneProbeImp;
        oneProbe.registerProvider(new QubitContainerInfoProvider());
    }
}
