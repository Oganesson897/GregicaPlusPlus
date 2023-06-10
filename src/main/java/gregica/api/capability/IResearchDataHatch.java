package gregica.api.capability;

import gregtech.api.recipes.Recipe;

import javax.annotation.Nonnull;
import java.util.Set;

public interface IResearchDataHatch {

    @Nonnull
    Set<Recipe> getCanAssemblyRecipes();

    boolean isCreative();

}
