package com.qa.library.service;

import java.util.List;

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

	// get all books as list
	public List<Book> getAll() {
		return repo.findAll();
	}

	// get one book by Id
	public Book getById(long id) {
		return repo.findById(id).orElseThrow(BookNotFoundWithIdException::new);
	}

	// get one book by title
	public Book getByTitle(String title) {
		return repo.findByTitle(title).orElseThrow(BookNotFoundWithTitleException::new);

	}

	// get books by author
	public List<Book> getByAuthor(String author) {
		return repo.findByAuthor(author).orElseThrow(BooksNotFoundByAuthorException::new);
	}

	// get books by genre
	public List<Book> getByGenre(String genre) {
		return repo.findByGenre(genre).orElseThrow(BooksNotFoundByGenreException::new);
	}
}
