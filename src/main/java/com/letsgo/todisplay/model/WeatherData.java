package com.letsgo.todisplay.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Extrait de https://github.com/migtavares/owmClient
 * https://openweathermap.org/api
 * 
 * @author s.goudard
 *
 */
@Entity
public class WeatherData {
    protected static final String JSON_DATE_TIME = "dt";
    protected static final String JSON_MAIN = "main";
    protected static final String JSON_WIND = "wind";
    protected static final String JSON_RAIN = "rain";
    protected static final String JSON_SNOW = "snow";

    protected static final String JSON_TEMP = "temp";
    protected static final String JSON_TEMP_MIN = "temp_min";
    protected static final String JSON_TEMP_MAX = "temp_max";
    protected static final String JSON_HUMIDITY = "humidity";
    protected static final String JSON_PRESSURE = "pressure";

//    private final long dateTime;

//    public MeteoData (JSONObject json) {
//        this.dateTime = json.optLong (WeatherData.JSON_DATE_TIME, Long.MIN_VALUE);
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    /**
     * the temperature of this weather report
     * 
     * @return <code>Float.NaN</code> if the report doesn't have temperature data; the value of the temperature in Kelvin otherwise.
     */
    private float temp;

    /**
     * the humidity of this weather report
     * 
     * @return <code>Float.NaN</code> if the report doesn't have humidity data; the value of the humidity in percentage to condensation poprivate int otherwise.
     */
    private float humidity;

    /**
     * the atmospheric pressure of this weather report
     * 
     * @return <code>Float.NaN</code> if the report doesn't have pressure data; the value of the pressure in hectopascal otherwise.
     */
    private float pressure;

    /**
     * the average wind speed of this weather report
     * 
     * @return <code>Float.NaN</code> if the report doesn't have wind speed data; the value of the wind speed in metre per second otherwise.
     */
    private float windSpeed;

    /**
     * the wind gust speed of this weather report
     * 
     * @return <code>Float.NaN</code> if the report doesn't have wind gust speed data; the value of the wind gust speed in metre per second otherwise.
     */
    private float windGust;

    /**
     * the average wind direction of this weather report
     * 
     * @return <code>Integer.MIN_VALUE</code> if the report doesn't have wind direction data; the degree of the wind direction otherwise.
     */
    private int windDeg;

    /**
     * the rain amount of this weather report
     * 
     * @return <code>Integer.MIN_VALUE</code> if the report doesn't have rain data; the amount of rain in mm per hour otherwise.
     */
    private int rain;

    /**
     * the snow amount of this weather report
     * 
     * @return <code>Integer.MIN_VALUE</code> if the report doesn't have snow data; the amount of snow in mm per hour otherwise.
     */
    private int snow;

    /**
     * the amount of precipitation in this weather report
     * 
     * @return <code>Integer.MIN_VALUE</code> if the report doesn't have precipitation data; the amount of precipitation in mm per hour otherwise.
     */
    private int precipitation;
}
