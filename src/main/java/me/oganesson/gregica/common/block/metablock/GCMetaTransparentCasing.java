package me.oganesson.gregica.common.block.metablock;

import gregtech.api.block.VariantActiveBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class GCMetaTransparentCasing extends VariantActiveBlock<GCMetaTransparentCasing.GlassCasingType> {

    public GCMetaTransparentCasing() {
        super(Material.GLASS);
        this.setTranslationKey("transparent_casing");
        this.setHardness(5.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.GLASS);
        this.setHarvestLevel("pickaxe", 1);
        this.setDefaultState(this.getState(GlassCasingType.REINFORCED_GLASS));
        this.useNeighborBrightness = true;
    }

    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Nonnull
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return this.getState(state) == GlassCasingType.REINFORCED_GLASS ? layer == BlockRenderLayer.TRANSLUCENT : super.canRenderInLayer(state, layer);
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        IBlockState sideState = world.getBlockState(pos.offset(side));
        return sideState.getBlock() == this ? this.getState(sideState) != this.getState(state) : super.shouldSideBeRendered(state, world, pos, side);
    }

    public enum GlassCasingType implements IStringSerializable {
        REINFORCED_GLASS("reinforced_glass"),
        BOROSILICATE_REINFORCED_GLASS("borosilicate_reinforced_glass"),
        NICKEL_REINFORCED_GLASS("nickel_reinforced_glass"),
        CHROME_REINFORCED_GLASS("chrome_reinforced_glass"),
        TUNGSTEN_REINFORCED_GLASS("tungsten_reinforced_glass"),
        IRIDIUM_REINFORCED_GLASS("iridium_reinforced_glass"),
        OSMIRIDIUM_REINFORCED_GLASS("osmiridium_reinforced_glass");

        private final String name;

        GlassCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        public String getName() {
            return this.name;
        }
    }
}