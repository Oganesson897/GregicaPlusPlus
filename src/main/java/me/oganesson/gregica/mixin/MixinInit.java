package me.oganesson.gregica.mixin;

import com.google.common.collect.Lists;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.List;

@SuppressWarnings("unused")
public class MixinInit implements ILateMixinLoader {
    
    @Override
    public List<String> getMixinConfigs() {
        return Lists.newArrayList("mixins.gregica.json");
    }
}
