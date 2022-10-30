package Models;

public class Cinema {
    String ApiCityId;
    String Cineplex;
    String ApiCinemaId;
    String Name;

    public Cinema(){}

    public Cinema( String apiCinemaId, String apiCityId, String cineplex, String name) {
        ApiCityId = apiCityId;
        Cineplex = cineplex;
        ApiCinemaId = apiCinemaId;
        Name = name;
    }

    public String getApiCityId() {
        return ApiCityId;
    }

    public void setApiCityId(String apiCityId) {
        ApiCityId = apiCityId;
    }

    public String getCineplex() {
        return Cineplex;
    }

    public void setCineplex(String cineplex) {
        Cineplex = cineplex;
    }

    public String getApiCinemaId() {
        return ApiCinemaId;
    }

    public void setApiCinemaId(String apiCinemaId) {
        ApiCinemaId = apiCinemaId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String toString(){
        return "{" +  "\n" +
                "ApiCityId: " + this.ApiCityId + "\n" +
                "Cineplex: " + this.Cineplex + "\n" +
                "ApiCinemaId: " + this.ApiCinemaId + "\n"+
                "Name: " + this.Name + "\n" +
                "}";
    }
}
