package com.letsgo.todisplay.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

//@CrossOrigin
@RequestMapping("/api/weather")
@RestController
public class WeatherController {
	final String uri_forecast = "http://api.openweathermap.org/data/2.5/forecast";
	final String uri_base = "http://openweathermap.org";
	final String APPID = "2154cbadaa3015485f10fff459f8d611";
	// Parameters
	//	https://openweathermap.org/weather-data

	@GetMapping("/icon/{icon}")
	public String getIconByWheater(@PathVariable String icon) {
		return uri_base + "/img/w/" + icon + ".png";
//		return "<img src=\"" + uri_base + "/img/w/" + icon + ".png\"</img>";
	}


	@GetMapping("/{city}")
	public HttpEntity<String> getWheaterByCity(@PathVariable String city) {
		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format 
		headers.setContentType(MediaType.APPLICATION_JSON);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri_forecast).queryParam("APPID", APPID)
				.queryParam("q", city).queryParam("lang", "fr_fr").queryParam("units", "metric")
//				.queryParam("cnt", 10)
//				.queryParam("callback", "test")
		;

		HttpEntity<?> entity = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

		System.out.println(result);
		return result;
	}
}
