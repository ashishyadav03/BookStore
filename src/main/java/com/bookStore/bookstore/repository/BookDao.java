package com.bookStore.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookStore.bookstore.model.Book;

/**
 * this is a BookDao interface which extending the JpaRepository
 * @author ashishyadav03
 *
 */
public interface BookDao extends JpaRepository<Book, String> {

	/**
	 * this method return a book based on keyword
	 * @param keyword first variable
	 * @param keyword2 second variable
	 * @param keyword3 third variable
	 * @return the book details
	 */
	List<Book> findByIsbnOrAuthorOrTitle(String keyword, String keyword2, String keyword3);

	/**
	 * getBookByAuthorAndTitle method return the book details based on title and author
	 * @param author book author name
	 * @param title book title
	 * @return the book details based on title and author
	 */
	@Query("select b From Book b WHERE b.author =:atr and b.title =:tle")
	public List<Book> getBookByAuthorAndTitle(@Param("atr") String author, @Param("tle") String title);
	
}
