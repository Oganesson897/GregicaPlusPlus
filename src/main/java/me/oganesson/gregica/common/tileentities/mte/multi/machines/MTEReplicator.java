package me.oganesson.gregica.common.tileentities.mte.multi.machines;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.api.capability.quantum.QubitRecipeMapMultiblockController;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.common.block.metablock.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MTEReplicator extends QubitRecipeMapMultiblockController {
    public MTEReplicator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCRecipeMaps.REPLICATOR);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCCCC", "CGGGC", "CGGGC", "CCCCC")
                .aisle("CUUUC", "GAAAG", "GAAAG", "CUUUC")
                .aisle("CUUUC", "GAAAG", "GAAAG", "CUMUC")
                .aisle("CUUUC", "GAAAG", "GAAAG", "CUUUC")
                .aisle("CCOCC", "CGGGC", "CGGGC", "CCCCC")
                .where('O', selfPredicate())
                .where('C', states(MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.FUSION_CASING))
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('G', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS)))
                .where('U', states(GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.MATTER_FABRICATION_CPU)))
                .where('M', autoAbilities(false, true))
                .where('A', air())
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.FUSION_REACTOR_OVERLAY;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEReplicator(metaTileEntityId);
    }
}
