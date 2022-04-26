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

	// get books by availability
	public List<Book> getByAvailable(boolean available) {
		return repo.findByAvailable(available);
	}

	// update a book by searching id
	public Book checkIn(long id, Book book) {
		Book existing = repo.findById(id).get();
		existing.setAvailable(true);
		return repo.saveAndFlush(existing);
	}

	// update a book by searching id
	public Book checkOut(long id, Book book) {
		Book existing = repo.findById(id).get();
		existing.setAvailable(false);
		return repo.saveAndFlush(existing);
	}

	// delete by searching id
	public boolean deleteBook(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

}
