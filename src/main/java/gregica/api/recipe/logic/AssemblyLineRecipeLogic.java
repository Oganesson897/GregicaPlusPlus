package gregica.api.recipe.logic;

import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.recipes.Recipe;
import gregica.api.capability.quantum.QubitConsumeRecipeLogic;

import javax.annotation.Nonnull;

public class AssemblyLineRecipeLogic extends QubitConsumeRecipeLogic {
    public AssemblyLineRecipeLogic(RecipeMapMultiblockController metaTileEntity) {
        super(metaTileEntity);
    }

    @Override
    public boolean checkRecipe(@Nonnull Recipe recipe) {
        boolean result = false;
        getInputBuses().forEach(buses -> {
        });
        return result;
    }
}
