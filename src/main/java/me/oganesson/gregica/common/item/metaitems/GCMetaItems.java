package me.oganesson.gregica.common.item.metaitems;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.Component;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.items.behaviors.TooltipBehavior;
import me.oganesson.gregica.GCConfig;
import me.oganesson.gregica.common.item.behavior.BaguetteBehavior;
import me.oganesson.gregica.common.unification.materials.GCMaterials;
import me.oganesson.gregica.proxy.CommonProxy;
import net.minecraft.client.resources.I18n;

import static gregtech.api.GTValues.M;

public class GCMetaItems {
    private static StandardMetaItem metaItem1;
    private static StandardMetaItem metaItem2;


    public static MetaItem<?>.MetaValueItem BAGUETTE_SWORD;
    public static MetaItem<?>.MetaValueItem COMMON_ALGAE;
    public static MetaItem<?>.MetaValueItem GREEN_ALGAE;
    public static MetaItem<?>.MetaValueItem RED_ALGAE;
    public static MetaItem<?>.MetaValueItem BROWN_ALGAE;
    public static MetaItem<?>.MetaValueItem GOLD_ALGAE;
    public static MetaItem<?>.MetaValueItem T_ALGAE;
    public static MetaItem<?>.MetaValueItem ULV_CONVEYOR_MODULE;
    public static MetaItem<?>.MetaValueItem ULV_ELECTRIC_PUMP;
    public static MetaItem<?>.MetaValueItem ULV_ELECTRIC_MOTOR;
    public static MetaItem<?>.MetaValueItem ULV_ELECTRIC_PISTON;
    public static MetaItem<?>.MetaValueItem ULV_ROBOT_ARM;
    public static MetaItem<?>.MetaValueItem ULV_EMITTER;
    public static MetaItem<?>.MetaValueItem ULV_SENSOR;
    public static MetaItem<?>.MetaValueItem ULV_FIELD_GENERATOR;
    public static MetaItem<?>.MetaValueItem MAX_CONVEYOR_MODULE;
    public static MetaItem<?>.MetaValueItem MAX_ELECTRIC_PUMP;
    public static MetaItem<?>.MetaValueItem MAX_ELECTRIC_MOTOR;
    public static MetaItem<?>.MetaValueItem MAX_ELECTRIC_PISTON;
    public static MetaItem<?>.MetaValueItem MAX_ROBOT_ARM;
    public static MetaItem<?>.MetaValueItem MAX_EMITTER;
    public static MetaItem<?>.MetaValueItem MAX_SENSOR;
    public static MetaItem<?>.MetaValueItem MAX_FIELD_GENERATOR;
    public static MetaItem<?>.MetaValueItem ADVANCED_PROCESS_CIRCUIT;

    //Components + Microcrafting

    public static MetaItem<?>.MetaValueItem STEAM_MOTOR;
    public static MetaItem<?>.MetaValueItem STEAM_PISTON;
    public static MetaItem<?>.MetaValueItem STEAM_PUMP;
    public static MetaItem<?>.MetaValueItem CLEANROOM_FILTER;
    public static MetaItem<?>.MetaValueItem EVACUATED_TUBE;
    public static MetaItem<?>.MetaValueItem VACUUM_TUBE;

    //CIRCUITFRAMEWORK
    public static MetaItem<?>.MetaValueItem WETPHENOLICPULP;
    public static MetaItem<?>.MetaValueItem WETPRESSEDPHENOLICSUBSTRATE;

    public static MetaItem<?>.MetaValueItem UVEMITTER_A;
    public static MetaItem<?>.MetaValueItem UVEMITTER_B;
    public static MetaItem<?>.MetaValueItem UVEMITTER_C;
    public static MetaItem<?>.MetaValueItem UVEMITTER_D;
    public static MetaItem<?>.MetaValueItem UVEMITTER_E;

    //SMDs

    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_1;
    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_2;
    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_3;
    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_4;
    public static MetaItem<?>.MetaValueItem SMD_RESISTOR_5;

    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_1;
    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_2;
    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_3;
    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_4;
    public static MetaItem<?>.MetaValueItem SMD_TRANSISTOR_5;

    public static MetaItem<?>.MetaValueItem SMD_DIODE_1;
    public static MetaItem<?>.MetaValueItem SMD_DIODE_2;
    public static MetaItem<?>.MetaValueItem SMD_DIODE_3;
    public static MetaItem<?>.MetaValueItem SMD_DIODE_4;
    public static MetaItem<?>.MetaValueItem SMD_DIODE_5;

    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_1;
    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_2;
    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_3;
    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_4;
    public static MetaItem<?>.MetaValueItem SMD_CAPACITOR_5;

    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_1;
    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_2;
    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_3;
    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_4;
    public static MetaItem<?>.MetaValueItem SMD_INDUCTOR_5;

    //Boules + Wafers

    public static MetaItem<?>.MetaValueItem SILICON_BOULE;
    public static MetaItem<?>.MetaValueItem ANTIMONY_DOPED_SILICON_BOULE;
    public static MetaItem<?>.MetaValueItem BORON_DOPED_SILICON_BOULE;
    public static MetaItem<?>.MetaValueItem GALLIUM_ARSENIDE_BOULE;
    public static MetaItem<?>.MetaValueItem SILVER_GALLIUM_SELENIDE_BOULE;

    public static MetaItem<?>.MetaValueItem SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem ANTIMONY_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem BORON_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem GALLIUM_ARSENIDE_WAFER;
    public static MetaItem<?>.MetaValueItem SILVER_GALLIUM_SELENIDE_WAFER;

    public static MetaItem<?>.MetaValueItem LAYERED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem LAYERED_ANTIMONY_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem LAYERED_BORON_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem LAYERED_GALLIUM_ARSENIDE_WAFER;
    public static MetaItem<?>.MetaValueItem LAYERED_SILVER_GALLIUM_SELENIDE_WAFER;

    public static MetaItem<?>.MetaValueItem PREPARED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem PREPARED_ANTIMONY_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem PREPARED_BORON_DOPED_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem PREPARED_GALLIUM_ARSENIDE_WAFER;
    public static MetaItem<?>.MetaValueItem PREPARED_SILVER_GALLIUM_SELENIDE_WAFER;

    public static MetaItem<?>.MetaValueItem INTEGRATED_WAFER_LITHOGRAPHY_PREP;
    public static MetaItem<?>.MetaValueItem MICRO_WAFER_LITHOGRAPHY_PREP;
    public static MetaItem<?>.MetaValueItem NANO_WAFER_LITHOGRAPHY_PREP;
    public static MetaItem<?>.MetaValueItem IMC_WAFER_LITHOGRAPHY_PREP;
    public static MetaItem<?>.MetaValueItem OPTICAL_WAFER_LITHOGRAPHY_PREP;

    public static MetaItem<?>.MetaValueItem PREBAKED_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem PREBAKED_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem PREBAKED_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem PREBAKED_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem PREBAKED_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem TREATED_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem TREATED_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem TREATED_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem TREATED_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem TREATED_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem RAW_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem BAKED_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem BAKED_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem BAKED_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem BAKED_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem BAKED_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem NANO_WAFER;
    public static MetaItem<?>.MetaValueItem IMC_WAFER;
    public static MetaItem<?>.MetaValueItem OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem ETCHED_INTEGRATED_WAFER;
    public static MetaItem<?>.MetaValueItem ETCHED_MICRO_WAFER;
    public static MetaItem<?>.MetaValueItem ETCHED_NANO_WAFER;
    public static MetaItem<?>.MetaValueItem ETCHED_IMC_WAFER;
    public static MetaItem<?>.MetaValueItem ETCHED_OPTICAL_WAFER;

    public static MetaItem<?>.MetaValueItem INTEGRATED_CHIP;
    public static MetaItem<?>.MetaValueItem MICRO_CHIP;
    public static MetaItem<?>.MetaValueItem NANO_CHIP;
    public static MetaItem<?>.MetaValueItem IMC_CHIP;
    public static MetaItem<?>.MetaValueItem OPTICAL_CHIP;

    public static MetaItem<?>.MetaValueItem INTEGRATED_HARD_MASK;
    public static MetaItem<?>.MetaValueItem MICRO_HARD_MASK;
    public static MetaItem<?>.MetaValueItem NANO_HARD_MASK;
    public static MetaItem<?>.MetaValueItem IMC_HARD_MASK;
    public static MetaItem<?>.MetaValueItem OPTICAL_HARD_MASK;

