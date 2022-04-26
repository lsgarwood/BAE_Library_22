package com.qa.library.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.library.domain.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

	Optional<Book> findByTitle(String title);
	
	Optional<Book> findById(Long id);
	
	List<Book> findByAuthor(String author);
	
	List<Book> findByGenre(String genre);
	
	Optional<Book> deleteByTitle(String title);
	
	Optional<Book> existsByTitle(String title);
	
}
