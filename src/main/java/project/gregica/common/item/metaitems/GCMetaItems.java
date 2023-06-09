package project.gregica.common.item.metaitems;

import gregtech.api.GTValues;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.items.behaviors.TooltipBehavior;
import project.gregica.module.gcys.api.unification.materials.material.GCYSMaterials;
import project.gregica.common.item.behavior.BaguetteBehavior;
import project.gregica.common.item.behavior.ColorApplicatorBehavior;
import project.gregica.common.item.behavior.IntBcircuitBehavior;
import project.gregica.common.item.behavior.MillBallBehavior;
import project.gregica.api.CommonProxy;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import static gregtech.api.GTValues.M;

public class GCMetaItems {
    private static StandardMetaItem metaItem1;
    private static StandardMetaItem metaItem2;
    
    //Only for colorApplicator now
    //涉及染色 你可能不会想在其他地方用它
    public static StandardMetaItem metaItem3;


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
    public static MetaItem<?>.MetaValueItem BIOLOGY_INTEGRATED_CIRCUIT;
    public static MetaItem<?>.MetaValueItem ADVANCED_INTEGRATED_CIRCUIT;

    public static MetaItem<?>.MetaValueItem ROUGH_BIOLOGY_RESIN;
    public static MetaItem<?>.MetaValueItem PURIFIED_ALUMINIUM_MIXTURE;
    public static MetaItem<?>.MetaValueItem CELLULOSE_PULP;
    public static MetaItem<?>.MetaValueItem CELLULOSE_FIBER;
    public static MetaItem<?>.MetaValueItem CELLULOSE_FIBER_RED;
    public static MetaItem<?>.MetaValueItem CELLULOSE_FIBER_YELLOW;
    public static MetaItem<?>.MetaValueItem PINE_CONE;
    public static MetaItem<?>.MetaValueItem PINE_FRAGMENT;
    public static MetaItem<?>.MetaValueItem COMPOST;
    public static MetaItem<?>.MetaValueItem ALGAE_ACID;
    public static MetaItem<?>.MetaValueItem WOOD_PELLETS;
    public static MetaItem<?>.MetaValueItem PELLETS_MOULD;
    public static MetaItem<?>.MetaValueItem ALUMINIUM_PELLETS;

    public static MetaItem<?>.MetaValueItem GRINDBALL_SOAPSTONE;
    public static MetaItem<?>.MetaValueItem GRINDBALL_ALUMINIUM;

    public static MetaItem<?>.MetaValueItem SODIUM_ETHYLATE;
    public static MetaItem<?>.MetaValueItem POTASSIUM_ETHYLATE;

    public static MetaItem<?>.MetaValueItem SODIUM_ETHYLXANTHATE;
    public static MetaItem<?>.MetaValueItem POTASSIUM_ETHYLXANTHATE;

    //GCYS Items
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

    // Primitive Circuit Components
    public static MetaItem<?>.MetaValueItem VACUUM_TUBE_COMPONENTS;

    // Crystal Circuit Components
    public static MetaItem<?>.MetaValueItem EU_DOPED_CUBIC_ZIRCONIA_BOULE;
    public static MetaItem<?>.MetaValueItem EU_DOPED_CUBIC_ZIRCONIA_WAFER;
    public static MetaItem<?>.MetaValueItem CRYSTAL_INTERFACE_WAFER;
    public static MetaItem<?>.MetaValueItem CRYSTAL_INTERFACE_CHIP;
    public static MetaItem<?>.MetaValueItem ENGRAVED_RUBY_CRYSTAL_CHIP;
    public static MetaItem<?>.MetaValueItem ENGRAVED_SAPPHIRE_CRYSTAL_CHIP;
    public static MetaItem<?>.MetaValueItem ENGRAVED_DIAMOND_CRYSTAL_CHIP;
    public static MetaItem<?>.MetaValueItem CRYSTAL_MODULATOR_RUBY;
    public static MetaItem<?>.MetaValueItem CRYSTAL_MODULATOR_DIAMOND;
    public static MetaItem<?>.MetaValueItem CRYSTAL_MODULATOR_SAPPHIRE;
    public static MetaItem<?>.MetaValueItem CRYSTAL_SYSTEM_ON_CHIP_SOCKET;

    // Gooware Circuit Components
    public static MetaItem<?>.MetaValueItem BZ_REACTION_CHAMBER;
    public static MetaItem<?>.MetaValueItem NONLINEAR_CHEMICAL_OSCILLATOR;

