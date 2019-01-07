package com.letsgo.todisplay.service;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.letsgo.todisplay.WeatherAppProperties;
import com.letsgo.todisplay.handler.SGoResponseErrorHandler;
import com.letsgo.todisplay.model.Weather;

@Service
public class WeatherService {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";
    private static final String FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?q={city},{country}&APPID={key}";
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    private final RestTemplate restTemplate;
	private final String apiUrl;
	private final String apiKey;

	public WeatherService(RestTemplate restTemplate, WeatherAppProperties properties) {
		this.restTemplate = restTemplate;
		this.restTemplate.setErrorHandler(new SGoResponseErrorHandler());
		this.apiKey = properties.getApi().getKey();
		this.apiUrl = FORECAST_URL;
	}

	@Cacheable("weather")
	public Weather getWeather(String city, String country){
		logger.debug("Requesting current weather for {},[{}]", city, country);
		logger.debug("API key {} , url {}", apiKey, apiUrl);
		Weather weather = null;
		if(validParameters(city, country)) {
			URI url = new UriTemplate(this.apiUrl).expand(city, country, this.apiKey);

			weather = invoke(url, Weather.class);
		}
		logger.debug("weather {}", weather);
		return weather;
	}

	private boolean validParameters(String city, String country) {
		return  country !=null && !"".equals(country) && city !=null && !"".equals(city) && apiKey !=null && !"".equals(apiKey) && apiUrl!=null && !"".equals(apiUrl);
	}

	private <T> T invoke(URI url, Class<T> responseType){
		T weather = null;
		try {
			RequestEntity<?> request = RequestEntity.get(url)
			        .accept(MediaType.APPLICATION_JSON).build();
			ResponseEntity<T> exchange = this.restTemplate
					.exchange(request, responseType)
					;
			weather = exchange.getBody();
		} catch(Exception e){
				logger.error("An error occurred while calling openweathermap.org API endpoint:  " + e.getMessage());
		}

		return weather;
	}
}
