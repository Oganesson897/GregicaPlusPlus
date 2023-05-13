package me.oganesson.gregica.common.block.wood;

import gregtech.api.GregTechAPI;
import gregtech.common.items.MetaItems;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockPineLog extends BlockLog {

    public static final PropertyBool NATURAL = PropertyBool.create("natural");

    public BlockPineLog() {
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(LOG_AXIS, EnumAxis.Y)
                .withProperty(NATURAL, false));
        setTranslationKey("pine_log");
        setRegistryName("pine_log");

    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LOG_AXIS, NATURAL);
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState()
                .withProperty(NATURAL, (meta & 1) == 1)
                .withProperty(LOG_AXIS, EnumAxis.values()[meta >> 1]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(NATURAL) ? 1 : 0) | (state.getValue(LOG_AXIS).ordinal() << 1);
    }
}