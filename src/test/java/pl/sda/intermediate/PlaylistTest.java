package pl.sda.intermediate;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pl.sda.intermediate.playlists.Movie;
import pl.sda.intermediate.playlists.Music;
import pl.sda.intermediate.playlists.PlayMode;
import pl.sda.intermediate.playlists.Playlist;

import java.util.stream.IntStream;

class PlaylistTest {

    @Test
    void shouldPlaySequentially() {
        Playlist playlist = new Playlist();

        Music m1 = new Music("Rolling Stones", "Brown Sugar");
        Movie mv1 = new Movie("Casablanca");
        Movie mv2 = new Movie("Titanic");
        playlist.add(m1);
        playlist.add(mv1);
        playlist.add(mv2);

        Playlist subPlaylist = new Playlist();
        Music m2 = new Music("Kazik", "Baranek");
        Movie mv3 = new Movie("Pan Tadeusz");
        Movie mv4 = new Movie("Przedwiosnie");
        subPlaylist.add(m2);
        subPlaylist.add(mv3);
        subPlaylist.add(mv4);
        playlist.add(subPlaylist);

        System.out.println(playlist.play());
    }

    @RepeatedTest(10)
    void shouldPlayRandomly() {
        Playlist playlist = new Playlist();
        playlist.setOrder(PlayMode.RANDOM);

        Music m1 = new Music("Rolling Stones", "Brown Sugar");
        Movie mv1 = new Movie("Casablanca");
        Movie mv2 = new Movie("Titanic");
        playlist.add(m1);
        playlist.add(mv1);
        playlist.add(mv2);

        Playlist subPlaylist = new Playlist();
        Music m2 = new Music("Kazik", "Baranek");
        Movie mv3 = new Movie("Pan Tadeusz");
        Movie mv4 = new Movie("Przedwiosnie");
        subPlaylist.add(m2);
        subPlaylist.add(mv3);
        subPlaylist.add(mv4);
        playlist.add(subPlaylist);

        System.out.println(playlist.play());
    }

    @Test
    void shouldPlayRandomLoop() {
        Playlist playlist = new Playlist();
        playlist.setOrder(PlayMode.RANDOM);

        Music m1 = new Music("Rolling Stones", "Brown Sugar");
        Movie mv1 = new Movie("Casablanca");
        Movie mv2 = new Movie("Titanic");
        playlist.add(m1);
        playlist.add(mv1);
        playlist.add(mv2);

        Playlist subPlaylist = new Playlist();
        subPlaylist.setOrder(PlayMode.LOOP);
        Music m2 = new Music("Kazik", "Baranek");
        Movie mv3 = new Movie("Pan Tadeusz");
        Movie mv4 = new Movie("Przedwiosnie");
        subPlaylist.add(m2);
        subPlaylist.add(mv3);
        subPlaylist.add(mv4);
        playlist.add(subPlaylist);

        System.out.println(playlist.play());
    }

    @Test
    void name() {
        IntStream.iterate(1,a->a+8)
                .limit(3)
                .forEach(System.out::println);
    }
}