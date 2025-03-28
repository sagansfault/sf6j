package sh.sagan.sf6j;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

public class TestLoad {

    @Test
    void testLoad() {
        GameData gameData;
        try {
            gameData = SF6J.load().get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(gameData.getCharacterData().get(CharacterId.MBISON).getMove("j.HP").toString());
        System.out.println(gameData.getCharacterData().get(CharacterId.MBISON).getGifs().get(0).getGifURL());

        CharacterData bison = gameData.getCharacterData().get(CharacterId.MBISON);
        int outOf = 0;
        int matched = 0;
        for (Move move : bison.getMoves()) {
            if (bison.getGifs().stream().anyMatch(g -> g.getMoveName().toLowerCase().contains(move.getName().toLowerCase()))) {
                matched++;
            }
            outOf++;
        }
        System.out.println("m=" + matched + " / o=" + outOf);
    }
}
