package gregica.loader.recipes.xkball;

import gregica.Gregica;
import gregica.api.event.SearchMaterialsClassEvent;
import gregica.api.unification.materials.GCMaterials;
import gregica.loader.recipes.xkball.laser.LaserRecipes;
import gregica.loader.recipes.xkball.worktablerecipe.XkballCraftingTableRecipe;
import gregica.modules.gcys.api.unification.materials.GCYSMaterials;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.ingredients.GTRecipeOreInput;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = Gregica.MOD_ID)
public class XkballRecipe {
    public static void init(){
        LaserRecipes.init();
        XkballCraftingTableRecipe.init();
        
        
        for(var field : allMaterials()){
            if(Modifier.isStatic(field.getModifiers())){
                try {
                    var obj = field.get(null);
                    if(obj instanceof Material material
                    ){
                          
                        var ingot = GTRecipeOreInput.getOrCreate(OrePrefix.ingot,material).getInputStacks();
                        var plate = GTRecipeOreInput.getOrCreate(OrePrefix.plate,material).getInputStacks();
                        var foil = GTRecipeOreInput.getOrCreate(OrePrefix.foil,material).getInputStacks();
                       
                        if(ingot.length>0 && plate.length>0 && foil.length>0){
                            RecipeMaps.BENDER_RECIPES.recipeBuilder()
                                    .EUt(24)
                                    .input(OrePrefix.ingot,material)
                                    .output(OrePrefix.foil,material,4)
                                    .duration(Math.max((int)(material.getMass()*2.1),1))
                                    .circuitMeta(8)
                                    .buildAndRegister();
                        }
                    }
                }   catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                }
            }
        }
    }
    
    public static Collection<Field> allMaterials(){
        var classList = new ArrayList<Class<?>>();
        var event = new SearchMaterialsClassEvent(classList);
        if(!MinecraftForge.EVENT_BUS.post(event)){
            return event.getClassList().stream().flatMap(
                    (clazz) -> Arrays.stream(clazz.getFields())).collect(Collectors.toList());
        }
        return Collections.emptySet();
    }
    
    @SubscribeEvent
    public static void onSearchMaterialsClass(SearchMaterialsClassEvent event){
        var list = event.getClassList();
        list.add(Materials.class);
        list.add(GCMaterials.class);
        list.add(GCYSMaterials.class);
    }
}
