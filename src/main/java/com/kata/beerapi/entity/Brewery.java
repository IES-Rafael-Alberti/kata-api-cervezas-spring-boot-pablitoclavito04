package com.kata.beerapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "breweries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brewery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String code;

    private String country;

    private String phone;

    private String website;

    private String filepath;

    @Column(columnDefinition = "TEXT")
    private String descript;

    @Column(name = "add_user")
    private Integer addUser;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;
}