    public static MetaItem<?>.MetaValueItem BALLAST;
    public static MetaItem<?>.MetaValueItem EMPTY_GEISSLER_TUBE;

    public static MetaItem<?>.MetaValueItem EMPTY_ARC_LAMP;

    public static MetaItem<?>.MetaValueItem LASER_TUBE;

    //Circuit Boards
    public static MetaItem<?>.MetaValueItem PRIMITIVE_PREBOARD;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_PREBOARD;
    public static MetaItem<?>.MetaValueItem INTEGRATED_PREBOARD;
    public static MetaItem<?>.MetaValueItem MICRO_PREBOARD;
    public static MetaItem<?>.MetaValueItem NANO_PREBOARD;
    public static MetaItem<?>.MetaValueItem IMC_PREBOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_PREBOARD;
    public static MetaItem<?>.MetaValueItem CRYSTAL_PREBOARD;
    public static MetaItem<?>.MetaValueItem BIOWARE_PREBOARD;
    public static MetaItem<?>.MetaValueItem WETWARE_PREBOARD;
    public static MetaItem<?>.MetaValueItem QUANTUM_PREBOARD;
    public static MetaItem<?>.MetaValueItem EXOTIC_PREBOARD;
    public static MetaItem<?>.MetaValueItem COSMIC_PREBOARD;
    public static MetaItem<?>.MetaValueItem SUPRA_PREBOARD;

    public static MetaItem<?>.MetaValueItem PRIMITIVE_BOARD;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_BOARD;
    public static MetaItem<?>.MetaValueItem INTEGRATED_BOARD;
    public static MetaItem<?>.MetaValueItem MICRO_BOARD;
    public static MetaItem<?>.MetaValueItem NANO_BOARD;
    public static MetaItem<?>.MetaValueItem IMC_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_BOARD;
    public static MetaItem<?>.MetaValueItem CRYSTAL_BOARD;
    public static MetaItem<?>.MetaValueItem BIOWARE_BOARD;
    public static MetaItem<?>.MetaValueItem WETWARE_BOARD;
    public static MetaItem<?>.MetaValueItem QUANTUM_BOARD;
    public static MetaItem<?>.MetaValueItem EXOTIC_BOARD;
    public static MetaItem<?>.MetaValueItem COSMIC_BOARD;
    public static MetaItem<?>.MetaValueItem SUPRA_BOARD;

    //Circuits
    public static MetaItem<?>.MetaValueItem PRIMITIVE_ASSEMBLY_ULV;
    public static MetaItem<?>.MetaValueItem PRIMITIVE_COMPUTER_LV;
    public static MetaItem<?>.MetaValueItem PRIMITIVE_MAINFRAME_MV;

    public static MetaItem<?>.MetaValueItem ELECTRONIC_PROCESSOR_ULV;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_ASSEMBLY_LV;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_COMPUTER_MV;
    public static MetaItem<?>.MetaValueItem ELECTRONIC_MAINFRAME_HV;

    public static MetaItem<?>.MetaValueItem INTEGRATED_PROCESSOR_LV;
    public static MetaItem<?>.MetaValueItem INTEGRATED_ASSEMBLY_MV;
    public static MetaItem<?>.MetaValueItem INTEGRATED_COMPUTER_HV;
    public static MetaItem<?>.MetaValueItem INTEGRATED_MAINFRAME_EV;

    public static MetaItem<?>.MetaValueItem MICRO_PROCESSOR_MV;
    public static MetaItem<?>.MetaValueItem MICRO_ASSEMBLY_HV;
    public static MetaItem<?>.MetaValueItem MICRO_COMPUTER_EV;
    public static MetaItem<?>.MetaValueItem MICRO_MAINFRAME_IV;

    public static MetaItem<?>.MetaValueItem NANO_PROCESSOR_HV;
    public static MetaItem<?>.MetaValueItem NANO_ASSEMBLY_EV;
    public static MetaItem<?>.MetaValueItem NANO_COMPUTER_IV;
    public static MetaItem<?>.MetaValueItem NANO_MAINFRAME_LUV;

    public static MetaItem<?>.MetaValueItem IMC_PROCESSOR_EV;
    public static MetaItem<?>.MetaValueItem IMC_ASSEMBLY_IV;
    public static MetaItem<?>.MetaValueItem IMC_COMPUTER_LUV;
    public static MetaItem<?>.MetaValueItem IMC_MAINFRAME_ZPM;

    public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR_IV;
    public static MetaItem<?>.MetaValueItem OPTICAL_ASSEMBLY_LUV;
    public static MetaItem<?>.MetaValueItem OPTICAL_COMPUTER_ZPM;
    public static MetaItem<?>.MetaValueItem OPTICAL_MAINFRAME_UV;

    public static MetaItem<?>.MetaValueItem CRYSTAL_PROCESSOR_LUV;
    public static MetaItem<?>.MetaValueItem CRYSTAL_ASSEMBLY_ZPM;
    public static MetaItem<?>.MetaValueItem CRYSTAL_COMPUTER_UV;
    public static MetaItem<?>.MetaValueItem CRYSTAL_MAINFRAME_UHV;

    public static MetaItem<?>.MetaValueItem QUANTUM_PROCESSOR_ZPM;
    public static MetaItem<?>.MetaValueItem QUANTUM_ASSEMBLY_UV;
    public static MetaItem<?>.MetaValueItem QUANTUM_COMPUTER_UHV;
    public static MetaItem<?>.MetaValueItem QUANTUM_MAINFRAME_UEV;

    public static MetaItem<?>.MetaValueItem WETWARE_PROCESSOR_UV;
    public static MetaItem<?>.MetaValueItem WETWARE_ASSEMBLY_UHV;
    public static MetaItem<?>.MetaValueItem WETWARE_COMPUTER_UEV;
    public static MetaItem<?>.MetaValueItem WETWARE_MAINFRAME_UIV;

    public static MetaItem<?>.MetaValueItem BIOWARE_PROCESSOR_UHV;
    public static MetaItem<?>.MetaValueItem BIOWARE_ASSEMBLY_UEV;
    public static MetaItem<?>.MetaValueItem BIOWARE_COMPUTER_UIV;
    public static MetaItem<?>.MetaValueItem BIOWARE_MAINFRAME_UXV;

    public static MetaItem<?>.MetaValueItem EXOTIC_PROCESSOR_UEV;
    public static MetaItem<?>.MetaValueItem EXOTIC_ASSEMBLY_UIV;
    public static MetaItem<?>.MetaValueItem EXOTIC_COMPUTER_UXV;
    public static MetaItem<?>.MetaValueItem EXOTIC_MAINFRAME_OPV;

    public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR_UIV;
    public static MetaItem<?>.MetaValueItem COSMIC_ASSEMBLY_UXV;
    public static MetaItem<?>.MetaValueItem COSMIC_COMPUTER_OPV;
    public static MetaItem<?>.MetaValueItem COSMIC_MAINFRAME_MAX;

    public static MetaItem<?>.MetaValueItem SUPRA_PROCESSOR_UXV;
    public static MetaItem<?>.MetaValueItem SUPRA_ASSEMBLY_OPV;
    public static MetaItem<?>.MetaValueItem SUPRA_COMPUTER_MAX;
    public static MetaItem<?>.MetaValueItem SUPRA_MAINFRAME_ALL;

