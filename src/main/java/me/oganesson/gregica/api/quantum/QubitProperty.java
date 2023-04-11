package me.oganesson.gregica.api.quantum;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
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
    public void drawInfo(@Nonnull Minecraft minecraft, int x, int y, int color, Object value) {
        Integer casted = castValue(value);
        minecraft.fontRenderer.drawString(I18n.format(casted > 1 ? "gcpp.recipe.pressure" : "gcys.recipe.vacuum",
                NumberFormattingUtil.formatDoubleToCompactString(casted)), x, y, color);
    }
}