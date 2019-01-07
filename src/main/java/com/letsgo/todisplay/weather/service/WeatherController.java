package com.letsgo.todisplay.weather.service;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsgo.todisplay.WeatherAppProperties;
import com.letsgo.todisplay.weather.model.WeatherDaily;
import com.letsgo.todisplay.weather.model.WeatherForecast;
import com.letsgo.todisplay.weather.model.WeatherNow;

//@CrossOrigin
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

	@GetMapping(value = "/weekly/{country}/{city}", produces = "application/json; charset=utf-8")
	public WeatherForecast getWeatherForecast(@PathVariable String country, @PathVariable String city) {
		logger.debug(String.format("getWeatherForecast %s,%s", city, country));
		return this.weatherService.getWeather("forecast", WeatherForecast.class, city, country, 5);
	}

	@GetMapping(value = "daily/{country}/{city}/{cnt}", produces = "application/json; charset=utf-8")
	public WeatherDaily getWeatherForecast(@PathVariable String country, @PathVariable String city, @PathVariable int cnt) {
		logger.debug(String.format("getWeatherDaily %s,%s", city, country));
		return this.weatherService.getWeather("forecast/daily", WeatherDaily.class, city, country, cnt);
	}
	
	@GetMapping(value = "/now/{country}/{city}", produces = "application/json; charset=utf-8")
	public WeatherNow getWeather(@PathVariable String country, @PathVariable String city) {
		logger.debug(String.format("getWeather %s,%s", city, country));
		return this.weatherService.getWeather("weather", WeatherNow.class, city, country, 1);
	}

}
