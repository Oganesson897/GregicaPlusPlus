package me.oganesson.gregica.common.tileentities.mte.multipart;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.IDataInfoProvider;
import gregtech.api.metatileentity.IFastRenderMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockAbilityPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.util.GTUtility;
import gregtech.api.util.interpolate.Eases;
import gregtech.client.renderer.handler.BlockPosHighlightRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.shader.postprocessing.BloomEffect;
import gregtech.client.utils.BloomEffectUtil;
import gregtech.client.utils.PipelineUtil;
import gregtech.client.utils.RenderUtil;
import gregtech.common.ConfigHolder;
import gregtech.common.metatileentities.multi.multiblockpart.MetaTileEntityMultiblockPart;
import me.oganesson.gregica.api.GCValues;
import me.oganesson.gregica.api.blocks.IColored;
import me.oganesson.gregica.api.capability.GCCapabilities;
import me.oganesson.gregica.api.capability.impl.EnergyContainerLaser;
import me.oganesson.gregica.api.mte.HatchType;
import me.oganesson.gregica.api.mte.INoticeable;
import me.oganesson.gregica.client.GCTextures;
import me.oganesson.gregica.common.tileentities.te.TELaserPipe;
import me.oganesson.gregica.utils.GCColorUtil;
import me.oganesson.gregica.utils.GCMathUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MTELaserHatch extends MetaTileEntityMultiblockPart implements IMultiblockAbilityPart<IEnergyContainer>, IDataInfoProvider, INoticeable, IColored, IFastRenderMetaTileEntity {
    
    public static final String COLOR_KEY = "LaserColor";
    public static final String UP_KEY = "needUpdate";
    public static final String POS_KEY = "targetPos";
    
    public static final String RENDER_KEY = "renderLaser";
    
    public static final int LASER_COLOR = 0xFF8FFFFF;
    
    private final IEnergyContainer energyContainer;
    private final HatchType type;
    
    private final int amperage;
    
    private final long maxIO;
    
    private int color;
    
    private boolean needUpdateImm;
    
    private boolean renderLaser;
    
    private BlockPos target;
    
    
    public MTELaserHatch(ResourceLocation metaTileEntityId, int tier, int amperage, HatchType type) {
        super(metaTileEntityId, tier);
        this.type = type;
        this.amperage = amperage;
        this.maxIO = GTValues.V[tier]*amperage;
        this.energyContainer = type == HatchType.INPUT ? EnergyContainerLaser.input(this,GTValues.V[tier],amperage)
                : EnergyContainerLaser.output(this,GTValues.V[tier],amperage);
    }
    
    @Override
    public void update() {
        super.update();
        if(!this.getWorld().isRemote && this.type == HatchType.OUTPUT){
            
            if(needUpdateImm){
                updateTarget();
                needUpdateImm = false;
            }
            else if(getOffsetTimer() % 100 == 0){
                updateTarget();
            }
            
            if(this.target != null && getOffsetTimer() % 5 == 0){
                MetaTileEntity mte = GTUtility.getMetaTileEntity(getWorld(),target);
                if(mte instanceof MTELaserHatch) {
                    IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, this.getFrontFacing().getOpposite());
                    long canOutput = container.getEnergyCanBeInserted();
                    canOutput = GCMathUtils.min(canOutput, energyContainer.getEnergyStored(),maxIO);
                    int tier = this.getTier() - ((MTELaserHatch) mte).getTier();
                    if(tier > 0){
                        //this.doExplosion(this.getTier()*1.5F);
                        mte.doExplosion(this.getTier()*1.5F);
                        return;
                    }
                    energyContainer.removeEnergy(canOutput);
                    container.addEnergy(canOutput);
                }
            }
        }
      
    }
    
    public void updateTarget(){
        boolean buff = this.renderLaser;
        if(this.color != -1){
            this.renderLaser = false;
            World world = getWorld();
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(this.getPos()).move(this.getFrontFacing());
            if(this.target != null){
                BlockPos self = this.getPos();
                int distance = (int) target.getDistance(self.getX(),self.getY(),self.getZ());
                for(int i=0;i<distance;i++){
                    if(!world.isBlockLoaded(pos) || isConnectedLaserPipe(world,pos) || isTarget(world,pos)){
                        pos = pos.move(this.getFrontFacing());
                    }
                    else {
                        target = null;
                        this.writeCustomData(GCValues.TARGET_UPDATE_NULL,b -> {});
                        return;
                    }
                }
               // renderLaser = true;
            }
            else {
                while (isConnectedLaserPipe(world,pos)){
                    pos = pos.move(this.getFrontFacing());
                }
                if(isTarget(world,pos)){
                    this.target = pos.toImmutable();
                    this.writeCustomData(GCValues.TARGET_UPDATE,b -> b.writeBlockPos(target));
                   // this.renderLaser = true;
                }
            }
         
        }
        if(buff != this.renderLaser){
            this.writeCustomData(GCValues.RENDER_UPDATE,(b) -> b.writeBoolean(renderLaser));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);
        if (this.shouldRenderOverlay()) {
            Textures.ENERGY_IN_HI.renderSided(this.getFrontFacing(), renderState, translation, PipelineUtil.color(pipeline, GTValues.VC[this.getTier()]));
            if(this.color != 0 && this.color != -1)
                GCTextures.LASER_COLORED.renderSided(getFrontFacing(),renderState,translation,PipelineUtil.color(pipeline,EnumDyeColor.byMetadata(color-1).getColorValue()));
        }
      
    }
    
    @Override
    public void renderMetaTileEntity(double x, double y, double z, float partialTicks) {
        if(this.target != null && this.renderLaser && MinecraftForgeClient.getRenderPass() == 0){
            BloomEffectUtil.requestCustomBloom(RENDER_HANDLER,(bufferBuilder) ->{
                int r_color = RenderUtil.colorInterpolator(LASER_COLOR, -1).apply(Eases.EaseQuadIn.getInterpolation(Math.abs((float)Math.abs(this.getOffsetTimer() % 50L) +  - 25.0F) / 25.0F));
                float a = (float)(r_color >> 24 & 255) / 255.0F;
                float r = (float)(r_color >> 16 & 255) / 255.0F;
                float g = (float)(r_color >> 8 & 255) / 255.0F;
                float b = (float)(r_color & 255) / 255.0F;
                Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
                if (entity != null) {
//                    bufferBuilder.begin(8, DefaultVertexFormats.POSITION_COLOR);
//                    double sideDelta = 6.283185307179586 / (double)10;
//                    double phi = 0;
//                    double cosTheta = 1.0;
//                    double sinTheta = 0.0;
//                    for (int j = 0; j <= 10; ++j) {
//                        phi += sideDelta;
//                        double cosPhi = MathHelper.cos((float) phi);
//                        double sinPhi = MathHelper.sin((float) phi);
//                        double dist = r + 0.1 * cosPhi;
//                        bufferBuilder.pos(x + sinTheta * dist, y + 0.1 * sinPhi, z + cosTheta * dist).color(r, g, b, a).endVertex();
//                        bufferBuilder.pos(x + sinTheta1 * dist, y + 0.1 * sinPhi, z + cosTheta1 * dist).color(r, g, b, a).endVertex();

                   
                   // }
//                bufferBuilder.pos(x+0.4,y+0.4,z+0.4).color(r,g,b,a).endVertex();
//                bufferBuilder.pos(target.getX()+0.4,target.getY()+0.4,target.getZ()+0.4).color(r,g,b,a).endVertex();
//                bufferBuilder.pos(x+0.6,y+0.6,z+0.6).color(r,g,b,a).endVertex();
//                bufferBuilder.pos(target.getX()+0.6,target.getY()+0.6,target.getZ()+0.6).color(r,g,b,a).endVertex();
//                Tessellator.getInstance().draw();
                }
            });
        }
    }
    
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        if(target != null){
            return new AxisAlignedBB(this.getPos().offset(this.getFrontFacing().getOpposite()).offset(this.getFrontFacing().rotateY()),
                    target.offset(this.getFrontFacing().getOpposite()).offset(this.getFrontFacing().rotateY()));
        }
        return new AxisAlignedBB(this.getPos(),this.getPos());
    }
    
    @Override
    public boolean isGlobalRenderer() {
        return true;
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        NBTTagCompound result = super.writeToNBT(data);
        result.setInteger(COLOR_KEY,color);
        result.setBoolean(UP_KEY,needUpdateImm);
        if(target != null) {
            result.setIntArray(POS_KEY, new int[]{target.getX(), target.getY(), target.getZ()});
        }
        result.setBoolean(RENDER_KEY,renderLaser);
        return result;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.color = data.getInteger(COLOR_KEY);
        this.needUpdateImm = data.getBoolean(UP_KEY);
        if(data.hasKey(POS_KEY)){
            int[] pos = data.getIntArray(POS_KEY);
            this.target = new BlockPos(pos[0],pos[1],pos[2]);
        }
        this.renderLaser = data.getBoolean(RENDER_KEY);
    }
    
    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeInt(color);
        buf.writeBoolean(renderLaser);
        if(this.target != null){
            buf.writeBoolean(true);
            buf.writeBlockPos(target);
        }
        buf.writeBoolean(false);
    }
    
    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.color = buf.readInt();
        this.renderLaser = buf.readBoolean();
        if(buf.readBoolean()){
            this.target = buf.readBlockPos();
        }
    }
    
    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MTELaserHatch(this.metaTileEntityId, this.getTier(), this.amperage,this.type);
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
    public MultiblockAbility<IEnergyContainer> getAbility() {
        return this.type == HatchType.INPUT ? MultiblockAbility.INPUT_ENERGY : MultiblockAbility.OUTPUT_ENERGY;
    }
    
    @Override
    public void registerAbilities(List<IEnergyContainer> list) {
        list.add(this.energyContainer);
    }
    
    public int getColor() {
        return color;
    }
    
    public GCColorUtil.StandardColor getStandardColor(){
        return GCColorUtil.StandardColor.getFromInt(color);
    }
    
    public void setColor(int color) {
        this.color = color;
        this.writeCustomData(GCValues.REQUIRE_DATA_UPDATE,(b) -> b.writeInt(color));
        this.notifyBlockUpdate();
        this.markDirty();
        this.scheduleRenderUpdate();
    }
    
    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if(dataId == GCValues.REQUIRE_DATA_UPDATE){
            this.color = buf.readInt();
            //this.notifyBlockUpdate();
            this.markDirty();
            this.scheduleRenderUpdate();
        }
        if(dataId == GCValues.RENDER_UPDATE){
            this.renderLaser = buf.readBoolean();
            //this.notifyBlockUpdate();
            this.markDirty();
            this.scheduleRenderUpdate();
        }
        if(dataId == GCValues.TARGET_UPDATE){
            this.target = buf.readBlockPos();
            this.markDirty();
            this.scheduleRenderUpdate();
        }
        if(dataId == GCValues.TARGET_UPDATE_NULL){
            this.target = null;
            this.markDirty();
            this.scheduleRenderUpdate();
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, @NotNull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, world, tooltip, advanced);
        String tierName = GTValues.VNF[this.getTier()];
        if(this.type == HatchType.OUTPUT){
            tooltip.add(I18n.format("gregica.info.laser_hatch_output"));
            tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_out", this.energyContainer.getOutputVoltage(), tierName));
            tooltip.add(I18n.format("gregtech.universal.tooltip.amperage_out_till", this.energyContainer.getOutputAmperage()));
        }
        else {
            tooltip.add(I18n.format("gregica.info.laser_hatch_input"));
            tooltip.add(I18n.format("gregtech.universal.tooltip.voltage_in",this.energyContainer.getInputVoltage(), tierName));
            tooltip.add(I18n.format("gregtech.universal.tooltip.amperage_in_till",this.energyContainer.getInputAmperage()));
        }
        tooltip.add(I18n.format("gregtech.universal.tooltip.energy_storage_capacity", this.energyContainer.getEnergyCapacity()));
    }
    
    @NotNull
    @Override
    public List<ITextComponent> getDataInfo() {
        List<ITextComponent> result = new ArrayList<>(1);
        result.add(new TextComponentTranslation("gregica.laser.color",color)
                .appendSibling(new TextComponentTranslation(GCColorUtil.StandardColor.getFromInt(color).getI18NKey())));
        if(this.type == HatchType.OUTPUT && this.target != null){
            result.add(new TextComponentString("target: x:"+target.getX()+" y:"+target.getY()+" z:"+target.getZ()));
            BlockPosHighlightRenderer.renderBlockBoxHighLight(target,10000);
        }
        
        return result;
    }
    
    @Override
    public void notice(IBlockAccess world, BlockPos pos) {
        //MetaTileEntity mte = GTUtility.getMetaTileEntity(world,pos);
        if(this.type == HatchType.OUTPUT) this.needUpdateImm = true;
    }
    
    @Override
    public boolean isNoticed() {
        return false;
    }
    
    public boolean isConnectedLaserPipe(World world ,BlockPos pos){
        TileEntity te = world.getTileEntity(pos);
        if(te instanceof TELaserPipe){
            this.renderLaser = this.renderLaser || ((TELaserPipe) te).isTransparent();
            return ((TELaserPipe) te).getColor() == this.color;
        }
        return false;
    }
    
    public boolean isTarget(World world,BlockPos pos){
        MetaTileEntity mte = GTUtility.getMetaTileEntity(world,pos);
        if(mte instanceof MTELaserHatch){
            return ((MTELaserHatch) mte).type == HatchType.INPUT;
        }
        return false;
    }
    
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing side) {
        if(capability == GCCapabilities.COLOR_CAPABILITY){
            return GCCapabilities.COLOR_CAPABILITY.cast(this);
        }
        return super.getCapability(capability, side);
    }
    
    public int getAmperage() {
        return amperage;
    }
    
    static BloomEffectUtil.IBloomRenderFast RENDER_HANDLER = new BloomEffectUtil.IBloomRenderFast() {
        float lastBrightnessX;
        float lastBrightnessY;
        
        public int customBloomStyle() {
            return ConfigHolder.client.shader.fusionBloom.useShader ? ConfigHolder.client.shader.fusionBloom.bloomStyle : -1;
        }
        
        @SideOnly(Side.CLIENT)
        public void preDraw(BufferBuilder buffer) {
            BloomEffect.strength = (float)ConfigHolder.client.shader.fusionBloom.strength;
            BloomEffect.baseBrightness = (float)ConfigHolder.client.shader.fusionBloom.baseBrightness;
            BloomEffect.highBrightnessThreshold = (float)ConfigHolder.client.shader.fusionBloom.highBrightnessThreshold;
            BloomEffect.lowBrightnessThreshold = (float)ConfigHolder.client.shader.fusionBloom.lowBrightnessThreshold;
            BloomEffect.step = 0.4F;
            this.lastBrightnessX = OpenGlHelper.lastBrightnessX;
            this.lastBrightnessY = OpenGlHelper.lastBrightnessY;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
            GlStateManager.disableTexture2D();
        }
        
        @SideOnly(Side.CLIENT)
        public void postDraw(BufferBuilder buffer) {
            GlStateManager.enableTexture2D();
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, this.lastBrightnessX, this.lastBrightnessY);
        }
    };
    
}
