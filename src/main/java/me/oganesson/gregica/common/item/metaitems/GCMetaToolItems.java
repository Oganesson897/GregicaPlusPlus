package me.oganesson.gregica.common.item.metaitems;

import gregtech.api.items.toolitem.IGTTool;
import gregtech.api.items.toolitem.ItemGTTool;
import gregtech.api.items.toolitem.ToolOreDict;
import gregtech.common.items.tool.BlockRotatingBehavior;
import gregtech.common.items.tool.EntityDamageBehavior;
import me.oganesson.gregica.Gregica;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.init.SoundEvents;

import static gregtech.common.items.ToolItems.register;

public class GCMetaToolItems {
    public static IGTTool Choocher;
    public static void init() {
        Choocher = register(ItemGTTool.Builder.of(Gregica.MOD_ID, "choocher")
                        .toolStats(b -> b.blockBreaking()
                        .crafting()
                        .damagePerCraftingAction(2)
                        .attackDamage(1.0F)
                        .attackSpeed(-2.8F)
                        .behaviors(new EntityDamageBehavior(2.0F, EntityGolem.class), BlockRotatingBehavior.INSTANCE))
                        .oreDict(ToolOreDict.toolHammer)
                        .secondaryOreDicts(ToolOreDict.toolWrench)
                        .sound(SoundEvents.BLOCK_ANVIL_LAND)
                        .symbol('t')
                        .toolClasses("hammer", "wrench"));
      
    }
}
