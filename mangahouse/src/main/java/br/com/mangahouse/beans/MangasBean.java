package br.com.mangahouse.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mangahouse.dao.MangaDao;
import br.com.mangahouse.models.Mangas;

@Named
@RequestScoped
public class MangasBean {

	@Inject
	private MangaDao dao;

	private Mangas manga = new Mangas();

	public void save() {
		dao.save(manga);
		System.out.println("Manga Saved" + manga);
	}

	public Mangas getManga() {
		return manga;
	}

	public void setManga(Mangas manga) {
		this.manga = manga;
	}

}
