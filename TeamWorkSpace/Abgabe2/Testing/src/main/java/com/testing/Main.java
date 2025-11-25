package com.testing;

public class Main {
    public static void main(String[] args){
        Playlist p1 = new Playlist("MyPlayList");
        Song s1 = new Song("Lose Yourself", "Eminem", 326);
        Song s2 = new Song("Use Me", "Diplo", 203);
        Song s3 = new Song("Be Mine", "Ofenbach", 181);
        Song s4 = new Song("TMM TMM", "Summer Cem", 172);
        Song s5 = new Song("Mit Dir", "Sido", 177);
        Song s6 = new Song("Big In Japan", "Alphaville", 233);

        p1.addSong(s1);
        p1.addSong(s2);
        p1.addSong(s3);
        p1.addSong(s4);
        p1.addSong(s5);
        p1.addSong(s6);

        System.out.println(p1);
        System.out.println("Gesamtdauer: " + p1.getTotalDuration() + " Sek.");
        System.out.println("Anzahl: " + p1.getTotalSongs());
        System.out.println("Enthält 'Use Me'? " + p1.containsSong(new Song("Use Me", "Diplo", 203)));
    }
}
