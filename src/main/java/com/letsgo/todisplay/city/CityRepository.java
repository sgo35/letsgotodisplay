package com.letsgo.todisplay.city;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
    // Retourne le premier de la liste selon le début d'un nom de commune et/ou un pays
    City findFirstByCountryAllIgnoreCaseOrderByNameAsc(String country);
    City findFirstByNameStartingWithAllIgnoreCaseOrderByNameAsc(String name);
    City findFirstByNameStartingWithAndCountryAllIgnoreCaseOrderByNameAsc(String name, String country);
    
//    Iterable<City> findByNameStartingWithAndCountryAllIgnoreCaseOrderByNameAsc(String name, String country);
//    Iterable<City> findByNameAllIgnoreCaseStartingWithOrderByCountryAsc(String name);
//    Iterable<City> findByCountryAllIgnoreCaseStartingWithOrderByNameAsc(String country);
    
    Page<City> findByNameStartingWithAndCountryAllIgnoreCaseOrderByNameAsc(String name, String country, Pageable pageable);
    Page<City> findByNameAllIgnoreCaseStartingWithOrderByCountryAsc(String name, Pageable pageable);
    Page<City> findByCountryAllIgnoreCaseStartingWithOrderByNameAsc(String country, Pageable pageable);
    Page<City> findAll(Pageable pageable);
}
	