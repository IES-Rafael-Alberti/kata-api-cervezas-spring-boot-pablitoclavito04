package com.kata.beerapi.controller;

import com.kata.beerapi.dto.StyleDTO;
import com.kata.beerapi.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StyleController {

    private final StyleService styleService;

    @GetMapping("/styles")
    public ResponseEntity<List<StyleDTO>> getAllStyles() {
        return ResponseEntity.ok(styleService.findAll());
    }

    @GetMapping("/style/{id}")
    public ResponseEntity<StyleDTO> getStyleById(@PathVariable Integer id) {
        return ResponseEntity.ok(styleService.findById(id));
    }
}
