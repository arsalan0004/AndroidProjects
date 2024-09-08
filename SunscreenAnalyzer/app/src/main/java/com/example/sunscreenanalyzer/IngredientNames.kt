package com.example.IngredientNames


fun organizeLists(){
    // organize company names alphabetically
    companyNames.sort()

    // organize products alphabetically
    neutrogena_products.sort()
    lrp_products.sort()


}

// names of different ingredients
val tinosorb_M_names = listOf("Tinosorb_M", "Bisoctrizole",
    "Parsol Max", "Eversorb M", "Milestab 360",
    "methylene bis-benzotriazolyl tetramethyl-butylphenol",
    "2,2′-Methylenebis[6-(2H-1,2,3-benzotriazol-2-yl)-4-(2,4,4-trimethylpentan-2-yl)phenol]")

val tinosorb_S_names = listOf("Tinosorb_S", "Parsol Shield",
    "Escalol S", "bis-ethylhexyloxyphenol methoxyphenyl triazine",
    "Bemotrizinol", "triazine", "Anisotriazine")

val mexoryl_XL_names = listOf("Mexoryl_XL", "Drometrizole Trisiloxane")

val mexoryl_SX_names = listOf("Mexoryl_SX", "Ecamsule", "terephthalylidene dicamphor sulfonic acid")

val merodimate_names = listOf("Merodimate", "Menthyl anthranilate")

val neo_Heliopan_names = listOf("Neo_Heliopan", "Bisdisulizole disodium", "Neo Heliopan AP",
    "disodium phenyl dibenzimidazole tetrasulfonate")

val parsol_BHHB_names = listOf("Parsol_DHHB", "Diethylamino hydroxybenzoyl hexyl benzoate",
    "Uvinul A Plus")

val avobenzone_names = listOf("Avobenzone", "Parsol 1789", "Milestab 1789",
    "Eusolex 9020", "Escalol 517", "Neo Heliopan 357", "Butyl Methoxydibenzoylmethane")

val sulisobenzone_names = listOf("Sulisobenzone", "benzophenone-4", "benzophenone-5")

val oxybenzone_names = listOf("Oxybenzone", "benzophenone-3", "BP-3",
    "Milestab 9", "Eusolex 4360", "Escalol 567", "KAHSCREEN BZ-3")

val ensulizole_names = listOf("Ensulizole", "phenylbenzimidazole sulfonic acid")

val enzacamene_names = listOf("Enzacamene", "4-methylbenzylidene camphor", "4-MBC")

val iscotrizinol_names = listOf("Iscotrizinol", "diethylhexyl butamido triazone")

val octyltriazone_names = listOf("Octyltriazone","Ethylhexyl triazone", "Uvinul T 150")

val polysilicone_15_names = listOf("polysilicone_15", "Parsol SLX")

val octisalate_names = listOf("Octisalate", "2-Ethylhexyl salicylate", "octyl salicylate",
    "octisalate", "ethyl hexyl salicylate", "2-ethylhexyl ester salicylic acid", "2-ethylhexyl ester",
    "benzoic acid", "2-hydroxy ester", "2-ethylhexyl ester", "2-ethylhexyl ester")

val octocrylene_names = listOf("Octocrylene", "Octocrilene", "Uvinul N-539")

val octinoxate_names = listOf("Octinoxate", "Ethylhexyl methoxycinnamate", "Octyl methoxycinnamate",
    "Eusolex 2292", "Uvinul MC80", "(E)-3-(4-methoxyphenyl) prop-2-enoic acid 2-ethylhexyl ester")

val padimate_O_names = listOf("Padimate_O", "2-ethylhexyl dimethyl PABA", "Escalol 507",
    "Sundown")

val amiloxate_names = listOf("Amiloxate", "3-Methylbutyl (2E)-3-(4-methoxyphenyl)prop-2-enoate",
    "Isopentyl 4-methoxycinnamate; Isoamyl p-methoxycinnamate")

val homosalate_names = listOf("Homosalate", "3,3,5-Trimethylcyclohexyl 2-hydroxybenzoate")

