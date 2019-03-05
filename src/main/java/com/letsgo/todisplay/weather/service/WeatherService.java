package com.letsgo.todisplay.weather.service;

import java.net.URI;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.letsgo.todisplay.WeatherAppProperties;
import com.letsgo.todisplay.city.City;
import com.letsgo.todisplay.city.CityService;
import com.letsgo.todisplay.handler.SGoResponseErrorHandler;

@Service
public class WeatherService {

	private static final Logger logger = Logger.getLogger(WeatherService.class);
	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/{prefix}?APPID={key}&lang={lang}&units={units}";

	private final RestTemplate restTemplate;
	private String apiUrl;
	private final String apiKey;
	
	@Autowired
    private CityService cityService;

	public WeatherService(RestTemplate restTemplate, WeatherAppProperties properties) {
		this.apiKey = properties.getApi().getKey();
		logger.debug(String.format("WeatherService %s,[%s]", apiUrl, apiKey));
		this.restTemplate = restTemplate;
		this.restTemplate.setErrorHandler(new SGoResponseErrorHandler());
	}

//	@Cacheable("weather")
	public <T> T getWeather(String prefix, Class<T> responseType, String city, String cnt) throws Exception {
		return getWeather(prefix, responseType, city, null, cnt, "0", "20");
	}

//	@Cacheable("weather")
	public <T> T getWeather(String prefix, Class<T> responseType, String city) throws Exception {
		return getWeather(prefix, responseType, city, null, "", "0", "20");
	}
	
//	@Cacheable("weather")
    public <T> T getWeather(String prefix, Class<T> responseType, String city, String country, String cnt, String page, String size) throws Exception {
		T result = null;
        this.apiUrl = WEATHER_URL;
//		if(validParameters(city, country)) {

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String filter = "";
		if (city == null) {
		    logger.error(String.format("getWeather error city null", country, cnt));	    
		} else {
		    logger.error(String.format("getWeather filter city=%s", city));
    		if (city.matches("^[+-]?\\d+$")) {
    		    // C'est un ID
    		    filter = String.format("%s",city);
    		    this.apiUrl += "&id={filter}";
    		} else {
    		    // C'est son nom
    		    if (country == null) {
    		        filter = String.format("%s",city);    		    
    		        this.apiUrl += "&q={filter}";
    		    } else {
//    		        final String countryCondition = country != null && country.length() > 0 ? "," + country : "";
    		        City _city = this.cityService.search(city, country, null).iterator().next();
    		        if (_city == null) {
    		            System.out.println("city not found, city=" + city + ", country=" + country);
    		        } else {
    		            filter = _city.getId() + "";    		    
    		            this.apiUrl += "&id={filter}";
    		        }
    		    }
    		}
		}
        if (!"".equals(cnt)) {
            this.apiUrl += "&cnt={cnt}";
        }
		if ("".equals(filter)) { 
		    logger.error(String.format("getWeather error city=%s, country=%s, cnt=%d", city, country, cnt));
		} else {
    		logger.debug("getWeather :" +  this.apiUrl);
    		URI url = new UriTemplate(this.apiUrl).expand(prefix, this.apiKey, "fr_fr", "metric", filter, cnt + "");
    		result = invoke(url, responseType);			
		}

		return result;
	}

//	private boolean validParameters(String city, String country) {
//		return country != null && !"".equals(country) && city != null && !"".equals(city) && apiKey != null
//				&& !"".equals(apiKey) && apiUrl != null && !"".equals(apiUrl);
//	}

	private <T> T invoke(URI url, Class<T> responseType) throws Exception {
		T weather = null;
//		try {
			RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
			logger.debug(String.format("Class %s ; request %s", responseType.getSimpleName(), request));
			ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
			logger.debug(String.format("exchange : %s", exchange));
			if (exchange != null) {
			    weather = exchange.getBody();
			}
//		} catch (Exception e) {
//			logger.error("An error occurred while calling openweathermap.org API endpoint: ", e);
//		}

		return weather;
	}
}
