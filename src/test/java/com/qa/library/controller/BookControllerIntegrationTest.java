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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.library.domain.Book;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class BookControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void createBookTest() throws Exception {
		Book entry = new Book("William Golding", true, "Fiction", "Lord Of The Flies");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Book result = new Book(2L, "William Golding", true, "Fiction", "Lord Of The Flies");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(post("/books/createBook").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(resultAsJSON));
	}

	@Test
	public void getAllTest() throws Exception {
		Book book = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(book);
		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/books/getAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByIdTest() throws Exception {
		Book result = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(get("/books/getById/1").contentType(MediaType.APPLICATION_JSON).content(resultAsJSON))
				.andExpect(status().isOk()).andExpect(content().json(resultAsJSON));
	}

	@Test
	public void getByTitleTest() throws Exception {
		Book entry = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/books/getByTitle/Lord Of The Flies").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByAuthorTest() throws Exception {
		Book entry = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/books/getByAuthor/William Golding").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByAvailableTest() throws Exception {
		Book entry = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/books/getByAvailable/true").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(status().isOk()).andExpect(content().json(outputAsJSON));
	}

	@Test
	public void checkInTest() throws Exception {
		Book entry = new Book("William Golding", false, "Fiction", "Lord Of The Flies");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Book result = new Book(1L, "William Golding", true, "Fiction", "Lord Of The Flies");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(put("/books/checkIn/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(resultAsJSON));
	}

	@Test
	public void checkOutTest() throws Exception {
		Book entry = new Book("William Golding", true, "Fiction", "Lord Of The Flies");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Book result = new Book(1L, "William Golding", false, "Fiction", "Lord Of The Flies");
		String resultAsJSON = mapper.writeValueAsString(result);

		mvc.perform(put("/books/checkOut/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(resultAsJSON));
	}

	@Test
	public void deleteBookTest() throws Exception {
		mvc.perform(delete("/books/deleteBook/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
