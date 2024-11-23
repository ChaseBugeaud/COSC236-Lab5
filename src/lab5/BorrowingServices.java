package lab5;

import java.util.ArrayList;

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
	

}
