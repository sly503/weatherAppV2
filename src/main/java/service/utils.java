package service;

import model.City;
import model.WeatherData;

import java.util.List;

public class utils {

    private static final JpaService jpaService = JpaService.getInstance();


    public static void printCities() {
        List<City> cities = jpaService.runInTransaction(entityManager ->
                entityManager.createQuery("select c from City c", City.class).getResultList());
        cities.stream()
                .map(city -> city.getCityName() + ": " + city.getCityLon() + ":" + city.getCityLat())
                .forEach(System.out::println);
    }

    public static void printWeatherData(String cityName) {
        List<WeatherData> weatherData = jpaService.runInTransaction(entityManager ->
                entityManager.createQuery("select w from WeatherData w where w.city.cityName=:cityName", WeatherData.class)
                        .setParameter("cityName", cityName)
                        .getResultList());
        weatherData.stream()
                .map(weatherData1 -> weatherData1.getCity().getCityName() + ": " + weatherData1.getTemperature() + ":" + weatherData1.getPressure() + ":" + weatherData1.getHumidity())
                .forEach(System.out::println);
    }

    public static void printWeatherDataByCity(String cityName) {
        List<WeatherData> weatherData = jpaService.runInTransaction(entityManager ->
                entityManager.createQuery("select w from WeatherData w where w.city.cityName=:cityName", WeatherData.class)
                        .setParameter("cityName", cityName)
                        .getResultList());
        weatherData.stream()
                .map(weatherData1 -> weatherData1.getCity().getCityName() + ": " + weatherData1.getTemperature() + ":" + weatherData1.getPressure() + ":" + weatherData1.getHumidity())
                .forEach(System.out::println);
    }

    //print weather data for a city by city name and temperature
    public static void printWeatherDataByCityAndTemperature(String cityName, int temperature) {
        List<WeatherData> weatherData = jpaService.runInTransaction(entityManager ->
                entityManager.createQuery("select w from WeatherData w where w.city.cityName=:cityName and w.temperature=:temperature", WeatherData.class)
                        .setParameter("cityName", cityName)
                        .setParameter("temperature", temperature)
                        .getResultList());
        weatherData.stream()
                .map(weatherData1 -> weatherData1.getCity().getCityName() + ": " + weatherData1.getTemperature() + ":" + weatherData1.
    


}
