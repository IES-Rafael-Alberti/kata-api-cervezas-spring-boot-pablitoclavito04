package com.kata.beerapi.controller;

import com.kata.beerapi.dto.BreweryDTO;
import com.kata.beerapi.service.BreweryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BreweryController {

    private final BreweryService breweryService;

    @GetMapping("/breweries")
    public ResponseEntity<List<BreweryDTO>> getAllBreweries() {
        return ResponseEntity.ok(breweryService.findAll());
    }

    @GetMapping("/brewerie/{id}")
    public ResponseEntity<BreweryDTO> getBreweryById(@PathVariable Integer id) {
        return ResponseEntity.ok(breweryService.findById(id));
    }
}
