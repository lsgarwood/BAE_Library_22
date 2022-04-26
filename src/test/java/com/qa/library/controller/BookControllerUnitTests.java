package com.qa.library.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

}
