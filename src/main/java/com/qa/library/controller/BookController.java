package com.qa.library.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.library.domain.Book;
import com.qa.library.service.BookService;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {

	private BookService service;

	public BookController(BookService service) {
		super();

		this.service = service;
	}

	// GetAll - get all books list
	@GetMapping("/getAll") // localhost:8080/books/getAll
	public ResponseEntity<List<Book>> getAll() {
		return new ResponseEntity<List<Book>>(service.getAll(), HttpStatus.OK);
	}

	// GetByID - get one book by id
	@GetMapping("/getById/{id}") // localhost:8080/books/getById/id
	public ResponseEntity<Book> getById(@PathVariable long id) {
		return new ResponseEntity<Book>(service.getById(id), HttpStatus.OK);
	}

	// getByTitle - get books by title
	@GetMapping("/getByTitle/{title}") // localhost:8080/books/getByTitle/title
	public ResponseEntity<List<Book>> getByTitle(@PathVariable String title) {
		return new ResponseEntity<List<Book>>(service.getByTitle(title), HttpStatus.OK);
	}

	// getByAuthor - get books by author list
	@GetMapping("/getByAuthor/{author}") // localhost:8080/books/getByAuthor/author
	public ResponseEntity<List<Book>> getByAuthor(@PathVariable String author) {
		return new ResponseEntity<List<Book>>(service.getByAuthor(author), HttpStatus.OK);
	}

	// getByGenre - get book by genre list
	@GetMapping("/getByGenre/{genre}") // localhost:8080/books/getByGenre/genre
	public ResponseEntity<List<Book>> getByGenre(@PathVariable String genre) {
		return new ResponseEntity<List<Book>>(service.getByGenre(genre), HttpStatus.OK);
	}

	// getByAvailable
	@GetMapping("/getByAvailable/{available}")
	public ResponseEntity<List<Book>> getByAvailable(@PathVariable boolean available) {
		return new ResponseEntity<List<Book>>(service.getByAvailable(available), HttpStatus.OK);
	}

	// Post
	@PostMapping("/createBook") // localhost:8080/books/createBook
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(service.createBook(book), HttpStatus.CREATED);
	}

	// Put - update available to true, search by id
	@PutMapping("/checkIn/{id}") // localhost:8080/books/update/id
	public ResponseEntity<Book> checkIn(@PathVariable long id, @RequestBody Book book) {
		return new ResponseEntity<Book>(service.checkIn(id, book), HttpStatus.CREATED);
	}

	// Put - update available to false, search by id
	@PutMapping("/checkOut/{id}") // localhost:8080/books/update/id
	public ResponseEntity<Book> checkOut(@PathVariable long id, @RequestBody Book book) {
		return new ResponseEntity<Book>(service.checkOut(id, book), HttpStatus.CREATED);
	}

	// Delete book
	@DeleteMapping("/deleteBook/{id}") // localhost:8080/books/deleteBook/id
	public ResponseEntity<?> deleteBook(@PathVariable long id) {
		return (service.deleteBook(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
