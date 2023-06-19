package gregica.loader.recipes.xkball.worktablerecipe;

import gregica.utils.GCRecipeUtils;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregica.common.tileentities.mte.GCMetaEntities;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class XkballCraftingTableRecipe {
    
    public static void init(){
        ModHandler.addShapedRecipe("infinite_water_hatch", GCMetaEntities.INF_WATER_HATCH.getStackForm(),
                "KEK", "UWU","RTR",
                'E', GCRecipeUtils.getComponent(GCRecipeUtils.Component.PUMP, MarkerMaterials.Tier.LuV).getStackForm(),
                'T', GCRecipeUtils.Component.CASING.getAsStack(MarkerMaterials.Tier.LuV),
                'R',new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.LuV),
                'K',new UnificationEntry(OrePrefix.plate, Materials.Osmium),
                'W',GCRecipeUtils.Component.FIELD_GENERATOR.getAsStack(MarkerMaterials.Tier.LuV),
                'U',new ItemStack(Items.WATER_BUCKET));
    }
}
