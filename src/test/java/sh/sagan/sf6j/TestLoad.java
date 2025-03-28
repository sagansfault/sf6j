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
        System.out.println(gameData.getCharacterData().get(CharacterId.MBISON).getMove("236HK").toString());
        System.out.println(gameData.getCharacterData().get(CharacterId.MBISON).getGifs().get(0).getGifURL());
    }
}
