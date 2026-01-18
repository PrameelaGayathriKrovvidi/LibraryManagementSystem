package com.LibraryManagementSystem;

public class BookNotAvailableException extends Exception{
	public BookNotAvailableException(String message) {
		super(message);
	}
}
