package project.gregica.api.unification.materials;

import gregtech.api.unification.material.Material;
import project.gregica.api.unification.materials.material.FirstDegreeMaterials;
import project.gregica.api.unification.materials.material.SecondDegreeMaterials;

public class GCMaterials {
    //Material ID: 26000-27000

    public static Material Coolant;
    public static Material SuperCoolant;
    public static Material Cryotheum;
    public static Material XPJuice;
    public static Material Spirit;
    public static Material Hollowtears;
    public static Material AtomicSeparationCatalyst;
    public static Material Tiberium;
    public static Material NeutronsFlow;
    public static Material ProtonFlow;
    public static Material BismuthLeadAlloy;
    public static Material UreaMix;
    public static Material FermentationBase;
    public static Material Resin;
    public static Material CalciumCarbonate;
    public static Material PropionicAcid;
    public static Material SodiumAluminate;
    public static Material RedMud;
    public static Material Butanol;
    public static Material Formaldehyde;
    public static Material CarbenDisulfide;
    public static Material PineOil;
    public static Material Periodicium;

    public static Material AlmandineFront;
    public static Material PentlanditeFront;
    public static Material ChalcopyriteFront;
    public static Material GrossularFront;
    public static Material MonaziteFront;
    public static Material NickelFront;
    public static Material PlatinumFront;
    public static Material PyropeFront;
    public static Material RedstoneFront;
    public static Material SpessartineFront;
    public static Material SphaleriteFront;

    public static Material Inconel625;


    public static Material Thaumium;
    public static Material VoidMetal;
    public static Material MetallicHydrogen;
    public static Material Ethylenimine;
    public static Material Polyethyleneimine;

    public static Material SuperheatedSteam;

    public static void register() {
        FirstDegreeMaterials.register();
        SecondDegreeMaterials.register();
      /*  if(GCValues.IS_TC_LOADED)
        *    ThaumcraftMaterials.TCMaterials();
       */
    }
}