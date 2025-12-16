package com.kata.beerapi.mapper;

import com.kata.beerapi.dto.CategoryDTO;
import com.kata.beerapi.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDTO toDTO(Category entity) {
        if (entity == null) return null;
        return CategoryDTO.builder()
                .id(entity.getId())
                .catName(entity.getCatName())
                .build();
    }
}
