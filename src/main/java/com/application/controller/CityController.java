package com.application.controller;

import com.application.entity.City;
import com.application.mapper.CityMapper;
import com.application.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityMapper cityMapper;
    private final CityService cityService;

    @Autowired
    public CityController(CityMapper cityMapper, CityService cityService) {
        this.cityMapper = cityMapper;
        this.cityService = cityService;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityMapper.getAllCities();
        return ResponseEntity.status(HttpStatus.OK).body(cities);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCity(@PathVariable String id) {
        City city = cityMapper.getCity(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<City> getCity(@PathVariable String id) {
//        City city = cityService.getCity(Integer.parseInt(id));
//        return ResponseEntity.status(HttpStatus.OK).body(city);
//    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        cityMapper.saveCity(city);
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> saveCity2(@RequestBody City city) {
        city = cityService.saveCity(city);
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        cityMapper.updateCity(city);
        return ResponseEntity.status(HttpStatus.OK).body(city);
    }

    @DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCity(@RequestBody City city) {
        cityService.deleteCity(city.getId());
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @GetMapping("/check-condition")
    public String check() {
        return getClass().getName() + " status: OK";
    }
}
