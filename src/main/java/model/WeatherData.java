package model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "weatherData")
public class WeatherData {
@Id
@GeneratedValue(generator = "increment")
@GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
@Temporal(TemporalType.TIMESTAMP)
@Column(name = "checkedDate")
    private Date date;

    private Double temperature;

    private String weather;

    private Double pressure;

    private Double humidity;

    private Double windSpeed;

    @ManyToOne
    private City city;

    public WeatherData() {
    }

    public WeatherData(Date date, Double temperature, String weather, Double pressure, Double humidity, Double windSpeed, City city) {
        this.date = date;
        this.temperature = temperature;
        this.weather = weather;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherData that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(temperature, that.temperature) && Objects.equals(weather, that.weather) && Objects.equals(pressure, that.pressure) && Objects.equals(humidity, that.humidity) && Objects.equals(windSpeed, that.windSpeed) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, temperature, weather, pressure, humidity, windSpeed, city);
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", date=" + date +
                ", temperature=" + temperature +
                ", weather='" + weather + '\'' +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                ", city=" + city +
                '}';
    }

}
