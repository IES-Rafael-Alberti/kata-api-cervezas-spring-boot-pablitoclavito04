package com.kata.beerapi.mapper;

import com.kata.beerapi.dto.BreweryDTO;
import com.kata.beerapi.entity.Brewery;
import org.springframework.stereotype.Component;

@Component
public class BreweryMapper {

    public BreweryDTO toDTO(Brewery entity) {
        if (entity == null) return null;
        return BreweryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address1(entity.getAddress1())
                .address2(entity.getAddress2())
                .city(entity.getCity())
                .state(entity.getState())
                .code(entity.getCode())
                .country(entity.getCountry())
                .phone(entity.getPhone())
                .website(entity.getWebsite())
                .descript(entity.getDescript())
                .build();
    }
}
