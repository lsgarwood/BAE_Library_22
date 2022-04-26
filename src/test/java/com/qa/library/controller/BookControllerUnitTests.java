package com.qa.library.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
	public void createTest() throws Exception {
		Book entry = new Book("Willaim Golding", true, "Fiction", "Lord Of The Flies");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Mockito.when(this.service.create(entry)).thenReturn(entry);

		mvc.perform(post("/books/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(entryAsJSON));
	}

	@Test
	public void getAllTest() throws Exception {
		Book entry = new Book(1L, "Willaim Golding", true, "Fiction", "Lord Of The Flies");
		List<Book> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);

		Mockito.when(this.service.getAll()).thenReturn(output);

		mvc.perform(get("/books/getAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void getByIdTest() throws Exception {
		Book entry = new Book(1L, "Willaim Golding", true, "Fiction", "Lord Of The Flies");
		String entryAsJSON = mapper.writeValueAsString(entry);

		Mockito.when(this.service.getById(1L)).thenReturn(entry);

		mvc.perform(get("/books/getById/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isOk()).andExpect(content().json(entryAsJSON));
	}

}
