
package me.oganesson.gregica.common.block.metablock;

import gregtech.api.GTValues;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.items.toolitem.ToolClasses;
import me.oganesson.gregica.api.blocks.ITiredGlass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
public class GCMetaGlasses extends VariantActiveBlock<GCMetaGlasses.CasingType>  {

    public GCMetaGlasses(String name) {
        super(Material.GLASS);
        setTranslationKey("glasses_casing");
        setRegistryName(name);
        setHardness(5.0F);
        setResistance(5.0F);
        setSoundType(SoundType.GLASS);
        setHarvestLevel(ToolClasses.PICKAXE, 1);
        setDefaultState(getState(CasingType.TI_BORON_SILICATE_GLASS_BLOCK));
        this.useNeighborBrightness = true;
    }
    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
        return false;
    }
    
    @Override
    public void addInformation(@NotNull ItemStack stack, @Nullable World player, List<String> tooltip, @NotNull ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        int tier = getState(stack).getTier();
        tooltip.add(I18n.format("gregica.mixin.info.glass.tier", GTValues.VNF[tier]));
    }
    
    @Override
    @Nonnull
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return super.canRenderInLayer(state, layer);
    }
    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        IBlockState sideState = world.getBlockState(pos.offset(side));

        return sideState.getBlock() == this ?
                getState(sideState) != getState(state) :
                super.shouldSideBeRendered(state, world, pos, side);
    }

    public  enum CasingType implements IStringSerializable, ITiredGlass {
        TI_BORON_SILICATE_GLASS_BLOCK("ti_boron_silicate_glass_block", 4),
        W_BORON_SILICATE_GLASS_BLOCK("w_boron_silicate_glass_block", 5),
        CThY_BORON_SILICATE_GLASS_BLOCK("thy_boron_silicate_glass_block", 5),
        CR_BORON_SILICATE_GLASS_BLOCK("cr_boron_silicate_glass_block", 6),
        IR_BORON_SILICATE_GLASS_BLOCK("ir_boron_silicate_glass_block", 7),
        OS_BORON_SILICATE_GLASS_BLOCK("os_boron_silicate_glass_block", 8),
        NE_BORON_SILICATE_GLASS_BLOCK("ne_boron_silicate_glass_block", 9),
        SNE_BORON_SILICATE_GLASS_BLOCK("sne_boron_silicate_glass_block", 10);



        private final String name;
        private final int tier;

        private CasingType(String name, int tier) {
            this.name = name;
            this.tier = tier;
        }

        @Override
        @Nonnull
        public String getName() {
            return this.name;
        }
    
        @Override
        public int getTier() {
            return tier;
        }
    }

}
