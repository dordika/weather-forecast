package com.dikado.training.weatherforecast.controller;

import com.dikado.training.weatherforecast.domain.AvarageMetricsDto;
import com.dikado.training.weatherforecast.services.WeatherForecastMetricsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Api(description = " Average weather forecast for next 3 days at any city")
@RestController
@RequestMapping(WeatherForecastController.BASE_URL)
@Slf4j
public class WeatherForecastController {
    public static final String BASE_URL = "/data";

    private final WeatherForecastMetricsService weatherForecastMetricsService;

    public WeatherForecastController(WeatherForecastMetricsService weatherForecastMetricsService) {
        this.weatherForecastMetricsService = weatherForecastMetricsService;
    }

    @ApiOperation(value = "get json with avarage weather forecast of a specific city")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AvarageMetricsDto getWeatherByCity(@ApiParam(value = "City - Parameter mandatory") @NotNull String city){

        return weatherForecastMetricsService.getWeatherMetricsByCity(city);

    }
}
