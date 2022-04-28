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

	@Column
	private String imageLink; // will be image_link

	@Column
	private String review;

	// default constructor
	public Book() {
		super();
	}

	// constructors used for crud
	public Book(String author, boolean available, String genre, String title, String imageLink, String review) {
		super();
		this.author = author;
		this.available = available;
		this.genre = genre;
		this.title = title;
		this.imageLink = imageLink;
		this.review = review;
	}

	// constructors for reading and testing
	public Book(long id, String author, boolean available, String genre, String title, String imageLink,
			String review) {
		super();
		this.id = id;
		this.author = author;
		this.available = available;
		this.genre = genre;
		this.title = title;
		this.imageLink = imageLink;
		this.review = review;
	}

	// getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	// tostring
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", available=" + available + ", genre=" + genre + ", title="
				+ title + ", imageLink=" + imageLink + ", review=" + review + ", getId()=" + getId() + ", getAuthor()="
				+ getAuthor() + ", isAvailable()=" + isAvailable() + ", getGenre()=" + getGenre() + ", getTitle()="
				+ getTitle() + ", getImageLink()=" + getImageLink() + ", getReview()=" + getReview() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, available, genre, id, imageLink, review, title);
	}

	// hashcode and equals
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
				&& Objects.equals(genre, other.genre) && id == other.id && Objects.equals(imageLink, other.imageLink)
				&& Objects.equals(review, other.review) && Objects.equals(title, other.title);
	}

}
