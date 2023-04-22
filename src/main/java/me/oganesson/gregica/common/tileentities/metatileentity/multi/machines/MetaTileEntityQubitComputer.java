package me.oganesson.gregica.common.tileentities.metatileentity.multi.machines;

import gregtech.api.capability.IWorkable;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import me.oganesson.gregica.api.capability.GCCapabilities;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.common.recipes.recipemap.QubitProducerRecipeLogic;
import me.oganesson.gregica.api.capability.quantum.QubitRecipeMapMultiblockController;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.block.metablock.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;


public class MetaTileEntityQubitComputer extends QubitRecipeMapMultiblockController implements IWorkable {
    public MetaTileEntityQubitComputer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCRecipeMaps.SIMPLE_QUBIT_GENERATOR);
        this.recipeMapWorkable = new QubitProducerRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityQubitComputer(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCC", "CCCC", "CCCC", "CCCC")
                .aisle("CCCC", "CSCC", "CCCC", "CCCC")
                .where('S', selfPredicate())
                .where('C', states(getCasingState()).setMinGlobalLimited(24).or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1)).or(abilities(MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1)).or(abilities(MultiblockAbility.EXPORT_ITEMS).setExactLimit(1)).or(abilities(GCCapabilities.OUTPUT_QBIT).setExactLimit(1)).or(abilities( MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1)))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCTextures.QUANTUM_CASING;
    }

    protected IBlockState getCasingState() {
        return GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.QUANTUM_CASING);
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCTextures.QUBIT_COMPUTER_OVERLAY;
    }

    @Override
    public int getProgress() {
        return this.recipeMapWorkable.getProgress();
    }

    @Override
    public int getMaxProgress() {
        return this.recipeMapWorkable.getMaxProgress();
    }

    @Override
    public boolean isWorkingEnabled() {
        return this.recipeMapWorkable.isWorkingEnabled();
    }

    @Override
    public void setWorkingEnabled(boolean e) {
        this.recipeMapWorkable.setWorkingEnabled(e);
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }
}
