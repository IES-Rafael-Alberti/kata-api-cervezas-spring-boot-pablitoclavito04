package com.kata.beerapi.mapper;

import com.kata.beerapi.dto.StyleDTO;
import com.kata.beerapi.entity.Style;
import org.springframework.stereotype.Component;

@Component
public class StyleMapper {

    public StyleDTO toDTO(Style entity) {
        if (entity == null) return null;
        return StyleDTO.builder()
                .id(entity.getId())
                .catId(entity.getCatId())
                .styleName(entity.getStyleName())
                .build();
    }
}
