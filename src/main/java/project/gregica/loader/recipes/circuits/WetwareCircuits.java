package project.gregica.loader.recipes.circuits;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import project.gregica.module.gcys.api.unification.materials.material.GCYSMaterials;
import project.gregica.config.GCConfigValue;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.AUTOCLAVE_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static project.gregica.module.gcys.api.unification.materials.material.GCYSMaterials.KaptonK;

public class WetwareCircuits {

    public static void init() {
        // Harder Wetware
        if (GCConfigValue.harderWetwareCircuits) {
            GTRecipeHandler.removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{
                            MULTILAYER_FIBER_BOARD.getStackForm(16),
                            PETRI_DISH.getStackForm(),
                            ELECTRIC_PUMP_LuV.getStackForm(),
                            SENSOR_IV.getStackForm(),
                            OreDictUnifier.get(circuit, MarkerMaterials.Tier.IV),
                            OreDictUnifier.get(foil, NiobiumTitanium, 16)},
                    new FluidStack[]{SterileGrowthMedium.getFluid(4000)});
        }

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, KaptonK, 16)
                .input(PETRI_DISH)
                .input(ELECTRIC_PUMP_LuV)
                .input(SENSOR_IV)
                .input(circuit, MarkerMaterials.Tier.IV)
                .input(foil, NiobiumTitanium, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(4000))
                .output(WETWARE_BOARD, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .duration(1200).EUt(VA[LuV]).buildAndRegister();

        // Fix autoclave recipe to obtain wetware mainframes
        GTRecipeHandler.removeRecipesByInputs(AUTOCLAVE_RECIPES,
                new ItemStack[]{QUANTUM_STAR.getStackForm()},
                new FluidStack[]{Neutronium.getFluid(L * 2)});

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(QUANTUM_STAR)
                .fluidInputs(GCYSMaterials.Orichalcum.getFluid(L * 2))
                .output(GRAVI_STAR)
                .duration(480).EUt(VA[IV]).buildAndRegister();
    }
}
