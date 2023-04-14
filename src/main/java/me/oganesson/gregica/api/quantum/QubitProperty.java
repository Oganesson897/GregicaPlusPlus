package me.oganesson.gregica.api.quantum;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

import javax.annotation.Nonnull;

public class QubitProperty extends RecipeProperty<Integer> {

    public static final String KEY = "qubitProduce";

    private static QubitProperty INSTANCE;

    private QubitProperty() {
        super(KEY, Integer.class);
    }

    public static QubitProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QubitProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gregica.recipe.qubitProduce", castValue(value)), x, y, color);
    }
}