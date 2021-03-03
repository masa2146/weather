package com.blt.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fatih
 */
@Data
@NoArgsConstructor
public class WeatherUrl {
    private String url;
    private String apiKey;
}