val titanium_dioxide_names = listOf("Titanium_Dioxide", "TiO2")

val zinc_oxide_names = listOf("Zinc_Oxide", "ZnO")




//############################################################################################### //
//                                            COMPANIES                                           //
//############################################################################################### //
val companyNames = arrayOf("La Roche-Posay", "Neutrogena", "Anessa")


//############################################################################################### //
//                                            PRODUCTS                                            //
//############################################################################################### //

val neutrogena_products = arrayOf(
    "Ultra Sheer Dry Touch (Oxybenzone Free) | SPF 70",
    "Ultra Sheer Dry Touch Broad Spectrum | SPF 100+",
    "Ultra Sheer Dry Touch Broad Spectrum | SPF 55",
    "Ultra Sheer Dry Touch Broad Spectrum | SPF 45",
    "Ultra Sheer Dry Touch Broad Spectrum | SPF 30",
    "Ultra Sheer Face | SPF 70",
    "Mineral Ultra Sheer Dry Touch | SPF 30",
    "Ultra Sheer Face & Body Mineral Stick | SPF 50",
    "Ultra Sheer Body Mist | SPF 70",
    "Ultra Sheer Body Mist | SPF 45",
    "Ultra Sheer Body Mist | SPF 30",
    "Ultra Sheer Face Sereum with Vitamin E (Oil Free)| SPF 60",

    "Sport Face Oil Free | SPF 70+",
    "Sport Active Defense | SPF 30",
    "Sport Active Defense | SPF 70",

    "Sheer Zinc Mineral | SPF 50",
    "Sheer Zinc Face Mineral | SPF 50",
    "Sheer Zinc Kids Mineral Sunscreen Stick | SPF 50",
    "Sheer Zinc Kids Mineral Sunscreen | SPF 50",

    "Beach Defense Lotion | SPF 30",
    "Beach Defense Lotion | SPF 50",
    "Beach Defense Lotion | SPF 70",

    "Beach Defense Spray | SPF 30",
    "Beach Defense Spray | SPF 50",
    "Beach Defense Spray | SPF 70",

    "Beach Defense Kids Sunscreen stick | SPF 60+",
    "Beach Defense Kids Sunscreen Spray | SPF 70",

    "PureScreen+ Mineral Beach Defense Stick | SPF 50",
    "PureScreen+ Mineral Beach Defense Lotion | SPF 30",


    "Invisible Daily Defense Lotion | SPF 30",
    "Invisible Daily Defense Lotion | SPF 60+",
    "Invisible Daily Defense Face Serum | SPF 60+",
    "Invisible Daily Defense Body Spray | SPF 60+",
    "Invisible Daily Defense Face Mist | SPF 50",

    "Invisible Daily Defense Face Liquid | SPF 30",
    "PureScreen+ Invisible Daily Defense Face Liquid | SPF 30",

    "Clear Face Oil-Free Lotion | SPF 30",
    "Clear Face Oil Free Lotion | SPF 50",
    "Clear Face Oil-Free Face Serum | SPF 60+",

    "Clear Body Oil-Free sunscreen | SPF 30",

    "Hydro Boost Water Gel Lotion | SPF 30",
    "Hydro Boost Water Gel Lotion | SPF 50",
    "Age Shield Face Oil-Free lotion | SPF 70",
    "Pure & Free Baby Sunscreen Lotion | SPF 50",
    "Pure & Free Baby Sunscreen Stick | SPF 50",
    "PureScreen+ Mineral UV Tint Face Liquid | SPF 30"
)



val anessa_products = arrayOf(
    "Perfect UV Sunscreen Milk | SPF 50+ | PA++++"

)

val ing_Anessa_meltInMilk : List<Pair<String, Float>> = listOf(
    Pair(zinc_oxide_names[0], 10.35f),
    Pair(octocrylene_names[0], 5.0f),
    Pair(octisalate_names[0], 4.9f),
    Pair(parsol_BHHB_names[0], 1.8f),
    Pair(homosalate_names[0], 1.0f),
    Pair(octyltriazone_names[0], 0.8f),
    Pair(polysilicone_15_names[0], 0.5f),
    //Pair(tinosorb_S_names[0], 0.5f)
)



