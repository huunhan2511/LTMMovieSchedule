package Models;

import java.io.Serializable;

public class Review implements Serializable{
    String Title;
    String URL;

    public Review(){}

    public Review(String title, String URL) {
        Title = title;
        this.URL = URL;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String toString() {
        return "{" +
                "Title: " + this.Title + "\n" +
                "URL: " + this.URL + "\n" +
                "}";
    }
}
