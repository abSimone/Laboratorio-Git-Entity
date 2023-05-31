package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cinema;
import com.entity.Film;
import com.repository.CinemaFilmRepository;

@Service
public class CinemaFilmServiceImpl implements CinemaFilmService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CinemaFilmRepository CinemaFilmRepository;

	@Override
	public List<Cinema> SelectCinemaByNumberSales() {
		List<Cinema> cinemas = null;
		try {
			cinemas = CinemaFilmRepository.SelectCinemaByNumberSales();
			log.info("Lettura dei Course avvenuta con successo");
		} catch (Exception e) {
			log.error("Lettura Course fallita");
			e.printStackTrace();
		}
		return cinemas;
	}

	@Override
	public List<Film> SelectFilmByGenWithDuraction100(String genere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> SelectFilmByCinemaNationality(String nationality) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCinema(Cinema cinema) {
		try {
			CinemaFilmRepository.insertCinema(cinema);
			log.info("Inserimento Course avvenuto con successo");
		} catch (Exception e) {
			log.error("Inserimento Course fallito");
			e.printStackTrace();
		}

	}

	@Override
	public void insertFilm(Film film) {
		try {
			CinemaFilmRepository.insertFilm(film);
			log.info("Inserimento Course avvenuto con successo");
		} catch (Exception e) {
			log.error("Inserimento Course fallito");
			e.printStackTrace();
		}

	}

}
