package br.com.mangahouse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import br.com.mangahouse.models.Author;

public class AuthorDao {

	static Logger logger = Logger.getLogger(AuthorDao.class.getName());

	@PersistenceContext(unitName = "mangaHouse")
	private EntityManager entityManager;

	@Transactional
	public void save(Author author) {
		Author existingAuthor = getAuthorByAttributes(author.getName(), author.getLastName());
		if (existingAuthor == null) {
			logger.info("Inserting new author");
			entityManager.persist(author);
		} else {
			// existingAuthor.setMangas(author.getMangas());
			logger.info("Updating author");
			entityManager.merge(existingAuthor);
		}

	}

	public List<Author> getAuthorList() {
		return entityManager.createQuery("select a from Author a", Author.class).getResultList();
	}

	public Author getAuthorById(Integer id) {
		Author author = entityManager.find(Author.class, id);

		return author != null ? author : null;
	}

	public Author getAuthorByAttributes(String name, String lastName) {
		List<Author> resultList = entityManager
				.createQuery("select a from Author a where a.name=:name and a.lastName=:lastName", Author.class)
				.setParameter("name", name).setParameter("lastName", lastName).getResultList();

		return resultList != null && resultList.size() > 0 ? resultList.get(0) : null;
	}

}
