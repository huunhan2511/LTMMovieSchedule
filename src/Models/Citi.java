package Models;

public class Citi {
    String ApiId;
    String Name;

    public Citi(){}

    public Citi(String apiId, String name) {
        ApiId = apiId;
        Name = name;
    }

    public String getApiId() {
        return ApiId;
    }

    public void setApiId(String apiId) {
        ApiId = apiId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String toString(){
        return "{" +  "\n" +
                "ApiId: " + this.ApiId + "\n" +
                "Name: " + this.Name + "\n" +
                "}";
    }
}
