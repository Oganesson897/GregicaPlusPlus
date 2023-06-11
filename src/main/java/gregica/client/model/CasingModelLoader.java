package gregica.client.model;

import gregica.client.model.models.CasingModel;
import gregica.common.block.metablock.GCMetaCasing;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class CasingModelLoader implements ICustomModelLoader {
    
    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {
    
    }
    
    @Override
    public boolean accepts(ResourceLocation modelLocation) {
        if(!(modelLocation instanceof ModelResourceLocation)) return false;
        String s1 = modelLocation.getPath();
        String s2 = ((ModelResourceLocation) modelLocation).getVariant();
        return s1.contains("gc_machine_casing") && s2.contains("block_model");
                //&&s.contains("model");
    }
    
    @Override
    public IModel loadModel(ResourceLocation modelLocation) {
        int index = 0;
        if(modelLocation instanceof ModelResourceLocation){
            String s = ((ModelResourceLocation) modelLocation).getVariant();
            index = Integer.parseInt(s.substring(s.length()-1));
        }
        return new CasingModel(GCMetaCasing.MetalCasingType.values()[index],
                genModelBlock(GCMetaCasing.MetalCasingType.values()[index].getName()));
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
