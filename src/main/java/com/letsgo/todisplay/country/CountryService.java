package com.letsgo.todisplay.country;

import java.util.List;

import org.hibernate.boot.model.IdGeneratorStrategyInterpreter.GeneratorNameDeterminationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

	    private CountryRepository countryRepository;

	    public CountryService(CountryRepository countryRepository) {
	        this.countryRepository = countryRepository;
	    }

	    public Page<Country> getPages(String name, String abbreviation, Pageable pageable) {
	        System.out.println("countryService list(name=" + name + ", abbreviation=" + abbreviation + ") by Page" + pageable);
	        if (name == null && abbreviation == null) {
	            return countryRepository.findAll(pageable);
	        } else 
	        	if (name == null) {
	            return countryRepository.findByAbbreviationAllIgnoreCaseStartingWithOrderByCountryAsc(abbreviation, pageable);
	        } else if (abbreviation == null) {
	            return countryRepository.findByCountryAllIgnoreCaseStartingWithOrderByAbbreviationAsc(name, pageable);
	        } else {
	            return countryRepository.findByCountryStartingWithAndAbbreviationAllIgnoreCaseOrderByCountryAsc(name, abbreviation, pageable);
	        }
	    }

	    public Iterable<Country> save(List<Country> cities) {
	        return countryRepository.saveAll(cities);
	    }
	}
