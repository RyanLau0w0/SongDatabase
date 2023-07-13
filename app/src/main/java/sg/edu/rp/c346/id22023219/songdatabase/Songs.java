package sg.edu.rp.c346.id22023219.songdatabase;

import androidx.annotation.NonNull;

public class Songs {
    private int id;
    private String title;
    private String singer;
    private int year;
    private String stars;

    public Songs(int id, String title, String singer, int year, String stars) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getStars() {
        return stars;
    }

    @NonNull
    @Override
    public String toString() {
        return id + "\n" + title + "\n" + singer + "\n" + year + "\n" + stars;
    }
}
