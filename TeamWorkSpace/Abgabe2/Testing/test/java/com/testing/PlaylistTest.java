package com.testing;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlaylistTest {

    private Playlist playlist;

    @BeforeAll
    void setupAll(){
        playlist = new Playlist("p");
    }

    @BeforeEach
    void setupEach(){
        playlist.clearPlaylist();
        playlist.addSong(new Song("Song1", "Artist1", 200));
        playlist.addSong(new Song("Song2", "Artist2", 210));
        playlist.addSong(new Song("Song3", "Artist3", 220));
    }
    @AfterEach
    void cleanupEach(){
        playlist.clearPlaylist();
    }

    @AfterAll
    void tearDownAll(){
        System.out.println("All Tests abgeschlossen");
    }
    @Test
    @Order(1)
    void testAddSong(){
        playlist.addSong(new Song("Song4", "Artist4", 250));
        assertEquals(4, playlist.getTotalSongs());
    }
    @Test
    @Order(2)
    void testRemoveSong(){
        playlist.removeSong(new Song("Song2", "Artist2", 210));
        playlist.removeSong(new Song("Nope", "NA", 1));
        assertEquals(2, playlist.getTotalSongs());
        assertFalse(playlist.containsSong(new Song("song2", "Artist2", 210)));
    }


    @Test
    @Order(3)
    void testGetTotalSongs(){
        assertEquals(3, playlist.getTotalSongs());
    }

    @Test
    @Order(4)
    void testClearPlaylist(){
        playlist.clearPlaylist();
        assertEquals(0, playlist.getTotalSongs());
        assertEquals(0, playlist.getTotalDuration());
    }

    @Test
    @Order(5)
    void testShuffleKeepsCount(){
        List<Song> before = new ArrayList<>(playlist.getSongs());
        playlist.shuffle();
        assertEquals(3, playlist.getTotalSongs());
    }


   /**

    @Test
    void ctor_rejectsEmptyName(){
        assertThrows(IllegalArgumentException.class, () -> new Playlist("  "));
    }
    @Test
    void addSong_increasesCount(){
        Playlist p1 = new Playlist("p");
        p1.addSong(new Song("A", "X", 100));
        p1.addSong(new Song("B", "Y", 200));
        p1.addSong(new Song("C", "Z", 300));
        assertEquals(3, p1.getTotalSongs());
    }
    @Test
    void addSong_rejectsNull(){
        Playlist p1 = new Playlist("p");
        assertThrows(IllegalArgumentException.class, () -> p1.addSong(null));
    }
    @Test
    void totalDuration_ok(){
        Playlist p1 = new Playlist("p");
        p1.addSong(new Song("A", "X", 100));
        p1.addSong(new Song("B", "Y", 200));
        p1.addSong(new Song("C", "Z", 300));
        assertEquals(600, p1.getTotalDuration());
    }
    @Test
    void containsSong_trueForEqualSong(){
        Playlist p1 = new Playlist("p");
        Song a = new Song("A", "X", 100);
        p1.addSong(a);
        assertTrue(p1.containsSong(new Song("A", "X", 100)));
    }
    @Test
    void containsSong_falseIfAbsent(){
        Playlist p1 = new Playlist("p");
        p1.addSong(new Song("A", "X", 100));
        assertFalse(p1.containsSong(new Song("B", "Y", 200)));
    }
    @Test
    void toString_ok(){
        Playlist p1 = new Playlist("p");
        p1.addSong(new Song("A", "X", 100));
        assertEquals("Playlist: p mit 1 Songs.", p1.toString());
    }

    */
}
