package com.example.sunscreenanalzyerv2

// names of different ingredients
val tinosorb_M_names = listOf("Tinosorb M", "Bisoctrizole",
    "Parsol Max", "Eversorb M", "Milestab 360",
    "methylene bis-benzotriazolyl tetramethyl-butylphenol",
    "2,2′-Methylenebis[6-(2H-1,2,3-benzotriazol-2-yl)-4-(2,4,4-trimethylpentan-2-yl)phenol]")

val tinosorb_S_names = listOf("Tinosorb_S", "Parsol Shield",
    "Escalol S", "bis-ethylhexyloxyphenol methoxyphenyl triazine",
    "Bemotrizinol", "triazine", "Anisotriazine")

val mexoryl_XL_names = listOf("Mexoryl XL", "Drometrizole Trisiloxane")

val mexoryl_SX_names = listOf("Mexoryl SX", "Ecamsule", "terephthalylidene dicamphor sulfonic acid")

val merodimate_names = listOf("Merodimate", "Menthyl anthranilate")

val neo_Heliopan_names = listOf("Neo Heliopan", "Bisdisulizole disodium", "Neo Heliopan AP",
    "disodium phenyl dibenzimidazole tetrasulfonate")

val parsol_BHHB_names = listOf("Parsol DHHB", "Diethylamino hydroxybenzoyl hexyl benzoate",
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

val polysilicone_15_names = listOf("polysilicone 15", "Parsol SLX")

val octisalate_names = listOf("Octisalate", "2-Ethylhexyl salicylate", "octyl salicylate",
    "octisalate", "ethyl hexyl salicylate", "2-ethylhexyl ester salicylic acid", "2-ethylhexyl ester",
    "benzoic acid", "2-hydroxy ester", "2-ethylhexyl ester", "2-ethylhexyl ester")

val octocrylene_names = listOf("Octocrylene", "Octocrilene", "Uvinul N-539")

val octinoxate_names = listOf("Octinoxate", "Ethylhexyl methoxycinnamate", "Octyl methoxycinnamate",
    "Eusolex 2292", "Uvinul MC80", "(E)-3-(4-methoxyphenyl) prop-2-enoic acid 2-ethylhexyl ester")

val padimate_O_names = listOf("Padimate O", "2-ethylhexyl dimethyl PABA", "Escalol 507",
    "Sundown")

val amiloxate_names = listOf("Amiloxate", "3-Methylbutyl (2E)-3-(4-methoxyphenyl)prop-2-enoate",
    "Isopentyl 4-methoxycinnamate; Isoamyl p-methoxycinnamate")

val homosalate_names = listOf("Homosalate", "3,3,5-Trimethylcyclohexyl 2-hydroxybenzoate")

val titanium_dioxide_names = listOf("Titanium Dioxide", "TiO2")

val zinc_oxide_names = listOf("Zinc Oxide", "ZnO")

var allIngredients : List<String> = zinc_oxide_names +
                                    titanium_dioxide_names +
                                    homosalate_names +
                                    amiloxate_names +
                                    padimate_O_names +
                                    octinoxate_names +
                                    octocrylene_names +
                                    octisalate_names +
                                    polysilicone_15_names +
                                    octyltriazone_names +
                                    iscotrizinol_names +
                                    enzacamene_names +
                                    ensulizole_names +
                                    oxybenzone_names +
                                    sulisobenzone_names +
                                    avobenzone_names +
                                    tinosorb_M_names +
                                    tinosorb_S_names +
                                    mexoryl_XL_names +
                                    mexoryl_SX_names +
                                    merodimate_names +
                                    neo_Heliopan_names +
                                    parsol_BHHB_names
