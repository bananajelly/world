package com.application.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class City {
    private Integer id;
    private String name;
    private String countryCode;
    private String district;
    private Integer population;
    private String description;
}
