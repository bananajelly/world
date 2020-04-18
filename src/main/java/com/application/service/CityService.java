package com.application.service;

import com.application.entity.City;
import com.application.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    private final CityMapper cityMapper;

    @Autowired
    public CityService(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public List<City> getAllCities() {
        return cityMapper.getAllCities();
    }

    public City getCity(Integer id) {
        return cityMapper.getCity(id);
    }

    public City saveCity(City city) {
        cityMapper.saveCity(city);
        return city;
    }

    public City updateCity(City city) {
        cityMapper.updateCity(city);
        return city;
    }

    @Transactional
    public void deleteCity(Integer id) {
        cityMapper.deleteCity(id);
        try {
            doSmth();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doSmth() throws InterruptedException {
        Thread.sleep(1000);
        throw new RuntimeException();
    }
}
