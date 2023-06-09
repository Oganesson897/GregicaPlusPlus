package project.gregica.common.item.behavior;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.UUID;

public class BaguetteBehavior implements IItemBehaviour {

    public static final String NBTTAG_DURABILITY = "Freshness";
    private static final int MaxDurability = 96000;

    protected static final UUID ATTACK_DAMAGE_MODIFIER = UUID.fromString("CB3F55D3-645C-4F38-A288-9C13A33DB5CF");
    protected static final UUID ATTACK_SPEED_MODIFIER = UUID.fromString("FA233E1C-4180-4288-B01B-BCCE9785ACA3");

    public BaguetteBehavior() {
    }

    public static int getNBTDurability(ItemStack pItemStack) {
        if(pItemStack.getTagCompound() == null)
        {
            pItemStack.setTagCompound(new NBTTagCompound());
            pItemStack.getTagCompound().setInteger(NBTTAG_DURABILITY, MaxDurability);
            return pItemStack.getTagCompound().getInteger(NBTTAG_DURABILITY);
        }
        return pItemStack.getTagCompound().getInteger(NBTTAG_DURABILITY);
    }

    @Override
    public void onUpdate(ItemStack stack, Entity entity) {
        createOrInitNBTTag(stack);
        int tCurrentDura = getNBTDurability(stack);
        if(stack.getTagCompound() != null) {
            if (tCurrentDura > 0)
                stack.getTagCompound().setInteger(NBTTAG_DURABILITY, --tCurrentDura);
            else
                stack.shrink(1);
        }
    }

    private void createOrInitNBTTag(ItemStack pItemStack) {
        if (pItemStack.getTagCompound() == null) {
            pItemStack.setTagCompound(new NBTTagCompound());
            pItemStack.getTagCompound().setInteger(NBTTAG_DURABILITY, MaxDurability);
        }
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        HashMultimap<String, AttributeModifier> modifiers = HashMultimap.create();
        if (slot == EntityEquipmentSlot.MAINHAND && stack.getTagCompound() != null) {
            modifiers.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", 1.6, 0));
            modifiers.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon Modifier", 6 + 6 * stack.getTagCompound().getInteger(NBTTAG_DURABILITY)/MaxDurability, 0));
        }
        return modifiers;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, List<String> lines) {
        if (itemStack.getTagCompound() != null) {
            if (itemStack.getTagCompound().getInteger(NBTTAG_DURABILITY) > 0)
                lines.add("This bread looks like it should be edible...probably");
            else
                lines.add("This 'bread' looks completely useless");
            if (itemStack.getTagCompound().getInteger(NBTTAG_DURABILITY) >= 48000) {
                lines.add(TextFormatting.BOLD + TextFormatting.GREEN.toString() + I18n.format("Fresh"));
            } else if (itemStack.getTagCompound().getInteger(NBTTAG_DURABILITY) >= 19200 && itemStack.getTagCompound().getInteger(NBTTAG_DURABILITY) < 48000) {
                lines.add(TextFormatting.BOLD + TextFormatting.GOLD.toString() + I18n.format("Stale"));
            } else if (itemStack.getTagCompound().getInteger(NBTTAG_DURABILITY) < 19200 && itemStack.getTagCompound().getInteger(NBTTAG_DURABILITY) > 0) {
                lines.add(TextFormatting.BOLD + TextFormatting.RED.toString() + I18n.format("Spoiled"));
            } else
                lines.add(TextFormatting.BOLD + TextFormatting.DARK_RED.toString() + I18n.format("Rot"));
        }
    }
}
