package com.bookStore.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.bookstore.model.Book;
import com.bookStore.bookstore.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getProduct(){
		
		List<Book> list = bookService.getBook();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/book/{isbn}")
	public Optional<Book> getProductById(@PathVariable String isbn){
		
		return bookService.getBookBYId(isbn);
	}
	
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book){
		return bookService.addBook(book);
	}
	
	@GetMapping("/books/{keyword}")
	public List<Book> getBookByIsbnORTitleOrAuthor(@PathVariable String keyword) {
		return bookService.getBookByIsbnORTitleOrAuthor(keyword);
	}
	
	@GetMapping("/book/{author}/{title}")
	public List<Book> getBookByTitleAndAuthor(@PathVariable String author, @PathVariable String title) {
		return bookService.getBookByTitleAndAuthor(author, title);
	}

}
