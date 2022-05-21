package com.bookStore.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.bookstore.model.Book;
import com.bookStore.bookstore.model.Media;
import com.bookStore.bookstore.services.BookService;

/**
 * The BookController class
 * @author ashishyadav03
 *
 */
@RestController
public class BookController {
	
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	/**
	 * this getProduct method is used for getting the list of all the books
	 * @return the list of available books
	 */
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getProduct(){
		
		logger.info("info");
		logger.trace("trace");
		logger.error("error");

		List<Book> list = bookService.getBook();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	/**
	 * By this method we can find the book using book ISBN number
	 * @param isbn is the unique book id
	 * @return the unique book for this isbn
	 */
	@GetMapping("/book/{isbn}")
	public Optional<Book> getProductById(@PathVariable String isbn){
		logger.info("info");
		logger.trace("trace");
		return bookService.getBookBYId(isbn);
	}
	
	/**
	 * this method add the book in to the database table
	 * @param book is a object which contains book atribute(isbn,title, author, price and quantity)
	 * @return the added book details
	 */
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book){
		logger.info("info");
		logger.trace("trace");
		Optional<Book> b = bookService.getBookBYId(book.getIsbn());
//		if(b!=null) {
//			return bookService.updatebook(book.getIsbn(), book.getQuantity());
//		}
		return bookService.addBook(book);
	}
	
	public Book updateBookQuantity(@PathVariable String isbn, @PathVariable Long quantity) {
		return bookService.updateBookQuantity(isbn, quantity);
	}
		
	/**
	 * we can search a book by using isbn/title/author 
	 * @param keyword is a text for searching books
	 * @return the book according to keyword
	 */
	@GetMapping("/books/{keyword}")
	public List<Book> getBookByIsbnORTitleOrAuthor(@PathVariable String keyword) {
		logger.info("info");
		logger.trace("trace");
		return bookService.getBookByIsbnORTitleOrAuthor(keyword);
	}
	
	/**
	 * we can search book by using title and author
	 * @param author is the book author name variable
	 * @param title is the book title name variable
	 * @return the book according to title and author
	 */
	@GetMapping("/book/{author}/{title}")
	public List<Book> getBookByTitleAndAuthor(@PathVariable String author, @PathVariable String title) {
		logger.info("info");
		logger.trace("trace");
		return bookService.getBookByTitleAndAuthor(author, title);
	}
	
	/**
	 * By this method we can update the Book details
	 * @param book updated book details
	 * @return the modified book details
	 */
	@PutMapping("/book")
	public Book updateBookById(@RequestBody Book book){
		logger.info("info");
		logger.trace("trace");
		return bookService.updateBook(book);
	}

	/**
	 * we can buy a book by this method
	 * @param isbn book isbn number
	 * @return return the book detail of bought book
	 */
	public Book ByABook(@PathVariable String isbn) {
		return bookService.ByABook(isbn);
	}
	
	/**
	 * we can buy books by this method
	 * @param isbn book isbn number
	 * @param quantity number of books
	 * @return the book detail of bought book
	 */
	public Book BuyBookByQuantity(@PathVariable String isbn, @PathVariable Long quantity) {
		return bookService.BuyBookByQuantity(isbn, quantity);
	}
	
	@GetMapping("/mediacoverage/{bookTitle}")
	public ResponseEntity<?> getMedia(@PathVariable String bookTitle) {
	ArrayList<Media> arr = new ArrayList<Media>();
	logger.info("media coverage info");
	// service call
	Media[] medias = bookService.mediaList();
	arr.clear();
	int count = 0;	
	for (int i = 0; i < medias.length; i++) {
	String title = medias[i].getTitle();
	String body = medias[i].getBody();
	if (title.contains(bookTitle) || body.contains(bookTitle)) {
	System.out.println("Present");
	arr.add(medias[i]);
	System.out.println(arr);
	count++;
	}
	}
	if (count == 0) {
	logger.error("Data Not Present Or Invalid Input");
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data Not Found.");
	}
	logger.info("Data Found");
	return ResponseEntity.ok(arr);
	}
}
