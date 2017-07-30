package br.com.mangahouse.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mangahouse.models.Manga;

@Named
@RequestScoped
public class MangasBean {

	@Inject
	private Manga manga;

	public void save() {
		System.out.println("Manga Saved" + manga);
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

}
