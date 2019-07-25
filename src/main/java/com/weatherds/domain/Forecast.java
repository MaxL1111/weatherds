package com.weatherds.domain;


import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "london")
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String date;
    private String forecast_currently;

    public Forecast(String date, String forecast_currently) {
        this.date = date;
        this.forecast_currently = forecast_currently;
    }

    public Forecast() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getForecast() {
        return forecast_currently;
    }

    public void setForecast(String forecast_currently) {
        this.forecast_currently = forecast_currently;
    }

}
