import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

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
}
