package com.example.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pizzeria.model.Offerta;
import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.repository.OffertaRepository;
import com.example.pizzeria.repository.PizzaRepository;


@Controller
@RequestMapping("/offerte")
public class OffertaController {
	@Autowired
	OffertaRepository offertaRepository;
	@Autowired
	PizzaRepository pizzaRepository;

	@GetMapping
	public String index(Model model) {
		List<Offerta> listaOfferte = offertaRepository.findAll();
		model.addAttribute("offerte", listaOfferte);
		return "/offerte/index";
	}

	@GetMapping("/create")
	public String create(@RequestParam(name = "idPizza", required = true) Integer id, Model model) throws Exception {
		Offerta offerta = new Offerta();
		Pizza pizza = pizzaRepository.getReferenceById(id);
		offerta.setPizza(pizza);
		model.addAttribute("offerta", offerta);
		return "/offerte/create";
	}

	@PostMapping("/create")
	public String store(@ModelAttribute("offerta") Offerta formOfferta, Model model) {

		//Pizza pizza = formOfferta.getPizza();
		offertaRepository.save(formOfferta);

		return "redirect:/pizze";

	}
	
	//Edit
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("offerta", offertaRepository.getReferenceById(id));
		return "/offerte/edit";
	}
	
	
	@PostMapping("/edit/{id}")
	public String update(@ModelAttribute("offerta") Offerta formOfferta, Model model) {
		offertaRepository.save(formOfferta);
		return "redirect:/pizze";
	}

}
