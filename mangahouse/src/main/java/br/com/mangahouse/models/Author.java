package br.com.mangahouse.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Author")
public class Author implements Serializable {

	/**
	 * Always change after make some change
	 */
	private static final long serialVersionUID = -632058977268034215L;

	@Column(name = "authorId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "authorName", nullable = false, unique = false)
	private String name;

	@Column(name = "authorLastName", nullable = false, unique = false)
	private String lastName;

	public Author() {

	}

	public Author(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", lastName=" + lastName + "]";
	}



}
