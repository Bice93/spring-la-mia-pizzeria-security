package com.example.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pizzeria.model.Ingrediente;
import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.repository.IngredienteRepository;
import com.example.pizzeria.repository.PizzaRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pizze") //gestisce tutte le richieste /pizze/*
public class PizzaController {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
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
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", new Pizza());
		List<Ingrediente> ingredienti = ingredienteRepository.findAll();
		model.addAttribute("ingredienti", ingredienti);
		return "/pizze/create";
	}

	
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingR, Model model){
		//validazione dati;
		if(bindingR.hasErrors()) {
			return "/pizze/create";
		}
		pizzaRepository.save(formPizza);
		return "redirect:/pizze";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("pizza", pizzaRepository.getReferenceById(id));
		List<Ingrediente> ingredienti = ingredienteRepository.findAll();
		model.addAttribute("ingredienti", ingredienti);
		return "pizze/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update(
			@Valid @ModelAttribute("pizza") Pizza formPizza,
			BindingResult bindingR,
			Model model) {
		
		if(bindingR.hasErrors()) {
			return "pizze/edit";
		}
		
		pizzaRepository.save(formPizza);
		return "redirect:/pizze/"+formPizza.getId();
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		pizzaRepository.deleteById(id);
		return "redirect:/pizze";
	}
	

}
