package me.oganesson.gregica.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public class SingleSolarPanel extends VariantBlock<SingleSolarPanel.SolarPanelType> {
    public SingleSolarPanel() {
        super(Material.IRON);
        this.setTranslationKey("solar_panel");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setDefaultState(this.getState(SolarPanelType.LV));
    }

    public static enum SolarPanelType implements IStringSerializable {
        LV("lv", 1),
        MV("mv", 2),
        HV("hv", 3),
        EV("ev", 4),
        IV("iv", 5),
        LuV("luv", 6),
        ZPM("zpm", 7),
        UV("uv", 8),
        UHV("uhv", 9),
        UEV("uev", 10),
        UIV("uiv", 11),
        UXV("uxv", 12),
        OpV("opv", 13);
        private String name;
        private int tier;

        private SolarPanelType(String name, int tier) {
            this.name = name + "_solar_panel";
            this.tier = tier;
        }

        @Override
        public String getName() {
            return name;
        }

        public int getTier() {
            return tier;
        }
    }
}
