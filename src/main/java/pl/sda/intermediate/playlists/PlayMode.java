package pl.sda.intermediate.playlists;

public enum PlayMode {
    RANDOM("LOSOWO"),
    SEQUENTIAL("KOLEJNO"),
    LOOP("PETLA");

    private String pMName;

    PlayMode(String str) {
        this.pMName = str;
    }
}
