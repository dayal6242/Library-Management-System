package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        if (bookRepository.findByIsbn(book.getIsbn()) == null) {
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book with this ISBN already exists in the library.");
        }
    }

    public void removeBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book != null) {
            bookRepository.delete(book);
        }
    }

    public List<Book> findBookByTitle(String title) {
        return bookRepository.findByTitleIgnoreCase(title);
    }

    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findByAuthorIgnoreCase(author);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> listAvailableBooks() {
        return bookRepository.findAll().stream().filter(Book::isAvailability).toList();
    }
}
