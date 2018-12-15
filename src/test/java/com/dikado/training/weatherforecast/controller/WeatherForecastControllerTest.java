package com.dikado.training.weatherforecast.controller;

import com.dikado.training.weatherforecast.domain.AvarageMetricsDto;
import com.dikado.training.weatherforecast.exceptions.WeatherExceptionHandler;
import com.dikado.training.weatherforecast.services.WeatherForecastMetricsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpClientErrorException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class WeatherForecastControllerTest {

    @Mock
    WeatherForecastMetricsService weatherForecastMetricsService;

    @InjectMocks
    WeatherForecastController weatherForecastController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(weatherForecastController)
                .setControllerAdvice(new WeatherExceptionHandler())
                .build();
    }

    @Test
    void getWeatherByCityTest() throws Exception {

        AvarageMetricsDto avarageMetricsDto = new AvarageMetricsDto();
        avarageMetricsDto.setCity("Rome");
        avarageMetricsDto.setDailyAvarage(4.9);
        avarageMetricsDto.setNaightlyAvarage(1.9);
        avarageMetricsDto.setPressure(997.19);

        when(weatherForecastMetricsService.getWeatherMetricsByCity(anyString()))
                .thenReturn(avarageMetricsDto);



        mockMvc.perform(get(WeatherForecastController.BASE_URL)
                .requestAttr("city", "Roma"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test assert HttpClientErrorException.NotFound.class")
    void expectedNotFoundExceptionTest() throws Exception {

        when(weatherForecastMetricsService.getWeatherMetricsByCity(anyString()))
                .thenThrow(HttpClientErrorException.NotFound.class);

        mockMvc.perform(get(WeatherForecastController.BASE_URL + "/blabla")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }


}