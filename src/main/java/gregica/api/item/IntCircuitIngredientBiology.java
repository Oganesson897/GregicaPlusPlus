package gregica.api.item;

import gregtech.api.items.gui.PlayerInventoryHolder;
import gregtech.api.recipes.ingredients.GTRecipeItemInput;
import gregica.common.item.metaitems.GCMetaItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nullable;

public class  IntCircuitIngredientBiology extends GTRecipeItemInput {
    public static final int CIRCUIT_MIN = 0;
    public static final int CIRCUIT_MAX = 32;
    private final int matchingConfigurations;

    @Override
    protected IntCircuitIngredientBiology copy() {
        IntCircuitIngredientBiology copy = new IntCircuitIngredientBiology(this.matchingConfigurations);
        copy.isConsumable = this.isConsumable;
        copy.nbtMatcher = this.nbtMatcher;
        copy.nbtCondition = this.nbtCondition;
        return copy;
    }

    public IntCircuitIngredientBiology(int matchingConfigurations) {
        super(getIntegratedCircuit(matchingConfigurations));
        this.matchingConfigurations = matchingConfigurations;
    }

    public static ItemStack getIntegratedCircuit(int configuration) {
        ItemStack stack = GCMetaItems.BIOLOGY_INTEGRATED_CIRCUIT.getStackForm();
        setCircuitConfiguration(stack, configuration);
        return stack;
    }

    public static void setCircuitConfiguration(ItemStack itemStack, int configuration) {
        if (!GCMetaItems.BIOLOGY_INTEGRATED_CIRCUIT.isItemEqual(itemStack))
            throw new IllegalArgumentException("Given item stack is not an integrated circuit!");
        if (configuration < 0 || configuration > CIRCUIT_MAX)
            throw new IllegalArgumentException("Given configuration number is out of range!");
        NBTTagCompound tagCompound = itemStack.getTagCompound();
        if (tagCompound == null) {
            tagCompound = new NBTTagCompound();
            itemStack.setTagCompound(tagCompound);
        }
        tagCompound.setInteger("Configuration", configuration);
    }

    public static int getCircuitConfiguration(ItemStack itemStack) {
        if (!isIntegratedCircuit(itemStack)) return 0;
        NBTTagCompound tagCompound = itemStack.getTagCompound();
        if (tagCompound != null) {
            return tagCompound.getInteger("Configuration");
        }
        return 0;
    }

    public static boolean isIntegratedCircuit(ItemStack itemStack) {
        boolean isCircuit = GCMetaItems.BIOLOGY_INTEGRATED_CIRCUIT.isItemEqual(itemStack);
        if (isCircuit && !itemStack.hasTagCompound()) {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setInteger("Configuration", 0);
            itemStack.setTagCompound(compound);
        }
        return isCircuit;
    }

    public static void adjustConfiguration(PlayerInventoryHolder holder, int amount) {
        adjustConfiguration(holder.getCurrentItem(), amount);
        holder.markAsDirty();
    }

    public static void adjustConfiguration(ItemStack stack, int amount) {
        if (!IntCircuitIngredientBiology.isIntegratedCircuit(stack)) return;
        int configuration = IntCircuitIngredientBiology.getCircuitConfiguration(stack);
        configuration += amount;
        configuration = MathHelper.clamp(configuration, 0, IntCircuitIngredientBiology.CIRCUIT_MAX);
        IntCircuitIngredientBiology.setCircuitConfiguration(stack, configuration);
    }

    @Override
    public boolean acceptsStack(@Nullable ItemStack itemStack) {
        return itemStack != null && GCMetaItems.BIOLOGY_INTEGRATED_CIRCUIT.isItemEqual(itemStack) &&
                matchingConfigurations == getCircuitConfiguration(itemStack);
    }
}
