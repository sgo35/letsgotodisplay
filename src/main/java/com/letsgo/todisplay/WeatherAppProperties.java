package com.letsgo.todisplay;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("app.weather")
public class WeatherAppProperties {

    @Valid
    @Getter
    private final Api api = new Api();

    /**
     * Comma-separated list of locations to display. Each entry should have the
     * form "Country/City".
     */
    @Getter
    @Setter
    private List<String> locations = Arrays.asList("FR/Rennes", "Russia/Moscow");

    public static class Api {

        /**
         * API key of the OpenWeatherMap service.
         */
        @NotNull
        @Getter
        @Setter
        private String key;
    }

}
