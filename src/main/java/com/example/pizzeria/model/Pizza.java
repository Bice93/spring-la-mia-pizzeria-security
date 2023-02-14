package com.example.pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pizze")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descrizione;
	private String foto;
	private float prezzo;
	
	
	public Pizza() { }
	
	public Pizza(String nome, String descrizione, String foto, float prezzo) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.foto = foto;
		this.prezzo = prezzo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return  getId() + " - " + getNome() + " - " + getDescrizione() + " - " + getFoto() + " - " + getPrezzo() + "€";
	}


	
	
	
}
