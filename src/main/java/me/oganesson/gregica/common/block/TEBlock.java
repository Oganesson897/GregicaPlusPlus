package me.oganesson.gregica.common.block;

import me.oganesson.gregica.common.tileentities.te.EssentiaHatch;
import me.oganesson.gregica.common.tileentities.te.IGCTileEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TEBlock extends BlockContainer {

    private final int index;

    public TEBlock(String name, int index) {
        super(Material.IRON);
        this.setHardness(9.0F);
        this.setResistance(5.0F);
        this.setRegistryName(name);
        this.setTranslationKey(name);
        this.setHarvestLevel("wrench", 2);
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    @Nonnull
    public EnumBlockRenderType getRenderType(@Nonnull IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean canBeReplacedByLeaves(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos) {
        return false;
    }

    @Override
    public boolean canEntityDestroy(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull Entity entity) {
        return false;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        if (this.index == 1) {
            return new EssentiaHatch();
        }
        return null;
    }

    @Override
    public boolean onBlockActivated(@Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull IBlockState state, @Nonnull EntityPlayer playerIn, @Nonnull EnumHand hand, @Nonnull EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if(tile instanceof IGCTileEntity){
            return ((IGCTileEntity)tile).onBlockActivated(tile,worldIn,pos,state,playerIn,hand,facing,hitX,hitY,hitZ);
        }
        return false;
    }


}
