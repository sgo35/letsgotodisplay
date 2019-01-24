package com.letsgo.todisplay.city.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letsgo.todisplay.weather.model.City;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

//	    @GetMapping("/list")
//	    public Iterable<City> list() 
//	    {
//	        return cityService.list();
//	    }

    @GetMapping("/list")
    public Iterable<City> list(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam(name = "size", required = false) String size
            ) {
            if (page == null && size == null) {
                return cityService.list(name, country);
            } else if (page == null) {
                return cityService.list(name, country, PageRequest.of(0, Integer.parseInt(size)));
            } else if (size == null) {
                return cityService.list(name, country, PageRequest.of(Integer.parseInt(page), 10));                
            } else {
                return cityService.list(name, country, PageRequest.of(Integer.parseInt(page), Integer.parseInt(size)));
            }
    }
        
}