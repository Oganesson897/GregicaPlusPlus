package gregica.common.tileentities.mte.multipart;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregica.client.GCTextures;
import gregica.utils.GCLangUtil;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.unification.material.Materials;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockNotifiablePart;
import gregica.api.capability.fluid.InfFluidTank;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

//Infinite water
public class MTEInfWaterHatch extends MetaTileEntityMultiblockNotifiablePart implements IMultiblockAbilityPart<IFluidTank> {
    
    private final InfFluidTank tank;
    
    private boolean needUpgrade = false;
    
    public MTEInfWaterHatch(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, 6, false);
        this.tank = new InfFluidTank(Materials.Water.getFluid(1000),this,false);
        this.initializeInventory();
    }
    
    @Override
    public void update() {
        super.update();
        if(!this.getWorld().isRemote && needUpgrade){
            needUpgrade = false;
            this.tank.update();
        }
    }
    
    @Override
    protected FluidTankList createImportFluidHandler() {
        return new FluidTankList(true,this.tank);
    }
    
    @Override
    public void addToMultiBlock(MultiblockControllerBase controllerBase) {
        super.addToMultiBlock(controllerBase);
        this.needUpgrade = true;
    }
    
    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if(this.shouldRenderOverlay()){
            GCTextures.INF_WATER.renderSided(getFrontFacing(),renderState,translation,pipeline);
        }
    }
    
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEInfWaterHatch(this.metaTileEntityId);
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
    public MultiblockAbility<IFluidTank> getAbility() {
        return MultiblockAbility.IMPORT_FLUIDS;
    }
    
    @Override
    public void registerAbilities(List<IFluidTank> list) {
        list.add(this.tank);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, @NotNull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(I18n.format("gregica.tooltip.inf_water1"));
        tooltip.add(I18n.format("gregica.tooltip.inf_water3"));
        String tooltip2 = I18n.format("gregica.tooltip.inf_water2");
        if(tooltip2.contains("§")){
            tooltip.add(tooltip2);
            tooltip.add(TextFormatting.UNDERLINE.toString()+TextFormatting.BOLD+GCLangUtil.currentRainbowString(GCLangUtil.getEnglishLang("gregica.tooltip.inf_water2")));
        }
        else {
            tooltip.add(TextFormatting.UNDERLINE.toString()+TextFormatting.BOLD+GCLangUtil.currentRainbowString(GCLangUtil.currentRainbowModifier()+tooltip2));
        }
    }
}
