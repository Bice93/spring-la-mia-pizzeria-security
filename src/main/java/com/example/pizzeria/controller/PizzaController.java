package com.example.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.repository.PizzaRepository;

@Controller
@RequestMapping("/pizze") //gestisce tutte le richieste /pizze/*
public class PizzaController {

	@Autowired
	private PizzaRepository pizzaRepository;
	
//	@GetMapping
//	public String index(Model m) {
//		List<Pizza> elencoPizze = pizzaRepository.findAll();
//		m.addAttribute("pizze", elencoPizze);
//		return "/pizze/index";
//	}
	
	@GetMapping
	public String index(@RequestParam(name="nome", required = false) String keyword, Model model) {
		List<Pizza> elencoPizze;
		if ( keyword != null && !keyword.isEmpty() ) {
			elencoPizze = pizzaRepository.findByNomeLike("%" + keyword + "%");
		} else {
			elencoPizze = pizzaRepository.findAll();
		}
		model.addAttribute("pizze", elencoPizze);
		return "pizze/index";
	}
	
	@GetMapping("/{id}") // gestirà le richieste GET di tipo /pizze/id
	public String detail(@PathVariable("id") Integer id, Model model) {
		
		Optional<Pizza> pizza = pizzaRepository.findById(id);
		if (pizza.isEmpty()) {
			// return error
		} else {
			model.addAttribute("pizza", pizza.get());
		}
//		Pizza pizza = pizzaRepository.getReferenceById(id);
//		model.addAttribute("pizza", pizza);
		
		return "pizze/detail";
	}
	
	

}
