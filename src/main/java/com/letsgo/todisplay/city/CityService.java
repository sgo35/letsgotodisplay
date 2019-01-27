package com.letsgo.todisplay.city;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.letsgo.todisplay.country.Country;

import ch.qos.logback.classic.Logger;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

//    https://github.com/json-path/JsonPath

    public Page<City> search(String name, String country, Pageable pageable) {
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
