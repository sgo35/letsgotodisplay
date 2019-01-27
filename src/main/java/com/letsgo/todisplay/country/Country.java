package com.letsgo.todisplay.country;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
//@ToString(exclude = "cities")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String country;
//	@OneToMany(mappedBy = "city_country")
	private String abbreviation;

//	@OneToMany(mappedBy = "country")
//	private Set<City> cities;
    public Country(String country, String abbreviation) {
        this.country = country;
        this.abbreviation = abbreviation;
    }

}