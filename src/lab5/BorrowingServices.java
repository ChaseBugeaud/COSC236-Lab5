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
	public void returnAllBorrowedBooks(Book book, ArrayList<Book> arrBooks) {
		Iterator<Book> bookIterator = arrBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 book = bookIterator.next();
		   	 book.setIsAvailable(true);
	    }
	    arrBooks.clear(); // clear array of borrowed books
	}


}
