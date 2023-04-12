package me.oganesson.gregica.common.gregtech;

import gregtech.api.GTValues;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import me.oganesson.gregica.api.quantum.GCPPRecipeMaps;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.UV;
import static gregtech.api.unification.material.Materials.DistilledWater;
import static gregtech.api.unification.material.Materials.MetalMixture;
import static gregtech.api.unification.ore.OrePrefix.circuit;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class FuelRecipe {
    public static void registerQubitGeneratorFuel(OrePrefix prefix, Material material, int duration, int tier, int qubit) {
        GCPPRecipeMaps.SIMPLE_QUBIT_GENERATOR.recipeBuilder()
                .qubit(qubit)
                .input(prefix, material)
                .duration(duration)
                .EUt((int) GTValues.V[tier])
                .output(dust, MetalMixture)
                .buildAndRegister();
    }

    public static void init(){

        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.IV,          100, UV, 1);
        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.LuV,         200, UV, 2);
        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.ZPM,       400, UV, 4);
        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.UV, 1200, UV, 4);
        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.UHV,       1600, UV, 8);
        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.UEV,            4800, UV, 8);
        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.UIV,            6400, UV, 16);
        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.UXV,            19_200, UV, 16);
        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.OpV,            25_600, UV, 32);
        registerQubitGeneratorFuel(circuit, MarkerMaterials.Tier.MAX,            51_200, UV, 64);
    }
}
