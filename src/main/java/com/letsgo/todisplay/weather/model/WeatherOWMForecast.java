
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cod",
    "message",
    "cnt",
    "list",
    "city"
})
public class WeatherOWMForecast implements Serializable
{

    @JsonProperty("cod")
    public String cod;
    @JsonProperty("message")
    public float message;
    @JsonProperty("cnt")
    public int cnt;
    @JsonProperty("list")
    public List<WeatherList> list = new ArrayList<WeatherList>();
    @JsonProperty("city")
    public City city;
    private final static long serialVersionUID = -8254215406530381764L;

}
