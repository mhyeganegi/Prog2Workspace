package com.testing;

import java.util.Objects;

public final class Song {
    private final String title;
    private final String artist;
    private final int duration;

    public Song(String title, String artist, int duration){
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Title darf nicht leer sein.");
        }
        if(artist == null || artist.isBlank()){
            throw new IllegalArgumentException("Artist darf nicht leer sein.");
        }
        if(duration <= 0){
            throw new IllegalArgumentException("Dauer muss positiv sein.");
        }
        this.title=title;
        this.artist=artist;
        this.duration=duration;
    }
    public String getTitle() {return title;}
    public String getArtist() {return artist;}
    public int getDuration() {return duration;}

    @Override
    public String toString(){
        return  title + " von " + artist + " (" + duration + " Sek.)";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song s)) return false;
        return duration == s.duration && title.equals(s.title) && artist.equals(s.artist);
    }
    @Override
    public int hashCode(){
        return Objects.hash(title, artist, duration);
    }
}
