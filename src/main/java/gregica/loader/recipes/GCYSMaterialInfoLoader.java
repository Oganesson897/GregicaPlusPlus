package gregica.loader.recipes;

import gregica.modules.gcys.api.unification.materials.GCYSMaterials;
import gregica.modules.gcys.common.metablock.BlockTransparentCasing;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.metatileentities.MetaTileEntities;
import gregica.modules.gcys.common.metablock.GCYSMetaBlocks;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.material.Materials.Europium;
import static gregtech.api.unification.material.Materials.Rubber;

public class GCYSMaterialInfoLoader {

    public static void init() {
        OreDictUnifier.registerOre(GCYSMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.CasingType.PMMA), new ItemMaterialInfo(new MaterialStack(GCYSMaterials.PMMA, M * 4))); // single plate

        // fix UHV hull unification
        OreDictUnifier.registerOre(MetaTileEntities.HULL[9].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(GCYSMaterials.Orichalcum, M * 8), // plate
                new MaterialStack(Europium, M), // single cable
                new MaterialStack(Rubber, M * 2))); // plate
    }
}
