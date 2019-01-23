
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Embeddable
public class Coord implements Serializable
{

    public float lat;
    public float lon;

    public Coord() {}
}
