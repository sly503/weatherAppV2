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

}
