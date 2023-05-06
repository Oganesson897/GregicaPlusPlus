package me.oganesson.gregica.common.tileentities.mte.multi.machines;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.blocks.*;
import me.oganesson.gregica.api.capability.ChemicalPlantProperties;
import me.oganesson.gregica.api.predicate.AlgaeFarmPredicate;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

import static gregtech.api.GTValues.VA;

public class MTEChemicalPlant extends RecipeMapMultiblockController {

    private int coilLevel;

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
                .where('T', states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE)).or(states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE))).or(states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE))).or(states(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE))))
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
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object coilType = context.get("CoilType");
        if (coilType instanceof IHeatingCoilBlockStats) {
            this.coilLevel = ((IHeatingCoilBlockStats) coilType).getLevel();
        } else {
            this.coilLevel = BlockWireCoil.CoilType.CUPRONICKEL.getLevel();
        }
    }

    protected class ChemicalPlantLogic extends MultiblockRecipeLogic {

        private int CasingTier;
        private int MachineTier;
        private int tubeTier;

        public ChemicalPlantLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity);
        }

        public void update() {
            if (metaTileEntity.getWorld().isRemote)
                return;

            checkCasingTier();
            checkMachineTier();
            checkTubeTier();
        }

        public double getProgressPercent() {
            return this.getMaxProgress() == 0 ? 0.0D : (double)this.getProgress() / ((double)this.getMaxProgress() * 1.0D);
        }

        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = maxProgress / (2 * coilLevel);
            this.metaTileEntity.markDirty();
        }

        public int getMaxProgress() {
            return this.maxProgressTime / (2 * coilLevel);
        }

        protected long getMaxVoltage() {
            return Math.min(super.getMaxVoltage(), VA[CasingTier]);
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            if (!super.checkRecipe(recipe))
                return false;

            if (recipe.getProperty(ChemicalPlantProperties.getInstance(), 0) > this.MachineTier)
                return false;

            return true;
        }

        @Override
        public int getParallelLimit() {
            return 2 * tubeTier;
        }

        private void checkCasingTier() {
            EnumFacing facing = metaTileEntity.getFrontFacing();
            if (facing.getIndex() == 2) {
                BlockPos pos = metaTileEntity.getPos().add(0, 0, 1);
                getCasingTire(pos);
            } else if (facing.getIndex() == 3) {
                BlockPos pos = metaTileEntity.getPos().add(0, 0, -1);
                getCasingTire(pos);
            } else if (facing.getIndex() == 4) {
                BlockPos pos = metaTileEntity.getPos().add(1, 0, 0);
                getCasingTire(pos);
            } else if (facing.getIndex() == 5) {
                BlockPos pos = metaTileEntity.getPos().add(-1, 0, 0);
                getCasingTire(pos);
            } else
                this.CasingTier = 0;
        }

        private void checkTubeTier() {
            EnumFacing facing = metaTileEntity.getFrontFacing();
            if (facing.getIndex() == 2) {
                BlockPos pos = metaTileEntity.getPos().add(0, 2, 2);
                getTubeTier(pos);
            } else if (facing.getIndex() == 3) {
                BlockPos pos = metaTileEntity.getPos().add(0, 2, -2);
                getTubeTier(pos);
            } else if (facing.getIndex() == 4) {
                BlockPos pos = metaTileEntity.getPos().add(2, 2, 0);
                getTubeTier(pos);
            } else if (facing.getIndex() == 5) {
                BlockPos pos = metaTileEntity.getPos().add(-2, 2, 0);
                getTubeTier(pos);
            } else
                this.tubeTier = 0;
        }

        private void checkMachineTier() {
            BlockPos pos = metaTileEntity.getPos().add(0, 6, 0);
            getMachineTire(pos);
        }

        private void getCasingTire(BlockPos pos) {
            if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ULV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 0;
            } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 1;
            } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.MV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 2;
            } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.HV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 3;
            } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.EV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 4;
            } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.IV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 5;
            } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LuV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 6;
            } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ZPM).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 7;
            } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 8;
            } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UHV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.CasingTier = 9;
            } else {
                this.CasingTier = 9;
            }
        }

        private void getTubeTier(BlockPos pos) {
            if (MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.tubeTier = 1;
            } else if (MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.tubeTier = 2;
            } else if (MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.tubeTier = 3;
            } else {
                this.tubeTier = 0;
            }
        }

        private void getMachineTire(BlockPos pos) {
            if (MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.MachineTier = 0;
            } else if (MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.MachineTier = 1;
            } else if (MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.MachineTier = 2;
            } else if (MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.MachineTier = 3;
            } else if (MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.MachineTier = 4;
            } else if (MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST).equals(metaTileEntity.getWorld().getBlockState(pos))) {
                this.MachineTier = 5;
            } else this.MachineTier = 6;
        }
    }
}
