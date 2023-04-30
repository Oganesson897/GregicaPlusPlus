package me.oganesson.gregica.common.tileentities.mte.multi.energy;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.GregtechTileCapabilities;
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
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static me.oganesson.gregica.client.GCTextures.ACTIVE_TRANSFORMER;

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
                        .or(abilities(MultiblockAbility.INPUT_ENERGY).setPreviewCount(2))
                        .or(abilities(MultiblockAbility.OUTPUT_ENERGY).setPreviewCount(1))
                ).build();
    }

    @Override
    public void addToolUsages(ItemStack stack, @Nullable World world, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("gregtech.tool_action.screwdriver.access_covers"));
        tooltip.add(I18n.format("gregtech.tool_action.wrench.set_facing"));
        super.addToolUsages(stack, world, tooltip, advanced);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE)
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this);
        return super.getCapability(capability, side);
    }
    
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCTextures.HIGH_POWER_CASING;
    }
    @Nonnull
    protected ICubeRenderer getFrontOverlay() {
        return ACTIVE_TRANSFORMER;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), isActive(), this.logic.isWorkingEnabled());
    }
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEActiveTransformer(metaTileEntityId);
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }
}
