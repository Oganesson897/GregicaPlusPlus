package me.oganesson.gregica.common.gregtech.recipemap;

import gregtech.api.GTValues;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMaintenance;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.common.ConfigHolder;
import me.oganesson.gregica.common.gregtech.metatileentity.MetaTileEntityIndustrialFishingPond;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.List;

import static scala.collection.concurrent.Debug.log;

public class FishPondLogic {
    public static final int MAX_PROGRESS = 20;

    private int progressTime = 0;
    private int maxProgress = 0;
    private int minEnergyTier;
    private final MetaTileEntityIndustrialFishingPond metaTileEntity;
    private int output;
    private String loottable = "";
    private int mode;

    private boolean isActive;
    private boolean isWorkingEnabled = true;
    private boolean wasActiveAndNeedsUpdate;
    private boolean isDone = false;
    protected boolean isInventoryFull;

    private boolean hasNotEnoughEnergy;
    private final boolean hasMaintenance;

    public FishPondLogic(MetaTileEntityIndustrialFishingPond metaTileEntity, int minEnergyTier) {
        this.metaTileEntity = metaTileEntity;
        this.minEnergyTier = minEnergyTier;
        this.hasMaintenance = ConfigHolder.machines.enableMaintenance && ((IMaintenance) metaTileEntity).hasMaintenanceMechanics();
    }


    private boolean isNotStaticWater(Block block) {
        return block == Blocks.AIR || block == Blocks.FLOWING_WATER;
    }

    private boolean depleteInput(FluidStack fluid) {
        if (fluid == null) {
            return false;
        }
        IMultipleTankHandler inputTank = metaTileEntity.getImportFluid();
        if (fluid.isFluidStackIdentical(inputTank.drain(fluid, false))) {
            inputTank.drain(fluid, true);
            return true;
        }
        return false;
    }

    public Boolean CheckWater() {
        int mCurrentDirectionX;
        int mCurrentDirectionZ;
        int mOffsetX_Lower;
        int mOffsetX_Upper;
        int mOffsetZ_Lower;
        int mOffsetZ_Upper;

        mCurrentDirectionX = 4;
        mCurrentDirectionZ = 4;

        mOffsetX_Lower = -4;
        mOffsetX_Upper = 4;
        mOffsetZ_Lower = -4;
        mOffsetZ_Upper = 4;

        // if (aBaseMetaTileEntity.fac)

        final int xDir = this.metaTileEntity.getFrontFacing().getOpposite().getXOffset()
                * mCurrentDirectionX;
        final int zDir = this.metaTileEntity.getFrontFacing().getOpposite().getZOffset()
                * mCurrentDirectionZ;

        int tAmount = 0;
        for (int i = mOffsetX_Lower + 1; i <= mOffsetX_Upper - 1; ++i) {
            for (int j = mOffsetZ_Lower + 1; j <= mOffsetZ_Upper - 1; ++j) {
                for (int h = 0; h < 2; h++) {
                    BlockPos waterCheckPos = this.metaTileEntity.getPos().add(xDir + i, h, zDir + j);
                    Block tBlock = this.metaTileEntity.getWorld().getBlockState(waterCheckPos).getBlock();
                    if (isNotStaticWater(tBlock)) {
                        if (this.metaTileEntity.getImportFluid() != null) {
                                    if(depleteInput(FluidRegistry.getFluidStack("water", 1000)))
                                        this.metaTileEntity.getWorld().setBlockState(
                                                waterCheckPos,
                                                Blocks.WATER.getDefaultState());
                        }
                    }
                    tBlock = this.metaTileEntity.getWorld().getBlockState(this.metaTileEntity.getPos().add(xDir + i, h, zDir + j)).getBlock();
                    if (tBlock == Blocks.WATER || tBlock == Blocks.FLOWING_WATER) {
                        ++tAmount;
                        // log("Found Water");
                    }
                }
            }
        }

        boolean isValidWater = tAmount >= 60;
        if (isValidWater) {
            log("Filled structure.");
        } else {
            log("Did not fill structure.");
        }
        return isValidWater;
    }

