package model;

import java.util.Objects;

public class City {

    private String cityName;
    private String cityLon;
    private String cityLat;

    public City(String cityName, String cityLon, String cityLat) {
        this.cityName = cityName;
        this.cityLon = cityLon;
        this.cityLat = cityLat;
    }

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityLon() {
        return cityLon;
    }

    public void setCityLon(String cityLon) {
        this.cityLon = cityLon;
    }

    public String getCityLat() {
        return cityLat;
    }

    public void setCityLat(String cityLat) {
        this.cityLat = cityLat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return Objects.equals(cityName, city.cityName) && Objects.equals(cityLon, city.cityLon) && Objects.equals(cityLat, city.cityLat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, cityLon, cityLat);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", cityLon='" + cityLon + '\'' +
                ", cityLat='" + cityLat + '\'' +
                '}';
    }

}
