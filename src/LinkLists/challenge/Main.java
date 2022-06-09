package LinkLists.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    // Create a program that implements a playlist for songs
    // Create a Song class having Title and Duration for a song
    // The program will have an Album class containing a list of songs,
    // The albums will be stored in an ArrayList
    // Songs from different albums can be added to the playlist and will appear in the list in the order *
    // they are added.
    // Once the songs have been added to the playlist, create a menu of options to:-
    // Quite, Skip forward the next song, skip backwards to a previous song, Replay the current song.
    // List the songs in the playlist
    // A song must exist on the album before it can be added to the playlist (so can you  play songs that you own).
    // Hin: To replay a song, consider what happened when a went back and forth from a city before we
    // started tracking the direction we were doing
    // As an optional extra, provide an option to remove the current song from the playlist
    // (hint: listiterator.remove()

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {



        Album album = new Album("lovely", "Ali Haidar");
        album.addNewSong("jawani", 3.3) ;
        album.addNewSong("samandar", 2.2);
        album.addNewSong("qalandar", 2.1);
        album.addNewSong("diwana", 3.1);
        album.addNewSong("jigar", 3.5);
        albums.add(album);

        album = new Album("classic", "Sami Khan");
        album.addNewSong("salam", 2.1);
        album.addNewSong("korban", 2.3);
        album.addNewSong("jani", 1.1);
        album.addNewSong("dobara", 1.3);
        album.addNewSong("sahara", 1.3);
        album.addNewSong("lala", 3.3);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("jawani", playList);
        albums.get(0).addToPlayList("samandar", playList);
        albums.get(0).addToPlayList("kaka", playList);//not exist
        albums.get(0).addToPlayList(5, playList);
        albums.get(1).addToPlayList(1, playList);//second album
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(9, playList);//not exist
        albums.get(1).addToPlayList(4, playList);

        play(playList);


    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playList");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.printf("We have reached the start of the playList");
                        forward = true;
                    }
                    break;
                case 3:
                    break;
                case 4:
//                    printList(playList);
                    break;
                case 5:
//                    printMenu();
                    break;
            }
        }

    }

    private static void printPlaylistSongs() {

    }
    private static void printInstructions() {
        System.out.println(" 0 -> To print instructions");
        System.out.println(" 1 -> To print songs in the current album");
        System.out.println(" 2 -> To add songs to the playlist");
        System.out.println(" 3 -> To quite the song");
        System.out.println(" 4 -> To skip forward to the next song");
        System.out.println(" 5 -> To skip backward to the previous song");
    }

}
