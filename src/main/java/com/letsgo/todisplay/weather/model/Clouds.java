
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "all"
})
public class Clouds implements Serializable
{

    @JsonProperty("all")
    public int all;
    private final static long serialVersionUID = -5603659274715526985L;

}
