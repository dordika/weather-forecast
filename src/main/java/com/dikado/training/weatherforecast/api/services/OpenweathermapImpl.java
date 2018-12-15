package com.dikado.training.weatherforecast.api.services;

import com.dikado.training.weatherforecast.api.model.FutureWeatherForecast;
import com.dikado.training.weatherforecast.converter.WeatherForecastMapper;
import com.dikado.training.weatherforecast.domain.WeatherMetrics;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class OpenweathermapImpl implements WeatherForecastService {

    private RestTemplate restTemplate;

    private final String api_url;

    private final String api_key;

    public OpenweathermapImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url, @Value("${api.key}") String api_key) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
        this.api_key = api_key;
    }

    @Override
    public WeatherMetrics fiveDaysWeatherForecast(String city) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("q", city)
                .queryParam("APPID",api_key);

        URI uri = uriBuilder.build(true).toUri();
        FutureWeatherForecast futureWeatherForecast = restTemplate.getForObject(uri, FutureWeatherForecast.class);
        return WeatherForecastMapper.futureWeatherForecastToWeatherMetrics(futureWeatherForecast);
    }
}
