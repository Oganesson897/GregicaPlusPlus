package me.oganesson.gregica.common.tileentities.mte.multi.machines;

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
import me.oganesson.gregica.api.capability.quantum.QubitConsumeRecipeLogic;
import me.oganesson.gregica.api.capability.quantum.QubitRecipeMapMultiblockController;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.block.metablock.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;


public class MTEResearchStation extends QubitRecipeMapMultiblockController implements IWorkable {
    public MTEResearchStation(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCRecipeMaps.RESEARCH_STATION);
        this.recipeMapWorkable = new QubitConsumeRecipeLogic(this);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEResearchStation(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCC", "DDD", "BBB", "BBB", "BBB", "DDD", "CCC")
                .aisle("CCC", "DCD", "DCD", "DCD", "DCD", "DCD", "CCC")
                .aisle("CCC", "DDD", "CDC", "CSC", "CDC", "DDD", "CCC")
                .aisle("CCC", "CDC", "###", "###", "###", "CDC", "CCC")
                .aisle("#C#", "CDC", "###", "###", "###", "CDC", "#C#")
                .aisle("#C#", "CDC", "#D#", "#A#", "#D#", "CDC", "#C#")
                .aisle("###", "CCC", "###", "###", "###", "CCC", "###")
                .where('#', any())
                .where('S', selfPredicate())
                .where('C', states(getCasingState()))
                .where('A', abilities(MultiblockAbility.IMPORT_ITEMS))
                .where('B', states(getCasingState1()).or(abilities(MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1)).or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1)).or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1)).or(abilities(GCCapabilities.INPUT_QBIT).setMinGlobalLimited(1)))
                .where('D', states(getCasingState1()))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCTextures.QUBIT_GENERATOR_CASING;
    }

    protected IBlockState getCasingState() {
        return GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.QUANTUM_CASING);
    }

    protected IBlockState getCasingState1() {
        return GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.QUANTUM_GENERATOR_CASING);
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCTextures.RESEARCH_STATION_OVERLAY;
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
