package com.bookStore.bookstore.services;

import java.util.List;
import java.util.Optional;

import com.bookStore.bookstore.model.Book;
import com.bookStore.bookstore.model.Media;

public interface BookService {
	
	public List<Book> getBook();
	public Book addBook(Book book);
	public List<Book> getBookByIsbnORTitleOrAuthor(String keyword);
	public List<Book> getBookByTitleAndAuthor(String author, String title);
	public Optional<Book> getBookBYId(String isbn);
	public Book updateBook(Book book);
	public Book updatebook(String isbn, long quantity);
	public Book ByABook(String isbn);
	public Book BuyBookByQuantity(String isbn, Long quantity);
	public Media[] mediaList();
	public Book updateBookQuantity(String isbn, Long quantity);

}
