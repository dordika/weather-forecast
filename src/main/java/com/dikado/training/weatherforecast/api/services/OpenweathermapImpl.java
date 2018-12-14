package com.dikado.training.weatherforecast.api.services;

import com.dikado.training.weatherforecast.api.model.FutureWeatherForecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;

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
    public FutureWeatherForecast fiveDaysWeatherForecast(String city) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("q", city)
                .queryParam("APPID",api_key);

        URI uri = uriBuilder.build(true).toUri();
        return restTemplate.getForObject(uri, FutureWeatherForecast.class);
    }
}
