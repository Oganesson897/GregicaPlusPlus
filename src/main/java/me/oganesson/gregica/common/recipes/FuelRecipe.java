package me.oganesson.gregica.common.recipes;

import gregtech.api.GTValues;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;

import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.UV;
import static gregtech.api.unification.material.Materials.MetalMixture;
import static gregtech.api.unification.ore.OrePrefix.circuit;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class FuelRecipe {
    public static void registerQubitGeneratorFuel(OrePrefix prefix, Material material, int duration, int tier, int qubit) {
        GCRecipeMaps.SIMPLE_QUBIT_GENERATOR.recipeBuilder()
                .qubit(qubit)
                .input(prefix, material)
                .duration(duration)
                .EUt((int) GTValues.V[tier])
                .output(dust, MetalMixture)
                .buildAndRegister();
    }

    @Nonnull
    public static NBTTagCompound generateResearchNBT(@Nonnull String researchId) {
        if (researchId.isEmpty()) throw new IllegalArgumentException("Assemblyline researchId cannot be empty");
        NBTTagCompound compound = new NBTTagCompound();
        compound.setString("researchId", researchId);
        return compound;
    }

    public static void registerResearchStationResearch(ItemStack researchItem, int duration, int tier, int qubit, String researchId) {

        NBTTagCompound compound = new NBTTagCompound();
        compound.setTag("assemblylineResearch", generateResearchNBT(researchId));

        ItemStack dataStick = MetaItems.TOOL_DATA_STICK.getStackForm();
        dataStick.setTagCompound(compound);

        GCRecipeMaps.RESEARCH_STATION.recipeBuilder()
                .qubit(qubit)
                .inputs(researchItem)
                .input(MetaItems.TOOL_DATA_STICK)
                .duration(duration)
                .EUt((int) GTValues.V[tier])
                .outputs(dataStick)
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

        registerResearchStationResearch(new ItemStack(Items.BREAD), 99, IV, 1, "baguette_sword");
    }
}
