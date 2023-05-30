package com.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Cinema;
import com.entity.Film;

@Configuration
public class EntityBeanConfiguration {
	/*
	 * Beans per le CRUD su Cinema
	 */
	@Bean(name = "cinemaToInsert1")
	public Cinema getCinemaToInsert1() {
		return new Cinema("Montecarlo", "italiana", 450);
	}

	@Bean(name = "cinemaToInsert2")
	public Cinema getCinemaToInsert2() {
		return new Cinema("mazzoni", "italiana", 290);
	}

	/*
	 * Beans per le CRUD su Film
	 */

	@Bean(name = "filmToInsert1")
	public Film getfilmToInsert1() {
		return new Film("viaggio nel mondo", "carino", "fantasy");
	}

	@Bean(name = "filmToInsert2")
	public Film getfilmToInsert2() {
		return new Film("la bambola assasina", "pauroso", "horror");
	}

	@Bean(name = "filmToInsert3")
	public Film getfilmToInsert3() {
		return new Film("l esorcista", "stomachevole", "horror");
	}

}
