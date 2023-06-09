package project.gregica.api.recipe.builders;

import project.gregica.api.recipe.GCRecipeMaps;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.Map;

public class HeatExchangerRecipeBuilder {

    public final Fluid heatFluid;
    public final int superheatedSteamThreshold;
    public final int maxInputVolume;
    public final int steamGenerateMultiplier;

    public static Map<Fluid, HeatExchangerRecipeBuilder> map;

    private HeatExchangerRecipeBuilder(Fluid heatFluid, int superheatedSteamThreshold, int maxInputVolume, int steamGenerateMultiplier) {
        this.heatFluid = heatFluid;
        this.superheatedSteamThreshold = superheatedSteamThreshold;
        this.maxInputVolume = maxInputVolume;
        this.steamGenerateMultiplier = steamGenerateMultiplier;
        map.put(heatFluid, this);
    }

    public static HeatExchangerRecipeBuilder create(FluidStack heatFluid, int superheatedSteamThreshold, int maxInputVolume, int steamGenerateMultiplier, FluidStack output) {
        GCRecipeMaps.HEAT_EXCHANGER.recipeBuilder()
                .fluidInputs(heatFluid)
                .fluidOutputs(output)
                .build();
        return new HeatExchangerRecipeBuilder(heatFluid.getFluid(), superheatedSteamThreshold, maxInputVolume, steamGenerateMultiplier);
    }

}
