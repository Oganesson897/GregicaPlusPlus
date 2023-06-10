package gregica.client.render.laserpipe;

import codechicken.lib.render.BlockRenderer;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.block.BlockRenderingRegistry;
import codechicken.lib.render.block.ICCBlockRenderer;
import codechicken.lib.render.item.IItemRenderer;
import codechicken.lib.render.pipeline.ColourMultiplier;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.texture.TextureUtils;
import codechicken.lib.util.TransformUtils;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Translation;
import codechicken.lib.vec.Vector3;
import codechicken.lib.vec.uv.IconTransformation;
import gregica.Gregica;
import gregica.common.block.te.LaserVacuumPipeBlock;
import gregica.common.tileentities.te.TELaserPipe;
import gregica.api.utils.GCUtil;
import gregtech.api.pipenet.block.BlockPipe;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.CubeRendererState;
import gregtech.client.renderer.texture.Textures;
import gregica.common.item.CommonItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.BitSet;

public class LaserVacuumPipeRender implements ICCBlockRenderer, IItemRenderer {
    
    public static final Cuboid6 MAIN = BlockPipe.getSideBox(null, 0.5f);
    public static IVertexOperation[] STATIC_OP_O;
    public static IVertexOperation[] STATIC_OP_T;
    
    public static final BitSet ITEM_CONNECT = GCUtil.forIntToBitSet(12,6);
    public final ModelResourceLocation modelLocation;
    private final String name;
   
    private EnumBlockRenderType blockRenderType;
    
    private static final ThreadLocal<BlockRenderer.BlockFace> blockFaces = ThreadLocal.withInitial(BlockRenderer.BlockFace::new);
    
    private TextureAtlasSprite texture;
    private TextureAtlasSprite texture_color;
    
    private TextureAtlasSprite t_texture;
    
    private TextureAtlasSprite t_texture_color;
    
    public static final LaserVacuumPipeRender INSTANCE = new LaserVacuumPipeRender();
    
    public LaserVacuumPipeRender() {
        this.name = LaserVacuumPipeBlock.NAME;
        this.modelLocation = new ModelResourceLocation(new ResourceLocation(Gregica.MOD_ID,name),"normal");
    }
    
    public void preInit(){
        this.blockRenderType = BlockRenderingRegistry.createRenderType(this.name);
        BlockRenderingRegistry.registerRenderer(this.blockRenderType, this);
        MinecraftForge.EVENT_BUS.register(this);
        TextureUtils.addIconRegister(this::registerIcons);
    }
    
    
    @SubscribeEvent
    public void onModelsBake(ModelBakeEvent event) {
        event.getModelRegistry().putObject(this.modelLocation, this);
    }
    
    public void registerIcons(TextureMap map){
        texture = map.registerSprite(Gregica.gcResource("blocks/pipe/laser_normal"));
        texture_color = map.registerSprite(Gregica.gcResource("blocks/pipe/laser_color"));
        t_texture = map.registerSprite(Gregica.gcResource("blocks/pipe/laser_transparent"));
        t_texture_color = map.registerSprite(Gregica.gcResource("blocks/pipe/laser_color_transparent"));
        STATIC_OP_O = new IVertexOperation[]{new IconTransformation(texture)};
        STATIC_OP_T = new IVertexOperation[]{new IconTransformation(t_texture)};
    }
    
    
    @Override
    public void handleRenderBlockDamage(IBlockAccess iBlockAccess, BlockPos blockPos, IBlockState iBlockState, TextureAtlasSprite textureAtlasSprite, BufferBuilder bufferBuilder) {
        CCRenderState renderState = CCRenderState.instance();
        renderState.reset();
        renderState.bind(bufferBuilder);
        renderState.setPipeline((new Vector3(new Vec3d(blockPos))).translation(), new IconTransformation(textureAtlasSprite));
        TileEntity te = iBlockAccess.getTileEntity(blockPos);
        if(te instanceof TELaserPipe) {
            float thickness = 0.5f;
            BitSet connections = ((TELaserPipe) te).getConnections();
            Cuboid6 baseBox = BlockPipe.getSideBox(null, thickness);
            BlockRenderer.renderCuboid(renderState, baseBox, 0);
            for(EnumFacing renderSide : EnumFacing.VALUES) {
                if (connections.get(renderSide.getIndex())) {
                    Cuboid6 sideBox = BlockPipe.getSideBox(renderSide, thickness);
                    BlockRenderer.renderCuboid(renderState, sideBox, 0);
                }
            }
        }
    }
    
