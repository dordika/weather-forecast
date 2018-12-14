package com.dikado.training.weatherforecast.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WeatherForecastController.BASE_URL)
public class WeatherForecastController {
    public static final String BASE_URL = "/data";

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getWeatherByCity(String city){

        return "json";
    }
}
