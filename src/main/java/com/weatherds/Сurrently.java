package com.weatherds;

import org.springframework.stereotype.Component;

@Component
public class Сurrently {

    private String summary;
    private String temperature;
    private String windSpeed;
    private String pressure;
    private String humidity;


    public String getSummary() {
        return summary;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }
}
