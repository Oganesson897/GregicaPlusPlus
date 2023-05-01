package me.oganesson.gregica.common.unification;

import com.google.common.base.CaseFormat;
import crafttweaker.annotations.ZenRegister;
import gregtech.api.unification.Element;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.*;

@ZenClass("mods.gregic.unification.Elements")
@ZenRegister
public class GCElements {
    private static final Map<String, Element> elements = new HashMap<>();

    public static final Element Tr = add(123L, 123L, -1L, null, "Tiberium", "Tr", false);

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
