package me.oganesson.gregica.mixininit;

import me.oganesson.gregica.Gregica;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.Side;
import org.jetbrains.annotations.Nullable;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@IFMLLoadingPlugin.Name(Gregica.MOD_ID)
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
public class EarlyMixinInit implements IFMLLoadingPlugin,IEarlyMixinLoader{
    public static final boolean isClient = FMLLaunchHandler.side() == Side.CLIENT;
    @Override
    public List<String> getMixinConfigs() {
            return Collections.singletonList("mixins.gregica_early.json");
    }
    
    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }
    
    @Override
    public String getModContainerClass() {
        return null;
    }
    
    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }
    
    @Override
    public void injectData(Map<String, Object> data) {
    
    }
    
    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
