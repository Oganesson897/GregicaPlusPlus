package me.oganesson.gregica.common.recipes.circuits;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.api.unification.materials.GCYSMaterials;
import me.oganesson.gregica.common.block.GCYSMetaBlocks;
import me.oganesson.gregica.common.block.gcysblocks.BlockGCYSMultiblockCasing;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;
import me.oganesson.gregica.common.tileentities.mte.GCMetaEntities;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.OpV;
import static gregtech.api.GTValues.UXV;

public class SuprachronalCircuits {

    private static final ItemStack[] SUPRACHRONAL_CIRCUITS = {
            GCMetaItems.SUPRACHRONAL_ULV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_LV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_MV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_HV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_EV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_IV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_LuV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_ZPM.getStackForm(),
            GCMetaItems.SUPRACHRONAL_UV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_UHV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_UEV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_UIV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_UXV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_OpV.getStackForm(),
            GCMetaItems.SUPRACHRONAL_MAX.getStackForm(),
    };

    public static void init() {
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(OrePrefix.plate, GCYSMaterials.ReissnerNordstromMatrix)
                .input(OrePrefix.frameGt, GCYSMaterials.ReissnerNordstromMatrix)
                .input(OrePrefix.stick, GCYSMaterials.ReissnerNordstromMatrix)
                .input(OrePrefix.stick, GCYSMaterials.QCDConfinedMatter)
                .fluidInputs(Materials.Neutronium.getFluid(1296))
                .fluidInputs(GCYSMaterials.SentientMetal.getFluid(1296))
                .outputs(GCYSMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockGCYSMultiblockCasing.CasingType.SUPRACHRONAL_CASING))
                .duration(200)
                .EUt(GTValues.VA[UXV])
                .buildAndRegister();

        //TODO Add Teralloy and make its fluid used in this recipe
        //TODO Add Quark-Gluon plasma and make its fluid used in this recipe
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(GCYSMetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockGCYSMultiblockCasing.CasingType.SUPRACHRONAL_CASING))
                .inputs(MetaItems.EMITTER_OpV.getStackForm())
                .inputs(MetaItems.SENSOR_OpV.getStackForm())
                .inputs(MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.UXV))
                .inputs(GCMetaItems.EIGENFOLDED_KERR_MANIFOLD.getStackForm())
                .input(OrePrefix.plate, GCYSMaterials.QCDConfinedMatter)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.MAX)
                .fluidInputs(GCYSMaterials.Taranium.getFluid(144))
                .fluidInputs(GCYSMaterials.SentientMetal.getFluid(1296))
                .outputs(GCMetaEntities.SUPRACHRONAL_ASSEMBLER.getStackForm())
                .duration(600)
                .EUt(GTValues.VA[OpV])
                .buildAndRegister();

        //TODO Add Trinium-Tritanium and use it as a fluid input for this
        RecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .inputs(MetaItems.SENSOR_OpV.getStackForm())
                .inputs(MetaItems.ROBOT_ARM_OpV.getStackForm())
                .inputs(MetaItems.FIELD_GENERATOR_OpV.getStackForm())
                .inputs(MetaItems.ELECTRIC_PUMP_OpV.getStackForm())
                .input(OrePrefix.plate, GCYSMaterials.ReissnerNordstromMatrix, 16)
                .input(OrePrefix.circuit, MarkerMaterials.Tier.MAX, 8)
                .input(OrePrefix.battery, MarkerMaterials.Tier.MAX, 2)
                .fluidInputs(Materials.Naquadria.getFluid(1296))
                .fluidInputs(GCYSMaterials.Taranium.getFluid(1296))
                .fluidInputs(GCYSMaterials.SentientMetal.getFluid(1296))
                .outputs(GCMetaItems.HYPERDIMENSIONAL_DRONE.getStackForm())
                .duration(600)
                .EUt(GTValues.VA[OpV])
                .buildAndRegister();

        for(int i = 0; i < GTValues.V.length; i++) {
            GCRecipeMaps.SUPRACHRONAL_ASSEMBLER_RECIPES.recipeBuilder()
                    .notConsumable(GCMetaItems.HYPERDIMENSIONAL_DRONE.getStackForm())
                    .notConsumable(new IntCircuitIngredient(i))
                    .outputs(SUPRACHRONAL_CIRCUITS[i])
                    .duration(600)
                    .EUt(GTValues.VA[i])
                    .buildAndRegister();
        }
    }
}
