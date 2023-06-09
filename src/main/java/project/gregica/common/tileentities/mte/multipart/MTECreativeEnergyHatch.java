package project.gregica.common.tileentities.mte.multipart;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.PipelineUtil;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;
import project.gregica.api.capability.ICreativeOnly;
import project.gregica.api.capability.impl.EnergyContainerCreative;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class MTECreativeEnergyHatch extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IEnergyContainer>, ICreativeOnly {
    
    private final IEnergyContainer energyContainer;
    
    public MTECreativeEnergyHatch(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier);
        this.energyContainer = new EnergyContainerCreative(this,GTValues.V[tier]*64,GTValues.V[tier],0,GTValues.V[tier],0);
    }
    
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTECreativeEnergyHatch(this.metaTileEntityId,getTier());
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState,translation,pipeline);
        Textures.CREATIVE_CONTAINER_OVERLAY.renderSided(getFrontFacing(),renderState,translation,pipeline);
        Textures.ENERGY_IN_HI.renderSided(getFrontFacing(),renderState,translation,PipelineUtil.color(pipeline, GTValues.VC[this.getTier()]));
    }
    
    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }
    
    @Override
    protected boolean openGUIOnRightClick() {
        return false;
    }
    
    @Override
    public MultiblockAbility<IEnergyContainer> getAbility() {
        return  MultiblockAbility.INPUT_ENERGY;
    }
    
    @Override
    public void registerAbilities(List<IEnergyContainer> list) {
        list.add(this.energyContainer);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        String tierName = GTValues.VNF[getTier()];
        
        tooltip.add(I18n.format("gregtech.machine.energy_hatch.input.tooltip"));
        tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_in", energyContainer.getInputVoltage(), tierName));
        tooltip.add(I18n.format("gregtech.universal.tooltip.amperage_in_till", 2));
        tooltip.add(I18n.format("gregtech.universal.tooltip.energy_storage_capacity", energyContainer.getEnergyCapacity()));
        tooltip.add(I18n.format("gregtech.universal.enabled"));
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addToolUsages(ItemStack stack, @Nullable World world, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("gregtech.tool_action.screwdriver.access_covers"));
        tooltip.add(I18n.format("gregtech.tool_action.wrench.set_facing"));
        super.addToolUsages(stack, world, tooltip, advanced);
    }
}
