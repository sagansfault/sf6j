package sh.sagan.sf6j;

public class Gif {

    private final String moveName;
    private final String gifURL;

    public Gif(String moveName, String gifURL) {
        this.moveName = moveName;
        this.gifURL = gifURL;
    }

    public String getGifURL() {
        return gifURL;
    }

    public String getMoveName() {
        return moveName;
    }
}
