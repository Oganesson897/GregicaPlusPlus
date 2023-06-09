package project.gregica.common.tileentities.mte.multi.machines;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import project.gregica.api.recipe.GCRecipeMaps;
import project.gregica.client.GCTextures;
import project.gregica.common.block.GCMetaBlocks;
import project.gregica.common.block.metablock.GCMetaCasing;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MTEReplicator extends RecipeMapMultiblockController {
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
                .where('C', states(GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.REPLICATOR_CASING))
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('G', states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.LAMINATED_GLASS)))
                .where('U', states(GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.MATTER_FABRICATION_CPU)))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('A', air())
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCTextures.REPLICATOR;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEReplicator(metaTileEntityId);
    }
}
