package model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
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

    private BigDecimal temperature;

    private String weather;

    private BigDecimal pressure;

    private BigDecimal humidity;

    private BigDecimal windSpeed;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    public WeatherData() {
    }

    public WeatherData(Date date, Double temperature, String weather, Double pressure, Double humidity, Double windSpeed, City city) {
        this.date = date;
        this.temperature = BigDecimal.valueOf(temperature);
        this.weather = weather;
        this.pressure = BigDecimal.valueOf(pressure);
        this.humidity = BigDecimal.valueOf(humidity);
        this.windSpeed = BigDecimal.valueOf(windSpeed);
    }

    public WeatherData(BigDecimal temperature, String weather, BigDecimal pressure, BigDecimal humidity, BigDecimal windSpeed, City city) {
        this.temperature = temperature;
        this.weather = weather;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
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

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
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
