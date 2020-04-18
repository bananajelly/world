package com.application.mapper;

import com.application.entity.City;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Component
public interface CityMapper {
    @Select("select * from city")
    List<City> getAllCities();

    @Select("select * from city where id = #{id}")
    City getCity(@Param("id") Integer id);

    @Insert("insert into city(name, countryCode, district, population) values (#{name}, #{countryCode}, #{district}, #{population})")
    void saveCity(City city);

    @Update("update city set name = #{name}, countryCode = #{countryCode}, district = #{district}, population = #{population} where id = #{id}")
    void updateCity(City city);

    @Delete("delete from city where id = #{id}")
    void deleteCity(Integer id);
}
