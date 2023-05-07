package me.oganesson.gregica.common.recipes.recipemap;

import gregtech.api.GTValues;
import gregtech.api.capability.GregtechDataCodes;
import gregtech.api.capability.IMultipleTankHandler;
import gregtech.api.metatileentity.multiblock.IMaintenance;
import gregtech.api.unification.material.Materials;
import gregtech.common.ConfigHolder;
import me.oganesson.gregica.common.thaumcraft.LargeEssentiaEnergyData;
import me.oganesson.gregica.common.tileentities.EssentiaHatch;
import me.oganesson.gregica.common.tileentities.mte.multi.generators.MTEEssentiaGenerator;
import me.oganesson.gregica.common.unification.materials.GCMaterials;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;

import javax.annotation.Nonnull;

public class EssentiaLogic {

    private final MTEEssentiaGenerator host;
    private int maxProgress = 0;
    private int progressTime = 0;
    private final boolean hasMaintenance;
    private boolean isActive;
    private boolean isWorkingEnabled = true;
    private boolean wasActiveAndNeedsUpdate;
    protected long mLeftEnergy;
    private int mUpgrade = 1;
    private int mEUt;
    private int eAmpereFlow;
    private int mStableValue;

    public EssentiaLogic(MTEEssentiaGenerator generator) {
        this.host = generator;
        this.hasMaintenance = ConfigHolder.machines.enableMaintenance && ((IMaintenance) generator).hasMaintenanceMechanics();
    }

    public int getProgressPercent() {
        return (int) ((1.0F * progressTime / getMaxProgress()) * 100);
    }

    public void updateLogic() {
        if (!this.isWorkingEnabled) return;
        if (hasMaintenance && ((IMaintenance) host).getNumMaintenanceProblems() > 5) return;
        if(host.energyContainer.getEnergyStored() == host.energyContainer.getEnergyCapacity()) return;


            setEssentiaToEUVoltageAndAmp(host.energyContainer.getOutputVoltage(), host.energyContainer.getOutputAmperage());
            if (!this.isActive)
                setActive(mEUt * eAmpereFlow > 0);
            progressTime++;
            host.energyContainer.addEnergy((long) mEUt * eAmpereFlow);
            if (progressTime % getMaxProgress() != 0) return;
            progressTime = 0;
            if (mEUt * eAmpereFlow <= 0)
                setActive(false);
    }

    public void invalidate() {
        this.progressTime = 0;
        this.maxProgress = 0;
        setActive(false);
    }

    public int getProgress() {
        return progressTime;
    }

    public int getMaxProgress() {
        return maxProgress;
    }

    public void setMaxProgress(int val) {
        maxProgress = val;
    }

    public boolean isWorkingEnabled() {
        return isWorkingEnabled;
    }

    public void setWorkingEnabled(boolean workingEnabled) {
        this.isWorkingEnabled = workingEnabled;
        this.host.markDirty();
        World world = this.host.getWorld();
        if (world != null && !world.isRemote) {
            this.host.writeCustomData(GregtechDataCodes.WORKING_ENABLED, buf -> buf.writeBoolean(workingEnabled));
        }
    }

    public boolean isWorking() {
        return isActive && isWorkingEnabled;
    }

    public void setActive(boolean active) {
        if (this.isActive != active) {
            this.isActive = active;
            this.host.markDirty();
            World world = this.host.getWorld();
            if (world != null && !world.isRemote) {
                this.host.writeCustomData(GregtechDataCodes.WORKABLE_ACTIVE, buf -> buf.writeBoolean(active));
            }
        }
    }

    public boolean isActive() {
        return this.isActive && isWorkingEnabled();
    }

    public NBTTagCompound writeToNBT(@Nonnull NBTTagCompound data) {
        data.setBoolean("isActive", this.isActive);
        data.setBoolean("isWorkingEnabled", this.isWorkingEnabled);
        data.setBoolean("wasActiveAndNeedsUpdate", this.wasActiveAndNeedsUpdate);
        data.setInteger("progressTime", progressTime);
        data.setInteger("maxProgress", maxProgress);
        data.setLong("mLeftEnergy", mLeftEnergy);
        data.setInteger("mEUt", mEUt);
        data.setInteger("eAmpereFlow", eAmpereFlow);
        data.setInteger("mUpgrade", mUpgrade);
        return data;
    }

