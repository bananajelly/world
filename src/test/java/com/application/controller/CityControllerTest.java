package com.application.controller;

import com.application.entity.City;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CityControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void check() {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8080/world-app/api/city", String.class);
        System.out.println(forObject);
        assertTrue("Hello, world".equals(forObject));
    }

    @Test
    public void basicScope() {
        RestTemplate restTemplate = new RestTemplate();
        City city = restTemplate.getForObject("http://localhost:8080/world-app/api/city/5", City.class);
        System.out.println(city);
        assertEquals("Amsterdam", city.getName());
    }
}