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
        WeatherData weatherData2 = fetchWeatherData("London");
        try {
            jpaService.runInTransaction(entityManager -> {
                entityManager.persist(weatherData);
                entityManager.persist(weatherData2);
                return null;
            });
            printCities();

        } finally {
            jpaService.shutdown();
        }

    }








}