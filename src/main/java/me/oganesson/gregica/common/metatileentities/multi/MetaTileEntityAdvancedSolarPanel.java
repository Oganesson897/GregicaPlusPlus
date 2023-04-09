package me.oganesson.gregica.common.metatileentities.multi;

import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nonnull;
import java.util.List;

public class MetaTileEntityAdvancedSolarPanel extends RecipeMapMultiblockController implements ITieredMetaTileEntity {
    private final int tier;

    public final IBlockState panelType;

    public MetaTileEntityAdvancedSolarPanel(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, int tier, IBlockState panelType) {
        super(metaTileEntityId, recipeMap);
        this.tier = tier;
        this.panelType = panelType;
    }

    @Override
    protected void updateFormedValid() {

    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        textList.add(new TextComponentTranslation("gregica.multiblock.solar_panel.tier", tier));
        super.addDisplayText(textList);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("AAAAAAAAAAAAA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("ASSSSSSSSSSSA")
                .aisle("AAAAAACAAAAAA")
                .where('C', this.selfPredicate())
                .where('A', )
        .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return null;
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityAdvancedSolarPanel(this.metaTileEntityId, this.recipeMap, this.tier, this.panelType);
    }

    @Override
    public int getTier() {
        return tier;
    }
}
