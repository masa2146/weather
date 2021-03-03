package com.blt.weather.conroller;

import com.blt.weather.model.Weather;
import com.blt.weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.blt.weather.util.APIConstant.*;

/**
 * @author fatih
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(API_PREFIX + API_VERSION + API_WEATHER)
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<Weather> getWeather(@PathVariable("city") String city) {
        try {
            Weather weather = weatherService.getWeather(city);
            return ResponseEntity.ok(weather);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
