package br.com.mangahouse.beans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.mangahouse.dao.AuthorDao;
import br.com.mangahouse.models.Author;

@Model
public class AuthorBean {

	static Logger logger = Logger.getLogger(AuthorBean.class.getName());

	@Inject
	private AuthorDao dao;

	private Author author = new Author();

	public void save() {

		dao.save(author);
		logger.info("Author saved " + author);
	}

	@Override
	public String toString() {
		return "AuthorBean [author=" + author + "]";
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
