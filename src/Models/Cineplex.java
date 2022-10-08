package Models;

public class Cineplex {
    String Id;
    String Name;

    public Cineplex(){}

    public Cineplex(String id, String name) {
        Id = id;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String toString(){
        return "{" +  "\n" +
                "Id: " + this.Id + "\n" +
                "Name: " + this.Name + "\n" +
                "}";
    }
}
