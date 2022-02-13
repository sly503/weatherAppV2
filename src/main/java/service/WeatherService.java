package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import model.WeatherData;

import java.io.IOException;
import java.math.BigDecimal;

public class WeatherService {
    public static final String HTTPS_API_OPENWEATHERMAP_ORG_DATA_2_5_WEATHER = "https://api.openweathermap.org/data/2.5/weather";
    private static String FIXED_APPIKEY = "7edda0bea071419a1e1da9c91ac2d4c6";

    public WeatherData getLiveWeatherValues(String lat, String lon) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherData weatherData = new WeatherData();

        Request request = new Request.Builder()
                .url(HTTPS_API_OPENWEATHERMAP_ORG_DATA_2_5_WEATHER + "?lat=" + lat + "&lon=" + lon + "&APPID=" + FIXED_APPIKEY)
                .method("GET", null)
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        ObjectNode root = (ObjectNode) objectMapper.readTree(String.valueOf(responseBody));
        root.get("main");
        weatherData.setHumidity(new BigDecimal(root.get("humidity").asText()));
        System.out.println(weatherData);
        return objectMapper.readValue(responseBody.string(), WeatherData.class);
    }
}