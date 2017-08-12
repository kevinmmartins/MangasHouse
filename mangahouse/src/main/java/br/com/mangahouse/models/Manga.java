package br.com.mangahouse.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "mangas")
public class Manga {

	@Column(name = "mangaId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "mangaTitle", nullable = false, unique = true)
	private String title;

	@Column(name = "mangaDesc", nullable = false, unique = false)
	@Lob
	private String description;

	@Column(name = "mangaAuthor", nullable = false, unique = false)
	private String author;

	@Column(name = "mangaPrice", nullable = false, unique = false)
	private BigDecimal price;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return "[Title: " + title + "] [Author: " + author + "]";
	}

}
