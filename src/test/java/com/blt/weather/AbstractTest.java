package com.blt.weather;

import com.blt.weather.model.City;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author fatih
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public abstract class AbstractTest {
    @Autowired
    protected MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationContext;


    protected List<City> createCityList() {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("Ankara", "Turkey"));
        cityList.add(new City("Istanbul", "Turkey"));
        cityList.add(new City("Elazig", "Turkey"));
        cityList.add(new City("Malatya", "Turkey"));
        cityList.add(new City("Chicago", "USA"));
        cityList.add(new City("California", "USA"));
        cityList.add(new City("London", "UK"));

        return cityList;
    }

    protected City getRandomCity() {
        List<City> cityList = createCityList();
        Random randomIndex = new Random();
        return cityList.get(randomIndex.nextInt(cityList.size() - 1));
    }

}