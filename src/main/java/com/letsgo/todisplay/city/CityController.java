package com.letsgo.todisplay.city;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CityController {

	private CityService cityService;

	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping("/api/cities/search")
	public Page<City> search(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "country", required = false) String country,
			@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String limit) {
		System.out.println(String.format("cities name=%s, country=%s, page=%s, limit=%s", name, country, page, limit));
		return cityService.search(name, country, PageRequest.of(page == null || limit == null ? 0 : Integer.parseInt(page),
				limit == null ? Integer.MAX_VALUE : Integer.parseInt(limit)));
	}

}