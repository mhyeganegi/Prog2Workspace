import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Playlist {
    private final String name;
    private final List<Song> songs;

    public Playlist(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Playlist-Name darf nicht leer sein");
        }
        this.name=name;
        this.songs=new ArrayList<>();
    }
    public void addSong(Song song){
        if(song==null)throw new IllegalArgumentException("Song darf nicht null sein");
        songs.add(song);
    }
    public int getTotalDuration(){
        int sum = 0;
        for (Song s : songs) sum += s.getDuration();
        return sum;
    }
    public boolean containsSong(Song song){
        return  songs.contains(song);
    }
    public int getTotalSongs(){
        return songs.size();
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Playlist: " + name + " mit " + songs.size() + " Songs.";
    }
}
