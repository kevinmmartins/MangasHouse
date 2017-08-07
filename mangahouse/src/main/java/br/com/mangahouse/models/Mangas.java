package br.com.mangahouse.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="mangas")
public class Mangas {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;

	@Lob
	private String description;

	private String author;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {

		return "[Title: " + title + "] [Author: " + author + "]";
	}

}
