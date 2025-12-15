package com.kata.beerapi.service;

import com.kata.beerapi.dto.CategoryDTO;
import com.kata.beerapi.exception.ResourceNotFoundException;
import com.kata.beerapi.mapper.CategoryMapper;
import com.kata.beerapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(Integer id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Category", id));
    }
}
