/**
 * 
 */
package com.bfis.lms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan
 *
 */
public class Book {
	protected static int count; // should be initialized with value from the database
	protected  int quantity; // 
	protected int bookID;
	protected String bookTitle;
	protected String bookAuthor;
	
	// Constructor
	public Book(String bookTitle, String bookAuthor, int quantity) {
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.quantity = quantity;
		this.bookID = ++count;
		
	}

	public  int getQuantity() {
		return quantity;
	}

	public  void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBookID() {
		return bookID;
	}

	

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	/**
	 * 
	 * @param abookTitle
	 * @param abookAuthor
	 * @param quantity
	 * @return
	 */
	public boolean add(String abookTitle, String abookAuthor, int quantity) {
		Book newBook = new Book(abookTitle, abookAuthor, quantity);
		int status = 0; // status should be updated from database
		return(status == 0 ? true : false); //returns true if status from database is 0 and false otherwise
		
	}
	
	/**
	 * 
	 * @param bookID
	 * @return
	 */
	public List<Book> search(int bookID) {
		return new ArrayList<Book>(); // should be fetched from database
	}
	
	/**
	 * 
	 * @param booTitle
	 * @return
	 */
	public List<Book> search(String  booTitle) {
		return new ArrayList<Book>(); // should be fetched from database
	}
	
	public boolean reserve(int bookID) {
		quantity --; // reduce quantity
		int status = 0; // status should be updated from database
		return(status == 0 ? true : false); //returns true if status from database is 0 and false otherwise
		
	}
	
	public boolean update(String abookTitle, String abookAuthor, int quantity) {
		
		this.bookTitle = abookTitle;
		this.bookAuthor = abookAuthor;
		
		int status = 0; // status should be updated from database
		return(status == 0 ? true : false); //returns true if status from database is 0 and false otherwise
		
	}

}
