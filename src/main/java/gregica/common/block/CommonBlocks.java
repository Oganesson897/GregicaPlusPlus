package gregica.common.block;

import gregica.api.GCValues;
import gregica.common.block.te.LaserVacuumPipeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class CommonBlocks {
    
    public static final Block OpaqueLVPipe = new LaserVacuumPipeBlock(false);
    public static final Block TransparentLVPipe = new LaserVacuumPipeBlock(true);

    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        //registerItemModel(TRANSPARENT_CASING);
        if(GCValues.IS_TC_LOADED) registerItemModel(getEssentiaHatch());
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(@Nonnull Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            //noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(
                    Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }
    
    @Optional.Method(modid = "thaumcraft")
    public static TEBlock getEssentiaHatch(){
        return Holder.ESSENTIA_HATCH;
    }
    
    private static class Holder{
        public static final TEBlock ESSENTIA_HATCH = new TEBlock("essentia_hatch", 1);
    }

}
