package com.letsgo.todisplay.city.model;

import org.springframework.data.repository.CrudRepository;

import com.letsgo.todisplay.weather.model.City;

public interface CityRepository extends CrudRepository<City, Long> {
	}
	