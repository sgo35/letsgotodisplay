package com.letsgo.todisplay.country;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
	
    // Retourne le premier de la liste selon le début d'un nom de commune et/ou un pays
    Country findFirstByAbbreviationAllIgnoreCaseOrderByCountryAsc(String abbreviation);
    Country findFirstByCountryStartingWithAllIgnoreCaseOrderByCountryAsc(String country);
    Country findFirstByCountryStartingWithAndAbbreviationAllIgnoreCaseOrderByCountryAsc(String country, String abbreviation);
    
//    Iterable<Country> findByCountryStartingWithAndAbbreviationAllIgnoreCaseOrderByCountryAsc(String country, String abbreviation);
//    Iterable<Country> findByCountryAllIgnoreCaseStartingWithOrderByAbbreviationAsc(String country);
//    Iterable<Country> findByAbbreviationAllIgnoreCaseStartingWithOrderByCountryAsc(String abbreviation);
    
    // per page
    Page<Country> findByCountryStartingWithAndAbbreviationAllIgnoreCaseOrderByCountryAsc(String country, String abbreviation, Pageable pageable);
    Page<Country> findByCountryAllIgnoreCaseStartingWithOrderByAbbreviationAsc(String country, Pageable pageable);
    Page<Country> findByAbbreviationAllIgnoreCaseStartingWithOrderByCountryAsc(String abbreviation, Pageable pageable);
    Page<Country> findAll(Pageable pageable);
	
	
}
