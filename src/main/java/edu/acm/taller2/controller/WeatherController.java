package edu.acm.taller2.controller;

import org.springframework.web.bind.annotation.*;
import edu.acm.taller2.service.WeatherService;

import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public Map<String, Object> getWeather(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
}