    public static MetaItem<?>.MetaValueItem STENCILING_CUTHEAD;
    public static MetaItem<?>.MetaValueItem COPPER_LAMINATED_EPOXID;
    public static MetaItem<?>.MetaValueItem ELECTRUM_LAMINATED_EPOXID;
    public static MetaItem<?>.MetaValueItem GERMANIUM_LAMINATED_EPOXID;
    public static MetaItem<?>.MetaValueItem FIBERGLASS_MESH;
    public static MetaItem<?>.MetaValueItem ZBLANMATRIX;
    public static MetaItem<?>.MetaValueItem OPTICAL_BASE;
    public static MetaItem<?>.MetaValueItem LAMINATED_OPTICAL_BASE;
    public static MetaItem<?>.MetaValueItem SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem COATED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem DIRTY_COATED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem CLEANED_COATED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem SAPPHIRE_SUBSTRATE_PREP;
    public static MetaItem<?>.MetaValueItem ETCHED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem SUPERHEATED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem VIABLE_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem NONVIABLE_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem RECYCLED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem SINTERED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem WIRED_SAPPHIRE_WAFER;
    public static MetaItem<?>.MetaValueItem RAW_SAPPHIRE_CHIP;
    public static MetaItem<?>.MetaValueItem SAPPHIRE_CHIP;
    public static MetaItem<?>.MetaValueItem PROCESSED_CRYSTAL_WAFER;
    public static MetaItem<?>.MetaValueItem CRYSTAL_SFET_BUNDLE;
    public static MetaItem<?>.MetaValueItem CRYSTAL_SFET_WAFER;
    public static MetaItem<?>.MetaValueItem REFRACTING_SHEET;
    public static MetaItem<?>.MetaValueItem REFLECTING_SHEET;
    public static MetaItem<?>.MetaValueItem LAMINATED_CRYSTAL_PCB_SHEET;
    public static MetaItem<?>.MetaValueItem GAMMA_EMITTING_DIODE;
    public static MetaItem<?>.MetaValueItem SIMPLE_SILICON_WAFER;
    public static MetaItem<?>.MetaValueItem SIMPLE_CPU_WAFER;
    public static MetaItem<?>.MetaValueItem SIMPLE_CPU;
    public static MetaItem<?>.MetaValueItem FERROUS_INDUCTOR_CORE;
    public static MetaItem<?>.MetaValueItem TUNGSTEN_INDUCTOR_CORE;
    public static MetaItem<?>.MetaValueItem LANGMUIR_HOUSING;
    public static MetaItem<?>.MetaValueItem TRANSMON_SUPPORT;
    public static MetaItem<?>.MetaValueItem SQUID_BASE;
    public static MetaItem<?>.MetaValueItem LANGMUIR_OSCILATOR;
    public static MetaItem<?>.MetaValueItem GRAPHENE_ALUMINOSILICATE_AEROGEL;
    public static MetaItem<?>.MetaValueItem CNT_SHORT;
    public static MetaItem<?>.MetaValueItem CNT_LONG;
    public static MetaItem<?>.MetaValueItem STERILE_POLYMER_FOIL;
    public static MetaItem<?>.MetaValueItem LAYERED_POLYMER_FOIL;


    // Chips - Post Wetware

    public static MetaItem<?>.MetaValueItem WETWARE_CPU;
    public static MetaItem<?>.MetaValueItem BIOWARE_CPU;
    //already technically exists, do we want to use that item and change lang?
    public static MetaItem<?>.MetaValueItem QUANTUM_CPU;
    public static MetaItem<?>.MetaValueItem EXOTIC_CPU;
    public static MetaItem<?>.MetaValueItem COSMIC_CPU;
    public static MetaItem<?>.MetaValueItem SUPRA_CPU;
    public static MetaItem<?>.MetaValueItem SPUN_POLYACRYLONITRILE;
    public static MetaItem<?>.MetaValueItem WASHED_POLYACRLONITRILE;
    public static MetaItem<?>.MetaValueItem BAKED_POLYACRLONITRILE;
    public static MetaItem<?>.MetaValueItem OXIDIZED_CARBON_THREAD;
    public static MetaItem<?>.MetaValueItem ETCHED_CARBON_THREAD;
    public static MetaItem<?>.MetaValueItem COATED_CARBON_THREAD;
    public static MetaItem<?>.MetaValueItem WOVEN_CARBON_FIBER;
    public static MetaItem<?>.MetaValueItem THIN_WOVEN_CARBON_FIBER;
    public static MetaItem<?>.MetaValueItem CARBON_FIBER_PLATE;
    public static MetaItem<?>.MetaValueItem CARBON_FIBER_FOIL;

    public static MetaItem<?>.MetaValueItem EVACUATED_SYNTHETIC_DIAMOND;
    public static MetaItem<?>.MetaValueItem ANNEALED_NVC_PREPARATION;
    public static MetaItem<?>.MetaValueItem STRESSED_NVC_SHEET;
    public static MetaItem<?>.MetaValueItem NVC_CHIP;
    public static MetaItem<?>.MetaValueItem RABI_SENSOR;
    public static MetaItem<?>.MetaValueItem NVC_SENSOR;
    public static MetaItem<?>.MetaValueItem NVC_STORAGE_MODULE;
    public static MetaItem<?>.MetaValueItem MICROTUBE_INVERSE_FORM;
    public static MetaItem<?>.MetaValueItem COPPER_MICROTUBE_MATRIX;
    public static MetaItem<?>.MetaValueItem SUPERCOOLING_RADIATOR;
    public static MetaItem<?>.MetaValueItem SUPERCOOLING_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SUPERCOOLING_PORT;
    public static MetaItem<?>.MetaValueItem LAYERED_DATA_TRANSFER_PCB;
    public static MetaItem<?>.MetaValueItem DATA_TRANSFER_MASK;
    public static MetaItem<?>.MetaValueItem MASKED_DATA_TRANSFER_PCB;
    public static MetaItem<?>.MetaValueItem ETCHED_MASKED_DATA_TRANSFER_PCB;
    public static MetaItem<?>.MetaValueItem ETCHED_DATA_TRANSFER_PCB;
    public static MetaItem<?>.MetaValueItem UNITARY_MAPPING_SHEET;
    public static MetaItem<?>.MetaValueItem UNITARY_MEASUREMENT_MODULE;
    public static MetaItem<?>.MetaValueItem ANYON_BIT_REGISTER;
    public static MetaItem<?>.MetaValueItem WAVEFORM_LOGISTICS_BRIDGE;
    public static MetaItem<?>.MetaValueItem SMALL_GAAS_WAFER;
    public static MetaItem<?>.MetaValueItem FRACTIONAL_HALL_WAFER;
    public static MetaItem<?>.MetaValueItem FRACTIONAL_HALL_CHIP;
    public static MetaItem<?>.MetaValueItem FRACTIONAL_HALL_COMPLEX;
    public static MetaItem<?>.MetaValueItem NON_ABELIAN_ANYON_STRANDPLATE;
    public static MetaItem<?>.MetaValueItem MAGNETIC_STRANDPLATE_FORM;
    public static MetaItem<?>.MetaValueItem PRECISION_MAG_STIMULATION_SHEET;
    public static MetaItem<?>.MetaValueItem ANYON_BRAIDING_STRUCTURE;

    // Circuits
    // Gooware
    public static MetaItem<?>.MetaValueItem GOOWARE_PROCESSOR;
    public static MetaItem<?>.MetaValueItem GOOWARE_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem GOOWARE_COMPUTER;
    public static MetaItem<?>.MetaValueItem GOOWARE_MAINFRAME;

    // Optical
    public static MetaItem<?>.MetaValueItem OPTICAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem OPTICAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem OPTICAL_MAINFRAME;

    // Spintronic
    public static MetaItem<?>.MetaValueItem SPINTRONIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_MAINFRAME;

    // Cosmic, name TBD
    public static MetaItem<?>.MetaValueItem COSMIC_PROCESSOR;
    public static MetaItem<?>.MetaValueItem COSMIC_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem COSMIC_COMPUTER;
    public static MetaItem<?>.MetaValueItem COSMIC_MAINFRAME;

    // Supra-causal
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_COMPUTER;
    public static MetaItem<?>.MetaValueItem SUPRACAUSAL_MAINFRAME;

    // Supra-chronal
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_ULV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_LV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_MV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_HV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_EV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_IV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_LuV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_ZPM;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UHV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UEV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UIV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_UXV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_OpV;
    public static MetaItem<?>.MetaValueItem SUPRACHRONAL_MAX;

    // Primitive Circuit Components
    public static MetaItem<?>.MetaValueItem VACUUM_TUBE_COMPONENTS;

    // Crystal Circuit Components
    public static MetaItem<?>.MetaValueItem EU_DOPED_CUBIC_ZIRCONIA_BOULE;
    public static MetaItem<?>.MetaValueItem EU_DOPED_CUBIC_ZIRCONIA_WAFER;

    // Gooware Circuit Components
    public static MetaItem<?>.MetaValueItem BZ_REACTION_CHAMBER;
    public static MetaItem<?>.MetaValueItem NONLINEAR_CHEMICAL_OSCILLATOR;

    // Voltage Coils
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UHV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UEV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UIV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_UXV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_OpV;
    public static MetaItem<?>.MetaValueItem VOLTAGE_COIL_MAX;

