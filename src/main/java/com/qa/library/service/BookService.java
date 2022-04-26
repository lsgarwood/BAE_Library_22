package com.qa.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.library.domain.Book;
import com.qa.library.exceptions.BookNotFoundWithIdException;
import com.qa.library.exceptions.BookNotFoundWithTitleException;
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
		return repo.saveAndFlush(book);// .orElseThrow(BookNotCreatedException::new);
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
		return repo.findByAuthor(author);// .orElseThrow(BooksNotFoundByAuthorException::new);
	}

	// get books by genre
	public List<Book> getByGenre(String genre) {
		return repo.findByGenre(genre);
	}

	// update a book by searching id
	public Book update(long id, Book book) {
		Book existing = repo.findById(id).get(); // get existing book
		existing.setTitle(book.getTitle()); // change existing data to new
		existing.setAuthor(book.getAuthor());
		existing.setGenre(book.getGenre());
		existing.setStatus(book.getGenre());
		return repo.saveAndFlush(existing);// .orElseThrow(BookUpdateNotSuccessfulException::new);
		// send new user info back
	}

	// update a book by searching title
	public Book update(String title, Book book) {
		Book existing = repo.findByTitle(title).get(); // get existing book
		existing.setTitle(book.getTitle()); // change existing data to new
		existing.setAuthor(book.getAuthor());
		existing.setGenre(book.getGenre());
		existing.setStatus(book.getGenre());
		return repo.saveAndFlush(existing);// .orElseThrow(BookUpdateNotSuccessfulException::new);
	}

	// delete by searching id
	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

//	// delete by searching title
//	public boolean delete(String title) {
//		repo.deleteByTitle(title);
//		return !repo.existsByTitle(title);
//	}

}
