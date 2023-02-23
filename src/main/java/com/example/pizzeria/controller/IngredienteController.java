package com.example.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pizzeria.model.Ingrediente;
import com.example.pizzeria.repository.IngredienteRepository;

@Controller
@RequestMapping("/ingredienti")
public class IngredienteController {
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	@GetMapping
	public String index(Model model) {
		List<Ingrediente> ingredientsList = ingredienteRepository.findAll();
		model.addAttribute("ingredienti", ingredientsList);
		return "/ingredienti/index";
	}
	
	
}
