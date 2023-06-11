package gregica.api.unification;

import com.google.common.base.CaseFormat;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.unification.Element;
import net.minecraft.util.text.TextFormatting;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.*;

@ZenClass("mods.gregic.unification.Elements")
@ZenRegister
public class GCElements {
    private static final Map<String, Element> elements = new HashMap<>();

    public static final Element Tr = add(123L, 123L, -1L, null, "Tiberium", "Tr", false);

    public static final Element Co60 = add(27L, 33L, -1L, null, "Cobalt-60", "Co-60", true);

    public static final Element Li6 = add(3, 3, -1, null, "Lithium-6", "Li-6", true);
    public static final Element Li7 = add(3, 4, -1, null, "Lithium-7", "Li-7", true);
    public static final Element Be7 = add(4, 3, -1, null, "Beryllium-7", "Be-7", true);

    public static final Element Or = add(130, 200, -1, null, "Orichalcum", "Or", false);
    public static final Element Vb = add(152, 226, -1, null, "Vibranium", "Vb", false);
    public static final Element Ad = add(222, 580, -1, null, "Adamantium", "Ad", false);
    public static final Element Tn = add(321, 478, -1, null, "Taranium", "Tn", false);
    public static final Element Void = add(1, 1, -1, null, "Void", TextFormatting.OBFUSCATED + "☯", false);

    private GCElements() {}

    public static Element add(long protons, long neutrons, long halfLifeSeconds, String decayTo, String name, String symbol, boolean isIsotope) {
        Element element = new Element(protons, neutrons, halfLifeSeconds, decayTo, name, symbol, isIsotope);
        elements.put(name, element);
        return element;
    }

    public static List<Element> getAllElements() {
        return Collections.unmodifiableList(new ArrayList(elements.values()));
    }

    @ZenMethod("getAllElements")
    public static Element[] getAllElementsCT() {
        return elements.values().toArray(new Element[0]);
    }

    @ZenMethod
    public static Element get(String name) {
        return elements.get(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name));
    }
}
