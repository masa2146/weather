package com.blt.weather.service;

import com.blt.weather.model.Weather;
import com.blt.weather.model.WeatherUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author fatih
 */
@Service
public class WeatherService {

    @Autowired
    private WeatherUrl weatherUrl;

    @Autowired
    private RestTemplate restTemp;

    public Weather getWeather(String city) throws JsonProcessingException {
        UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(weatherUrl.getUrl())
                .path("")
                .query("q={keyword}&appid={appid}")
                .buildAndExpand(city, weatherUrl.getApiKey());

        String uri = uriComponents.toUriString();
        ResponseEntity<String> resp = restTemp.exchange(uri, HttpMethod.GET, null, String.class);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resp.getBody(), Weather.class);
    }
}
