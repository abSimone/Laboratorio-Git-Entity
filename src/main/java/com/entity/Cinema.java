package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Cinema.findAll", query = "SELECT c FROM Course c"),
		@NamedQuery(name = "Cinema.findCinemaBySales10", query = "select Nome_cinema AS cinema from cinema where numero_sale >= 10;"), })
public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cinema_id")
	private int cinemaId;

	@Column(name = "name")
	private String name;

	@Column(name = "nazionality")
	private String nazionality;

	@Column(name = "salesNumber")
	private int salesNumber;

	// bi-directional many-to-many association to Film
	@ManyToMany(mappedBy = "film")
	private List<Film> films = new ArrayList<>();// Inizializzo qui la lista in modo tale che
													// quando ci faccio delle operazioni sopra

	// costruttore per insert

	public Cinema(String name, String nazionality, int salesNumber) {
		this.name = name;
		this.nazionality = nazionality;
		this.salesNumber = salesNumber;
	}

	// costruttore per update

	public Cinema(int cinemaId, String name, String nazionality, int salesNumber) {
		this.cinemaId = cinemaId;
		this.name = name;
		this.nazionality = nazionality;
		this.salesNumber = salesNumber;
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNazionality() {
		return nazionality;
	}

	public void setNazionality(String nazionality) {
		this.nazionality = nazionality;
	}

	public int getSalesNumber() {
		return salesNumber;
	}

	public void setSalesNumber(int salesNumber) {
		this.salesNumber = salesNumber;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Cinema [cinemaId=" + cinemaId + ", name=" + name + ", nazionality=" + nazionality + ", salesNumber="
				+ salesNumber + "]";
	}

}