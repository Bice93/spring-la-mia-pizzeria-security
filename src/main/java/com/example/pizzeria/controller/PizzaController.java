package com.example.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/pizze") //gestisce tutte le richieste /pizze/*
public class PizzaController {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	@GetMapping
	public String index(Model m) {
		List<Pizza> elencoPizze = pizzaRepository.findAll();
		m.addAttribute("pizze", elencoPizze);
		return "/pizze/index";
	}
}
