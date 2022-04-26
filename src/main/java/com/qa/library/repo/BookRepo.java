package com.qa.library.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.library.domain.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

	Optional<Book> findByTitle(String title);
	
	Optional<Book> findById(Long id);
	
	Optional<Book> findByAuthor(String author);
	
	Optional<Book> findByGenre(String genre);
	
}
