package Models;

import java.io.Serializable;
import java.util.List;

public class ShowTimeCinema implements Serializable {
    String filmType;
    String captionType;
    List<String> showTimes;

    public ShowTimeCinema() {
    }

    public ShowTimeCinema(String filmType, String captionType, List<String> showTimes) {
        this.filmType = filmType;
        this.captionType = captionType;
        this.showTimes = showTimes;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getCaptionType() {
        return captionType;
    }

    public void setCaptionType(String captionType) {
        this.captionType = captionType;
    }

    public List<String> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(List<String> showTimes) {
        this.showTimes = showTimes;
    }

    @Override
    public String toString() {
        return "{" +
                "filmType: " + this.filmType + "\n" +
                "captionType: " + this.captionType + "\n" +
                "showTimes: " + this.showTimes + "\n" +
                "}";
    }
}
