package me.oganesson.gregica.common.block;

import gregtech.client.model.SimpleStateMapper;
import me.oganesson.gregica.common.block.gcysblocks.BlockCrucible;
import me.oganesson.gregica.common.block.gcysblocks.BlockGCYSMultiblockCasing;
import me.oganesson.gregica.common.block.gcysblocks.BlockGCYSMultiblockCasingActive;
import me.oganesson.gregica.common.block.gcysblocks.BlockTransparentCasing;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GCYSMetaBlocks {

    public static BlockCrucible CRUCIBLE;
    public static BlockGCYSMultiblockCasing MULTIBLOCK_CASING;
    public static BlockGCYSMultiblockCasingActive MULTIBLOCK_CASING_ACTIVE;
    public static BlockTransparentCasing TRANSPARENT_CASING;

    private GCYSMetaBlocks() {

    }

    public static void init() {
        CRUCIBLE = new BlockCrucible();
        CRUCIBLE.setRegistryName("crucible");
        MULTIBLOCK_CASING = new BlockGCYSMultiblockCasing();
        MULTIBLOCK_CASING.setRegistryName("multiblock_casing");
        MULTIBLOCK_CASING_ACTIVE = new BlockGCYSMultiblockCasingActive();
        MULTIBLOCK_CASING_ACTIVE.setRegistryName("multiblock_casing_active");
        TRANSPARENT_CASING = new BlockTransparentCasing();
        TRANSPARENT_CASING.setRegistryName("transparent_casing");
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(CRUCIBLE);
        registerItemModel(MULTIBLOCK_CASING);
        registerItemModel(MULTIBLOCK_CASING_ACTIVE);
        registerItemModel(TRANSPARENT_CASING);
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@Nonnull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }

    @Nonnull
    private static String statePropertiesToString(@Nonnull Map<IProperty<?>, Comparable<?>> properties) {
        StringBuilder stringbuilder = new StringBuilder();
        List<Map.Entry<IProperty<?>, Comparable<?>>> entries = properties.entrySet().stream().sorted(Comparator.comparing((c) -> c.getKey().getName())).collect(Collectors.toList());

        for (Map.Entry<IProperty<?>, Comparable<?>> iPropertyComparableEntry : entries) {
            if (stringbuilder.length() != 0) {
                stringbuilder.append(",");
            }

            IProperty<?> property = (IProperty<?>) ((Map.Entry<?, ?>) iPropertyComparableEntry).getKey();
            stringbuilder.append(property.getName());
            stringbuilder.append("=");
            stringbuilder.append(getPropertyName(property, (Comparable<?>) ((Map.Entry<?, ?>) iPropertyComparableEntry).getValue()));
        }

        if (stringbuilder.length() == 0) {
            stringbuilder.append("normal");
        }

        return stringbuilder.toString();
    }

    @Nonnull
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> String getPropertyName(@Nonnull IProperty<T> property, Comparable<?> value) {
        return property.getName((T) value);
    }
}
