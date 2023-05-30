package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private int filmId;

	@Lob
	private String description;

	@Column(name = "language_id")
	private byte languageId;

	@Column(name = "genere")
	private String genere;

	@UpdateTimestamp
	@Column(name = "last_update")
	private Timestamp lastUpdate;

	private int length;

	@Column(name = "original_language_id")
	private byte originalLanguageId;

	private String rating;

	@Temporal(TemporalType.DATE)
	@Column(name = "release_year")
	private Integer releaseYear;

	@Column(name = "rental_duration")
	private byte rentalDuration;

	@Column(name = "rental_rate")
	private double rentalRate;

	@Column(name = "replacement_cost")
	private double replacementCost;

	@Column(name = "special_features")
	private Object specialFeatures;

	private String title;

	@ManyToMany
	@JoinTable(name = "film_cinema", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "cinema_id"))
	private List<Cinema> cinemas = new ArrayList<>(); // Inizializzo qui la lista in modo tale che
														// quando ci faccio delle operazioni sopra
														// non risulti null

	public Film() {

	}

	// Costruttore per le insert con parametri pre impostati in modo da inserire
	// solo title e description
	public Film(String title, String description, String genere) {
		this.title = title;
		this.description = description;
		this.languageId = 1;
		this.length = 190;
		this.originalLanguageId = 1;
		this.rating = "R";
		this.releaseYear = 2023;
		this.rentalDuration = 4;
		this.rentalRate = 2.99;
		this.replacementCost = 20.99;
		this.specialFeatures = "Behind the Scenes";
		this.genere = genere;
	}

	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(byte languageId) {
		this.languageId = languageId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public byte getOriginalLanguageId() {
		return this.originalLanguageId;
	}

	public void setOriginalLanguageId(byte originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Integer getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public byte getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public double getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Object getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(Object specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getTitle() {
		return this.title;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Cinema> getCinemas() {
		return cinemas;
	}

	public void setCinemas(List<Cinema> cinemas) {
		this.cinemas = cinemas;
	}

}