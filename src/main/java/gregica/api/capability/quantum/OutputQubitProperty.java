package gregica.api.capability.quantum;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class OutputQubitProperty extends RecipeProperty<Integer> {

    public static final String KEY = "qubitConsume";

    private static OutputQubitProperty INSTANCE;

    private OutputQubitProperty() {
        super(KEY, Integer.class);
    }

    public static OutputQubitProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OutputQubitProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gregica.recipe.qubitConsume", castValue(value)), x, y, color);
    }
}