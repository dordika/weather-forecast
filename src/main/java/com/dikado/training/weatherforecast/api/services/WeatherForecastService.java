package com.dikado.training.weatherforecast.api.services;

import com.dikado.training.weatherforecast.domain.WeatherMetrics;

public interface WeatherForecastService {

    WeatherMetrics fiveDaysWeatherForecast(String city);

}
