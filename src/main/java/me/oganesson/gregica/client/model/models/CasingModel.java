package me.oganesson.gregica.client.model.models;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import mcp.MethodsReturnNonnullByDefault;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.client.model.bakedmodels.CasingBakedModel;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.BakedItemModel;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ItemLayerModel;
import net.minecraftforge.client.model.PerspectiveMapWrapper;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;
import java.util.function.Function;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CasingModel implements IModel {
    
    private final GCMetaCasing.MetalCasingType type;
    
    public static Map<GCMetaCasing.MetalCasingType,ResourceLocation> used;
    
    public CasingModel(GCMetaCasing.MetalCasingType type) {
        this.type = type;
    }
    
    
    @Override
    public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();
        Optional<TRSRTransformation> transform = state.apply(Optional.empty());
      
        TextureAtlasSprite sprite = bakedTextureGetter.apply(used.get(type));
        builder.addAll(ItemLayerModel.getQuadsForSprite(0, sprite, format, transform));
        
        return new CasingBakedModel(builder.build(),sprite);
    }
    
    @Override
    public Collection<ResourceLocation> getDependencies() {
        if(used == null) genUsedTextures();
        return used.values();
    }
    
    @Override
    public Collection<ResourceLocation> getTextures() {
        if(used == null) genUsedTextures();
        return used.values();
    }
    
    @Override
    public IModel retexture(ImmutableMap<String, String> textures) {
        return this;
    }
    
    public static void genUsedTextures(){
        for(GCMetaCasing.MetalCasingType casingType : GCMetaCasing.MetalCasingType.values()){
            used = new HashMap<>();
            used.put(casingType,genCasingResourceLocation(casingType.getName()));
        }
    }
    
    public static ResourceLocation genCasingResourceLocation(String name){
        return new ResourceLocation(Gregica.MOD_ID,"blocks/"+name);
    }
}
