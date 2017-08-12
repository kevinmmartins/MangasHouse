package br.com.mangahouse.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.mangahouse.dao.AuthorDao;
import br.com.mangahouse.dao.MangaDao;
import br.com.mangahouse.models.Author;
import br.com.mangahouse.models.Manga;

@Model
public class MangasBean {

	static Logger logger = Logger.getLogger(MangasBean.class.getName());

	@Inject
	private MangaDao dao;

	@Inject
	private AuthorDao authorDao;

	private Manga manga = new Manga();
	private List<Integer> authorListId = new ArrayList<>();


	public String save() {
		try {
			setAuthorList();
			dao.save(manga);
			logger.info("Manga saved " + manga);
			this.manga = new Manga();
			this.authorListId = new ArrayList<>();
		} catch (Exception e) {
			logger.error("Cannot save the manga " + manga, e);
		}

		return "/mangas/mangaList?faces-redirect=true";
	}

	private void setAuthorList() {
		if (authorListId.size() > 0) {
			List<Author> authorList = new ArrayList<>();
			authorListId.forEach(author -> {
				Author authorById = authorDao.getAuthorById(author);
				if (authorById != null) {
					authorList.add(authorById);
				}
			});
			manga.setAuthorList(authorList);
		}

	}

	public Manga getManga() {
		return manga;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}

	public List<Author> getAuthorList() {
		return authorDao.getAuthorList();
	}

	public List<Integer> getAuthorListId() {
		return authorListId;
	}

	public void setAuthorListId(List<Integer> authorListId) {
		this.authorListId = authorListId;
	}

}
