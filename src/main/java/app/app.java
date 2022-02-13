package app;
import model.WeatherData;
import service.JpaService;
import java.io.IOException;

import static serialiser.WeatherService.fetchWeatherData;
import static service.utils.printCities;


public class app {
    private static final JpaService jpaService = JpaService.getInstance();
    public static void main(String[] args) throws IOException {

        WeatherData weatherData = fetchWeatherData("Tirana");
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