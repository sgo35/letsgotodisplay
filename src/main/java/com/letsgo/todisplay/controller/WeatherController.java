package com.letsgo.todisplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsgo.todisplay.model.WeatherForecast;
import com.letsgo.todisplay.service.WeatherService;

//@CrossOrigin
@RequestMapping("/api/weather")
@RestController
public class WeatherController {
//    private static final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast";
//    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String BASE_URL = "http://openweathermap.org";
	// Parameters
	//	https://openweathermap.org/weather-data

    
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
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

	    @RequestMapping("/weekly/{country}/{city}")
	    public WeatherForecast getWeatherForecast(@PathVariable String country,
	            @PathVariable String city) {
	        return this.weatherService.getWeatherForecast(country, city);
	}
	    
	
//	@GetMapping("/{city}")
//	public HttpEntity<String> getWheaterByCity(@PathVariable String city) throws UnsupportedEncodingException {
//		// HttpHeaders
//		HttpHeaders headers = new HttpHeaders();
//
//		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
//		// Request to return JSON format 
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FORECAST_URL)
//		        .queryParam("q", city)
//		        .queryParam("APPID", APPID)
//				.queryParam("lang", "fr_fr")
//				.queryParam("units", "metric")
////				.queryParam("cnt", 10)
////				.queryParam("callback", "test")
//		;
//
//		System.out.println("getWheaterByCity " + city );
//		HttpEntity<?> entity = new HttpEntity<>(headers);
//
//		System.out.println(builder.toUriString());
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<String> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
//		System.out.println(result);
//
//		return result;
//	}
	
	
    }
