package com.bookStore.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookStore.bookstore.model.Book;

public interface BookDao extends JpaRepository<Book, String> {

	List<Book> findByIsbnOrAuthorOrTitle(String keyword, String keyword2, String keyword3);

	@Query("select b From Book b WHERE b.author =:atr and b.title =:tle")
	public List<Book> getBookByAuthorAndTitle(@Param("atr") String author, @Param("tle") String title);
	
}
