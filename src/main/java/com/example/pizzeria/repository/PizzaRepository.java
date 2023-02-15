package com.example.pizzeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
	//Query custom
	public List<Pizza> findByNomeLike (String keyword);
}
