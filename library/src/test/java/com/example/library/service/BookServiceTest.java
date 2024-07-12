package com.example.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.library.model.Book;
import com.example.library.model.Department;
import com.example.library.repository.BookRepository;

public class BookServiceTest {
	@Mock
    private BookRepository bookRepository;

    @Mock
    private DepartmentService departmentService;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddBook_Success() {
        Department department = new Department("Department A");
        Book newBook = new Book("Test Book", "Test Author", "1234567890", "Fiction", 2022, true, department);

      
        when(bookRepository.findByIsbn(newBook.getIsbn())).thenReturn(null);
        when(bookRepository.save(any(Book.class))).thenReturn(newBook);

        Book savedBook = bookService.addBook(newBook);

        assertNotNull(savedBook);
        assertEquals("Test Book", savedBook.getTitle());
        assertEquals("Test Author", savedBook.getAuthor());
        assertEquals("1234567890", savedBook.getIsbn());
        assertEquals("Fiction", savedBook.getGenre());
        assertEquals(2022, savedBook.getPublicationYear());
        assertTrue(savedBook.isAvailability());
        assertEquals(department, savedBook.getDepartment());

      
        verify(bookRepository, times(1)).findByIsbn(newBook.getIsbn());
        verify(bookRepository, times(1)).save(any(Book.class));
    }
    
    
    @Test
    public void testAddBook_BookAlreadyExists() {
        Department department = new Department("Department B");
        Book existingBook = new Book("Existing Book", "Existing Author", "1234567890", "Non-Fiction", 2021, false, department);

     
        when(bookRepository.findByIsbn(existingBook.getIsbn())).thenReturn(existingBook);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bookService.addBook(existingBook);
        });

        assertEquals("Book with this ISBN already exists in the library.", exception.getMessage());

       
        verify(bookRepository, times(1)).findByIsbn(existingBook.getIsbn());
        verify(bookRepository, never()).save(any(Book.class));
    }
    
    @Test
    public void testRemoveBook_Success() {
        Department department = new Department("Department C");
        Book bookToRemove = new Book("Book to Remove", "Remove Author", "1234567890", "Fantasy", 2020, true, department);

        when(bookRepository.findByIsbn(bookToRemove.getIsbn())).thenReturn(bookToRemove);

        bookService.removeBook(bookToRemove.getIsbn());

        verify(bookRepository, times(1)).findByIsbn(bookToRemove.getIsbn());
        verify(bookRepository, times(1)).delete(bookToRemove);
    }
    
    @Test
    public void testRemoveBook_BookNotFound() {
        String isbn = "9999999999"; // Non-existing ISBN

        when(bookRepository.findByIsbn(isbn)).thenReturn(null);

        bookService.removeBook(isbn);

        verify(bookRepository, times(1)).findByIsbn(isbn);
        verify(bookRepository, never()).delete(any(Book.class));
    }
    
    @Test
    public void testFindBookByAuthor() {
        String author = "Test Author";
        List<Book> booksByAuthor = new ArrayList<>();
        Department department = new Department("Science Fiction");
        booksByAuthor.add(new Book("Book 1", author, "1234567890", "Fiction", 2022, true, department));
        booksByAuthor.add(new Book("Book 2", author, "2345678901", "Non-Fiction", 2021, false, department));

        when(bookRepository.findByAuthorIgnoreCase(author)).thenReturn(booksByAuthor);

        List<Book> foundBooks = bookService.findBookByAuthor(author);

        assertEquals(2, foundBooks.size());

        verify(bookRepository, times(1)).findByAuthorIgnoreCase(author);
    }
    @Test
    public void testListAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        Department department = new Department("Department A");
        allBooks.add(new Book("Book 1", "Author 1", "1234567890", "Fiction", 2022, true, department));
        allBooks.add(new Book("Book 2", "Author 2", "2345678901", "Non-Fiction", 2021, false, department));

        when(bookRepository.findAll()).thenReturn(allBooks);

        List<Book> books = bookService.listAllBooks();

        assertEquals(2, books.size());

        verify(bookRepository, times(1)).findAll();
    }

}
