
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "city",
    "cod",
    "message",
    "cnt",
    "list"
})
public class WeatherDaily implements Serializable
{

    @JsonProperty("city")
    public City city;
    @JsonProperty("cod")
    public String cod;
    @JsonProperty("message")
    public float message;
    @JsonProperty("cnt")
    public int cnt;
    @JsonProperty("list")
    public List<WeatherDailyList> list = new ArrayList<WeatherDailyList>();
    private final static long serialVersionUID = -5009142278687722405L;

}
