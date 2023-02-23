package com.example.pizzeria.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="pizze")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@NotNull (message="Il campo 'Nome' non può essere vuoto")
	@Size(min=5, max=250)
	private String nome;
	
	@NotEmpty
	@NotNull (message="Il campo 'Descrizione' non può essere vuoto")
	@Size(min=5, max=250)
	private String descrizione;
	
	@NotEmpty
	@NotNull (message="Il campo 'Foto' non può essere vuoto")
	@Size(min=5, max=250)
	private String foto;
	
	@NotNull (message="Il campo 'Prezzo' non può essere vuoto")
	@DecimalMin("1.00")
	@DecimalMax("30.00")
	private BigDecimal prezzo;
	
	@OneToMany(mappedBy = "pizza")
	private List<Offerta> offerteList;
	
	@ManyToMany
	private List<Ingrediente> ingredienti;
	

	
	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public List<Offerta> getOfferteList() {
		return offerteList;
	}

	public void setOfferteList(List<Offerta> offerteList) {
		this.offerteList = offerteList;
	}

	public Pizza() { }
	
	public Pizza(String nome, String descrizione, String foto, BigDecimal prezzo) {
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
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return  getId() + " - " + getNome() + " - " + getDescrizione() + " - " + getFoto() + " - " + getPrezzo() + "€";
	}


	
	
	
}
