package com.blt.weather.conroller;

import com.blt.weather.RecordNotFoundException;
import com.blt.weather.model.City;
import com.blt.weather.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.blt.weather.util.APIConstant.*;

/**
 * @author fatih
 */
@RestController
@RequestMapping(API_PREFIX + API_VERSION + API_CITY)
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/all")
    public ResponseEntity<List<City>> getAllCity() {
        List<City> allCities = cityService.getAllCities();
        return ResponseEntity.ok().body(allCities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable("id") Long id) {
        try {
            City city = cityService.getCityById(id);
            return ResponseEntity.ok(city);
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        try {
            City newCity = cityService.createOrUpdateCity(city);
            return ResponseEntity.ok(newCity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Long id) {
        try {
            cityService.deleteCityById(id);
            return ResponseEntity.ok().build();
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

}
