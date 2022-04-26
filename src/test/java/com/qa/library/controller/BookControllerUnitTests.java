package com.qa.library.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.library.domain.Book;
import com.qa.library.service.BookService;

@WebMvcTest
public class BookControllerUnitTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private BookService service;

	@Test
	public void createBookTest() throws Exception {
		Book entry = new Book("William Golding", true, "Fiction", "Lord Of The Flies");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Mockito.when(this.service.createBook(entry)).thenReturn(entry);

		mvc.perform(post("/books/createBook").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(entryAsJSON));
	}

	@Test
	public void getAllTest() throws Exception {
		Book entry = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);

		Mockito.when(this.service.getAll()).thenReturn(output);

		mvc.perform(get("/books/getAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByIdTest() throws Exception {
		Book entry = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Mockito.when(this.service.getById(1L)).thenReturn(entry);

		mvc.perform(get("/books/getById/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isOk()).andExpect(content().json(entryAsJSON));
	}

	@Test
	public void getByTitleTest() throws Exception {
		Book entry = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);

		Mockito.when(this.service.getByTitle("Lord Of The Flies")).thenReturn(output);

		mvc.perform(get("/books/getByTitle/Lord Of The Flies").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByAuthorTest() throws Exception {
		Book entry = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);

		Mockito.when(this.service.getByAuthor("William Golding")).thenReturn(output);

		mvc.perform(get("/books/getByAuthor/William Golding").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByAvailableTest() throws Exception {
		Book entry = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);

		Mockito.when(this.service.getByAvailable(true)).thenReturn(output);

		mvc.perform(get("/books/getByAvailable/true").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByGenreTest() throws Exception {
		Book entry = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);

		Mockito.when(this.service.getByGenre("Fiction")).thenReturn(output);

		mvc.perform(get("/books/getByGenre/Fiction").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
	}

	@Test
	public void checkInTest() throws Exception {
		Book entry = new Book("William Golding", false, "Fiction", "Lord Of The Flies");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Mockito.when(this.service.checkIn(1L, entry)).thenReturn(entry);

		mvc.perform(put("/books/checkIn/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(entryAsJSON));
	}

	@Test
	public void checkOutTest() throws Exception {
		Book entry = new Book("William Golding", true, "Fiction", "Lord Of The Flies");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Mockito.when(this.service.checkOut(1L, entry)).thenReturn(entry);

		mvc.perform(put("/books/checkOut/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(entryAsJSON));
	}

	@Test
	public void deleteBookTest() throws Exception {

		Mockito.when(this.service.deleteBook(1l)).thenReturn(true);

		mvc.perform(delete("/books/deleteBook/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
