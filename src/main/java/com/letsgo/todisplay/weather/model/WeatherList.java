
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "main",
    "weather",
    "clouds",
    "wind",
    "rain",
    "sys",
    "dt_txt"
})
public class WeatherList implements Serializable
{

    @JsonProperty("dt")
    public int dt;
    @JsonProperty("main")
    public Main main;
    @JsonProperty("weather")
    public List<Weather> weather = new ArrayList<Weather>();
    @JsonProperty("clouds")
    public Clouds clouds;
    @JsonProperty("wind")
    public Wind wind;
    @JsonProperty("rain")
    public Rain rain;
    @JsonProperty("sys")
    public Sys sys;
    @JsonProperty("dt_txt")
    public String dtTxt;
    private final static long serialVersionUID = -2919077435233109871L;

}
