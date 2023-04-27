package me.oganesson.gregica.common.recipes.machines;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ModHandler;

import static gregtech.common.metatileentities.MetaTileEntities.*;

public class RewriteMachineHardRecipe {
    public static void init() {
        changed(ELECTRIC_FURNACE, );
    }

    private static void changed(MetaTileEntity machine, Object... recipe) {
        ModHandler.removeRecipeByOutput(machine.getStackForm());

        ModHandler.addShapedRecipe(machine.metaTileEntityId.getPath(), machine.getStackForm(), recipe);
    }
}
