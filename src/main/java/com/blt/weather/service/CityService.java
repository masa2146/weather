package com.blt.weather.service;

import com.blt.weather.exception.RecordNotFoundException;
import com.blt.weather.model.City;
import com.blt.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author fatih
 */
@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> getAllCities() {
        List<City> all = cityRepository.findAll();
        return all;
    }

    public City getCityById(Long id) throws RecordNotFoundException {
        return cityRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("City with ID " + id + " not found"));
    }

    public City createOrUpdateCity(City entity) {
        if (entity.getId() != null) {
            Optional<City> city = cityRepository.findById(entity.getId());
            if (city.isPresent()) {
                City newCity = city.get();
                newCity.setCountry(entity.getCountry());
                newCity.setName(entity.getName());
                cityRepository.save(newCity);
                return newCity;
            } else {
                return cityRepository.save(entity);
            }
        } else {
            return cityRepository.save(entity);
        }
    }

    public void deleteCityById(Long id) throws RecordNotFoundException {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            cityRepository.delete(city.get());
        } else {
            throw new RecordNotFoundException("City with ID " + id + " not found");
        }
    }


}
