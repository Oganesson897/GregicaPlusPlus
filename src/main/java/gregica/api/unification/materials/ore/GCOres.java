package gregica.api.unification.materials.ore;

import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.StoneType;
import gregtech.common.blocks.BlockOre;
import gregica.common.block.GCMetaBlocks;

public class GCOres {

    public static void registerSpecialOres() {
        for (Material material : GregTechAPI.MATERIAL_REGISTRY) {
            if (material.hasProperty(PropertyKey.ORE)) {
                createOreBlock(material, GCStoneTypes.LIST.toArray(new StoneType[0]), 0);
            }
        }
    }

    private static void createOreBlock(Material material, StoneType[] stoneTypes, int index) {
        BlockOre block = new BlockOre(material, stoneTypes);
        block.setRegistryName("ore_" + material + "_" + index);
        StoneType[] var4 = stoneTypes;
        int var5 = stoneTypes.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            StoneType stoneType = var4[var6];
            /*
            GregTechAPI.oreBlockTable.computeIfAbsent(material, (m) -> {
                return new HashMap();
            }).put(stoneType, block);
             */
        }

        GCMetaBlocks.ORES.add(block);
    }

}
