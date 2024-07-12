package com.example.library.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.library.service.BookService;

public class BookTest {

	@Autowired
    private BookService bookService;
    @Test
    public void testSetTitle() {
        Book book = new Book();
        book.setTitle("Test Title");
        assertEquals("Test Title", book.getTitle());
    }

    @Test
    public void testSetAuthor() {
        Book book = new Book();
        book.setAuthor("Test Author");
        assertEquals("Test Author", book.getAuthor());
    }

    @Test
    public void testSetIsbn() {
        Book book = new Book();
        book.setIsbn("1234567890");
        assertEquals("1234567890", book.getIsbn());
    }
    
    

}
