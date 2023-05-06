package me.oganesson.gregica.common.tileentities.mte.multi.machines;

import gregtech.api.GTValues;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.api.predicate.AlgaeFarmPredicate;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import me.oganesson.gregica.common.recipes.recipemap.ChemicalPlantLogic;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MTEChemicalPlant extends RecipeMapMultiblockController {

    public MTEChemicalPlant(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCRecipeMaps.CHEMICAL_PLANT);
        this.recipeMapWorkable = new ChemicalPlantLogic(this);
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("EEEEEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                .aisle("EEESEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                .where('S', selfPredicate())
                .where('E', states(getBaseCasingState())
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setMinGlobalLimited(1).setExactLimit(1))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2).setPreviewCount(1)))
                .where('C', casing())
                .where('X', heatingCoils())
                .where('M', AlgaeFarmPredicate.MACHINECASINGS)
                .where('T', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE)).or(states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE))).or(states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE))))
                .where('#', any())
                .build();
    }

    private TraceabilityPredicate casing(){
        return states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS))
                .or(states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID)))
                .or(states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF)))
                .or(states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN)))
                .or(states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE)))
                .or(states(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST)));
    }

    protected IBlockState getBaseCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.BRONZE_PLATED_BRICKS;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEChemicalPlant(metaTileEntityId);
    }

    @Override
    protected void updateFormedValid() {
        if (!this.hasMufflerMechanics() || this.isMufflerFaceFree()) {
            this.recipeMapWorkable.updateWorkable();
        }
    }

    public boolean drainEnergy(int recipeEUt, boolean simulate) {
        long resultEnergy = energyContainer.getEnergyStored() - (long) recipeEUt;
        if (resultEnergy >= 0L && resultEnergy <= energyContainer.getEnergyCapacity()) {
            if (!simulate)
                energyContainer.changeEnergy(-(long) recipeEUt);
            return true;
        }
        return false;
    }
}
