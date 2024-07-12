package com.example.library;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;

@SpringBootTest
class LibraryApplicationTests {

	/*
	 * @Autowired private BookService bookService;
	 * 
	 * @Autowired private BookRepository bookRepository;
	 * 
	 * @Test void contextLoads() { }
	 * 
	 * @Test void testAddBook() { Book book = new Book();
	 * book.setTitle("Test Book"); book.setAuthor("Test Author");
	 * book.setIsbn("1234567890"); book.setGenre("Fiction");
	 * book.setPublicationYear(2022); //book.setDepartment("Science");
	 * book.setAvailability(true); System.out.println("Test addbook"); Book
	 * savedBook = bookService.addBook(book);
	 * 
	 * assertThat(savedBook).isNotNull(); assertThat(savedBook.getId()).isNotNull();
	 * assertThat(savedBook.getTitle()).isEqualTo("Test Book");
	 * 
	 * // Cleanup bookService.removeBook(savedBook.getIsbn()); }
	 * 
	 * @Test void testRemoveBook() { Book book = new Book();
	 * book.setTitle("Test Book"); book.setAuthor("Test Author");
	 * book.setIsbn("1234567890"); book.setGenre("Fiction");
	 * book.setPublicationYear(2022); // book.setDepartment("Science");
	 * book.setAvailability(true);
	 * 
	 * bookService.addBook(book); bookService.removeBook(book.getIsbn());
	 * 
	 * Book foundBook = bookRepository.findByIsbn("1234567890");
	 * assertThat(foundBook).isNull(); }
	 * 
	 * @Test void testFindBookByTitle() { Book book = new Book();
	 * book.setTitle("Unique Title"); book.setAuthor("Test Author");
	 * book.setIsbn("1234567890"); book.setGenre("Fiction");
	 * book.setPublicationYear(2022); // book.setDepartment("Science");
	 * book.setAvailability(true);
	 * 
	 * bookService.addBook(book);
	 * 
	 * List<Book> foundBooks = bookService.findBookByTitle("unique title");
	 * assertThat(foundBooks).hasSize(1);
	 * assertThat(foundBooks.get(0).getTitle()).isEqualTo("Unique Title");
	 * 
	 * // Cleanup bookService.removeBook(book.getIsbn()); }
	 * 
	 * @Test void testListAvailableBooks() { Book book = new Book();
	 * book.setTitle("Available Book"); book.setAuthor("Test Author");
	 * book.setIsbn("1234567890"); book.setGenre("Fiction");
	 * book.setPublicationYear(2022); //book.setDepartment("Science");
	 * book.setAvailability(true);
	 * 
	 * bookService.addBook(book);
	 * 
	 * List<Book> availableBooks = bookService.listAvailableBooks();
	 * assertThat(availableBooks).contains(book);
	 * 
	 * // Cleanup bookService.removeBook(book.getIsbn()); }
	 */
	private Calculator c=new Calculator();
	@Test
	void contextLoads() {
	}
	
	@Test
	void testSum() {
		int expre=60;
		int doSum = c.doSum(10, 20, 30);
		System.out.println("Testing");
		assertThat(doSum).isEqualTo(expre);
	}
	
}
