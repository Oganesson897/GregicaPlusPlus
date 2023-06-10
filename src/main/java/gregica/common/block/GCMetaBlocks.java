package gregica.common.block;

import com.google.common.collect.UnmodifiableIterator;
import gregica.common.block.metablock.*;
import gregica.common.block.wood.BlockPineLeaves;
import gregica.common.block.wood.BlockPineLog;
import gregica.common.block.wood.BlockPineSapling;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.StoneType;
import gregtech.client.ClientProxy;
import gregtech.common.blocks.BlockOre;
import gregtech.common.blocks.MetaBlocks;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import gregica.common.block.metablock.*;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import java.util.Collection;
import java.util.Iterator;

import static gregtech.client.ClientProxy.RUBBER_LEAVES_BLOCK_COLOR;
import static gregtech.client.ClientProxy.RUBBER_LEAVES_ITEM_COLOR;
import static gregtech.common.blocks.MetaBlocks.statePropertiesToString;

public class GCMetaBlocks {

    public GCMetaBlocks(){}
    
    public static final GCMetaCasing GC_BLOCK_CASING = new GCMetaCasing();
    public static final GCMetaCells GC_ESSENTIA_CELLS = new GCMetaCells();
    public static final GCMetaGearBox GC_META_GEAR_BOX = new GCMetaGearBox();
    public static final BlockPineLeaves PINE_LEAVES = new BlockPineLeaves();
    public static final BlockPineLog PINE_LOG = new BlockPineLog();
    public static final BlockPineSapling PINE_SAPLING = new BlockPineSapling();

    public static final GCLapotronicCasing GC_LAPOTRONIC_CASING = new GCLapotronicCasing();
    
    public static final GCMetaGlasses TRANSPARENT_CASING = new GCMetaGlasses("glasses_casing");
    public static final GCMetaGlasses1 TRANSPARENT_CASING1 = new GCMetaGlasses1("glasses_casing1");

    public static final Collection<BlockOre> ORES = new ReferenceArrayList();
    
    public static boolean isMachineCasing(IBlockState state) {
        return state.getBlock().equals(MetaBlocks.MACHINE_CASING);
    }
    
    public static GCMetaCasing.MetalCasingType getType(IBlockState state){
        return GC_BLOCK_CASING.getState(state);
    }

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(GC_BLOCK_CASING);
        registerItemModel(GC_ESSENTIA_CELLS);
        registerItemModel(GC_META_GEAR_BOX);
        registerItemModel(GC_LAPOTRONIC_CASING);
        registerItemModel(TRANSPARENT_CASING);
        registerItemModel(TRANSPARENT_CASING1);
        registerItemModel(PINE_LEAVES);
        registerItemModel(PINE_LOG);
        registerItemModel(PINE_SAPLING);

        ORES.forEach(BlockOre::onModelRegister);
    }

    @SideOnly(Side.CLIENT)
    public static void registerColors() {
        Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(RUBBER_LEAVES_BLOCK_COLOR, PINE_LEAVES);
        Minecraft.getMinecraft().getItemColors().registerItemColorHandler(RUBBER_LEAVES_ITEM_COLOR, PINE_LEAVES);

        ORES.stream().distinct().forEach((block) -> {
            Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(ClientProxy.ORE_BLOCK_COLOR, new Block[]{block});
            Minecraft.getMinecraft().getItemColors().registerItemColorHandler(ClientProxy.ORE_ITEM_COLOR, new Block[]{block});
        });
    }

    public static void registerOreDict() {
        Iterator var0 = ORES.iterator();

        while(var0.hasNext()) {
            BlockOre blockOre = (BlockOre)var0.next();
            Material material = blockOre.material;
            UnmodifiableIterator var15 = blockOre.STONE_TYPE.getAllowedValues().iterator();

            while(var15.hasNext()) {
                StoneType stoneType = (StoneType)var15.next();
                if (stoneType != null) {
                    ItemStack normalStack = BlockOre.getItem(blockOre.getDefaultState().withProperty(blockOre.STONE_TYPE, stoneType));
                    OreDictUnifier.registerOre(normalStack, stoneType.processingPrefix, material);
                }
            }
        }
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

}
