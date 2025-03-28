package sh.sagan.sf6j;

import org.jetbrains.annotations.Nullable;

public enum CharacterId {

    RYU("Ryu", "Ryu", "ryu"),
    LUKE("Luke", "Luke", "luke"),
    JAMIE("Jamie", "Jamie", "jamie"),
    CHUNLI("Chun-Li", "Chun-Li", "chunli"),
    GUILE("Guile", "Guile", "guile"),
    KIMBERLY("Kimberly", "Kimberly", "kimberly"),
    JURI("Juri", "Juri", "juri"),
    KEN("Ken", "Ken", "ken"),
    BLANKA("Blanka", "Blanka", "blanka"),
    DHALSIM("Dhalsim", "Dhalsim", "dhalsim"),
    EHONDA("E.Honda", "E.Honda", "ehonda"),
    DEEJAY("Dee Jay", "Dee_Jay", "deejay"),
    MANON("Manon", "Manon", "manon"),
    MARISA("Marisa", "Marisa", "marisa"),
    JP("JP", "JP", "jp"),
    ZANGIEF("Zangief", "Zangief", "zangief"),
    LILY("Lily", "Lily", "lily"),
    CAMMY("Cammy", "Cammy", "cammy"),
    RASHID("Rashid", "Rashid", "rashid"),
    AKI("A.K.I.", "A.K.I.", "aki"),
    ED("Ed", "Ed", "ed"),
    AKUMA("Akuma", "Akuma", "akuma"),
    MBISON("M.Bison", "M.Bison", "mbison"),
    TERRY("Terry", "Terry", "terry"),
    MAI("Mai", "Mai", "mai"),
    ;

    public static final CharacterId[] VALUES = values();

    private final String name;
    private final String superComboURL;
    private final String ultimateFrameDataURL;

    CharacterId(String name, String superComboURLPath, String ultimateFrameDataURL) {
        this.name = name;
        this.superComboURL = String.format("https://wiki.supercombo.gg/w/Street_Fighter_6/%s/Data", superComboURLPath);
        this.ultimateFrameDataURL = String.format("https://ultimateframedata.com/sf6/%s", ultimateFrameDataURL);
    }

    public String getName() {
        return name;
    }

    public String getSuperComboURL() {
        return superComboURL;
    }

    public String getUltimateFrameDataURL() {
        return ultimateFrameDataURL;
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
