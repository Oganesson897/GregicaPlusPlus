package me.oganesson.gregica.mixin.gregtech;

import gregtech.common.blocks.BlockGlassCasing;
import me.oganesson.gregica.api.blocks.ITiredGlass;
import net.minecraft.util.IStringSerializable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockGlassCasing.CasingType.class)
public abstract class MixinGTGlassCasingType implements IStringSerializable,  ITiredGlass {
   
   // @Shadow @Nonnull public abstract String func_176610_l();
    
    @Override
    public int getGlassTier() {
        switch (getName()){
            case("tempered_glass"):
                return 3;
            case("fusion_glass"):
                return 9;
            case("laminated_glass"):
                return 4;
        }
        return 3;
    }
}