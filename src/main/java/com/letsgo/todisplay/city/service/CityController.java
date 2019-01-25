package com.letsgo.todisplay.city.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.letsgo.todisplay.weather.model.City;

@CrossOrigin
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/city")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/list")
    public Iterable<City> list(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam(name = "size", required = false) String size
            ) {
        System.out.println(String.format("cities name=%s, country=%s, page=%s, size=%s", name, country, page, size));
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
        
    @GetMapping("/first")
    public City first(
            @RequestParam(name = "id", required = false) String id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "country", required = false) String country
            ) {
        try {
        System.out.println(String.format("city first name=%s, country=%s", name, country));
            return cityService.first(id, name, country);
        } catch (CityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City Not Found", e);
        }
    }
    
}