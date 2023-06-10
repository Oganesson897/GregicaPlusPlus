package gregica.common.item;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class itemUpgrades extends Item {

    public itemUpgrades() {
        super();
        setRegistryName("upgrade");
        setHasSubtypes(true);
        setMaxStackSize(1);
    }

    public static final String[] ListUpgrade = new String[] {
            "null",
            "air",
            "thermal",
            "unstable",
            "victus",
            "tainted",
            "mechanics",
            "spirit",
            "radiation",
            "electric"
    };


    @Override
    public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> items) {
        if (!isInCreativeTab(tab)) {
            return;
        }
        for (int i = 0; i < ListUpgrade.length; i++) {
            items.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    @Nonnull
    public String getTranslationKey(@Nonnull ItemStack stack) {
        return "item.upgradeEssentia." + stack.getItemDamage();
    }

}