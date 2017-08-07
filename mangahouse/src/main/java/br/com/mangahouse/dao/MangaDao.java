package br.com.mangahouse.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.mangahouse.models.Mangas;

public class MangaDao {

	@PersistenceContext(unitName="mangaHouse")
	private EntityManager entityManager;

	@Transactional
	public void save(Mangas manga) {
		entityManager.persist(manga);
	}

}