    public void readFromNBT(@Nonnull NBTTagCompound data) {
        this.isActive = data.getBoolean("isActive");
        this.isWorkingEnabled = data.getBoolean("isWorkingEnabled");
        this.wasActiveAndNeedsUpdate = data.getBoolean("wasActiveAndNeedsUpdate");
        this.progressTime = data.getInteger("progressTime");
        this.maxProgress = data.getInteger("maxProgress");
        mLeftEnergy = data.getLong("mLeftEnergy");
        mEUt = data.getInteger("mEUt");
        eAmpereFlow = data.getInteger("eAmpereFlow");
        mUpgrade = data.getInteger("mUpgrade");
    }

    public void writeInitialSyncData(@Nonnull PacketBuffer buf) {
        buf.writeBoolean(this.isActive);
        buf.writeBoolean(this.isWorkingEnabled);
        buf.writeBoolean(this.wasActiveAndNeedsUpdate);
        buf.writeInt(this.progressTime);
        buf.writeInt(this.maxProgress);
        buf.writeLong(mLeftEnergy);
        buf.writeInt(mEUt);
        buf.writeInt(eAmpereFlow);
    }

    public void receiveInitialSyncData(@Nonnull PacketBuffer buf) {
        setActive(buf.readBoolean());
        setWorkingEnabled(buf.readBoolean());
        setWasActiveAndNeedsUpdate(buf.readBoolean());
        this.progressTime = buf.readInt();
        this.maxProgress = buf.readInt();
        mLeftEnergy = buf.readLong();
        mEUt = buf.readInt();
        eAmpereFlow = buf.readInt();
    }

    public void receiveCustomData(int dataId, PacketBuffer buf) {
        if (dataId == GregtechDataCodes.IS_WORKING) {
            setActive(buf.readBoolean());
            host.scheduleRenderUpdate();
        }
    }

    public void setStable(int val) {
        this.mStableValue = val;
    }

    public int getUpgrade() {
        return this.mUpgrade;
    }

    public void setUpgrade(int val) {
        this.mUpgrade = val;
    }

    public boolean wasActiveAndNeedsUpdate() {
        return this.wasActiveAndNeedsUpdate;
    }

    public void setWasActiveAndNeedsUpdate(boolean wasActiveAndNeedsUpdate) {
        this.wasActiveAndNeedsUpdate = wasActiveAndNeedsUpdate;
    }

    public void setEssentiaToEUVoltageAndAmp(long voltageLimit, long ampLimit) {
        long EUt = mLeftEnergy;
        long EUVoltage = voltageLimit, EUAmp = 1;

        for (EssentiaHatch hatch : host.mEssentiaHatch) {
            AspectList aspects = hatch.getAspects();
            for (Aspect aspect : aspects.aspects.keySet()) {
                if (!isValidEssentia(aspect) || getPerAspectEnergy(aspect) == 0) continue;
                while (EUt <= (voltageLimit * ampLimit) && aspects.getAmount(aspect) > 0) {
                    EUt += getPerAspectEnergy(aspect) * mStableValue / 25;
                    aspects.reduce(aspect, 1);
                    if (aspects.getAmount(aspect) == 0) aspects.remove(aspect);
                }
            }
            if (EUt == 0 && aspects.size() != 0) {
                if (!isValidEssentia(aspects.getAspects()[0]) || getPerAspectEnergy(aspects.getAspects()[0]) == 0)
                    continue;
                EUt += getPerAspectEnergy(aspects.getAspects()[0]) * mStableValue / 25;
                aspects.reduce(aspects.getAspects()[0], 1);
                if (aspects.getAmount(aspects.getAspects()[0]) == 0) aspects.remove(aspects.getAspects()[0]);
            }
        }

        if (EUt <= voltageLimit) {
            EUVoltage = EUt;
            EUAmp = 1;
            mLeftEnergy = 0;
        } else {
            while (EUVoltage * (EUAmp + 1) <= EUt && EUAmp + 1 <= ampLimit) {
                EUAmp++;
            }
            mLeftEnergy = EUt - (EUVoltage * EUAmp);
        }

        this.mEUt = (int) EUVoltage;
        this.eAmpereFlow = (int) EUAmp;
    }

