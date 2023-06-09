package project.gregica.utils;

import com.google.common.collect.Lists;
import gregtech.api.GTValues;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.Locale;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

//borrow some code from https://github.com/friendlyhj/BilingualName
public class GCLangUtil {
    public static final Locale EN_US = new Locale();
    public static final Object[] NONE_ARRAY = new Object[0];
    
    public static final String[] modifiers = new String[]{
            "§0","§1","§2","§3",
            "§4","§5","§6","§7",
            "§8","§9","§a","§b",
            "§c","§d","§e","§f"
    };
    
    public static int currentIndex = 0;
    
    static {
        EN_US.loadLocaleDataFiles(Minecraft.getMinecraft().getResourceManager(), Lists.newArrayList("en_us"));
    }
    
    public static String tryFindingKey(Locale locale, ItemStack stack) {
        String key = stack.getTranslationKey();
        if (locale.hasKey(key)) return key;
        key += ".name";
        if (locale.hasKey(key)) return key;
        key = stack.getItem().getUnlocalizedNameInefficiently(stack);
        if (locale.hasKey(key)) return key;
        key += ".name";
        if (locale.hasKey(key)) return key;
        return "";
    }
    
    public static String tryFindingKey(Locale locale, String key) {
        if (locale.hasKey(key)) return key;
        key += ".name";
        if (locale.hasKey(key)) return key;
        return "";
    }
    
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        if (Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getJavaLocale().equals(java.util.Locale.US)) return;
        ItemStack stack = event.getItemStack();
        List<String> tooltip = event.getToolTip();
        String key = GCLangUtil.tryFindingKey(EN_US, stack);
        if (key.isEmpty()) return;
        String localizedName = TextFormatting.GREEN + EN_US.formatMessage(key, NONE_ARRAY);
        tooltip.add(localizedName);
    }
    
    public static String getEnglishLang(String key){
        return EN_US.formatMessage(key,NONE_ARRAY);
    }
    
    public static String currentRainbowModifier(){
        return modifiers[currentIndex];
    }
    
    public static void updateModifier(){
        currentIndex = (int) (GTValues.CLIENT_TIME%16);
    }
}
