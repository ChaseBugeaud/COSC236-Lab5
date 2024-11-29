package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class BorrowingServices implements BorrowingServiceAPI {
	
	
	@Override
	public void borrowBook(Book book, ArrayList<Book> arrBooks) {
		if (book != null && book.getIsAvailable() == true) {
			arrBooks.add(book);
			book.setIsAvailable(false);
		}
	}
	@Override
	public void returnBook(Book book, ArrayList<Book> arrBooks) {
		if (book != null) {
			arrBooks.remove(book);
			book.setIsAvailable(true);
		}
	}
	@Override
	public void returnAllBorrowedBooks(ArrayList<Book> borrowedBooks) {
		Book book = borrowedBooks.get(0);
		Iterator<Book> bookIterator = borrowedBooks.iterator();
		while(bookIterator.hasNext()) {
			book.setIsAvailable(true);
			book = bookIterator.next();
		}
		System.out.println("All books cleared");
		
	    borrowedBooks.clear();
		
	}


}
