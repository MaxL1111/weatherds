package com.weatherds;

import com.google.gson.Gson;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class Request {

    public String coordinates;
    public String date;

    public Request(String date, String coordinates) {
        this.coordinates = coordinates;
        this.date = date;
    }

    public Weather res3() {

        //формируем url запрос
        Urlcreate urlcreate = new Urlcreate(this.date, this.coordinates);
        long datetimestamp = urlcreate.getDateparse();
        String url = urlcreate.getUrl(datetimestamp);

        //выполняем запрос и получаем результат json
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        final String response = restTemplate.getForObject(url, String.class);

        //разбираем json
        Gson gson = new Gson();
        Weather weather = gson.fromJson(response, Weather.class);
        return weather;
    }
}
