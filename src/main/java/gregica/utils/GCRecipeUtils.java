package gregica.utils;

import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.MetaBlocks;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import gregica.api.GCValues;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.function.IntFunction;

public class GCRecipeUtils {
    public static final MetaItem<?> META_ITEM_1 = (MetaItem<?>) ForgeRegistries.ITEMS.getValue(new ResourceLocation(GCValues.CEu_MOD_ID,"meta_item_1"));
    
    public static final Int2ObjectMap<Material> int2TierMaterialMap;
    
    public static final Object2IntMap<Material> tierMaterial2intMap;
    public static final IntFunction<Material> intToMaterialsTier;
    
    public static MetaItem<?>.MetaValueItem getComponent(Component component,int tier){
        //noinspection ConstantConditions
        return META_ITEM_1.getItem(component.name+GTValues.VN[tier].toLowerCase());
    }
    
    public static MetaItem<?>.MetaValueItem getComponent(Component component,Material tier){
        return getComponent(component,tierMaterial2intMap.get(tier));
    }
    
    static {
        int2TierMaterialMap = new Int2ObjectOpenHashMap<>();
        int2TierMaterialMap.put(0,MarkerMaterials.Tier.ULV);
        int2TierMaterialMap.put(1,MarkerMaterials.Tier.LV);
        int2TierMaterialMap.put(2,MarkerMaterials.Tier.MV);
        int2TierMaterialMap.put(3,MarkerMaterials.Tier.HV);
        int2TierMaterialMap.put(4,MarkerMaterials.Tier.EV);
        int2TierMaterialMap.put(5,MarkerMaterials.Tier.IV);
        int2TierMaterialMap.put(6,MarkerMaterials.Tier.LuV);
        int2TierMaterialMap.put(7,MarkerMaterials.Tier.ZPM);
        int2TierMaterialMap.put(8,MarkerMaterials.Tier.UV);
        int2TierMaterialMap.put(9,MarkerMaterials.Tier.UHV);
        int2TierMaterialMap.put(10,MarkerMaterials.Tier.UEV);
        int2TierMaterialMap.put(11,MarkerMaterials.Tier.UIV);
        int2TierMaterialMap.put(12,MarkerMaterials.Tier.UXV);
        int2TierMaterialMap.put(13,MarkerMaterials.Tier.OpV);
        int2TierMaterialMap.put(14,MarkerMaterials.Tier.MAX);
        
        tierMaterial2intMap = new Object2IntOpenHashMap<>();
        tierMaterial2intMap.put(MarkerMaterials.Tier.ULV,0);
        tierMaterial2intMap.put(MarkerMaterials.Tier.LV,1);
        tierMaterial2intMap.put(MarkerMaterials.Tier.MV,2);
        tierMaterial2intMap.put(MarkerMaterials.Tier.HV,3);
        tierMaterial2intMap.put(MarkerMaterials.Tier.EV,4);
        tierMaterial2intMap.put(MarkerMaterials.Tier.IV,5);
        tierMaterial2intMap.put(MarkerMaterials.Tier.LuV,6);
        tierMaterial2intMap.put(MarkerMaterials.Tier.ZPM,7);
        tierMaterial2intMap.put(MarkerMaterials.Tier.UV,8);
        tierMaterial2intMap.put(MarkerMaterials.Tier.UHV,9);
        tierMaterial2intMap.put(MarkerMaterials.Tier.UEV,10);
        tierMaterial2intMap.put(MarkerMaterials.Tier.UIV,11);
        tierMaterial2intMap.put(MarkerMaterials.Tier.UXV,12);
        tierMaterial2intMap.put(MarkerMaterials.Tier.OpV,13);
        tierMaterial2intMap.put(MarkerMaterials.Tier.MAX,14);
        
        intToMaterialsTier = (i) -> int2TierMaterialMap.getOrDefault(i,MarkerMaterials.Tier.ULV);
    }
    
    public enum Component{
        CASING("casing"){
            @Override
            public ItemStack getAsStack(Material tier) {
                return MetaBlocks.MACHINE_CASING.getItemVariant(BlockMachineCasing.MachineCasingType.values()[tierMaterial2intMap.get(tier)]);
            }
        },
        EMITTER("emitter."),
        PUMP("electric.pump."),
        FIELD_GENERATOR("field.generator."),
        SENSOR("sensor.");
        final String name;
    
        Component(String name) {
            this.name = name;
        }
        
        public ItemStack getAsStack(Material tier){
            return GCRecipeUtils.getComponent(this,tier).getStackForm();
        }
    }
}