    // Power Components
    public static MetaItem<?>.MetaValueItem NANO_POWER_IC_WAFER;
    public static MetaItem<?>.MetaValueItem PICO_POWER_IC_WAFER;
    public static MetaItem<?>.MetaValueItem FEMTO_POWER_IC_WAFER;
    public static MetaItem<?>.MetaValueItem NANO_POWER_IC;
    public static MetaItem<?>.MetaValueItem PICO_POWER_IC;
    public static MetaItem<?>.MetaValueItem FEMTO_POWER_IC;

    // Crafting Components
    public static MetaItem<?>.MetaValueItem COMPONENT_GRINDER_BORON_NITRIDE;

    // Process-Specific Components
    public static MetaItem<?>.MetaValueItem MAGNETRON;

    // Process Intermediary Items

    // Nanotubes
    public static MetaItem<?>.MetaValueItem CARBON_ALLOTROPE_MIXTURE;
    public static MetaItem<?>.MetaValueItem GRAPHENE_ALIGNED_CNT;

    public static void initMetaItems() {
        metaItem1 = new StandardMetaItem();
        metaItem1.setRegistryName("meta_item_gc");

        metaItem2 = new StandardMetaItem();
        metaItem2.setRegistryName("meta_item_gc_2");
    }

    public static void initSubitems() {
        initMetaItem1();
        if (GCConfig.Misc.enableTjcore) {
            tjcoreItems();
        }
    }

    private static void initMetaItem1() {
        //meme 0~9
        BAGUETTE_SWORD = metaItem1.addItem(0, "tool.baguette").addComponents(new BaguetteBehavior()).setMaxStackSize(1).setCreativeTabs(CommonProxy.Tab);

        //materal 10 ~ 199
        //algae(10 ~ 21)
        COMMON_ALGAE = metaItem1.addItem(10,"algae.common").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        GREEN_ALGAE = metaItem1.addItem(11,"algae.green").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        RED_ALGAE = metaItem1.addItem(12,"algae.red").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        BROWN_ALGAE = metaItem1.addItem(13,"algae.brown").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        GOLD_ALGAE = metaItem1.addItem(14,"algae.gold").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        T_ALGAE = metaItem1.addItem(15,"algae.t").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        tierItems();
        ADVANCED_PROCESS_CIRCUIT = metaItem1.addItem(38, "item.advanced_circuit").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
    }

