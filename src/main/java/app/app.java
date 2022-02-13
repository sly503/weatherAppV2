package app;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.City;
import model.WeatherData;
import service.JpaService;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;


public class app {
    private static JpaService jpaService = JpaService.getInstance();
    public static void main(String[] args) throws IOException {
        WeatherData weatherData = getWeatherData();

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

    private static WeatherData getWeatherData() throws IOException {
        WeatherData weatherData = new WeatherData();
        City city = new City();
        ObjectMapper mapper = new ObjectMapper();
        URL www = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=e0b05909c4c74435ac5117ce6d06f0f8");
        JsonParser parser = mapper.createParser(www);
        JsonNode node = mapper.readTree(parser);
        JsonNode main = node.get("main");
        JsonNode wind = node.get("wind");
        JsonNode weather = node.get("weather");
        JsonNode coord = node.get("coord");
        weatherData.setWindSpeed(new BigDecimal(wind.get("speed").asText()));
        weatherData.setHumidity(new BigDecimal(main.get("humidity").asText()));
        weatherData.setPressure(new BigDecimal(main.get("pressure").asText()));
        weatherData.setTemperature(new BigDecimal(main.get("temp").asText()));
        weatherData.setWeather(weather.get(0).get("main").asText());
        city.setCityLat(coord.get("lat").asText());
        city.setCityName(node.get("name").asText());
        city.setCityLon(coord.get("lon").asText());
        System.out.println(city.toString());
        System.out.println(weatherData.toString());
        weatherData.setCity(city);
        return weatherData;
    }

    private static void printCities() {
        List<City> cities = jpaService.runInTransaction(entityManager ->
                entityManager.createQuery("select c from City c", City.class).getResultList());
        cities.stream()
                .map(city -> city.getCityName() + ": " + city.getCityLon() + ":" + city.getCityLat())
                .forEach(System.out::println);
    }





}