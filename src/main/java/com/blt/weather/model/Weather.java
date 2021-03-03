package com.blt.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author fatih
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Weather implements Serializable {

    private static final long serialVersionUID = 3937462346144036240L;

    private String weatherDescription;

    @JsonProperty("lon")
    private double lon;
    @JsonProperty("lat")
    private double lat;

    @JsonProperty("name")
    private String name;

    @JsonProperty("main")
    private Main main;

    @Bean
    public Weather weather() {
        return new Weather();
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        weatherDescription = (String) weather.get("description");
    }

    @JsonProperty("coord")
    public void setCoord(Map<String, Object> coord) {
        lon = (double) coord.get("lon");
        lat = (double) coord.get("lat");
    }

    @ToString
    @Data
    static class Main {
        @JsonProperty("temp")
        private double temp;

        @JsonProperty("feels_like")
        private double feelsLike;

        @JsonProperty("temp_min")
        private double tempMin;

        @JsonProperty("temp_max")
        private double tempMax;

        @JsonProperty("pressure")
        private double pressure;

        @JsonProperty("humidity")
        private double humidity;
    }
}
