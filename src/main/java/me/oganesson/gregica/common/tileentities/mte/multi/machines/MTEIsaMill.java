package me.oganesson.gregica.common.tileentities.mte.multi.machines;


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
import gregtech.client.renderer.texture.Textures;
import me.oganesson.gregica.api.capability.GCCapabilities;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import me.oganesson.gregica.common.block.metablock.GCMetaGearBox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MTEIsaMill extends RecipeMapMultiblockController {
    public MTEIsaMill(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCRecipeMaps.ISAMILL_GRINDER);
    }

    protected IBlockState getCasingState() {
        return GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.ISA_MILL_CASING);
    }

    protected IBlockState getCasingState1() {
        return GCMetaBlocks.GC_META_GEAR_BOX.getState(GCMetaGearBox.GearBoxType.ISA_MILL_GEARBOX);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("EEE", "EEE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "EGE", "EEE")
                .aisle("EEE", "ESE", "EEE")
                .where('S', selfPredicate())
                .where('E', states(getCasingState()).setMinGlobalLimited(39)
                        .or(abilities(MultiblockAbility.MUFFLER_HATCH).setExactLimit(1))
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
                        .or(abilities(GCCapabilities.GRINDBALL).setExactLimit(1))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                         .or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2).setPreviewCount(1)))
                .where('G', states(getCasingState1()))
                .where('#', any())
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GCTextures.ISA_MILL_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEIsaMill(metaTileEntityId);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        Textures.ROTOR_HOLDER_OVERLAY.renderSided(getFrontFacing(), renderState, translation, pipeline);
        GCTextures.ISA_MILL.renderSided(renderState, translation, pipeline, getFrontFacing(), isStructureFormed(), this.getRecipeLogic().isActive());
    }

}
