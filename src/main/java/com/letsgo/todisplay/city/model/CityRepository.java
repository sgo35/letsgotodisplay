package com.letsgo.todisplay.city.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.letsgo.todisplay.weather.model.City;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findByNameContainingAndCountryAllIgnoreCaseOrderByNameAsc(String name, String country);
    List<City> findByNameAllIgnoreCaseContainingOrderByCountryAsc(String name);
    List<City> findByCountryAllIgnoreCaseContainingOrderByNameAsc(String country);
    
    Page<City> findByNameContainingAndCountryAllIgnoreCaseOrderByNameAsc(String name, String country, Pageable pageable);
    Page<City> findByNameAllIgnoreCaseContainingOrderByCountryAsc(String name, Pageable pageable);
    Page<City> findByCountryAllIgnoreCaseContainingOrderByNameAsc(String country, Pageable pageable);
    Page<City> findAll(Pageable pageable);
}
	