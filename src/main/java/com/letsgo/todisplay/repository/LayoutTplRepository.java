package com.letsgo.todisplay.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.letsgo.todisplay.model.MeteoData;

public class MeteoRepository implements CrudRepository<MeteoData, Long> {

    public MeteoRepository() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(MeteoData arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends MeteoData> arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Long arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean existsById(Long arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<MeteoData> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<MeteoData> findAllById(Iterable<Long> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<MeteoData> findById(Long arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MeteoData> S save(S arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends MeteoData> Iterable<S> saveAll(Iterable<S> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

}
