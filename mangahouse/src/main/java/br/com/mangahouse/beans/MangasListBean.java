package br.com.mangahouse.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.mangahouse.dao.MangaDao;
import br.com.mangahouse.models.Manga;

@Model
public class MangasListBean {

	@Inject
	private MangaDao dao;

	List<Manga> mangaList = new ArrayList<>();

	public List<Manga> getMangaList() {
		this.mangaList = dao.mangaList();
		return mangaList;
	}

	public void setMangaList(List<Manga> mangaList) {
		this.mangaList = mangaList;
	}
	
	

}
