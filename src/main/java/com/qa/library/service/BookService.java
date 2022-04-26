package com.qa.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.library.domain.Book;
import com.qa.library.exceptions.BookNotFoundWithIdException;
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

	// create a new book
	public Book create(Book book) {
		return repo.saveAndFlush(book);
	}

	// get all books as list
	public List<Book> getAll() {
		return repo.findAll();
	}

	// get one book by Id
	public Book getById(long id) {
		return repo.findById(id).orElseThrow(BookNotFoundWithIdException::new);
	}

	// get books by title
	public List<Book> getByTitle(String title) {
		return repo.findByTitle(title);

	}

	// get books by author
	public List<Book> getByAuthor(String author) {
		return repo.findByAuthor(author);
	}

	// get books by genre
	public List<Book> getByGenre(String genre) {
		return repo.findByGenre(genre);
	}

	// update a book by searching id
	public Book update(long id, Book book) {
		Book existing = repo.findById(id).get();
		existing.setAvailable(true);
		return repo.saveAndFlush(existing);
	}

	// delete by searching id
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}
