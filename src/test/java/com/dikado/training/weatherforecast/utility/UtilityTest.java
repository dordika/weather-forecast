package com.dikado.training.weatherforecast.utility;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static java.time.Month.FEBRUARY;
import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {



    @Test
    void roundAvoid() {
        assertEquals(30.50,Utility.roundAvoid(30.50343214d,2));
    }

    @Test
    void toDate() {
        Integer unxTimestamp = 1487246400; //02/16/2017 @ 12:00pm (UTC)
        LocalDateTime triggerTime =LocalDateTime.ofInstant(Instant.ofEpochMilli((long)unxTimestamp*1000), ZoneOffset.UTC);
        assertEquals(FEBRUARY,triggerTime.getMonth());
        assertEquals(16,triggerTime.getDayOfMonth());
        assertEquals(12,triggerTime.getHour());

    }

    @Test
    void toCelsius() {
        assertEquals(0,Utility.toCelsius(273.15));

    }

}