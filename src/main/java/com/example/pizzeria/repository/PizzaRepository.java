package com.example.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
