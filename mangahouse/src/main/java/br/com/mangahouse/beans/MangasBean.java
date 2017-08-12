package br.com.mangahouse.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.mangahouse.dao.MangaDao;
import br.com.mangahouse.models.Manga;

@Model
public class MangasBean {

	static Logger logger = Logger.getLogger(MangasBean.class.getName());
	
	@Inject
	private MangaDao dao;

	private Manga manga = new Manga();

	public void save() {
		dao.save(manga);
		logger.info("Manga saved " + manga);
	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

}
