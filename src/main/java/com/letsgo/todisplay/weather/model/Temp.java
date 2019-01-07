
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "day",
    "min",
    "max",
    "night",
    "eve",
    "morn"
})
public class Temp implements Serializable
{

    @JsonProperty("day")
    public float day;
    @JsonProperty("min")
    public float min;
    @JsonProperty("max")
    public float max;
    @JsonProperty("night")
    public float night;
    @JsonProperty("eve")
    public float eve;
    @JsonProperty("morn")
    public float morn;
    private final static long serialVersionUID = 5412350532270253643L;

}