    public String getLootTable() {
        if(this.metaTileEntity.getImportItem().getStackInSlot(0).getTagCompound() != null && this.metaTileEntity.getImportItem().getStackInSlot(0).isItemEqual(IntCircuitIngredient.getIntegratedCircuit(0))) {
            if (this.metaTileEntity.getImportItem().getStackInSlot(0).getTagCompound().getInteger("Configuration") == 14) {
                output = 8 + (metaTileEntity.getMaxParallelRecipes() - 2);
                this.loottable = "gameplay/fishing/fish";
                this.mode = 14;
            }
            // Junk
            else if (this.metaTileEntity.getImportItem().getStackInSlot(0).getTagCompound().getInteger("Configuration") == 15) {
                output = 4;
                this.mode = 15;
                this.loottable = "gameplay/fishing/junk";
            }
            // Loot
            else if (this.metaTileEntity.getImportItem().getStackInSlot(0).getTagCompound().getInteger("Configuration") == 16) {
                output = 4;
                this.mode = 16;
                this.loottable = "gameplay/fishing/treasure";
            }else {
                output = 0;
                this.mode = 0;
                this.loottable = "";
            }
        }
        return loottable;
    }
    /**
     * Performs the actual drilling
     * Call this method every tick in update
     */
    public void update() {
        if (metaTileEntity.getWorld().isRemote) return;

        if (!CheckWater()) return;

        if (hasMaintenance && ((IMaintenance) metaTileEntity).getNumMaintenanceProblems() > 5) return;

        // drills that cannot work do nothing
        if (!this.isWorkingEnabled)
            return;

        // check if drilling is possible
        if (!checkCanFish())
            return;

        // if the inventory is not full, drain energy etc. from the drill
        // the storages have already been checked earlier
        if (!isInventoryFull) {
            // actually drain the energy
            consumeEnergy(false);

            // since energy is being consumed the rig is now active
            if (!this.isActive)
                setActive(true);
        } else {
            // the rig cannot drain, therefore it is inactive
            if (this.isActive)
                setActive(false);
            return;
        }

        // increase progress
        if(this.metaTileEntity.getImportItem().getStackInSlot(0).isItemEqual(IntCircuitIngredient.getIntegratedCircuit(0))  && this.metaTileEntity.getImportItem().getStackInSlot(0).getTagCompound() != null) {

            progressTime++;
            if (progressTime % MAX_PROGRESS != 0)
                return;
            progressTime = 0;

            World world = this.metaTileEntity.getWorld();
            int k = world.rand.nextInt(output);
            while (k < output) {

                LootTable table = world.getLootTableManager().getLootTableFromLocation(new ResourceLocation(getLootTable()));
                LootContext ctx = new LootContext.Builder((WorldServer) world).build();
                List<ItemStack> stacks = table.generateLootForPools(world.rand, ctx);

                for (ItemStack stack : stacks)
                    if (metaTileEntity.fillTanks(stack, true)) {
                        metaTileEntity.fillTanks(stack, false);
                    } else {
                        isInventoryFull = true;
                        setActive(false);
                        setWasActiveAndNeedsUpdate(true);
                    }
                k++;
            }
        }else {
            isInventoryFull = true;
            setActive(false);
            setWasActiveAndNeedsUpdate(true);
        }
    }

    protected boolean consumeEnergy(boolean simulate) {
        return metaTileEntity.drainEnergy(simulate);
    }

    /**
     *
     * @return true if the rig is able to drain, else false
     */
    protected boolean checkCanFish() {
        if (!consumeEnergy(true)) {
            if (progressTime >= 2) {
                if (ConfigHolder.machines.recipeProgressLowEnergy)
                    this.progressTime = 1;
                else
                    this.progressTime = Math.max(1, progressTime - 2);

                hasNotEnoughEnergy = true;
            }
            return false;
        }

        if (this.hasNotEnoughEnergy && metaTileEntity.getEnergyInputPerSecond() > 19L * GTValues.VA[metaTileEntity.getEnergyTier()]) {
            this.hasNotEnoughEnergy = false;
        }

        World world = this.metaTileEntity.getWorld();
        LootTable table = world.getLootTableManager().getLootTableFromLocation(new ResourceLocation(getLootTable()));
        LootContext ctx = new LootContext.Builder((WorldServer) world).build();
        List<ItemStack> stacks = table.generateLootForPools(world.rand, ctx);

        for(ItemStack stack : stacks)
        if (metaTileEntity.fillChest(stack, true)) {
            this.isInventoryFull = false;
            return true;
        }
        this.isInventoryFull = true;

        if (isActive()) {
            setActive(false);
            setWasActiveAndNeedsUpdate(true);
        }
        return false;
    }

    public int getMaxProgress() {
        return maxProgress;
    }

    public void setMaxProgress(int val) {
        maxProgress = val;
    }

    public void invalidate() {
        this.progressTime = 0;
        this.maxProgress = 0;
        setActive(false);
    }

