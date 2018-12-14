package com.dikado.training.weatherforecast.services;

import com.dikado.training.weatherforecast.api.model.FutureWeatherForecast;
import com.dikado.training.weatherforecast.api.services.WeatherForecastService;
import com.dikado.training.weatherforecast.domain.WeatherMetrics;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastMetricsServiceImpl implements WeatherForecastMetricsService {

    final WeatherForecastService weatherForecastService;

    public WeatherForecastMetricsServiceImpl(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @Override
    public WeatherMetrics getWeatherMetricsByCity(String city) {
        WeatherMetrics weatherMetrics = null;
        FutureWeatherForecast futureWeatherForecast = weatherForecastService.fiveDaysWeatherForecast(city);

        if(futureWeatherForecast != null){
            weatherMetrics = new WeatherMetrics();
        }

        return weatherMetrics;
    }
}
