package com.testing;

import com.testing.Playlist;
import com.testing.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class User {
        private final String username;
        private final List<Playlist> playlists = new ArrayList<>();

        public User(String username) {
            if (username == null || username.isBlank()) throw new IllegalArgumentException("Username leer.");
            this.username = username;
        }

        public String getUsername() { return username; }

        public void addPlaylist(Playlist playlist) {
            if (playlist == null) throw new IllegalArgumentException("Playlist null.");
            playlists.add(playlist);
        }

        public Playlist getPlaylist(String name) {
            return playlists.stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Playlist nicht gefunden: " + name));
        }

        /** „Spielt“ den Song – hier: liefert ihn zurück, damit Tests ihn prüfen können. */
        public Song playSongFromPlaylist(String pName, String sTitle) {
            Playlist p = getPlaylist(pName);
            return p.getSongs().stream()
                    .filter(s -> s.getTitle().equals(sTitle))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException(
                            "Song '" + sTitle + "' nicht in Playlist '" + pName + "'."));
        }
}
