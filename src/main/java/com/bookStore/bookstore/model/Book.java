package com.bookStore.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Required;

/**
 * this is a Book entity class
 * @author ashishyadav03
 *
 */
@Entity
public class Book {
	
	@Id
	private String isbn;
	private String title;
	private String author;
	private long price;
	private long quantity;
	
	
	/**
	 * this is a Book Constructor
	 * @param isbn
	 * @param title
	 * @param author
	 * @param price
	 * @param quantity
	 */
	public Book(String isbn, String title, String author, long price, long quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantity = quantity;
	}

	/**
	 * this is a Book Constructor
	 */
	public Book() {
		super();
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}

	@Required
	public long getQuantity() {
		return quantity;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
		this.price = price;
	}
	
	@Required
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
}
