package me.oganesson.gregica.api.capability.isa_mill;

import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import org.apache.commons.lang3.Validate;

import java.util.Map;
import java.util.TreeMap;

public class IsaMillProperties extends RecipeProperty<Integer> {

    public static final String KEY = "grindball_level";

    private static final TreeMap<Integer, String> registeredGrindBallTiers = new TreeMap<>();

    private static IsaMillProperties INSTANCE;

    private IsaMillProperties() {
        super(KEY, Integer.class);
    }

    public static IsaMillProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IsaMillProperties();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(getGrindBallTier(castValue(value)), x, y, color);
    }

    private static String getGrindBallTier(Integer eu) {
        Map.Entry<Integer, String> mapEntry = registeredGrindBallTiers.ceilingEntry(eu);

        if (mapEntry == null) {
            throw new IllegalArgumentException("Value is above registered maximum EU values");
        }

        return String.format(" %s", mapEntry.getValue());
    }


    public static void registerBallTier(int tier, String shortName) {
        Validate.notNull(shortName);
        registeredGrindBallTiers.put(tier, shortName);
    }
}
