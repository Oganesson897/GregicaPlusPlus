package me.oganesson.gregica.common.tileentities.mte.multi.energy;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.GregtechTileCapabilities;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.world.DummyWorld;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;
import me.oganesson.gregica.api.blocks.ITiredGlass;
import me.oganesson.gregica.api.mte.IMTEChangeableBattery;
import me.oganesson.gregica.api.mte.energy.BigIntegerBufferLogic;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.client.render.BlocksHighlightRenderer;
import me.oganesson.gregica.common.GCUtility;
import me.oganesson.gregica.common.block.metablock.GCLapotronicCasing;
import me.oganesson.gregica.common.block.GCMetaBlocks;
import me.oganesson.gregica.common.block.metablock.GCMetaGlasses;
import me.oganesson.gregica.common.block.metablock.GCMetaGlasses1;
import me.oganesson.gregica.common.tileentities.mte.multi.MultiblockWithUpdatable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.math.BigInteger;
import java.util.List;

import static gregtech.api.util.RelativeDirection.*;

public class MTELapotronicSuperCapacitor extends MultiblockWithUpdatable<BigIntegerBufferLogic<MTELapotronicSuperCapacitor>>
        implements IMTEChangeableBattery<MTELapotronicSuperCapacitor> {
    
    BigIntegerBufferLogic<MTELapotronicSuperCapacitor> logic = new BigIntegerBufferLogic<>(this);
    
    public MTELapotronicSuperCapacitor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }
    
    @Override
    protected void updateFormedValid() {
        if (!getWorld().isRemote){
            logic.update();
        }
    }
    
    @Override
    public void update() {
        super.update();
//        if(getWorld().isRemote && getOffsetTimer() % 500 == 0){
//            for(BlockPos pos : getAllGlassAndCapacitor()){
//                BlocksHighlightRenderer.renderBlockBoxHighLight(pos,10000);
//            }
//        }
    }
    
    @Override
    public BigIntegerBufferLogic<MTELapotronicSuperCapacitor> getLogic() {
        return logic;
    }
    
    @Override
    public boolean isActive() {
        return super.isActive() && logic.isWorkingEnabled();
    }
    
    @SuppressWarnings("SpellCheckingInspection")
    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(RIGHT, FRONT, UP)
                .aisle("XXSXX","XXXXX","XXXXX","XXXXX","XXXXX")
                .aisle("XXXXX","XXXXX","XXXXX","XXXXX","XXXXX")
                .aisle("GGGGG","GCCCG","GCCCG","GCCCG","GGGGG").setRepeatable(1,50)
                .aisle("ZZZZZ","ZZZZZ","ZZZZZ","ZZZZZ","ZZZZZ")
                .where('S',selfPredicate())
                .where('X',states(getCasingState()).setMinGlobalLimited(10)
                                  .or(abilities(MultiblockAbility.INPUT_ENERGY).setPreviewCount(1))
                                  .or(abilities(MultiblockAbility.OUTPUT_ENERGY).setPreviewCount(1))
                                  .or(autoAbilities(true,false)))
                .where('G',glass())
                .where('C',capacitor())
                .where('Z',states(getCasingState()))
                .build();
    }
    
    private static IBlockState getCasingState(){
        return GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(GCLapotronicCasing.LapotronicCasingType.LapotronicSuperCapacitorCasing);
    }
    
    private static TraceabilityPredicate capacitor(){
        return states(GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(GCLapotronicCasing.LapotronicCasingType.LapotronicCapacitorEmpty))
                .or(states(GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(GCLapotronicCasing.LapotronicCasingType.LapotronicCapacitorEV)))
                .or(states(GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(GCLapotronicCasing.LapotronicCasingType.LapotronicCapacitorIV)))
                .or(states(GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(GCLapotronicCasing.LapotronicCasingType.LapotronicCapacitorLUV)))
                .or(states(GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(GCLapotronicCasing.LapotronicCasingType.LapotronicCapacitorZPM)))
                .or(states(GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(GCLapotronicCasing.LapotronicCasingType.LapotronicCapacitorUV)))
                .or(states(GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(GCLapotronicCasing.LapotronicCasingType.LapotronicCapacitorUHV)))
                .or(states(GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(GCLapotronicCasing.LapotronicCasingType.LapotronicCapacitorUEV))
                );
    }
    
    private static TraceabilityPredicate glass(){
        return states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.FUSION_GLASS))
                .or(states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS)))
                .or(states(MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.CLEANROOM_GLASS)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.TI_BORON_SILICATE_GLASS_BLOCK)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.W_BORON_SILICATE_GLASS_BLOCK)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.CThY_BORON_SILICATE_GLASS_BLOCK)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.CR_BORON_SILICATE_GLASS_BLOCK)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.IR_BORON_SILICATE_GLASS_BLOCK)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.OS_BORON_SILICATE_GLASS_BLOCK)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.NE_BORON_SILICATE_GLASS_BLOCK)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING.getState(GCMetaGlasses.CasingType.SNE_BORON_SILICATE_GLASS_BLOCK)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING1.getState(GCMetaGlasses1.CasingType.AVA_BORON_SILICATE_GLASS_BLOCK)))
                .or(states(GCMetaBlocks.TRANSPARENT_CASING1.getState(GCMetaGlasses1.CasingType.TL_BORON_SILICATE_GLASS_BLOCK)))
                ;
    }
    
    
    @Override
    public void checkStructurePattern() {
        if(!this.isStructureFormed()){
            World world = this.getWorld();
            if(!(world instanceof DummyWorld)) {
                int minGlassTier = 10;
                int maxCapacitorTier = 0;
                int emptyCount = 0;
                int capacitorCount = 0;
                
                for (BlockPos pos : getAllGlassAndCapacitor()) {
                    IBlockState state = world.getBlockState(pos);
                    if(GCLapotronicCasing.isLapotronicCasing(state)){
                        GCLapotronicCasing.LapotronicCasingType type = GCLapotronicCasing.getType(state);
                        if(type == GCLapotronicCasing.LapotronicCasingType.LapotronicCapacitorEmpty) emptyCount++;
                        if(type != GCLapotronicCasing.LapotronicCasingType.LapotronicSuperCapacitorCasing) capacitorCount++;
                        maxCapacitorTier = Math.max(maxCapacitorTier,type.ordinal()-1);
                    }
                    if(isGlass(state)){
                        minGlassTier = Math.min(minGlassTier,getGlassTier(state));
                    }
                }
                //check
                if((float)emptyCount/(float) capacitorCount>0.5f
                    || (maxCapacitorTier>5&&minGlassTier==0)){
                    this.invalidateStructure();
                    return;
                }
            }
        }
        super.checkStructurePattern();
    }
    
    public static boolean isGlass(IBlockState state){
        return state.getBlock() == MetaBlocks.TRANSPARENT_CASING;
    }
    
    public static int getGlassTier(IBlockState state){
        return ITiredGlass.getGlassTier(state);
    }
    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        super.addDisplayText(textList);
        textList.add(new TextComponentTranslation("gregica.multiblock.lapotronic_super_capacitor.stored",getLogic().getStored().toString()));
        textList.add(new TextComponentTranslation("gregica.multiblock.lapotronic_super_capacitor.capacity",getCapacity().toString()));
        textList.add(new TextComponentTranslation("gregica.multiblock.lapotronic_super_capacitor.passive_loss",getPassiveLoss()));
        textList.add(new TextComponentTranslation("gregica.multiblock.active_transformer.percent",
                getCapacity().equals(BigInteger.ZERO) ? 0 : getLogic().getStored().divide(getCapacity()).floatValue()*100f));
    }
    
    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCTextures.LAPOTRONIC_CASING;
    }
    
    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCTextures.LAPOTRONIC_CAPACITOR;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        getFrontOverlay().renderOrientedState(renderState, translation, pipeline, getFrontFacing(), isActive(), this.logic.isWorkingEnabled());
    }
    
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTELapotronicSuperCapacitor(metaTileEntityId);
    }
    
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if (capability == GregtechTileCapabilities.CAPABILITY_CONTROLLABLE)
            return GregtechTileCapabilities.CAPABILITY_CONTROLLABLE.cast(this);
        return super.getCapability(capability, side);
    }
    
    @Override
    public BigInteger getCapacity() {
        return logic.getCapacity();
    }
    
    @Override
    public int getPassiveLoss() {
        return logic.getPassiveLoss();
    }
    
    @Override
    public BigInteger updateCapacity() {
        World world = this.getWorld();
        BigInteger result = BigInteger.ZERO;
        for(BlockPos pos : getAllCapacitors()){
            result = result.add(BigInteger.valueOf(GCLapotronicCasing.getCapacity(world.getBlockState(pos))));
        }
        return result;
    }
    
    @Override
    public int updatePassiveLoss() {
        World world = this.getWorld();
        int result = 0;
        for(BlockPos pos : getAllCapacitors()){
            result = result + GCLapotronicCasing.getPassiveLoss(world.getBlockState(pos));
        }
        return result;
    }
    
    private Iterable<BlockPos.MutableBlockPos> getAllCapacitors(){
        World world = this.getWorld();
        BlockPos pos = this.getPos();
        EnumFacing facing = this.getFrontFacing().getOpposite();
        BlockPos startPos = pos.offset(facing,1).offset(GCUtility.getCounterClockWise(facing)).offset(EnumFacing.UP,2);
        BlockPos searchPos = new BlockPos.MutableBlockPos(startPos);
        int height = 0;
        while (height <= 50){
            if(GCLapotronicCasing.isLapotronicCasing(world.getBlockState(searchPos))){
                height++;
                searchPos = searchPos.up();
                continue;
            }
            break;
        }
        BlockPos endPos = searchPos.offset(facing,2).offset(GCUtility.getClockWise(facing),2).toImmutable();
        return BlockPos.getAllInBoxMutable(startPos,endPos);
    }
    
    private Iterable<BlockPos.MutableBlockPos> getAllGlassAndCapacitor(){
        World world = this.getWorld();
        BlockPos pos = this.getPos();
        EnumFacing facing = this.getFrontFacing().getOpposite();
        BlockPos startPos = pos.offset(facing,1).offset(GCUtility.getCounterClockWise(facing)).offset(EnumFacing.UP,2);
        BlockPos searchPos = new BlockPos.MutableBlockPos(startPos);
        startPos = pos.offset(GCUtility.getClockWise(facing),2).offset(EnumFacing.UP,2);
        int height = 0;
        while (height <= 50){
            if(GCLapotronicCasing.isLapotronicCasing(world.getBlockState(searchPos))){
                height++;
                searchPos = searchPos.up();
                continue;
            }
            break;
        }
        BlockPos endPos = searchPos.offset(facing,3).offset(GCUtility.getCounterClockWise(facing),3).toImmutable();
        return BlockPos.getAllInBoxMutable(startPos,endPos);
    }
    
  
    
    @Override
    protected boolean shouldShowVoidingModeButton() {
        return false;
    }
    
}
