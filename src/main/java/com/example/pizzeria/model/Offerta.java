package com.example.pizzeria.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "offerte")
public class Offerta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private LocalDate startOfferDate;
	
	@NotNull
	private LocalDate endOfferDate;
	
	@NotNull
	@Size(min=5, max=250)
	private String name;
	
	@JsonBackReference
	@NotNull
	@ManyToOne
	private Pizza pizza;
	

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getStartOfferDate() {
		return startOfferDate;
	}

	public void setStartOfferDate(LocalDate startOfferDate) {
		this.startOfferDate = startOfferDate;
	}

	public LocalDate getEndOfferDate() {
		return endOfferDate;
	}

	public void setEndOfferDate(LocalDate endOfferDate) {
		this.endOfferDate = endOfferDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
