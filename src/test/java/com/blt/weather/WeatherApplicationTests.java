package com.blt.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static com.blt.weather.util.APIConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WeatherApplicationTests extends AbstractTest {

    private static final String CITY_API = API_PREFIX + API_VERSION + API_CITY;
    private static final String WEATHER_API = API_PREFIX + API_VERSION + API_WEATHER;

    @Test
    public void testCreateCity() throws Exception {
        String url = CITY_API + "/";
        String inputData = new ObjectMapper().writeValueAsString(getRandomCity());
        System.out.println(inputData);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputData)).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testListCity() throws Exception {
        String url = CITY_API + "/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .content(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testGetCity() throws Exception{
        String url = CITY_API + "/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .content(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testDeleteCity() throws Exception{
        String url = CITY_API + "/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(url)
                .content(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testGetWeather() throws Exception{
        String url = WEATHER_API + "/chicago";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(url)
                .content(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testWeatherAPI() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http").host("api.openweathermap.org/data/2.5/weather")
                .path("").query("q={keyword}&appid={appid}").buildAndExpand("chicago", "1c9770dfaf3b327dd03510a4c07b7f2d");

        assertEquals("http://api.openweathermap.org/data/2.5/weather?q=chicago&appid=1c9770dfaf3b327dd03510a4c07b7f2d", uriComponents.toUriString());
    }
}
