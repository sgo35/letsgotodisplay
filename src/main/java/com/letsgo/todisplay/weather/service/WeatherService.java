package com.letsgo.todisplay.weather.service;

import java.net.URI;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.letsgo.todisplay.WeatherAppProperties;
import com.letsgo.todisplay.handler.SGoResponseErrorHandler;

@Service
public class WeatherService {

	private static final Logger logger = Logger.getLogger(WeatherService.class);
	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/{prefix}?q={city},{country}&APPID={key}&lang={lang}&units={units}&cnt={cnt}";

	private final RestTemplate restTemplate;
	private final String apiUrl;
	private final String apiKey;

	public WeatherService(RestTemplate restTemplate, WeatherAppProperties properties) {
		this.apiKey = properties.getApi().getKey();
		this.apiUrl = WEATHER_URL;
		logger.debug(String.format("WeatherService %s,[%s]", apiUrl, apiKey));
		this.restTemplate = restTemplate;
		this.restTemplate.setErrorHandler(new SGoResponseErrorHandler());
	}

	@Cacheable("weather")
	public <T> T getWeather(String prefix, Class<T> responseType, String city, String country, int cnt) {
		T result;
//		if(validParameters(city, country)) {

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI url = new UriTemplate(this.apiUrl).expand(prefix, city, country, this.apiKey, "fr_fr", "metric", cnt);

		result = invoke(url, responseType);			
//		}

		return result;
	}

	private boolean validParameters(String city, String country) {
		return country != null && !"".equals(country) && city != null && !"".equals(city) && apiKey != null
				&& !"".equals(apiKey) && apiUrl != null && !"".equals(apiUrl);
	}

	private <T> T invoke(URI url, Class<T> responseType) {
		T weather = null;
		try {
			RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
			logger.debug(String.format("url %s", url));
			ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
			weather = exchange.getBody();
			logger.debug(String.format("exchange : %s", exchange));
		} catch (Exception e) {
			logger.error("An error occurred while calling openweathermap.org API endpoint: ", e);
		}

		return weather;
	}
}
