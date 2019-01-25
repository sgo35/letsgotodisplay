package com.letsgo.todisplay.weather.service;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.letsgo.todisplay.WeatherAppProperties;
import com.letsgo.todisplay.city.service.CityNotFoundException;
import com.letsgo.todisplay.weather.model.WeatherOWMDaily;
import com.letsgo.todisplay.weather.model.WeatherOWMForecast;
import com.letsgo.todisplay.weather.model.WeatherOWMNow;

//@CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/weather")
@RestController
public class WeatherController {
    private static final Logger logger = Logger.getLogger(WeatherController.class);
    private static final String BASE_URL = "http://openweathermap.org";
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService, WeatherAppProperties properties) {
        this.weatherService = weatherService;
    }

    @GetMapping("/icon/{icon}")
    public String getIconByWheater(@PathVariable String icon) {
        return BASE_URL + "/img/w/" + icon + ".png";
//		return "<img src=\"" + uri_base + "/img/w/" + icon + ".png\"</img>";
    }

//	   @RequestMapping("/now/{country}/{city}")
//	    public WeatherForecast getWeather(@PathVariable String country,
//	            @PathVariable String city) {
//	        return this.weatherService.getWeather(country, city);
//	    }

//	@GetMapping(value = "/forecast/{city}", produces = "application/json; charset=utf-8")
//	public WeatherOWMForecast getWeatherForecast(@PathVariable String city) {
//		logger.debug(String.format("getWeatherForecast %s", city));
//		return this.weatherService.getWeather("forecast", WeatherOWMForecast.class, city);
//	}
//	
    @GetMapping(value = "/forecast", produces = "application/json; charset=utf-8")
    public WeatherOWMForecast getWeatherForecast(@RequestParam(name = "city", required = true) String city,
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam(name = "size", required = false) String size) {
        logger.debug(String.format("getWeatherForecast city=%s,country=%s", city, country));
        try {
            return this.weatherService.getWeather("forecast", WeatherOWMForecast.class, city, country, "", page, size);
        } catch (CityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City Not Found", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Weather Not Found", e);
        }
    }

    @GetMapping(value = "/daily", produces = "application/json; charset=utf-8")
    public WeatherOWMDaily getWeatherDaily(@RequestParam(name = "city", required = true) String city,
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "cnt", required = false) String cnt, @RequestParam(name = "page", required = false) String page,
            @RequestParam(name = "size", required = false) String size) {
        try {
            logger.debug(String.format("getWeatherDaily %s,%s, %s", city, country, cnt));
            return this.weatherService.getWeather("forecast/daily", WeatherOWMDaily.class, city, country, cnt, page, size);
        } catch (CityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City Not Found", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Weather Not Found", e);
        }
    }

    @GetMapping(value = "/current", produces = "application/json; charset=utf-8")
    public WeatherOWMNow getWeather(@RequestParam(name = "city", required = true) String city,
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam(name = "size", required = false) String size) {
        try {
            logger.debug(String.format("getWeatherCurrent %s,%s", city, country));
            return this.weatherService.getWeather("weather", WeatherOWMNow.class, city, country, "", page, size);
        } catch (CityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City Not Found", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Weather Not Found", e);
        }
    }

}
