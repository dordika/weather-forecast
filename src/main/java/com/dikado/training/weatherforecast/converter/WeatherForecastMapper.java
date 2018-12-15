package com.dikado.training.weatherforecast.converter;

import com.dikado.training.weatherforecast.api.model.FutureWeatherForecast;
import com.dikado.training.weatherforecast.domain.Metric;
import com.dikado.training.weatherforecast.domain.WeatherMetrics;
import com.dikado.training.weatherforecast.utility.Utility;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherForecastMapper {
    public static WeatherMetrics futureWeatherForecastToWeatherMetrics(FutureWeatherForecast futureWeatherForecast) {
        WeatherMetrics weatherMetrics = new WeatherMetrics();

        weatherMetrics.setCity(futureWeatherForecast.getCity().getName());

        List<Metric> metricList = futureWeatherForecast.getList().stream().map(list ->
                                        Metric.builder().time(Utility.toDate(list.getDt()))
                                             .temperatureCelsius(Utility.toCelsius(list.getMain().getTemp()))
                                             .pressure(list.getMain().getPressure()).build())
                                        .collect(Collectors.toList());

        weatherMetrics.setMetric(metricList);

        return weatherMetrics;
    }
}
