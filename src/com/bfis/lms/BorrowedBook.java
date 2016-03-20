/**
 * 
 */
package com.bfis.lms;

import java.time.LocalDate;

/**
 * @author Ivan
 *
 */
public class BorrowedBook extends Book{
	private LocalDate borrowedDate;
	private LocalDate dueDate;
	
	public BorrowedBook(String bookTitle, String bookAuthor, int quantity, LocalDate borrowedDate) {
		super( bookTitle,  bookAuthor, quantity);
		this.borrowedDate = borrowedDate;
		this.dueDate = borrowedDate.plusDays(10);
	}
	
	public BorrowedBook(String bookTitle, String bookAuthor, int quantity) {
		super(bookTitle,  bookAuthor, quantity);
		this.borrowedDate = LocalDate.now();
	}
	
	public boolean returnBook(int bookID) {
		quantity ++;
		int status = 0; // status should be updated from database
		return(status == 0 ? true : false); //returns true if status from database is 0 and false otherwise
	}
	
	/**
	 * 
	 * @param bookID
	 * @return
	 */
	public boolean renewBook(int bookID) {
		this.dueDate.plusDays(10); // extend due date by 10 days
		int status = 0; // status should be updated from database
		return(status == 0 ? true : false); //returns true if status from database is 0 and false otherwise
	}

}
