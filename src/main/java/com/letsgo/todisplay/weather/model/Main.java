
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "temp_min",
    "temp_max",
    "pressure",
    "sea_level",
    "grnd_level",
    "humidity",
    "temp_kf"
})
public class Main implements Serializable
{

    @JsonProperty("temp")
    public float temp;
    @JsonProperty("temp_min")
    public float tempMin;
    @JsonProperty("temp_max")
    public float tempMax;
    @JsonProperty("pressure")
    public float pressure;
    @JsonProperty("sea_level")
    public float seaLevel;
    @JsonProperty("grnd_level")
    public float grndLevel;
    @JsonProperty("humidity")
    public int humidity;
    @JsonProperty("temp_kf")
    public int tempKf;
    private final static long serialVersionUID = 3565189907607640471L;

}
