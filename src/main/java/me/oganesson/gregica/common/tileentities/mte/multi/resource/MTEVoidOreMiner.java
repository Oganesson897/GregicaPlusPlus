package me.oganesson.gregica.common.tileentities.mte.multi.resource;

import gregtech.api.GTValues;
import gregtech.api.capability.IMiner;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.pipelike.itempipe.ItemPipeType;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import me.oganesson.gregica.common.block.metablock.GCMetaGlasses;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class MTEVoidOreMiner extends MultiblockWithDisplayBase implements ITieredMetaTileEntity {
    private int tier;
    public MTEVoidOreMiner(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId);
        this.tier = tier;
    }

    @Override
    public int getTier() {
        return tier;
    }

    @Override
    protected void updateFormedValid() {
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("#####CCCCC#####", "#####CGGGC#####", "#####CGIGC#####", "#####CGGGC#####", "###############", "###############")
                .aisle("####CCCCCCC####", "####G#####G####", "####G##T##G####", "####G#####G####", "#####CGGGC#####", "###############")
                .aisle("##CCCCCCCCCCC##", "###C#######C###", "###C###T###C###", "###C#######C###", "####CCCCCCC####", "###############")
                .aisle("##CCCCCCCCCCC##", "##C#########C##", "##C####T####C##", "##C#########C##", "###C#######C###", "####GGGGGGG####")
                .aisle("#CCCCCCCCCCCCC#", "#G###########G#", "#G#####T#####G#", "#G###########G#", "##C#########C##", "###GGGGGGGGG###")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C######T######C", "C#############C", "#CC#########CC#", "###GGGGGGGGG###")
                .aisle("CCCCCCCCCCCCCCC", "G#####LTL#####G", "G#####LTL#####G", "G#####LTL#####G", "#GC####L####CG#", "###GGGGGGGGG###")
                .aisle("CCCCCCCHCCCCCCC", "G#####TGT#####G", "ETTTTTTGTTTTTTQ", "G#####TGT#####G", "#GC###LLL###CG#", "###GGGGPGGGG###")
                .aisle("CCCCCCCCCCCCCCC", "G#####LTL#####G", "G#####LTL#####G", "G#####LTL#####G", "#GC####L####CG#", "###GGGGGGGGG###")
                .aisle("CCCCCCCCCCCCCCC", "C#############C", "C#############C", "C#############C", "#CC#########CC#", "###GGGGGGGGG###")
                .aisle("#CCCCCCCCCCCCC#", "#G###########G#", "#G###########G#", "#G###########G#", "##C#########G##", "###GGGGGGGGG###")
                .aisle("##CCCCCCCCCCC##", "##C#########C##", "##C#########C##", "##C#########C##", "###C#######C###", "####GGGGGGG####")
                .aisle("##CCCCCCCCCCC##", "###C#######C###", "###C#######C###", "###C#######C###", "####CCCCCCC####", "###############")
                .aisle("####CCCCCCC####", "####G#####G####", "####G#####G####", "####G#####G####", "#####CGGGC#####", "###############")
                .aisle("#####CCCCC#####", "#####CMOFC#####", "#####CGGGC#####", "#####CGGGC#####", "###############", "###############")
                .where('#', any())
                .where('C', states(GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.RHODIUM_PLATED_PALLADIUM_CASING)))
                .where('G', glassPredicate())
                .where('L', states(MetaBlocks.LAMPS.get(EnumDyeColor.GRAY).getStateFromMeta(0)))
                .where('T', states(MetaBlocks.ITEM_PIPES[ItemPipeType.RESTRICTIVE_HUGE.ordinal()].getDefaultState()))
                .where('M', abilities(MultiblockAbility.MAINTENANCE_HATCH))
                .where('O', selfPredicate())
                .where('F', abilities(MultiblockAbility.IMPORT_FLUIDS))
                .where('E', abilities(MultiblockAbility.INPUT_ENERGY))
                .where('Q', abilities(MultiblockAbility.EXPORT_FLUIDS))
                .where('I', abilities(MultiblockAbility.EXPORT_ITEMS))
                .where('P', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('H', lensPredicate())
                .build();
    }

    private TraceabilityPredicate glassPredicate() {
        return states(GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.getByTier(tier)));
    }

    private TraceabilityPredicate lensPredicate() {
        return new TraceabilityPredicate(blockWorldState -> {
            boolean result = false;
            BlockPos pos = blockWorldState.getPos();
            World world = blockWorldState.getWorld();
            for (int i = pos.getY()-1;i>0;i--) {
                if (blockWorldState == GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.getByTier(tier))
                        && (world.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())) == Blocks.AIR.getDefaultState() || world.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())) == Blocks.BEDROCK.getDefaultState())) result = true;
            }
            return result;
        }).addTooltip("gregica.tooltip.void_miner_lens");
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return null; //GCTextures.RHODIUM_PLATED_PALLADIUM_CASING;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEVoidOreMiner(metaTileEntityId, tier);
    }
}
