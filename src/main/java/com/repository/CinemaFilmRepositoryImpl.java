package com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Cinema;
import com.entity.Film;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Transactional
@Repository
public class CinemaFilmRepositoryImpl implements CinemaFilmRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Cinema> SelectCinemaByNumberSales() {
		return em.createNamedQuery("Cinema.findCinemaBySales10", Cinema.class).getResultList();
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
		em.persist(cinema);

	}

	@Override
	public void insertFilm(Film film) {
		em.persist(film);

	}

}
