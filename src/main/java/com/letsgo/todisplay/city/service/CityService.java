package com.letsgo.todisplay.city.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Iterable<City> list(String name, String country) {
        System.out.println("cityService list(name=" + name + ", country=" + country + ")");
        if (name == null && country == null) {
            return cityRepository.findAll();
        } else if (name == null) {
            return cityRepository.findByCountryAllIgnoreCaseContainingOrderByNameAsc(country);            
        } else if (country == null) {
            return cityRepository.findByNameAllIgnoreCaseContainingOrderByCountryAsc(name);
        } else {           
            return cityRepository.findByNameContainingAndCountryAllIgnoreCaseOrderByNameAsc(name, country);
        }
    }
    
    public Page<City> list(String name, String country, Pageable pageable) {
        System.out.println("cityService list(name=" + name + ", country=" + country + ") by Page" + pageable);
        if (name == null && country == null) {
            return cityRepository.findAll(pageable);
        } else if (name == null) {
            return cityRepository.findByCountryAllIgnoreCaseContainingOrderByNameAsc(country, pageable);            
        } else if (country == null) {
            return cityRepository.findByNameAllIgnoreCaseContainingOrderByCountryAsc(name, pageable);
        } else {           
            return cityRepository.findByNameContainingAndCountryAllIgnoreCaseOrderByNameAsc(name, country, pageable);
        }
    }
 
    public Iterable<City> save(List<City> cities) {
        return cityRepository.saveAll(cities);
    }
	}
