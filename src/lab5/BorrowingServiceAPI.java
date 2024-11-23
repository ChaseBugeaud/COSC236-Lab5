package lab5;

import java.util.ArrayList;

public interface BorrowingServiceAPI {
	public void borrowBook(Book book, ArrayList<Book> arrBooks);
	
	public void returnAllBorrowedBooks(Book book, ArrayList<Book> arrBooks);
	
	public void returnBook(Book book, ArrayList<Book> arrBooks); 
}