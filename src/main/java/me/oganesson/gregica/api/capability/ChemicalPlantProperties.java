package me.oganesson.gregica.api.capability;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class ChemicalPlantProperties extends RecipeProperty<Integer> {

    public static final String KEY = "machineLevel";

    private static ChemicalPlantProperties INSTANCE;

    private ChemicalPlantProperties() {
        super(KEY, Integer.class);
    }

    public static ChemicalPlantProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ChemicalPlantProperties();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("tier" + value), x, y, color);
    }
}
