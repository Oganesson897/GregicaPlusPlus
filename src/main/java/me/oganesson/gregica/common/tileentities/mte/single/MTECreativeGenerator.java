package me.oganesson.gregica.common.tileentities.mte.single;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import com.google.common.collect.Lists;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IControllable;
import gregtech.api.capability.impl.EnergyContainerBatteryBuffer;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.MTETrait;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.TieredMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.PipelineUtil;
import me.oganesson.gregica.api.capability.ICreativeOnly;
import me.oganesson.gregica.api.capability.impl.EnergyContainerCreative;
import me.oganesson.gregica.common.GCUtility;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class MTECreativeGenerator extends TieredMetaTileEntity implements IControllable,IDataInfoProvider, ICreativeOnly {
    
    int outputAmperage = 2;
    private boolean allowEnergyOutput = true;
    
    public MTECreativeGenerator(ResourceLocation metaTileEntityId, int tier) {
        super(metaTileEntityId, tier);
        reinitializeEnergyContainer();
    }
    
    @Override
    protected void reinitializeEnergyContainer() {
        long tierVoltage = GTValues.V[this.getTier()];
        this.energyContainer = new EnergyContainerCreative(this,tierVoltage);
    }
    
    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        Textures.ENERGY_OUT.renderSided(getFrontFacing(), renderState, translation, PipelineUtil.color(pipeline, GTValues.VC[getTier()]));
    }
    
    @Override
    protected boolean isEnergyEmitter() {
        return true;
    }
    
    @Override
    protected boolean openGUIOnRightClick() {
        return false;
    }
    
    @Override
    public boolean onScrewdriverClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        changeAmperage(playerIn.isSneaking()?-1:+1);
        playerIn.sendStatusMessage(
                new TextComponentTranslation("gregica.machine.creative_generator.amperage",this.outputAmperage),
                true);
        return true;
    }
    
    @Override
    protected long getMaxInputOutputAmperage() {
        return 64L;
    }
    
    
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        return capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE ? GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this) : super.getCapability(capability, side);
    }
    
    protected boolean shouldUpdate(MTETrait trait) {
        return !(trait instanceof EnergyContainerBatteryBuffer) || this.allowEnergyOutput;
    }
    
    
    public boolean isValidFrontFacing(EnumFacing facing) {
        return true;
    }
    
    @NotNull
    @Override
    public List<ITextComponent> getDataInfo() {
        return Lists.newArrayList(new TextComponentTranslation("gregtech.battery_buffer.average_output",
                new TextComponentTranslation(GTUtility.formatNumbers(energyContainer.getOutputPerSec() / 20)).setStyle(new Style().setColor(TextFormatting.YELLOW))));
        
    }
    
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        String tierName = GTValues.VNF[this.getTier()];
        tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_in_out", GTValues.V[getTier()], tierName));
        tooltip.add(I18n.format("gregtech.universal.tooltip.amperage_in_till", this.energyContainer.getInputAmperage()));
        tooltip.add(I18n.format("gregtech.universal.tooltip.amperage_out_till", this.getMaxInputOutputAmperage()));
    }
    
    public void addToolUsages(ItemStack stack, @Nullable World world, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.format("gregtech.tool_action.screwdriver.set_output_amperage"));
        tooltip.add(I18n.format("gregtech.tool_action.wrench.set_facing"));
        super.addToolUsages(stack, world, tooltip, advanced);
    }
    
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTECreativeGenerator(metaTileEntityId,getTier());
    }
    
    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        return null;
    }
    
    @Override
    public boolean isWorkingEnabled() {
        return this.allowEnergyOutput;
    }
    
    @Override
    public void setWorkingEnabled(boolean b) {
        this.allowEnergyOutput = b;
        this.notifyBlockUpdate();
    }
    
    public void setOutputAmperage(int i){
        this.outputAmperage = GCUtility.clamp(i,0,64);
    }
    
    public void changeAmperage(int i){
        this.setOutputAmperage(this.outputAmperage+i);
    }
    
    public long getOutputAmperage(){
        return this.outputAmperage;
    }
    
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        NBTTagCompound tagCompound = super.writeToNBT(data);
        tagCompound.setBoolean("AllowEnergyOutput", this.allowEnergyOutput);
        tagCompound.setInteger("OutputAmperage",this.outputAmperage);
        return tagCompound;
    }
    
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        if (data.hasKey("AllowEnergyOutput")) {
            this.allowEnergyOutput = data.getBoolean("AllowEnergyOutput");
        }
        if(data.hasKey("OutputAmperage")){
            this.outputAmperage = data.getInteger("OutputAmperage");
        }
    }
}
