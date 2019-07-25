package com.weatherds.repos;

import com.weatherds.Request;
import com.weatherds.Weather;
import com.weatherds.domain.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Other {

    @Autowired
    public ForecastRepository forecastRepository;

    private String date;
    private String coordinates;

    public Other() {

    }

    public String findDat(String date, String coordinates) {

        Forecast fc = forecastRepository.findByDate(date);
        if (fc == null) {
            Request request = new Request(date, coordinates);
            Weather weather = request.res3();

            String forecast_currently = "Геолокация: " + weather.getTimezone() + "; " +
                    "Дата: " + date + "; " +
                    "Температура: " + weather.getCurrently().getTemperature() + "; " +
                    "Скорость ветра: " + weather.getCurrently().getWindSpeed() + "; " +
                    "Давление: " + weather.getCurrently().getPressure() + "; " +
                    "Влажность: " + weather.getCurrently().getHumidity();


            Forecast forecaste = new Forecast(date, forecast_currently);
            forecastRepository.save(forecaste);
            return forecaste.getForecast();

        } else {
            return fc.getForecast();
        }
    }
}
