package pl.sda.intermediate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Movie extends Playable{
    private String title;

    @Override
    public String play() {
        return title;
    }
}
