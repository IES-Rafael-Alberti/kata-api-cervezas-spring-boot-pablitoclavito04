package com.kata.beerapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "beers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brewery_id")
    @Builder.Default
    private Integer breweryId = 0;

    @Column(nullable = false)
    private String name;

    @Column(name = "cat_id")
    @Builder.Default
    private Integer catId = 0;

    @Column(name = "style_id")
    @Builder.Default
    private Integer styleId = 0;

    @Builder.Default
    private Float abv = 0f;

    @Builder.Default
    private Float ibu = 0f;

    @Builder.Default
    private Float srm = 0f;

    @Builder.Default
    private Integer upc = 0;

    @Builder.Default
    private String filepath = "";

    @Column(columnDefinition = "TEXT")
    @Builder.Default
    private String descript = "";

    @Column(name = "add_user")
    @Builder.Default
    private Integer addUser = 0;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;
}