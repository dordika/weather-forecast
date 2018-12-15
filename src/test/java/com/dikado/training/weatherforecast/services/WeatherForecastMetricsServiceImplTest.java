package com.dikado.training.weatherforecast.services;

import com.dikado.training.weatherforecast.api.services.WeatherForecastService;
import com.dikado.training.weatherforecast.domain.AvarageMetricsDto;
import com.dikado.training.weatherforecast.domain.Metric;
import com.dikado.training.weatherforecast.domain.WeatherMetrics;
import com.dikado.training.weatherforecast.utility.Utility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@Disabled
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
        //Given
        WeatherMetrics metrics = new WeatherMetrics();
        metrics.setCity("Rome");
        List<Metric> metricList = Arrays.asList(Metric.builder().time(Utility.now()).temperatureCelsius(7).pressure(980).build()
                                    ,Metric.builder().time(Utility.now()).temperatureCelsius(10).pressure(950).build()
                                    ,Metric.builder().time(Utility.now()).temperatureCelsius(13).pressure(920).build());
        metrics.setMetric(metricList);


        //mockito BDD syntax
        given(weatherForecastService.fiveDaysWeatherForecast(anyString()))
                .willReturn(metrics);

        //when
        AvarageMetricsDto rome = weatherForecastMetricsService.getWeatherMetricsByCity("Rome");

        //then
        then(weatherForecastService).should(times(1)).fiveDaysWeatherForecast(anyString());
        assertNotNull(rome);
        //verify(weatherForecastService,times(1)).fiveDaysWeatherForecast(anyString());

    }

}