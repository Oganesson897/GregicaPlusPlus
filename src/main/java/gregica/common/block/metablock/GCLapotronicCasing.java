package gregica.common.block.metablock;

import gregtech.api.block.VariantBlock;
import mcp.MethodsReturnNonnullByDefault;
import gregica.common.block.GCMetaBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GCLapotronicCasing extends VariantBlock<GCLapotronicCasing.LapotronicCasingType> {
    
    public GCLapotronicCasing() {
        super(Material.IRON);
        setTranslationKey("gc_lapotronic_casing");
        setHardness(2.0f);
        setResistance(5.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 4);
        setDefaultState(getState(LapotronicCasingType.LapotronicSuperCapacitorCasing));
        setRegistryName("gc_lapotronic_casing");
    }
    
    public static long getCapacity(IBlockState state){
        return getType(state).getCapacity();
    }
    
    public static int getPassiveLoss(IBlockState state){
        return getType(state).getPassiveLoss();
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@NotNull ItemStack stack, @Nullable World player, List<String> tooltip, @NotNull ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        LapotronicCasingType type = getState(stack);
        tooltip.add(I18n.format("gregica.casing.lapotronic.part"));
        if(type.getCapacity()>0){
            tooltip.add(I18n.format("gregica.casing.lapotronic.capacity",type.getCapacity()));
        }
        if(type.getPassiveLoss()>0){
            tooltip.add(I18n.format("gregica.casing.lapotronic.passive_loss",type.getPassiveLoss()));
        }
    }
    
    public static LapotronicCasingType getType(IBlockState state){
        if(isLapotronicCasing(state)){
            return GCMetaBlocks.GC_LAPOTRONIC_CASING.getState(state);
        }
        return LapotronicCasingType.LapotronicSuperCapacitorCasing;
    }
    
    public static boolean isLapotronicCasing(IBlockState state){
        return state.getBlock() == GCMetaBlocks.GC_LAPOTRONIC_CASING;
    }
    
    public static boolean isCapacitor(IBlockState states){
        return getType(states) != LapotronicCasingType.LapotronicSuperCapacitorCasing;
    }
    
    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }
    
    public enum LapotronicCasingType implements IStringSerializable {
        LapotronicSuperCapacitorCasing("lapotronic_super_capacitor_casing", 0, 0L),
        LapotronicCapacitorEmpty("lapotronic_capacitor_empty",0,0),
        LapotronicCapacitorEV("lapotronic_capacitor_ev", 1, 100000000L),
        LapotronicCapacitorIV("lapotronic_capacitor_iv", 16, 1000000000L),
        LapotronicCapacitorLUV("lapotronic_capacitor_luv", 256, 10000000000L),
        LapotronicCapacitorZPM("lapotronic_capacitor_zpm", 4096, 100000000000L),
        LapotronicCapacitorUV("lapotronic_capacitor_uv", 65536, 1000000000000L),
        LapotronicCapacitorUHV("lapotronic_capacitor_uhv", 1048576, Long.MAX_VALUE/2),
        LapotronicCapacitorUEV("lapotronic_capacitor_uev", 16777216, Long.MAX_VALUE);
        
        private final String name;
        private final int passiveLoss;
        private final long capacity;
    
        LapotronicCasingType(String name, int passiveLoss, long capacity) {
            this.name = name;
            this.passiveLoss = passiveLoss;
            this.capacity = capacity;
        }
    
        @Override
        public String getName() {
            return name;
        }
    
        public int getPassiveLoss() {
            return passiveLoss;
        }
    
        public long getCapacity() {
            return capacity;
        }
    }
}
