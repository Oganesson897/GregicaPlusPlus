package me.oganesson.gregica.common.block;

import me.oganesson.gregica.common.tileentities.EssentiaHatch;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.IEssentiaContainerItem;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TEBlock extends BlockContainer {

    private final int index;

    public TEBlock(String name, int index) {
        super(Material.IRON);
        this.setHardness(9.0F);
        this.setResistance(5.0F);
        setRegistryName(name);
        setTranslationKey(name);
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
        if (worldIn.isRemote) {
            return false;
        } else if (hand == EnumHand.MAIN_HAND) {
            TileEntity tile = worldIn.getTileEntity(pos);
            if (index == 1) {
                if (tile instanceof EssentiaHatch) {
                    ItemStack tItemStack = playerIn.getHeldItem(hand);
                    if (!tItemStack.isEmpty()) {
                        Item tItem = tItemStack.getItem();
                        if (tItem instanceof IEssentiaContainerItem
                                && ((IEssentiaContainerItem) tItem).getAspects(playerIn.getHeldItem(hand)) != null
                                && ((IEssentiaContainerItem) tItem).getAspects(playerIn.getHeldItem(hand)).size() > 0) {
                            Aspect tLocked = ((IEssentiaContainerItem) tItem).getAspects(playerIn.getHeldItem(hand))
                                    .getAspects()[0];
                            ((EssentiaHatch) tile).setLockedAspect(tLocked);
                            if (playerIn instanceof EntityPlayerMP) {
                                playerIn.sendMessage(
                                        new TextComponentTranslation(
                                                "essentiahatch.chat.0",
                                                tLocked.getLocalizedDescription()));
                            }
                        }
                    } else {
                        ((EssentiaHatch) tile).setLockedAspect(null);
                        if (playerIn instanceof EntityPlayerMP) {
                            playerIn.sendMessage(new TextComponentTranslation(
                                    "essentiahatch.chat.1"
                            ));
                        }
                    }
                    tile.markDirty();
                    return true;
                }
            }
        }
        return false;
    }


}
