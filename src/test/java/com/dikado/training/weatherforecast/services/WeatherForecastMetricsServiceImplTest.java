package com.dikado.training.weatherforecast.services;

import com.dikado.training.weatherforecast.api.model.FutureWeatherForecast;
import com.dikado.training.weatherforecast.api.services.WeatherForecastService;
import com.dikado.training.weatherforecast.domain.WeatherMetrics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastMetricsServiceImplTest {

    @Mock
    WeatherForecastService weatherForecastService;


    WeatherForecastMetricsService weatherForecastMetricsService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);
        weatherForecastMetricsService = new WeatherForecastMetricsServiceImpl(weatherForecastService);
    }

    @Test
    void getWeatherMetricsByCity() {

        //given
        when(weatherForecastService.fiveDaysWeatherForecast(anyString())).thenReturn(new FutureWeatherForecast());

        //when
        WeatherMetrics london = weatherForecastMetricsService.getWeatherMetricsByCity("London");

        //then
        assertNotNull(london);
        verify(weatherForecastService,times(1)).fiveDaysWeatherForecast(anyString());

    }
}