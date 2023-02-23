package com.example.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizzeria.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

}
