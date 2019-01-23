package com.letsgo.todisplay.city.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.letsgo.todisplay.city.model.CityRepository;
import com.letsgo.todisplay.weather.model.City;

@Service
public class CityService {

    private CityRepository cityRepository;
    
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
 
//    https://github.com/json-path/JsonPath
    public Iterable<City> list() {
        return cityRepository.findAll();
    }
 
    public Iterable<City> save(List<City> cities) {
        return cityRepository.saveAll(cities);
    }
	}
