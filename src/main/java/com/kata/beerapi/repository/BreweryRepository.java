package com.kata.beerapi.repository;

import com.kata.beerapi.entity.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Integer> {
}
