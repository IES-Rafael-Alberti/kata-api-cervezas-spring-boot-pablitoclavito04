package com.kata.beerapi.controller;

import com.kata.beerapi.dto.BeerCreateDTO;
import com.kata.beerapi.dto.BeerDTO;
import com.kata.beerapi.service.BeerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    // GET /beers - Listar todas las cervezas
    @GetMapping("/beers")
    public ResponseEntity<List<BeerDTO>> getAllBeers() {
        return ResponseEntity.ok(beerService.findAll());
    }

    // GET /beer/{id} - Obtener cerveza por ID
    @GetMapping("/beer/{id}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable Integer id) {
        return ResponseEntity.ok(beerService.findById(id));
    }

    // POST /beer - Crear nueva cerveza
    @PostMapping("/beer")
    public ResponseEntity<BeerDTO> createBeer(@Valid @RequestBody BeerCreateDTO createDTO) {
        BeerDTO created = beerService.create(createDTO);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        
        return ResponseEntity.created(location).body(created);
    }

    // PUT /beer/{id} - Actualizar cerveza (completa o parcialmente)
    @PutMapping("/beer/{id}")
    public ResponseEntity<BeerDTO> updateBeer(
            @PathVariable Integer id, 
            @RequestBody BeerCreateDTO updateDTO) {
        return ResponseEntity.ok(beerService.update(id, updateDTO));
    }

    // DELETE /beer/{id} - Eliminar cerveza
    @DeleteMapping("/beer/{id}")
    public ResponseEntity<Void> deleteBeer(@PathVariable Integer id) {
        beerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
