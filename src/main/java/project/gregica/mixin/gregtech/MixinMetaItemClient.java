package project.gregica.mixin.gregtech;

import gregtech.api.items.metaitem.MetaItem;
import project.gregica.config.GCConfigValue;
import project.gregica.utils.GCLangUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static project.gregica.utils.GCLangUtil.EN_US;
import static project.gregica.utils.GCLangUtil.tryFindingKey;

//borrow some code from https://github.com/friendlyhj/BilingualName
@Mixin(MetaItem.class)
public abstract class MixinMetaItemClient<T extends MetaItem<?>.MetaValueItem> extends Item {
    
    @Shadow(remap = false) @Nullable public abstract T getItem(ItemStack itemStack);
    
    @Inject(method = "addInformation",at = @At(value = "RETURN",remap = false))
    public void onAddInfo(ItemStack itemStack, @Nullable World worldIn, @Nonnull List<String> lines, @Nonnull ITooltipFlag tooltipFlag, CallbackInfo ci){
        if (!GCConfigValue.enableMetaItemShows_en_us_nameOnOtherLanguage
                || Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getJavaLocale().equals(java.util.Locale.US)){
            return;
        }
        T metaValueItem = this.getItem(itemStack);
        if(metaValueItem != null){
            @SuppressWarnings("SpellCheckingInspection")
            String key = tryFindingKey(EN_US,"metaitem."+metaValueItem.unlocalizedName);
            if (key.isEmpty()) return;
            String localizedName = TextFormatting.GREEN + EN_US.formatMessage(key, GCLangUtil.NONE_ARRAY);
            lines.add(localizedName);
        }
    }
}
