
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "temp",
    "pressure",
    "humidity",
    "weather",
    "speed",
    "deg",
    "clouds",
    "rain"
})
public class WeatherDailyList implements Serializable
{

    @JsonProperty("dt")
    public int dt;
    @JsonProperty("temp")
    public Temp temp;
    @JsonProperty("pressure")
    public float pressure;
    @JsonProperty("humidity")
    public int humidity;
    @JsonProperty("weather")
    public java.util.List<WeatherOWM> weather = new ArrayList<WeatherOWM>();
    @JsonProperty("speed")
    public float speed;
    @JsonProperty("deg")
    public int deg;
    @JsonProperty("clouds")
    public int clouds;
    @JsonProperty("rain")
    public float rain;
    private final static long serialVersionUID = 5272458761313028203L;

}
