package ir.ac.kntu;

public class City {
    private String name;
    private String latitude;
    private String longitude;


    public City() {
    }

    public City(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name= " + name + "\n" +
                "latitude= " + latitude + "\n" +
                "longitude= " + longitude ;
    }
}
