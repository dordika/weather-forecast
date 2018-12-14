package com.dikado.training.weatherforecast.services;

import com.dikado.training.weatherforecast.domain.WeatherMetrics;

public interface WeatherForecastMetricsService {
    WeatherMetrics getWeatherMetricsByCity(String city);
}
