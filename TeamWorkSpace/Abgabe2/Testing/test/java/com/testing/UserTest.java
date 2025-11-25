package com.testing;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
public class UserTest {
    private User user;
    private Playlist rock, chill;

    @BeforeEach
    void setup() {
        user = new User("hossein");
        rock = new Playlist("Rock");
        chill = new Playlist("Chill");

        rock.addSong(new Song("Lose Yourself", "Eminem", 326));
        rock.addSong(new Song("Big In Japan", "Alphaville", 233));
        chill.addSong(new Song("Use Me", "Diplo", 203));
    }

    @Test
    void addPlaylist_addsPlaylists() {
        user.addPlaylist(rock);
        user.addPlaylist(chill);
        assertEquals("Rock", user.getPlaylist("Rock").getName());
        assertEquals("Chill", user.getPlaylist("Chill").getName());
    }

    @Test
    void getPlaylist_byName() {
        user.addPlaylist(rock);
        Playlist got = user.getPlaylist("Rock");
        assertEquals("Rock", got.getName());
    }

    @Test
    void playSongFromPlaylist_returnsSong() {
        user.addPlaylist(chill);
        Song played = user.playSongFromPlaylist("Chill", "Use Me");
        assertEquals("Use Me", played.getTitle());
        assertEquals("Diplo", played.getArtist());
        assertEquals(203, played.getDuration());
    }
}

