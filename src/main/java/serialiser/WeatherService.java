package serialiser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.City;
import model.WeatherData;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

public class WeatherService {
    public static WeatherData fetchWeatherData(String cityName) throws IOException {

        String appId = "Insert your Api ID (Token) here";
    City city = new City();
    WeatherData weatherData = new WeatherData();
    ObjectMapper mapper = new ObjectMapper();


    URL www = new URL("http://api.openweathermap.org/data/2.5/weather?q="+ cityName +"&APPID="+appId);
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
    city.setCityLon(coord.get("lon").asText());
    city.setCityName(node.get("name").asText());

    System.out.println(city);
    System.out.println(weatherData);

    weatherData.setCity(city);

    return weatherData;
}
}
