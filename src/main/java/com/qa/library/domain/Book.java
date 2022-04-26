package com.qa.library.domain;

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
	private boolean status;

	// Default Constructor
	public Book() {
		super();
	}

	// Constructors for Creating/Inserting
	public Book(String title, String author, String genre, boolean status) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.status = status;
	}

	// Used for reading/selecting (and testing)
	public Book(long id, String title, String author, String genre, boolean status) {
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// Generate toString()

	// Generate hashCode() and equals()

}
