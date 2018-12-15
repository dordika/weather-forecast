package com.dikado.training.weatherforecast.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Metric  {
    private LocalDateTime time;
    private double temperatureCelsius;
    private double pressure;

    @Builder
    public Metric(LocalDateTime time, double temperatureCelsius,double pressure) {
        this.time = time;
        this.temperatureCelsius = temperatureCelsius;
        this.pressure = pressure;
    }
}
