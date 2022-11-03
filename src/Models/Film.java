package Models;

import java.io.Serializable;
import java.util.List;

public class Film implements Serializable {
    String Title;
    String TitleEn;
    String Director;
    String ApiFilmId; //id de lay lich chieu cu the
    String Link; //link de lay thong tin phim
    String Duration; //thoi luong phim
    String ApiRatingFormat; //do tuoi - vd: 13+, 16+
    String ApiGenreName; //the loai - vi du: Bí Ẩn,Kinh Dị,Gay Cấn
    String ApiImdb;
    String ApiRottenTomatoes;
    String ApiMetacritic;
    String ImdbLink;
    String RottenTomatoesLink;
    String GraphicUrl;
    String BannerUrl;
    String SynopsisEn; //mo ta
    String TrailerUrl;
    String Casts;
    List<Review> Reviews;
    public Film(){

    }

    public Film(String title, String titleEn, String director, String apiFilmId, String link, String duration, String apiRatingFormat, String apiGenreName, String apiImdb, String apiRottenTomatoes, String apiMetacritic, String imdbLink, String rottenTomatoesLink, String graphicUrl, String bannerUrl, String synopsisEn, String trailerUrl, String casts, List<Review> reviews) {
        Title = title;
        TitleEn = titleEn;
        Director = director;
        ApiFilmId = apiFilmId;
        Link = link;
        Duration = duration;
        ApiRatingFormat = apiRatingFormat;
        ApiGenreName = apiGenreName;
        ApiImdb = apiImdb;
        ApiRottenTomatoes = apiRottenTomatoes;
        ApiMetacritic = apiMetacritic;
        ImdbLink = imdbLink;
        RottenTomatoesLink = rottenTomatoesLink;
        GraphicUrl = graphicUrl;
        BannerUrl = bannerUrl;
        SynopsisEn = synopsisEn;
        TrailerUrl = trailerUrl;
        Casts = casts;
        Reviews = reviews;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitleEn() {
        return TitleEn;
    }

    public void setTitleEn(String titleEn) {
        TitleEn = titleEn;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getApiFilmId() {
        return ApiFilmId;
    }

    public void setApiFilmId(String apiFilmId) {
        ApiFilmId = apiFilmId;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = Integer.parseInt(duration)/60 + "h" + Integer.parseInt(duration)%60 + '\'';
    }

    public String getApiRatingFormat() {
        return ApiRatingFormat;
    }

    public void setApiRatingFormat(String apiRatingFormat) {
        ApiRatingFormat = (apiRatingFormat.equals("P")) ? "3+" : apiRatingFormat;
    }

    public String getApiGenreName() {
        return ApiGenreName;
    }

    public void setApiGenreName(String apiGenreName) {
        ApiGenreName = apiGenreName;
    }

    public String getApiImdb() {
        return ApiImdb;
    }

    public void setApiImdb(String apiImdb) {
        ApiImdb = apiImdb;
    }

    public String getApiRottenTomatoes() {
        return ApiRottenTomatoes;
    }

    public void setApiRottenTomatoes(String apiRottenTomatoes) {
        ApiRottenTomatoes = apiRottenTomatoes;
    }

    public String getApiMetacritic() {
        return ApiMetacritic;
    }

    public void setApiMetacritic(String apiMetacritic) {
        ApiMetacritic = apiMetacritic;
    }

    public String getImdbLink() {
        return ImdbLink;
    }

    public void setImdbLink(String imdbLink) {
        ImdbLink = imdbLink;
    }

    public String getRottenTomatoesLink() {
        return RottenTomatoesLink;
    }

    public void setRottenTomatoesLink(String rottenTomatoesLink) {
        RottenTomatoesLink = rottenTomatoesLink;
    }

    public String getGraphicUrl() {
        return GraphicUrl;
    }

    public void setGraphicUrl(String graphicUrl) {
        GraphicUrl = graphicUrl;
    }

    public String getBannerUrl() {
        return BannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        BannerUrl = bannerUrl;
    }

    public String getSynopsisEn() {
        return SynopsisEn;
    }

    public void setSynopsisEn(String synopsisEn) {
        SynopsisEn = synopsisEn;
    }

    public String getTrailerUrl() {
        return TrailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        TrailerUrl = trailerUrl;
    }

    public String getCasts() {
        return Casts;
    }

    public void setCasts(String cast) {
        Casts = cast;
    }

    public List<Review> getReviews() {
        return Reviews;
    }

    public void setReviews(List<Review> reviews) {
        Reviews = reviews;
    }

    public String toString(){
        return "{" + "\n" +
                "Title: " + this.Title + "\n" +
                "TitleEn: " + this.TitleEn + "\n" +
                "Director: " + this.Director + "\n" +
                "ApiFilmId: " + this.ApiFilmId + "\n" +
                "Link: " + this.Link + "\n" +
                "Duration: " + this.Duration + "\n" +
                "Casts: " + this.Casts + "\n" +
                "ApiRatingFormat: " + this.ApiRatingFormat + "\n" +
                "ApiGenreName: " + this.ApiGenreName + "\n" +
                "ApiImdb: " + this.ApiImdb + "\n" +
                "ImdbLink: " + this.ImdbLink + "\n" +
                "ApiRottenTomatoes: " + this.ApiRottenTomatoes + "\n" +
                "RottenTomatoesLink: " + this.RottenTomatoesLink + "\n" +
                "ApiMetacritic: " + this.ApiMetacritic + "\n" +
                "GraphicUrl: " + this.GraphicUrl + "\n" +
                "BannerURL: " + this.BannerUrl + "\n" +
                "SynopsisEn: " + this.SynopsisEn + "\n" +
                "TrailerUrl: " + this.TrailerUrl + "\n" +
                "Review: " + this.Reviews + "\n" +
                "}";

    }
}
