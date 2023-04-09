package me.oganesson.gregica.common.gregtech.metablock;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class GCMetaCasing extends VariantBlock<GCMetaCasing.MetalCasingType> {

    public GCMetaCasing() {
        super(Material.IRON);
        setTranslationKey("gc_machine_casing");
        setHardness(2.0f);
        setResistance(5.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 2);
        setDefaultState(getState(MetalCasingType.MAGIC_CASING));
        setRegistryName("gc_machine_casing");
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum MetalCasingType implements IStringSerializable {

        ESSENTIA_CELL_T1("essentia_cell_1"),
        ESSENTIA_CELL_T2("essentia_cell_2"),
        ESSENTIA_CELL_T3("essentia_cell_3"),
        ESSENTIA_CELL_T4("essentia_cell_4"),
        MAGIC_CASING("magic_machine_casing"),
        FISHING_CASING("fishing_machine_casing");

        private final String name;

        MetalCasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }

    }

}