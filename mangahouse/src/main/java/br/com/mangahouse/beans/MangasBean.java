package br.com.mangahouse.beans;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	
	@Inject
	private FacesContext facesContent;

	public String save() {
		try {
			dao.save(manga);
			logger.info("Manga saved " + manga);
			sendMessageSuccess();
		} catch (Exception e) {
			logger.error("Cannot save the manga " + manga, e);
			sendMessageError();
		}

		return "/mangas/mangaList?faces-redirect=true";
	}

	private void sendMessageSuccess() {
		facesContent.getExternalContext().getFlash().setKeepMessages(true);
		facesContent.addMessage(null, new FacesMessage("Manga Saved"));
	}

	private void sendMessageError() {
		facesContent.getExternalContext().getFlash().setKeepMessages(true);
		facesContent.addMessage(null, new FacesMessage("Cannot save the manga"));
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


}
