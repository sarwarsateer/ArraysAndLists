package LinkLists.challenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean addNewSong(String title, double duration) {
        if (searchSong(title) == null) {
            songs.add(new Song(name, duration));
            return true;
        }
        return false;
    }

    private Song searchSong(String title) {
        for (Song searchedSong : this.songs) {
            if (searchedSong.getTitle().equals(title)) {
                System.out.println(searchedSong.getTitle() + " is already exist");
                return searchedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }

        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = searchSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

}
