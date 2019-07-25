package com.weatherds;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Urlcreate {
    private String coordinates;
    private String date;
    private long dateparse;
    private String url_employees_json = "https://api.darksky.net/forecast/31745226713ce5c416d3ad416512990c/";
    private String url;

    public Urlcreate(String date, String coordinates) {
        this.coordinates = coordinates;
        this.date = date;
    }


    public long getDateparse() {

        try {
            long millis = new SimpleDateFormat("yyyy-MM-dd").parse(this.date).getTime();
            this.dateparse = millis / 1000 + 86400;
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return dateparse;
    }

    public String getUrl(long date) {
        this.url = this.url_employees_json + this.coordinates + "," + date + "?units=si";
        return url;
    }
}
