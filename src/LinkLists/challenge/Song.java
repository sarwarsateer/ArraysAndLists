package LinkLists.challenge;

public class Song {
    private String title;
    private double duration;


    public Song(String title, double duration) {
        this.duration = duration;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + this.title + '\'' +
                ", duration=" + this.duration +
                '}';
    }

    public String getTitle() {
        return title;
    }
}
