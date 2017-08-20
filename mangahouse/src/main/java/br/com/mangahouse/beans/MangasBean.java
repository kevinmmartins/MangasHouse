package br.com.mangahouse.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import br.com.mangahouse.dao.AuthorDao;
import br.com.mangahouse.dao.MangaDao;
import br.com.mangahouse.infra.FileSaver;
import br.com.mangahouse.models.Author;
import br.com.mangahouse.models.Manga;

@Model
public class MangasBean {

	private static Logger logger = Logger.getLogger(MangasBean.class.getName());

	@Inject
	private MangaDao dao;

	@Inject
	private AuthorDao authorDao;

	private Manga manga = new Manga();

	private Part mangaImage;

	@Inject
	private FacesContext facesContent;

	public String save() {
		try {
			saveMangaImage();
			dao.save(manga);
			logger.info("Manga saved " + manga);
			sendMessageSuccess();
		} catch (Exception e) {
			logger.error("Cannot save the manga " + manga, e);
			sendMessageError();
		}

		return "/mangas/mangaList?faces-redirect=true";
	}

	private void saveMangaImage() throws IOException {
		if (mangaImage != null) {
			FileSaver fileSaver = new FileSaver();
			String patch = fileSaver.saveFile(mangaImage, "images");
			manga.setPatch(patch);
		}
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

	public Part getMangaImage() {
		return mangaImage;
	}

	public void setMangaImage(Part mangaImage) {
		this.mangaImage = mangaImage;
	}

}
