package pl.sda.intermediate;

public enum PlayMode {
    RANDOM("LOSOWO"),
    SEQUENTIAL("KOLEJNO"),
    LOOP("PETLA");

    private String pMName;

    PlayMode(String str) {
        this.pMName = str;
    }
}
