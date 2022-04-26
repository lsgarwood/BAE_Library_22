package com.qa.library.service;

import org.springframework.stereotype.Service;

import com.qa.library.repo.BookRepo;

@Service
public class BookService {

	// connection to repo
	private BookRepo repo;

	// constructor
	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}

}
