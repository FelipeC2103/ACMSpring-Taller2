package edu.acm.taller2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.acm.taller2.model.ForecastItem;
import edu.acm.taller2.model.WeatherResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getWeather(String city) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        if (response == null || response.getList() == null)
            throw new RuntimeException("No se pudo obtener la información del clima");

        //Filtrar las próximas 24 horas
        List<ForecastItem> next24Hours = response.getList().stream()
                .limit(8) // 3h * 8 = 24h
                .collect(Collectors.toList());

        double avgTemp = next24Hours.stream()
                .mapToDouble(f -> f.getMain().getTemp())
                .average()
                .orElse(Double.NaN);

        String description = next24Hours.get(0).getWeather().get(0).getDescription();
        String lastUpdate = next24Hours.get(0).getDt_txt();

        //Resumen de los próximos 3 días
        Map<String, Double> dailyAvg = response.getList().stream()
                .collect(Collectors.groupingBy(
                        f -> f.getDt_txt().substring(0, 10),
                        Collectors.averagingDouble(f -> f.getMain().getTemp())
                ));

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("ciudad", response.getCity().getName());
        result.put("pais", response.getCity().getCountry());
        result.put("tempPromedio24h", avgTemp);
        result.put("descripcion", description);
        result.put("ultimaActualizacion", lastUpdate);
        result.put("resumen3Dias", dailyAvg.entrySet().stream().limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        return result;
    }
}