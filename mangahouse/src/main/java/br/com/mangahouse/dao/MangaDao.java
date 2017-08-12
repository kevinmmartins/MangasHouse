package br.com.mangahouse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.com.mangahouse.models.Manga;

public class MangaDao {

	@PersistenceContext(unitName = "mangaHouse")
	private EntityManager entityManager;

	@Transactional
	public void save(Manga manga) {
		entityManager.persist(manga);
	}

	public List<Manga> mangaList() {
		String jpql = "select distinct(m) from Manga m" + " join fetch m.authorList";

		return entityManager.createQuery(jpql, Manga.class).getResultList();
	}

}
