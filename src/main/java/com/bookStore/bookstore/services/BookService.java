package com.bookStore.bookstore.services;

import java.util.List;
import java.util.Optional;

import com.bookStore.bookstore.model.Book;

public interface BookService {
	
	public List<Book> getBook();
	public Book addBook(Book book);
	public List<Book> getBookByIsbnORTitleOrAuthor(String keyword);
	public List<Book> getBookByTitleAndAuthor(String author, String title);
	public Optional<Book> getBookBYId(String isbn);
	public Book updateBook(Book book);

}
