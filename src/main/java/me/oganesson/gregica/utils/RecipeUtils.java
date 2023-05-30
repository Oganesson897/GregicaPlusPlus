package me.oganesson.gregica.utils;

import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import me.oganesson.gregica.api.GCValues;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.function.IntFunction;

public class RecipeUtils {
    public static final MetaItem<?> META_ITEM_1 = (MetaItem<?>) ForgeRegistries.ITEMS.getValue(new ResourceLocation(GCValues.CEu_MOD_ID,"meta_item_1"));
    
    public static final IntFunction<Material> intToMaterialsTier = (i) ->{
        switch (i){
            case (1):
                return MarkerMaterials.Tier.LV;
            case (2):
                return MarkerMaterials.Tier.MV;
            case (3):
                return MarkerMaterials.Tier.HV;
            case (4):
                return MarkerMaterials.Tier.EV;
            case (5):
                return MarkerMaterials.Tier.IV;
            case (6):
                return MarkerMaterials.Tier.LuV;
            case (7):
                return MarkerMaterials.Tier.ZPM;
            case (8):
                return MarkerMaterials.Tier.UV;
            case (9):
                return MarkerMaterials.Tier.UHV;
            case (10):
                return MarkerMaterials.Tier.UEV;
            case (11):
                return MarkerMaterials.Tier.UIV;
            case (12):
                return MarkerMaterials.Tier.UXV;
            case (13):
                return MarkerMaterials.Tier.OpV;
            case (14):
                return MarkerMaterials.Tier.MAX;
            default:
                return MarkerMaterials.Tier.ULV;
        }
    };
    
    public static MetaItem<?>.MetaValueItem getComponent(Component component,int tier){
        //noinspection ConstantConditions
        return META_ITEM_1.getItem(component.name+GTValues.VN[tier].toLowerCase());
    }
    
    public enum Component{
        CASING("casing"),
        EMITTER("emitter."),
        PUMP("electric.pump."),
        SENSOR("sensor.");
        final String name;
    
        Component(String name) {
            this.name = name;
        }
    }
}
