package model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {

@GenericGenerator(name = "increment", strategy = "increment")
@Id
@GeneratedValue(generator = "increment")

private Long id;
    private String cityName;
    private String cityLon;
    private String cityLat;
    @OneToMany(mappedBy = "city")
    private List<WeatherData> weatherData;

    public City(String cityName, String cityLon, String cityLat) {
        this.cityName = cityName;
        this.cityLon = cityLon;
        this.cityLat = cityLat;
    }

    public City() {
    }

    public City(String name) {
    }



    public Long getId() {
        return id;
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
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(cityName, city.cityName) && Objects.equals(cityLon, city.cityLon) && Objects.equals(cityLat, city.cityLat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, cityLon, cityLat);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cityLon='" + cityLon + '\'' +
                ", cityLat='" + cityLat + '\'' +
                '}';
    }

}
