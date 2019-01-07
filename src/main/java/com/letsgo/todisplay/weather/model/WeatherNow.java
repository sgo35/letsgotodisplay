
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coord",
    "weather",
    "base",
    "main",
    "visibility",
    "wind",
    "clouds",
    "dt",
    "sys",
    "id",
    "name",
    "cod"
})
public class WeatherNow implements Serializable
{

    @JsonProperty("coord")
    public Coord coord;
    @JsonProperty("weather")
    public List<Weather> weather = new ArrayList<Weather>();
    @JsonProperty("base")
    public String base;
    @JsonProperty("main")
    public Main main;
    @JsonProperty("visibility")
    public int visibility;
    @JsonProperty("wind")
    public Wind wind;
    @JsonProperty("clouds")
    public Clouds clouds;
    @JsonProperty("dt")
    public int dt;
    @JsonProperty("sys")
    public Sys sys;
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("cod")
    public int cod;
    private final static long serialVersionUID = -3016104722327592196L;

}
