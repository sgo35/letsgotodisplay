package com.letsgo.todisplay.city.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.letsgo.todisplay.city.model.CityRepository;
import com.letsgo.todisplay.weather.model.City;

import ch.qos.logback.classic.Logger;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

//    https://github.com/json-path/JsonPath
    public City first(String id, String name, String country) throws CityNotFoundException {
        System.out.println("cityService list(id=" + id + "name=" + name + ", country=" + country + ")");
        if (id == null) {
            if (name == null && country == null) {
                return cityRepository.findFirstByNameStartingWithAndCountryAllIgnoreCaseOrderByNameAsc("Paris", "FR");
            } else if (name == null) {
                return cityRepository.findFirstByCountryAllIgnoreCaseOrderByNameAsc(country);
            } else if (country == null) {
                return cityRepository.findFirstByNameStartingWithAllIgnoreCaseOrderByNameAsc(name);
            } else {
                return cityRepository.findFirstByNameStartingWithAndCountryAllIgnoreCaseOrderByNameAsc(name, country);
            }
        } else {
            return cityRepository.findById(Integer.parseInt(id));
        }
    }

    public Iterable<City> list(String name, String country) {
        System.out.println("cityService list(name=" + name + ", country=" + country + ")");
        if (name == null && country == null) {
            return cityRepository.findAll();
        } else if (name == null) {
            return cityRepository.findByCountryAllIgnoreCaseStartingWithOrderByNameAsc(country);
        } else if (country == null) {
            return cityRepository.findByNameAllIgnoreCaseStartingWithOrderByCountryAsc(name);
        } else {
            return cityRepository.findByNameStartingWithAndCountryAllIgnoreCaseOrderByNameAsc(name, country);
        }
    }

    public Page<City> list(String name, String country, Pageable pageable) {
        System.out.println("cityService list(name=" + name + ", country=" + country + ") by Page" + pageable);
        if (name == null && country == null) {
            return cityRepository.findAll(pageable);
        } else if (name == null) {
            return cityRepository.findByCountryAllIgnoreCaseStartingWithOrderByNameAsc(country, pageable);
        } else if (country == null) {
            return cityRepository.findByNameAllIgnoreCaseStartingWithOrderByCountryAsc(name, pageable);
        } else {
            return cityRepository.findByNameStartingWithAndCountryAllIgnoreCaseOrderByNameAsc(name, country, pageable);
        }
    }

    public Iterable<City> save(List<City> cities) {
        return cityRepository.saveAll(cities);
    }
}
