package me.oganesson.gregica.common.item.metaitems;

import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.*;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import me.oganesson.gregica.GCConfig;
import me.oganesson.gregica.common.unification.materials.GCMaterials;

import static gregtech.api.GTValues.M;
import static me.oganesson.gregica.common.item.metaitems.GCMetaItems.*;

public class GCMetaItem2 extends StandardMetaItem {
    public GCMetaItem2() {
        super();
        if (GCConfig.Misc.enableTjcore) {
            registerSubItems();
        }
    }

    @Override
    public void registerSubItems() {

        SMD_RESISTOR_1 = addItem(1, "component.smd_resistor_1").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_1 = addItem(2, "component.smd_transistor_1").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_1 = addItem(3, "component.smd_diode_1").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_1 = addItem(4, "component.smd_capacitor_1").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_1 = addItem(5, "component.smd_inductor_1").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_2 = addItem(6, "component.smd_resistor_2").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_2 = addItem(7, "component.smd_transistor_2").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_2 = addItem(8, "component.smd_diode_2").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_2 = addItem(9, "component.smd_capacitor_2").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_2 = addItem(10, "component.smd_inductor_2").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_3 = addItem(11, "component.smd_resistor_3").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_3 = addItem(12, "component.smd_transistor_3").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_3 = addItem(13, "component.smd_diode_3").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_3 = addItem(14, "component.smd_capacitor_3").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_3 = addItem(15, "component.smd_inductor_3").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_4 = addItem(16, "component.smd_resistor_4").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_4 = addItem(17, "component.smd_transistor_4").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_4 = addItem(18, "component.smd_diode_4").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_4 = addItem(19, "component.smd_capacitor_4").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_4 = addItem(20, "component.smd_inductor_4").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_5 = addItem(21, "component.smd_resistor_5").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_5 = addItem(22, "component.smd_transistor_5").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_CAPACITOR_5 = addItem(24, "component.smd_capacitor_5").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_5 = addItem(25, "component.smd_inductor_5").setUnificationData(OrePrefix.component, Component.Inductor);
        SMD_DIODE_5 = addItem(26, "component.smd_diode_5").setUnificationData(OrePrefix.component, Component.Diode);
        // Misc. SMD ITEMS (27-49)

        FERROUS_INDUCTOR_CORE = addItem(27, "ferrous_inductor_core");
        TUNGSTEN_INDUCTOR_CORE = addItem(28,"tungsten_inductor_core");
        LANGMUIR_OSCILATOR = addItem(29, "langmuir_wave_oscilator");
        LANGMUIR_HOUSING = addItem(30, "langmuir_qbit_housing");
        SQUID_BASE = addItem(31, "squid_base");
        TRANSMON_SUPPORT = addItem(32, "transmon_support_system");
        GRAPHENE_ALUMINOSILICATE_AEROGEL = addItem(33, "graphene_aluminosilicate_aerogel");
        LAYERED_POLYMER_FOIL = addItem(34, "layered_polyer_foil");
        STERILE_POLYMER_FOIL = addItem(35, "sterile_polymer_foil");

        //Boards & Preboards (50-99)
        PRIMITIVE_PREBOARD = addItem(50, "primitive_preboard");
        ELECTRONIC_PREBOARD = addItem(51, "electronic_preboard");
        INTEGRATED_PREBOARD = addItem(52, "integrated_preboard");
        MICRO_PREBOARD = addItem(53, "micro_preboard");
        NANO_PREBOARD = addItem(54, "nano_preboard");
        IMC_PREBOARD = addItem(55, "imc_preboard");
        OPTICAL_PREBOARD = addItem(56, "optical_preboard");
        CRYSTAL_PREBOARD = addItem(57, "crystal_preboard");
        BIOWARE_PREBOARD = addItem(58, "bioware_preboard");
        WETWARE_PREBOARD = addItem(59, "wetware_preboard");
        QUANTUM_PREBOARD = addItem(60, "quantum_preboard");
        EXOTIC_PREBOARD = addItem(61, "exotic_preboard");
        COSMIC_PREBOARD = addItem(62, "cosmic_preboard");
        SUPRA_PREBOARD = addItem(63, "supra_preboard");

        PRIMITIVE_BOARD = addItem(64, "primitive_board");
        ELECTRONIC_BOARD = addItem(65, "electronic_board");
        INTEGRATED_BOARD = addItem(66, "integrated_board");
        MICRO_BOARD = addItem(67, "micro_board");
        NANO_BOARD = addItem(68, "nano_board");
        IMC_BOARD = addItem(69, "imc_board");
        OPTICAL_BOARD = addItem(70, "optical_board");
        CRYSTAL_BOARD = addItem(71, "crystal_board");
        BIOWARE_BOARD = addItem(72, "bioware_board");
        WETWARE_BOARD = addItem(73, "wetware_board");
        QUANTUM_BOARD = addItem(74, "quantum_board");
        EXOTIC_BOARD = addItem(75, "exotic_board");
        COSMIC_BOARD = addItem(76, "cosmic_board");
        SUPRA_BOARD = addItem(77, "supra_board");

        //Circuit Metaitems (100-199)
        PRIMITIVE_ASSEMBLY_ULV = addItem(100, "circuit.primitive_ulv").setUnificationData(OrePrefix.circuit,   Tier.ULV);
        PRIMITIVE_COMPUTER_LV = addItem(101, "circuit.primitive_lv").setUnificationData(OrePrefix.circuit,    Tier.LV);
        PRIMITIVE_MAINFRAME_MV = addItem(102, "circuit.primitive_mv").setUnificationData(OrePrefix.circuit,  Tier.MV);

        ELECTRONIC_PROCESSOR_ULV = addItem(103, "circuit.electronic_ulv").setUnificationData(OrePrefix.circuit,   Tier.ULV);
        ELECTRONIC_ASSEMBLY_LV = addItem(104, "circuit.electronic_lv").setUnificationData(OrePrefix.circuit,      Tier.LV);
        ELECTRONIC_COMPUTER_MV = addItem(105, "circuit.electronic_mv").setUnificationData(OrePrefix.circuit,      Tier.MV);
        ELECTRONIC_MAINFRAME_HV = addItem(106, "circuit.electronic_hv").setUnificationData(OrePrefix.circuit,    Tier.HV);

        INTEGRATED_PROCESSOR_LV = addItem(107, "circuit.integrated_lv").setUnificationData(OrePrefix.circuit,    Tier.LV);
        INTEGRATED_ASSEMBLY_MV = addItem(108, "circuit.integrated_mv").setUnificationData(OrePrefix.circuit,      Tier.MV);
        INTEGRATED_COMPUTER_HV = addItem(109, "circuit.integrated_hv").setUnificationData(OrePrefix.circuit,      Tier.HV);
        INTEGRATED_MAINFRAME_EV = addItem(110, "circuit.integrated_ev").setUnificationData(OrePrefix.circuit,    Tier.EV);

        MICRO_PROCESSOR_MV = addItem(111, "circuit.micro_mv").setUnificationData(OrePrefix.circuit, Tier.MV);
        MICRO_ASSEMBLY_HV = addItem(112, "circuit.micro_hv").setUnificationData(OrePrefix.circuit, Tier.HV);
        MICRO_COMPUTER_EV = addItem(113, "circuit.micro_ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        MICRO_MAINFRAME_IV = addItem(114, "circuit.micro_iv").setUnificationData(OrePrefix.circuit, Tier.IV);

        NANO_PROCESSOR_HV = addItem(115, "circuit.nano_hv").setUnificationData(OrePrefix.circuit, Tier.HV);
        NANO_ASSEMBLY_EV = addItem(116, "circuit.nano_ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        NANO_COMPUTER_IV = addItem(117, "circuit.nano_iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        NANO_MAINFRAME_LUV = addItem(118, "circuit.nano_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);

        IMC_PROCESSOR_EV = addItem(119, "circuit.imc_ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        IMC_ASSEMBLY_IV = addItem(120, "circuit.imc_iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        IMC_COMPUTER_LUV = addItem(121, "circuit.imc_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        IMC_MAINFRAME_ZPM = addItem(122, "circuit.imc_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);

        OPTICAL_PROCESSOR_IV = addItem(123, "circuit.optical_iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        OPTICAL_ASSEMBLY_LUV = addItem(124, "circuit.optical_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        OPTICAL_COMPUTER_ZPM = addItem(125, "circuit.optical_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        OPTICAL_MAINFRAME_UV = addItem(126, "circuit.optical_uv").setUnificationData(OrePrefix.circuit, Tier.UV);

        CRYSTAL_PROCESSOR_LUV = addItem(127, "circuit.crystal_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        CRYSTAL_ASSEMBLY_ZPM = addItem(128, "circuit.crystal_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        CRYSTAL_COMPUTER_UV = addItem(129, "circuit.crystal_uv").setUnificationData(OrePrefix.circuit, Tier.UV);
        CRYSTAL_MAINFRAME_UHV = addItem(130, "circuit.crystal_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);

        QUANTUM_PROCESSOR_ZPM = addItem(131,"circuit.quantum_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        QUANTUM_ASSEMBLY_UV = addItem(132,"circuit.quantum_uv").setUnificationData(OrePrefix.circuit, Tier.UV);
        QUANTUM_COMPUTER_UHV = addItem(133,"circuit.quantum_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);
        QUANTUM_MAINFRAME_UEV = addItem(134,"circuit.quantum_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);

        WETWARE_PROCESSOR_UV = addItem(135, "circuit.wetware_uv").setUnificationData(OrePrefix.circuit, Tier.UV);
        WETWARE_ASSEMBLY_UHV = addItem(136, "circuit.wetware_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);
        WETWARE_COMPUTER_UEV = addItem(137, "circuit.wetware_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);
        WETWARE_MAINFRAME_UIV = addItem(138, "circuit.wetware_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);

        BIOWARE_PROCESSOR_UHV = addItem(139, "circuit.bioware_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);
        BIOWARE_ASSEMBLY_UEV = addItem(140, "circuit.bioware_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);
        BIOWARE_COMPUTER_UIV = addItem(141, "circuit.bioware_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        BIOWARE_MAINFRAME_UXV = addItem(142,"circuit.bioware_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);

        EXOTIC_PROCESSOR_UEV = addItem(143,"circuit.exotic_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);
        EXOTIC_ASSEMBLY_UIV = addItem(144,"circuit.exotic_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        EXOTIC_COMPUTER_UXV = addItem(145,"circuit.exotic_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        EXOTIC_MAINFRAME_OPV = addItem(146,"circuit.exotic_opv").setUnificationData(OrePrefix.circuit, Tier.OpV);

        COSMIC_PROCESSOR_UIV = addItem(147,"circuit.cosmic_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        COSMIC_ASSEMBLY_UXV = addItem(148,"circuit.cosmic_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        COSMIC_COMPUTER_OPV = addItem(149,"circuit.cosmic_opv").setUnificationData(OrePrefix.circuit, Tier.OpV);
        COSMIC_MAINFRAME_MAX = addItem(150,"circuit.cosmic_max").setUnificationData(OrePrefix.circuit, Tier.MAX);

        SUPRA_PROCESSOR_UXV = addItem(151,"circuit.supra_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        SUPRA_ASSEMBLY_OPV = addItem(152,"circuit.supra_opv").setUnificationData(OrePrefix.circuit, Tier.OpV);
        SUPRA_COMPUTER_MAX = addItem(153,"circuit.supra_max").setUnificationData(OrePrefix.circuit, Tier.MAX);
        SUPRA_MAINFRAME_ALL = addItem(154,"circuit.supra_all")
                .setUnificationData(OrePrefix.circuit, Tier.ULV)
                .setUnificationData(OrePrefix.circuit, Tier.LV)
                .setUnificationData(OrePrefix.circuit, Tier.MV)
                .setUnificationData(OrePrefix.circuit, Tier.HV)
                .setUnificationData(OrePrefix.circuit, Tier.EV)
                .setUnificationData(OrePrefix.circuit, Tier.IV)
                .setUnificationData(OrePrefix.circuit, Tier.LuV)
                .setUnificationData(OrePrefix.circuit, Tier.ZPM)
                .setUnificationData(OrePrefix.circuit, Tier.UV)
                .setUnificationData(OrePrefix.circuit, Tier.UHV)
                .setUnificationData(OrePrefix.circuit, Tier.UEV)
                .setUnificationData(OrePrefix.circuit, Tier.UIV)
                .setUnificationData(OrePrefix.circuit, Tier.UXV)
                .setUnificationData(OrePrefix.circuit, Tier.OpV)
                .setUnificationData(OrePrefix.circuit, Tier.MAX);

        //Open (200-299)

        //PCB Intermediate Metaitems Primitive - Crystal (300-499)
        WETPHENOLICPULP = addItem(300, "wetphenolicpulp");
        WETPRESSEDPHENOLICSUBSTRATE = addItem(301, "wetpressedphenolicsubstrate");
        COPPER_LAMINATED_EPOXID = addItem(302, "copper_laminated_epoxid");
        ELECTRUM_LAMINATED_EPOXID = addItem(303, "electrum_laminated_epoxid");
        GERMANIUM_LAMINATED_EPOXID = addItem(304,"germanium_laminated_epoxid");
        FIBERGLASS_MESH = addItem(305,"fiber_glass_mesh");
        ZBLANMATRIX = addItem(306,"zblan_matrix");
        OPTICAL_BASE = addItem(307,"optical_base");
        LAMINATED_OPTICAL_BASE = addItem(308,"laminated_optical_base");
        PROCESSED_CRYSTAL_WAFER = addItem(309,"processed_crystal_wafer");
        CRYSTAL_SFET_BUNDLE = addItem(310,"crystal_sfet_bundle");
        CRYSTAL_SFET_WAFER = addItem(311,"crystal_sfet_wafer");
        REFRACTING_SHEET = addItem(312,"refracting_sheet");
        LAMINATED_CRYSTAL_PCB_SHEET = addItem(313,"laminated_crystal_pcb_sheet");
        GAMMA_EMITTING_DIODE = addItem(314,"gamma_emitting_diode");
        REFLECTING_SHEET = addItem(315, "reflecting_sheet");


        //Lithography Metaitems (500-597)
        SILICON_BOULE = addItem(500, "silicon_boule");
        ANTIMONY_DOPED_SILICON_BOULE = addItem(501, "antimony_doped_silicon_boule");
        BORON_DOPED_SILICON_BOULE = addItem(502, "boron_doped_silicon_boule");
        GALLIUM_ARSENIDE_BOULE = addItem(503, "gallium_arsenide_boule");
        SILVER_GALLIUM_SELENIDE_BOULE = addItem(504, "silver_gallium_selenide_boule");

        SILICON_WAFER = addItem(505, "silicon_wafer");
        ANTIMONY_DOPED_SILICON_WAFER = addItem(506, "antimony_doped_silicon_wafer");
        BORON_DOPED_SILICON_WAFER = addItem(507, "boron_doped_silicon_wafer");
        GALLIUM_ARSENIDE_WAFER = addItem(508, "gallium_arsenide_wafer");
        SILVER_GALLIUM_SELENIDE_WAFER = addItem(509, "silver_gallium_selenide_wafer");

        LAYERED_SILICON_WAFER = addItem(510, "layered_silicon_wafer");
        LAYERED_ANTIMONY_DOPED_SILICON_WAFER = addItem(511, "layered_antimony_doped_silicon_wafer");
        LAYERED_BORON_DOPED_SILICON_WAFER = addItem(512, "layered_boron_doped_silicon_wafer");
        LAYERED_GALLIUM_ARSENIDE_WAFER = addItem(513, "layered_gallium_arsenide_wafer");
        LAYERED_SILVER_GALLIUM_SELENIDE_WAFER = addItem(514, "layered_silver_gallium_selenide_wafer");

        PREPARED_SILICON_WAFER = addItem(515, "prepared_silicon_wafer");
        PREPARED_ANTIMONY_DOPED_SILICON_WAFER = addItem(516, "prepared_antimony_doped_silicon_wafer");
        PREPARED_BORON_DOPED_SILICON_WAFER = addItem(517, "prepared_boron_doped_silicon_wafer");
        PREPARED_GALLIUM_ARSENIDE_WAFER = addItem(518, "prepared_gallium_arsenide_wafer");
        PREPARED_SILVER_GALLIUM_SELENIDE_WAFER = addItem(519, "prepared_silver_gallium_selenide_wafer");

        INTEGRATED_WAFER_LITHOGRAPHY_PREP = addItem(520, "integrated_wafer_lithography_prep");
        MICRO_WAFER_LITHOGRAPHY_PREP = addItem(521, "micro_wafer_lithography_prep");
        NANO_WAFER_LITHOGRAPHY_PREP = addItem(522, "nano_wafer_lithography_prep");
        IMC_WAFER_LITHOGRAPHY_PREP = addItem(523, "imc_wafer_lithography_prep");
        OPTICAL_WAFER_LITHOGRAPHY_PREP = addItem(524, "optical_wafer_lithography_prep");

        PREBAKED_INTEGRATED_WAFER = addItem(525, "prebaked_integrated_wafer");
        PREBAKED_MICRO_WAFER = addItem(526, "prebaked_micro_wafer");
        PREBAKED_NANO_WAFER = addItem(527, "prebaked_nano_wafer");
        PREBAKED_IMC_WAFER = addItem(528, "prebaked_imc_wafer");
        PREBAKED_OPTICAL_WAFER = addItem(529, "prebaked_optical_wafer");

        TREATED_INTEGRATED_WAFER = addItem(530, "treated_integrated_wafer");
        TREATED_MICRO_WAFER = addItem(531, "treated_micro_wafer");
        TREATED_NANO_WAFER = addItem(532, "treated_nano_wafer");
        TREATED_IMC_WAFER = addItem(533, "treated_imc_wafer");
        TREATED_OPTICAL_WAFER = addItem(534, "treated_optical_wafer");

        RAW_INTEGRATED_WAFER = addItem(535, "raw_integrated_wafer");
        RAW_MICRO_WAFER = addItem(536, "raw_micro_wafer");
        RAW_NANO_WAFER = addItem(537, "raw_nano_wafer");
        RAW_IMC_WAFER = addItem(538, "raw_imc_wafer");
        RAW_OPTICAL_WAFER = addItem(539, "raw_optical_wafer");

        BAKED_INTEGRATED_WAFER = addItem(540, "baked_integrated_wafer");
        BAKED_MICRO_WAFER = addItem(541, "baked_micro_wafer");
        BAKED_NANO_WAFER = addItem(542, "baked_nano_wafer");
        BAKED_IMC_WAFER = addItem(543, "baked_imc_wafer");
        BAKED_OPTICAL_WAFER = addItem(544, "baked_optical_wafer");

        INTEGRATED_WAFER = addItem(545, "integrated_wafer");
        MICRO_WAFER = addItem(546, "micro_wafer");
        NANO_WAFER = addItem(547, "nano_wafer");
        IMC_WAFER = addItem(548, "imc_wafer");
        OPTICAL_WAFER = addItem(549, "optical_wafer");

        ETCHED_INTEGRATED_WAFER = addItem(550, "etched_integrated_wafer");
        ETCHED_MICRO_WAFER = addItem(551, "etched_micro_wafer");
        ETCHED_NANO_WAFER = addItem(552, "etched_nano_wafer");
        ETCHED_IMC_WAFER = addItem(553, "etched_imc_wafer");
        ETCHED_OPTICAL_WAFER = addItem(554, "etched_optical_wafer");

        INTEGRATED_CHIP = addItem(555, "integrated_chip");
        MICRO_CHIP = addItem(556, "micro_chip");
        NANO_CHIP = addItem(557, "nano_chip");
        IMC_CHIP = addItem(558, "imc_chip");
        OPTICAL_CHIP = addItem(559, "optical_chip");

        INTEGRATED_HARD_MASK = addItem(560, "integrated_hard_mask");
        MICRO_HARD_MASK = addItem(561, "micro_hard_mask");
        NANO_HARD_MASK = addItem(562, "nano_hard_mask");
        IMC_HARD_MASK = addItem(563, "imc_hard_mask");
        OPTICAL_HARD_MASK = addItem(564, "optical_hard_mask");

        UVEMITTER_A = addItem(565, "uvemitter_a");
        UVEMITTER_B = addItem(566, "uvemitter_b");
        UVEMITTER_C = addItem(567, "uvemitter_c");
        UVEMITTER_D = addItem(568, "uvemitter_d");
        UVEMITTER_E = addItem(569, "uvemitter_e");

        BALLAST = addItem(570,"ballast");
        EMPTY_GEISSLER_TUBE = addItem(571, "empty_geissler_tube");
        EMPTY_ARC_LAMP = addItem(572, "empty_arc_lamp");
        LASER_TUBE = addItem(573, "laser_tube");
        STENCILING_CUTHEAD = addItem(574, "stencil_cutting_head");

        // Chip Metaitems Excluding Lithography (598-999)

        //Primitive Chip
        EVACUATED_TUBE = addItem(598, "evacuated_glass_tube");
        VACUUM_TUBE = addItem(599, "vacuum_tube");

        // Electronic Chip
        SIMPLE_SILICON_WAFER = addItem(600, "simple_silicon_wafer");
        SIMPLE_CPU_WAFER = addItem(601,"simple_cpu_wafer");
        SIMPLE_CPU = addItem(602, "simple_cpu");

        // Sapphire Chip
        COATED_SAPPHIRE_WAFER = addItem(603,"coated_sapphire_wafer");
        DIRTY_COATED_SAPPHIRE_WAFER = addItem(604,"dirty_coated_sapphire_wafer");
        CLEANED_COATED_SAPPHIRE_WAFER = addItem(605,"cleaned_coated_sapphire_wafer");
        SAPPHIRE_SUBSTRATE_PREP = addItem(606,"sapphire_substrate_prep");
        ETCHED_SAPPHIRE_WAFER = addItem(607,"etched_sapphire_wafer");
        SUPERHEATED_SAPPHIRE_WAFER = addItem(608,"superheated_sapphire_wafer");
        VIABLE_SAPPHIRE_WAFER = addItem(609,"viable_sapphire_wafer");
        NONVIABLE_SAPPHIRE_WAFER = addItem(610,"nonviable_sapphire_wafer");
        RECYCLED_SAPPHIRE_WAFER = addItem(611,"recycled_sapphire_wafer");
        SINTERED_SAPPHIRE_WAFER = addItem(612,"sintered_sapphire_wafer");
        WIRED_SAPPHIRE_WAFER = addItem(613,"wired_sapphire_wafer");
        SAPPHIRE_WAFER = addItem(614,"sapphire_wafer");
        RAW_SAPPHIRE_CHIP = addItem(615, "raw_crystal_chip");
        SAPPHIRE_CHIP = addItem(616,"sapphire_chip");

        //Quantum CPU
        EVACUATED_SYNTHETIC_DIAMOND = addItem(617, "evacuated_synthetic_diamond");
        ANNEALED_NVC_PREPARATION = addItem(618, "annealed_nvc_prep");
        STRESSED_NVC_SHEET = addItem(619, "stressed_nvc_sheet");
        NVC_CHIP = addItem(620, "nvc_chip");
        RABI_SENSOR = addItem(621,"rabi_sensor");
        NVC_SENSOR = addItem(622, "nvc_sensor");
        NVC_STORAGE_MODULE = addItem(623, "nvc_storage_module");
        LAYERED_DATA_TRANSFER_PCB = addItem(624, "layered_data_pcb");
        DATA_TRANSFER_MASK = addItem(625, "data_mask");
        MASKED_DATA_TRANSFER_PCB = addItem(626, "masked_data_pcb");
        ETCHED_MASKED_DATA_TRANSFER_PCB = addItem(627, "etched_masked_data_pcb");
        ETCHED_DATA_TRANSFER_PCB = addItem(628, "etched_data_pcb");
        UNITARY_MAPPING_SHEET = addItem(629, "unitary_mapping_sheet");
        UNITARY_MEASUREMENT_MODULE = addItem(630, "unitary_measurement_module");
        ANYON_BIT_REGISTER = addItem(631, "anyon_bit_register");
        WAVEFORM_LOGISTICS_BRIDGE = addItem(632, "waveform_logistics_bridge");
        SMALL_GAAS_WAFER = addItem(633, "small_gallium_arsenide_wafer");
        FRACTIONAL_HALL_WAFER = addItem(634, "fractional_hall_wafer");
        FRACTIONAL_HALL_CHIP = addItem(635, "fractional_hall_chip");
        FRACTIONAL_HALL_COMPLEX = addItem(636, "fractional_hall_complex");
        NON_ABELIAN_ANYON_STRANDPLATE = addItem(637, "anyon_strandplate");
        MAGNETIC_STRANDPLATE_FORM = addItem(638, "magnetic_strandplate_form");
        PRECISION_MAG_STIMULATION_SHEET = addItem(639, "magnetic_stimulation_sheet");
        ANYON_BRAIDING_STRUCTURE = addItem(640, "anyon_braiding_structure");
        QUANTUM_CPU = addItem(641, "quantum_cpu");


        WETWARE_CPU = addItem(995, "wetware_cpu");

        BIOWARE_CPU = addItem(996, "bioware_cpu");

        EXOTIC_CPU = addItem(997, "exotic_cpu");

        COSMIC_CPU = addItem(998, "cosmic_cpu");

        SUPRA_CPU = addItem(999, "supra_cpu");

        // Chemistry Intermediates (1000-1249)
        SPUN_POLYACRYLONITRILE = addItem(1000,"spun_polyacrylonitrile");
        WASHED_POLYACRLONITRILE = addItem(1001,"washed_polyacrylonitrile");
        BAKED_POLYACRLONITRILE = addItem(1002,"baked_polyacrylonitrile");
        OXIDIZED_CARBON_THREAD = addItem(1003,"oxidized_carbon_thread");
        ETCHED_CARBON_THREAD = addItem(1004,"etched_carbon_thread");
        COATED_CARBON_THREAD = addItem(1005,"coated_carbon_thread");
        WOVEN_CARBON_FIBER = addItem(1006,"woven_carbon_fiber");
        THIN_WOVEN_CARBON_FIBER = addItem(1007,"thin_woven_carbon_fiber");

        // Chemistry End Products (1250-1299)
        CNT_SHORT = addItem(1250, "short_carbon_nanotube_strand");
        CNT_LONG = addItem(1251, "long_carbon_nanotube_strand");
        CARBON_FIBER_PLATE = addItem(1252,"carbon_fiber_plate");
        CARBON_FIBER_FOIL = addItem(1253,"carbon_fiber_foil");

        // Microcrafting + Components (1300-1499)
        STEAM_MOTOR = addItem(1300, "steam_motor");
        STEAM_PISTON = addItem(1301, "steam_piston");
        STEAM_PUMP = addItem(1302, "steam_pump");
        CLEANROOM_FILTER = addItem(1303, "cleanroom_filter");
        MICROTUBE_INVERSE_FORM = addItem(1304, "microtube_inverse_form");
        COPPER_MICROTUBE_MATRIX = addItem(1305, "copper_microtube_matrix");
        SUPERCOOLING_RADIATOR = addItem(1306, "supercooling_radiator");
        SUPERCOOLING_ASSEMBLY = addItem(1307, "supercooling_assembly");
        SUPERCOOLING_PORT = addItem(1308, "supercooling_port");

        GOOWARE_PROCESSOR = addItem(1309, "circuit.gooware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        GOOWARE_ASSEMBLY = addItem(1310, "circuit.gooware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        GOOWARE_COMPUTER = addItem(1311, "circuit.gooware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        GOOWARE_MAINFRAME = addItem(1312, "circuit.gooware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);

        OPTICAL_PROCESSOR = addItem(1313,"circuit.optical_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        OPTICAL_ASSEMBLY = addItem(1314,"circuit.optical_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        OPTICAL_COMPUTER = addItem(1315,"circuit.optical_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        OPTICAL_MAINFRAME = addItem(1316,"circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);

        SPINTRONIC_PROCESSOR = addItem(1317, "circuit.spintronic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SPINTRONIC_ASSEMBLY = addItem(1318, "circuit.spintronic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SPINTRONIC_COMPUTER = addItem(1319, "circuit.spintronic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SPINTRONIC_MAINFRAME = addItem(1320, "circuit.spintronic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);

        COSMIC_PROCESSOR = addItem(1321, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        COSMIC_ASSEMBLY = addItem(1322, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        COSMIC_COMPUTER = addItem(1323, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_MAINFRAME = addItem(1324, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);

        SUPRACAUSAL_PROCESSOR = addItem(1325, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACAUSAL_ASSEMBLY = addItem(1326, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACAUSAL_COMPUTER = addItem(1327, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACAUSAL_MAINFRAME = addItem(1328, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        SUPRACHRONAL_ULV = addItem(1329, "circuit.suprachronal.ulv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ULV);
        SUPRACHRONAL_LV = addItem(1330, "circuit.suprachronal.lv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LV);
        SUPRACHRONAL_MV = addItem(1331, "circuit.suprachronal.mv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MV);
        SUPRACHRONAL_HV = addItem(1332, "circuit.suprachronal.hv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.HV);
        SUPRACHRONAL_EV = addItem(1333, "circuit.suprachronal.ev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.EV);
        SUPRACHRONAL_IV = addItem(1334, "circuit.suprachronal.iv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.IV);
        SUPRACHRONAL_LuV = addItem(1335, "circuit.suprachronal.luv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LuV);
        SUPRACHRONAL_ZPM = addItem(1336, "circuit.suprachronal.zpm").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        SUPRACHRONAL_UV = addItem(1337, "circuit.suprachronal.uv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        SUPRACHRONAL_UHV = addItem(1338, "circuit.suprachronal.uhv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SUPRACHRONAL_UEV = addItem(1339, "circuit.suprachronal.uev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SUPRACHRONAL_UIV = addItem(1340, "circuit.suprachronal.uiv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACHRONAL_UXV = addItem(1341, "circuit.suprachronal.uxv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACHRONAL_OpV = addItem(1342, "circuit.suprachronal.opv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACHRONAL_MAX = addItem(1343, "circuit.suprachronal.max").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        // Primitive Circuit Components: ID 1343-1350
        VACUUM_TUBE_COMPONENTS = addItem(1344, "vacuum_tube.components").setInvisible(GCConfig.circuitOverrides.harderVacuumTubes);

        // Electronic Circuit Components: ID 1351-1360


        // Micro Circuit Components: ID 1361-1370


        // Nano Circuit Components: ID 1371-1380


        // Quantum Circuit Components: ID 1381-1390


        // Crystal Circuit Components: ID 1391-1400
        EU_DOPED_CUBIC_ZIRCONIA_BOULE = addItem(1391, "boule.cubic_zirconia.europium");
        EU_DOPED_CUBIC_ZIRCONIA_WAFER = addItem(1392, "wafer.cubic_zirconia.europium");

        // Wetware Circuit Components: ID 1401-1410


        // Gooware Circuit Components: ID 1411-1420
        BZ_REACTION_CHAMBER = addItem(1411, "reaction_chamber.bz");
        NONLINEAR_CHEMICAL_OSCILLATOR = addItem(1412, "nonlinear_chemical_oscillator");

        // Cosmic Circuit Components: ID 1421-1530


        // Supra-Causal Circuit Components: ID 1531-1540


        // Supra-Chronal Circuit Components: ID 1541-1550


        // Voltage Coils: ID 1551-1560
        VOLTAGE_COIL_UHV = addItem(1551, "voltage_coil.uhv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UEV = addItem(1552, "voltage_coil.uev").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UIV = addItem(1553, "voltage_coil.uiv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UXV = addItem(1554, "voltage_coil.uxv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_OpV = addItem(1555, "voltage_coil.opv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_MAX = addItem(1556, "voltage_coil.max").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));

        // Power Components: ID 1561-1570
        NANO_POWER_IC_WAFER = addItem(1561, "wafer.nano_power_integrated_circuit");
        PICO_POWER_IC_WAFER = addItem(1562, "wafer.pico_power_integrated_circuit");
        FEMTO_POWER_IC_WAFER = addItem(1563, "wafer.femto_power_integrated_circuit");
        NANO_POWER_IC = addItem(1564, "plate.nano_power_integrated_circuit");
        PICO_POWER_IC = addItem(1565, "plate.pico_power_integrated_circuit");
        FEMTO_POWER_IC = addItem(1566, "plate.femto_power_integrated_circuit");

        // Simple Machine Crafting Components: ID 1571-1580
        COMPONENT_GRINDER_BORON_NITRIDE = addItem(1571, "component.grinder.boron_nitride")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.CubicBoronNitride, M * 4), new MaterialStack(GCMaterials.Vibranium, M * 8), new MaterialStack(GCMaterials.CubicHeterodiamond, M)));

        // Process-Specific Components: ID 1581-1590
        MAGNETRON = addItem(1581, "magnetron");

        // Process Intermediary Items: ID 1601-1610
        CARBON_ALLOTROPE_MIXTURE = addItem(1601, "mixture.carbon_allotrope");
        GRAPHENE_ALIGNED_CNT = addItem(1610, "cnt.graphene_aligned");
    }
}
