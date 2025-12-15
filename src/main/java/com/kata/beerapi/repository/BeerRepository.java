package com.kata.beerapi.repository;

import com.kata.beerapi.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer> {
}
