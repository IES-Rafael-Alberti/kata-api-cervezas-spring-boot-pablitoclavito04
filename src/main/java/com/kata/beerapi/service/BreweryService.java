package com.kata.beerapi.service;

import com.kata.beerapi.dto.BreweryDTO;
import com.kata.beerapi.exception.ResourceNotFoundException;
import com.kata.beerapi.mapper.BreweryMapper;
import com.kata.beerapi.repository.BreweryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BreweryService {

    private final BreweryRepository breweryRepository;
    private final BreweryMapper breweryMapper;

    public List<BreweryDTO> findAll() {
        return breweryRepository.findAll().stream()
                .map(breweryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BreweryDTO findById(Integer id) {
        return breweryRepository.findById(id)
                .map(breweryMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Brewery", id));
    }
}
