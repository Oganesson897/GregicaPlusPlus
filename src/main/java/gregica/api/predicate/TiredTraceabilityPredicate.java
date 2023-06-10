package gregica.api.predicate;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.pattern.BlockWorldState;
import gregtech.api.pattern.PatternStringError;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.util.BlockInfo;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMachineCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import gregica.api.blocks.ITired;
import gregica.api.blocks.ITiredGlass;
import gregica.api.blocks.impl.WrappedIntTired;
import gregica.common.block.GCMetaBlocks;
import gregica.common.block.metablock.GCMetaCells;
import gregica.common.block.metablock.GCMetaGlasses;
import gregica.common.block.metablock.GCMetaGlasses1;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TiredTraceabilityPredicate extends TraceabilityPredicate {
    
    static {
        MAP_ESSENTIA_CELLS = new Object2ObjectOpenHashMap<>();
        MAP_MACHINE_CASING = new Object2ObjectOpenHashMap<>();
        MAP_GLASS = new Object2ObjectOpenHashMap<>();
        MAP_CP_CASING = new Object2ObjectOpenHashMap<>();
        MAP_CP_TUBE = new Object2ObjectOpenHashMap<>();
        
        for (BlockMachineCasing.MachineCasingType type : Arrays.stream(BlockMachineCasing.MachineCasingType.values()).filter((c)-> c.ordinal()<10).collect(Collectors.toList())) {
            TiredTraceabilityPredicate.MAP_MACHINE_CASING.put(MetaBlocks.MACHINE_CASING.getState(type),new WrappedIntTired(type,type.ordinal()));
        }
        for(GCMetaCells.MetalCellType type : GCMetaCells.MetalCellType.values()){
            TiredTraceabilityPredicate.MAP_ESSENTIA_CELLS.put(GCMetaBlocks.GC_ESSENTIA_CELLS.getState(type),type);
        }
        for(GCMetaGlasses.CasingType type : GCMetaGlasses.CasingType.values()){
            TiredTraceabilityPredicate.MAP_GLASS.put(GCMetaBlocks.TRANSPARENT_CASING.getState(type),type);
        }
        for(GCMetaGlasses1.CasingType type : GCMetaGlasses1.CasingType.values()){
            TiredTraceabilityPredicate.MAP_GLASS.put(GCMetaBlocks.TRANSPARENT_CASING1.getState(type),type);
        }
        
        TiredTraceabilityPredicate.MAP_GLASS.put(Blocks.GLASS.getDefaultState(), (ITired) Blocks.GLASS);
        for(int i = 0; i< EnumDyeColor.values().length; i++){
            IBlockState defaultState = Blocks.STAINED_GLASS.getDefaultState();
            TiredTraceabilityPredicate.MAP_GLASS.put(defaultState.cycleProperty(BlockStainedGlass.COLOR), (ITired) Blocks.STAINED_GLASS);
        }
       
        
        TiredTraceabilityPredicate.MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.BRONZE_BRICKS,1));
        TiredTraceabilityPredicate.MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.STEEL_SOLID,2));
        TiredTraceabilityPredicate.MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF,3));
        TiredTraceabilityPredicate.MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN,4));
        TiredTraceabilityPredicate.MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.TITANIUM_STABLE,5));
        TiredTraceabilityPredicate.MAP_CP_CASING.put(MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST),
                new WrappedIntTired(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST,6));
        
        TiredTraceabilityPredicate.MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE,1));
        TiredTraceabilityPredicate.MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE,2));
        TiredTraceabilityPredicate.MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TITANIUM_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE,5));
        TiredTraceabilityPredicate.MAP_CP_TUBE.put(MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE),
                new WrappedIntTired(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE,6));
     
    }
    
    public static final Object2ObjectOpenHashMap<IBlockState,ITired> MAP_ESSENTIA_CELLS;
    public static final Object2ObjectOpenHashMap<IBlockState,ITired> MAP_MACHINE_CASING;
    public static final Object2ObjectOpenHashMap<IBlockState,ITired> MAP_GLASS;
    public static final Object2ObjectOpenHashMap<IBlockState,ITired> MAP_CP_CASING;
    public static final Object2ObjectOpenHashMap<IBlockState,ITired> MAP_CP_TUBE;
    
    
    public static TraceabilityPredicate MACHINE_CASINGS = new TiredTraceabilityPredicate(MAP_MACHINE_CASING,"MachineCasingType",null);
    
    public static TraceabilityPredicate ESSENTIA_CELLS = new TiredTraceabilityPredicate(MAP_ESSENTIA_CELLS,"ESS_CELL","gc.multiblock.pattern.error.essentia")
            .addTooltips("gc.multiblock.pattern.error.essentia");
    
    public static TraceabilityPredicate CP_CASING = new TiredTraceabilityPredicate(MAP_CP_CASING,
            Comparator.comparing((s) -> ((WrappedIntTired)MAP_CP_CASING.get(s)).getIntTier()),"ChemicalPlantCasing",null);
    public static TraceabilityPredicate CP_TUBE = new TiredTraceabilityPredicate(MAP_CP_TUBE,
            Comparator.comparing((s) -> ((WrappedIntTired)MAP_CP_TUBE.get(s)).getIntTier()),"ChemicalPlantTube",null);
    
    public static TraceabilityPredicate GLASS = new TiredTraceabilityPredicate(MAP_GLASS,
            Comparator.comparing((s) -> ((ITiredGlass)MAP_GLASS.get(s)).getGlassTier()),"Glass",null);
    
    private final Object2ObjectOpenHashMap<IBlockState, ITired> map;
    private final String name;
    
    private final String errorKey;
    
    private Supplier<BlockInfo[]> candidatesCache;
    
    private final Comparator<IBlockState> comparator;
    
    
    public TiredTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, ITired> map,String name,@Nullable String errorKey){
        this(map,Comparator.comparing((s) -> map.get(s).getName()),name,errorKey);
    }

    public TiredTraceabilityPredicate(Object2ObjectOpenHashMap<IBlockState, ITired> map,Comparator<IBlockState> comparator,String name,@Nullable String errorKey){
        super();
        this.map = map;
        this.name = name;
        if(errorKey == null){
            this.errorKey = "gregtech.multiblock.pattern.error.casing";
        }
        else{
            this.errorKey = errorKey;
        }
        this.common.add(new SimplePredicate(predicate(), candidates()));
        this.comparator = comparator;
      
    }
    
    private Predicate<BlockWorldState> predicate(){
       return  (blockWorldState) -> {
           IBlockState blockState = blockWorldState.getBlockState();
           if (map.containsKey(blockState)) {
               ITired stats = map.get(blockState);
               Object tier = stats.getTire();
               Object current = blockWorldState.getMatchContext().getOrPut(name, tier);
               if (!current.equals(tier)) {
                   blockWorldState.setError(new PatternStringError(errorKey));
                   return false;
               } else {
                   blockWorldState.getMatchContext().getOrPut(name+"TiredStats",stats);
                   if(blockState.getBlock() instanceof VariantActiveBlock){
                       (blockWorldState.getMatchContext().getOrPut("VABlock", new LinkedList<>())).add(blockWorldState.getPos());
                   }
                   return true;
               }
           } else {
               return false;
           }
        };
    }
    
    private Supplier<BlockInfo[]> candidates(){
        if(candidatesCache == null) {
            candidatesCache = () -> map.keySet().stream()
                    .sorted(comparator)
                    .map(type -> new BlockInfo(type, null,map.get(type).getInfo()))
                    .toArray(BlockInfo[]::new);
        }
        return candidatesCache;
    }
}
