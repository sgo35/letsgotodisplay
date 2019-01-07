
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lon"
})
public class Coord implements Serializable
{

    @JsonProperty("lat")
    public float lat;
    @JsonProperty("lon")
    public float lon;
    private final static long serialVersionUID = 1469268022845139537L;

}