    private static void tierItems() {
        //ulv cover(22 ~ 29)
        ULV_CONVEYOR_MODULE = metaItem1.addItem(22, "cover.conveyor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 2));
        }));
        ULV_ELECTRIC_PUMP = metaItem1.addItem(23, "cover.pump.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.electric.pump.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 1280 / 80));
        }));
        ULV_ELECTRIC_MOTOR = metaItem1.addItem(24, "cover.motor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_ELECTRIC_PISTON = metaItem1.addItem(25, "cover.piston.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_ROBOT_ARM = metaItem1.addItem(26, "cover.robotic_arm.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.robot.arm.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 2));
        }));
        ULV_EMITTER = metaItem1.addItem(27, "cover.emitter.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_SENSOR = metaItem1.addItem(28, "cover.sensor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        ULV_FIELD_GENERATOR = metaItem1.addItem(29, "cover.field_generator.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);

        //max cover(30~37)
        MAX_CONVEYOR_MODULE = metaItem1.addItem(30, "cover.conveyor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 16 * 64 * 2));
        }));
        MAX_ELECTRIC_PUMP = metaItem1.addItem(31, "cover.pump.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.electric.pump.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 * 2 / 80));
        }));
        MAX_ELECTRIC_MOTOR = metaItem1.addItem(32, "cover.motor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_ELECTRIC_PISTON = metaItem1.addItem(33, "cover.piston.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_ROBOT_ARM = metaItem1.addItem(34, "cover.robotic_arm.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.robot.arm.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 16 * 64 * 2));
        }));
        MAX_EMITTER = metaItem1.addItem(35, "cover.emitter.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_SENSOR = metaItem1.addItem(36, "cover.sensor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
        MAX_FIELD_GENERATOR = metaItem1.addItem(37, "cover.field_generator.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.Tab);
    }

    private static void tjcoreItems() {

        SMD_RESISTOR_1 = metaItem2.addItem(1, "component.smd_resistor_1").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_1 = metaItem2.addItem(2, "component.smd_transistor_1").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_1 = metaItem2.addItem(3, "component.smd_diode_1").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_1 = metaItem2.addItem(4, "component.smd_capacitor_1").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_1 = metaItem2.addItem(5, "component.smd_inductor_1").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_2 = metaItem2.addItem(6, "component.smd_resistor_2").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_2 = metaItem2.addItem(7, "component.smd_transistor_2").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_2 = metaItem2.addItem(8, "component.smd_diode_2").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_2 = metaItem2.addItem(9, "component.smd_capacitor_2").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_2 = metaItem2.addItem(10, "component.smd_inductor_2").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_3 = metaItem2.addItem(11, "component.smd_resistor_3").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_3 = metaItem2.addItem(12, "component.smd_transistor_3").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_3 = metaItem2.addItem(13, "component.smd_diode_3").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_3 = metaItem2.addItem(14, "component.smd_capacitor_3").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_3 = metaItem2.addItem(15, "component.smd_inductor_3").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_4 = metaItem2.addItem(16, "component.smd_resistor_4").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_4 = metaItem2.addItem(17, "component.smd_transistor_4").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_DIODE_4 = metaItem2.addItem(18, "component.smd_diode_4").setUnificationData(OrePrefix.component, Component.Diode);
        SMD_CAPACITOR_4 = metaItem2.addItem(19, "component.smd_capacitor_4").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_4 = metaItem2.addItem(20, "component.smd_inductor_4").setUnificationData(OrePrefix.component, Component.Inductor);

        SMD_RESISTOR_5 = metaItem2.addItem(21, "component.smd_resistor_5").setUnificationData(OrePrefix.component, Component.Resistor);
        SMD_TRANSISTOR_5 = metaItem2.addItem(22, "component.smd_transistor_5").setUnificationData(OrePrefix.component, Component.Transistor);
        SMD_CAPACITOR_5 = metaItem2.addItem(24, "component.smd_capacitor_5").setUnificationData(OrePrefix.component, Component.Capacitor);
        SMD_INDUCTOR_5 = metaItem2.addItem(25, "component.smd_inductor_5").setUnificationData(OrePrefix.component, Component.Inductor);
        SMD_DIODE_5 = metaItem2.addItem(26, "component.smd_diode_5").setUnificationData(OrePrefix.component, Component.Diode);
        // Misc. SMD ITEMS (27-49)

        FERROUS_INDUCTOR_CORE = metaItem2.addItem(27, "ferrous_inductor_core");
        TUNGSTEN_INDUCTOR_CORE = metaItem2.addItem(28, "tungsten_inductor_core");
        LANGMUIR_OSCILATOR = metaItem2.addItem(29, "langmuir_wave_oscilator");
        LANGMUIR_HOUSING = metaItem2.addItem(30, "langmuir_qbit_housing");
        SQUID_BASE = metaItem2.addItem(31, "squid_base");
        TRANSMON_SUPPORT = metaItem2.addItem(32, "transmon_support_system");
        GRAPHENE_ALUMINOSILICATE_AEROGEL = metaItem2.addItem(33, "graphene_aluminosilicate_aerogel");
        LAYERED_POLYMER_FOIL = metaItem2.addItem(34, "layered_polyer_foil");
        STERILE_POLYMER_FOIL = metaItem2.addItem(35, "sterile_polymer_foil");

        //Boards & Preboards (50-99)
        PRIMITIVE_PREBOARD = metaItem2.addItem(50, "primitive_preboard");
        ELECTRONIC_PREBOARD = metaItem2.addItem(51, "electronic_preboard");
        INTEGRATED_PREBOARD = metaItem2.addItem(52, "integrated_preboard");
        MICRO_PREBOARD = metaItem2.addItem(53, "micro_preboard");
        NANO_PREBOARD = metaItem2.addItem(54, "nano_preboard");
        IMC_PREBOARD = metaItem2.addItem(55, "imc_preboard");
        OPTICAL_PREBOARD = metaItem2.addItem(56, "optical_preboard");
        CRYSTAL_PREBOARD = metaItem2.addItem(57, "crystal_preboard");
        BIOWARE_PREBOARD = metaItem2.addItem(58, "bioware_preboard");
        WETWARE_PREBOARD = metaItem2.addItem(59, "wetware_preboard");
        QUANTUM_PREBOARD = metaItem2.addItem(60, "quantum_preboard");
        EXOTIC_PREBOARD = metaItem2.addItem(61, "exotic_preboard");
        COSMIC_PREBOARD = metaItem2.addItem(62, "cosmic_preboard");
        SUPRA_PREBOARD = metaItem2.addItem(63, "supra_preboard");

        PRIMITIVE_BOARD = metaItem2.addItem(64, "primitive_board");
        ELECTRONIC_BOARD = metaItem2.addItem(65, "electronic_board");
        INTEGRATED_BOARD = metaItem2.addItem(66, "integrated_board");
        MICRO_BOARD = metaItem2.addItem(67, "micro_board");
        NANO_BOARD = metaItem2.addItem(68, "nano_board");
        IMC_BOARD = metaItem2.addItem(69, "imc_board");
        OPTICAL_BOARD = metaItem2.addItem(70, "optical_board");
        CRYSTAL_BOARD = metaItem2.addItem(71, "crystal_board");
        BIOWARE_BOARD = metaItem2.addItem(72, "bioware_board");
        WETWARE_BOARD = metaItem2.addItem(73, "wetware_board");
        QUANTUM_BOARD = metaItem2.addItem(74, "quantum_board");
        EXOTIC_BOARD = metaItem2.addItem(75, "exotic_board");
        COSMIC_BOARD = metaItem2.addItem(76, "cosmic_board");
        SUPRA_BOARD = metaItem2.addItem(77, "supra_board");

        //Circuit Metaitems (100-199)
        PRIMITIVE_ASSEMBLY_ULV = metaItem2.addItem(100, "circuit.primitive_ulv").setUnificationData(OrePrefix.circuit, Tier.ULV);
        PRIMITIVE_COMPUTER_LV = metaItem2.addItem(101, "circuit.primitive_lv").setUnificationData(OrePrefix.circuit, Tier.LV);
        PRIMITIVE_MAINFRAME_MV = metaItem2.addItem(102, "circuit.primitive_mv").setUnificationData(OrePrefix.circuit, Tier.MV);

        ELECTRONIC_PROCESSOR_ULV = metaItem2.addItem(103, "circuit.electronic_ulv").setUnificationData(OrePrefix.circuit, Tier.ULV);
        ELECTRONIC_ASSEMBLY_LV = metaItem2.addItem(104, "circuit.electronic_lv").setUnificationData(OrePrefix.circuit, Tier.LV);
        ELECTRONIC_COMPUTER_MV = metaItem2.addItem(105, "circuit.electronic_mv").setUnificationData(OrePrefix.circuit, Tier.MV);
        ELECTRONIC_MAINFRAME_HV = metaItem2.addItem(106, "circuit.electronic_hv").setUnificationData(OrePrefix.circuit, Tier.HV);

        INTEGRATED_PROCESSOR_LV = metaItem2.addItem(107, "circuit.integrated_lv").setUnificationData(OrePrefix.circuit, Tier.LV);
        INTEGRATED_ASSEMBLY_MV = metaItem2.addItem(108, "circuit.integrated_mv").setUnificationData(OrePrefix.circuit, Tier.MV);
        INTEGRATED_COMPUTER_HV = metaItem2.addItem(109, "circuit.integrated_hv").setUnificationData(OrePrefix.circuit, Tier.HV);
        INTEGRATED_MAINFRAME_EV = metaItem2.addItem(110, "circuit.integrated_ev").setUnificationData(OrePrefix.circuit, Tier.EV);

        MICRO_PROCESSOR_MV = metaItem2.addItem(111, "circuit.micro_mv").setUnificationData(OrePrefix.circuit, Tier.MV);
        MICRO_ASSEMBLY_HV = metaItem2.addItem(112, "circuit.micro_hv").setUnificationData(OrePrefix.circuit, Tier.HV);
        MICRO_COMPUTER_EV = metaItem2.addItem(113, "circuit.micro_ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        MICRO_MAINFRAME_IV = metaItem2.addItem(114, "circuit.micro_iv").setUnificationData(OrePrefix.circuit, Tier.IV);

        NANO_PROCESSOR_HV = metaItem2.addItem(115, "circuit.nano_hv").setUnificationData(OrePrefix.circuit, Tier.HV);
        NANO_ASSEMBLY_EV = metaItem2.addItem(116, "circuit.nano_ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        NANO_COMPUTER_IV = metaItem2.addItem(117, "circuit.nano_iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        NANO_MAINFRAME_LUV = metaItem2.addItem(118, "circuit.nano_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);

        IMC_PROCESSOR_EV = metaItem2.addItem(119, "circuit.imc_ev").setUnificationData(OrePrefix.circuit, Tier.EV);
        IMC_ASSEMBLY_IV = metaItem2.addItem(120, "circuit.imc_iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        IMC_COMPUTER_LUV = metaItem2.addItem(121, "circuit.imc_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        IMC_MAINFRAME_ZPM = metaItem2.addItem(122, "circuit.imc_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);

        OPTICAL_PROCESSOR_IV = metaItem2.addItem(123, "circuit.optical_iv").setUnificationData(OrePrefix.circuit, Tier.IV);
        OPTICAL_ASSEMBLY_LUV = metaItem2.addItem(124, "circuit.optical_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        OPTICAL_COMPUTER_ZPM = metaItem2.addItem(125, "circuit.optical_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        OPTICAL_MAINFRAME_UV = metaItem2.addItem(126, "circuit.optical_uv").setUnificationData(OrePrefix.circuit, Tier.UV);

        CRYSTAL_PROCESSOR_LUV = metaItem2.addItem(127, "circuit.crystal_luv").setUnificationData(OrePrefix.circuit, Tier.LuV);
        CRYSTAL_ASSEMBLY_ZPM = metaItem2.addItem(128, "circuit.crystal_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        CRYSTAL_COMPUTER_UV = metaItem2.addItem(129, "circuit.crystal_uv").setUnificationData(OrePrefix.circuit, Tier.UV);
        CRYSTAL_MAINFRAME_UHV = metaItem2.addItem(130, "circuit.crystal_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);

        QUANTUM_PROCESSOR_ZPM = metaItem2.addItem(131, "circuit.quantum_zpm").setUnificationData(OrePrefix.circuit, Tier.ZPM);
        QUANTUM_ASSEMBLY_UV = metaItem2.addItem(132, "circuit.quantum_uv").setUnificationData(OrePrefix.circuit, Tier.UV);
        QUANTUM_COMPUTER_UHV = metaItem2.addItem(133, "circuit.quantum_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);
        QUANTUM_MAINFRAME_UEV = metaItem2.addItem(134, "circuit.quantum_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);

        WETWARE_PROCESSOR_UV = metaItem2.addItem(135, "circuit.wetware_uv").setUnificationData(OrePrefix.circuit, Tier.UV);
        WETWARE_ASSEMBLY_UHV = metaItem2.addItem(136, "circuit.wetware_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);
        WETWARE_COMPUTER_UEV = metaItem2.addItem(137, "circuit.wetware_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);
        WETWARE_MAINFRAME_UIV = metaItem2.addItem(138, "circuit.wetware_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);

        BIOWARE_PROCESSOR_UHV = metaItem2.addItem(139, "circuit.bioware_uhv").setUnificationData(OrePrefix.circuit, Tier.UHV);
        BIOWARE_ASSEMBLY_UEV = metaItem2.addItem(140, "circuit.bioware_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);
        BIOWARE_COMPUTER_UIV = metaItem2.addItem(141, "circuit.bioware_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        BIOWARE_MAINFRAME_UXV = metaItem2.addItem(142, "circuit.bioware_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);

        EXOTIC_PROCESSOR_UEV = metaItem2.addItem(143, "circuit.exotic_uev").setUnificationData(OrePrefix.circuit, Tier.UEV);
        EXOTIC_ASSEMBLY_UIV = metaItem2.addItem(144, "circuit.exotic_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        EXOTIC_COMPUTER_UXV = metaItem2.addItem(145, "circuit.exotic_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        EXOTIC_MAINFRAME_OPV = metaItem2.addItem(146, "circuit.exotic_opv").setUnificationData(OrePrefix.circuit, Tier.OpV);

        COSMIC_PROCESSOR_UIV = metaItem2.addItem(147, "circuit.cosmic_uiv").setUnificationData(OrePrefix.circuit, Tier.UIV);
        COSMIC_ASSEMBLY_UXV = metaItem2.addItem(148, "circuit.cosmic_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        COSMIC_COMPUTER_OPV = metaItem2.addItem(149, "circuit.cosmic_opv").setUnificationData(OrePrefix.circuit, Tier.OpV);
        COSMIC_MAINFRAME_MAX = metaItem2.addItem(150, "circuit.cosmic_max").setUnificationData(OrePrefix.circuit, Tier.MAX);

        SUPRA_PROCESSOR_UXV = metaItem2.addItem(151, "circuit.supra_uxv").setUnificationData(OrePrefix.circuit, Tier.UXV);
        SUPRA_ASSEMBLY_OPV = metaItem2.addItem(152, "circuit.supra_opv").setUnificationData(OrePrefix.circuit, Tier.OpV);
        SUPRA_COMPUTER_MAX = metaItem2.addItem(153, "circuit.supra_max").setUnificationData(OrePrefix.circuit, Tier.MAX);
        SUPRA_MAINFRAME_ALL = metaItem2.addItem(154, "circuit.supra_all")
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
        WETPHENOLICPULP = metaItem2.addItem(300, "wetphenolicpulp");
        WETPRESSEDPHENOLICSUBSTRATE = metaItem2.addItem(301, "wetpressedphenolicsubstrate");
        COPPER_LAMINATED_EPOXID = metaItem2.addItem(302, "copper_laminated_epoxid");
        ELECTRUM_LAMINATED_EPOXID = metaItem2.addItem(303, "electrum_laminated_epoxid");
        GERMANIUM_LAMINATED_EPOXID = metaItem2.addItem(304, "germanium_laminated_epoxid");
        FIBERGLASS_MESH = metaItem2.addItem(305, "fiber_glass_mesh");
        ZBLANMATRIX = metaItem2.addItem(306, "zblan_matrix");
        OPTICAL_BASE = metaItem2.addItem(307, "optical_base");
        LAMINATED_OPTICAL_BASE = metaItem2.addItem(308, "laminated_optical_base");
        PROCESSED_CRYSTAL_WAFER = metaItem2.addItem(309, "processed_crystal_wafer");
        CRYSTAL_SFET_BUNDLE = metaItem2.addItem(310, "crystal_sfet_bundle");
        CRYSTAL_SFET_WAFER = metaItem2.addItem(311, "crystal_sfet_wafer");
        REFRACTING_SHEET = metaItem2.addItem(312, "refracting_sheet");
        LAMINATED_CRYSTAL_PCB_SHEET = metaItem2.addItem(313, "laminated_crystal_pcb_sheet");
        GAMMA_EMITTING_DIODE = metaItem2.addItem(314, "gamma_emitting_diode");
        REFLECTING_SHEET = metaItem2.addItem(315, "reflecting_sheet");


        //Lithography Metaitems (500-597)
        SILICON_BOULE = metaItem2.addItem(500, "silicon_boule");
        ANTIMONY_DOPED_SILICON_BOULE = metaItem2.addItem(501, "antimony_doped_silicon_boule");
        BORON_DOPED_SILICON_BOULE = metaItem2.addItem(502, "boron_doped_silicon_boule");
        GALLIUM_ARSENIDE_BOULE = metaItem2.addItem(503, "gallium_arsenide_boule");
        SILVER_GALLIUM_SELENIDE_BOULE = metaItem2.addItem(504, "silver_gallium_selenide_boule");

        SILICON_WAFER = metaItem2.addItem(505, "silicon_wafer");
        ANTIMONY_DOPED_SILICON_WAFER = metaItem2.addItem(506, "antimony_doped_silicon_wafer");
        BORON_DOPED_SILICON_WAFER = metaItem2.addItem(507, "boron_doped_silicon_wafer");
        GALLIUM_ARSENIDE_WAFER = metaItem2.addItem(508, "gallium_arsenide_wafer");
        SILVER_GALLIUM_SELENIDE_WAFER = metaItem2.addItem(509, "silver_gallium_selenide_wafer");

        LAYERED_SILICON_WAFER = metaItem2.addItem(510, "layered_silicon_wafer");
        LAYERED_ANTIMONY_DOPED_SILICON_WAFER = metaItem2.addItem(511, "layered_antimony_doped_silicon_wafer");
        LAYERED_BORON_DOPED_SILICON_WAFER = metaItem2.addItem(512, "layered_boron_doped_silicon_wafer");
        LAYERED_GALLIUM_ARSENIDE_WAFER = metaItem2.addItem(513, "layered_gallium_arsenide_wafer");
        LAYERED_SILVER_GALLIUM_SELENIDE_WAFER = metaItem2.addItem(514, "layered_silver_gallium_selenide_wafer");

        PREPARED_SILICON_WAFER = metaItem2.addItem(515, "prepared_silicon_wafer");
        PREPARED_ANTIMONY_DOPED_SILICON_WAFER = metaItem2.addItem(516, "prepared_antimony_doped_silicon_wafer");
        PREPARED_BORON_DOPED_SILICON_WAFER = metaItem2.addItem(517, "prepared_boron_doped_silicon_wafer");
        PREPARED_GALLIUM_ARSENIDE_WAFER = metaItem2.addItem(518, "prepared_gallium_arsenide_wafer");
        PREPARED_SILVER_GALLIUM_SELENIDE_WAFER = metaItem2.addItem(519, "prepared_silver_gallium_selenide_wafer");

        INTEGRATED_WAFER_LITHOGRAPHY_PREP = metaItem2.addItem(520, "integrated_wafer_lithography_prep");
        MICRO_WAFER_LITHOGRAPHY_PREP = metaItem2.addItem(521, "micro_wafer_lithography_prep");
        NANO_WAFER_LITHOGRAPHY_PREP = metaItem2.addItem(522, "nano_wafer_lithography_prep");
        IMC_WAFER_LITHOGRAPHY_PREP = metaItem2.addItem(523, "imc_wafer_lithography_prep");
        OPTICAL_WAFER_LITHOGRAPHY_PREP = metaItem2.addItem(524, "optical_wafer_lithography_prep");

        PREBAKED_INTEGRATED_WAFER = metaItem2.addItem(525, "prebaked_integrated_wafer");
        PREBAKED_MICRO_WAFER = metaItem2.addItem(526, "prebaked_micro_wafer");
        PREBAKED_NANO_WAFER = metaItem2.addItem(527, "prebaked_nano_wafer");
        PREBAKED_IMC_WAFER = metaItem2.addItem(528, "prebaked_imc_wafer");
        PREBAKED_OPTICAL_WAFER = metaItem2.addItem(529, "prebaked_optical_wafer");

        TREATED_INTEGRATED_WAFER = metaItem2.addItem(530, "treated_integrated_wafer");
        TREATED_MICRO_WAFER = metaItem2.addItem(531, "treated_micro_wafer");
        TREATED_NANO_WAFER = metaItem2.addItem(532, "treated_nano_wafer");
        TREATED_IMC_WAFER = metaItem2.addItem(533, "treated_imc_wafer");
        TREATED_OPTICAL_WAFER = metaItem2.addItem(534, "treated_optical_wafer");

        RAW_INTEGRATED_WAFER = metaItem2.addItem(535, "raw_integrated_wafer");
        RAW_MICRO_WAFER = metaItem2.addItem(536, "raw_micro_wafer");
        RAW_NANO_WAFER = metaItem2.addItem(537, "raw_nano_wafer");
        RAW_IMC_WAFER = metaItem2.addItem(538, "raw_imc_wafer");
        RAW_OPTICAL_WAFER = metaItem2.addItem(539, "raw_optical_wafer");

        BAKED_INTEGRATED_WAFER = metaItem2.addItem(540, "baked_integrated_wafer");
        BAKED_MICRO_WAFER = metaItem2.addItem(541, "baked_micro_wafer");
        BAKED_NANO_WAFER = metaItem2.addItem(542, "baked_nano_wafer");
        BAKED_IMC_WAFER = metaItem2.addItem(543, "baked_imc_wafer");
        BAKED_OPTICAL_WAFER = metaItem2.addItem(544, "baked_optical_wafer");

        INTEGRATED_WAFER = metaItem2.addItem(545, "integrated_wafer");
        MICRO_WAFER = metaItem2.addItem(546, "micro_wafer");
        NANO_WAFER = metaItem2.addItem(547, "nano_wafer");
        IMC_WAFER = metaItem2.addItem(548, "imc_wafer");
        OPTICAL_WAFER = metaItem2.addItem(549, "optical_wafer");

        ETCHED_INTEGRATED_WAFER = metaItem2.addItem(550, "etched_integrated_wafer");
        ETCHED_MICRO_WAFER = metaItem2.addItem(551, "etched_micro_wafer");
        ETCHED_NANO_WAFER = metaItem2.addItem(552, "etched_nano_wafer");
        ETCHED_IMC_WAFER = metaItem2.addItem(553, "etched_imc_wafer");
        ETCHED_OPTICAL_WAFER = metaItem2.addItem(554, "etched_optical_wafer");

        INTEGRATED_CHIP = metaItem2.addItem(555, "integrated_chip");
        MICRO_CHIP = metaItem2.addItem(556, "micro_chip");
        NANO_CHIP = metaItem2.addItem(557, "nano_chip");
        IMC_CHIP = metaItem2.addItem(558, "imc_chip");
        OPTICAL_CHIP = metaItem2.addItem(559, "optical_chip");

        INTEGRATED_HARD_MASK = metaItem2.addItem(560, "integrated_hard_mask");
        MICRO_HARD_MASK = metaItem2.addItem(561, "micro_hard_mask");
        NANO_HARD_MASK = metaItem2.addItem(562, "nano_hard_mask");
        IMC_HARD_MASK = metaItem2.addItem(563, "imc_hard_mask");
        OPTICAL_HARD_MASK = metaItem2.addItem(564, "optical_hard_mask");

        UVEMITTER_A = metaItem2.addItem(565, "uvemitter_a");
        UVEMITTER_B = metaItem2.addItem(566, "uvemitter_b");
        UVEMITTER_C = metaItem2.addItem(567, "uvemitter_c");
        UVEMITTER_D = metaItem2.addItem(568, "uvemitter_d");
        UVEMITTER_E = metaItem2.addItem(569, "uvemitter_e");

        BALLAST = metaItem2.addItem(570, "ballast");
        EMPTY_GEISSLER_TUBE = metaItem2.addItem(571, "empty_geissler_tube");
        EMPTY_ARC_LAMP = metaItem2.addItem(572, "empty_arc_lamp");
        LASER_TUBE = metaItem2.addItem(573, "laser_tube");
        STENCILING_CUTHEAD = metaItem2.addItem(574, "stencil_cutting_head");

        // Chip Metaitems Excluding Lithography (598-999)

        //Primitive Chip
        EVACUATED_TUBE = metaItem2.addItem(598, "evacuated_glass_tube");
        VACUUM_TUBE = metaItem2.addItem(599, "vacuum_tube");

        // Electronic Chip
        SIMPLE_SILICON_WAFER = metaItem2.addItem(600, "simple_silicon_wafer");
        SIMPLE_CPU_WAFER = metaItem2.addItem(601, "simple_cpu_wafer");
        SIMPLE_CPU = metaItem2.addItem(602, "simple_cpu");

        // Sapphire Chip
        COATED_SAPPHIRE_WAFER = metaItem2.addItem(603, "coated_sapphire_wafer");
        DIRTY_COATED_SAPPHIRE_WAFER = metaItem2.addItem(604, "dirty_coated_sapphire_wafer");
        CLEANED_COATED_SAPPHIRE_WAFER = metaItem2.addItem(605, "cleaned_coated_sapphire_wafer");
        SAPPHIRE_SUBSTRATE_PREP = metaItem2.addItem(606, "sapphire_substrate_prep");
        ETCHED_SAPPHIRE_WAFER = metaItem2.addItem(607, "etched_sapphire_wafer");
        SUPERHEATED_SAPPHIRE_WAFER = metaItem2.addItem(608, "superheated_sapphire_wafer");
        VIABLE_SAPPHIRE_WAFER = metaItem2.addItem(609, "viable_sapphire_wafer");
        NONVIABLE_SAPPHIRE_WAFER = metaItem2.addItem(610, "nonviable_sapphire_wafer");
        RECYCLED_SAPPHIRE_WAFER = metaItem2.addItem(611, "recycled_sapphire_wafer");
        SINTERED_SAPPHIRE_WAFER = metaItem2.addItem(612, "sintered_sapphire_wafer");
        WIRED_SAPPHIRE_WAFER = metaItem2.addItem(613, "wired_sapphire_wafer");
        SAPPHIRE_WAFER = metaItem2.addItem(614, "sapphire_wafer");
        RAW_SAPPHIRE_CHIP = metaItem2.addItem(615, "raw_crystal_chip");
        SAPPHIRE_CHIP = metaItem2.addItem(616, "sapphire_chip");

        //Quantum CPU
        EVACUATED_SYNTHETIC_DIAMOND = metaItem2.addItem(617, "evacuated_synthetic_diamond");
        ANNEALED_NVC_PREPARATION = metaItem2.addItem(618, "annealed_nvc_prep");
        STRESSED_NVC_SHEET = metaItem2.addItem(619, "stressed_nvc_sheet");
        NVC_CHIP = metaItem2.addItem(620, "nvc_chip");
        RABI_SENSOR = metaItem2.addItem(621, "rabi_sensor");
        NVC_SENSOR = metaItem2.addItem(622, "nvc_sensor");
        NVC_STORAGE_MODULE = metaItem2.addItem(623, "nvc_storage_module");
        LAYERED_DATA_TRANSFER_PCB = metaItem2.addItem(624, "layered_data_pcb");
        DATA_TRANSFER_MASK = metaItem2.addItem(625, "data_mask");
        MASKED_DATA_TRANSFER_PCB = metaItem2.addItem(626, "masked_data_pcb");
        ETCHED_MASKED_DATA_TRANSFER_PCB = metaItem2.addItem(627, "etched_masked_data_pcb");
        ETCHED_DATA_TRANSFER_PCB = metaItem2.addItem(628, "etched_data_pcb");
        UNITARY_MAPPING_SHEET = metaItem2.addItem(629, "unitary_mapping_sheet");
        UNITARY_MEASUREMENT_MODULE = metaItem2.addItem(630, "unitary_measurement_module");
        ANYON_BIT_REGISTER = metaItem2.addItem(631, "anyon_bit_register");
        WAVEFORM_LOGISTICS_BRIDGE = metaItem2.addItem(632, "waveform_logistics_bridge");
        SMALL_GAAS_WAFER = metaItem2.addItem(633, "small_gallium_arsenide_wafer");
        FRACTIONAL_HALL_WAFER = metaItem2.addItem(634, "fractional_hall_wafer");
        FRACTIONAL_HALL_CHIP = metaItem2.addItem(635, "fractional_hall_chip");
        FRACTIONAL_HALL_COMPLEX = metaItem2.addItem(636, "fractional_hall_complex");
        NON_ABELIAN_ANYON_STRANDPLATE = metaItem2.addItem(637, "anyon_strandplate");
        MAGNETIC_STRANDPLATE_FORM = metaItem2.addItem(638, "magnetic_strandplate_form");
        PRECISION_MAG_STIMULATION_SHEET = metaItem2.addItem(639, "magnetic_stimulation_sheet");
        ANYON_BRAIDING_STRUCTURE = metaItem2.addItem(640, "anyon_braiding_structure");
        QUANTUM_CPU = metaItem2.addItem(641, "quantum_cpu");


        WETWARE_CPU = metaItem2.addItem(995, "wetware_cpu");

        BIOWARE_CPU = metaItem2.addItem(996, "bioware_cpu");

        EXOTIC_CPU = metaItem2.addItem(997, "exotic_cpu");

        COSMIC_CPU = metaItem2.addItem(998, "cosmic_cpu");

        SUPRA_CPU = metaItem2.addItem(999, "supra_cpu");

        // Chemistry Intermediates (1000-1249)
        SPUN_POLYACRYLONITRILE = metaItem2.addItem(1000, "spun_polyacrylonitrile");
        WASHED_POLYACRLONITRILE = metaItem2.addItem(1001, "washed_polyacrylonitrile");
        BAKED_POLYACRLONITRILE = metaItem2.addItem(1002, "baked_polyacrylonitrile");
        OXIDIZED_CARBON_THREAD = metaItem2.addItem(1003, "oxidized_carbon_thread");
        ETCHED_CARBON_THREAD = metaItem2.addItem(1004, "etched_carbon_thread");
        COATED_CARBON_THREAD = metaItem2.addItem(1005, "coated_carbon_thread");
        WOVEN_CARBON_FIBER = metaItem2.addItem(1006, "woven_carbon_fiber");
        THIN_WOVEN_CARBON_FIBER = metaItem2.addItem(1007, "thin_woven_carbon_fiber");

        // Chemistry End Products (1250-1299)
        CNT_SHORT = metaItem2.addItem(1250, "short_carbon_nanotube_strand");
        CNT_LONG = metaItem2.addItem(1251, "long_carbon_nanotube_strand");
        CARBON_FIBER_PLATE = metaItem2.addItem(1252, "carbon_fiber_plate");
        CARBON_FIBER_FOIL = metaItem2.addItem(1253, "carbon_fiber_foil");

        // Microcrafting + Components (1300-1499)
        STEAM_MOTOR = metaItem2.addItem(1300, "steam_motor");
        STEAM_PISTON = metaItem2.addItem(1301, "steam_piston");
        STEAM_PUMP = metaItem2.addItem(1302, "steam_pump");
        CLEANROOM_FILTER = metaItem2.addItem(1303, "cleanroom_filter");
        MICROTUBE_INVERSE_FORM = metaItem2.addItem(1304, "microtube_inverse_form");
        COPPER_MICROTUBE_MATRIX = metaItem2.addItem(1305, "copper_microtube_matrix");
        SUPERCOOLING_RADIATOR = metaItem2.addItem(1306, "supercooling_radiator");
        SUPERCOOLING_ASSEMBLY = metaItem2.addItem(1307, "supercooling_assembly");
        SUPERCOOLING_PORT = metaItem2.addItem(1308, "supercooling_port");

        GOOWARE_PROCESSOR = metaItem2.addItem(0, "circuit.gooware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        GOOWARE_ASSEMBLY = metaItem2.addItem(1, "circuit.gooware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        GOOWARE_COMPUTER = metaItem2.addItem(2, "circuit.gooware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        GOOWARE_MAINFRAME = metaItem2.addItem(3, "circuit.gooware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);

        OPTICAL_PROCESSOR = metaItem2.addItem(4,"circuit.optical_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        OPTICAL_ASSEMBLY = metaItem2.addItem(5,"circuit.optical_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        OPTICAL_COMPUTER = metaItem2.addItem(6,"circuit.optical_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        OPTICAL_MAINFRAME = metaItem2.addItem(7,"circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);

        SPINTRONIC_PROCESSOR = metaItem2.addItem(8, "circuit.spintronic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SPINTRONIC_ASSEMBLY = metaItem2.addItem(9, "circuit.spintronic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SPINTRONIC_COMPUTER = metaItem2.addItem(10, "circuit.spintronic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SPINTRONIC_MAINFRAME = metaItem2.addItem(11, "circuit.spintronic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);

        COSMIC_PROCESSOR = metaItem2.addItem(12, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        COSMIC_ASSEMBLY = metaItem2.addItem(13, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        COSMIC_COMPUTER = metaItem2.addItem(14, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        COSMIC_MAINFRAME = metaItem2.addItem(15, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);

        SUPRACAUSAL_PROCESSOR = metaItem2.addItem(16, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACAUSAL_ASSEMBLY = metaItem2.addItem(17, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACAUSAL_COMPUTER = metaItem2.addItem(18, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACAUSAL_MAINFRAME = metaItem2.addItem(19, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        SUPRACHRONAL_ULV = metaItem2.addItem(20, "circuit.suprachronal.ulv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ULV);
        SUPRACHRONAL_LV = metaItem2.addItem(21, "circuit.suprachronal.lv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LV);
        SUPRACHRONAL_MV = metaItem2.addItem(22, "circuit.suprachronal.mv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MV);
        SUPRACHRONAL_HV = metaItem2.addItem(23, "circuit.suprachronal.hv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.HV);
        SUPRACHRONAL_EV = metaItem2.addItem(24, "circuit.suprachronal.ev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.EV);
        SUPRACHRONAL_IV = metaItem2.addItem(25, "circuit.suprachronal.iv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.IV);
        SUPRACHRONAL_LuV = metaItem2.addItem(26, "circuit.suprachronal.luv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LuV);
        SUPRACHRONAL_ZPM = metaItem2.addItem(27, "circuit.suprachronal.zpm").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        SUPRACHRONAL_UV = metaItem2.addItem(28, "circuit.suprachronal.uv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        SUPRACHRONAL_UHV = metaItem2.addItem(29, "circuit.suprachronal.uhv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SUPRACHRONAL_UEV = metaItem2.addItem(30, "circuit.suprachronal.uev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        SUPRACHRONAL_UIV = metaItem2.addItem(31, "circuit.suprachronal.uiv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        SUPRACHRONAL_UXV = metaItem2.addItem(32, "circuit.suprachronal.uxv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        SUPRACHRONAL_OpV = metaItem2.addItem(33, "circuit.suprachronal.opv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        SUPRACHRONAL_MAX = metaItem2.addItem(34, "circuit.suprachronal.max").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        // Primitive Circuit Components: ID 50-59
        VACUUM_TUBE_COMPONENTS = metaItem2.addItem(51, "vacuum_tube.components").setInvisible(GCConfig.circuitOverrides.harderVacuumTubes);

        // Electronic Circuit Components: ID 60-69


        // Micro Circuit Components: ID 70-89


        // Nano Circuit Components: ID 90-109


        // Quantum Circuit Components: ID 110-129


        // Crystal Circuit Components: ID 130-159
        EU_DOPED_CUBIC_ZIRCONIA_BOULE = metaItem2.addItem(130, "boule.cubic_zirconia.europium");
        EU_DOPED_CUBIC_ZIRCONIA_WAFER = metaItem2.addItem(131, "wafer.cubic_zirconia.europium");

        // Wetware Circuit Components: ID 160-179


        // Gooware Circuit Components: ID 180-199
        BZ_REACTION_CHAMBER = metaItem2.addItem(180, "reaction_chamber.bz");
        NONLINEAR_CHEMICAL_OSCILLATOR = metaItem2.addItem(181, "nonlinear_chemical_oscillator");

        // Cosmic Circuit Components: ID 240-259


        // Supra-Causal Circuit Components: ID 260-299


        // Supra-Chronal Circuit Components: ID 300-349


        // Voltage Coils: ID 350-355
        VOLTAGE_COIL_UHV = metaItem2.addItem(350, "voltage_coil.uhv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UEV = metaItem2.addItem(351, "voltage_coil.uev").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UIV = metaItem2.addItem(352, "voltage_coil.uiv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UXV = metaItem2.addItem(353, "voltage_coil.uxv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_OpV = metaItem2.addItem(354, "voltage_coil.opv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_MAX = metaItem2.addItem(355, "voltage_coil.max").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));

        // Power Components: ID 356-379
        NANO_POWER_IC_WAFER = metaItem2.addItem(356, "wafer.nano_power_integrated_circuit");
        PICO_POWER_IC_WAFER = metaItem2.addItem(357, "wafer.pico_power_integrated_circuit");
        FEMTO_POWER_IC_WAFER = metaItem2.addItem(358, "wafer.femto_power_integrated_circuit");
        NANO_POWER_IC = metaItem2.addItem(368, "plate.nano_power_integrated_circuit");
        PICO_POWER_IC = metaItem2.addItem(369, "plate.pico_power_integrated_circuit");
        FEMTO_POWER_IC = metaItem2.addItem(370, "plate.femto_power_integrated_circuit");

        // Simple Machine Crafting Components: ID 480-499
        COMPONENT_GRINDER_BORON_NITRIDE = metaItem2.addItem(480, "component.grinder.boron_nitride")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCMaterials.CubicBoronNitride, M * 4), new MaterialStack(GCMaterials.Vibranium, M * 8), new MaterialStack(GCMaterials.CubicHeterodiamond, M)));

        // Process-Specific Components: ID 500-999
        MAGNETRON = metaItem2.addItem(500, "magnetron");

        // Process Intermediary Items: ID 1000-1999
        CARBON_ALLOTROPE_MIXTURE = metaItem2.addItem(1000, "mixture.carbon_allotrope");
        GRAPHENE_ALIGNED_CNT = metaItem2.addItem(1001, "cnt.graphene_aligned");
    }
}
