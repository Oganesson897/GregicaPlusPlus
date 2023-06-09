package project.gregica.module.gcys.api.unification.materials.material;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.PropertyKey;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GCYSSecondDegreeMaterials {

    /**
     * 6000-8999
     */
    public static void init() {
        GCYSMaterials.LaPrNdCeOxidesSolution = new Material.Builder(6000, "la_pr_nd_ce_oxides_solution")
                .fluid()
                .color(0x9CE3DB)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(GCYSMaterials.LanthanumOxide, 1, GCYSMaterials.PraseodymiumOxide, 1, GCYSMaterials.NeodymiumOxide, 1, GCYSMaterials.CeriumOxide, 1)
                .build();

        GCYSMaterials.ScEuGdSmOxidesSolution = new Material.Builder(6001, "sc_eu_gd_sm_oxides_solution")
                .fluid()
                .color(0xFFFF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(GCYSMaterials.ScandiumOxide, 1, GCYSMaterials.EuropiumOxide, 1, GCYSMaterials.GadoliniumOxide, 1, GCYSMaterials.SamariumOxide, 1)
                .build();

        GCYSMaterials.YTbDyHoOxidesSolution = new Material.Builder(6002, "y_tb_dy_ho_oxides_solution")
                .fluid()
                .color(0x99FF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(GCYSMaterials.YttriumOxide, 1, GCYSMaterials.TerbiumOxide, 1, GCYSMaterials.DysprosiumOxide, 1, GCYSMaterials.HolmiumOxide, 1)
                .build();

        GCYSMaterials.ErTmYbLuOxidesSolution = new Material.Builder(6003, "er_tm_yb_lu_oxides_solution")
                .fluid()
                .color(0xFFB3FF)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(GCYSMaterials.ErbiumOxide, 1, GCYSMaterials.ThuliumOxide, 1, GCYSMaterials.YtterbiumOxide, 1, GCYSMaterials.LutetiumOxide, 1)
                .build();

        GCYSMaterials.PlatinumGroupConcentrate = new Material.Builder(6004, "platinum_group_concentrate")
                .fluid()
                .color(0xFFFFA6)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gold, 1, Platinum, 1, Palladium, 1, HydrochloricAcid, 6)
                .build();

        GCYSMaterials.PlatinumGroupResidue = new Material.Builder(6005, "platinum_group_residue")
                .dust()
                .color(0x64632E)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iridium, 1, Osmium, 1, Rhodium, 1, Ruthenium, 1, RareEarth, 1)
                .build();

        // FREE ID 6006-6013

        GCYSMaterials.GrapheneOxide = new Material.Builder(6014, "graphene_oxide")
                .dust()
                .color(0x777777)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Graphene, 1, Oxygen, 1)
                .build();

        GCYSMaterials.AmmoniumNitrate = new Material.Builder(6015, "ammonium_nitrate")
                .dust()
                .color(0xA59ED7)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Ammonia, 1, NitricAcid, 1)
                .build()
                .setFormula("NH4NO3", true);

        GCYSMaterials.Wollastonite = new Material.Builder(6016, "wollastonite")
                .dust()
                .color(0xF0F0F0)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Quicklime, 2, SiliconDioxide, 3)
                .build()
                .setFormula("CaSiO3", true);

        GCYSMaterials.RoastedSphalerite = new Material.Builder(6017, "roasted_sphalerite")
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, GCYSMaterials.GermaniumDioxide, 1)
                .build();

        GCYSMaterials.WaelzOxide = new Material.Builder(6018, "waelz_oxide")
                .dust()
                .color(0xB8B8B8)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Zinc, 1, GCYSMaterials.GermaniumDioxide, 1)
                .build();

        //TODO move to first degree
        GCYSMaterials.WaelzSlag = new Material.Builder(6019, "waelz_slag")
                .dust()
                .color(0xAC8B5C)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Gallium, 1, Zinc, 1, Sulfur, 1, Oxygen, 4)
                .build();

        GCYSMaterials.ImpureGermaniumDioxide = new Material.Builder(6020, "impure_germanium_dioxide")
                .dust()
                .color(0x666666)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(GCYSMaterials.GermaniumDioxide, 1)
                .build()
                .setFormula("GeO2?", true);

        GCYSMaterials.ErbiumDopedZBLANGlass = new Material.Builder(6021, "erbium_doped_zblan_glass")
                .ingot()
                .color(0x505444)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(GCYSMaterials.ZBLANGlass, 1, Erbium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Er", true);

        GCYSMaterials.PraseodymiumDopedZBLANGlass = new Material.Builder(6022, "praseodymium_doped_zblan_glass")
                .ingot()
                .color(0xC5C88D)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION, GENERATE_PLATE)
                .components(GCYSMaterials.ZBLANGlass, 1, Praseodymium, 1)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2Pr", true);

        GCYSMaterials.NdYAG = new Material.Builder(6023, "nd_yag") //TODO "Yttrium-Aluminium-Garnet" Tooltip
                .gem()
                .color(0xD99DE4)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(CRYSTALLIZABLE, DECOMPOSITION_BY_CENTRIFUGING)
                .components(GCYSMaterials.YttriumOxide, 2, GCYSMaterials.NeodymiumOxide, 1, GCYSMaterials.Alumina, 5)
                .build()
                .setFormula("NdY2Al5O12", true);

        GCYSMaterials.BismuthFerrite = new Material.Builder(6024, "bismuth_ferrite") //TODO "Multiferroic!" tooltip
                .gem()
                .color(0x43634B)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(CRYSTALLIZABLE, GENERATE_PLATE)
                .components(GCYSMaterials.BismuthTrioxide, 2, GCYSMaterials.FerricOxide, 2)
                .build()
                .setFormula("BiFeO3", true);

        GCYSMaterials.ChromiumGermaniumTellurideMagnetic = new Material.Builder(6025, "cgt_magnetic")
                .ingot()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, IS_MAGNETIC)
                .components(GCYSMaterials.ChromiumGermaniumTelluride, 1)
                .ingotSmeltInto(GCYSMaterials.ChromiumGermaniumTelluride)
                .arcSmeltInto(GCYSMaterials.ChromiumGermaniumTelluride)
                .macerateInto(GCYSMaterials.ChromiumGermaniumTelluride)
                .build();
        GCYSMaterials.ChromiumGermaniumTelluride.getProperty(PropertyKey.INGOT).setMagneticMaterial(GCYSMaterials.ChromiumGermaniumTellurideMagnetic);

        GCYSMaterials.HeavyAlkaliChlorideSolution = new Material.Builder(6026, "heavy_alkali_chloride_solution")
                .fluid()
                .color(0x8F5353)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rubidium, 1, Caesium, 2, Chlorine, 6, Water, 2)
                .build()
                .setFormula("RbCl(CsCl)2Cl3(H2O)2", true);
    }
}
