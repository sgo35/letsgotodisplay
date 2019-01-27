package com.letsgo.todisplay.country;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letsgo.todisplay.city.City;

	@CrossOrigin
	@RestController
	public class CountryController {

	    private CountryService countryService;

	    public CountryController(CountryService countryService) {
	        this.countryService = countryService;
	    }

		@GetMapping("/api/countries/search")
		public Page<Country> getList(
				@RequestParam(name = "country", required = false) String country
				, @RequestParam(name = "abbreviation", required = false) String abbreviation
				, @RequestParam(name = "page", required = false) String page
				, @RequestParam(name = "limit", required = false) String limit
				) {
			System.out.println(String.format("countries abbreviation=%s, country=%s, page=%s, size=%s", abbreviation, country, page, limit));
			return countryService.getPages(country, abbreviation, PageRequest.of(page == null || limit == null ? 0 : Integer.parseInt(page),
					limit == null ? Integer.MAX_VALUE : Integer.parseInt(limit)));
		}

	}