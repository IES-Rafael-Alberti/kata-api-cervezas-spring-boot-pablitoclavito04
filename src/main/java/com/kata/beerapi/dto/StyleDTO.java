package com.kata.beerapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StyleDTO {
    private Integer id;
    private Integer catId;
    private String styleName;
}
