package com.rafael.falconi.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafael.falconi.shoppingcart.entities.Caracteristic;

public interface CaracteristicRepository extends JpaRepository<Caracteristic, Integer> {

}
