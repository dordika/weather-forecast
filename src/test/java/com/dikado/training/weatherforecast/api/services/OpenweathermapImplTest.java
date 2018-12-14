package com.dikado.training.weatherforecast.api.services;

import com.dikado.training.weatherforecast.api.model.FutureWeatherForecast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class OpenweathermapImplTest {

    @Autowired
    WeatherForecastService weatherForecastService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void fiveDaysWeatherForecast() {
        FutureWeatherForecast futureWeatherForecast = weatherForecastService.FiveDaysWeatherForecast("London,us");
        assertNotNull(futureWeatherForecast);
    }
}