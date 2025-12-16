package com.kata.beerapi.mapper;

import com.kata.beerapi.dto.BeerCreateDTO;
import com.kata.beerapi.dto.BeerDTO;
import com.kata.beerapi.entity.Beer;
import org.springframework.stereotype.Component;

@Component
public class BeerMapper {

    public BeerDTO toDTO(Beer entity) {
        if (entity == null) return null;
        return BeerDTO.builder()
                .id(entity.getId())
                .breweryId(entity.getBreweryId())
                .name(entity.getName())
                .catId(entity.getCatId())
                .styleId(entity.getStyleId())
                .abv(entity.getAbv())
                .ibu(entity.getIbu())
                .srm(entity.getSrm())
                .descript(entity.getDescript())
                .build();
    }

    public Beer toEntity(BeerCreateDTO dto) {
        if (dto == null) return null;
        return Beer.builder()
                .breweryId(dto.getBreweryId())
                .name(dto.getName())
                .catId(dto.getCatId())
                .styleId(dto.getStyleId())
                .abv(dto.getAbv())
                .ibu(dto.getIbu())
                .srm(dto.getSrm())
                .descript(dto.getDescript())
                .build();
    }
}
