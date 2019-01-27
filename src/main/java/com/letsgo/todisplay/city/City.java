
package com.letsgo.todisplay.city;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.letsgo.todisplay.weather.model.Coord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
//@ToString(exclude = "country2")
//@RequiredArgsConstructor(staticName = "of") 
public class City
{
    @Id
	private long id;
    private String name;
    private String country;
    @Embedded
    private Coord coord;
    private int population = 0;
    
//    @ManyToOne
//    @JoinColumn(name = "country_abbreviation")
//    @RestResource(path = "city_country", rel="country")
//    private Country country2;
    
//    @ManyToOne
//    @JoinColumn(name="country_abbreviation", nullable=false, insertable=false, updatable=false, referencedColumnName = "country")
//    private Country countryLink;
    
}
