package project.gregica.api.capability.isa_mill;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTLog;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class IsaMillBuilder extends RecipeBuilder<IsaMillBuilder> {

    public IsaMillBuilder() {

    }

    public IsaMillBuilder(Recipe recipe, RecipeMap<IsaMillBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public IsaMillBuilder(RecipeBuilder<IsaMillBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public IsaMillBuilder copy() {
        return new IsaMillBuilder(this);
    }

    public int getLevel() {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(IsaMillProperties.getInstance(), 0);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(IsaMillProperties.KEY)) {
            this.getTier(((Number) value).intValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    public IsaMillBuilder getTier(int level) {
        if (level <= 0) {
            GTLog.logger.error("Blast Furnace Temperature cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(IsaMillProperties.getInstance(), level);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(IsaMillProperties.getInstance().getKey(), getLevel())
                .toString();
    }
}