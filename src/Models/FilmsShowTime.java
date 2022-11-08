package Models;

import java.io.Serializable;
import java.util.List;

public class FilmsShowTime implements Serializable{
    String Title;
    String ApiFilmId;
    String GraphicUrl; //poster
    String ApiRatingFormat;
    String Duration;
    List<ShowTimeCinema> ShowTime;

    public FilmsShowTime(String title, String apiFilmId, String graphicUrl, String apiRatingFormat, String duration, List<ShowTimeCinema> showTime) {
        Title = title;
        ApiFilmId = apiFilmId;
        GraphicUrl = graphicUrl;
        ApiRatingFormat = apiRatingFormat;
        Duration = duration;
        ShowTime = showTime;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getApiFilmId() {
        return ApiFilmId;
    }

    public void setApiFilmId(String apiFilmId) {
        ApiFilmId = apiFilmId;
    }

    public String getGraphicUrl() {
        return GraphicUrl;
    }

    public void setGraphicUrl(String graphicUrl) {
        GraphicUrl = graphicUrl;
    }

    public String getApiRatingFormat() {
        return ApiRatingFormat;
    }

    public void setApiRatingFormat(String apiRatingFormat) {
        ApiRatingFormat = apiRatingFormat;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public List<ShowTimeCinema> getShowTime() {
        return ShowTime;
    }

    public void setShowTime(List<ShowTimeCinema> showTime) {
        ShowTime = showTime;
    }

    public String toString() {
        return "{" +
                "Title: " + this.Title + "\n" +
                "ApiFilmId: " + this.ApiFilmId + "\n" +
                "GraphicUrl: " + this.GraphicUrl + "\n" +
                "ApiRatingFormat: " + this.ApiRatingFormat + "\n" +
                "Duration: " + this.Duration + "\n" +
                "ShowTime: " + this.ShowTime + "\n" +
                "}";
    }
}
