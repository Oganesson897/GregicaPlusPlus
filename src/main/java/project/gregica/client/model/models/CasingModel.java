package project.gregica.client.model.models;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import mcp.MethodsReturnNonnullByDefault;
import project.gregica.Gregica;
import project.gregica.client.model.bakedmodels.CasingBakedModel;
import project.gregica.common.block.metablock.GCMetaCasing;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ItemLayerModel;
import net.minecraftforge.client.model.animation.ModelBlockAnimation;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;


@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CasingModel implements IModel {
    
    private final GCMetaCasing.MetalCasingType type;
    
    private final ModelBlock model;
    
    private final ModelBlockAnimation animation;
    
    public static Map<GCMetaCasing.MetalCasingType, ResourceLocation> used;
    
    private final FaceBakery faceBakery = new FaceBakery();
    
    
    public CasingModel(GCMetaCasing.MetalCasingType type, ModelBlock model) {
        this.type = type;
        this.model = model;
        this.animation = ModelBlockAnimation.loadVanillaAnimation(Minecraft.getMinecraft().getResourceManager(),
                genCasingResourceLocation(type.getName()));
    }
    
    
    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();
        Optional<TRSRTransformation> transform = state.apply(Optional.empty());
    
        TextureAtlasSprite sprite = bakedTextureGetter.apply(used.get(type));
        builder.addAll(ItemLayerModel.getQuadsForSprite(0, sprite, format, transform));
        
        return new CasingBakedModel(builder.build(), sprite);
    }
    
    @Override
    public Collection<ResourceLocation> getDependencies() {
        if (used == null) genUsedTextures();
        return used.values();
    }
    
    @Override
    public Collection<ResourceLocation> getTextures() {
        if (used == null) genUsedTextures();
        return used.values();
    }
    
    @Override
    public IModel retexture(ImmutableMap<String, String> textures) {
        return this;
    }
    
    public static void genUsedTextures() {
        for (GCMetaCasing.MetalCasingType casingType : GCMetaCasing.MetalCasingType.values()) {
            used = new HashMap<>();
            used.put(casingType, genCasingResourceLocation(casingType.getName()));
        }
    }
    
    public static ResourceLocation genCasingResourceLocation(String name) {
        return new ResourceLocation(Gregica.MOD_ID, "blocks/" + name);
    }
    

}
