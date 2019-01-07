
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "speed",
    "deg"
})
public class Wind implements Serializable
{

    @JsonProperty("speed")
    public float speed;
    @JsonProperty("deg")
    public int deg;
    private final static long serialVersionUID = 6870374836994983027L;

}
