package me.oganesson.gregica.common.tileentities.mte.multi.machines;


import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaGearBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class MTEVacuumFurnace extends GCYMRecipeMapMultiblockController {
    public MTEVacuumFurnace(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[]{GCRecipeMaps.VACUUM_FURNACE, GCRecipeMaps.DRYER_RECIPES});
    }

    protected IBlockState getCasingState() {
        return GCMetaBlocks.GC_META_GEAR_BOX.getState(GCMetaGearBox.GearBoxType.VACUUM_CASING);
    }
    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "CCC", "CCC", "CCC", "XXX")
                .aisle("XXX", "C#C", "C#C", "C#C", "XMX")
                .aisle("XSX", "CCC", "CCC", "CCC", "XXX")
                .where('S', this.selfPredicate())
                .where('X', states(this.getCasingState()).setMinGlobalLimited(9)
                        .or(this.autoAbilities(true, true, true, true, true, true, false)))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('C', heatingCoils())
                .where('#', air()).build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCTextures.VACUUM_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEVacuumFurnace(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCTextures.CHEMICAL_PLANT;
    }

    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.recipeMapWorkable.isActive(), this.recipeMapWorkable.isWorkingEnabled());
    }

}
