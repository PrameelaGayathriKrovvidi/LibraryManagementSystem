package com.LibraryManagementSystem;


import java.util.Scanner;

public class LibraryApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LibraryService service = new LibraryService();
		
		
		System.out.println("Number of Users: ");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Enter user id: ");
			int userId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter user name: ");
			String name = sc.nextLine();
			System.out.println("Enter user email: ");
			String email = sc.nextLine();
			service.addUser(new User(userId, name, email));
		}

		while(true) {
			System.out.println("1. Add Book: ");
			System.out.println("2. View Avaialble Books: ");
			System.out.println("3. Reserve a Book: ");
			System.out.println("4. Return a Book: ");
			System.out.println("5. View Reserved Books: ");
			System.out.println("6. Exit:");
			int choice = sc.nextInt();
			
		try {
			switch(choice) {
			case 1: 
				System.out.println("Number of Books: ");
				int m = sc.nextInt();
				
				for(int i=0;i<n;i++) {
					System.out.println("Enter Book id: ");
					int bookId = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Book title: ");
					String author = sc.nextLine();
					System.out.println("Enter Book author: ");
					String title = sc.nextLine();
					service.addBook(new Book(bookId,title,author));
					System.out.println("Book added Successfully!");
				}
				break;
				
			case 2: 
				service.viewAvailableBooks();
			break;
			case 3: 
				System.out.println("Enter User Id to reserve book:");
				int reserveUserId = sc.nextInt();
				System.out.println("Enter Book Id to reserve book: ");
				int reserveBookId = sc.nextInt();
				service.reserveABook(reserveBookId,reserveUserId);
				System.out.println("Book reserved successfully");
				break;
			case 4:
				System.out.println("Enter User Id to return book:");
				int returnUserId = sc.nextInt();
				System.out.println("Enter Book Id to return book: ");
				int returnBookId = sc.nextInt();
				service.returnABook(returnBookId, returnUserId);
				System.out.println("Book returned successfully");
				break;
			case 5:
				System.out.println("Enter user ID to view user reserved books:");
				int viewUserId = sc.nextInt();
				service.viewReservedBooks(viewUserId);
				break;
				
			case 6:
				System.out.println("Thankyou for using the library System.");
				sc.close();
				System.exit(0);
				}
			} catch(BookNotAvailableException e) {
				System.out.println("Error: " + e.getMessage());
			} catch(IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			} catch(Exception e) {
				System.out.println("Unexpected Error: " + e.getMessage());
			}
		}
		
	
	}
}
