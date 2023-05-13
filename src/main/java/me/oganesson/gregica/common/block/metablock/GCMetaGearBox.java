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

public class GCMetaGearBox extends VariantBlock<GCMetaGearBox.GearBoxType> {

    public GCMetaGearBox() {
        super(Material.IRON);
        setTranslationKey("gc_meta_gearbox");
        setHardness(2.0f);
        setResistance(5.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 2);
        setDefaultState(getState(GearBoxType.ISA_MILL_GEARBOX));
        setRegistryName("gc_meta_gearbox");
    }

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum GearBoxType implements IStringSerializable {

        ISA_MILL_GEARBOX("isa_gear_casing"),
        INCONEL_CASING("inconel_casing"),
        FLOTATION_CALL("flotation_cell"),
        VACUUM_CASING("vacuum_casing");

        private final String name;

        GearBoxType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return this.name;
        }

    }

}