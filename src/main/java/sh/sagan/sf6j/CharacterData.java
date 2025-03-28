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
    private final List<Gif> gifs;

    private CharacterData(CharacterId characterId, List<Move> moves, List<Gif> gifs) {
        this.characterId = characterId;
        this.moves = moves;
        this.movesByIdentifier = moves.stream().collect(Collectors.toMap(k -> k.getIdentifier().toUpperCase(), k -> k));
        this.gifs = gifs;
    }

    public static CompletableFuture<CharacterData> load(CharacterId characterId) {
        CompletableFuture<List<Move>> moves = Parser.FrameData.loadMoves(characterId);
        CompletableFuture<List<Gif>> gifs = Parser.Gifs.loadGifs(characterId);
        return CompletableFuture.allOf(moves, gifs)
                .thenApply(nothing -> new CharacterData(characterId, moves.join(), gifs.join()));
    }

    public CharacterId getCharacterId() {
        return characterId;
    }

    public List<Move> getMoves() {
        return moves;
    }

    @Nullable
    public Move getMove(String identifier) {
        return movesByIdentifier.get(identifier.toUpperCase());
    }

    public List<Gif> getGifs() {
        return gifs;
    }
}
