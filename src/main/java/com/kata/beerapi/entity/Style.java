package com.kata.beerapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "styles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cat_id")
    private Integer catId;

    @Column(name = "style_name", nullable = false)
    private String styleName;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;
}
