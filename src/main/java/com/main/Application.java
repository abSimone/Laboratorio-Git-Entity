package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Cinema;
import com.entity.Film;
import com.service.CinemaFilmService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CinemaFilmService cinemaFilmService;

	/*
	 * Resources per Cinema
	 */
	@Resource(name = "cinemaToInsert1")
	private Cinema cinemaToInsert1;

	@Resource(name = "cinemaToInsert2")
	private Cinema cinemaToInsert2;

	/*
	 * Resources per Film
	 */

	@Resource(name = "filmToInsert1")
	private Film filmToInsert1;

	@Resource(name = "filmToInsert2")
	private Film filmToInsert2;

	@Resource(name = "filmToInsert3")
	private Film filmToInsert3;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		cinemaFilmService.insertCinema(cinemaToInsert1);
		cinemaFilmService.insertCinema(cinemaToInsert2);
		cinemaFilmService.insertFilm(filmToInsert1);
		cinemaFilmService.insertFilm(filmToInsert2);
		cinemaFilmService.insertFilm(filmToInsert3);

	}

}