    // Optical Circuit Components
    public static MetaItem<?>.MetaValueItem PHASE_CHANGE_MEMORY;
    public static MetaItem<?>.MetaValueItem OPTICAL_FIBER;
    public static MetaItem<?>.MetaValueItem DIELECTRIC_MIRROR;
    public static MetaItem<?>.MetaValueItem EMPTY_LASER_ASSEMBLY;
    public static MetaItem<?>.MetaValueItem HELIUM_NEON_LASER;
    public static MetaItem<?>.MetaValueItem ND_YAG_LASER;
    public static MetaItem<?>.MetaValueItem OPTICAL_LASER_CONTROL_UNIT;

    // Spintronic Circuit Components
    public static MetaItem<?>.MetaValueItem SPIN_TRANSFER_TORQUE_MEMORY;
    public static MetaItem<?>.MetaValueItem TOPOLOGICAL_INSULATOR_TUBE;
    public static MetaItem<?>.MetaValueItem BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT;
    public static MetaItem<?>.MetaValueItem BOSE_EINSTEIN_CONDENSATE;
    public static MetaItem<?>.MetaValueItem ESR_COMPUTATION_UNIT;

    // Supra-Causal Circuit Components
    public static MetaItem<?>.MetaValueItem EIGENFOLDED_KERR_MANIFOLD;

    // Supra-Chronal Circuit Components
    public static MetaItem<?>.MetaValueItem HYPERDIMENSIONAL_DRONE;

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

    // Circuit Boards
    public static MetaItem<?>.MetaValueItem GOOWARE_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_BOARD;
    public static MetaItem<?>.MetaValueItem GOOWARE_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem OPTICAL_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_CIRCUIT_BOARD;

    // SMDs
    public static MetaItem<?>.MetaValueItem OPTICAL_CAPACITOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_DIODE;
    public static MetaItem<?>.MetaValueItem OPTICAL_RESISTOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem OPTICAL_INDUCTOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_CAPACITOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_DIODE;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_RESISTOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_TRANSISTOR;
    public static MetaItem<?>.MetaValueItem SPINTRONIC_INDUCTOR;

    // Crafting Components
    public static MetaItem<?>.MetaValueItem COMPONENT_GRINDER_BORON_NITRIDE;

    // Process-Specific Components
    public static MetaItem<?>.MetaValueItem MAGNETRON;

    // Process Intermediary Items
    // Nanotubes
    public static MetaItem<?>.MetaValueItem CARBON_ALLOTROPE_MIXTURE;
    public static MetaItem<?>.MetaValueItem GRAPHENE_ALIGNED_CNT;
    
    //tool?
    public static MetaItem<?>.MetaValueItem COLOR_APPLICATOR;

    public static void initMetaItems() {
        metaItem1 = new StandardMetaItem();
        metaItem1.setRegistryName("meta_item_gc");
        metaItem2 = new StandardMetaItem();
        metaItem2.setRegistryName("meta_item_gcys");
        metaItem3 = new StandardMetaItem(){
            @Override
            protected int getColorForItemStack(ItemStack stack, int tintIndex) {
                return tintIndex == 1 ? ColorApplicatorBehavior.currentColor(stack).getAsDyeColor().getColorValue() : super.getColorForItemStack(stack,tintIndex);
            }
        };
        metaItem3.setRegistryName("meta_item_gregica_sp");
    }

    public static void initSubitems() {
        initMetaItem1();
        GCYSItems();
    }

