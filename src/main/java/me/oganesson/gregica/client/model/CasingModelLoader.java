package me.oganesson.gregica.client.model;

import mcp.MethodsReturnNonnullByDefault;
import me.oganesson.gregica.client.model.models.CasingModel;
import me.oganesson.gregica.common.block.metablock.GCMetaCasing;
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
        String s = modelLocation.getPath();
        return s.contains("gc_machine_casing");
                //&&s.contains("model");
    }
    
    @Override
    public IModel loadModel(ResourceLocation modelLocation) {
        String s = modelLocation.getPath();
        return new CasingModel(GCMetaCasing.MetalCasingType.values()[Integer.parseInt(s.substring(s.length()-1))]);
    }
}
