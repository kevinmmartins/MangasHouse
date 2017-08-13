package br.com.mangahouse.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity(name = "Manga")
public class Manga implements Serializable {

	/**
	 * Always change after make some change
	 */
	private static final long serialVersionUID = 6408644172540289190L;

	@Column(name = "mangaId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Length(min = 10)
	@Column(name = "mangaTitle", nullable = false, unique = true)
	private String title;

	@Length(min = 20)
	@Column(name = "mangaDesc", nullable = false, unique = false)
	@Lob
	private String description;

	@ManyToMany
	@Size(min = 1)
	@NotNull
	private Collection<Author> authorList = new HashSet<>();

	@DecimalMin("20")
	@Column(name = "mangaPrice", nullable = false, unique = false)
	private BigDecimal price;

	@Temporal(TemporalType.DATE)
	private Calendar publishDate;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Collection<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(Collection<Author> authorList) {
		this.authorList = authorList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Calendar publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Manga [id=" + id + ", title=" + title + ", description=" + description + ", authorList=" + authorList
				+ ", price=" + price + "]";
	}

}
