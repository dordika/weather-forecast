package com.dikado.training.weatherforecast.api.services;

import com.dikado.training.weatherforecast.api.model.FutureWeatherForecast;

public interface WeatherForecastService {

    FutureWeatherForecast FiveDaysWeatherForecast(String city);

}
