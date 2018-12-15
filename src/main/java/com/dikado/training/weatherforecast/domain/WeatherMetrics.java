package com.dikado.training.weatherforecast.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherMetrics {
    private String city;
    private List<Metric> metric;

}
