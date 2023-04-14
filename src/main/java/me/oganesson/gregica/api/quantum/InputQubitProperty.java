package me.oganesson.gregica.api.quantum;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class InputQubitProperty extends RecipeProperty<Integer> {

    public static final String KEY = "qubitProduce";

    private static InputQubitProperty INSTANCE;

    private InputQubitProperty() {
        super(KEY, Integer.class);
    }

    public static InputQubitProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InputQubitProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        Integer casted = castValue(value);
        minecraft.fontRenderer.drawString(I18n.format("gregica.recipe.qubitProduce", castValue(value)), x, y, color);
    }
}