package me.oganesson.gregica.common.recipes.recipemap;

import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.multiblock.IMaintenance;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTEAlgaeFarm;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import java.util.Random;

import static scala.collection.concurrent.Debug.log;

public class AlgaeFarmLogic {
    public static final int MAX_PROGRESS = 2000;

    private int progressTime = 0;
    private int maxProgress = 0;
    private int CasingTier=1;
    private final MTEAlgaeFarm metaTileEntity;


    private int mode;

    private boolean isActive;
    private boolean isWorkingEnabled = true;
    private boolean wasActiveAndNeedsUpdate;
    private boolean isDone = false;
    protected boolean isInventoryFull=false;

    private boolean hasNotEnoughEnergy;
    public AlgaeFarmLogic(MTEAlgaeFarm metaTileEntity, int minEnergyTier) {
        this.metaTileEntity = metaTileEntity;
        this.CasingTier = minEnergyTier;
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

        boolean isValidWater = tAmount >= 49;
        if (isValidWater) {
            log("Filled structure.");
        } else {
            log("Did not fill structure.");
        }
        return isValidWater;
    }
    private void CanOutPut()
    {
        if(metaTileEntity.fillChest(new ItemStack(Items.SKULL,1), true) )
        {
            for (int i = 0; i < this.metaTileEntity.getImportItem().getSlots(); i++) {
                if(this.metaTileEntity.getImportItem().getStackInSlot(i).isItemEqual(IntCircuitIngredient.getIntegratedCircuit(0)) && this.metaTileEntity.getImportItem().getStackInSlot(i).getTagCompound() != null)
                {
                    //this.isWorkingEnabled = true;
                    this.isInventoryFull=false;
                    this.mode = this.metaTileEntity.getImportItem().getStackInSlot(i).getTagCompound().getInteger("Configuration");
                    break;
                }
                else
                {
                    //this.isWorkingEnabled = false;
                    this.isInventoryFull=true;
                    this.mode=-1;
                }
            }
        }
        else
        {
            this.isInventoryFull=true;
            this.mode=-1;
        }
    }
    private void CountOutMultiplier()
    {
        EnumFacing facing =  metaTileEntity.getFrontFacing();
        if(facing.getIndex()==2)
        {
            BlockPos pos = metaTileEntity.getPos().add(0,0,1);
            getCasingTire(pos);
        }
        else if(facing.getIndex()==3)
        {
            BlockPos pos = metaTileEntity.getPos().add(0,0,-1);
            getCasingTire(pos);
        }
        else if(facing.getIndex()==4)
        {
            BlockPos pos = metaTileEntity.getPos().add(1,0,0);
            getCasingTire(pos);
        }
        else if(facing.getIndex()==5)
        {
            BlockPos pos = metaTileEntity.getPos().add(-1,0,0);
            getCasingTire(pos);
        }
        else
            this.CasingTier=0;
    }
    private void getCasingTire(BlockPos pos)
    {
        if(MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ULV).equals(metaTileEntity.getWorld().getBlockState(pos)))
        {
            this.CasingTier = 1;
        } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 2;
        } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.MV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 3;
        } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.HV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 4;
        } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.EV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 5;
        } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.IV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 6;
        } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.LuV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 7;
        } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.ZPM).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 8;
        } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 9;
        } else if (MetaBlocks.MACHINE_CASING.getState(BlockMachineCasing.MachineCasingType.UHV).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 10;
        } else {
            this.CasingTier = 11;
        }
    }
    public void update() {
        if (metaTileEntity.getWorld().isRemote) return;
        if (!CheckWater()) return;
        CanOutPut();
        if (!this.isWorkingEnabled)  return;

       if (!isInventoryFull) {
            if (!this.isActive)
                setActive(true);
        } else {
            if (this.isActive)
                setActive(false);
            return;
        }

        if(this.mode==5) {

            CountOutMultiplier();
            progressTime++;
            if (progressTime % (MAX_PROGRESS /Math.pow(2,(double) this.CasingTier-1)) != 0)
                return;
            progressTime = 0;
            int x = new Random().nextInt(5);
            //褐藻
            if(metaTileEntity.fillChest(GCMetaItems.BROWN_ALGAE.getStackForm(x*Math.max(0,(CasingTier-2))), true))
            {
                metaTileEntity.fillChest(GCMetaItems.BROWN_ALGAE.getStackForm(x*Math.max(0,(CasingTier-2))), false);
            }
            else {
                isInventoryFull = true;
                setActive(false);
                setWasActiveAndNeedsUpdate(true);
            }
            //普通
            if(metaTileEntity.fillChest(GCMetaItems.COMMON_ALGAE.getStackForm(x*CasingTier), true))
            {
                metaTileEntity.fillChest(GCMetaItems.COMMON_ALGAE.getStackForm(x*CasingTier), false);
            }
            else {
                isInventoryFull = true;
                setActive(false);
                setWasActiveAndNeedsUpdate(true);
            }
            //绿藻
            if(metaTileEntity.fillChest(GCMetaItems.GREEN_ALGAE.getStackForm(x*CasingTier), true))
            {
                metaTileEntity.fillChest(GCMetaItems.GREEN_ALGAE.getStackForm(x*CasingTier), false);
            }
            else {
                isInventoryFull = true;
                setActive(false);
                setWasActiveAndNeedsUpdate(true);
            }

            //金藻
            if(metaTileEntity.fillChest(GCMetaItems.GOLD_ALGAE.getStackForm(x*Math.max(0,(CasingTier-4))), true))
            {
                metaTileEntity.fillChest(GCMetaItems.GOLD_ALGAE.getStackForm(x*Math.max(0,(CasingTier-4))), false);
            }
            else {
                isInventoryFull = true;
                setActive(false);
                setWasActiveAndNeedsUpdate(true);
            }
            //红藻
            if(metaTileEntity.fillChest(GCMetaItems.RED_ALGAE.getStackForm(x*Math.max(0,(CasingTier-5))/2), true))
            {
                metaTileEntity.fillChest(GCMetaItems.RED_ALGAE.getStackForm(x*Math.max(0,(CasingTier-5))/2), false);
            }
            else {
                isInventoryFull = true;
                setActive(false);
                setWasActiveAndNeedsUpdate(true);
            }
            //T藻
        //    if(metaTileEntity.fillChest(GCMetaItems.T_ALGAE.getStackForm(x*Math.min(0,(CasingTier-4))), true))
         //   {
         //       metaTileEntity.fillChest(GCMetaItems.T_ALGAE.getStackForm(x*Math.min(0,(CasingTier-4))), false);
         //   }
        //    else {
         //       isInventoryFull = true;
         //       setActive(false);
        //        setWasActiveAndNeedsUpdate(true);
        //    }


        }else {
            isInventoryFull = true;
            setActive(false);
            setWasActiveAndNeedsUpdate(true);
        }
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
        return getProgressTime() * 1.0 / (MAX_PROGRESS/Math.pow(2,(double) this.CasingTier-1));
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
    public boolean wasActiveAndNeedsUpdate() {
        return this.wasActiveAndNeedsUpdate;
    }


    public void setWasActiveAndNeedsUpdate(boolean wasActiveAndNeedsUpdate) {
        this.wasActiveAndNeedsUpdate = wasActiveAndNeedsUpdate;
    }
}
