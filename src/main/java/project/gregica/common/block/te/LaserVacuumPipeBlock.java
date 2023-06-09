package project.gregica.common.block.te;

import codechicken.lib.raytracer.IndexedCuboid6;
import codechicken.lib.raytracer.RayTracer;
import codechicken.lib.vec.Cuboid6;
import gregtech.api.cover.ICoverable;
import gregtech.api.pipenet.block.BlockPipe;
import mcp.MethodsReturnNonnullByDefault;
import project.gregica.client.render.laserpipe.LaserVacuumPipeRender;
import project.gregica.common.item.metaitems.GCMetaItems;
import project.gregica.common.tileentities.te.TELaserPipe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

import static gregtech.api.metatileentity.MetaTileEntity.FULL_CUBE_COLLISION;
import static gregtech.api.pipenet.block.BlockPipe.getSideBox;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class LaserVacuumPipeBlock extends BlockContainer {
    
    public static final String NAME = "laser_vacuum_pipe";
    
    private final boolean isTransparent;
    
    public LaserVacuumPipeBlock(boolean isTransparent) {
        super(Material.IRON, MapColor.BLUE);
        this.setHardness(9.0F);
        this.setResistance(5.0F);
        this.setRegistryName(NAME+ (isTransparent?"_transparent":"_opaque"));
        this.setTranslationKey(NAME+(isTransparent?"_transparent":"_opaque"));
        this.setHarvestLevel("wrench", 2);
        this.isTransparent = isTransparent;
    }
    
    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TELaserPipe();
    }
    
    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(world, pos, neighbor);
        TileEntity self = world.getTileEntity(pos);
        if(self instanceof TELaserPipe){
            ((TELaserPipe) self).updateConnections(world,pos,true);
        }
    }
    
    @Override
    public boolean canBeReplacedByLeaves(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos) {
        return false;
    }
    
    @Override
    public boolean canEntityDestroy(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull Entity entity) {
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return LaserVacuumPipeRender.INSTANCE.getBlockRenderType();
    }
    
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    
    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
    @Override
    @SuppressWarnings("deprecation")
    public void addCollisionBoxToList(@Nonnull IBlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull AxisAlignedBB entityBox, @Nonnull List<AxisAlignedBB> collidingBoxes, @javax.annotation.Nullable Entity entityIn, boolean isActualState) {
        // This iterator causes some heap memory overhead
        
        for (Cuboid6 axisAlignedBB : getCollisionBox(worldIn, pos, entityIn)) {
            AxisAlignedBB offsetBox = axisAlignedBB.aabb().offset(pos);
            if (offsetBox.intersects(entityBox)) collidingBoxes.add(offsetBox);
        }
    }
    
    @javax.annotation.Nullable
    @Override
    @SuppressWarnings("deprecation")
    public RayTraceResult collisionRayTrace(@Nonnull IBlockState blockState, World worldIn, @Nonnull BlockPos pos, @Nonnull Vec3d start, @Nonnull Vec3d end) {
        if (worldIn.isRemote) {
            return getClientCollisionRayTrace(worldIn, pos, start, end);
        }
        return RayTracer.rayTraceCuboidsClosest(start, end, pos, FULL_CUBE_COLLISION);
    }
    
    @SideOnly(Side.CLIENT)
    public RayTraceResult getClientCollisionRayTrace(World worldIn, @Nonnull BlockPos pos, @Nonnull Vec3d start, @Nonnull Vec3d end) {
        return RayTracer.rayTraceCuboidsClosest(start, end, pos, getCollisionBox(worldIn, pos, Minecraft.getMinecraft().player));
    }
    
    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public BlockFaceShape getBlockFaceShape(@Nonnull IBlockAccess worldIn, @Nonnull IBlockState state, @Nonnull BlockPos pos, @Nonnull EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
    
    private List<IndexedCuboid6> getCollisionBox(IBlockAccess world, BlockPos pos, @javax.annotation.Nullable Entity entityIn) {
        TileEntity te = world.getTileEntity(pos);
        
        if(te instanceof TELaserPipe){
            BitSet connections = ((TELaserPipe) te).getConnections();
            float thickness = 0.5f;
            ArrayList<IndexedCuboid6> result = new ArrayList<>();
            
            result.add(new IndexedCuboid6(new ICoverable.PrimaryBoxData(true), getSideBox(null, thickness)));
            for (EnumFacing side : EnumFacing.VALUES) {
                if (connections.get(side.getIndex())) {
                    result.add(new IndexedCuboid6(new BlockPipe.PipeConnectionData(side), getSideBox(side, thickness)));
                }
            }
            return result;
        }
        return Collections.emptyList();
    }
    
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if(placer instanceof EntityPlayer) {
            ItemStack offhand = placer.getHeldItemOffhand();
            if (offhand.isItemEqual(GCMetaItems.COLOR_APPLICATOR.getStackForm())) {
                GCMetaItems.COLOR_APPLICATOR.getBehaviours().get(1).onItemUseFirst((EntityPlayer) placer, worldIn, pos, EnumFacing.UP, 0f, 0f, 0f, EnumHand.OFF_HAND);
                TileEntity entity = worldIn.getTileEntity(pos);
                if(entity instanceof TELaserPipe){
                    ((TELaserPipe) entity).notice(worldIn,pos);
                }
            }
        }
    }
    
    public boolean isTransparent() {
        return isTransparent;
    }
}
