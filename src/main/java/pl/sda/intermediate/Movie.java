package pl.sda.intermediate;

public class Movie extends Playable{
    String title;

    @Override
    public String play() {
        return title;
    }
}
