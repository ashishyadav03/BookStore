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
	
	/**
	 * If a book already exists in the database then by this method we can update the quantity of the book
	 * @param isbn book isbn number
	 * @param quantity book quantity
	 * @return return the book details
	 */
	@Query("update Book b set b.quantity = qt + qty = select qty.quantity from Book qty where qty.isbn=:id")
	public Book updateBookById(@Param("id") String isbn, @Param("qt") long quantity);

	/**
	 * By this method we can buy a book
	 * @param isbn is the book isbn number
	 * @return the book of specified isbn number
	 */
	@Query("update Book b set b.quantity = b.quantity - 1 where b.isbn=:id")
	Book ByBook(@Param("id") String isbn);

	@Query("update Book b set b.quantity = b.quantity + qty where b.isbn=:id")
	Book updateBookQuantity(String isbn, Long quantity);

	/**
	 * By this method we can buy a book
	 * @param isbn is the book isbn number
	 * @param quantity of book
	 * @return the book of specified isbn number
	 */
	@Query("update Book b set b.quantity = b.quantity - qty where b.isbn=:id")
	Book BuyBookByQuantity(@Param("id") String isbn, @Param("qty") Long quantity);
	
}
