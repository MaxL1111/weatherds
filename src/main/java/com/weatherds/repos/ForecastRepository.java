package com.weatherds.repos;

import com.weatherds.domain.Forecast;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface ForecastRepository extends CrudRepository<Forecast, Integer> {

    Forecast findByDate(String date);

}
