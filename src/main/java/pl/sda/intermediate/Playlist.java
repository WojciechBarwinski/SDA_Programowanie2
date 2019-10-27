package pl.sda.intermediate;

import java.util.Collections;
import java.util.List;

public class Playlist extends Playable {

    private List<Playable> playableList;

    private PlayMode playMode;

    public void add(Playable playable) {
        playableList.add(playable);
    }

    public void setOrder(PlayMode playMode) {
        this.playMode = playMode;
    }

    @Override
    public String play() {
        String playedList = "";
        if (PlayMode.SEQUENTIAL == playMode) {
            for (Playable playable : playableList) {
                playedList += playable.play();
            }
        } else if (PlayMode.RANDOM == playMode) {
            Collections.shuffle(playableList);
            for (Playable playable : playableList) {
                playedList += playable.play();
            }
        } else if (PlayMode.LOOP == playMode) {
            for (int i = 0; i < 10; i++) {
                for (Playable playable : playableList) {
                    playedList += playable.play();
                }
            }
        }
        return "";
    }
}
