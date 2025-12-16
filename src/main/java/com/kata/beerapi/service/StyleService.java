package com.kata.beerapi.service;

import com.kata.beerapi.dto.StyleDTO;
import com.kata.beerapi.exception.ResourceNotFoundException;
import com.kata.beerapi.mapper.StyleMapper;
import com.kata.beerapi.repository.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StyleService {

    private final StyleRepository styleRepository;
    private final StyleMapper styleMapper;

    public List<StyleDTO> findAll() {
        return styleRepository.findAll().stream()
                .map(styleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public StyleDTO findById(Integer id) {
        return styleRepository.findById(id)
                .map(styleMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Style", id));
    }
}
