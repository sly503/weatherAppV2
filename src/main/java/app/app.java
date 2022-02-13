package app;
import model.WeatherData;
import service.JpaService;
import java.io.IOException;

import static service.JpaRepository.printCities;
import static service.WeatherService.getWeatherData;


public class app {
    private static JpaService jpaService = JpaService.getInstance();
    public static void main(String[] args) throws IOException {

        WeatherData weatherData = getWeatherData("Tirana");
        try {
            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(weatherData);
                return null;
            });
            printCities();
        } finally {
            jpaService.shutdown();
        }

    }








}