    public boolean isValidEssentia(Aspect aspect) {
        int type = LargeEssentiaEnergyData.getAspectTypeIndex(aspect);
        return type != -1 && (mUpgrade & (1 << type)) != 0;
    }

    public long getPerAspectEnergy(Aspect aspect) {
        int type = LargeEssentiaEnergyData.getAspectTypeIndex(aspect);
        if (!isValidEssentia(aspect)) return 0;
        switch (type) {
            case 0:
                return normalEssentia(aspect);
            case 1:
                return airEssentia(aspect);
            case 2:
                return thermalEssentia(aspect);
            case 3:
                return unstableEssentia(aspect);
            case 4:
                return victusEssentia(aspect);
            case 5:
                return taintedEssentia(aspect);
            case 6:
                return mechanicEssentia(aspect);
            case 7:
                return spiritEssentia(aspect);
            case 8:
                return radiationEssentia(aspect);
            case 9:
                return electricEssentia(aspect);
            default:
                return 0;
        }
    }

    public long normalEssentia(Aspect aspect) {
        return LargeEssentiaEnergyData.getAspectFuelValue(aspect);
    }

    public long airEssentia(Aspect aspect) {
        long baseValue = LargeEssentiaEnergyData.getAspectFuelValue(aspect);
        double ceoOutput = 0;
        int ceoInput = (int) LargeEssentiaEnergyData.getAspectCeo(aspect) * 8;
        if (depleteInput(Materials.LiquidAir.getFluid(ceoInput))) {
            ceoOutput = 1.5D;
        } else if (depleteInput(Materials.Air.getFluid(ceoInput))) {
            ceoOutput = 1.0D;
        }
        return (long) (baseValue * ceoOutput);
    }

    public long thermalEssentia(Aspect aspect) {
        long baseValue = LargeEssentiaEnergyData.getAspectFuelValue(aspect);
        double ceoOutput = 0;
        int ceoInput = (int) LargeEssentiaEnergyData.getAspectCeo(aspect) * 2;
        if (depleteInput(GCMaterials.SuperCoolant.getFluid(ceoInput))) {
            ceoOutput = 9.0D;
        } else if (depleteInput(GCMaterials.Cryotheum.getFluid(ceoInput))) {
            ceoOutput = 5.0D;
        } else if (depleteInput(GCMaterials.Coolant.getFluid(ceoInput))) {
            ceoOutput = 1.5D;
        } else if (depleteInput(Materials.Ice.getFluid(ceoInput))) {
            ceoOutput = 1.2D;
        } else if (depleteInput(Materials.DistilledWater.getFluid(ceoInput))) {
            ceoOutput = 1.0D;
        } else if (depleteInput(Materials.Water.getFluid(ceoInput))) {
            ceoOutput = 0.5D;
        }
        return (long) (baseValue * ceoOutput);
    }

    public long unstableEssentia(Aspect aspect) {
        long baseValue = LargeEssentiaEnergyData.getAspectFuelValue(aspect);
        double ceoOutput = 0;
        int ceoInput = (int) LargeEssentiaEnergyData.getAspectCeo(aspect) * 4;
        if (depleteInput(Materials.Xenon.getFluid(ceoInput))) {
            ceoOutput = 4.0D;
        } else if (depleteInput(Materials.Krypton.getFluid(ceoInput))) {
            ceoOutput = 3.0D;
        } else if (depleteInput(Materials.Argon.getFluid(ceoInput))) {
            ceoOutput = 2.5D;
        } else if (depleteInput(Materials.Neon.getFluid(ceoInput))) {
            ceoOutput = 2.2D;
        } else if (depleteInput(Materials.Helium.getFluid(ceoInput))) {
            ceoOutput = 2.0D;
        } else if (depleteInput(Materials.Nitrogen.getFluid(ceoInput))) {
            ceoOutput = 1.0D;
        }
        return (long) (baseValue * ceoOutput);
    }

