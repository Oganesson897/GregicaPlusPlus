package gregica.common.tileentities.mte.multi.machines;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregica.api.GCValues;
import gregica.api.capability.GCCapabilities;
import gregica.api.predicate.TiredTraceabilityPredicate;
import gregica.api.recipe.GCRecipeMaps;
import gregica.client.GCTextures;
import gregica.api.utils.GCUtil;
import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.PatternMatchContext;
import gregtech.api.recipes.Recipe;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.blocks.BlockWireCoil;
import gregica.api.blocks.impl.WrappedIntTired;
import gregica.api.capability.chemical_plant.ChemicalPlantProperties;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.List;

import static gregtech.api.GTValues.VA;

public class MTEChemicalPlant extends RecipeMapMultiblockController {

    private int coilLevel;
    private int casingTier;
    private int tubeTier;
    
    private int voltageTier;
    
    private int tier;
    

    public MTEChemicalPlant(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, GCRecipeMaps.CHEMICAL_PLANT);
        this.recipeMapWorkable = new ChemicalPlantLogic(this);
    }
    
    @Override
    public void update() {
        super.update();
       
        if(this.getWorld().isRemote && this.casingTier == 0){
            this.writeCustomData(GCValues.REQUIRE_DATA_UPDATE, buf -> {});
        }
    }
    
    
    
    @SuppressWarnings("SpellCheckingInspection")
    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("EEEEEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                .aisle("EMMMMME", "#MXAXM#", "##TAT##", "##XAX##", "##TAT##", "#MXAXM#", "CCCCCCC")
                .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                .aisle("EEESEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                .where('S', selfPredicate())
                .where('E', TiredTraceabilityPredicate.CP_CASING
                        .or(abilities(MultiblockAbility.MAINTENANCE_HATCH).setExactLimit(1))
                        .or(abilities(MultiblockAbility.EXPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.IMPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(1))
                        .or(abilities(GCCapabilities.CATALYST).setMaxGlobalLimited(2).setPreviewCount(1))
                        .or(abilities(MultiblockAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2).setPreviewCount(1)))
                .where('C',TiredTraceabilityPredicate.CP_CASING)
                .where('X', heatingCoils())
                .where('M', TiredTraceabilityPredicate.MACHINE_CASINGS)
                .where('T',TiredTraceabilityPredicate.CP_TUBE)
                .where('#', any())
                .where('A',air())
                .build();
    }
    
    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }
    
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCTextures.CHEMICAL_PLANT;
    }

    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), this.recipeMapWorkable.isActive(), this.recipeMapWorkable.isWorkingEnabled());
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        switch (this.casingTier){
            case (2):{
                return Textures.SOLID_STEEL_CASING;
            }
            case (3):{
                return Textures.FROST_PROOF_CASING;
            }
            case (4):{
                return Textures.CLEAN_STAINLESS_STEEL_CASING;
            }
            case (5):{
                return Textures.STABLE_TITANIUM_CASING;
            }
            case (6):{
                return Textures.ROBUST_TUNGSTENSTEEL_CASING;
            }
            default:{
                return Textures.BRONZE_PLATED_BRICKS;
            }
        }
    }
    
    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if(dataId == GCValues.UPDATE_TIER){
            this.casingTier = buf.readInt();
        }
        if(dataId == GCValues.REQUIRE_DATA_UPDATE){
            this.writeCustomData(GCValues.UPDATE_TIER,buf1 -> buf1.writeInt(this.casingTier));
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, @NotNull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        tooltip.add(TooltipHelper.RAINBOW_SLOW + I18n.format("gregtech.machine.perfect_oc"));
    }
    
    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        textList.add(new TextComponentString(String.format("coilTire: %d",coilLevel)));
        textList.add(new TextComponentString(String.format("casingTire: %d",casingTier)));
        textList.add(new TextComponentString(String.format("tubeTire: %d",tubeTier)));
        textList.add(new TextComponentString(String.format("tire: %d",tier)));
    }
    
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTEChemicalPlant(metaTileEntityId);
    }

    @Override
    protected void formStructure(PatternMatchContext context) {
        super.formStructure(context);
        Object coilType = context.get("CoilType");
        Object casingTier = context.get("ChemicalPlantCasingTiredStats");
        Object tubeTier = context.get("ChemicalPlantTubeTiredStats");
        Object voltageTier = context.get("MachineCasingTypeTiredStats");
        this.coilLevel = GCUtil.getOrDefault(() -> coilType instanceof IHeatingCoilBlockStats,
                () ->  ((IHeatingCoilBlockStats) coilType).getLevel(),
                BlockWireCoil.CoilType.CUPRONICKEL.getLevel());
        this.casingTier = GCUtil.getOrDefault(() -> casingTier instanceof WrappedIntTired,
                () -> ((WrappedIntTired)casingTier).getIntTier(),
                0);
        this.tubeTier = GCUtil.getOrDefault(() -> tubeTier instanceof WrappedIntTired,
                () -> ((WrappedIntTired)tubeTier).getIntTier(),
                0);
        this.voltageTier = GCUtil.getOrDefault(() -> voltageTier instanceof WrappedIntTired,
                () -> ((WrappedIntTired)voltageTier).getIntTier(),
                0);
        
        this.tier = Math.min(this.casingTier,this.tubeTier);
        
        this.writeCustomData(GCValues.UPDATE_TIER,buf -> buf.writeInt(this.casingTier));
    }
    
    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(this.casingTier);
    }
    
    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.casingTier = buf.readInt();
    }

    protected class ChemicalPlantLogic extends MultiblockRecipeLogic {
        

        public ChemicalPlantLogic(RecipeMapMultiblockController tileEntity) {
            super(tileEntity,true);
        }

        public void update() {
//            if (metaTileEntity.getWorld().isRemote) {
//
//            }
            
        }

        public void setMaxProgress(int maxProgress) {
            this.maxProgressTime = maxProgress / (2 * coilLevel);
            this.metaTileEntity.markDirty();
        }

        protected long getMaxVoltage() {
            return Math.min(super.getMaxVoltage(), VA[voltageTier]);
        }

        @Override
        public boolean checkRecipe(@Nonnull Recipe recipe) {
            if (!super.checkRecipe(recipe))
                return false;
    
            return recipe.getProperty(ChemicalPlantProperties.getInstance(), 0) <= tier;
        }

        @Override
        public int getParallelLimit() {
            return 2 * tubeTier;
        }

        
    }
}
