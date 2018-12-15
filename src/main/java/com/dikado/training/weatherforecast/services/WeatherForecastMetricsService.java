package com.dikado.training.weatherforecast.services;

import com.dikado.training.weatherforecast.domain.AvarageMetricsDto;

public interface WeatherForecastMetricsService {
    AvarageMetricsDto getWeatherMetricsByCity(String city);
}
