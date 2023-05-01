package me.oganesson.gregica.api.recipe;

import crafttweaker.annotations.ZenRegister;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import me.oganesson.gregica.api.capability.quantum.QubitConsumerRecipeBuilder;
import me.oganesson.gregica.api.capability.quantum.QubitProducerRecipeBuilder;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.gcpp.recipe.GCPPRecipeMaps")
@ZenRegister

public class GCRecipeMaps {

    public static final RecipeMap<QubitProducerRecipeBuilder> SIMPLE_QUBIT_GENERATOR = new RecipeMap<>("simple_qubit_generator",
            1, 1, 0, 0, new QubitProducerRecipeBuilder(), false);

    public static final RecipeMap<QubitConsumerRecipeBuilder> RESEARCH_STATION = new RecipeMap<>("research_station",
            2, 1, 0, 0, new QubitConsumerRecipeBuilder(), false);

    public static final RecipeMap<FuelRecipeBuilder> NR_MKI = new RecipeMap<>("naquadah_reactor_mki",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);

    public static final RecipeMap<FuelRecipeBuilder> NR_MKII = new RecipeMap<>("naquadah_reactor_mkii",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
    public static final RecipeMap<FuelRecipeBuilder> NR_MKIII = new RecipeMap<>("naquadah_reactor_mkiii",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
    public static final RecipeMap<FuelRecipeBuilder> NR_MKIV = new RecipeMap<>("naquadah_reactor_mkiv",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
    public static final RecipeMap<FuelRecipeBuilder> NR_MKV = new RecipeMap<>("naquadah_reactor_mkv",
            1, 1, 0, 0, new FuelRecipeBuilder(), false)
            .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.BOX_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);

    public static final RecipeMap<SimpleRecipeBuilder> REPLICATOR = new RecipeMap<>("replication",
            1, 1, 4, 1, new SimpleRecipeBuilder(), false);
}
