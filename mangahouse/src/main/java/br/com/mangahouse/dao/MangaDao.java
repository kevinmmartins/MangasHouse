package br.com.mangahouse.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.mangahouse.models.Manga;

public class MangaDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Manga manga) {
		entityManager.persist(manga);
	}

}
