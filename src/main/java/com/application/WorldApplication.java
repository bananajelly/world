package com.application;

import com.application.entity.City;
import com.application.mapper.CityMapper;
import com.application.service.CityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class WorldApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-context.xml");
//        CityMapper cityMapper = context.getBean(CityMapper.class);
//        City city = cityMapper.getCity(10);
//        System.out.println(city);

        // cityMapper.getAllCities().forEach(System.out::println);

        CityService cityService = context.getBean(CityService.class);
//        cityService.setCityMapper(cityMapper);
        cityService.getAllCities().forEach(System.out::println);

    }
}
