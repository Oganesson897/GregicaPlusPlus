package project.gregica.common.item.behavior;

import appeng.api.util.AEColor;
import appeng.tile.networking.TileCableBus;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.pipenet.tile.IPipeTile;
import gregtech.client.utils.TooltipHelper;
import project.gregica.api.item.IExtendedItemBehavior;
import project.gregica.common.item.metaitems.GCMetaItems;
import project.gregica.common.tileentities.mte.multipart.MTELaserHatch;
import project.gregica.common.tileentities.te.TELaserPipe;
import project.gregica.utils.GCColorUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ColorApplicatorBehavior implements IItemBehaviour, IExtendedItemBehavior {
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, List<String> lines) {
        if(itemStack.hasTagCompound()){
            lines.add(I18n.format("gregica.color.wheel"));
            if(TooltipHelper.isShiftDown()){
                lines.add(I18n.format("gregica.color.creative"));
            }
            lines.add(TextFormatting.WHITE+I18n.format("gregica.color.current")+currentColor(itemStack).getChatColor()+I18n.format("gregica.color."+currentColorName(itemStack))+"  "+currentColor(itemStack).ordinal());
            
            //noinspection ConstantConditions
            NBTTagCompound colorTags = itemStack.getTagCompound().getCompoundTag("colors");
            for(GCColorUtil.StandardColor color : GCColorUtil.StandardColor.values()){
                if(colorTags.hasKey(color.getName())){
                    int amount = colorTags.getInteger(color.getName());
                    if(amount >= 1){
                        lines.add(GCColorUtil.colorName(color)+I18n.format("gregica.color.available",amount));
                    }
                }
            }
        }
        
    }
    
    @Override
    public EnumActionResult onWheelChanged(boolean isUp, World world, EntityPlayer player, ItemStack itemStack) {
        if(!isUp){
            nextColor(itemStack);
        }
        else {
            previousColor(itemStack);
        }
        GCColorUtil.StandardColor standardColor = currentColor(itemStack);
        player.sendStatusMessage(new TextComponentTranslation("gregica.color.current")
                .appendSibling(new TextComponentTranslation(GCColorUtil.colorName(standardColor)))
                .setStyle(new Style().setColor(standardColor.getChatColor())),true);
        return EnumActionResult.SUCCESS;
    }
    
    @Override
    public boolean canHandleWheelChange() {
        return true;
    }
    
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        if (!world.isRemote && !world.isAirBlock(pos)){

            ItemStack itemStack = player.getHeldItem(hand);
            if (player.isCreative() && needLoad(itemStack)) {
                loadAllColor(itemStack);
                return EnumActionResult.SUCCESS;
            }

            if((player.isCreative() || drainEnergy(itemStack, true)) && canPaint(itemStack)){
                if(!player.isCreative()){
                    drainEnergy(itemStack,false);
                }
                GCColorUtil.StandardColor color = currentColor(itemStack);
                if(tryPaintBlock(player,world,pos,side,color == GCColorUtil.StandardColor.NONE ? null : color.getAsDyeColor())){
                    customColor(itemStack);
                }
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }

    
    
    private boolean drainEnergy(@Nonnull ItemStack stack, boolean simulate) {
        IElectricItem electricItem = stack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
        if (electricItem == null)
            return false;
        
        return electricItem.discharge(10, Integer.MAX_VALUE, true, false, simulate) >= 10;
    }
    
    public static boolean needLoad(ItemStack stack){
        //noinspection ConstantConditions
        return !(stack.hasTagCompound() && stack.getTagCompound().hasKey("colors"));
    }
    public static void loadAllColor(ItemStack stack){
        if(stack.getItem() == GCMetaItems.metaItem3){
            NBTTagCompound toAdd = stack.getTagCompound();
            NBTTagCompound tag = new NBTTagCompound();
            for(GCColorUtil.StandardColor color : GCColorUtil.StandardColor.values()){
                tag.setInteger(color.getName(),Integer.MAX_VALUE);
            }
            //noinspection ConstantConditions
            toAdd.setTag("colors",tag);
            toAdd.setInteger("current_color",GCColorUtil.StandardColor.NONE.getColor());
            stack.setTagCompound(toAdd);
        }
    }
    
    public static boolean canPaint(ItemStack stack){
        GCColorUtil.StandardColor color = currentColor(stack);
        NBTTagCompound tag = stack.getTagCompound();
        if(tag != null && tag.hasKey("colors")){
            NBTTagCompound colorTag = tag.getCompoundTag("colors");
            return colorTag.hasKey(color.getName()) && colorTag.getInteger(color.getName()) >= 1;
        }
        return false;
    }
    
    public static void customColor(ItemStack stack){
        GCColorUtil.StandardColor color = currentColor(stack);
        NBTTagCompound tag = stack.getTagCompound();
        if(tag != null &&tag.hasKey("colors")){
            NBTTagCompound colors = tag.getCompoundTag("colors");
            colors.setInteger(color.getName(),colors.getInteger(color.getName())-1);
        }
    }
    
    public static void nextColor(ItemStack stack){
        if(stack.getItem() == GCMetaItems.metaItem3 && stack.hasTagCompound()){
            NBTTagCompound tag = stack.getTagCompound();
            //noinspection ConstantConditions
            int currentIndex = !tag.hasKey("current_color") ?
                    -1 : GCColorUtil.colors.getOrDefault(tag.getInteger("current_color"), GCColorUtil.StandardColor.NONE).ordinal();
            tag.setInteger("current_color", nextAvailableColor(currentIndex,tag.getCompoundTag("colors")));
            stack.setTagCompound(tag);
        }
    }
    
    public static void previousColor(ItemStack stack){
        if(stack.getItem() == GCMetaItems.metaItem3 && stack.hasTagCompound()){
            NBTTagCompound tag = stack.getTagCompound();
            //noinspection ConstantConditions
            int currentIndex = !tag.hasKey("current_color") ?
                    -1 :GCColorUtil.colors.getOrDefault(tag.getInteger("current_color"), GCColorUtil.StandardColor.NONE).ordinal();
    
            NBTTagCompound colorTag = tag.getCompoundTag("colors");
            for(int i=GCColorUtil.StandardColor.values().length-1; i>=0 ;i--){
                int index = (currentIndex > 0 ? currentIndex+i : i) % GCColorUtil.StandardColor.values().length;
                GCColorUtil.StandardColor color = GCColorUtil.StandardColor.values()[index];
                String name = color.getName();
                if(colorTag.hasKey(name)){
                    if(colorTag.getInteger(name) < 1) continue;
                    if(color.ordinal() == currentIndex ) continue;
                    tag.setInteger("current_color", color.getColor());
                    break;
                }
            }
//            if(currentIndex == -1){
//                tag.setInteger("current_color", 0);
//            }
//            else if(currentIndex == 0){
//                tag.setInteger("current_color",GCColorUtil.StandardColor.values()[GCColorUtil.StandardColor.values().length].getColor());
//            }
//            else {
//                tag.setInteger("current_color", GCColorUtil.StandardColor.values()[currentIndex -1].getColor());
//            }
            stack.setTagCompound(tag);
        }
    }
    
    public static String currentColorName(ItemStack stack){
        return currentColor(stack).getName();
    }
    
    public static GCColorUtil.StandardColor currentColor(ItemStack stack){
        if(stack.getItem() == GCMetaItems.metaItem3 && stack.hasTagCompound()){
            NBTTagCompound tag = stack.getTagCompound();
            //noinspection ConstantConditions
            return GCColorUtil.colors.getOrDefault(tag.getInteger("current_color"), GCColorUtil.StandardColor.NONE);
        
        }
        return GCColorUtil.StandardColor.NONE;
    }
    
    public static int nextAvailableColor(int currentIndex,NBTTagCompound tag){
        for(int i=0; i< GCColorUtil.StandardColor.values().length;i++){
            int index = (currentIndex > 0? currentIndex+i : i) % GCColorUtil.StandardColor.values().length;
            GCColorUtil.StandardColor color = GCColorUtil.StandardColor.values()[index];
            String name = color.getName();
            if(tag.hasKey(name)){
                if(tag.getInteger(name) < 1) continue;
                if(color.ordinal() == currentIndex ) continue;
                return color.getColor();
            }
        }
        return 0;
    }
    
    
    public static int currentColorValue(ItemStack stack){
        return currentColor(stack).getColor();
    }
    
    
    
    private boolean tryPaintBlock(EntityPlayer player, World world, BlockPos pos, EnumFacing side,@Nullable EnumDyeColor color) {
        IBlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
    
        TileEntity te = world.getTileEntity(pos);
        int colorValue = color == null ? -1 : color.ordinal()+1;
        if (te instanceof IGregTechTileEntity) {
            MetaTileEntity mte = ((IGregTechTileEntity) te).getMetaTileEntity();
            if (mte instanceof MTELaserHatch && ((MTELaserHatch) mte).getColor() != colorValue) {
                MTELaserHatch laserHatch = (MTELaserHatch) mte;
                laserHatch.setColor(colorValue);
                return true;
            }
        }
        if(te instanceof TELaserPipe){
            if(((TELaserPipe) te).getColor() != (colorValue)){
                ((TELaserPipe) te).setColor(colorValue);
                ((TELaserPipe) te).updateConnections(world,pos,true);
                return true;
            }
        }
        
        if (color == null) {
            return tryStripBlockColor(player, world, pos, block, side);
        }
        
        return block.recolorBlock(world, pos, side, color) || tryPaintSpecialBlock(player, world, pos, block,color);
    }
    
    private boolean tryPaintSpecialBlock(EntityPlayer player, World world, BlockPos pos, Block block,EnumDyeColor color) {
        if (block == Blocks.GLASS) {
            IBlockState newBlockState = Blocks.STAINED_GLASS.getDefaultState()
                    .withProperty(BlockStainedGlass.COLOR, color);
            world.setBlockState(pos, newBlockState);
            return true;
        }
        if (block == Blocks.GLASS_PANE) {
            IBlockState newBlockState = Blocks.STAINED_GLASS_PANE.getDefaultState()
                    .withProperty(BlockStainedGlassPane.COLOR, color);
            world.setBlockState(pos, newBlockState);
            return true;
        }
        if (block == Blocks.HARDENED_CLAY) {
            IBlockState newBlockState = Blocks.STAINED_HARDENED_CLAY.getDefaultState()
                    .withProperty(BlockColored.COLOR, color);
            world.setBlockState(pos, newBlockState);
            return true;
        }
        if (Loader.isModLoaded(GTValues.MODID_APPENG)) {
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof TileCableBus) {
                TileCableBus cable = (TileCableBus) te;
                // do not try to recolor if it already is this color
                if (cable.getColor().ordinal() != color.ordinal()) {
                    cable.recolourBlock(null, AEColor.values()[color.ordinal()], player);
                    return true;
                }
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked, rawtypes")
    private static boolean tryStripBlockColor(EntityPlayer player, World world, BlockPos pos, Block block, EnumFacing side) {
        // MC special cases
        if (block == Blocks.STAINED_GLASS) {
            world.setBlockState(pos, Blocks.GLASS.getDefaultState());
            return true;
        }
        if (block == Blocks.STAINED_GLASS_PANE) {
            world.setBlockState(pos, Blocks.GLASS_PANE.getDefaultState());
            return true;
        }
        if (block == Blocks.STAINED_HARDENED_CLAY) {
            world.setBlockState(pos, Blocks.HARDENED_CLAY.getDefaultState());
            return true;
        }
    
        // MTE special case
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof IGregTechTileEntity) {
            MetaTileEntity mte = ((IGregTechTileEntity) te).getMetaTileEntity();
            if (mte != null) {
                if (mte.isPainted()) {
                    mte.setPaintingColor(-1);
                    return true;
                } else return false;
            }
        }
    
        // TileEntityPipeBase special case
        if (te instanceof IPipeTile) {
            IPipeTile<?, ?> pipe = (IPipeTile<?, ?>) te;
            if (pipe.isPainted()) {
                pipe.setPaintingColor(-1);
                return true;
            } else return false;
        }
    
        // AE2 cable special case
        if (Loader.isModLoaded(GTValues.MODID_APPENG)) {
            if (te instanceof TileCableBus) {
                TileCableBus cable = (TileCableBus) te;
                // do not try to strip color if it is already colorless
                if (cable.getColor() != AEColor.TRANSPARENT) {
                    cable.recolourBlock(null, AEColor.TRANSPARENT, player);
                    return true;
                } else return false;
            }
        }
    
        // General case
        IBlockState state = world.getBlockState(pos);
        for (IProperty prop : state.getProperties().keySet()) {
            if (prop.getName().equals("color") && prop.getValueClass() == EnumDyeColor.class) {
                IBlockState defaultState = block.getDefaultState();
                EnumDyeColor defaultColor = EnumDyeColor.WHITE;
                try {
                    // try to read the default color value from the default state instead of just
                    // blindly setting it to default state, and potentially resetting other values
                    defaultColor = (EnumDyeColor) defaultState.getValue(prop);
                } catch (IllegalArgumentException ignored) {
                    // no default color, we may have to fallback to WHITE here
                    // other mods that have custom behavior can be done as
                    // special cases above on a case-by-case basis
                }
                block.recolorBlock(world, pos, side, defaultColor);
                return true;
            }
        }
    
        return false;
    }
    
    
}
