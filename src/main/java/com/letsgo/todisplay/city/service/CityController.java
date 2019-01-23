package com.letsgo.todisplay.city.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsgo.todisplay.weather.model.City;

@RestController
@RequestMapping("/api/city")
public class CityController {

	    private CityService cityService;

	    public CityController(CityService cityService) {
	        this.cityService = cityService;
	    }

	    @GetMapping("/list")
	    public Iterable<City> list() {
	        return cityService.list();
	    }
	}