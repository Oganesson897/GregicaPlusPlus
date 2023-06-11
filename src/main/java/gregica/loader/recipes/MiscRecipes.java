package gregica.loader.recipes;

import gregica.modules.gcys.api.unification.materials.GCYSMaterials;
import gregica.modules.gcys.common.metablock.BlockTransparentCasing;
import gregica.modules.gcys.common.metablock.GCYSMetaBlocks;

import static gregtech.api.GTValues.IV;
import static gregtech.api.GTValues.VA;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.Water;
import static gregtech.api.unification.ore.OrePrefix.*;

/**
 * Use this class to add miscellaneous recipes which have no category otherwise
 */
public class MiscRecipes {

    public static void init() {
        metaBlockRecipes();

        //TODO add Iodine-131 gas or liquid
        MIXER_RECIPES.recipeBuilder()
                .input(dust, GCYSMaterials.Alumina)
                .input("blockSand", 3)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(GCYSMaterials.FracturingFluid.getFluid(1000))
                .duration(100).EUt(VA[IV]).buildAndRegister();

        // c-BN sawblade
        LATHE_RECIPES.recipeBuilder()
                .input(gemExquisite, GCYSMaterials.CubicBoronNitride)
                .output(toolHeadBuzzSaw, GCYSMaterials.CubicBoronNitride)
                .duration((int) (GCYSMaterials.CubicBoronNitride.getMass() * 4)).EUt(240).buildAndRegister();
    }

    private static void metaBlockRecipes() {
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(plate, GCYSMaterials.PMMA, 4)
                .outputs(GCYSMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.CasingType.PMMA))
                .duration(400).EUt(2).buildAndRegister();
    }
}
