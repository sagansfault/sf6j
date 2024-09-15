package sh.sagan.sf6j;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CharacterData {

    private final CharacterId characterId;
    private final List<Move> moves;
    private final Map<String, Move> movesByIdentifier;

    private CharacterData(CharacterId characterId, List<Move> moves) {
        this.characterId = characterId;
        this.moves = moves;
        this.movesByIdentifier = moves.stream().collect(Collectors.toMap(Move::getIdentifier, k -> k));
    }

    public static CompletableFuture<CharacterData> load(CharacterId characterId) {
        return Parser.MoveParser.loadMoves(characterId.getSuperComboURL())
                .thenApply(moves -> new CharacterData(characterId, moves));
    }

    public CharacterId getCharacterId() {
        return characterId;
    }

    public List<Move> getMoves() {
        return moves;
    }

    @Nullable
    public Move getMove(String identifier) {
        return movesByIdentifier.get(identifier);
    }
}
