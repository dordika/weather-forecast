package com.dikado.training.weatherforecast.utility;

import java.time.*;

public class Utility {


    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10,places);
        return Math.round(value*scale) / scale;
    }

    /***
     *
     * @param: @plusDay
     * @return now date plus the param
     */
    public static LocalDateTime addDayFromNow(int plusDay){
        return LocalDateTime.now(Clock.systemUTC()).plusDays(plusDay);
    }

    /***
     *
     * @return date now UTC
     */
    public static LocalDateTime now(){
        return LocalDateTime.now(Clock.systemUTC());
    }



    /***
     *
     * @param: @unixTimestamp
     * @return LocalDateTime UTC
     */
    public static LocalDateTime toDate(Integer unixTimestamp){
        return  LocalDateTime.ofInstant(Instant.ofEpochMilli((long)unixTimestamp*1000), ZoneOffset.UTC);
    }

    /**
     *
     * @param @kelvin
     * @return celsius
     */
    public static double toCelsius(Double kelvin){
        return kelvin - 273.15;
    }

}
