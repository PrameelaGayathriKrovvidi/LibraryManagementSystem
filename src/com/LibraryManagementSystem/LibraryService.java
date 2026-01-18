package com.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
	
	private Map<Integer, Book> books = new HashMap<>();
	private Map<Integer, User> users = new HashMap<>();

	
	public void addBook(Book book) {
		books.put(book.getId(), book);
	}
	
	public void addUser(User user) {
		users.put(user.getUserId(), user);
	}
	
	public void viewAvailableBooks() {
		books.values().stream()
		.filter(Book::isAvailable)
		.forEach(System.out::println);
	}
	
	public void reserveABook(int bookId, int userId) throws BookNotAvailableException {
		Book book = books.get(bookId);
		User user = users.get(userId);
		
		if(book == null || user == null) {
			throw new IllegalArgumentException("Invalid Book ID or User ID");
		}
		
		if(!book.isAvailable()) {
			throw new BookNotAvailableException("Book already reserved");
		}
		
		book.reserve(user);
		user.addBook(book);

	}
	
	public void returnABook(int bookId, int userId) {
		Book book = books.get(bookId);
		User user = users.get(userId);
		
		if(book == null || user == null) {
			throw new IllegalArgumentException("Invalid Book ID or User ID");
		}
		
		book.returnBook();
		user.removeBook(book);
	}
	
	public void viewReservedBooks(int userId) {
		User user = users.get(userId);
		if(user == null) {
			throw new IllegalArgumentException("Invalid User ID");
		}	
		
		user.getReservedBooks().forEach(System.out::println);
	}
	
	

}
