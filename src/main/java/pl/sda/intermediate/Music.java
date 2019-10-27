package pl.sda.intermediate;

public class Music extends Playable{
    String artist;
    String title;

    @Override
    public String play() {
        return artist + " " + title;
    }
}
