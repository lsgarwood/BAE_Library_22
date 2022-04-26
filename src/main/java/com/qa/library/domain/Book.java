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

	// Constructors for Creating/Inserting

	// Used for reading/selecting (and testing)

	// Getters and Setters

	// Generate toString()

	// Generate hashCode() and equals()

}
