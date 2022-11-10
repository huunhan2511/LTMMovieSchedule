/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author phuon
 */
public class FilmsShowTime implements Serializable{
    String Title;
    String ApiFilmId;
    String GraphicUrl;
    String ApiRatingFormat;
    String Duration;
    List<ShowTimeCinema> ShowTime;

    public FilmsShowTime(String Title, String ApiFilmId, String GraphicUrl, String ApiRatingFormat, String Duration, List<ShowTimeCinema> ShowTime) {
        this.Title = Title;
        this.ApiFilmId = ApiFilmId;
        this.GraphicUrl = GraphicUrl;
        this.ApiRatingFormat = ApiRatingFormat;
        this.Duration = Duration;
        this.ShowTime = ShowTime;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getApiFilmId() {
        return ApiFilmId;
    }

    public void setApiFilmId(String ApiFilmId) {
        this.ApiFilmId = ApiFilmId;
    }

    public String getGraphicUrl() {
        return GraphicUrl;
    }

    public void setGraphicUrl(String GraphicUrl) {
        this.GraphicUrl = GraphicUrl;
    }

    public String getApiRatingFormat() {
        return ApiRatingFormat;
    }

    public void setApiRatingFormat(String ApiRatingFormat) {
        this.ApiRatingFormat = ApiRatingFormat;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public List<ShowTimeCinema> getShowTime() {
        return ShowTime;
    }

    public void setShowTime(List<ShowTimeCinema> ShowTime) {
        this.ShowTime = ShowTime;
    }
    
    public String toString() {
        return "{" +
                "Title: " + this.Title + "\n" +
                "ApiFilmId: " + this.ApiFilmId + "\n" +
                "GraphicUrl: " + this.GraphicUrl + "\n" +
                "ApiRatingFormat: " + this.ApiRatingFormat + "\n" +
                "Duration: " + this.ShowTime + "\n" +
                "}";
    }
}