val lrp_products = arrayOf(
    "Mela B3 UV | SPF 30",
    "Cicaplast Balm B5 | SPF 50",
    "Anthelios UV Hydra | SPF 50",
    "Anthelios AOX Antioxidant Serum | SPF 50",

    "Anthelios Ultra Light | SPF 50",
    "Anthelios Melt-In Milk | SPF 100",
    "Anthelios Melt-In Milk | SPF 60",
    "Anthelios UV Correct | SPF 70",

    "Anthelios Lotion Spray | SPF 60",
    "Anthelios Dry Touch | SPF 60",
    "Anthelios Cooling | SPF 60",
    "Anthelios Cooling | SPF 30",
    "Anthelios Kids Gentle Lotion | SPF 50",
    "Anthelios Anti-Aging Primer | SPF 50",


    "Anthelios Mineral (Face) | SPF 50",
    "Anthelios Mineral (Face & Body) | SPF 50",
    "Anthelios HA Mineral | SPF 30",
    "Anthelios Tinted Mineral | SPF 50")


//############################################################################################### //
//                                            INGREDIENTS                                         //
//############################################################################################### //

val ing_LRP_A_UVHydra : List<Pair<String, Float>> = listOf(Pair(avobenzone_names[0], 3.0f),
                               Pair(homosalate_names[0], 7.0f),
                               Pair(octinoxate_names[0], 5.0f),
                               Pair(octocrylene_names[0], 7.0f))

// needs to be filled in
val ing_LRP_Mela_B3_UV : List<Pair<String, Float>> = listOf(Pair(titanium_dioxide_names[0], 0.0f))

val ing_LRP_A_AOX : List<Pair<String, Float>> = listOf(
                           Pair(avobenzone_names[0], 2.68f),
                           Pair(homosalate_names[0], 9.60f),
                           Pair(octisalate_names[0], 2.88f),
                           Pair(octocrylene_names[0], 5.38f),
                           Pair(oxybenzone_names[0], 3.46f))

val ing_LRP_A_Mineral_Tinted : List<Pair<String, Float>> = listOf(Pair(titanium_dioxide_names[0], 0.0f))

val ing_LRP_A_ultraLight : List<Pair<String, Float>> = listOf(
                                  Pair(avobenzone_names[0], 3.0f),
                                  Pair(homosalate_names[0], 10.0f),
                                  Pair(octisalate_names[0], 5.0f),
                                  Pair(octocrylene_names[0], 7.0f))

val ing_LRP_A_meltInMilk : List<Pair<String, Float>> = listOf(
                                  Pair(avobenzone_names[0], 3.0f),
                                  Pair(homosalate_names[0], 15.0f),
                                  Pair(octisalate_names[0], 5.0f),
                                  Pair(octocrylene_names[0], 10.0f))


val ing_LRP_A_UV_Correct : List<Pair<String, Float>> = listOf(
                                  Pair(avobenzone_names[0], 3.0f),
                                  Pair(homosalate_names[0], 13.0f),
                                  Pair(octisalate_names[0], 5.0f),
                                  Pair(octocrylene_names[0], 10.0f))

val ing_LRP_A_Mineral_Face : List<Pair<String, Float>> = listOf(
                                    Pair(titanium_dioxide_names[0], 6.0f),
                                    Pair(zinc_oxide_names[0], 5.0f))

val ing_LRP_A_Mineral_body : List<Pair<String, Float>> = listOf(
                                    Pair(titanium_dioxide_names[0], 5.0f),
                                    Pair(zinc_oxide_names[0], 15.0f))

val ing_LRP_cicaplast : List<Pair<String, Float>> = listOf(Pair(homosalate_names[0], 8.0f),
                               Pair(octisalate_names[0], 5.0f),
                               Pair(octocrylene_names[0], 5.0f),
                               Pair(zinc_oxide_names[0], 7.0f))

