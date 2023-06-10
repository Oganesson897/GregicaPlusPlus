package gregica.api.recipe.recipeproperties;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

import javax.annotation.Nonnull;

public class NoCoilTemperatureProperty extends RecipeProperty<Integer> {

    public static final String KEY = "temperature";

    private static NoCoilTemperatureProperty INSTANCE;

    private NoCoilTemperatureProperty() {
        super(KEY, Integer.class);
    }

    public static NoCoilTemperatureProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NoCoilTemperatureProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(@Nonnull Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gregica.recipe.temperature", castValue(value)), x, y, color);
    }
}
