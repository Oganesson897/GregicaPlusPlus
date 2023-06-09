package project.gregica.loader.recipes;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.metatileentities.MetaTileEntities;
import project.gregica.module.gcys.common.metablocks.GCYSMetaBlocks;
import project.gregica.module.gcys.common.metablocks.BlockTransparentCasing;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.material.Materials.Europium;
import static gregtech.api.unification.material.Materials.Rubber;
import static project.gregica.module.gcys.api.unification.materials.material.GCYSMaterials.Orichalcum;
import static project.gregica.module.gcys.api.unification.materials.material.GCYSMaterials.PMMA;

public class GCYSMaterialInfoLoader {

    public static void init() {
        OreDictUnifier.registerOre(GCYSMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.CasingType.PMMA), new ItemMaterialInfo(new MaterialStack(PMMA, M * 4))); // single plate

        // fix UHV hull unification
        OreDictUnifier.registerOre(MetaTileEntities.HULL[9].getStackForm(), new ItemMaterialInfo(
                new MaterialStack(Orichalcum, M * 8), // plate
                new MaterialStack(Europium, M), // single cable
                new MaterialStack(Rubber, M * 2))); // plate
    }
}
