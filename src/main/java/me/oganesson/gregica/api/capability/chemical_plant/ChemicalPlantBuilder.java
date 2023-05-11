package me.oganesson.gregica.api.capability.chemical_plant;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class ChemicalPlantBuilder extends RecipeBuilder<ChemicalPlantBuilder> {

    public ChemicalPlantBuilder() {

    }

    public ChemicalPlantBuilder(Recipe recipe, RecipeMap<ChemicalPlantBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public ChemicalPlantBuilder(RecipeBuilder<ChemicalPlantBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public ChemicalPlantBuilder copy() {
        return new ChemicalPlantBuilder(this);
    }

    public int getLevel() {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(ChemicalPlantProperties.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(ChemicalPlantProperties.KEY)) {
            this.recipeLevel(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public ChemicalPlantBuilder recipeLevel(int level) {
        if (level <= 0) {
            GTLog.logger.error("Blast Furnace Temperature cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(ChemicalPlantProperties.getInstance(), level);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(ChemicalPlantProperties.getInstance().getKey(), getLevel())
                .toString();
    }
}