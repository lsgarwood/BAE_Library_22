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
	private String title;

	@Column(nullable = false)
	private String author;

	@Column(nullable = false)
	private String genre;

	@Column(nullable = false)
	private String status;

	// Default Constructor
	public Book() {
		super();
	}

	// Constructors for Creating/Inserting
	public Book(String title, String author, String genre, String status) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.status = status;
	}

	// Used for reading/selecting (and testing)
	public Book(long id, String title, String author, String genre, String status) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.status = status;
	}

	// Getters and Setters
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

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// Generate toString()
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", status=" + status
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor()
				+ ", getGenre()=" + getGenre() + ", isStatus()=" + isStatus() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	// Generate hashCode() and equals()
	@Override
	public int hashCode() {
		return Objects.hash(author, genre, id, status, title);
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
		return Objects.equals(author, other.author) && Objects.equals(genre, other.genre) && id == other.id
				&& status == other.status && Objects.equals(title, other.title);
	}

}
