package com.blt.weather.config;

import com.blt.weather.model.WeatherUrl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author fatih
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan
public class WeatherConfigurations {

    @Value("${weather.url}")
    private String url;

    @Value("${weather.apiKey}")
    private String apiKey;

    @Bean
    public WeatherUrl weatherUrl() {
        WeatherUrl weatherUrl = new WeatherUrl();
        weatherUrl.setUrl(url);
        weatherUrl.setApiKey(apiKey);
        return weatherUrl;
    }
}
