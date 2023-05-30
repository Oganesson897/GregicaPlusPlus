package me.oganesson.gregica.common.recipes.machines;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.ore.OrePrefix;
import me.oganesson.gregica.api.recipe.GCRecipeMaps;

import static gregtech.api.unification.material.Materials.*;
import static me.oganesson.gregica.common.unification.materials.GCMaterials.NeutronsFlow;
import static me.oganesson.gregica.common.unification.materials.GCMaterials.ProtonFlow;

public class ReplicatorRecipes {
    public static void init() {
        addRecipeByMaterial(Hydrogen);
        addRecipeByMaterial(Deuterium);
        addRecipeByMaterial(Tritium);
        addRecipeByMaterial(Helium);
        addRecipeByMaterial(Helium3);
        addRecipeByMaterial(Lithium);
        addRecipeByMaterial(Beryllium);
        addRecipeByMaterial(Boron);
        addRecipeByMaterial(Coal);
        addRecipeByMaterial(Nitrogen);
        addRecipeByMaterial(Oxygen);
        addRecipeByMaterial(Fluorine);
        addRecipeByMaterial(Neon);
        addRecipeByMaterial(Sodium);
        addRecipeByMaterial(Magnesium);
        addRecipeByMaterial(Aluminium);
        addRecipeByMaterial(Silicon);
        addRecipeByMaterial(Phosphorus);
        addRecipeByMaterial(Sulfur);
        addRecipeByMaterial(Chlorine);
        addRecipeByMaterial(Argon);
        addRecipeByMaterial(Potassium);
        addRecipeByMaterial(Calcium);
        addRecipeByMaterial(Scandium);
        addRecipeByMaterial(Titanium);
        addRecipeByMaterial(Vanadium);
        addRecipeByMaterial(Chrome);
        addRecipeByMaterial(Manganese);
        addRecipeByMaterial(Iron);
        addRecipeByMaterial(Cobalt);
        addRecipeByMaterial(Nickel);
        addRecipeByMaterial(Copper);
        addRecipeByMaterial(Zinc);
        addRecipeByMaterial(Gallium);
        addRecipeByMaterial(Germanium);
        addRecipeByMaterial(Arsenic);
        addRecipeByMaterial(Selenium);
        addRecipeByMaterial(Bromine);
        addRecipeByMaterial(Krypton);
        addRecipeByMaterial(Rubidium);
        addRecipeByMaterial(Strontium);
        addRecipeByMaterial(Yttrium);
        addRecipeByMaterial(Zirconium);
        addRecipeByMaterial(Niobium);
        addRecipeByMaterial(Molybdenum);
        addRecipeByMaterial(Technetium);
        addRecipeByMaterial(Ruthenium);
        addRecipeByMaterial(Rhodium);
        addRecipeByMaterial(Palladium);
        addRecipeByMaterial(Silver);
        addRecipeByMaterial(Cadmium);
        addRecipeByMaterial(Indium);
        addRecipeByMaterial(Tin);
        addRecipeByMaterial(Antimony);
        addRecipeByMaterial(Tellurium);
        addRecipeByMaterial(Iodine);
        addRecipeByMaterial(Xenon);
        addRecipeByMaterial(Caesium);
        addRecipeByMaterial(Barium);
        addRecipeByMaterial(Lanthanum);
        addRecipeByMaterial(Cerium);
        addRecipeByMaterial(Praseodymium);
        addRecipeByMaterial(Neodymium);
        addRecipeByMaterial(Promethium);
        addRecipeByMaterial(Samarium);
        addRecipeByMaterial(Europium);
        addRecipeByMaterial(Gadolinium);
        addRecipeByMaterial(Terbium);
        addRecipeByMaterial(Dysprosium);
        addRecipeByMaterial(Holmium);
        addRecipeByMaterial(Erbium);
        addRecipeByMaterial(Thulium);
        addRecipeByMaterial(Ytterbium);
        addRecipeByMaterial(Lutetium);
        addRecipeByMaterial(Hafnium);
        addRecipeByMaterial(Tantalum);
        addRecipeByMaterial(Tungsten);
        addRecipeByMaterial(Rhenium);
        addRecipeByMaterial(Osmium);
        addRecipeByMaterial(Iridium);
        addRecipeByMaterial(Platinum);
        addRecipeByMaterial(Gold);
        addRecipeByMaterial(Mercury);
        addRecipeByMaterial(Thallium);
        addRecipeByMaterial(Lead);
        addRecipeByMaterial(Bismuth);
        addRecipeByMaterial(Polonium);
        addRecipeByMaterial(Astatine);
        addRecipeByMaterial(Radon);
        addRecipeByMaterial(Francium);
        addRecipeByMaterial(Radium);
        addRecipeByMaterial(Actinium);
        addRecipeByMaterial(Thorium);
        addRecipeByMaterial(Protactinium);
        addRecipeByMaterial(Uranium235);
        addRecipeByMaterial(Uranium238);
        addRecipeByMaterial(Neptunium);
        addRecipeByMaterial(Plutonium239);
        addRecipeByMaterial(Plutonium241);
        addRecipeByMaterial(Americium);
        addRecipeByMaterial(Curium);
        addRecipeByMaterial(Berkelium);
        addRecipeByMaterial(Californium);
        addRecipeByMaterial(Einsteinium);
        addRecipeByMaterial(Fermium);
        addRecipeByMaterial(Mendelevium);
        addRecipeByMaterial(Nobelium);
        addRecipeByMaterial(Lawrencium);
        addRecipeByMaterial(Rutherfordium);
        addRecipeByMaterial(Dubnium);
        addRecipeByMaterial(Seaborgium);
        addRecipeByMaterial(Bohrium);
        addRecipeByMaterial(Hassium);
        addRecipeByMaterial(Meitnerium);
        addRecipeByMaterial(Darmstadtium);
        addRecipeByMaterial(Roentgenium);
        addRecipeByMaterial(Copernicium);
        addRecipeByMaterial(Nihonium);
        addRecipeByMaterial(Flerovium);
        addRecipeByMaterial(Moscovium);
        addRecipeByMaterial(Livermorium);
        addRecipeByMaterial(Tennessine);
        //支持Oganesson897喵，谢谢喵。
        addRecipeByMaterial(Oganesson);
        addRecipeByMaterial(Tritanium);
        addRecipeByMaterial(Duranium);
        addRecipeByMaterial(Trinium);
        addRecipeByMaterial(Naquadah);
        addRecipeByMaterial(Naquadria);
        addRecipeByMaterial(NaquadahEnriched);
        special();
    }

