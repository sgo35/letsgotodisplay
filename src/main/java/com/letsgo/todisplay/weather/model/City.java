
package com.letsgo.todisplay.weather.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class City
{
    @Id
	public int id;
    public String name;
    public String country;
    @Embedded
    public Coord coord;
    public int population = 0;
    
    public City() {}
}
