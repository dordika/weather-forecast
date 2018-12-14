package com.dikado.training.weatherforecast.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class WeatherForecastControllerTest {

    @Mock
    WeatherForecastController weatherForecastController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(weatherForecastController)
                .build();
    }

    @Test
    void getWeatherByCityTest() throws Exception {

        mockMvc.perform(get(weatherForecastController.BASE_URL)
                .param("q","London"))
                .andExpect(status().isOk());
    }

}