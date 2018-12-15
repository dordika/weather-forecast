package com.dikado.training.weatherforecast.services;

import com.dikado.training.weatherforecast.api.services.WeatherForecastService;
import com.dikado.training.weatherforecast.domain.AvarageMetricsDto;
import com.dikado.training.weatherforecast.domain.Metric;
import com.dikado.training.weatherforecast.domain.WeatherMetrics;
import com.dikado.training.weatherforecast.utility.Utility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherForecastMetricsServiceImpl implements WeatherForecastMetricsService {

    private final WeatherForecastService weatherForecastService;

    public WeatherForecastMetricsServiceImpl(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @Override
    public AvarageMetricsDto getWeatherMetricsByCity(String city) {
        WeatherMetrics weatherMetrics = weatherForecastService.fiveDaysWeatherForecast(city);
        return  avarageTemperature(weatherMetrics);

    }


    /**
     *
     * @param: @weatherMetrics, WeatherMetricslist contain City and a list of time and temperatureCelsius
     * @return AvarageMetricsDto, the city with the avarage of the temperatureCelsius(daily and
     * nightly) for the next 3 days from today’s
     */
    private static AvarageMetricsDto avarageTemperature(WeatherMetrics weatherMetrics){

        //filter the list of metric, keep info for next 3 dayt from now.
        List<Metric> metricsNext3Days = weatherMetrics.getMetric().stream()
                .filter(metric -> metric.getTime().isBefore(Utility.addDayFromNow(3)))
                .collect(Collectors.toList());

        AvarageMetricsDto avarageMetricsDto = new AvarageMetricsDto();

        avarageMetricsDto.setCity(weatherMetrics.getCity());
        avarageMetricsDto.setDailyAvarage(avarageDaily(metricsNext3Days));
        avarageMetricsDto.setNaightlyAvarage(avarageNightly(metricsNext3Days));
        avarageMetricsDto.setPressure(avaragePressure(metricsNext3Days));


        return avarageMetricsDto;
    }

    private static double avaragePressure(List<Metric> metricsNext3Days) {

        double sumPressure = metricsNext3Days.stream().mapToDouble(Metric::getPressure).sum();
        double numberMeasurements = metricsNext3Days.size();
        return Utility.roundAvoid(sumPressure/numberMeasurements,2);
    }

    /***
     * daily means all the metric.getTime() between 6 am and 18 pm
     *
     */
    private static double avarageDaily(List<Metric> metrics) {
        List<Metric> dailyMetric = metrics.stream()
                .filter(metric -> metric.getTime().getHour() >= 6
                        && metric.getTime().getHour() < 18)
                .collect(Collectors.toList());

        double temperature = dailyMetric.stream().mapToDouble(Metric::getTemperatureCelsius).sum();
        double numberMeasurements = dailyMetric.size();

        return Utility.roundAvoid(temperature/numberMeasurements,2);
    }

    /***
     * Nightly means all the metric.getTime() between 18 and 6 am
     *
     */
    private static double avarageNightly(List<Metric> metrics) {
        List<Metric> nightlyMetric = metrics.stream()
                .filter(metric -> metric.getTime().getHour() <6
                        || metric.getTime().getHour() >= 18)
                .collect(Collectors.toList());

        double temperature = nightlyMetric.stream().mapToDouble(Metric::getTemperatureCelsius).sum();
        double numberMeasurements = nightlyMetric.size();

        return Utility.roundAvoid(temperature/numberMeasurements,2);
    }


}
