package gregica.api.blocks;

import gregtech.api.GTValues;
import gregtech.common.blocks.MetaBlocks;
import gregica.common.block.GCMetaBlocks;
import net.minecraft.block.state.IBlockState;

public interface ITiredGlass extends ITired {
    
    @Override
    default Object getTire() {
        return getGlassTier();
    }
    
    int getGlassTier();
    
    default long getTireVoltage(){
        return GTValues.V[getGlassTier()];
    }
    
    default String getTireName(){
        return GTValues.VN[getGlassTier()];
    }
    
    default String getTireNameColored(){
        return GTValues.VNF[getGlassTier()];
    }
    
    static int getGlassTier(IBlockState state){
        if(state.getBlock() == MetaBlocks.TRANSPARENT_CASING){
            return ((ITiredGlass)(Object)MetaBlocks.TRANSPARENT_CASING.getState(state)).getGlassTier();
        }
        if(state.getBlock() == GCMetaBlocks.TRANSPARENT_CASING){
            return GCMetaBlocks.TRANSPARENT_CASING.getState(state).getGlassTier();
        }
        if(state.getBlock() == GCMetaBlocks.TRANSPARENT_CASING1){
            return GCMetaBlocks.TRANSPARENT_CASING1.getState(state).getGlassTier();
        }
        return 0;
    }
}