    private static void initMetaItem1() {
        //meme 0~9
        BAGUETTE_SWORD = metaItem1.addItem(0, "tool.baguette").addComponents(new BaguetteBehavior()).setMaxStackSize(1).setCreativeTabs(CommonProxy.GREGICA_TAB);

        //materal 10 ~ 199
        //algae(10 ~ 21)
        COMMON_ALGAE = metaItem1.addItem(10,"algae.common").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        GREEN_ALGAE = metaItem1.addItem(11,"algae.green").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        RED_ALGAE = metaItem1.addItem(12,"algae.red").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        BROWN_ALGAE = metaItem1.addItem(13,"algae.brown").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        GOLD_ALGAE = metaItem1.addItem(14,"algae.gold").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        T_ALGAE = metaItem1.addItem(15,"algae.t").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        tierItems();
        ADVANCED_PROCESS_CIRCUIT = metaItem1.addItem(38, "item.advanced_circuit").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        //biologist items
        BIOLOGY_INTEGRATED_CIRCUIT=metaItem1.addItem(39, "item.biology_integrated_circuit").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB).addComponents(new IntBcircuitBehavior());
        ADVANCED_INTEGRATED_CIRCUIT=metaItem1.addItem(40, "item.advanced_integrated_circuit").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        ROUGH_BIOLOGY_RESIN=metaItem1.addItem(41, "item.biology_resin").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        PURIFIED_ALUMINIUM_MIXTURE=metaItem1.addItem(42, "item.aluminium_mixture").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        CELLULOSE_PULP=metaItem1.addItem(43, "item.cellulose_pulp").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        CELLULOSE_FIBER=metaItem1.addItem(44, "item.cellulose_fiber_green").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        CELLULOSE_FIBER_RED=metaItem1.addItem(45, "item.cellulose_fiber_red").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        CELLULOSE_FIBER_YELLOW=metaItem1.addItem(46, "item.cellulose_fiber_yellow").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        PINE_CONE=metaItem1.addItem(47, "item.pine_cone").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        PINE_FRAGMENT=metaItem1.addItem(48, "item.pine_fragment").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        COMPOST=metaItem1.addItem(49, "item.compost").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        ALGAE_ACID=metaItem1.addItem(50, "item.algae_acid").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        WOOD_PELLETS=metaItem1.addItem(51, "item.wood_pellets").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        PELLETS_MOULD=metaItem1.addItem(52, "item.pellets_mould").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        ALUMINIUM_PELLETS=metaItem1.addItem(53, "item.aluminium_pellets").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);

        GRINDBALL_SOAPSTONE=metaItem1.addItem(54, "item.soapstone.ball").setMaxStackSize(1).setCreativeTabs(CommonProxy.GREGICA_TAB).addComponents(new MillBallBehavior());
        GRINDBALL_ALUMINIUM=metaItem1.addItem(55, "item.aluminium.ball").setMaxStackSize(1).setCreativeTabs(CommonProxy.GREGICA_TAB).addComponents(new MillBallBehavior());

        SODIUM_ETHYLATE=metaItem1.addItem(56, "item.sodium.ethylate").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        SODIUM_ETHYLXANTHATE=metaItem1.addItem(57, "item.sodium.ethylxanthate").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);

        POTASSIUM_ETHYLATE=metaItem1.addItem(58, "item.potassium.ethylate").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        POTASSIUM_ETHYLXANTHATE=metaItem1.addItem(59, "item.potassium.ethylxanthate").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);

        COLOR_APPLICATOR = metaItem3.addItem(1,"item.color_applicator")
                .setMaxStackSize(1)
                .addComponents(ElectricStats.createElectricItem(10000000L, GTValues.HV),new ColorApplicatorBehavior())
                .setCreativeTabs(CommonProxy.GREGICA_TAB);
    }

    private static void tierItems() {
        //ulv cover(22 ~ 29)
        ULV_CONVEYOR_MODULE = metaItem1.addItem(22, "cover.conveyor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 2));
        }));
        ULV_ELECTRIC_PUMP = metaItem1.addItem(23, "cover.pump.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.electric.pump.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 1280 / 80));
        }));
        ULV_ELECTRIC_MOTOR = metaItem1.addItem(24, "cover.motor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        ULV_ELECTRIC_PISTON = metaItem1.addItem(25, "cover.piston.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        ULV_ROBOT_ARM = metaItem1.addItem(26, "cover.robotic_arm.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.robot.arm.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 2));
        }));
        ULV_EMITTER = metaItem1.addItem(27, "cover.emitter.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        ULV_SENSOR = metaItem1.addItem(28, "cover.sensor.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        ULV_FIELD_GENERATOR = metaItem1.addItem(29, "cover.field_generator.ulv").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);

        //max cover(30~37)
        MAX_CONVEYOR_MODULE = metaItem1.addItem(30, "cover.conveyor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 16 * 64 * 2));
        }));
        MAX_ELECTRIC_PUMP = metaItem1.addItem(31, "cover.pump.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.electric.pump.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", 1280 * 64 * 64 * 4 * 2 / 80));
        }));
        MAX_ELECTRIC_MOTOR = metaItem1.addItem(32, "cover.motor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        MAX_ELECTRIC_PISTON = metaItem1.addItem(33, "cover.piston.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        MAX_ROBOT_ARM = metaItem1.addItem(34, "cover.robotic_arm.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB).addComponents(new TooltipBehavior(lines -> {
            lines.add(I18n.format("metaitem.robot.arm.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", 16 * 64 * 2));
        }));
        MAX_EMITTER = metaItem1.addItem(35, "cover.emitter.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        MAX_SENSOR = metaItem1.addItem(36, "cover.sensor.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
        MAX_FIELD_GENERATOR = metaItem1.addItem(37, "cover.field_generator.max").setMaxStackSize(64).setCreativeTabs(CommonProxy.GREGICA_TAB);
    }

    public static void GCYSItems(){
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

        // Electronic Circuit Components: ID 60-69


        // Micro Circuit Components: ID 70-89


        // Nano Circuit Components: ID 90-109


        // Quantum Circuit Components: ID 110-129


        // Crystal Circuit Components: ID 130-159
        EU_DOPED_CUBIC_ZIRCONIA_BOULE = metaItem2.addItem(130, "boule.cubic_zirconia.europium");
        EU_DOPED_CUBIC_ZIRCONIA_WAFER = metaItem2.addItem(131, "wafer.cubic_zirconia.europium");
        CRYSTAL_INTERFACE_WAFER = metaItem2.addItem(132, "wafer.crystal.interface");
        CRYSTAL_INTERFACE_CHIP = metaItem2.addItem(133, "plate.crystal.interface");
        ENGRAVED_RUBY_CRYSTAL_CHIP = metaItem2.addItem(134, "engraved.crystal_chip.ruby");
        ENGRAVED_SAPPHIRE_CRYSTAL_CHIP = metaItem2.addItem(135, "engraved.crystal_chip.sapphire");
        ENGRAVED_DIAMOND_CRYSTAL_CHIP = metaItem2.addItem(136, "engraved.crystal_chip.diamond");
        CRYSTAL_MODULATOR_RUBY = metaItem2.addItem(137, "crystal.modulator.ruby");
        CRYSTAL_MODULATOR_SAPPHIRE = metaItem2.addItem(138, "crystal.modulator.sapphire");
        CRYSTAL_MODULATOR_DIAMOND = metaItem2.addItem(139, "crystal.modulator.diamond");
        CRYSTAL_SYSTEM_ON_CHIP_SOCKET = metaItem2.addItem(140, "crystal.system_on_chip.socket");

        // Wetware Circuit Components: ID 160-179


        // Gooware Circuit Components: ID 180-199
        BZ_REACTION_CHAMBER = metaItem2.addItem(180, "reaction_chamber.bz");
        NONLINEAR_CHEMICAL_OSCILLATOR = metaItem2.addItem(181, "nonlinear_chemical_oscillator");

        // Optical Circuit Components: ID 200-219
        PHASE_CHANGE_MEMORY = metaItem2.addItem(200, "plate.phase_change_memory");
        OPTICAL_FIBER = metaItem2.addItem(201, "optical_fiber");
        DIELECTRIC_MIRROR = metaItem2.addItem(202, "dielectric_mirror");
        EMPTY_LASER_ASSEMBLY = metaItem2.addItem(203, "laser.assembly.empty");
        HELIUM_NEON_LASER = metaItem2.addItem(204, "laser.helium_neon");
        ND_YAG_LASER = metaItem2.addItem(205, "laser.nd_yag");
        OPTICAL_LASER_CONTROL_UNIT = metaItem2.addItem(206, "optical_laser_control_unit");

        // Spintronic Circuit Components: ID 220-239
        SPIN_TRANSFER_TORQUE_MEMORY = metaItem2.addItem(220, "plate.spin_transfer_torque_memory");
        TOPOLOGICAL_INSULATOR_TUBE = metaItem2.addItem(221, "tube.topological_insulator");
        BOSE_EINSTEIN_CONDENSATE_CONTAINMENT_UNIT = metaItem2.addItem(222, "containment_unit.bose_einstein_condensate");
        BOSE_EINSTEIN_CONDENSATE = metaItem2.addItem(223, "bose_einstein_condensate");
        ESR_COMPUTATION_UNIT = metaItem2.addItem(224, "esr_computation_unit");

        // Cosmic Circuit Components: ID 240-259


        // Supra-Causal Circuit Components: ID 260-299
        EIGENFOLDED_KERR_MANIFOLD = metaItem2.addItem(260, "eigenfolded.kerr.manifold");


        // Supra-Chronal Circuit Components: ID 300-349
        HYPERDIMENSIONAL_DRONE = metaItem2.addItem(300, "hyperdimensional.drone");


        // Voltage Coils: ID 350-355
        VOLTAGE_COIL_UHV = metaItem2.addItem(350, "voltage_coil.uhv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UEV = metaItem2.addItem(351, "voltage_coil.uev").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UIV = metaItem2.addItem(352, "voltage_coil.uiv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_UXV = metaItem2.addItem(353, "voltage_coil.uxv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_OpV = metaItem2.addItem(354, "voltage_coil.opv").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));
        VOLTAGE_COIL_MAX = metaItem2.addItem(355, "voltage_coil.max").setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.MercuryCadmiumTelluride, M * 2), new MaterialStack(GCYSMaterials.ChromiumGermaniumTellurideMagnetic, M / 2)));

        // Power Components: ID 356-379
        NANO_POWER_IC_WAFER = metaItem2.addItem(356, "wafer.nano_power_integrated_circuit");
        PICO_POWER_IC_WAFER = metaItem2.addItem(357, "wafer.pico_power_integrated_circuit");
        FEMTO_POWER_IC_WAFER = metaItem2.addItem(358, "wafer.femto_power_integrated_circuit");
        NANO_POWER_IC = metaItem2.addItem(368, "plate.nano_power_integrated_circuit");
        PICO_POWER_IC = metaItem2.addItem(369, "plate.pico_power_integrated_circuit");
        FEMTO_POWER_IC = metaItem2.addItem(370, "plate.femto_power_integrated_circuit");

        // Circuit Boards: ID 380-419
        GOOWARE_BOARD = metaItem2.addItem(380, "board.gooware");
        OPTICAL_BOARD = metaItem2.addItem(381, "board.optical");
        SPINTRONIC_BOARD = metaItem2.addItem(382, "board.spintronic");
        GOOWARE_CIRCUIT_BOARD = metaItem2.addItem(400, "circuit_board.gooware");
        OPTICAL_CIRCUIT_BOARD = metaItem2.addItem(401, "circuit_board.optical");
        SPINTRONIC_CIRCUIT_BOARD = metaItem2.addItem(402, "circuit_board.spintronic");

        // SMDs: ID 420-479
        OPTICAL_CAPACITOR = metaItem2.addItem(420, "component.optical_smd.capacitor");
        OPTICAL_DIODE = metaItem2.addItem(421, "component.optical_smd.diode");
        OPTICAL_RESISTOR = metaItem2.addItem(422, "component.optical_smd.resistor");
        OPTICAL_TRANSISTOR = metaItem2.addItem(423, "component.optical_smd.transistor");
        OPTICAL_INDUCTOR = metaItem2.addItem(424, "component.optical_smd.inductor");

        SPINTRONIC_CAPACITOR = metaItem2.addItem(425, "component.spintronic_smd.capacitor");
        SPINTRONIC_DIODE = metaItem2.addItem(426, "component.spintronic_smd.diode");
        SPINTRONIC_RESISTOR = metaItem2.addItem(427, "component.spintronic_smd.resistor");
        SPINTRONIC_TRANSISTOR = metaItem2.addItem(428, "component.spintronic_smd.transistor");
        SPINTRONIC_INDUCTOR = metaItem2.addItem(429, "component.spintronic_smd.inductor");

        // Simple Machine Crafting Components: ID 480-499
        COMPONENT_GRINDER_BORON_NITRIDE = metaItem2.addItem(480, "component.grinder.boron_nitride")
                .setMaterialInfo(new ItemMaterialInfo(new MaterialStack(GCYSMaterials.CubicBoronNitride, M * 4), new MaterialStack(GCYSMaterials.Vibranium, M * 8), new MaterialStack(GCYSMaterials.CubicHeterodiamond, M)));

        // Process-Specific Components: ID 500-999
        MAGNETRON = metaItem2.addItem(500, "magnetron");

        // Process Intermediary Items: ID 1000-1999
        CARBON_ALLOTROPE_MIXTURE = metaItem2.addItem(1000, "mixture.carbon_allotrope");
        GRAPHENE_ALIGNED_CNT = metaItem2.addItem(1001, "cnt.graphene_aligned");
    }
}
