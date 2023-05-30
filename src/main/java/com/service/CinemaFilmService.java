package com.service;

import java.util.List;

import com.entity.Cinema;
import com.entity.Film;

public interface CinemaFilmService {

	// insert di film
	public void insertCinema(Cinema cinema);

	// insert di cinema

	public void insertFilm(Film film);
	// Selezionare tutti i cinema che hanno almeno 10 sale

	public List<Cinema> SelectCinemaByNumberSales();

	// Selezionare tutti i film che hanno un determinato genere e durano almeno 100
	// minuti

	public List<Film> SelectFilmByGenWithDuraction100(String genere);

	// Selezionare tutti i film che vengono riprodotti in dei cinema italiani

	public List<Film> SelectFilmByCinemaNationality(String nationality);

}
