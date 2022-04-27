package com.qa.library.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(nullable = false)
	private String author;

	@Column(nullable = false)
	private boolean available;

	@Column(nullable = false)
	private String genre;

	@Column(nullable = false)
	private String title;

	// default constructor
	public Book() {
		super();
	}

	// constructors used for crud
	public Book(String author, boolean available, String genre, String title) {
		super();
		this.author = author;
		this.available = available;
		this.genre = genre;
		this.title = title;
	}

	// constructors for reading and testing
	public Book(long id, String author, boolean available, String genre, String title) {
		super();
		this.id = id;
		this.author = author;
		this.available = available;
		this.genre = genre;
		this.title = title;
	}

	// getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	// tostring
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", available="
				+ available + ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor()
				+ ", getGenre()=" + getGenre() + ", isAvailable()=" + isAvailable() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	// hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(author, available, genre, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && available == other.available
				&& Objects.equals(genre, other.genre) && id == other.id && Objects.equals(title, other.title);
	}

}
