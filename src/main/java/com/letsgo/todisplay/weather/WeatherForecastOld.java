package com.letsgo.todisplay.weather;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class WeatherForecastOld implements Serializable {

	private String name;
//    private String country;

    private List<WeatherEntry> entries = new ArrayList<>();

    @JsonProperty("entries")
    public List<WeatherEntry> getEntries() {
        return this.entries;
    }

    @JsonSetter("list")
    public void setEntries(List<WeatherEntry> entries) {
        this.entries = entries;
    }

    @JsonProperty("city")
    public void setCity(Map<String, Object> city) {
        setName(city.get("name").toString());
    }

}