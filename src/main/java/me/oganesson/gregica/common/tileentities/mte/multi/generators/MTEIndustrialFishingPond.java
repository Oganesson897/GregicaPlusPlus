package me.oganesson.gregica.common.tileentities.mte.multi.generators;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import com.google.common.collect.Lists;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.IWorkable;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.ItemHandlerList;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.util.GTTransferUtils;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.recipes.recipemap.FishPondLogic;
import me.oganesson.gregica.common.block.metablock.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MTEIndustrialFishingPond extends MultiblockWithDisplayBase implements IWorkable, IDataInfoProvider {

    private final FishPondLogic logic;
    private IEnergyContainer energyContainer;
    protected IMultipleTankHandler inputFluidInventory;
    protected ItemHandlerList itemImportInventory;
    protected IItemHandler outputItemInventory;

    public MTEIndustrialFishingPond(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        this.logic = new FishPondLogic(this, GTValues.IV);
    }

    @Override
    protected void updateFormedValid() {
        this.logic.update();
        if (!getWorld().isRemote && this.logic.wasActiveAndNeedsUpdate()) {
            this.logic.setWasActiveAndNeedsUpdate(false);
            this.logic.setActive(false);
        }
    }

    protected void initializeAbilities() {
        this.inputFluidInventory = new FluidTankList(true, getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.outputItemInventory = new ItemHandlerList(getAbilities(MultiblockAbility.EXPORT_ITEMS));
        this.itemImportInventory = new ItemHandlerList(getAbilities(MultiblockAbility.IMPORT_ITEMS));
        this.energyContainer = new EnergyContainerList(getAbilities(MultiblockAbility.INPUT_ENERGY));
    }

    private void resetTileAbilities() {
        this.inputFluidInventory = new FluidTankList(true);
        this.outputItemInventory = new ItemHandlerList(Collections.emptyList());
        this.itemImportInventory = new ItemHandlerList(Collections.emptyList());
        this.energyContainer = new EnergyContainerList(Lists.newArrayList());
    }


    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        initializeAbilities();
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        resetTileAbilities();
        this.logic.invalidate();
    }

    @Override
    public void addToolUsages(ItemStack stack, @Nullable World world, List<String> tooltip, boolean advanced) {
        tooltip.add(I18n.translateToLocal("gregtech.tool_action.screwdriver.access_covers"));
        tooltip.add(I18n.translateToLocal("gregtech.tool_action.wrench.set_facing"));
        super.addToolUsages(stack, world, tooltip, advanced);
    }

    public boolean fillChest(ItemStack stack, boolean simulate) {
        return GTTransferUtils.addItemsToItemHandler(outputItemInventory, simulate, Collections.singletonList(stack));
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("EEEEEEEEE", "XXXXXXXXX", "XXXXXXXXX")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EXXXXXXXE", "X#######X", "X#######X")
                .aisle("EEEEEEEEE", "XXXXSXXXX", "XXXXXXXXX")
                .where('S', selfPredicate())
                .where('X', states(getCasingState()).setMinGlobalLimited(105)
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS).setExactLimit(1)).or(abilities(MultiblockAbility.IMPORT_ITEMS).setExactLimit(1)).or(abilities(MultiblockAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1)).or(abilities(MultiblockAbility.MUFFLER_HATCH).setExactLimit(1)).or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1)))
                .where('E', states(getCasingState()).or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3)))
                .where('#', any())
                .build();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MTEIndustrialFishingPond(metaTileEntityId);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return GCTextures.FISHING_CASING;
    }

    public int getMaxParallelRecipes() {
        return (2 * (this.getEnergyTier() + 1));
    }

    protected IBlockState getCasingState() {
        return GCMetaBlocks.GC_BLOCK_CASING.getState(GCMetaCasing.MetalCasingType.FISHING_CASING);
    }

    public long getEnergyInputPerSecond() {
        return energyContainer.getInputPerSec();
    }

    public boolean fillTanks(ItemStack stack, boolean simulate) {
        return GTTransferUtils.addItemsToItemHandler(outputItemInventory, simulate, Collections.singletonList(stack));
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return Textures.VACUUM_FREEZER_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public int getProgress() {
        return logic.getProgressTime();
    }

    @Override
    public int getMaxProgress() {
        return logic.getMaxProgress();
    }

    @Override
    public boolean isWorkingEnabled() {
        return logic.isWorkingEnabled();
    }

    @Override
    public boolean getIsWeatherOrTerrainResistant(){
        return true;
    }

    @Override
    public void setWorkingEnabled(boolean b) {
        logic.setWorkingEnabled(b);
    }

    public IItemHandlerModifiable getImportItem() {
        return itemImportInventory;
    }

    public IMultipleTankHandler getImportFluid() {
        return this.inputFluidInventory;
    }

    @Nonnull
    @Override
    public List<ITextComponent> getDataInfo() {
        return new LinkedList<>();
    }

    public int getEnergyTier() {
        if (energyContainer == null) return GTValues.IV;
        return Math.max(GTValues.LV, GTUtility.getFloorTierByVoltage(energyContainer.getInputVoltage()));
    }

    public boolean drainEnergy(boolean simulate) {
        long energyToDrain = GTValues.VA[getEnergyTier()];
        long resultEnergy = energyContainer.getEnergyStored() - energyToDrain;
        if (resultEnergy >= 0L && resultEnergy <= energyContainer.getEnergyCapacity()) {
            if (!simulate)
                energyContainer.changeEnergy(-energyToDrain);
            return true;
        }
        return false;
    }

    @Override
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound data) {
        super.writeToNBT(data);
        return this.logic.writeToNBT(data);
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.logic.readFromNBT(data);
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        this.logic.writeInitialSyncData(buf);
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.logic.receiveInitialSyncData(buf);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        this.getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.logic.isActive(), this.logic.isWorkingEnabled());
    }

    public boolean isActive() {
        return (isStructureFormed() && this.logic.isActive() && this.logic.isWorkingEnabled());
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        if (!isStructureFormed())
            return;

        if (energyContainer != null && energyContainer.getEnergyCapacity() > 0) {
            int energyContainer = getEnergyTier();
            long maxVoltage = GTValues.V[energyContainer];
            String voltageName = GTValues.VNF[energyContainer];
            textList.add(new TextComponentTranslation("gregtech.multiblock.max_energy_per_tick", maxVoltage, voltageName));
        }

        if (!logic.isWorkingEnabled()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.work_paused"));

        } else if (logic.isActive()) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.running"));
            int currentProgress = (int) (logic.getProgressPercent() * 100);
            textList.add(new TextComponentTranslation("gregtech.multiblock.progress", currentProgress));
        } else {
            textList.add(new TextComponentTranslation("gregtech.multiblock.idling"));
        }

        if (!drainEnergy(true)) {
            textList.add(new TextComponentTranslation("gregtech.multiblock.not_enough_energy").setStyle(new Style().setColor(TextFormatting.RED)));
        }

        if (logic.isInventoryFull())
            textList.add(new TextComponentTranslation("gregtech.multiblock.large_miner.invfull").setStyle(new Style().setColor(TextFormatting.RED)));
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_WORKABLE)
            return GregtechTileCapabilities.CAPABILITY_WORKABLE.cast(this);
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE)
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this);
        return super.getCapability(capability, side);
    }

    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        this.logic.receiveCustomData(dataId, buf);
    }

    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
            tooltip.add(net.minecraft.client.resources.I18n.format("gregica.tooltip.warning", new Object[0]));

    }
}