    public long victusEssentia(Aspect aspect) {
        long baseValue = LargeEssentiaEnergyData.getAspectFuelValue(aspect);
        double ceoOutput = 1.0D;
        int ceoInput = (int) LargeEssentiaEnergyData.getAspectCeo(aspect) * 18;
        if (depleteInput(GCMaterials.XPJuice.getFluid(ceoInput))) {
            ceoOutput = 2.0D;
        } else if (depleteInput(FluidRegistry.getFluidStack("lifeessence", ceoInput))) {
            ceoOutput = 6.0D;
        }
        return (long) (baseValue * ceoOutput);
    }

    public long taintedEssentia(Aspect aspect) {
        long baseValue = LargeEssentiaEnergyData.getAspectFuelValue(aspect);
        double ceoOutput = 1.0D;
        int ceoInput = (int) LargeEssentiaEnergyData.getAspectCeo(aspect) * 3;
        int chance = 2000;
        if (depleteInput(FluidRegistry.getFluidStack("purifying_fluid", ceoInput))) {
            ceoOutput = 60.0D;
            chance = 0;
        } else if (depleteInput(FluidRegistry.getFluidStack("liquid_death", ceoInput))) {
            ceoOutput = Math.pow(25000D / baseValue, 4);
            chance = 4000;
        }

        if (GTValues.RNG.nextInt(10000) < chance) {
            World world = host.getWorld();
            int tX = GTValues.RNG.nextInt(4);
            int tZ = GTValues.RNG.nextInt(4);
            BlockPos pos = host.getPos().add(tX, 0, tZ);
            if (world.isAirBlock(pos))
                world.setBlockState(pos, BlocksTC.fluxGoo.getDefaultState());
        }

        return (long) (baseValue * ceoOutput);
    }

    public long mechanicEssentia(Aspect aspect) {
        long baseValue = LargeEssentiaEnergyData.getAspectFuelValue(aspect);
        double ceoOutput = 0;
        int ceoInput = (int) LargeEssentiaEnergyData.getAspectCeo(aspect) * 20;
        if (depleteInput(Materials.Lubricant.getFluid(ceoInput))) {
            ceoOutput = 1.0D;
        }
        return (long) (baseValue * ceoOutput);
    }

    public long spiritEssentia(Aspect aspect) {
        long baseValue = LargeEssentiaEnergyData.getAspectFuelValue(aspect);
        double ceoOutput = 1.0D;
        int ceoInput = (int) LargeEssentiaEnergyData.getAspectCeo(aspect) * 2;
        if (depleteInput(GCMaterials.Spirit.getFluid(ceoInput))) {
            ceoOutput = 10D * (1 + mStableValue / 100D);
        } else if (depleteInput(GCMaterials.Hollowtears.getFluid(ceoInput))) {
            ceoOutput = 15D * (1 + 100D / mStableValue);
        }
        return (long) (baseValue * ceoOutput);
    }

    public long radiationEssentia(Aspect aspect) {
        long baseValue = LargeEssentiaEnergyData.getAspectFuelValue(aspect);
        double ceoOutput = 1.0D;
        int ceoInput = (int) LargeEssentiaEnergyData.getAspectCeo(aspect) * 6;
        if (depleteInput(Materials.Caesium.getFluid(ceoInput))) {
            ceoOutput = 2.0D;
        } else if (depleteInput(Materials.Uranium235.getFluid(ceoInput))) {
            ceoOutput = 3.0D;
        } else if (depleteInput(Materials.Naquadah.getFluid(ceoInput))) {
            ceoOutput = 4.0D;
        } else if (depleteInput(GCMaterials.AtomicSeparationCatalyst.getFluid(ceoInput))) {
            ceoOutput = 16.0D;
        }
        return (long) (baseValue * ceoOutput);
    }

    public long electricEssentia(Aspect aspect) {
        long baseValue = LargeEssentiaEnergyData.getAspectFuelValue(aspect);
        double ceoOutput = Math.pow(3.0, host.energyContainer.getOutputVoltage());
        return (long) (baseValue * ceoOutput);
    }

    private boolean depleteInput(FluidStack fluid) {
        if (fluid == null) {
            return false;
        }
        IMultipleTankHandler inputTank = host.inputFluidInventory;
        if (fluid.isFluidStackIdentical(inputTank.drain(fluid, false))) {
            inputTank.drain(fluid, true);
            return true;
        }
        return false;
    }

}
