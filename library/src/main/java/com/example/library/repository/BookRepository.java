package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	 	List<Book> findByTitleIgnoreCase(String title);
	    List<Book> findByAuthorIgnoreCase(String author);
	    
	    Book findByIsbn(String isbn);
}
