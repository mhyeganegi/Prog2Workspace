package com.testing;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
class SongTest {
    @Test
    void ctorAndGetters_ok(){
        Song s = new Song("Use Me", "Diplo", 203);
        assertEquals("Use Me", s.getTitle());
        assertEquals("Diplo", s.getArtist());
        assertEquals(203, s.getDuration());
        assertEquals("Use Me von Diplo (203 Sek.)", s.toString());
    }
    @Test
    void toString_returnsExpected() {
        Song s = new Song("Use Me", "Diplo", 203);
        assertEquals("Use Me von Diplo (203 Sek.)", s.toString());
    }

    @Test
    void ctor_rejectsEmptyTitle(){
        assertThrows(IllegalArgumentException.class, () ->new Song("   ", "Diplo", 203));
    }
    @Test
    void ctor_rejectsEmptyArtists(){
        assertThrows(IllegalArgumentException.class, () -> new Song("Use Me", "   ", 203));
    }
    @Test
    void ctor_rejectsNonPositiveDuration(){
        assertThrows(IllegalArgumentException.class, () -> new Song("Use Me", "Diplo", 0));
        assertThrows(IllegalArgumentException.class, () -> new Song("Use Me", "Diplo", -5));
    }
    @Test
    void equalsAndHashCode_byValue(){
        Song a = new Song("Use Me", "Diplo", 203);
        Song b = new Song("Use Me", "Diplo", 203);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }
}
