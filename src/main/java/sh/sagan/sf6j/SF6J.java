package sh.sagan.sf6j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SF6J {

    public static CompletableFuture<GameData> load() {
        List<CompletableFuture<CharacterData>> futures = Arrays.stream(CharacterId.VALUES)
                .map(CharacterData::load).toList();
        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
        return all.thenApply(v -> {
            List<CharacterData> list = futures.stream().map(CompletableFuture::join).toList();
            return new GameData(list);
        });
    }
}
