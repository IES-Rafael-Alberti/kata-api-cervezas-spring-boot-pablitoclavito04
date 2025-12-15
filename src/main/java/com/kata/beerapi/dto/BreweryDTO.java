package com.kata.beerapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BreweryDTO {
    private Integer id;
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String code;
    private String country;
    private String phone;
    private String website;
    private String descript;
}
