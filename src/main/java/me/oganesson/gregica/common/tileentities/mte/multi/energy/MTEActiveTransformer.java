package me.oganesson.gregica.common.tileentities.mte.multi.energy;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockFusionCasing;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.api.mte.IUpdatable;
import me.oganesson.gregica.api.mte.energy.LongBufferLogic;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.block.metablock.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import me.oganesson.gregica.common.tileentities.mte.multi.MultiblockWithUpdatable;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MTEActiveTransformer extends MultiblockWithUpdatable<LongBufferLogic> {
    
    private final LongBufferLogic logic = new LongBufferLogic(this);
    
    
    public MTEActiveTransformer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }
    
    @Override
    public IUpdatable getLogic() {
        return logic;
    }
    
    @Override
    protected void updateFormedValid() {
        if (!getWorld().isRemote){
            logic.update();
        }
    }
    
    @Override
    public boolean hasMaintenanceMechanics() {
        return false;
    }
    
    @Override
    public boolean isActive() {
        return super.isActive() && logic.isWorkingEnabled();
    }
    
    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX","XXX","XXX")
                .aisle("XXX","XEX","XXX")
                .aisle("XXX","XSX","XXX")
                .where('S',selfPredicate())
                .where('E',states(MetaBlocks.FUSION_CASING.getState(BlockFusionCasing.CasingType.SUPERCONDUCTOR_COIL)))
                .where('X',states(GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.HIGH_POWER_CASING))
                        .setMinGlobalLimited(10)
                        .or(abilities(MultiblockAbility.INPUT_ENERGY))
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY))
                ).build();
    }
    
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCTextures.HIGH_POWER_CASING;
    }
    
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEActiveTransformer(metaTileEntityId);
    }
    
}
