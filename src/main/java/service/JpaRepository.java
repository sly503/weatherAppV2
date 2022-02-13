package service;

import model.City;

import java.util.List;


public class JpaRepository {

    private static JpaService jpaService = JpaService.getInstance();

    public static void printCities() {
        List<City> cities = jpaService.runInTransaction(entityManager ->
                entityManager.createQuery("select c from City c", City.class).getResultList());
        cities.stream()
                .map(city -> city.getCityName() + ": " + city.getCityLon() + ":" + city.getCityLat())
                .forEach(System.out::println);
    }
}