    private static void addRecipeByMaterial(Material material) {
        int EU = (int) ((material.getProtons() + material.getNeutrons()) * 100);

        if (material.hasFluid()) {
            GCRecipeMaps.REPLICATOR.recipeBuilder().duration(1)
                    .fluidInputs(ProtonFlow.getFluid((int) Math.min(material.getProtons(),1)))
                    .fluidInputs(NeutronsFlow.getFluid((int) Math.min(material.getNeutrons(),1)))
                    .notConsumable(material.getFluid(1))
                    .fluidOutputs(material.getFluid(1))
                    .EUt(EU)
                .buildAndRegister();
        } else {
            GCRecipeMaps.REPLICATOR.recipeBuilder().duration(1)
                    .fluidInputs(ProtonFlow.getFluid((int) material.getProtons()))
                    .fluidInputs(NeutronsFlow.getFluid((int) material.getNeutrons()))
                    .notConsumable(OrePrefix.dust, material)
                    .outputs(OreDictUnifier.get(OrePrefix.dust, material))
                    .EUt(EU)
                    .buildAndRegister();
        }
    }

    private static void special() {
        GCRecipeMaps.REPLICATOR.recipeBuilder().duration(1)
                .fluidInputs(NeutronsFlow.getFluid(1000))
                .notConsumable(Neutronium.getFluid(1))
                .fluidOutputs(Neutronium.getFluid(1))
                .EUt(3000)
                .buildAndRegister();
    }
}