val ing_LRP_A_spray : List<Pair<String, Float>> = listOf(Pair(avobenzone_names[0], 2.68f),
                             Pair(homosalate_names[0], 9.60f),
                             Pair(octisalate_names[0], 2.88f),
                             Pair(octocrylene_names[0], 5.38f),
                             Pair(oxybenzone_names[0], 3.46f))

val ing_LRP_Dry_Touch : List<Pair<String, Float>> = listOf(Pair(avobenzone_names[0], 3.0f),
                               Pair(homosalate_names[0], 15.0f),
                               Pair(octisalate_names[0], 5.0f),
                               Pair(octocrylene_names[0], 7.0f))

val ing_LRP_cooling_60 : List<Pair<String, Float>> = listOf(Pair(avobenzone_names[0], 3.0f),
                                Pair(homosalate_names[0], 10.72f),
                                Pair(octisalate_names[0], 3.21f),
                                Pair(octocrylene_names[0], 6.0f),
                                Pair(oxybenzone_names[0], 3.86f))

val ing_LRP_cooling_30 : List<Pair<String, Float>> = listOf(Pair(avobenzone_names[0], 2.24f),
                                Pair(homosalate_names[0], 8.0f),
                                Pair(octisalate_names[0], 2.4f),
                                Pair(octocrylene_names[0], 4.48f),
                                Pair(oxybenzone_names[0], 2.88f))

val ing_LRP_kids : List<Pair<String, Float>> = listOf(Pair(avobenzone_names[0], 3.0f),
                          Pair(homosalate_names[0], 13.0f),
                          Pair(octisalate_names[0], 5.0f),
                          Pair(octocrylene_names[0], 10.0f))

val ing_LRP_A_HA_Mineral : List<Pair<String, Float>> = listOf(Pair(titanium_dioxide_names[0], 5.5f),
                                  Pair(zinc_oxide_names[0], 10.0f))

val ing_LRP_A_anti_aging : List<Pair<String, Float>> = listOf(Pair(avobenzone_names[0], 3.0f),
                                  Pair(homosalate_names[0], 10.0f),
                                  Pair(octisalate_names[0], 5.0f),
                                  Pair(octisalate_names[0], 5.0f),
                                  Pair(oxybenzone_names[0], 6.0f))


val ings_LRP_UltraFluid_invisibleFinish : List<Pair<String, Float>> = listOf(Pair(mexoryl_XL_names.first(), 7.0f),
                                                 Pair(tinosorb_S_names.first(), 5.0f),
                                                 Pair(octisalate_names.first(), 5.0f),
                                                 Pair(avobenzone_names.first(), 3.0f),
                                                 Pair(homosalate_names.first(), 2.0f),
                                                 Pair(ensulizole_names.first(), 0.5f))


//                                     NEUTROGENA INGREDIENTS                                     //
//############################################################################################### //


val ing_Neutrogena_pureAndFree_baby : List<Pair<String, Float>> = listOf(
    Pair(zinc_oxide_names[0], 21.6f)
)

val ing_Neutrogena_US_vitE : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 13.5f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f)
)

val ing_Neutrogena_US_bodyMist30 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 8.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 8.0f)
)

val ing_Neutrogena_US_bodyMist45 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 10.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f)
)

val ing_Neutrogena_US_bodyMist70 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f)
)

val ing_Neutrogena_US_mineral_stick50 : List<Pair<String, Float>> = listOf(
    Pair(zinc_oxide_names[0], 21.6f),
)

val ing_Neutrogena_US_DT_mineral : List<Pair<String, Float>> = listOf(
    Pair(zinc_oxide_names[0], 21.6f),
)

val ing_Neutrogena_US_DT_face : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 10.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 7.5f),
    Pair(oxybenzone_names[0], 5.0f)
)

val ing_Neutrogena_US_DT_30 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 2.5f),
    Pair(homosalate_names[0], 6.0f),
    Pair(octisalate_names[0], 4.5f),
    Pair(octocrylene_names[0], 8.0f)
)

val ing_Neutrogena_US_DT_45 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 10.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f)
)

val ing_Neutrogena_US_DT_55 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 10.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f)
)

val ing_Neutrogena_US_DT_100p : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f),
    Pair(oxybenzone_names[0], 6.0f)
)

