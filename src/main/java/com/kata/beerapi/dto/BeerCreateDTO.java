package com.kata.beerapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerCreateDTO {
    
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    
    private Integer breweryId;
    private Integer catId;
    private Integer styleId;
    private Float abv;
    private Float ibu;
    private Float srm;
    private String descript;
}
