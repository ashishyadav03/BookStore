package com.bookStore.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookstore.model.Book;
import com.bookStore.bookstore.repository.BookDao;

/**
 * this is a BookServiceImpl class
 * @author ashishyadav03
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	/**
	 * addBook method save the book details in to the database
	 */
	public Book addBook(Book book) {
		return bookDao.save(book);
	}

	/**
	 * getBook method returns the all books list
	 */
	public List<Book> getBook() {
		return bookDao.findAll();
	}
	
	/**
	 * getBookBYId method return the book of given isbn number
	 */
	public Optional<Book> getBookBYId(String isbn) {
		return bookDao.findById(isbn);
	}

	/**
	 * getBookByIsbnORTitleOrAuthor method return the book based on the typed keyword
	 */
	public List<Book> getBookByIsbnORTitleOrAuthor(String keyword) {
		return bookDao.findByIsbnOrAuthorOrTitle(keyword, keyword, keyword);
	}

	/**
	 * getBookByTitleAndAuthor method return the book details based on book title and book author
	 */
	public List<Book> getBookByTitleAndAuthor(String author, String title) {
		return bookDao.getBookByAuthorAndTitle(author, title);
	}

	/**
	 * updateBook method update the book details
	 */
	public Book updateBook(Book book) {
		return bookDao.save(book);
	}



}
