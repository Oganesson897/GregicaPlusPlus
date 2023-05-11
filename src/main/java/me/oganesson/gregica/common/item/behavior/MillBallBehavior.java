package me.oganesson.gregica.common.item.behavior;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.stats.IItemDurabilityManager;
import gregtech.api.items.metaitem.stats.IItemMaxStackSizeProvider;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.RotorProperty;
import gregtech.common.items.behaviors.AbstractMaterialPartBehavior;
import me.oganesson.gregica.common.item.metaitems.GCMetaItems;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MillBallBehavior extends AbstractMaterialPartBehavior implements IItemMaxStackSizeProvider {

    @Override
    public int getPartMaxDurability(ItemStack itemStack) {
        if(GCMetaItems.GRINDBALL_SOAPSTONE.isItemEqual(itemStack))
            return 50;
        else
            return 100;
    }

    public int getRotorDurabilityPercent(ItemStack itemStack) {
        return 100 - 100 * getPartDamage(itemStack) / getPartMaxDurability(itemStack);
    }

    public void applyBallDamage(ItemStack itemStack, int damageApplied) {
        int rotorDurability = getPartMaxDurability(itemStack);
        int resultDamage = getPartDamage(itemStack) + damageApplied;
        if (resultDamage >= rotorDurability) {
            itemStack.shrink(1);
        } else {
            setPartDamage(itemStack, resultDamage);
        }
    }

    public void addInformation(ItemStack stack, List<String> lines) {
        Material material;
        if(GCMetaItems.GRINDBALL_SOAPSTONE.isItemEqual(stack))
            material = Materials.Soapstone;
        else
            material = Materials.Aluminium;
        int maxDurability = getPartMaxDurability(stack);
        int damage = getPartDamage(stack);
        lines.add(I18n.format("metaitem.tool.tooltip.durability", maxDurability - damage, maxDurability));
        lines.add(I18n.format("metaitem.tool.tooltip.primary_material", material.getLocalizedName()));
    }

    @Override
    public int getMaxStackSize(ItemStack itemStack, int defaultValue) {
        return 1;
    }

    @Nullable
    public static MillBallBehavior getInstanceFor(@Nonnull ItemStack itemStack) {
        if (!(itemStack.getItem() instanceof MetaItem)) return null;

        MetaItem<?>.MetaValueItem valueItem = ((MetaItem<?>) itemStack.getItem()).getItem(itemStack);
        if (valueItem == null) return null;

        IItemDurabilityManager durabilityManager = valueItem.getDurabilityManager();
        if (!(durabilityManager instanceof MillBallBehavior)) return null;

        return (MillBallBehavior) durabilityManager;
    }
}