    @Override
    public boolean renderBlock(IBlockAccess world, BlockPos pos, IBlockState state, BufferBuilder buffer) {
        TileEntity te = world.getTileEntity(pos);
        if(te instanceof TELaserPipe){
            
            CCRenderState renderState = CCRenderState.instance();
            renderState.reset();
            renderState.bind(buffer);
            renderState.setBrightness(world, pos);
            
            TELaserPipe lp = (TELaserPipe) te;
            int color = lp.getColor();
            int connection = lp.getConnectionsAsInt();
            BitSet connections = lp.getConnections();
            
            BlockRenderLayer renderLayer = MinecraftForgeClient.getRenderLayer();
            boolean[] sideMask = new boolean[EnumFacing.VALUES.length];
    
            for (EnumFacing side : EnumFacing.VALUES) {
                sideMask[side.getIndex()] = state.shouldSideBeRendered(world, pos, side);
            }
            
            Textures.RENDER_STATE.set(new CubeRendererState(renderLayer, sideMask, world));
            
            if (renderLayer == BlockRenderLayer.CUTOUT_MIPPED) {
                boolean isTransparent = lp.isTransparent();
                
                renderState.lightMatrix.locate(world, pos);
                
                IVertexOperation[] faceRenderer = new IVertexOperation[]
                        {new Translation(pos), renderState.lightMatrix,
                                isTransparent ? new IconTransformation(t_texture) :new IconTransformation(texture)};
                        
                IVertexOperation[] faceRenderColor =  new IVertexOperation[]
                        {new Translation(pos), renderState.lightMatrix,
                                //new IconTransformation(texture),
                                isTransparent ? new IconTransformation(t_texture_color) : new IconTransformation(texture_color),
                                new ColourMultiplier(GTUtility.convertRGBtoOpaqueRGBA_CL(EnumDyeColor.byMetadata(color-1).getColorValue()))};
                
                Cuboid6 cuboid6 = MAIN;
                
                if(connection == 0){
                    for(EnumFacing facing:EnumFacing.VALUES){
                        renderOneFace(renderState,faceRenderer,facing,cuboid6,color, faceRenderColor);
                    }
                }
    
                for(EnumFacing facing : EnumFacing.VALUES){
                    if(!connections.get(facing.getIndex())){
                        //不需要判断边上是否链接
                        //因为side和open是一样的
                        //int oppIndex = facing.getOpposite().getIndex();
                        renderOneFace(renderState,faceRenderer,facing,cuboid6,color, faceRenderColor);
                    }
                    else {
                        Cuboid6 cuboid = BlockPipe.getSideBox(facing, 0.5F);
                        for(EnumFacing facing1 : EnumFacing.VALUES){
                            if(facing1.getAxis() != facing.getAxis()){
                                renderOneFace(renderState,faceRenderer,facing1,cuboid, color, faceRenderColor);
                            }
                        }
                        //renderFace(renderState,faceRenderer,facing,cuboid);
                    }
                }
                
            }
            
            Textures.RENDER_STATE.set(null);
            return true;
        }
        return false;
    }
    
    @Override
    public void renderBrightness(IBlockState iBlockState, float v) {
    
    }
    
    @Override
    public void registerTextures(TextureMap textureMap) {
    
    }
    
    
    private static void renderOneFace(CCRenderState renderState,IVertexOperation[] pipeline, EnumFacing side, Cuboid6 cuboid6,int color,IVertexOperation[] colorPipeLine){
        renderFace(renderState,pipeline,side,cuboid6);
        if(color != -1 && colorPipeLine != null){
            renderFace(renderState,colorPipeLine,side,cuboid6);
        }
    }
    private static void renderFace(CCRenderState renderState, IVertexOperation[] pipeline, EnumFacing side, Cuboid6 cuboid6) {
        BlockRenderer.BlockFace blockFace = blockFaces.get();
        blockFace.loadCuboidFace(cuboid6, side.getIndex());
        renderState.setPipeline(blockFace, 0, blockFace.verts.length, pipeline);
        renderState.render();
    }
    
    public EnumBlockRenderType getBlockRenderType() {
        return blockRenderType;
    }
    
    public ModelResourceLocation getModelLocation() {
        return modelLocation;
    }
    
    @Override
    public void renderItem(ItemStack itemStack, ItemCameraTransforms.TransformType transformType) {
        if (itemStack.getItem() == CommonItems.OPAQUE_ITEM_LASER_VACUUM_BLOCK
                || itemStack.getItem() == CommonItems.TRANSPARENT_ITEM_LASER_VACUUM_BLOCK) {
            CCRenderState renderState = CCRenderState.instance();
            GlStateManager.enableBlend();
            renderState.reset();
            renderState.startDrawing(7, DefaultVertexFormats.ITEM);
            IVertexOperation[] faceRenderer = itemStack.getItem() == CommonItems.OPAQUE_ITEM_LASER_VACUUM_BLOCK ?
                    STATIC_OP_O : STATIC_OP_T;
            
            Cuboid6 cuboid6 = BlockPipe.getSideBox(null, 0.5f);
    
            for(EnumFacing facing : EnumFacing.VALUES){
                if(!ITEM_CONNECT.get(facing.getIndex())){
                    renderOneFace(renderState,faceRenderer,facing,cuboid6,-1, null);
                }
                else {
                    Cuboid6 cuboid = BlockPipe.getSideBox(facing, 0.5F);
                    for(EnumFacing facing1 : EnumFacing.VALUES){
                        if(facing1.getAxis() != facing.getAxis()){
                            renderOneFace(renderState,faceRenderer,facing1,cuboid,-1,null);
                        }
                    }
                    renderFace(renderState,faceRenderer,facing,cuboid);
                }
            }
            renderState.draw();
            GlStateManager.disableBlend();
        }
    }
    
    @Override
    public IModelState getTransforms() {
        return TransformUtils.DEFAULT_BLOCK;
    }
    
    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }
    
    @Override
    public boolean isGui3d() {
        return true;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return true;
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.texture;
    }
}
