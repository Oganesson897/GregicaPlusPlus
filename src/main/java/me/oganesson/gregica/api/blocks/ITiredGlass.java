package me.oganesson.gregica.api.blocks;

import gregtech.api.GTValues;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import net.minecraft.block.state.IBlockState;

public interface ITiredGlass {
    int getTier();
    
    default long getTireVoltage(){
        return GTValues.V[getTier()];
    }
    
    default String getTireName(){
        return GTValues.VN[getTier()];
    }
    
    default String getTireNameColored(){
        return GTValues.VNF[getTier()];
    }
    
    static int getGlassTier(IBlockState state){
        if(state.getBlock() == MetaBlocks.TRANSPARENT_CASING){
            return ((ITiredGlass)(Object)MetaBlocks.TRANSPARENT_CASING.getState(state)).getTier();
        }
        if(state.getBlock() == GCMetaBlocks.TRANSPARENT_CASING){
            return GCMetaBlocks.TRANSPARENT_CASING.getState(state).getTier();
        }
        if(state.getBlock() == GCMetaBlocks.TRANSPARENT_CASING1){
            return GCMetaBlocks.TRANSPARENT_CASING1.getState(state).getTier();
        }
        return 0;
    }
}
