package me.oganesson.gregica.common.top;

import gregtech.api.GTValues;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.integration.theoneprobe.provider.*;
import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.api.ITheOneProbe;
import me.oganesson.gregica.api.quantum.GCPPRecipeMaps;
import me.oganesson.gregica.api.quantum.QubitContainerInfoProvider;

import static gregtech.api.GTValues.UV;
import static gregtech.api.unification.ore.OrePrefix.circuit;

public class GCPPCapability {
    public static void registerCompatibility() {
        ITheOneProbe oneProbe = TheOneProbe.theOneProbeImp;
        oneProbe.registerProvider(new QubitContainerInfoProvider());
    }
}
