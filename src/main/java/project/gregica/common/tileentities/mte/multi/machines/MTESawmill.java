package project.gregica.common.tileentities.mte.multi.machines;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockSteamCasing;
import gregtech.common.blocks.MetaBlocks;
import project.gregica.api.recipe.GCRecipeMaps;
import project.gregica.common.block.GCMetaBlocks;
import project.gregica.common.block.metablock.GCMetaCasing;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MTESawmill extends RecipeMapMultiblockController {
    public MTESawmill(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCRecipeMaps.SAWMILL);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCC", "CGC", "#C#")
                .aisle("CBC", "G#G", "#C#")
                .aisle("CBC", "G#G", "#C#")
                .aisle("CBC", "G#G", "#C#")
                .aisle("COC", "CGC", "#C#")
                .where('O', selfPredicate())
                .where('B', states(GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.SAWMILL_BLADE)))
                .where('C', states(MetaBlocks.STEAM_CASING.getState(BlockSteamCasing.SteamCasingType.WOOD_WALL))
                        .or(autoAbilities(true, false, true, true, true, false, false)))
                .where('#', any())
                .where('G', states(Blocks.GLASS.getDefaultState()))
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.WOOD_WALL;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTESawmill(metaTileEntityId);
    }
}
