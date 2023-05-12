package me.oganesson.gregica.common.recipes;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.ConfigHolder;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.common.unification.ore.GCOrePrefix;

import javax.annotation.Nonnull;

import static me.oganesson.gregica.common.unification.ore.GCMaterialFlags.GENERATE_MILLED;

//TODO: 修修它！
public class GCIsaProcessLine {

    public static void register(){
        OrePrefix.ore.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
        OrePrefix.oreNetherrack.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
        OrePrefix.oreEndstone.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
        if (ConfigHolder.worldgen.allUniqueStoneTypes) {
            OrePrefix.oreGranite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreDiorite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreAndesite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreBasalt.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreBlackgranite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreMarble.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreRedgranite.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreSand.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
            OrePrefix.oreRedSand.addProcessingHandler(PropertyKey.ORE, GCIsaProcessLine::processIsaMill);
        }
    }

    public static void processIsaMill(OrePrefix ore, @Nonnull Material material, OreProperty property) {
        if(!material.hasFlag(GENERATE_MILLED))
            return;

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.ore, material, 16)
                .circuitMeta(11)
                .duration(3000)
                .getTier(1)
                .EUt(7680)
                .outputs(OreDictUnifier.get(GCOrePrefix.oreMilled, material, 48))
                .buildAndRegister();

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.crushed, material, 16)
                .circuitMeta(11)
                .getTier(1)
                .duration(1500)
                .EUt(7680)
                .output(GCOrePrefix.oreMilled, material, 16)
                .buildAndRegister();

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.crushed, material, 16)
                .circuitMeta(10)
                .getTier(2)
                .duration(1200)
                .EUt(7680)
                .output(GCOrePrefix.oreMilled, material, 32)
                .buildAndRegister();

        GCRecipeMaps.ISAMILL_GRINDER.recipeBuilder()
                .input(OrePrefix.ore, material, 16)
                .circuitMeta(10)
                .getTier(2)
                .duration(2400)
                .EUt(7680)
                .output(GCOrePrefix.oreMilled, material, 64)
                .output(GCOrePrefix.oreMilled, material, 32)
                .buildAndRegister();
    }
}
