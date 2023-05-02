package me.oganesson.gregica.mixin;

import gregtech.common.blocks.BlockGlassCasing;
import me.oganesson.gregica.api.blocks.ITiredGlass;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nonnull;

@Mixin(BlockGlassCasing.CasingType.class)
public abstract class MixinGTGlassCasingType implements ITiredGlass {
    
    
    @Shadow(remap = false) @Nonnull public abstract String getName();
    
    @Override
    public int getTier() {
        switch (getName()){
            case("tempered_glass"):
                return 4;
            case("fusion_glass"):
                return 10;
            case("laminated_glass"):
                return 5;
        }
        return 3;
    }
}