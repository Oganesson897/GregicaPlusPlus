package me.oganesson.gregica.common.block.metablock;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class GCMetaCells extends VariantBlock<GCMetaCells.MetalCellType> {

    public GCMetaCells() {
        super(Material.IRON);
        setTranslationKey("gc_essentia_cell");
        setHardness(2.0f);
        setResistance(5.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 2);
        setDefaultState(getState(GCMetaCells.MetalCellType.ESSENTIA_CELL_T1));
        setRegistryName("gc_essentia_cell");
    }
    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum MetalCellType implements IStringSerializable {

        ESSENTIA_CELL_T1("essentia_cell_1"),
        ESSENTIA_CELL_T2("essentia_cell_2"),
        ESSENTIA_CELL_T3("essentia_cell_3"),
        ESSENTIA_CELL_T4("essentia_cell_4");

        private final String name;

        MetalCellType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }

    }

}
