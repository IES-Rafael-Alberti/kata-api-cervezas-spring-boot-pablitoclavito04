package com.kata.beerapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTO {
    private Integer id;
    private Integer breweryId;
    private String name;
    private Integer catId;
    private Integer styleId;
    private Float abv;
    private Float ibu;
    private Float srm;
    private String descript;
}
