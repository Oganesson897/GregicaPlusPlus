package gregica.api.mte.mega_tile;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MegaMultiblockControllerBuilder extends RecipeMapMultiblockController {
    private ICubeRenderer casingTexture;
    private MetaTileEntity machine;

    public MegaMultiblockControllerBuilder(MetaTileEntity machine) {
        super(new ResourceLocation("gregic", machine.metaTileEntityId.getPath()+".mega"), machine.getRecipeMap());
        this.machine = machine;
    }

    public void setPattern(BlockPattern pattern) {
        this.structurePattern = pattern;
    }

    public void setCasingTexture(ICubeRenderer texture) {
        casingTexture = texture;
    }

    @NotNull
    @Override
    protected BlockPattern createStructurePattern() {
        return structurePattern;
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return casingTexture;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MegaMultiblockControllerBuilder(machine);
    }
}