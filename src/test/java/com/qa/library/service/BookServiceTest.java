package com.qa.library.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.library.domain.Book;
import com.qa.library.repo.BookRepo;

@SpringBootTest
public class BookServiceTest {

	@Autowired
	private BookService service;

	@MockBean
	private BookRepo repo;

	@Test
	public void createBookTest() {
		Book input = new Book("William Golding", true, "Fiction", "Lord Of The Flies");
		Book output = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");

		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);

		assertEquals(output, this.service.createBook(input));

		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}

	@Test
	public void getAllTest() {
		List<Book> output = new ArrayList<>();
		output.add(new Book("William Golding", true, "Fiction", "Lord Of The Flies"));

		Mockito.when(this.repo.findAll()).thenReturn(output);

		assertEquals(output, this.service.getAll());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void getByIdTest() {
		Book book = new Book("William Golding", true, "Fiction", "Lord Of The Flies");

		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(book));

		assertEquals(book, this.service.getById(1L));

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}

	@Test
	public void getByTitleTest() {
		List<Book> output = new ArrayList<>();
		output.add(new Book("William Golding", true, "Fiction", "Lord Of The Flies"));

		Mockito.when(this.repo.findByTitle("Lord Of The Flies")).thenReturn(output);

		assertEquals(output, this.service.getByTitle("Lord Of The Flies"));

		Mockito.verify(this.repo, Mockito.times(1)).findByTitle("Lord Of The Flies");
	}

	@Test
	public void getByAuthorTest() {
		List<Book> output = new ArrayList<>();
		output.add(new Book("William Golding", true, "Fiction", "Lord Of The Flies"));

		Mockito.when(this.repo.findByAuthor("William Golding")).thenReturn(output);

		assertEquals(output, this.service.getByAuthor("William Golding"));

		Mockito.verify(this.repo, Mockito.times(1)).findByAuthor("William Golding");
	}

	@Test
	public void getByGenreTest() {
		List<Book> output = new ArrayList<>();
		output.add(new Book("William Golding", true, "Fiction", "Lord Of The Flies"));

		Mockito.when(this.repo.findByGenre("Fiction")).thenReturn(output);

		assertEquals(output, this.service.getByGenre("Fiction"));

		Mockito.verify(this.repo, Mockito.times(1)).findByGenre("Fiction");
	}

	@Test
	public void getByAvailableTest() {
		List<Book> output = new ArrayList<>();
		output.add(new Book("William Golding", true, "Fiction", "Lord Of The Flies"));

		Mockito.when(this.repo.findByAvailable(true)).thenReturn(output);

		assertEquals(output, this.service.getByAvailable(true));

		Mockito.verify(this.repo, Mockito.times(1)).findByAvailable(true);
	}

	@Test
	public void checkInTest() {
		Book existing = new Book(1L, "William Golding", false, "Fiction", "Lord Of The Flies");
		Book updated = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");

		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		assertThat(this.service.checkIn(1L, new Book(1L, "William Golding", false, "Fiction", "Lord Of The Flies")))
				.isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
	}

	@Test
	public void checkOutTest() {
		Book existing = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		Book updated = new Book(1L, "William Golding", false, "Fiction", "Lord Of The Flies");

		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		assertThat(this.service.checkOut(1L, new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies")))
				.isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
	}

	@Test
	public void deleteBookTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);

		assertTrue(this.service.deleteBook(1L));

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
}
