package me.oganesson.gregica.common.tileentities.mte.multi.generators;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import com.google.common.collect.Lists;
import gregtech.api.GTValues;
import gregtech.api.capability.IWorkable;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockWithDisplayBase;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.ConfigHolder;
import me.oganesson.gregica.api.predicate.EssentiaCellPredicate;
import me.oganesson.gregica.api.predicate.TileEntityPredicate;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.recipes.recipemap.EssentiaLogic;
import me.oganesson.gregica.common.tileentities.EssentiaHatch;
import me.oganesson.gregica.proxy.CommonProxy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.blocks.BlocksTC;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;

import static me.oganesson.gregica.client.GCTextures.LARGE_ESSENTIA_GENERATOR;
import static me.oganesson.gregica.common.block.metablock.GCMetaCasing.MetalCasingType.MAGIC_CASING;

public class MTEEssentiaGenerator extends MultiblockWithDisplayBase implements IDataInfoProvider, IWorkable {

    private int tier = -1;
    public final List<EssentiaHatch> mEssentiaHatch = new LinkedList<>();
    public IMultipleTankHandler inputFluidInventory;
    public IEnergyContainer energyContainer;
    private final EssentiaLogic logic;
    private final int[] stable = new int[] {0, 1, 2, 5, 10};

    public MTEEssentiaGenerator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        this.logic = new EssentiaLogic(this);
    }

    @Override
    public int getProgress() {
        return logic.getProgress();
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
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_WORKABLE)
            return GregtechTileCapabilities.CAPABILITY_WORKABLE.cast(this);
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE)
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this);
        return super.getCapability(capability, side);
    }

    @Override
    public void setWorkingEnabled(boolean b) {
        logic.setWorkingEnabled(b);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCTextures.MAGIC_CASING;
    }

    protected void initializeAbilities() {
        this.inputFluidInventory = new FluidTankList(true, getAbilities(MultiblockAbility.IMPORT_FLUIDS));
        this.energyContainer = new EnergyContainerList(getAbilities(MultiblockAbility.OUTPUT_ENERGY));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.logic.isActive(), this.logic.isWorkingEnabled());
    }

    private void resetTileAbilities() {
        this.inputFluidInventory = new FluidTankList(true);
        this.energyContainer = new EnergyContainerList(Lists.newArrayList());
    }

    public boolean updateEssentiaHatchState() {
        for (EssentiaHatch hatch : mEssentiaHatch) {
            hatch.mState = logic.getUpgrade();
        }
        return true;
    }

    @Override
    public void addToolUsages(ItemStack stack, @Nullable World world, List<String> tooltip, boolean advanced) {
        super.addToolUsages(stack, world, tooltip, advanced);
    }

    public int getProgressPercent() {
        return (int) logic.getProgressPercent();
    }


    @Nonnull
    protected ICubeRenderer getFrontOverlay() {
        return LARGE_ESSENTIA_GENERATOR;
    }

    protected void addDisplayText(List<ITextComponent> textList) {
        if (!isStructureFormed()) {
            TextComponentTranslation textComponentTranslation = new TextComponentTranslation("gregtech.multiblock.invalid_structure.tooltip", new Object[0]);
            textComponentTranslation.setStyle((new Style()).setColor(TextFormatting.GRAY));
            textList.add((new TextComponentTranslation("gregtech.multiblock.invalid_structure", new Object[0]))
                    .setStyle((new Style()).setColor(TextFormatting.RED)
                            .setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)textComponentTranslation))));
        } else {
            if (ConfigHolder.machines.enableMaintenance && hasMaintenanceMechanics()) {
                addMaintenanceText(textList);
            }
            if (hasMufflerMechanics() && !isMufflerFaceFree()) {
                textList.add((new TextComponentTranslation("gregtech.multiblock.universal.muffler_obstructed", new Object[0]))
                        .setStyle((new Style()).setColor(TextFormatting.RED)
                                .setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentTranslation("gregtech.multiblock.universal.muffler_obstructed.tooltip", new Object[0])))));
            }

            IEnergyContainer energyContainer = this.energyContainer;
            if (energyContainer != null && energyContainer.getEnergyCapacity() > 0L) {
                long maxVoltage = Math.max(energyContainer.getInputVoltage(), energyContainer.getOutputVoltage());
                String voltageName = GTValues.VN[GTUtility.getFloorTierByVoltage(maxVoltage)];
                textList.add(new TextComponentTranslation("gregtech.multiblock.max_energy_per_tick", new Object[] { Long.valueOf(maxVoltage), voltageName }));
            }

            if (!this.isWorkingEnabled()) {
                textList.add(new TextComponentTranslation("gregtech.multiblock.work_paused", new Object[0]));
            } else if (this.isActive()) {
                textList.add(new TextComponentTranslation("gregtech.multiblock.running", new Object[0]));
                int currentProgress = getProgressPercent();
                textList.add(new TextComponentTranslation("gregtech.multiblock.progress", new Object[] { Integer.valueOf(currentProgress) }));
            } else {
                textList.add(new TextComponentTranslation("gregtech.multiblock.idling", new Object[0]));
            }
        }
    }

    @Override
    public boolean onRightClick(EntityPlayer aPlayer, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        if (!getWorld().isRemote) {
            ItemStack tCurrentItem = aPlayer.inventory.getCurrentItem();
            if (tCurrentItem != null
                    && tCurrentItem.getItem().equals(CommonProxy.Upgrades)) {
                int tMeta = tCurrentItem.getItemDamage();
                if ((logic.getUpgrade() & (1 << tMeta)) == 0 && tMeta != 0) {
                    aPlayer.sendMessage(new TextComponentString(
                            tCurrentItem.getDisplayName()
                                    + I18n.translateToLocal("largeessentiagenerator.chat")));
                    tCurrentItem.setCount(tCurrentItem.getCount() - 1);
                    logic.setUpgrade(logic.getUpgrade() | (1 << tMeta));
                }
                updateEssentiaHatchState();
                return true;
            }
        }
        super.onRightClick(aPlayer, hand, facing, hitResult);
        return true;
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        initializeAbilities();
        Object type = context.get("ESS_CELL");
        if (type instanceof Integer) {
            this.tier = (int) type;
        } else {
            this.tier = 0;
        }
        logic.setMaxProgress(20);
        logic.setStable(stable[tier] * 25);
    }

    @Override
    public void invalidateStructure() {
        super.invalidateStructure();
        resetTileAbilities();
        this.logic.invalidate();
    }

    @Nonnull
    @Override
    public List<ITextComponent> getDataInfo() {
        return new LinkedList<>();
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("T##TXT##T", "T###C###T", "A#######A")
                .aisle("##TCCCT##", "###CEC###", "#########")
                .aisle("#TCCCCCT#", "##CEEEC##", "#########")
                .aisle("TCCCCCCCT", "#CEEEEEC#", "#########")
                .aisle("XCCCCCCCX", "CEEEEEEEC", "####S####")
                .aisle("TCCCCCCCT", "#CEEEEEC#", "#########")
                .aisle("#TCCCCCT#", "##CEEEC##", "#########")
                .aisle("##TCCCT##", "###CEC###", "#########")
                .aisle("T##TXT##T", "T###C###T", "A#######A")
                .where('S', selfPredicate())
                .where('T', blocks(BlocksTC.stoneArcaneBrick))
                .where('A', blocks(BlocksTC.amberBrick))
                .where('C', states(getCasing()))
                .where('E', EssentiaCellPredicate.ESSENTIA_CELLS)
                .where('X',
                        abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1)
                                .or(abilities(MultiblockAbility.OUTPUT_ENERGY).setExactLimit(1))
                                .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1))
                                .or(TileEntityPredicate.get(EssentiaHatch.class, this).setExactLimit(1))
                                .or(states(getCasing())))
                .where('#', any())
                .build();
    }

    public IBlockState getCasing() {
        return GCMetaBlocks.GC_BLOCK_CASING.getState(MAGIC_CASING);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEEssentiaGenerator(metaTileEntityId);
    }

    public void addEssentiaHatch(TileEntity te) {
        this.mEssentiaHatch.add((EssentiaHatch) te);
    }

    public int getTier() {
        return this.tier;
    }

    @Override
    protected void updateFormedValid() {
        if (!getWorld().isRemote) {
            this.logic.updateLogic();
            if (this.logic.wasActiveAndNeedsUpdate()) {
                this.logic.setWasActiveAndNeedsUpdate(false);
                this.logic.setActive(false);
            }
        }
    }

    public boolean isActive() {
        return (isStructureFormed() && this.logic.isActive() && this.logic.isWorkingEnabled());
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == GregtechDataCodes.IS_WORKING) {
            this.logic.setActive(buf.readBoolean());
            scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.WORKABLE_ACTIVE) {
            this.logic.setActive(buf.readBoolean());
            scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            this.logic.setWorkingEnabled(buf.readBoolean());
            scheduleRenderUpdate();
        }
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
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }

}
