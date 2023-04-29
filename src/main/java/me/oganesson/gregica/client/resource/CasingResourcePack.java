package me.oganesson.gregica.client.resource;

import codechicken.lib.texture.TextureUtils;
import com.google.common.collect.Sets;
import mcp.MethodsReturnNonnullByDefault;
import me.oganesson.gregica.Gregica;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class CasingResourcePack implements IResourcePack {
    @Override
    public InputStream getInputStream(ResourceLocation location) throws IOException {
        return new ByteArrayInputStream(getJson().getBytes());
    }
    
    @Override
    public boolean resourceExists(ResourceLocation location) {
        return "blockstates/gc_machine_casing".equals(location.getPath());
    }
    
    @Override
    public Set<String> getResourceDomains() {
        return Sets.newHashSet(Gregica.MOD_ID);
    }
    
    @Nullable
    @Override
    public <T extends IMetadataSection> T getPackMetadata(MetadataSerializer metadataSerializer, String metadataSectionName) throws IOException {
        return null;
    }
    
    @Override
    public BufferedImage getPackImage() throws IOException {
        return TextureUtils.loadBufferedImage(new ResourceLocation(Gregica.MOD_ID,"blocks/high_power_casing"));
    }
    
    @Override
    public String getPackName() {
        return "casing_resource_pack";
    }
    
    private static String getJson() {
       String head = "{\n" +
                "  \"forge_marker\": 1,\n" +
                "  \"defaults\": {\n" +
                "    \"model\": \"minecraft:cube_all\"\n" +
                "  },\n" +
                "  \"variants\": {\n" +
                "    \"variant\": {";
       StringBuilder builder = new StringBuilder();
       for(GCMetaCasing.MetalCasingType type : GCMetaCasing.MetalCasingType.values()){
           builder.append(genModelBlock(type.getName()));
           builder.append(",");
       }
       builder.deleteCharAt(builder.lastIndexOf(","));
       String tail = " }\n" +
               "  }\n" +
               "}";
       return (head+builder+tail).replace("/n","");
    }
    
    public static String genModelJson(String name){
        return name+": { \"textures\": { \"all\": \"gregica:blocks/"+name+"}}";
    }
    
    public static ModelBlock genModelBlock(String name){
        ModelBlock result = ModelBlock.deserialize(genModelJson(name));
        result.name = name;
        return result;
    }
}
