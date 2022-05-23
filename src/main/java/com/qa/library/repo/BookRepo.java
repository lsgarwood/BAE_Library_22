package com.qa.library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.library.domain.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

	List<Book> findByTitle(String title);

	List<Book> findByAuthor(String author);

	List<Book> findByGenre(String genre);

	List<Book> findByAvailable(boolean available);

}