    /**
     *
     * @return true if the rig is active
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     *
     * @param active the new state of the rig's activity: true to change to active, else false
     */
    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            this.metaTileEntity.markDirty();
            if (metaTileEntity.getWorld() != null && !metaTileEntity.getWorld().isRemote) {
                this.metaTileEntity.writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, buf -> buf.writeBoolean(active));
            }
        }
    }

    /**
     *
     * @param isWorkingEnabled the new state of the rig's ability to work: true to change to enabled, else false
     */
    public void setWorkingEnabled(boolean isWorkingEnabled) {
        if (this.isWorkingEnabled != isWorkingEnabled) {
            this.isWorkingEnabled = isWorkingEnabled;
            metaTileEntity.markDirty();
            if (metaTileEntity.getWorld() != null && !metaTileEntity.getWorld().isRemote) {
                this.metaTileEntity.writeCustomData(GregtechDataCodes.WORKING_ENABLED, buf -> buf.writeBoolean(isWorkingEnabled));
            }
        }
    }

    /**
     *
     * @return whether working is enabled for the logic
     */
    public boolean isWorkingEnabled() {
        return isWorkingEnabled;
    }

    /**
     *
     * @return whether the rig is currently working
     */
    public boolean isWorking() {
        return isActive && !hasNotEnoughEnergy && isWorkingEnabled;
    }

    /**
     *
     * @return the current progress towards producing fluid of the rig
     */
    public int getProgressTime() {
        return this.progressTime;
    }

    public double getProgressPercent() {
        return getProgressTime() * 1.0 / MAX_PROGRESS;
    }

    protected boolean isOverclocked() {
        return metaTileEntity.getEnergyTier() > minEnergyTier;
    }

    /**
     *
     * @return whether the inventory is full
     */
    public boolean isInventoryFull() {
        return this.isInventoryFull;
    }

    /**
     * writes all needed values to NBT
     * This MUST be called and returned in the MetaTileEntity's {@link MetaTileEntity#writeToNBT(NBTTagCompound)} method
     */
    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound data) {
        data.setBoolean("isActive", this.isActive);
        data.setBoolean("isWorkingEnabled", this.isWorkingEnabled);
        data.setBoolean("wasActiveAndNeedsUpdate", this.wasActiveAndNeedsUpdate);
        data.setBoolean("isDone", isDone);
        data.setInteger("progressTime", progressTime);
        data.setInteger("maxProgress", maxProgress);
        data.setBoolean("isInventoryFull", isInventoryFull);
        return data;
    }

    /**
     * reads all needed values from NBT
     * This MUST be called and returned in the MetaTileEntity's {@link MetaTileEntity#readFromNBT(NBTTagCompound)} method
     */
    public void readFromNBT(@Nonnull NBTTagCompound data) {
        this.isActive = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
        this.wasActiveAndNeedsUpdate = data.getBoolean("wasActiveAndNeedsUpdate");
        this.isDone = data.getBoolean("isDone");
        this.progressTime = data.getInteger("progressTime");
        this.maxProgress =  data.getInteger("maxProgress");
        this.isInventoryFull = data.getBoolean("isInventoryFull");
    }

    /**
     * writes all needed values to InitialSyncData
     * This MUST be called and returned in the MetaTileEntity's {@link MetaTileEntity#writeInitialSyncData(PacketBuffer)} method
     */
    public void writeInitialSyncData(@Nonnull PacketBuffer buf) {
        buf.writeBoolean(this.isActive);
        buf.writeBoolean(this.isWorkingEnabled);
        buf.writeBoolean(this.wasActiveAndNeedsUpdate);
        buf.writeInt(this.progressTime);
        buf.writeInt(this.maxProgress);
        buf.writeBoolean(this.isInventoryFull);
    }

    /**
     * reads all needed values from InitialSyncData
     * This MUST be called and returned in the MetaTileEntity's {@link MetaTileEntity#receiveInitialSyncData(PacketBuffer)} method
     */
    public void receiveInitialSyncData(@Nonnull PacketBuffer buf) {
        setActive(buf.readBoolean());
        setWorkingEnabled(buf.readBoolean());
        setWasActiveAndNeedsUpdate(buf.readBoolean());
        this.progressTime = buf.readInt();
        this.maxProgress = buf.readInt();
        this.isInventoryFull = buf.readBoolean();
    }

    /**
     * reads all needed values from CustomData
     * This MUST be called and returned in the MetaTileEntity's {@link MetaTileEntity#receiveCustomData(int, PacketBuffer)} method
     */
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        if (dataId == GregtechDataCodes.WORKABLE_ACTIVE) {
            this.isActive = buf.readBoolean();
            metaTileEntity.scheduleRenderUpdate();
        } else if (dataId == GregtechDataCodes.WORKING_ENABLED) {
            this.isWorkingEnabled = buf.readBoolean();
            metaTileEntity.scheduleRenderUpdate();
        }
    }

    /**
     *
     * @return whether the rig was active and needs an update
     */
    public boolean wasActiveAndNeedsUpdate() {
        return this.wasActiveAndNeedsUpdate;
    }

    /**
     * set whether the rig was active and needs an update
     *
     * @param wasActiveAndNeedsUpdate the state to set
     */
    public void setWasActiveAndNeedsUpdate(boolean wasActiveAndNeedsUpdate) {
        this.wasActiveAndNeedsUpdate = wasActiveAndNeedsUpdate;
    }
}
