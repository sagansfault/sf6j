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
    }
}
