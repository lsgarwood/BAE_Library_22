package com.qa.library.service;

import org.springframework.stereotype.Service;

import com.qa.library.domain.Book;

@Service
public class BookService {

	// connection to repo
	private BookRepo repo;

	// constructor
	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}

	// create a new book
	public Book create(Book book) {
		return repo.saveAndFlush(book).orElseThrow(BookNotCreatedException::new);
	}

}
