package project.gregica.common.tileentities.mte.multi.machines;


import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import project.gregica.api.recipe.GCRecipeMaps;
import project.gregica.client.GCTextures;
import project.gregica.common.block.GCMetaBlocks;
import project.gregica.common.block.metablock.GCMetaGearBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class MTEFlotationCellRegulator extends RecipeMapMultiblockController {
    public MTEFlotationCellRegulator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCRecipeMaps.FLOTATION_CELL_REGULATOR);
    }

    protected IBlockState getCasingState() {
        return GCMetaBlocks.GC_META_GEAR_BOX.getState(GCMetaGearBox.GearBoxType.INCONEL_CASING);
    }

    protected IBlockState getCasingState1() {
        return GCMetaBlocks.GC_META_GEAR_BOX.getState(GCMetaGearBox.GearBoxType.FLOTATION_CALL);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("##CCC##", "#CCCCC#", "CCCCCCC", "CCCCCCC", "CCCCCCC", "#CCCCC#", "##CCC##")
                .aisle("##CCC##", "#CCCCC#", "CCCCCCC", "CCCCCCC", "CCCCCCC", "#CCCCC#", "##CCC##")
                .aisle("#######", "###T###", "##T#T##", "#T###T#", "##T#T##", "###T###", "#######")
                .aisle("#######", "###T###", "##T#T##", "#T###T#", "##T#T##", "###T###", "#######")
                .aisle("#######", "###T###", "##T#T##", "#T###T#", "##T#T##", "###T###", "#######")
                .aisle("#######", "###T###", "##T#T##", "#T###T#", "##T#T##", "###T###", "#######")
                .aisle("#######", "###T###", "##T#T##", "#T###T#", "##T#T##", "###T###", "#######")
                .aisle("#######", "###T###", "##T#T##", "#T###T#", "##T#T##", "###T###", "#######")
                .aisle("#######", "#######", "###E###", "##ESE##", "###E###", "#######", "#######")
                .where('S', selfPredicate())
                .where('C', states(getCasingState()).setMinGlobalLimited(62)
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(1))
                         .or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2).setPreviewCount(1)))
                .where('T', states(getCasingState1()))
                .where('E', states(getCasingState()))
                .where('#', any())
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCTextures.FLOTATION_CELL_REGULATOR;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEFlotationCellRegulator(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCTextures.ALGAE_FARM;
    }

    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.recipeMapWorkable.isActive(), this.recipeMapWorkable.isWorkingEnabled());
    }

}
