package sh.sagan.sf6j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameData {

    private final Map<CharacterId, CharacterData> characterData;

    public GameData(List<CharacterData> characterData) {
        this.characterData = characterData.stream().collect(Collectors.toMap(CharacterData::getCharacterId, k -> k));
    }

    public Map<CharacterId, CharacterData> getCharacterData() {
        return characterData;
    }
}
