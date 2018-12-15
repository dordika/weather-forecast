package com.dikado.training.weatherforecast.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvarageMetricsDto {

    private String city;
    private double dailyAvarage;
    private double naightlyAvarage;
    private double pressure;
}