val ing_Neutrogena_US_DT_70 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_zinc_50 = listOf(Pair(zinc_oxide_names[0], 21.6f))

val ing_Neutrogena_zinc_face_50 = listOf(Pair(zinc_oxide_names[0], 21.6f))

val ing_Neutrogena_zinc_kids_stick = listOf(Pair(zinc_oxide_names[0], 21.6f))

val ing_Neutrogena_zinc_kids = listOf(Pair(zinc_oxide_names[0], 21.6f))

val ing_Neutrogena_Sport_face = listOf(Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_Sport_activeDefense_30 = listOf(Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 8.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 8.0f))

val ing_Neutrogena_Sport_activeDefense_70 = listOf(Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_beachDefenseLotion30 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 2.5f),
    Pair(homosalate_names[0], 6.0f),
    Pair(octisalate_names[0], 4.5f),
    Pair(octocrylene_names[0], 8.0f))

val ing_Neutrogena_beachDefenseLotion50 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_beachDefenseLotion70 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_beachDefenseSpray30 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 6.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 8.0f))

val ing_Neutrogena_beachDefenseSpray50 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 10.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_beachDefenseSpray70 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_beachDefenseKidsStick : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_beachDefenseKidsSpray : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_beachDefenseMineralStick50 : List<Pair<String, Float>> = listOf(
    Pair(zinc_oxide_names[0], 21.6f))

val ing_Neutrogena_beachDefenseMineralLotion : List<Pair<String, Float>> = listOf(
    Pair(zinc_oxide_names[0], 18.7f),
    Pair(titanium_dioxide_names[0], 6.5f))


val ing_Neutrogena_DailyDefenseLotion30 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 1.5f),
    Pair(homosalate_names[0], 5.0f),
    Pair(octisalate_names[0], 4.0f),
    Pair(octocrylene_names[0], 6.0f))

val ing_Neutrogena_DailyDefenseLotion60 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 13.5f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_DailyDefenseFaceSerum : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 13.5f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_DailyDefenseBodySpray : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 10.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_DailyDefenseFaceMist : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 10.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f))

val ing_Neutrogena_DailyDefenseMineral : List<Pair<String, Float>> = listOf(
    Pair(titanium_dioxide_names[0], 4.9f),
    Pair(zinc_oxide_names[0], 21.6f),
)

val ing_Neutrogena_ClearFace30 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 2.5f),
    Pair(homosalate_names[0], 8.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 8.0f)
)

val ing_Neutrogena_ClearFace50 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 10.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f)
)

val ing_Neutrogena_ClearFace60 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 13.5f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f)
)

val ing_Neutrogena_ClearBody : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 2.5f),
    Pair(homosalate_names[0], 8.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 8.0f)
)

val ing_Neutrogena_HydroBoost30 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 2.5f),
    Pair(homosalate_names[0], 8.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 8.0f)
)

val ing_Neutrogena_HydroBoost50 : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f)
)

val ing_Neutrogena_ageSheild : List<Pair<String, Float>> = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 15.0f),
    Pair(octisalate_names[0], 5.0f),
    Pair(octocrylene_names[0], 10.0f)
)

val ing_Neutrogena_PF_BabyLotion : List<Pair<String, Float>> = listOf(
    Pair(zinc_oxide_names[0], 21.6f)
)

val ing_Neutrogena_PF_Baby50 : List<Pair<String, Float>> = listOf(
    Pair(zinc_oxide_names[0], 21.6f)
)

val ing_Neutrogena_PS_MineralUVTint : List<Pair<String, Float>> = listOf(
    Pair(titanium_dioxide_names[0], 3.2f),
    Pair(zinc_oxide_names[0], 21.6f),
)



//                                          VICHY INGREDIENTS                                     //
//############################################################################################### //

val ing_Vichy_CS_UV_MAT = listOf(
    Pair(avobenzone_names[0], 3.0f),
    Pair(homosalate_names[0], 10.0f),
    Pair(octocrylene_names[0], 7.0f),
    Pair(octisalate_names, 5.0f),
    Pair(mexoryl_XL_names[0], 0.5f))


