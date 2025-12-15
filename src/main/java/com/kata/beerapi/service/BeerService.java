package com.kata.beerapi.service;

import com.kata.beerapi.dto.BeerCreateDTO;
import com.kata.beerapi.dto.BeerDTO;
import com.kata.beerapi.entity.Beer;
import com.kata.beerapi.exception.ResourceNotFoundException;
import com.kata.beerapi.mapper.BeerMapper;
import com.kata.beerapi.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    public List<BeerDTO> findAll() {
        return beerRepository.findAll().stream()
                .map(beerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BeerDTO findById(Integer id) {
        return beerRepository.findById(id)
                .map(beerMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Beer", id));
    }

    @Transactional
    public BeerDTO create(BeerCreateDTO createDTO) {
        Beer beer = beerMapper.toEntity(createDTO);
        beer.setLastMod(LocalDateTime.now());
        Beer savedBeer = beerRepository.save(beer);
        return beerMapper.toDTO(savedBeer);
    }

    @Transactional
    public BeerDTO update(Integer id, BeerCreateDTO updateDTO) {
        Beer beer = beerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Beer", id));
        
        // Actualiza solo los campos que vienen en el DTO (no nulos)
        // Esto permite que PUT funcione tanto para actualizaciones completas como parciales
        if (updateDTO.getName() != null) {
            beer.setName(updateDTO.getName());
        }
        if (updateDTO.getBreweryId() != null) {
            beer.setBreweryId(updateDTO.getBreweryId());
        }
        if (updateDTO.getCatId() != null) {
            beer.setCatId(updateDTO.getCatId());
        }
        if (updateDTO.getStyleId() != null) {
            beer.setStyleId(updateDTO.getStyleId());
        }
        if (updateDTO.getAbv() != null) {
            beer.setAbv(updateDTO.getAbv());
        }
        if (updateDTO.getIbu() != null) {
            beer.setIbu(updateDTO.getIbu());
        }
        if (updateDTO.getSrm() != null) {
            beer.setSrm(updateDTO.getSrm());
        }
        if (updateDTO.getDescript() != null) {
            beer.setDescript(updateDTO.getDescript());
        }
        
        beer.setLastMod(LocalDateTime.now());
        Beer updatedBeer = beerRepository.save(beer);
        return beerMapper.toDTO(updatedBeer);
    }

    @Transactional
    public void delete(Integer id) {
        if (!beerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Beer", id);
        }
        beerRepository.deleteById(id);
    }
}
