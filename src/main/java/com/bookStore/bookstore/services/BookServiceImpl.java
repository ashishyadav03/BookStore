package com.bookStore.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookstore.model.Book;
import com.bookStore.bookstore.repository.BookDao;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	public Book addBook(Book book) {
		return bookDao.save(book);
	}

	public List<Book> getBook() {
		return bookDao.findAll();
	}
	
	public Optional<Book> getBookBYId(String isbn) {
		return bookDao.findById(isbn);
	}

	public List<Book> getBookByIsbnORTitleOrAuthor(String keyword) {
		return bookDao.findByIsbnOrAuthorOrTitle(keyword, keyword, keyword);
	}

	public List<Book> getBookByTitleAndAuthor(String author, String title) {
		return bookDao.getBookByAuthorAndTitle(author, title);
	}



}