//############################################################################################### //
//                                                 MAPS                                           //
//############################################################################################### //

val companyToProductNames = mapOf(
    "La Roche-Posay" to lrp_products,
    "Neutrogena"     to neutrogena_products,
    "Anessa"         to anessa_products)


val neutrogena_productsIngredientsMap : Map<String, List<Pair<String, Float>>> = mapOf(

    "Ultra Sheer Dry Touch (Oxybenzone Free) | SPF 70" to ing_Neutrogena_US_DT_70,
    "Ultra Sheer Dry Touch Broad Spectrum | SPF 100+" to ing_Neutrogena_US_DT_100p,
    "Ultra Sheer Dry Touch Broad Spectrum | SPF 55" to ing_Neutrogena_US_DT_55,
    "Ultra Sheer Dry Touch Broad Spectrum | SPF 45" to ing_Neutrogena_US_DT_45,
    "Ultra Sheer Dry Touch Broad Spectrum | SPF 30" to ing_Neutrogena_US_DT_30,
    "Ultra Sheer Face | SPF 70" to ing_Neutrogena_US_DT_face,
    "Mineral Ultra Sheer Dry Touch | SPF 30" to ing_Neutrogena_US_DT_mineral,
    "Ultra Sheer Face & Body Mineral Stick | SPF 50" to ing_Neutrogena_US_mineral_stick50,
    "Ultra Sheer Body Mist | SPF 70" to ing_Neutrogena_US_bodyMist70,
    "Ultra Sheer Body Mist | SPF 45" to ing_Neutrogena_US_bodyMist45,
    "Ultra Sheer Body Mist | SPF 30" to ing_Neutrogena_US_bodyMist30,
    "Ultra Sheer Face Sereum with Vitamin E (Oil Free)| SPF 60" to ing_Neutrogena_US_vitE,
    "Pure & Free Baby Sunscreen Location | SPF 50" to ing_Neutrogena_pureAndFree_baby,

    "Sport Face Oil Free | SPF 70+" to ing_Neutrogena_Sport_face,
    "Sport Active Defense | SPF 30" to ing_Neutrogena_Sport_activeDefense_30,
    "Sport Active Defense | SPF 70" to ing_Neutrogena_Sport_activeDefense_70,

    "Sheer Zinc Mineral | SPF 50" to ing_Neutrogena_zinc_50,
    "Sheer Zinc Face Mineral | SPF 50" to ing_Neutrogena_zinc_face_50,
    "Sheer Zinc Kids Mineral Sunscreen Stick | SPF 50" to ing_Neutrogena_zinc_kids_stick,
    "Sheer Zinc Kids Mineral Sunscreen | SPF 50" to ing_Neutrogena_zinc_kids,

    "Beach Defense Lotion | SPF 30" to ing_Neutrogena_beachDefenseLotion30,
    "Beach Defense Lotion | SPF 50" to ing_Neutrogena_beachDefenseLotion50,
    "Beach Defense Lotion | SPF 70" to ing_Neutrogena_beachDefenseLotion70,

    "Beach Defense Spray | SPF 30" to ing_Neutrogena_beachDefenseSpray30,
    "Beach Defense Spray | SPF 50" to ing_Neutrogena_beachDefenseSpray50,
    "Beach Defense Spray | SPF 70" to ing_Neutrogena_beachDefenseSpray70,

    "Beach Defense Kids Sunscreen stick | SPF 60+" to ing_Neutrogena_beachDefenseKidsStick,
    "Beach Defense Kids Sunscreen Spray | SPF 70" to ing_Neutrogena_beachDefenseKidsSpray,

    "PureScreen+ Mineral Beach Defense Stick | SPF 50" to ing_Neutrogena_beachDefenseMineralStick50,
    "PureScreen+ Mineral Beach Defense Lotion | SPF 30" to ing_Neutrogena_beachDefenseMineralLotion,

    "Invisible Daily Defense Lotion | SPF 30" to ing_Neutrogena_DailyDefenseLotion30,
    "Invisible Daily Defense Lotion | SPF 60+" to ing_Neutrogena_DailyDefenseLotion60,
    "Invisible Daily Defense Face Serum | SPF 60+" to ing_Neutrogena_DailyDefenseFaceSerum,
    "Invisible Daily Defense Body Spray | SPF 60+" to ing_Neutrogena_DailyDefenseBodySpray,
    "Invisible Daily Defense Face Mist | SPF 50" to ing_Neutrogena_DailyDefenseFaceMist,
    "Invisible Daily Defense Face Liquid | SPF 30" to ing_Neutrogena_DailyDefenseMineral,
    "PureScreen+ Invisible Daily Defense Face Liquid | SPF 30" to ing_Neutrogena_DailyDefenseMineral,

    "Clear Face Oil-Free Lotion | SPF 30" to ing_Neutrogena_ClearFace30,
    "Clear Face Oil Free Lotion | SPF 50" to ing_Neutrogena_ClearFace50,
    "Clear Face Oil-Free Face Serum | SPF 60+" to ing_Neutrogena_ClearFace60,

    "Clear Body Oil-Free sunscreen | SPF 30" to ing_Neutrogena_ClearBody,

    "Hydro Boost Water Gel Lotion | SPF 30" to ing_Neutrogena_HydroBoost30,
    "Hydro Boost Water Gel Lotion | SPF 50" to ing_Neutrogena_HydroBoost50,
    "Age Shield Face Oil-Free lotion | SPF 70" to ing_Neutrogena_ageSheild,
    "Pure & Free Baby Sunscreen Lotion | SPF 50" to ing_Neutrogena_PF_BabyLotion,
    "Pure & Free Baby Sunscreen Stick | SPF 50" to ing_Neutrogena_PF_Baby50,
    "PureScreen+ Mineral UV Tint Face Liquid | SPF 30" to ing_Neutrogena_PS_MineralUVTint

)

