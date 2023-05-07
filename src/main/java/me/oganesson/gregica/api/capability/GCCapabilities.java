package me.oganesson.gregica.api.capability;

        import gregtech.api.capability.SimpleCapabilityManager;
        import gregtech.api.metatileentity.multiblock.MultiblockAbility;
        import me.oganesson.gregica.api.capability.quantum.IQubitContainer;
        import me.oganesson.gregica.api.item.ICatalyst;
        import net.minecraftforge.common.capabilities.Capability;
        import net.minecraftforge.common.capabilities.CapabilityInject;

@SuppressWarnings("InstantiationOfUtilityClass")
public class GCCapabilities {
    @CapabilityInject(IQubitContainer.class)
    public static Capability<IQubitContainer> QBIT_CAPABILITY;

    public static void init() {
        SimpleCapabilityManager.registerCapabilityWithNoDefault(IQubitContainer.class);
    }


    public static final MultiblockAbility<IQubitContainer> INPUT_QBIT = new MultiblockAbility<>("input_qubit");
    public static final MultiblockAbility<IQubitContainer> OUTPUT_QBIT = new MultiblockAbility<>("output_qubit");

    public static final MultiblockAbility<ICatalyst> CATALYST = new MultiblockAbility<>("catalyst");

    public static final MultiblockAbility<IResearchDataHatch> RESEARCH_DATA = new MultiblockAbility<>("data_hatch");
}