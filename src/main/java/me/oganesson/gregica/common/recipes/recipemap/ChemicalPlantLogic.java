package me.oganesson.gregica.common.recipes.recipemap;

import gregtech.api.capability.IMultiblockController;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.recipes.Recipe;
import gregtech.common.ConfigHolder;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.api.capability.ChemicalPlantProperties;
import me.oganesson.gregica.api.capability.quantum.InputQubitProperty;
import me.oganesson.gregica.common.tileentities.mte.multi.machines.MTEChemicalPlant;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static gregtech.api.GTValues.V;
import static gregtech.api.GTValues.VA;

public class ChemicalPlantLogic extends MultiblockRecipeLogic {

    private int level;

    private int CasingTier;
    private int CasingTier1;
    private int TubeTier;
    private int coilTier;
    private MTEChemicalPlant metaTileEntity;

    public ChemicalPlantLogic(MTEChemicalPlant tileEntity) {
        super(tileEntity);
        setAllowOverclocking(true);
        this.metaTileEntity = tileEntity;
    }

    protected long getEnergyInputPerSecond() {
        return Math.min(V[getRecipeLevel()], this.getEnergyContainer().getInputPerSec());
    }

    protected long getMaxVoltage() {
        return Math.min(this.getEnergyContainer().getInputVoltage(), VA[getRecipeLevel()]);
    }

    public int getRecipeLevel(){
        return this.CasingTier;
    }

    protected boolean canProgressRecipe() {
        return super.canProgressRecipe() && !((IMultiblockController)this.metaTileEntity).isStructureObstructed() && this.metaTileEntity.getEnergyContainer().getInputVoltage() >= getMaxVoltage();
    }

    public void update() {
        if(!metaTileEntity.getWorld().isRemote)
        getMachineTier();
    }

    @Override
    protected void updateRecipeProgress() {
        if (V[this.CasingTier] < this.recipeEUt) {
            return;
        }
        boolean drawEnergy = drawEnergy(recipeEUt, false);
        if (drawEnergy || (recipeEUt < 0)) {
            if (++progressTime >= maxProgressTime) {
                completeRecipe();
            }
        } else if (recipeEUt > 0) {
            //only set hasNotEnoughEnergy if this recipe is consuming recipe
            //generators always have enough energy
            this.hasNotEnoughEnergy = true;
            progressTime = 0;
        }
    }

    @Override
    protected void setupRecipe(Recipe recipe) {
        super.setupRecipe(recipe);
        this.CasingTier = recipe.getProperty(ChemicalPlantProperties.getInstance(), 0);
    }

    private void getMachineTier()
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

    private void getTubeTier(BlockPos pos)
    {
        if(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE).equals(metaTileEntity.getWorld().getBlockState(pos)))
        {
            this.CasingTier = 1;
        } else if (MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 2;
        } else if (MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE).equals(metaTileEntity.getWorld().getBlockState(pos))) {
            this.CasingTier = 3;
        } else {
            this.CasingTier = 0;
        }
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = super.serializeNBT();
        compound.setInteger("machineLevel", this.CasingTier);
        return compound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound compound) {
        super.deserializeNBT(compound);
        this.CasingTier = compound.getInteger("machineLevel");
    }
}
