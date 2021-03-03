package com.blt.weather.repository;

import com.blt.weather.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fatih
 */
@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
