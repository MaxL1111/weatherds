package com.weatherds.repos;

import com.weatherds.domain.Forecast;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForecastRepositoryImp implements ForecastRepository {


    @Override
    public Forecast findByDate(String date) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Forecast.class, date);
    }

    @Override
    public <S extends Forecast> S save(S s) {
        return null;
    }

    @Override
    public <S extends Forecast> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Forecast> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Forecast> findAll() {
        return null;
    }

    @Override
    public Iterable<Forecast> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Forecast forecast) {

    }

    @Override
    public void deleteAll(Iterable<? extends Forecast> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
