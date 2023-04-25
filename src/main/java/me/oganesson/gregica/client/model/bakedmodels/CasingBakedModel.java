package me.oganesson.gregica.client.model.bakedmodels;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CasingBakedModel implements IBakedModel {
    
    private final ImmutableList<BakedQuad> temp;
    private final TextureAtlasSprite particle;
    
    public CasingBakedModel(ImmutableList<BakedQuad> temp, TextureAtlasSprite particle) {
        this.temp = temp;
        this.particle = particle;
    }
    
    @Override
    @NotNull
    public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand) {
        return temp;
    }
    
    @Override
    public boolean isAmbientOcclusion() {
        return false;
    }
    
    @Override
    public boolean isGui3d() {
        return false;
    }
    
    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }
    
    @Override
    @NotNull
    public TextureAtlasSprite getParticleTexture() {
        return particle;
    }
    
    @Override
    @NotNull
    public ItemOverrideList getOverrides() {
        return ItemOverrideList.NONE;
    }
}