val LRP_productsIngredientsMap : Map<String, List<Pair<String, Float>>> = mapOf(
    "Mela B3 UV | SPF 30" to ing_LRP_Mela_B3_UV,
    "Cicaplast Balm B5 | SPF 50" to ing_LRP_cicaplast,
    "Anthelios UV Hydra | SPF 50" to ing_LRP_A_UVHydra,
    "Anthelios AOX Antioxidant Serum | SPF 50" to ing_LRP_A_AOX,

    "Anthelios Ultra Light | SPF 50" to ing_LRP_A_ultraLight,
    "Anthelios Melt-In Milk | SPF 100" to ing_LRP_A_meltInMilk,
    "Anthelios Melt-In Milk | SPF 60" to ing_LRP_cooling_60,
    "Anthelios UV Correct | SPF 70" to ing_LRP_A_UV_Correct,

    "Anthelios Lotion Spray | SPF 60" to ing_LRP_A_spray,
    "Anthelios Dry Touch | SPF " to ing_LRP_Dry_Touch,
    "Anthelios Cooling | SPF 30" to ing_LRP_cooling_30,
    "Anthelios Cooling | SPF 60" to ing_LRP_cooling_60,
    "Anthelios Kids Gentle Lotion | SPF 50" to ing_LRP_kids,
    "Anthelios Anti-Aging Primer | SPF 50" to ing_LRP_A_anti_aging,

    "Anthelios Mineral (Face) | SPF 50" to ing_LRP_A_Mineral_Face,
    "Anthelios Mineral (Face & Body) | SPF 50" to ing_LRP_A_Mineral_body,
    "Anthelios HA Mineral | SPF 30" to ing_LRP_A_HA_Mineral,
    "Anthelios Tinted Mineral | SPF 50" to ing_LRP_A_Mineral_Tinted
)

val anessa_productsMap : Map<String, List<Pair<String, Float>>> = mapOf(
   "Perfect UV Sunscreen Milk | SPF 50+ | PA++++" to ing_Anessa_meltInMilk
)


val companyToProductLists = mapOf(
    "La Roche-Posay" to LRP_productsIngredientsMap,
    "Neutrogena"     to neutrogena_productsIngredientsMap,
    "Anessa"         to anessa_productsMap
)
