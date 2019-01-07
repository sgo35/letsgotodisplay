
package com.letsgo.todisplay.weather.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "3h"
})
public class Rain implements Serializable
{

    @JsonProperty("3h")
    public float _3h;
    private final static long serialVersionUID = -3466019563701149071L;

}
