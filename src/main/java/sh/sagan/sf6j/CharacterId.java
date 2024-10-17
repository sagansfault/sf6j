package sh.sagan.sf6j;

import org.jetbrains.annotations.Nullable;

public enum CharacterId {

    RYU("Ryu", "Ryu"),
    LUKE("Luke", "Luke"),
    JAMIE("Jamie", "Jamie"),
    CHUNLI("Chun-Li", "Chun-Li"),
    GUILE("Guile", "Guile"),
    KIMBERLY("Kimberly", "Kimberly"),
    JURI("Juri", "Juri"),
    KEN("Ken", "Ken"),
    BLANKA("Blanka", "Blanka"),
    DHALSIM("Dhalsim", "Dhalsim"),
    EHONDA("E.Honda", "E.Honda"),
    DEEJAY("Dee Jay", "Dee_Jay"),
    MANON("Manon", "Manon"),
    MARISA("Marisa", "Marisa"),
    JP("JP", "JP"),
    ZANGIEF("Zangief", "Zangief"),
    LILY("Lily", "Lily"),
    CAMMY("Cammy", "Cammy"),
    RASHID("Rashid", "Rashid"),
    AKI("A.K.I.", "A.K.I."),
    ED("Ed", "Ed"),
    AKUMA("Akuma", "Akuma"),
    MBISON("M.Bison", "M.Bison"),
    TERRY("Terry", "Terry"),
    ;

    public static final CharacterId[] VALUES = values();

    private final String name;
    private final String superComboURL;

    CharacterId(String name, String superComboURLPath) {
        this.name = name;
        this.superComboURL = String.format("https://wiki.supercombo.gg/w/Street_Fighter_6/%s/Data", superComboURLPath);
    }

    public String getName() {
        return name;
    }

    public String getSuperComboURL() {
        return superComboURL;
    }

    @Nullable
    public static CharacterId getByName(String name) {
        for (CharacterId value : VALUES) {
            if (value.getName().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }
}
